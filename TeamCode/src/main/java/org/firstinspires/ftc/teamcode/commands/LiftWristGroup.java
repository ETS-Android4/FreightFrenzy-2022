package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.arm.LiftCommand;
import org.firstinspires.ftc.teamcode.commands.arm.WristCommand;

public class LiftWristGroup extends SequentialCommandGroup {
    private LiftCommand liftCommand;
    private WristCommand wristCommand;

    public LiftWristGroup(LiftCommand lift, WristCommand wrist) {
        this.liftCommand = lift;
        this.wristCommand = wrist;

        addCommands(lift, wrist);
    }
}
