package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;

public class MaintainHeightCommand extends CommandBase {
    private ArmPIDSubsystem subsystem;

    public MaintainHeightCommand(ArmPIDSubsystem subsystem){
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        subsystem.moveToPosition(subsystem.getDesiredPosition());
    }

    @Override
    public boolean isFinished() {
        return subsystem.atPosition();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
    }
}
