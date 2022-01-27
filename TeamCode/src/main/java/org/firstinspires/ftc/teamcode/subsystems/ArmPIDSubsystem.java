package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.util.MotorPDController;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

public class ArmPIDSubsystem extends SubsystemBase {
    private MotorPDController armMotor;
    private RevTouchSensor limitSwitch;

    private int targetPosition;

    public ArmPIDSubsystem(MotorPDController armMotor, RevTouchSensor limit) {
        this.armMotor = armMotor;
        this.limitSwitch = limit;
        armMotor.setInverted(true);
        armMotor.setRunMode(MotorPDController.RunMode.PositionControl);
        armMotor.encoder.reset();
        armMotor.encoder.setDirection(MotorPDController.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(MotorPDController.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorPosition(int position){
        armMotor.setRunMode(MotorPDController.RunMode.PositionControl);
        armMotor.setTargetPosition(position);
        armMotor.setPositionCoefficient(3.5);
        armMotor.setPositionDerivativeCoefficient(1);
        armMotor.setPositionTolerance(0);
    }

    public void armResetPosition(){
        armMotor.setRunMode(MotorPDController.RunMode.RawPower);
        armMotor.set(-1.0);
    }

    public void moveToPosition(){
        armMotor.set(0.3);
    }

    public int getCurrentPosition() {
        return armMotor.getCurrentPosition();
    }

    public void stopMotor() {
        armMotor.stopMotor();
    }

    public int getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
    }

    public boolean getState() {
        return limitSwitch.isPressed();
    }
}
