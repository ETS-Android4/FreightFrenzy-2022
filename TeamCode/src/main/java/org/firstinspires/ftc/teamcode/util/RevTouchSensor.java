package org.firstinspires.ftc.teamcode.util;

import android.text.method.Touch;

import com.arcrobotics.ftclib.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class RevTouchSensor implements TouchSensor, HardwareDevice {
    private DigitalChannel touchSensor;

    public RevTouchSensor(HardwareMap hardwareMap, String name) {
        this.touchSensor = hardwareMap.get(DigitalChannel.class, name);
    }

    @Override
    public double getValue() {
        return touchSensor.getState() ? 1 : 0;
    }

    @Override
    public boolean isPressed() {
        return touchSensor.getState();
    }

    @Override
    public void disable() {
        touchSensor.close();
    }


    @Override
    public String getDeviceType() {
        return "Touch Sensor";
    }

    @Override
    public Manufacturer getManufacturer() {
        return Manufacturer.Other;
    }

    @Override
    public String getDeviceName() {
        return "pee";
    }

    @Override
    public String getConnectionInfo() {
        return "africa";
    }

    @Override
    public int getVersion() {
        return 69;
    }

    @Override
    public void resetDeviceConfigurationForOpMode() {

    }

    @Override
    public void close() {
        touchSensor.close();
    }
}
