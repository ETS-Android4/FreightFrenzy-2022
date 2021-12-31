package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;;

import org.firstinspires.ftc.teamcode.commands.arm.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@TeleOp
public class ArmTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    private RevTouchSensor limit;

    //subsystems
    private WristSubsystem armSubsystem;

    //commands
    private ArmExtendTestCommand extendCommand;
    private ArmRetractTestCommand retractCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm");

        this.limit = new RevTouchSensor(hardwareMap, "limit");

        this.armSubsystem = new WristSubsystem(armMotor, limit);

        this.extendCommand = new ArmExtendTestCommand(armSubsystem);
        this.retractCommand = new ArmRetractTestCommand(armSubsystem);

        this.driver = new GamepadEx(gamepad1);

            driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.retractCommand);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.extendCommand);
    }
}