package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

public class ArmSubsystem extends SubsystemBase {
    private final Motor armMotor;
    private final RevTouchSensor limitSwitch;
    private int level;

    public ArmSubsystem(Motor motor, RevTouchSensor revTouchSensor) {
        this.armMotor = motor;
        this.limitSwitch = revTouchSensor;
        level = 0;
        armMotor.setInverted(true);
    }

    public void raise() {
        armMotor.set(0.3);
    }

    public void reduce() {
        armMotor.set(-0.3);
    }

    public void setPower(double power) {
        armMotor.set(power);
    }

    public void stop() {
        armMotor.stopMotor();
    }

    public boolean getState() {
        return limitSwitch.isPressed();
    }

    public void slightUp() {
        armMotor.set(0.5);
    }

    public void slightDown() {
        armMotor.set(-0.5);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void resetLevel() {
        this.level = 0;
    }


}