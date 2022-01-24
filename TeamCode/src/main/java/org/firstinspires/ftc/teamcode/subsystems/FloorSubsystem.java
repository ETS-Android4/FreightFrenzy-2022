package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class FloorSubsystem extends SubsystemBase {
    private final Servo servo;
    private boolean isActive;

    public FloorSubsystem(Servo servo) {
        this.servo = servo;
    }

    public void activate() {
        servo.setPosition(0.8);
    }

    public void reset() {
        servo.setPosition(0.1);
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggle() {
        isActive = !isActive;
    }
}
