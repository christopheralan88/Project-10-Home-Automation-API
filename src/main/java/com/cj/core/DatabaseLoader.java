package com.cj.core;


import com.cj.control.Control;
import com.cj.control.ControlRepository;
import com.cj.device.Device;
import com.cj.device.DeviceRepository;
import com.cj.room.Room;
import com.cj.room.RoomRepository;
import com.cj.user.User;
import com.cj.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final UserRepository users;
    private final RoomRepository rooms;
    private final DeviceRepository devices;
    private final ControlRepository controls;

    //injects whatever class we have implementing the UserRepository interface
    @Autowired
    public DatabaseLoader(UserRepository users, RoomRepository rooms, DeviceRepository devices, ControlRepository controls) {
        this.users = users;
        this.rooms = rooms;
        this.devices = devices;
        this.controls = controls;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> userList = Arrays.asList(
                new User("admin", new String[] {"ROLE_USER", "ROLE_ADMIN"}, "abc"),
                new User("user", new String[] {"ROLE_USER"}, "def")
        );
        users.save(userList);

        List<Room> roomList = new ArrayList<>();
        List<Device> deviceList  = new ArrayList<>();
        List<Control> controlList = new ArrayList<>();

        IntStream.range(1, 100)
                .forEach(i -> {
                    Room room = new Room("room" + i, 10, null, null);
                    Device device = new Device("device" + i, room);
                    Control control = new Control("control + i", device, 0, userList.get(0));

                    room.addDevice(device);
                    room.addAdministrator(userList.get(0));
                    device.addControls(control);

                    roomList.add(room);
                    deviceList.add(device);
                    controlList.add(control);
                });

        rooms.save(roomList);
        devices.save(deviceList);
        controls.save(controlList);
    }
}
