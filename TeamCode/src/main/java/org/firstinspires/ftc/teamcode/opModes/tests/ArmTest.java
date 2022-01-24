package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.test.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@TeleOp(group = "tests")
public class ArmTest extends CommandOpMode {
    //motors
    private Motor armMotor;

    private RevTouchSensor limit;

    //subsystems
    private ArmSubsystem armSubsystem;

    //commands
    private ArmExtendTestCommand extendCommand;
    private ArmRetractTestCommand retractCommand;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm", Motor.GoBILDA.RPM_435);

        this.limit = new RevTouchSensor(hardwareMap, "limit");

        this.armSubsystem = new ArmSubsystem(armMotor, limit);

        this.extendCommand = new ArmExtendTestCommand(armSubsystem);
        this.retractCommand = new ArmRetractTestCommand(armSubsystem);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.retractCommand);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.extendCommand);

//        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new RunCommand(() -> {
//            if (!armSubsystem.getState() || !retractCommand.isScheduled()) {
//                this.retractCommand.schedule();
//            }
//        }));
    }
}