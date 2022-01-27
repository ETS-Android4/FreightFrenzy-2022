package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.arm.ArmBoxCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmResetBoxCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmResetCommand;
import org.firstinspires.ftc.teamcode.commands.carousel.CarouselRunCommand;
import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.util.MotorPDController;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;


@TeleOp(name = "TeleOp")
public class MainTeleOp extends CommandOpMode {
    private Servo floor;
    private ElapsedTime time;
    private RevTouchSensor limit;

    //motors
    private Motor intakeL, intakeR, carousel;
    private MotorPDController armMotor;

    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private ArmPIDSubsystem armSubsystem;
    private BoxSubsystem boxSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private CarouselSubsystem carouselSubsystem;

    //commands
    private ArmResetBoxCommand armResetCommand;
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private MecanumDriveCommand mecanumDriveCommand;
    private CarouselRunCommand carouselCommand;
    private ArmBoxCommand armBoxCommand;

    //gamepads
    private GamepadEx driver;
    private GamepadEx operator;


    @Override
    public void initialize() {
        this.intakeL = new Motor(hardwareMap, "intakeL");
        this.intakeR = new Motor(hardwareMap, "intakeR");
        this.armMotor = new MotorPDController(hardwareMap, "arm", MotorPDController.GoBILDA.RPM_435);
        this.carousel = new Motor(hardwareMap, "carousel");
        intakeR.setInverted(true);

        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.time = new ElapsedTime();

        this.floor = hardwareMap.get(Servo.class, "floor");

        this.intakeSubsystem = new IntakeSubsystem(new MotorGroup(this.intakeL, this.intakeR));
        this.armSubsystem = new ArmPIDSubsystem(this.armMotor, this.limit);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        this.boxSubsystem = new BoxSubsystem(this.floor);
        this.carouselSubsystem = new CarouselSubsystem(this.carousel);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.carouselCommand = new CarouselRunCommand(this.carouselSubsystem);
        this.armBoxCommand = new ArmBoxCommand(new ArmCommand(this.armSubsystem, telemetry),
                new ArmResetCommand(this.armSubsystem, telemetry), this.boxSubsystem);
        this.armResetCommand = new ArmResetBoxCommand(new ArmResetCommand(this.armSubsystem, telemetry), this.boxSubsystem);

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, driver::getLeftY,
                driver::getLeftX, driver::getRightX
        );

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

        operator.getGamepadButton(GamepadKeys.Button.X).whenPressed(new InstantCommand(boxSubsystem::activate));
        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(armBoxCommand);
        operator.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(armResetCommand);

        operator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.carouselCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}