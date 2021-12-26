package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.OuttakeCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class MainTeleOp extends CommandOpMode {
    //motors
    private Motor arm, intakeMotor;

    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private LiftSubsystem liftSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private LiftCommand liftCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //gamepads
    private GamepadEx driver;
    private GamepadEx operator;

    //timer
    private ElapsedTime timer;

    @Override
    public void initialize() {
        this.intakeMotor = new Motor(hardwareMap, "intake");
        this.arm = new Motor(hardwareMap, "lift");

        this.intakeSubsystem = new IntakeSubsystem(intakeMotor);
        this.liftSubsystem = new LiftSubsystem(arm);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        timer = new ElapsedTime();

        this.intakeCommand = new IntakeCommand(intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(intakeSubsystem);
        this.liftCommand = new LiftCommand(liftSubsystem, timer);
        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> -driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        operator.getGamepadButton(GamepadKeys.Button.A).whenHeld(intakeCommand);
        operator.getGamepadButton(GamepadKeys.Button.B).whenHeld(outtakeCommand);

        operator.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(liftCommand);

        register(mecanumDriveSubsystem);
        mecanumDriveSubsystem.setDefaultCommand(mecanumDriveCommand);
    }
}
