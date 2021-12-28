package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.arm.LiftCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmExtendCommand;

public class LiftWristGroup extends SequentialCommandGroup {
    private LiftCommand liftCommand;
    private ArmExtendCommand armExtendCommand;

    public LiftWristGroup(LiftCommand lift, ArmExtendCommand wrist) {
        this.liftCommand = lift;
        this.armExtendCommand = wrist;

        addCommands(lift, wrist);
    }
}
