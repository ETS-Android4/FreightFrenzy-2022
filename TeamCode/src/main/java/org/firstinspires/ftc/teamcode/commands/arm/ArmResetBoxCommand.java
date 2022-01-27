package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class ArmResetBoxCommand extends SequentialCommandGroup {
    private ArmResetCommand resetCommand;
    private BoxSubsystem box;

    public ArmResetBoxCommand(ArmResetCommand resetCommand, BoxSubsystem box){
        this.box = box;
        this.resetCommand = resetCommand;

        addCommands(
                new InstantCommand(this.box::reset),
                this.resetCommand
        );
    }
}
