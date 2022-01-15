package org.firstinspires.ftc.teamcode.commands.floor;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

public class FloorResetCommand extends CommandBase {
    private FloorSubsystem subsystem;

    public FloorResetCommand(FloorSubsystem floorSubsystem) {
        subsystem = floorSubsystem;
    }

    @Override
    public void execute(){
        subsystem.reset();
    }

    @Override
    public void end(boolean interrupted){
        subsystem.stop();
    }
}

