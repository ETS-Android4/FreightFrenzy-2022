package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class ArmPIDSubsystem extends SubsystemBase {
    private Motor armMotor;

    private int targetPosition;

    public ArmPIDSubsystem(Motor armMotor) {
        this.armMotor = armMotor;
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setInverted(true);
        armMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        armMotor.setPositionCoefficient(10);
    }

    public void moveTo(){
        armMotor.set(0.75);
    }

    public void moveBack(){
        armMotor.set(-0.75);
    }

    public int getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
        armMotor.setTargetDistance(this.targetPosition);
    }
}
