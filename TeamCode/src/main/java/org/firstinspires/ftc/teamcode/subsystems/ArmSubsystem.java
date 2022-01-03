package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

public class ArmSubsystem extends SubsystemBase {
    private final Motor armMotor;
    private final RevTouchSensor limitSwitch;

    public ArmSubsystem(Motor motor, RevTouchSensor revTouchSensor){
        this.armMotor = motor;
        this.limitSwitch = revTouchSensor;
    }

    public void raise() {
        armMotor.set(1.0);
    }

    public void reduce() {
        armMotor.set(-1.0);
    }

    public void setPower(double power) {armMotor.set(power);}

    public void stop() {
        armMotor.stopMotor();
    }

    public boolean getState() { return limitSwitch.isPressed(); }



}