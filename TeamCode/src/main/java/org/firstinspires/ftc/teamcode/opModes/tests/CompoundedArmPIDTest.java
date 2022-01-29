package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.wrist.MaintainHeightCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@TeleOp
public class CompoundedArmPIDTest extends CommandOpMode {
    private RevTouchSensor limit;

    //motors
    private Motor armMotor;

    //subsystems
    private ArmPIDSubsystem subsystem;

    //commands
    private MaintainHeightCommand command;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm");
        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.subsystem = new ArmPIDSubsystem(armMotor, limit);
        this.command = new MaintainHeightCommand(subsystem, telemetry);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new InstantCommand(() ->
                subsystem.setTargetPosition(1500)
        ));
        driver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new InstantCommand(() ->
                subsystem.setTargetPosition(0)
        ));

        register(this.subsystem);
        subsystem.setDefaultCommand(command);
    }
}
