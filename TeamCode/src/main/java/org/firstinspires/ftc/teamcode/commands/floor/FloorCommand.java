package org.firstinspires.ftc.teamcode.commands.floor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

public class FloorCommand extends CommandBase {
    private FloorSubsystem subsystem;

    public FloorCommand(FloorSubsystem subsystem) {
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
