package com.myschool.syllabushub.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TestClient {
    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (src, typeOfSrc, context) ->
                    new JsonPrimitive(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                            .format(src)))
            .create();

    public <T> T callApi(String url, Object requestBody, Class<T> outputKlass) {
        String userJson = gson.toJson(requestBody);

        MvcResult result = null;
        try {
            result = mockMvc.perform(MockMvcRequestBuilders
                            .post(url)
                            .content(userJson)
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            return gson.fromJson(
                    result.getResponse().getContentAsString(),
                    outputKlass
            );
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getApi(String url, Object requestBody, Class<T> outputKlass) {
        String userJson = gson.toJson(requestBody);

        MvcResult result = null;
        try {
            result = mockMvc.perform(MockMvcRequestBuilders
                            .get(url)
                            .content(userJson)
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            return gson.fromJson(
                    result.getResponse().getContentAsString(),
                    outputKlass
            );
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getApi(String url, String queryParam, Object value, Class<T> outputKlass) {
        MvcResult result = null;
        try {
            result = mockMvc.perform(MockMvcRequestBuilders
                            .get(url)
                            .param(queryParam, String.valueOf(value))
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            return gson.fromJson(
                    result.getResponse().getContentAsString(),
                    outputKlass
            );
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
