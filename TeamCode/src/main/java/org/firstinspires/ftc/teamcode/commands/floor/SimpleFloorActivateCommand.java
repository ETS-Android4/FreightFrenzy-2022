package org.firstinspires.ftc.teamcode.commands.floor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.SimpleFloorSubsystem;

public class SimpleFloorActivateCommand extends CommandBase {
    private SimpleFloorSubsystem subsystem;

    public SimpleFloorActivateCommand(SimpleFloorSubsystem subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public void execute() {
        if(!subsystem.isActive()){
            subsystem.activate();
        } else {
            subsystem.reset();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.setActive(!subsystem.isActive());
    }
}
