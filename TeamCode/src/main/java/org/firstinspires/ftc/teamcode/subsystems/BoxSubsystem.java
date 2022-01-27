package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class BoxSubsystem extends SubsystemBase {
    private final Servo servo;
    private boolean isActive;

    public BoxSubsystem(Servo servo) {
        this.servo = servo;
        reset();
    }

    public void activate() {
        servo.setPosition(0.8);
    }

    public void reset() {
        servo.setPosition(0);
    }

    public void movePos(){
        servo.setPosition(0.3);
    }

    public boolean isActive() {
        return isActive;
    }

    public void toggle() {
        isActive = !isActive;
    }
}
