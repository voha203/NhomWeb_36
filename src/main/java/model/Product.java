package model;

public class Product {
    private int product_id;
    private String product_name;
    private String description;
    private double price;
    private int stock;
    private Image image;
    private String link;

        // Constructor có tham số
        public Product(int product_id, String product_name, String description, double price, int stock, Image image, String link) {
            this.product_id = product_id;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.stock = stock;
            this.image = image;
            this.link = link;
        }

        // Constructor mặc định
        public Product() {
        }

        // Getter và Setter cho các thuộc tính
        public int getProductId() {
            return product_id;
        }

        public void setProductId(int product_id) {
            this.product_id = product_id;
        }

        public String getProductName() {
            return product_name;
        }

        public void setProductName(String product_name) {
            this.product_name = product_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }
        public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
        // Phương thức toString để hiển thị thông tin sản phẩm
        @Override
        public String toString() {
            return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
                    + ", price=" + price + ", stock=" + stock + ", image=" + image +", link=" + link + "]";
        }

    public static void main(String[] args) {

    }
    }

