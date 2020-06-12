package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "mobilestation", schema = "db1", catalog = "")
public class MobilestationEntity {
    private int id;
    private double lastX;
    private double lastY;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "last_x")
    public double getLastX() {
        return lastX;
    }

    public void setLastX(double lastX) {
        this.lastX = lastX;
    }

    @Basic
    @Column(name = "last_y")
    public double getLastY() {
        return lastY;
    }

    public void setLastY(double lastY) {
        this.lastY = lastY;
    }
}
