package com.rshah.controller;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rshah.entity.Feed;
import com.rshah.entity.User;
import com.rshah.service.FeedService;
import com.rshah.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FeedController.class)
public class FeedControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	FeedService feedService;
	@MockBean
	UserService userService;

	Feed feed;
	Optional<User> user;
	List<Feed> feedList;
	String userEmail = "bob@email.com";
	Long currentMillisec = Instant.now().toEpochMilli();

	@Before
	public void setup() {

		this.user = Optional.of(new User(1L, "bob@email.com", "bob", null));
		this.feed = new Feed(1L, "Test message feed", this.user.get(), new Date(currentMillisec));
		this.feedList = Arrays.asList(this.feed);
		Mockito.when(userService.getUserByEmail(Mockito.anyString())).thenReturn(this.user);
	}

	@Test
	public void createFeed() throws Exception {
		// JSON data that need to be posted
		String feedData = "{\"message\":\"Test message feed\",\"user\":{\"userId\":1,\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null},\"createdOn\":"
				+ currentMillisec + "}";
		// When save method is invoked, let mockito return the feed object
		Mockito.when(feedService.save(Mockito.any(Feed.class))).thenReturn(this.feed);
		// expected will be json object with id in it
		String expected = "{\"feedId\":1,\"message\":\"Test message feed\",\"user\":{\"userId\":1,\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null},\"createdOn\":"
				+ currentMillisec + "}";
		// In case of post provide contentType and content
		RequestBuilder requestBld = MockMvcRequestBuilders.post("/feed").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).header("user", this.userEmail).content(feedData);
		MvcResult result = mockMvc.perform(requestBld).andReturn();

		assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
		assertEquals(expected, result.getResponse().getContentAsString());

	}

	@Test
	public void getFeeds() throws Exception {

		Mockito.when(feedService.findFeedsForLoggedInUser(Mockito.any(User.class))).thenReturn(this.feedList);

		String expected = "[{\"feedId\":1,\"message\":\"Test message feed\",\"user\":{\"userId\":1,\"email\":\"bob@email.com\",\"firstName\":\"bob\",\"lastName\":null},\"createdOn\":"
				+ currentMillisec + "}]";

		RequestBuilder requestBld = MockMvcRequestBuilders.get("/feed").header("user", this.userEmail).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBld).andReturn();

		assertEquals(expected, result.getResponse().getContentAsString());
	}

}
