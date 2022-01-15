package org.firstinspires.ftc.teamcode.commands.arm.test;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class LiftRaiseTestCommand extends CommandBase {
    private LiftSubsystem liftSubsystem;

    public LiftRaiseTestCommand(LiftSubsystem liftSubsystem) {
        this.liftSubsystem = liftSubsystem;
    }

    @Override
    public void execute() {
        liftSubsystem.motorUp();
    }

    @Override
    public void end(boolean interrupted) {
        liftSubsystem.motorStop();
    }
}