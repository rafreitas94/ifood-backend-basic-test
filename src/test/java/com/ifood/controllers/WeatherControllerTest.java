package com.ifood.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import feign.FeignException;
import feign.Request;
import feign.Response;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations="classpath:test.properties")
class WeatherControllerTest {

    @Autowired
    private WeatherController weatherController;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void getWeatherController() {
        ReflectionTestUtils.setField(weatherController, "weatherAppId", "29ab646de7f6b5cee969c839c40990f1");

        given().
                param("city", "São Bernardo do Campo").
                when().
                get("/weather").
                then().
                statusCode(HttpStatus.OK.value());
    }

    @Test
    void getWeatherFallbackToCallNotPermittedException() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("Erro");
        CallNotPermittedException callNotPermittedException = CallNotPermittedException.createCallNotPermittedException(circuitBreaker);

        ResponseEntity<Map<String, Object>> mapResponseEntity = weatherController.weatherFallback(callNotPermittedException);

        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, mapResponseEntity.getStatusCode());
        Assertions.assertEquals(
                "CircuitBreaker 'Erro' is CLOSED and does not permit further calls",
                mapResponseEntity.getBody().get("message"));
    }

    @Test
    void getWeatherFallbackToFeignException() throws JsonProcessingException {
        FeignException feignException = FeignException.errorStatus(
                "Page Not Found",
                Response.builder()
                        .status(404)
                        .headers(new HashMap<>())
                        .reason("Not found")
                        .request(Request.create(Request.HttpMethod.GET, "http://localhost:8080", new HashMap<>(), "Error test".getBytes(), StandardCharsets.UTF_8, null)).build());

        ResponseEntity<JsonNode> jsonNodeResponseEntity = weatherController.weatherFallback((FeignException.FeignClientException) feignException);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, jsonNodeResponseEntity.getStatusCode());
    }
}