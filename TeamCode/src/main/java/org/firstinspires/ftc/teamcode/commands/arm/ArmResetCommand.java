package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;

public class ArmResetCommand extends CommandBase {
    private final ArmPIDSubsystem subsystem;
    private Telemetry telemetry;
    private int level;

    public ArmResetCommand(ArmPIDSubsystem subsystem, Telemetry telemetry) {
        level = 0;
        this.subsystem = subsystem;
        this.telemetry = telemetry;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.setTargetPosition(0);
        subsystem.setMotorPosition(0);
        subsystem.moveToPosition();
        telemetry.addData("Current Position: ", subsystem.getCurrentPosition());
        telemetry.update();
    }

    @Override
    public boolean isFinished() {
        return subsystem.getCurrentPosition() == subsystem.getTargetPosition() || subsystem.getState();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
    }
}
