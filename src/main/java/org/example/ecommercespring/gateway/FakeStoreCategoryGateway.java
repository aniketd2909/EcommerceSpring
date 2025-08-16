package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<FakeStoreCategoryResponseDTO> response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        if (response == null) {
            throw new IOException("Error while fetching all categories");
        }
        return response.stream()
                .map(dto -> CategoryDTO.builder()
                        .name(dto.getTitle()).build())
                .toList();
    }
}
