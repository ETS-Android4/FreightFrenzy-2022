package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

public class ArmRetractTestCommand extends CommandBase {
    private WristSubsystem armSubsystem;

    public ArmRetractTestCommand(WristSubsystem wristSubsystem) {
        this.armSubsystem = wristSubsystem;
    }

    @Override
    public void execute() {
        if (!armSubsystem.getState())
            armSubsystem.reduce();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}
