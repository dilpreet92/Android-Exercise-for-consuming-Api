package com.test.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by vinsol on 4/6/15.
 */
public class ApiClient {
    private static final String BASE_URL = "http://staging.foodwheelsupply.com/api/v1";
    private static ApiClient apiClient;

    private ApiService apiService;

    public static ApiClient getInstance() {
        if(apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public ApiClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .setClient(new OkClient())
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
