package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.Timing;

public class WristSubsystem extends CommandBase {
    private final Motor armMotor;

    public WristSubsystem(Motor motor){
        this.armMotor = motor;
    }

    public void raise() {
        armMotor.set(1.0);
    }

    public void reduce() {
        armMotor.set(-1.0);
    }

    public void stop() {
        armMotor.stopMotor();
    }



}