package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.arm.test.ArmExtendTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.ArmRetractTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.LiftDropTestCommand;
import org.firstinspires.ftc.teamcode.commands.arm.test.LiftRaiseTestCommand;
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
    public CRServo floor;

    private RevTouchSensor limit;
    private ElapsedTime time;

    private Trigger armExtendTrigger;
    private Trigger armRetractTrigger;

    //subsystems
    private LiftSubsystem liftSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ArmSubsystem armSubsystem;
    private FloorSubsystem floorSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private LiftRaiseTestCommand liftRaiseCommand;
    private LiftDropTestCommand liftDropCommand;
    private ArmExtendTestCommand armExtendCommand;
    private ArmRetractTestCommand armRetractCommand;
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
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

        this.floor = new CRServo(hardwareMap, "floor");

        this.intakeSubsystem = new IntakeSubsystem(this.intake);
        this.armSubsystem = new ArmSubsystem(this.armMotor, this.limit);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        this.floorSubsystem = new FloorSubsystem(this.floor);
        this.liftSubsystem = new LiftSubsystem(liftMotorL, liftMotorR);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.armExtendCommand = new ArmExtendTestCommand(this.armSubsystem);
        this.armRetractCommand = new ArmRetractTestCommand(this.armSubsystem);
        this.floorActivateCommand = new FloorActivateCommand(this.floorSubsystem, this.time);
        this.liftRaiseCommand = new LiftRaiseTestCommand(this.liftSubsystem);
        this.liftDropCommand = new LiftDropTestCommand(this.liftSubsystem);

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

//        operator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
//        operator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

        operator.getGamepadButton(GamepadKeys.Button.X).whenPressed(this.floorActivateCommand);


        operator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.liftDropCommand);
        operator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.liftRaiseCommand);

//        TriggerReader rtReader = new TriggerReader(operator, GamepadKeys.Trigger.RIGHT_TRIGGER);
//        armExtendTrigger = new Trigger(rtReader::isDown);
//        armExtendTrigger.whenActive(this.armExtendCommand);
//        TriggerReader ltReader = new TriggerReader(operator, GamepadKeys.Trigger.LEFT_TRIGGER);
//        armRetractTrigger = new Trigger(ltReader::isDown);
//        armRetractTrigger.whenActive(this.armRetractCommand);


        operator.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenHeld(this.armExtendCommand);
        operator.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenHeld(this.armRetractCommand);
//        operator.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenHeld(this.liftDropCommand);
//        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenHeld(this.liftRaiseCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}