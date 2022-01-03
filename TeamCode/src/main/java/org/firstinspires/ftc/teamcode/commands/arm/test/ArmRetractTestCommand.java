package org.firstinspires.ftc.teamcode.commands.arm.test;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmRetractTestCommand extends CommandBase {
    private ArmSubsystem armSubsystem;

    public ArmRetractTestCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
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
