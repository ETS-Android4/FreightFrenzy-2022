package org.firstinspires.ftc.teamcode.commands.arm.test;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmExtendTestCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;

    public ArmExtendTestCommand(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
    }

    @Override
    public void execute() {
        armSubsystem.raise();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}
