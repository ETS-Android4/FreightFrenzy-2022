package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmDownCommand extends CommandBase {
    private ArmSubsystem armSubsystem;
    private ElapsedTime timer;
    private double timeToLift;

    public ArmDownCommand(ArmSubsystem armSubsystem, ElapsedTime timer) {
        this.armSubsystem = armSubsystem;
        this.timer = timer;

        addRequirements(this.armSubsystem);
    }

    @Override
    public void initialize() {
        this.timer.reset();
        if (armSubsystem.getLevel() == 0) {

        } else if (armSubsystem.getLevel() == 1) {
            armSubsystem.reduce();
            this.timeToLift = 0.2;
        } else if (armSubsystem.getLevel() == 2) {
            armSubsystem.reduce();
            this.timeToLift = 0.45;
        } else if (armSubsystem.getLevel() == 3) {
            armSubsystem.reduce();
            this.timeToLift = 0.8;
        }
    }

    @Override
    public boolean isFinished() {
        return this.timer.seconds() >= timeToLift;
    }

    @Override
    public void end(boolean interrupted) {
        if(armSubsystem.getLevel() != 0) {
            armSubsystem.stop();
            armSubsystem.resetLevel();
        }
    }
}
