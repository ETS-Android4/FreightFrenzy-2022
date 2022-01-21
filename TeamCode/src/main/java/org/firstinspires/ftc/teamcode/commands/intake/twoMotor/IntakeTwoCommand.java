package org.firstinspires.ftc.teamcode.commands.intake.twoMotor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TwoMotorIntakeSubsystem;

public class IntakeTwoCommand extends CommandBase {
    private final TwoMotorIntakeSubsystem intakeSubsystem;

    public IntakeTwoCommand(TwoMotorIntakeSubsystem intake) {
        this.intakeSubsystem = intake;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        intakeSubsystem.in();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
}