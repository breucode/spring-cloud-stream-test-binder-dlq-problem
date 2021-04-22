package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinder;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import({TestChannelBinderConfiguration.class})
class DemoApplicationTests {

	@Autowired
	private InputDestination inputDestination;

	@Autowired
	private TestChannelBinder testChannelBinder;

	@Test
	void contextLoads() {
		inputDestination.send(MessageBuilder.withPayload("testMessage").build());

		assertNotNull(testChannelBinder.getLastError());
	}

}
