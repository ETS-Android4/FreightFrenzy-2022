package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.commands.arm.ArmCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class ArmPIDTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    //subsystems
    private ArmPIDSubsystem armSubsystem;

    //commands
    private ArmCommand armCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm");

        this.armSubsystem = new ArmPIDSubsystem(armMotor);

        this.armCommand = new ArmCommand(armSubsystem, telemetry);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(armCommand);
    }
}