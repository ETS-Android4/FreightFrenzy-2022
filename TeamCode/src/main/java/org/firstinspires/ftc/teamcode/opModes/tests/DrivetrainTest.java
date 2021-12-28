package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

@TeleOp
public class  DrivetrainTest extends CommandOpMode {
    //motors
    //subsystems
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;

    HardwareMap hwMap = null;

    @Override
    public void initialize() {
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        driver = new GamepadEx(gamepad1);
        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> -driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}