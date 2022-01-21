package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class LiftOpenLoopCommand extends CommandBase {
    private final LiftSubsystem armSubsystem;
    private final double power;

    public LiftOpenLoopCommand(LiftSubsystem lift, double power) {
        this.armSubsystem = lift;
        this.power = power;
        addRequirements(this.armSubsystem);
    }

    @Override
    public void execute() {
        this.armSubsystem.setPower(power);
    }

}
