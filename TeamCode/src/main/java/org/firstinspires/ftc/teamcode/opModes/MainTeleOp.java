package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.arm.test.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.floor.FloorActivateCommand;
import org.firstinspires.ftc.teamcode.commands.floor.SimpleFloorActivateCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SimpleFloorSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;


@TeleOp(name = "TeleOp")
public class MainTeleOp extends CommandOpMode {
    private CRServo floor;
    private SimpleServo floorSimple;

    //motors
    private Motor armMotor, intakeL, intakeR;
    private RevTouchSensor limit;
    private ElapsedTime time;

    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private ArmSubsystem armSubsystem;
    private FloorSubsystem floorSubsystem;
    private SimpleFloorSubsystem simpleFloorSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private ArmExtendTestCommand armExtendCommand;
    private ArmRetractTestCommand armRetractCommand;
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private FloorActivateCommand floorActivateCommand;
    private SimpleFloorActivateCommand simpleActivateCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;
    private GamepadEx operator;


    @Override
    public void initialize() {
        this.intakeL = new Motor(hardwareMap, "intakeL");
        this.intakeR = new Motor(hardwareMap, "intakeR");
        intakeR.setInverted(true);
        this.armMotor = new Motor(hardwareMap, "arm");

        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.time = new ElapsedTime();

        //this.floor = new CRServo(hardwareMap, "floor");
        //this.floorSimple = new SimpleServo(hardwareMap, "floor", 0, 180, AngleUnit.DEGREES);

        this.intakeSubsystem = new IntakeSubsystem(new MotorGroup(this.intakeL, this.intakeR));
        this.armSubsystem = new ArmSubsystem(this.armMotor, this.limit);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        //this.floorSubsystem = new FloorSubsystem(this.floor);
        //this.simpleFloorSubsystem = new SimpleFloorSubsystem(this.floorSimple);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.armExtendCommand = new ArmExtendTestCommand(this.armSubsystem);
        this.armRetractCommand = new ArmRetractTestCommand(this.armSubsystem);
        //this.floorActivateCommand = new FloorActivateCommand(this.floorSubsystem, this.time);
        //this.simpleActivateCommand = new SimpleFloorActivateCommand(this.simpleFloorSubsystem);

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

//        operator.getGamepadButton(GamepadKeys.Button.Y).whenPressed(this.simpleActivateCommand);
//        operator.getGamepadButton(GamepadKeys.Button.X).whenPressed(this.floorActivateCommand);

        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenHeld(this.armExtendCommand);
        operator.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenHeld(this.armRetractCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}