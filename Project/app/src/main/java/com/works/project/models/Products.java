package com.works.project.models;

import java.util.List;

public class Products {
    private List<Product> products;
    private long total;
    private long skip;
    private long limit;

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> value) { this.products = value; }

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getSkip() { return skip; }
    public void setSkip(long value) { this.skip = value; }

    public long getLimit() { return limit; }
    public void setLimit(long value) { this.limit = value; }
}
