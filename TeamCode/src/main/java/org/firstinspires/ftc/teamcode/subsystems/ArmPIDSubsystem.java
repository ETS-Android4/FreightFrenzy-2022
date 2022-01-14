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
        armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        armMotor.encoder.setDirection(Motor.Direction.REVERSE);
        armMotor.encoder.reset();
        armMotor.setInverted(false);
    }

    public void setMotorPosition(int position){
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setTargetPosition(position);
        armMotor.setPositionCoefficient(10);
    }

    public void moveToPosition() {
        armMotor.set(0.75);
    }

    public boolean atPosition() {
        return armMotor.atTargetPosition();
    }

    public int currentPosition(){
        return armMotor.getCurrentPosition();
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