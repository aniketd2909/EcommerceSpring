package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreCategoryResponseDTO {

    private String title;

    private String description;

    private String category;

}
