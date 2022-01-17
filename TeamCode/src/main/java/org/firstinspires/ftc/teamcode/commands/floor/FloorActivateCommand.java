package org.firstinspires.ftc.teamcode.commands.floor;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

public class FloorActivateCommand extends CommandBase {
    private FloorSubsystem subsystem;
    private double timeToMove;
    private ElapsedTime timer;
    private boolean isOpen;

    public FloorActivateCommand(FloorSubsystem floorSubsystem, ElapsedTime time) {
        subsystem = floorSubsystem;
        this.timer = time;
        isOpen = false;

        addRequirements(this.subsystem);
    }

    @Override
    public void execute(){
        if(isOpen) {
            subsystem.reset();
        } else {
            subsystem.activate();
        }
        timeToMove = 0.2;
    }

    @Override
    public boolean isFinished() {
        return this.timer.seconds() >= timeToMove;
    }

    @Override
    public void end(boolean interrupted){
        isOpen = !isOpen;
        subsystem.stop();
    }
}