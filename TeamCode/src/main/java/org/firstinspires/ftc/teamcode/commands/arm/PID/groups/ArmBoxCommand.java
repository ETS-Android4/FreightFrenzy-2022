package org.firstinspires.ftc.teamcode.commands.arm.PID.groups;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmResetCommand;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class ArmBoxCommand extends SequentialCommandGroup {
    private ArmCommand armCommand;
    private ArmResetCommand armResetCommand;

    public ArmBoxCommand(ArmCommand armCommand, ArmResetCommand resetCommand, BoxSubsystem box){
        this.armCommand = armCommand;
        this.armResetCommand = resetCommand;

        addCommands(
            new InstantCommand(box::movePos),
            this.armCommand,
            new InstantCommand(box::activate)
        );
    }
}
