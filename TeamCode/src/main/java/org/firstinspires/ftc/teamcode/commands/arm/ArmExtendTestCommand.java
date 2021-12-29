package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

public class ArmExtendTestCommand extends CommandBase {
    private WristSubsystem armSubsystem;

    public ArmExtendTestCommand(WristSubsystem wristSubsystem) {
        this.armSubsystem = wristSubsystem;
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
