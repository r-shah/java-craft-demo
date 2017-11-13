package com.rshah.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rshah.entity.User;
import com.rshah.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    User user;
    List<User> userList;

    @Before
    public void setup() {
        this.user = new User(1L, "bob@email.com", "bob", null);
        this.userList = Arrays.asList(user);
    }

    @Test
    public void createUser() throws Exception {
        /*
         *  JSON data that need to be posted
         */
        String feedData = "{\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null}";
        // When save method is invoked, let mockito return the user object
        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(
                this.user);
        /*
         *  expected will be json object with id in it
         */
        String expected = "{\"userId\":1,\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null}";
        /*
         *  In case of post provide contentType and content
         */
        RequestBuilder requestBld = MockMvcRequestBuilders.post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(feedData);
        MvcResult result = mockMvc.perform(requestBld).andReturn();

        assertEquals(HttpStatus.CREATED.value(), result.getResponse()
                .getStatus());
        assertEquals(expected, result.getResponse().getContentAsString());

    }
    
    @Test
    public void getUsers() throws Exception {

        Mockito.when(userService.findAll()).thenReturn(this.userList);

        String expected = "[{\"userId\":1,\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null}]";

        RequestBuilder requestBld = MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBld).andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    
}
