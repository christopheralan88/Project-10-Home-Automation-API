package com.cj.control;


import com.cj.core.BaseEntity;
import com.cj.device.Device;
import com.cj.user.User;

import javax.persistence.*;

@Entity
public class Control extends BaseEntity{
    private String name;
    @ManyToOne
    private Device device;
    private int value;
    @OneToOne
    private User lastModifiedBy;

    protected Control() {
        super();
    }

    public Control(String name, Device device, int value, User lastModifiedBy) {
        this();
        this.name = name;
        this.device = device;
        this.value = value;
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
