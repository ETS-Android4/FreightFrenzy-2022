package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class LiftSubsystem extends SubsystemBase {

    private final Motor motor;

    public LiftSubsystem(Motor liftMotor) {
        motor = liftMotor;
    }

    public void motorUp() {
        motor.set(0.7);
    }

    public void motorDown() {
        motor.set(-0.4);
    }

    public void setPower(double power) {motor.set(power);}

    public void motorStop() {
        motor.stopMotor();
    }
}