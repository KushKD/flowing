package com.mis.education.Education.MIS.modules.cart;

import java.io.Serializable;

public class Summary implements Serializable {

    private String summaryHtml;
    private Double total;
    private Double tax;
    private Double price;

    private Integer items;

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public String getSummaryHtml() {
        return summaryHtml;
    }

    public void setSummaryHtml(String summaryHtml) {
        this.summaryHtml = summaryHtml;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "summaryHtml='" + summaryHtml + '\'' +
                ", total=" + total +
                ", tax=" + tax +
                ", price=" + price +
                ", items=" + items +
                '}';
    }
}
