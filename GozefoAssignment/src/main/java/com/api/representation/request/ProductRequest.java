package com.api.representation.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

/**
 * Created by chetan on 29/1/18.
 */
@JsonSnakeCase
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest {
    private String name;
    private String category;
    private String subcategory;
    private String type;
    private String material;
    private String brand;
    private String condition;
    private String softness;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal price;
    private String sortBy;
}
