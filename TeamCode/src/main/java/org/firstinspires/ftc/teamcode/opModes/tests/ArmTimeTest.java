package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.arm.time.ArmDownCommand;
import org.firstinspires.ftc.teamcode.commands.arm.time.ArmSlightCommand;
import org.firstinspires.ftc.teamcode.commands.arm.time.ArmUpCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

public class ArmTimeTest extends CommandOpMode {
    private Motor armMotor;
    private RevTouchSensor touchSensor;

    private ArmSubsystem armSubsystem;

    private ArmUpCommand armUpCommand;
    private ArmDownCommand armDownCommand;
    private ArmSlightCommand armSlightUpCommand, armSlightDownCommand;

    private GamepadEx driver;

    private ElapsedTime timer;

    @Override
    public void initialize() {
        armMotor = new Motor(hardwareMap, "arm");

        touchSensor = new RevTouchSensor(hardwareMap, "limit");

        armSubsystem = new ArmSubsystem(armMotor, touchSensor);

        this.timer = new ElapsedTime();

        armUpCommand = new ArmUpCommand(armSubsystem, timer);
        armDownCommand = new ArmDownCommand(armSubsystem, timer);
        armSlightUpCommand = new ArmSlightCommand(armSubsystem, timer, true);
        armSlightDownCommand = new ArmSlightCommand(armSubsystem, timer, false);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(armUpCommand);
        driver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(armDownCommand);
        driver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(armSlightDownCommand);
        driver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(armSlightUpCommand);

    }
}
