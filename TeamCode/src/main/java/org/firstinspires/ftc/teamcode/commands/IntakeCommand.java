package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private IntakeSubsystem intake;

    public IntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intake = intakeSubsystem;addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intake.in();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}