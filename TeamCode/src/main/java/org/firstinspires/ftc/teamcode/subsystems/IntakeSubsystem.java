package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class IntakeSubsystem extends SubsystemBase {
    private final MotorGroup intake;

    public IntakeSubsystem(MotorGroup intake) {
        this.intake = intake;
        intake.setInverted(true);
    }

    public void in() {
        intake.set(1.0);
    }

    public void out() {
        intake.set(-1.0);
    }

    public void stop() {
        intake.stopMotor();
    }
}