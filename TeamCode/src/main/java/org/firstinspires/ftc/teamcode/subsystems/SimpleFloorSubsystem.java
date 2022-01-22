package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class SimpleFloorSubsystem extends SubsystemBase {
    private SimpleServo servo;
    private boolean isActive;

    public SimpleFloorSubsystem(SimpleServo servo) {
        this.servo = servo;
    }

    public void activate() {
        servo.turnToAngle(180);
    }

    public void reset() {
        servo.turnToAngle(10);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
