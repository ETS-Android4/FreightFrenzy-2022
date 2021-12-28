package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.floor.FloorActivateCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;


@TeleOp(name = "TeleOp")
public class  MainTeleOp extends CommandOpMode {
    //motors
    private Motor intakeL, intakeR;
    public SimpleServo floor;


    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private FloorSubsystem floorSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private FloorActivateCommand floorActivateCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;
    private GamepadEx operator;


    @Override
    public void initialize() {
        this.intakeL = new Motor(hardwareMap, "intakeL");
        this.intakeR = new Motor(hardwareMap, "intakeR");

        this.floor = new SimpleServo(
                hardwareMap, "floor", 0, 60,
                AngleUnit.DEGREES
        );

        this.intakeSubsystem = new IntakeSubsystem(this.intakeL, this.intakeR);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        this.floorSubsystem = new FloorSubsystem(this.floor);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.floorActivateCommand = new FloorActivateCommand(this.floorSubsystem);

        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        operator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        operator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);
        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(this.floorActivateCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}