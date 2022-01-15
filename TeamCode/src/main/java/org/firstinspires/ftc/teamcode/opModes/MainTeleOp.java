package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.arm.ArmExtendCommand;
import org.firstinspires.ftc.teamcode.commands.arm.ArmOpenLoopCommand;
import org.firstinspires.ftc.teamcode.commands.arm.LiftOpenLoopCommand;
import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.floor.FloorActivateCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;


@TeleOp(name = "TeleOp")
public class MainTeleOp extends CommandOpMode {
    //motors
    private Motor intake, armMotor, liftMotorL, liftMotorR;
    public SimpleServo floor;

    private RevTouchSensor limit;
    private ElapsedTime time;

    //subsystems
    private LiftSubsystem liftSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ArmSubsystem armSubsystem;
    private FloorSubsystem floorSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private LiftOpenLoopCommand liftCommand;
    private ArmOpenLoopCommand armCommand;
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private ArmExtendCommand armExtendCommand;
    private FloorActivateCommand floorActivateCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;
    private GamepadEx operator;


    @Override
    public void initialize() {
        this.intake = new Motor(hardwareMap, "intake");
        this.armMotor = new Motor(hardwareMap, "arm");
        this.liftMotorL = new Motor(hardwareMap, "liftL");
        this.liftMotorR = new Motor(hardwareMap, "liftR");

        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.time = new ElapsedTime();

        this.floor = new SimpleServo(
                hardwareMap, "floor", 0, 60,
                AngleUnit.DEGREES
        );

        this.intakeSubsystem = new IntakeSubsystem(this.intake);
        this.armSubsystem = new ArmSubsystem(this.armMotor, limit);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        this.floorSubsystem = new FloorSubsystem(this.floor);
        this.liftSubsystem = new LiftSubsystem(liftMotorL, liftMotorR);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.armExtendCommand = new ArmExtendCommand(this.armSubsystem, time);
        this.floorActivateCommand = new FloorActivateCommand(this.floorSubsystem);
        this.liftCommand = new LiftOpenLoopCommand(this.liftSubsystem, operator.getLeftY());
        this.armCommand = new ArmOpenLoopCommand(this.armSubsystem, operator.getLeftX());

        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        operator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        operator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(this.floorActivateCommand);
        operator.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(this.armExtendCommand);

        register(this.mecanumDriveSubsystem, this.liftSubsystem, this.armSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
        this.liftSubsystem.setDefaultCommand(this.liftCommand);
        this.armSubsystem.setDefaultCommand(this.armCommand);
    }
}