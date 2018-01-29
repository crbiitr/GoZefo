package com.api.representation.response;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by chetan on 29/1/18.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSnakeCase
public class BaseResponse {
    protected String status;
    protected int statusCode;
}
