package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

public class WristSubsystem extends CommandBase {
    private final Motor armMotor;
    private final RevTouchSensor limitSwitch;

    public WristSubsystem(Motor motor, RevTouchSensor revTouchSensor){
        this.armMotor = motor;
        this.limitSwitch = revTouchSensor;
    }

    public void raise() {
        armMotor.set(1.0);
    }

    public void reduce() {
        armMotor.set(-1.0);
    }

    public void stop() {
        armMotor.stopMotor();
    }

    public boolean getState() { return limitSwitch.isPressed(); }



}