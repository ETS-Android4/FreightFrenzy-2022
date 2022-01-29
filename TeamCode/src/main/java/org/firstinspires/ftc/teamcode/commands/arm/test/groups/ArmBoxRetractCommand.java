package org.firstinspires.ftc.teamcode.commands.arm.test.groups;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.arm.test.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

public class ArmBoxRetractCommand extends SequentialCommandGroup {
    private ArmRetractTestCommand armCommand;
    private BoxSubsystem box;

    public ArmBoxRetractCommand(ArmRetractTestCommand armCommand, BoxSubsystem box){
        this.armCommand = armCommand;
        this.box = box;

        addCommands(
                new InstantCommand(box::reset),
                armCommand
        );
    }
}
