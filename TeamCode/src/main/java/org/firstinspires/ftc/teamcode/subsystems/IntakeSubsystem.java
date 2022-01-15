package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intake;

    public IntakeSubsystem(Motor intake) {
        this.intake = intake;
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