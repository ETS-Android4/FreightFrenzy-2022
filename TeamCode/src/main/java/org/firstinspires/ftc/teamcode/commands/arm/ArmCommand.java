package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;

public class ArmCommand extends CommandBase {
    private final ArmPIDSubsystem subsystem;
    private int level;
    private final Telemetry telemetry;

    public ArmCommand(ArmPIDSubsystem subsystem, Telemetry telemetry) {
        this.subsystem = subsystem;
        level = 0;
        this.telemetry = telemetry;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.moveToPosition(2);
////        if (level == 0) {
//            subsystem.moveToPosition(0.5);
//            level++;
//            telemetry.addData("Help", level);
////        } else if (level == 1) {
//            subsystem.moveToPosition(1);
//            level++;
//            telemetry.addData("Help", level);
////        } else if (level == 2) {
//            subsystem.setGoal(10);
//            level = 0;
//            telemetry.addData("Help", level);
//        }
    }

    @Override
    public boolean isFinished(){
        return subsystem.atPosition();
    }
}