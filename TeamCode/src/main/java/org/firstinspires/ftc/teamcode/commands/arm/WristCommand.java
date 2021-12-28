package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

public class WristCommand extends CommandBase {
    private final WristSubsystem armSubsystem;
    private ElapsedTime time;
    private int level;

    public WristCommand(WristSubsystem armSubsystem, ElapsedTime timer) {
        this.armSubsystem = armSubsystem;
        this.time = timer;
        level = 0;
    }

    @Override
    public void execute() {
        if (level == 0) {
            while(time.seconds() < 5) {
                armSubsystem.raise();
            }
            level++;
        } else if (level == 1) {
            while(time.seconds() < 5) {
                armSubsystem.raise();
            }
            level++;
        } else if (level == 2) {
            while(time.seconds() < 5) {
                armSubsystem.raise();
            }
            level++;
        } else if (level == 3) {
            while(time.seconds() < 7) {
                armSubsystem.reduce();
            }
            level = 0;
        }
        time.reset();
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}