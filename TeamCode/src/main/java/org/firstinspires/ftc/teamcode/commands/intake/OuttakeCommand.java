package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class OuttakeCommand extends CommandBase {

    private IntakeSubsystem intakeSubsystem;

    public OuttakeCommand(IntakeSubsystem intake) {
        this.intakeSubsystem = intake;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intakeSubsystem.out();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
}