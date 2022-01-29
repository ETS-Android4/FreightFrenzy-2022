package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmResetCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@TeleOp(group = "tests")
public class ArmPIDTest extends CommandOpMode {
    private RevTouchSensor limit;

    //motors
    private Motor armMotor;

    //subsystems
    private ArmPIDSubsystem armSubsystem;

    //commands
    private ArmCommand command;
    private ArmResetCommand resetCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm");
        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.armSubsystem = new ArmPIDSubsystem(armMotor, limit);

        this.command = new ArmCommand(armSubsystem, telemetry);
        this.resetCommand = new ArmResetCommand(armSubsystem, telemetry);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(command);
        driver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(resetCommand);
    }
}