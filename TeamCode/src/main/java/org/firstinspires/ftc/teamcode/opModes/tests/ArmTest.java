package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.teamcode.commands.arm.ArmOpenLoopCommand;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class ArmTest extends CommandOpMode {
    private Motor liftMotor;

    private LiftSubsystem liftSubsystem;

    private ArmOpenLoopCommand armOpenLoopCommand;

    private GamepadEx driver;

    @Override
    public void initialize() {
        this.liftMotor = new Motor(hardwareMap, "lift");

        this.liftSubsystem = new LiftSubsystem(liftMotor);

        this.driver = new GamepadEx(gamepad1);

        this.armOpenLoopCommand = new ArmOpenLoopCommand(liftSubsystem, driver.getLeftY());

        register(this.liftSubsystem);

        this.liftSubsystem.setDefaultCommand(armOpenLoopCommand);
    }
}
