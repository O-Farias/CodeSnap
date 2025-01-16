package com.codesnap.controller;

import com.codesnap.CodeSnapApplication; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(classes = CodeSnapApplication.class) 
@AutoConfigureMockMvc
public class QRCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGenerateQRCodeSuccessfully() throws Exception {
        String requestData = """
            {
                "data": "https://github.com",
                "width": 300,
                "height": 300
            }
        """;

        mockMvc.perform(post("/qrcode/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestData))
                .andExpect(status().isOk())
                .andExpect(content().contentType("image/png"));
    }

    @Test
    public void shouldReturnBadRequestWhenDataIsMissing() throws Exception {
        String requestData = """
            {
                "width": 300,
                "height": 300
            }
        """;

        mockMvc.perform(post("/qrcode/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestData))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequestWhenDimensionsAreInvalid() throws Exception {
        String requestData = """
            {
                "data": "https://github.com",
                "width": -100,
                "height": 300
            }
        """;

        mockMvc.perform(post("/qrcode/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestData))
                .andExpect(status().isBadRequest());
    }
}
