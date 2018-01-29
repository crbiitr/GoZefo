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
public class ErrorsResponse extends BaseResponse {
    public String message;
    public Integer httpStatus;

    public ErrorsResponse(String status, int statusCode, String message) {
        super(status, statusCode);
        this.message = message;
    }

    public ErrorsResponse(String status, int statusCode, String message, Integer httpStatus) {
        super(status, statusCode);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
