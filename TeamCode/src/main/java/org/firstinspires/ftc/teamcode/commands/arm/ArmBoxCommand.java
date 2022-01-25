package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class ArmBoxCommand extends SequentialCommandGroup {
    private ArmCommand armCommand;
    private ArmResetCommand armResetCommand;

    public ArmBoxCommand(ArmCommand armCommand, ArmResetCommand resetCommand, BoxSubsystem box){
        this.armCommand = armCommand;
        this.armResetCommand = resetCommand;

        addCommands(
            this.armCommand,
            new InstantCommand(box::activate),
            new InstantCommand(box::reset),
            this.armResetCommand
        );
    }
}
