package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.LiftOpenLoopCommand;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

@TeleOp(name = "LiftTest", group = "tests")
public class LiftTest extends CommandOpMode {
    private Motor liftMotor;

    private LiftSubsystem liftSubsystem;

    private LiftOpenLoopCommand wristOpenLoopCommand;

    private GamepadEx driver;

    @Override
    public void initialize() {
        this.liftMotor = new Motor(hardwareMap, "lift");

        this.liftSubsystem = new LiftSubsystem(liftMotor);

        this.driver = new GamepadEx(gamepad1);

        this.wristOpenLoopCommand = new LiftOpenLoopCommand(liftSubsystem, driver.getLeftY());

        register(this.liftSubsystem);

        this.liftSubsystem.setDefaultCommand(wristOpenLoopCommand);
    }
}
