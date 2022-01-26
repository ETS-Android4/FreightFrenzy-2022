package org.firstinspires.ftc.teamcode.commands.box;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class BoxNormalCommand extends CommandBase {
    private BoxSubsystem subsystem;

    public BoxNormalCommand(BoxSubsystem subsystem) {
        this.subsystem = subsystem;

        addRequirements(this.subsystem);
    }

    @Override
    public void execute() {
        subsystem.reset();
    }
}
