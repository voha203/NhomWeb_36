package model;


public class Product {
    private int product_id;
    private String product_name;
    private double price;
    private String image_url;

        // Constructor có tham số
        public Product(int product_id, String product_name, double price, String image_url) {
            this.product_id = product_id;
            this.product_name = product_name;
            this.price = price;
            this.image_url = image_url;
        }
        // Constructor mặc định
        public Product() {
        }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    public static void main(String[] args) {
    }
    }

