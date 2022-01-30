package org.firstinspires.ftc.teamcode.commands.auto.blue;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.arm.PID.groups.ArmBoxCommand;
import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmResetCommand;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class AutoCarouselStorageUnitBlueAlliance extends SequentialCommandGroup {
    public AutoCarouselStorageUnitBlueAlliance(MecanumDriveSubsystem dt, CarouselSubsystem car,
                                               ArmResetCommand reset, ArmBoxCommand arm, BoxSubsystem box, CommandOpMode opMode){
        addCommands(
                new WaitUntilCommand(opMode::isStarted),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(-1, 0, 0))),
                new WaitCommand(100),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0, 0))),
                new InstantCommand(() -> car.runCarousel()),
                new WaitCommand(3000),
                new InstantCommand(() -> car.endCarousel()),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, -1, 0))),
                new WaitCommand(1100),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(-1, 0, 0))),
                new WaitCommand(500),
//                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0,1,0))),
//                new WaitCommand(1000),
//                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0, 1))),
//                new WaitCommand(2000),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0,0)))
        );
    }

}
