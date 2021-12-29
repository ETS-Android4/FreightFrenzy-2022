package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class ArmOpenLoopCommand extends CommandBase {
    private LiftSubsystem armSubsystem;
    private double power;

    public ArmOpenLoopCommand(LiftSubsystem lift, double power) {
        this.armSubsystem = lift;
        this.power = power;
    }

    @Override
    public void execute() {
        this.armSubsystem.setPower(power);
    }

}
