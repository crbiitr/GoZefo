package com.api.representation.response;

import com.api.dao.models.SofasDAO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chetan on 29/1/18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSnakeCase
public class ProductResponse extends BaseResponse {
    public String message;
    public Integer httpStatus;
    public List<Sofa> data;

    public ProductResponse(String status, int statusCode, String message) {
        super(status, statusCode);
        this.message = message;
    }

    public ProductResponse(String status, int statusCode, String message, Integer httpStatus) {
        super(status, statusCode);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ProductResponse(String status, int statusCode, String message, Integer httpStatus, List<SofasDAO> list) {
        super(status, statusCode);
        this.message = message;
        this.httpStatus = httpStatus;

        List<Sofa> data = new LinkedList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            data.add(new Sofa((SofasDAO) iterator.next()));
        }
        this.data = data;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Sofa {
        private String name;
        private String category;
        private String subCategory;
        private String type;
        private String material;
        private String brand;
        private String condition;
        private String softness;
        private BigDecimal price;

        public Sofa(SofasDAO sofasDAO) {
            name = sofasDAO.getName();
            type = sofasDAO.getType();
            material = sofasDAO.getMaterial();
            brand = sofasDAO.getBrand();
            condition = sofasDAO.getCondition();
            softness = sofasDAO.getSoftness();
            price = sofasDAO.getPrice();
        }
    }
}
