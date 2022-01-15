package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.test.LiftDropTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.LiftRaiseTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

;

@TeleOp(group = "tests")
public class LiftBumperTest extends CommandOpMode {
    //motors
    private Motor liftMotorL, liftMotorR;

    //subsystems
    private LiftSubsystem liftSubsystem;

    //commands
    private LiftRaiseTestCommand raiseCommand;
    private LiftDropTestCommand dropCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.liftMotorL = new Motor(hardwareMap, "liftL");
        this.liftMotorR = new Motor(hardwareMap, "liftR");

        this.liftSubsystem = new LiftSubsystem(liftMotorL, liftMotorR);

        this.raiseCommand = new LiftRaiseTestCommand(liftSubsystem);
        this.dropCommand = new LiftDropTestCommand(liftSubsystem);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.raiseCommand);

        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.dropCommand);

//        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new RunCommand(() -> {
//            if (!armSubsystem.getState() || !retractCommand.isScheduled()) {
//                this.retractCommand.schedule();
//            }
//        }));
    }
}