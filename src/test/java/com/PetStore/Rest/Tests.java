package com.PetStore.Rest;

import common.EndPoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Tests extends TestBase{

    @Epic(value = "Pet Store")
    @Feature(value = "Store")
    @Story(value = "Post")
    @Test(description = "POST запрос на создание записи")
    @Owner(value = "Дюжев Михаил")

    public void testPostWithJson() throws IOException {
        given().relaxedHTTPSValidation()
                .spec(requestSpecification).body(generateBody(EndPoint.STORE_POST_JSON_TEMPLATE))
                .when()
                .post(EndPoint.STORE_POST)
                .then().spec(checkResponse200(200, "placed")).log().all();
    }

    @Epic(value = "Pet Store")
    @Feature(value = "Store")
    @Story(value = "Post")
    @Test(description = "POST запрос на создание записи")
    @Owner(value = "Дюжев Михаил")

    public void testPostWithClass() throws IOException {
        StorePost post = new StorePost(1, 0, 0, "2019-02-13T19:44:21.435Z", "placed", false);
        given().relaxedHTTPSValidation()
                .spec(requestSpecification).body(post)
                .when()
                .post(EndPoint.STORE_POST)
                .then().spec(checkResponse200(200, "placed")).log().all();
    }

    @Epic(value = "Pet Store")
    @Feature(value = "Store")
    @Story(value = "GET")
    @Test(description = "GET запрос inventory")
    @Owner(value = "Дюжев Михаил")

    public void testGetInventory() throws IOException {
           given().relaxedHTTPSValidation()
                .spec(requestSpecification)
                .when()
                .get(EndPoint.GET_INVENTORY)
                .then().statusCode(200).log().all();
    }
}
