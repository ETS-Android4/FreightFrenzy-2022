package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.LiftPIDSubsystem;

public class ArmCommand extends CommandBase {
    private final LiftPIDSubsystem subsystem;
    private final Telemetry telemetry;
    private int level;

    public ArmCommand(LiftPIDSubsystem subsystem, Telemetry telemetry) {
        level = 0;
        this.subsystem = subsystem;
        this.telemetry = telemetry;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        if(level == 0) {
            subsystem.setMotorPosition(200);
            subsystem.moveToPosition();
            subsystem.setDesiredPosition(200);
            level++;
        } else if (level == 1){
            subsystem.setMotorPosition(250);
            subsystem.moveToPosition();
            subsystem.setDesiredPosition(250);
            level++;
        } else {
            subsystem.setMotorPosition(300);
            subsystem.moveToPosition();
            subsystem.setDesiredPosition(300);
            level = 0;
        }
    }

    @Override
    public boolean isFinished(){
        return subsystem.atPosition();
    }

    @Override
    public void end(boolean interrupted){
        subsystem.stopMotor();
    }
}