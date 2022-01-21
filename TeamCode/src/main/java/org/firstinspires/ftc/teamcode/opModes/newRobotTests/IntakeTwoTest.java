package org.firstinspires.ftc.teamcode.opModes.newRobotTests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.commands.intake.twoMotor.IntakeTwoCommand;
import org.firstinspires.ftc.teamcode.commands.intake.twoMotor.OuttakeTwoCommand;
import org.firstinspires.ftc.teamcode.subsystems.TwoMotorIntakeSubsystem;

@TeleOp(name = "IntakeTwo")
public class IntakeTwoTest extends CommandOpMode {
    private Motor intakeL;
    private Motor intakeR;

    private TwoMotorIntakeSubsystem intake;

    private IntakeTwoCommand intakeTwoCommand;
    private OuttakeTwoCommand outtakeTwoCommand;

    private GamepadEx driver;
    @Override
    public void initialize() {
        this.intakeL = new Motor(hardwareMap, "liftL");
        this.intakeR = new Motor(hardwareMap, "liftR");

        this.intake = new TwoMotorIntakeSubsystem(intakeL, intakeR);

        this.intakeTwoCommand = new IntakeTwoCommand(this.intake);
        this.outtakeTwoCommand = new OuttakeTwoCommand(this.intake);

        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(intakeTwoCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(outtakeTwoCommand);
    }
}
