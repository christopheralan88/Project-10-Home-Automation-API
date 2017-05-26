package com.cj.device;


import com.cj.control.Control;
import com.cj.core.BaseEntity;
import com.cj.room.Room;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Device extends BaseEntity{
    private String name;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Control> controls;

    protected Device() {
        super();
    }

    public Device(String name, Room room, List<Control> controls) {
        this();
        this.name = name;
        this.room = room;
        this.controls = controls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Control> getControls() {
        return controls;
    }

    public void setControls(List<Control> controls) {
        this.controls = controls;
    }
}
