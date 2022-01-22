package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class SimpleFloorSubsystem extends SubsystemBase {
    private SimpleServo servo;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive;

    public SimpleFloorSubsystem(SimpleServo servo) {
        this.servo = servo;
    }

    public void activate() {
        servo.turnToAngle(180);
    }

    public void reset() {
        servo.turnToAngle(0);
    }


}
