package org.firstinspires.ftc.teamcode.commands.arm.test;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class LiftDropTestCommand extends CommandBase {
    private final LiftSubsystem liftSubsystem;

    public LiftDropTestCommand(LiftSubsystem liftSubsystem) {
        this.liftSubsystem = liftSubsystem;
    }

    @Override
    public void execute() {
        liftSubsystem.motorDown();
    }

    @Override
    public void end(boolean interrupted) {
        liftSubsystem.motorStop();
    }
}