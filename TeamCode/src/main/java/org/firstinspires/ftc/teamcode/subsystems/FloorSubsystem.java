package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class FloorSubsystem extends SubsystemBase {
    private SimpleServo servo;

    public FloorSubsystem(SimpleServo servo){
        this.servo = servo;
    }

    public void activate(){
        servo.rotateByAngle(30);
    }

    public void reset(){
        servo.rotateByAngle(-45);
    }

    public void stop(){
        servo.disable();
    }
}