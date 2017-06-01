package com.cj.room;


import com.cj.core.BaseEntity;
import com.cj.device.Device;
import com.cj.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    private String name;
    private int area;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<User> administrators;

    protected Room() {
        super();
        devices = new ArrayList<>();
        administrators = new ArrayList<>();
    }

    public Room(String name, int area, List<Device> devices, List<User> admins) {
        this();
        this.name = name;
        this.area = area;
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

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void addAdministrator(User user) {
        this.administrators.add(user);
    }
}
