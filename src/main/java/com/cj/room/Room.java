package com.cj.room;


import com.cj.core.BaseEntity;
import com.cj.device.Device;
import com.cj.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    private String name;
    private int area;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Device> devices;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<User> administrators;

    protected Room() {
        super();
    }

    public Room(String name, int area, List<Device> devices, List<User> admins) {
        this();
        this.name = name;
        this.area = area;
        this.devices = devices;
        this.administrators = admins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<User> administrators) {
        this.administrators = administrators;
    }
}
