package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmExtendCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private double timeToMove;
    private final ElapsedTime time;
    private int level;

    public ArmExtendCommand(ArmSubsystem armSubsystem, ElapsedTime timer) {
        this.armSubsystem = armSubsystem;
        this.time = timer;
        level = 0;
    }

    @Override
    public void execute() {
        time.reset();
        if (level == 0) {
            armSubsystem.raise();
            timeToMove = 0.5;
            level++;
        } else if (level == 1) {
            armSubsystem.raise();
            timeToMove = 0.5;
            level++;
        } else if (level == 2) {
            armSubsystem.raise();
            timeToMove = 0.5;
            level++;
        } else if (level == 3) {
            armSubsystem.reduce();
            timeToMove = 1;
            level = 0;
        }
    }

    @Override
    public boolean isFinished() {
        return time.seconds() >= timeToMove || armSubsystem.getState();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}