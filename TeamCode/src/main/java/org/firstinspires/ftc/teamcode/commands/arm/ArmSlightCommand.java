package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmSlightCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private final ElapsedTime timer;
    private final boolean isUp;
    private double timeToLift;

    public ArmSlightCommand(ArmSubsystem subsystem, ElapsedTime timer, boolean isUp) {
        this.armSubsystem = subsystem;
        this.timer = timer;
        this.isUp = isUp;

        addRequirements(this.armSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        if (isUp) {
            armSubsystem.slightUp();
        } else {
            armSubsystem.slightDown();
        }
        timeToLift = 0.1;
    }

    @Override
    public boolean isFinished() {
        return timer.seconds() >= timeToLift;
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}
