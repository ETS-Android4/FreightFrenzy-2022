package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class LiftCommand extends CommandBase {

    private final LiftSubsystem liftSubsystem;
    private final ElapsedTime time;
    private int level = 0;
    private double timeToLift = 0.4;

    public LiftCommand(LiftSubsystem liftSubsystem, ElapsedTime timer) {
        this.liftSubsystem = liftSubsystem;
        time = timer;
    }

    @Override
    public void initialize() {
        time.reset();
        if (level == 0) {
            level++;
        } else if (level == 1) {
            liftSubsystem.motorUp();
            timeToLift = 0.4;
            level++;
        } else if (level == 2) {
            liftSubsystem.motorUp();
            timeToLift = 0.7;
            level++;
        } else {
            liftSubsystem.motorDown();
            timeToLift = 1.2;
            level = 0;
        }
    }

    @Override
    public boolean isFinished() {
        return time.seconds() >= timeToLift;
    }

    @Override
    public void end(boolean interrupted) {
        if (level != 2)
            liftSubsystem.motorStop();
    }
}