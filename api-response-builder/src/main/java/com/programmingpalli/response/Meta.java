package com.programmingpalli.response;

public class Meta {
    public long total_records;
    private int page;
    private int total_page;
    private int page_size;
    public Meta(long totalElements, int totalPages, int pageNumber, int pageSize) {
        this.total_records = totalElements;
        this.total_page = totalPages;
        this.page = pageNumber;
        this.page_size = pageSize;
    }


    public long getTotalElements() { return total_records; }
    public void setTotalElements(long totalElements) { this.total_records = totalElements; }
    public int getTotalPages() { return total_page; }
    public void setTotalPages(int totalPages) { this.total_page = totalPages; }
    public int getPageNumber() { return page; }
    public void setPageNumber(int pageNumber) { this.page_size = pageNumber; }
    public int getPageSize() { return page_size; }
    public void setPageSize(int pageSize) { this.page_size = pageSize; }
}
