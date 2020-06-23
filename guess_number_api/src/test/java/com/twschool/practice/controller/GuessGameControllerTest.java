package com.twschool.practice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GuessGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_input_1234_and_result_4A0B_when_request_url_guessGame_with_param_input_1234() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/guessGame")
                .contentType(MediaType.APPLICATION_JSON)
                .param("input", "1 2 3 4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));
    }

    @Test
    public void should_return_isNewUser_true_and_userId_test_when_request_url_game_start_with_param_id_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game/start")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isNewUser").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test"));
    }

    @Test
    public void should_return_isNewUser_false_and_userId_test_when_request_url_game_start_with_param_id_test_twice() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game/start")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isNewUser").value("true"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test"));

        mockMvc.perform(MockMvcRequestBuilders.get("/game/start")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isNewUser").value("false"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test"));
    }

    @Test
    public void should_return_input_1234_and_userId_test_isExistUser_false_when_request_url_game_guess_with_param_input_1234_id_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .param("input", "1 2 3 4")
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isExistUser").value("false"));
    }

    @Test
    public void should_return_id_test_and_userId_test_isExistUser_false_when_request_url_game_guess_with_param_input_1234_id_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .param("input", "1 2 3 4")
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isExistUser").value("false"));
    }

    @Test
    public void should_return_user_isNotExist_when_request_url_getUser_with_param_id_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getUser")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").value("is not exist"));
    }
}
