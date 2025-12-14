package com.programmingpalli.product_service.model;

public class ApiResponse<T> {
    private int status = 200;

    /** true for 2xx responses */
    private boolean success = true;

    /** Human readable message */
    private String message;

    /** Response payload (object / list / map / DTO) */
    private T data;

    /** Pagination or extra metadata (optional) */
    private Meta meta;

    public ApiResponse() {}

    /* ---------------- GETTERS & SETTERS ---------------- */

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.success = status >= 200 && status < 300;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
