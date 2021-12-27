package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intakeLeft;
    private final Motor intakeRight;

    public IntakeSubsystem(Motor intakeL, Motor intakeR){
        this.intakeLeft = intakeL;
        this.intakeRight = intakeR;

        this.intakeLeft.setInverted(false);
        this.intakeRight.setInverted(true);
    }

    public void in() {
        intakeLeft.set(1.0);
        intakeRight.set(1.0);
    }

    public void out() {
        intakeLeft.set(-1.0);
        intakeRight.set(-1.0);
    }

    public void stop() {
        intakeLeft.stopMotor();
        intakeRight.stopMotor();
    }
}