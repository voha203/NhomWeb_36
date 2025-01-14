package model;

public class Order {
    private int order_id;
    private int user_id;
    private String name;
    private int phone;
    private String address;
    private int total_amount;
    private String order_status;
    private String order_date;

    public Order(int order_id, int user_id, String name, int phone, String address, int total_amount, String order_status, String order_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.order_date = order_date;
    }

    public Order() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}