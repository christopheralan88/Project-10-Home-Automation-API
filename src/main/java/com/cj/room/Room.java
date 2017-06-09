package com.cj.room;


import com.cj.core.BaseEntity;
import com.cj.device.Device;
import com.cj.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull
    @Max(value = 1000, message = "The room's area can't be greater than 1000 sq feet")
    private int area;
    @NotNull
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;
    @NotNull
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
