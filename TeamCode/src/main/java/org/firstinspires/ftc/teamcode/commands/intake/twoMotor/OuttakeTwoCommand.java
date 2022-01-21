package org.firstinspires.ftc.teamcode.commands.intake.twoMotor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TwoMotorIntakeSubsystem;

public class OuttakeTwoCommand extends CommandBase {
    private final TwoMotorIntakeSubsystem intakeSubsystem;

    public OuttakeTwoCommand(TwoMotorIntakeSubsystem intake) {
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
