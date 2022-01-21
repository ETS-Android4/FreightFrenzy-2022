package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.floor.FloorActivateCommand;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;

@TeleOp(group = "tests")
public class FloorTest extends CommandOpMode {
    private ElapsedTime time;

    //motors
    private CRServo floor;

    //subsystems
    private FloorSubsystem subsystem;

    //commands
    private FloorActivateCommand command;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        time = new ElapsedTime();
        this.floor = new CRServo(hardwareMap, "floor");
        this.subsystem = new FloorSubsystem(floor);
        this.command = new FloorActivateCommand(subsystem, time);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.Y).whenPressed(command);
    }
}