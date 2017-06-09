package com.cj.device;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public class DeviceRepositoryTest {
    @Autowired
    private DeviceRepository devices;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAllReturnsDevices() throws Exception {
        //Act
        Page<Device> allDevices = devices.findAll(new PageRequest(1, 20));

        //Assert
        Assert.assertTrue(allDevices.getTotalElements() > 0);
    }

}