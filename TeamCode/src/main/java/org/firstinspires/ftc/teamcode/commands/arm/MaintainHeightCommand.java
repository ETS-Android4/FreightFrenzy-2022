package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;

public class MaintainHeightCommand extends CommandBase {
    private ArmPIDSubsystem subsystem;
    private final Telemetry telemetry;

    public MaintainHeightCommand(ArmPIDSubsystem subsystem, Telemetry telemetry){
        this.subsystem = subsystem;
        this.telemetry = telemetry;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        subsystem.setMotorPosition(subsystem.getDesiredPosition());
        while (!subsystem.atPosition()) {
            subsystem.moveToPosition();
            telemetry.addData("Current Position: ", subsystem.currentPosition());
        }
        telemetry.addData("At Position: ", subsystem.atPosition());
        telemetry.update();
        subsystem.stopMotor();
    }
}
