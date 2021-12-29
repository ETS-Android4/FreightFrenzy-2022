package org.firstinspires.ftc.teamcode.commands.floor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

public class FloorActivateCommand extends CommandBase {
    private FloorSubsystem subsystem;
    private boolean isActivated = true;

    public FloorActivateCommand(FloorSubsystem floorSubsystem) {
        subsystem = floorSubsystem;
    }

    @Override
    public void execute(){
        if(isActivated){
            subsystem.activate();
        } else {
            subsystem.reset();
        }
        isActivated = !isActivated;
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){
        subsystem.stop();
    }
}