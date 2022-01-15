package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;

public class FloorSubsystem extends SubsystemBase {
    private CRServo servo;

    public FloorSubsystem(CRServo servo){
        this.servo = servo;
    }

    public void activate(){
        servo.set(0.3);
    }

    public void reset(){
        servo.set(-0.3);
    }

    public void stop(){
        servo.stopMotor();
    }
}