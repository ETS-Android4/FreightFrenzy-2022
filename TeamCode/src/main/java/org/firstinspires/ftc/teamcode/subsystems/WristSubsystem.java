package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class WristSubsystem extends SubsystemBase {
    private final Motor wristMotor;

    public WristSubsystem(Motor wrist) {
        this.wristMotor = wrist;
    }

    public void motorUp() {
        wristMotor.set(0.4);
    }

    public void motorDown() {
        wristMotor.set(-0.4);
    }

    public void motorStop() {
        wristMotor.stopMotor();
    }


}
