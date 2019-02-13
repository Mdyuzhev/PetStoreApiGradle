package com.PetStore.Rest;

import common.EndPoint;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.equalTo;


@Listeners(LogListener.class)
public class TestBase {
    RequestSpecification requestSpecification;
    RequestSpecBuilder build;
    String templateBody;
    String templateXml;

    @BeforeTest
    public void requestSpec() {
        build = new RequestSpecBuilder();
        build.setBaseUri(EndPoint.BASE_URL);
        build.setContentType(ContentType.JSON);
        requestSpecification = build.build();
    }
    @Step
    public String generateString(String message) throws IOException {
        String x = new String(Files.readAllBytes(Paths.get(message)));
        return x;
    }


    @Step(value = "Создание сообщения")

    public String generateBody(String pathTemp) throws IOException {
        templateBody = new String(Files.readAllBytes(Paths.get(pathTemp)));
        JSONObject requestBody = new JSONObject(templateBody);
        return requestBody.toString();
    }

    @Step(value = "Полученный StatusCode: {StatusCode}, статус сообщения: {status}, описание полученной ошибки: {details}")
    public ResponseSpecification checkResponse200(int StatusCode, String status) {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(StatusCode)
                //.expectBody("id", equalTo(templateBody.getString("id")))
                .expectBody("status", equalTo(status))
                //.expectBody("details", equalTo(details))
                .build();
        return responseSpec;
    }
}