package com.programmingpalli.product_service.model;

import org.springframework.data.domain.Page;

public class Meta {
    public long total_records;
    public int page;
    public int total_page;
    public int limit;

    public Meta(long total_records,int total_page, int page, int limit) {
        this.total_records = total_records;
        this.total_page = total_page;
        this.page = page;
        this.limit = limit;
    }
}
