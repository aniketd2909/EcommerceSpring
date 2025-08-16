package org.example.ecommercespring.configuration;

import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }

}
