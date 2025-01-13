package model;

public class Address {
    private int adddress_id;
    private int user_id;
    private String street_address;
    private String ward;
    private String district;
    private String city;
    private String created_at;
    private String updated_at;

    public Address(int adddress_id, int user_id, String street_address, String ward, String district, String city, String created_at, String updated_at) {
        this.adddress_id = adddress_id;
        this.user_id = user_id;
        this.street_address = street_address;
        this.ward = ward;
        this.district = district;
        this.city = city;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getAdddress_id() {
        return adddress_id;
    }

    public void setAdddress_id(int adddress_id) {
        this.adddress_id = adddress_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
