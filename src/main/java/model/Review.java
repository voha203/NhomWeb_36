package model;

public class Review {
    private int review_id;
    private int user_id;
    private String review_name;
    private String content;
    private String image;
    private String review_date;

    public Review(int review_id, int user_id, String review_name, String content, String image, String review_date) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.review_name = review_name;
        this.content = content;
        this.image = image;
        this.review_date = review_date;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }
}
