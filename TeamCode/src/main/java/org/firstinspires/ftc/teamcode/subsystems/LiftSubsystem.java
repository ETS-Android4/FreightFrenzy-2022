package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class LiftSubsystem extends SubsystemBase {

    private final MotorGroup liftMotors;

    public LiftSubsystem(Motor liftMotorL, Motor liftMotorR) {
        this.liftMotors = new MotorGroup(liftMotorL, liftMotorR);
        liftMotors.setInverted(true);
    }

    public void motorUp() {
        liftMotors.set(0.5);
    }

    public void motorDown() {
        liftMotors.set(-0.3);
    }

    public void setPower(double power) {
        liftMotors.set(power);
    }

    public void motorStop() {
        liftMotors.stopMotor();
    }
}