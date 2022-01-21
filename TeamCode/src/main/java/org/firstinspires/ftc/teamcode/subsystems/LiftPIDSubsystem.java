package org.firstinspires.ftc.teamcode.subsystems;

/*
 * once again, thx 21864
 * might need to change this to match arm pid
 */

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class LiftPIDSubsystem extends SubsystemBase {
    public final MotorGroup liftMotors;
    private int desiredPosition;

    public LiftPIDSubsystem(Motor liftMotorL, Motor liftMotorR) {
        liftMotors = new MotorGroup(liftMotorL, liftMotorR);
        liftMotors.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        liftMotors.encoder.setDirection(Motor.Direction.REVERSE);
        liftMotors.encoder.reset();
        liftMotorL.setInverted(false);
    }

    public void setMotorPosition(int position) {
        liftMotors.setRunMode(Motor.RunMode.PositionControl);
        liftMotors.setTargetPosition(position);
        liftMotors.setPositionCoefficient(10);
    }

    public void moveToPosition() {
        liftMotors.set(0.25);
    }

    public boolean atPosition() {
        return liftMotors.atTargetPosition();
    }

    public int currentPosition() {
        return liftMotors.getCurrentPosition();
    }

    public void stopMotor() {
        liftMotors.stopMotor();
    }

    public int getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(int desiredPosition) {
        this.desiredPosition = desiredPosition;
    }
}