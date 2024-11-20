
package com.example.userAuthentification;



import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;

import org.springframework.boot.test.context.SpringBootTest;
import com.example.userAuthentification.entity.User;
import com.example.userAuthentification.service.*;
import com.example.userAuthentification.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@EnableAutoConfiguration(exclude = {EurekaClientAutoConfiguration.class})

@ExtendWith(MockitoExtension.class)
class UserAuthentificationApplicationTests {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private JwtTokenProvider jwtTokenProvider;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSave() {
		// Arrange
		User user = new User();
		user.setUsername("testusers");
		when(jwtTokenProvider.generateToken("testusers")).thenReturn("mockedToken");

		// Act
		String token = userService.save(user);

		// Assert
		verify(userRepository, times(1)).save(user);
		verify(jwtTokenProvider, times(1)).generateToken("testusers");
		assertEquals("mockedToken", token);
	}

	@Test
	void testGenerateToken() {
		// Arrange
		String username = "testusers";
		when(jwtTokenProvider.generateToken(username)).thenReturn("mockedToken");

		// Act
		String token = userService.generateToken(username);

		// Assert
		verify(jwtTokenProvider, times(1)).generateToken(username);
		assertEquals("mockedToken", token);
	}

	@Test
	void testValidateToken() {
		// Arrange
		String token = "mockedToken";

		// Act
		userService.validateToken(token);

		// Assert
		verify(jwtTokenProvider, times(1)).validateToken(token);
	}
}
