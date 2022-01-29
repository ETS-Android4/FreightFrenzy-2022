package org.firstinspires.ftc.teamcode.commands.arm.test.groups;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.arm.test.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class ArmBoxExtendCommand extends SequentialCommandGroup {
    private BoxSubsystem box;
    private ArmExtendTestCommand armCommand;

    public ArmBoxExtendCommand(ArmExtendTestCommand arm, BoxSubsystem box){
        this.armCommand = arm;
        this.box = box;

        addCommands(
                new InstantCommand(box::movePos),
                armCommand
        );
    }
}
