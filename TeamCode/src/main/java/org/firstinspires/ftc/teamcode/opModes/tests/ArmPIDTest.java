package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.MaintainHeightCommand;
import org.firstinspires.ftc.teamcode.subsystems.LiftPIDSubsystem;

@TeleOp(group = "tests")
public class ArmPIDTest extends CommandOpMode {
    private int level = 0;

    //motors
    private Motor armMotorL, armMotorR;

    //subsystems
    private LiftPIDSubsystem armSubsystem;

    //commands
    private MaintainHeightCommand heightCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotorL = new Motor(hardwareMap, "armL");
        this.armMotorR = new Motor(hardwareMap, "armR");

        this.armSubsystem = new LiftPIDSubsystem(armMotorL, armMotorR);

        this.heightCommand = new MaintainHeightCommand(armSubsystem, telemetry);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(
                new InstantCommand(() -> {
                    if (level == 0) {
                        armSubsystem.setDesiredPosition(300);
                        level++;
                    } else if (level == 1) {
                        armSubsystem.setDesiredPosition(500);
                        level++;
                    } else {
                        armSubsystem.setDesiredPosition(700);
                        level = 0;
                    }
                }
                )
        );

        register(armSubsystem);
        this.armSubsystem.setDefaultCommand(heightCommand);
    }
}