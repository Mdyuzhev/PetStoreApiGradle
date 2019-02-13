package common;

public interface EndPoint {
    String BASE_URL = "https://petstore.swagger.io";
    String STORE_POST = "/v2/store/order";

    String STORE_POST_JSON_TEMPLATE = "C:\\Autostest\\PetStoreGradle\\src\\test\\resources\\StorePost.json";
    String GET_INVENTORY = "/v2/store/inventory";
}
