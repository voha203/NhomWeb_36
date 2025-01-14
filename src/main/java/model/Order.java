package model;

public class Order {
    private int order_id;
    private int user_id;
    private int total_amount;
    private String status;
    private String order_date;

    public Order(int order_id, int user_id, int total_amount, String status, String order_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.total_amount = total_amount;
        this.status = status;
        this.order_date = order_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}