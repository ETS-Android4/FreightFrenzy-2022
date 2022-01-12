package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.MaintainHeightCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;

@TeleOp
public class ArmPIDTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    //subsystems
    private ArmPIDSubsystem armSubsystem;

    //commands
    private ArmCommand armCommand;
    private MaintainHeightCommand heightCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm", Motor.GoBILDA.RPM_312);

        this.armSubsystem = new ArmPIDSubsystem(armMotor);

        this.armCommand = new ArmCommand(armSubsystem, telemetry);
        this.heightCommand = new MaintainHeightCommand(armSubsystem);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(armCommand);

        register(armSubsystem);
        this.armSubsystem.setDefaultCommand(heightCommand);
    }
}