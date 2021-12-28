package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.arm.ArmExtendCommand;
import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

@TeleOp
public class WristTest extends CommandOpMode {
    private ElapsedTime time;

    //motors
    private Motor armMotor;

    //subsystems
    private WristSubsystem armSubsystem;

    //commands
    private ArmExtendCommand extendCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "armMotor");

        time = new ElapsedTime();

        this.armSubsystem = new WristSubsystem(armMotor);

        this.extendCommand = new ArmExtendCommand(armSubsystem, time);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.X).whenPressed(extendCommand);
    }
}