package com.tugrulbo.retrofitv2.RestApi;

import com.tugrulbo.retrofitv2.RestApi.*;


public class BaseManager {
    protected RestApi getRestApiClient(){
        RestAPIClient restAPIClient = new RestAPIClient(BaseUrl.site_url);
        return restAPIClient.getRestApi();
    }
}