package org.firstinspires.ftc.teamcode.subsystems;

/*
 * once again, thx 21864
 * might need to change this to match arm pid
 */

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class ArmPIDSubsystem extends SubsystemBase {
    private final Motor armMotor;
    private int desiredPosition;

    public ArmPIDSubsystem(Motor motor) {
        this.armMotor = motor;
        armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        armMotor.encoder.setDirection(Motor.Direction.REVERSE);
        armMotor.setInverted(true);
    }

    public void moveToPosition(int position) {
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setTargetPosition(position);
        armMotor.setPositionCoefficient(3);
        armMotor.set(0.75);
    }

    public boolean atPosition() {
        return armMotor.atTargetPosition();
    }

    public void stopMotor() {
        armMotor.stopMotor();
    }

    public int getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(int desiredPosition) {
        this.desiredPosition = desiredPosition;
    }
}