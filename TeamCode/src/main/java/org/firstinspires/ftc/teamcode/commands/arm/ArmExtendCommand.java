package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

public class ArmExtendCommand extends CommandBase {
    private final WristSubsystem armSubsystem;
    private double timeToMove;
    private ElapsedTime time;
    private int level;

    public ArmExtendCommand(WristSubsystem armSubsystem, ElapsedTime timer) {
        this.armSubsystem = armSubsystem;
        this.time = timer;
        level = 0;
    }

    @Override
    public void execute() {
        time.reset();
        if (level == 0) {
            armSubsystem.raise();
            timeToMove = 5;
            level++;
        } else if (level == 1) {
            armSubsystem.raise();
            timeToMove = 5;
            level++;
        } else if (level == 2) {
            armSubsystem.raise();
            timeToMove = 5;
            level++;
        } else if (level == 3) {
            armSubsystem.reduce();
            timeToMove = 7;
            level = 0;
        }
    }

    @Override
    public boolean isFinished(){
        return time.seconds() >= timeToMove;
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}