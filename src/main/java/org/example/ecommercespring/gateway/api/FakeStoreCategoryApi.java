package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

@Component
public interface FakeStoreCategoryApi {

    @GET("products")
    Call<List<FakeStoreCategoryResponseDTO>> getAllFakeCategories() throws IOException;

}
