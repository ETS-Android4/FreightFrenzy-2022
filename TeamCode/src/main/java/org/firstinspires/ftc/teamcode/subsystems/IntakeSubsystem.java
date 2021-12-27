package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intakeMotor;

    public IntakeSubsystem(Motor intakeL){
        this.intakeMotor = intakeL;

        this.intakeMotor.setInverted(false);
    }

    public void in() {
        intakeMotor.set(1.0);
    }

    public void out() {
        intakeMotor.set(-1.0);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}