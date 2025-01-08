package model;

public class Image {
    private int image_id;
    private String image_url;

    public Image(int image_id, String image_url) {
        this.image_id = image_id;
        this.image_url = image_url;
    }

    public int getImageId() {
        return image_id;
    }

    public void setImageId(int image_id) {
        this.image_id = image_id;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

}
