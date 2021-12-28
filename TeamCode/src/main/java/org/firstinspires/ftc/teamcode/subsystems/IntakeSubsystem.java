package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intakeL, intakeR;

    public IntakeSubsystem(Motor intakeL, Motor intakeR){
        this.intakeL = intakeL;
        this.intakeR = intakeR;
    }

    public void in() {
        intakeL.set(1.0);
        intakeR.set(-1.0);
    }

    public void out() {
        intakeL.set(-1.0);
        intakeR.set(1.0);
    }

    public void stop() {
        intakeL.stopMotor();
        intakeR.stopMotor();
    }
}