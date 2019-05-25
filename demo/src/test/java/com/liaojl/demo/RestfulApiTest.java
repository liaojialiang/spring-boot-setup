package com.liaojl.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liaojl
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class RestfulApiTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    protected String doGet(String requestMapping, MultiValueMap<String, String> params, Object... pathVariables) throws Exception {
        if (params == null)
            params = new LinkedMultiValueMap<>();
        return mockMvc.perform(get(requestMapping, pathVariables)
                .params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    protected String doPost(String requestMapping, Object reqeustBody, Object... pathVariables) throws Exception {
        return mockMvc.perform(post(requestMapping, pathVariables)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(reqeustBody))
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    protected String doPut(String reqeustMapping, Object requestBody, Object... pathVariables) throws Exception {
        return mockMvc.perform(put(reqeustMapping, pathVariables)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(requestBody))
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    protected String doDelete(String requestMapping, MultiValueMap<String, String> params, Object... pathVariables) throws Exception {
        if (params == null)
            params = new LinkedMultiValueMap<>();
        return mockMvc.perform(delete(requestMapping, pathVariables)
                .params(params))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
