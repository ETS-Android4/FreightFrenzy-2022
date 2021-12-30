package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.arm.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.WristSubsystem;

@TeleOp
public class AemTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    //subsystems
    private WristSubsystem armSubsystem;

    //commands
    private ArmExtendTestCommand extendCommand;
    private ArmRetractTestCommand retractCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "armMotor");

        this.armSubsystem = new WristSubsystem(armMotor);

        this.extendCommand = new ArmExtendTestCommand(armSubsystem);
        this.retractCommand = new ArmRetractTestCommand(armSubsystem);

        this.driver = new GamepadEx(gamepad1);

        if (driver.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0) {
            schedule(this.extendCommand);
        }

        if (driver.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0) {
            schedule(this.retractCommand);
        }
    }
}