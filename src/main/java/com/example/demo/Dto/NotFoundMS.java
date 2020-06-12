package com.example.demo.Dto;

public class NotFoundMS {

    private Integer mobileId;
    private float x;
    private float y;
    private float error_radius;
    private Integer error_code;
    private String error_description;

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getError_radius() {
        return error_radius;
    }

    public void setError_radius(float error_radius) {
        this.error_radius = error_radius;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
}
