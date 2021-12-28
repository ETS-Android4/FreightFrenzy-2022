package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.floor.FloorActivateCommand;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

@TeleOp
public class FloorTest extends CommandOpMode {
    //motors
    private SimpleServo floor;

    //subsystems
    private FloorSubsystem subsystem;

    //commands
    private FloorActivateCommand command;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.floor = new SimpleServo(
                hardwareMap, "floor", 0, 60,
                AngleUnit.DEGREES
        );
        this.subsystem = new FloorSubsystem(floor);
        this.command = new FloorActivateCommand(subsystem);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.Y).whenPressed(command);
    }
}