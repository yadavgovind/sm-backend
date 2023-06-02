//package com.sm.user;
//
//import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
//import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
//import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
//import com.sm.user.handler.LambdaHandler;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//
//@SpringBootTest
//class SmUserApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
////	@Test
////	void whenTheUsersPathIsInvokedViaLambda_thenShouldReturnAList() throws IOException {
////		LambdaHandler lambdaHandler = new LambdaHandler();
////		AwsProxyRequest req = new AwsProxyRequestBuilder("/api/v1/users", "GET").build();
////		AwsProxyResponse resp = lambdaHandler.handleRequest(req,null);
////		Assertions.assertNotNull(resp.getBody());
////		Assertions.assertEquals(200, resp.getStatusCode());
////	}
//
//}
