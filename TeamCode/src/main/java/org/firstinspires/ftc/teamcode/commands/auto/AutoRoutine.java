package org.firstinspires.ftc.teamcode.commands.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class AutoRoutine extends SequentialCommandGroup {
    public AutoRoutine(MecanumDriveSubsystem dt, FloorSubsystem floor) {
        addCommands(
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0.5, 0))),
                new WaitCommand(500),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0, 0)))
        );
    }
}
