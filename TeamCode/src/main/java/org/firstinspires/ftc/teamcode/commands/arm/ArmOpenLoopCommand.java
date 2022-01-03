package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmOpenLoopCommand extends CommandBase {
    private ArmSubsystem armSubsystem;
    private double power;

    public ArmOpenLoopCommand(ArmSubsystem armSubsystem, double power){
        this.armSubsystem = armSubsystem;
        this.power = power;
    }

    @Override
    public void execute() {
        this.armSubsystem.setPower(this.power);
    }

    @Override
    public boolean isFinished() {
        return armSubsystem.getState() && power < 0;
    }
}
