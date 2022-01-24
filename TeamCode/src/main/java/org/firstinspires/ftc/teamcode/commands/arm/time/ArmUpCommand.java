package org.firstinspires.ftc.teamcode.commands.arm.time;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmUpCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private final ElapsedTime timer;
    private double timeToLift;

    public ArmUpCommand(ArmSubsystem armSubsystem, ElapsedTime timer) {
        this.armSubsystem = armSubsystem;
        this.timer = timer;

        addRequirements(this.armSubsystem);
    }

    @Override
    public void initialize() {
        this.timer.reset();
        if (armSubsystem.getLevel() == 0) {
            armSubsystem.raise();
            timeToLift = 0.2;
        } else if (armSubsystem.getLevel() == 1) {
            armSubsystem.raise();
            timeToLift = 0.2;
        } else if (armSubsystem.getLevel() == 2) {
            armSubsystem.raise();
            timeToLift = 0.2;
        }
    }

    @Override
    public boolean isFinished() {
        return this.timer.seconds() >= timeToLift;
    }

    @Override
    public void end(boolean interrupted) {
        if (this.armSubsystem.getLevel() != 3) {
            this.armSubsystem.stop();
            armSubsystem.setLevel(armSubsystem.getLevel() + 1);
        }
    }
}
