package com.api.representation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.*;

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
public class CategoryResponse extends BaseResponse {
    public String message;
    public Integer httpStatus;
    public int id;
    public String name;

    public CategoryResponse(String status, int statusCode, String message) {
        super(status, statusCode);
        this.message = message;
    }

    public CategoryResponse(String status, int statusCode, String message, Integer httpStatus) {
        super(status, statusCode);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public CategoryResponse(String status, int statusCode, String message, Integer httpStatus, int id, String name) {
        super(status, statusCode);
        this.message = message;
        this.httpStatus = httpStatus;
        this.id = id;
        this.name= name;
    }
}
