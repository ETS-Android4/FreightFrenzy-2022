package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

public class WristCommand extends CommandBase {
    private WristSubsystem wristSubsystem;
    private ElapsedTime time;
    private int level = 0;
    private double timeToLift = 0.4;

    public WristCommand(WristSubsystem wrist, ElapsedTime timer) {
        this.wristSubsystem = wrist;
        this.time = timer;
    }

    @Override
    public void initialize() {
        time.reset();
        if (level == 0) { //intake
            wristSubsystem.motorUp();
            timeToLift = 0.1;
            level++;
        } else if (level == 1) { //level 1
            wristSubsystem.motorDown();
            timeToLift = 0.2;
            level++;
        } else if (level == 2) {
            wristSubsystem.motorDown();
            timeToLift = 0.1;
            level++;
        } else { //return to straight up
            wristSubsystem.motorUp();
            timeToLift = 0.2;
            level = 0;
        }
    }
}
