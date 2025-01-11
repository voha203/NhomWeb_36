package model;

public class Image {
    private int image_id;
    private int product_id;
    private String link;

    public Image(int image_id, int product_id, String link) {
        this.image_id = image_id;
        this.product_id = product_id;
        this.link = link;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
