package com.programmingpalli.product_service.model;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    private ResponseBuilder() {

    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(String message, T data){
        return build(HttpStatus.OK, message, data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(String message,T data,HttpStatus status){
        return build(status, message, data);
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(
            String message,
            T data,
            Meta meta
    ) {
        return build(HttpStatus.OK, message, data);
    }

    /* ---------------- CUSTOM STATUS ---------------- */

    public static <T> ResponseEntity<ApiResponse<T>> status(
            HttpStatus status,
            String message,
            T data
    ) {
        return build(status, message, data);
    }

    /* ---------------- CORE BUILDER ---------------- */

    private static <T> ResponseEntity<ApiResponse<T>> build(
            HttpStatus status,
            String message,
            T data

    ) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(status.value());
        response.setSuccess(status.is2xxSuccessful());
        response.setMessage(message);
        response.setData(data);

        if (data instanceof Page<?> page) {
            response.setData((T) page.getContent());
            response.setMeta(
                    new Meta(
                            page.getTotalElements(),
                            page.getTotalPages(),
                            page.getNumber(),
                            page.getSize()
                    )
            );
        } else {
            response.setData((T) data);
        }

        return ResponseEntity.status(status).body(response);
    }
}
