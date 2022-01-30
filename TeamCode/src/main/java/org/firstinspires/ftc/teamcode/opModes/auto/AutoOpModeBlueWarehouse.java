package org.firstinspires.ftc.teamcode.opModes.auto;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.PID.ArmResetCommand;
import org.firstinspires.ftc.teamcode.commands.arm.PID.groups.ArmBoxCommand;
import org.firstinspires.ftc.teamcode.commands.auto.blue.AutoCarouselStorageUnitBlueAlliance;
import org.firstinspires.ftc.teamcode.commands.auto.blue.AutoCarouselWarehouseBlueAlliance;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@Autonomous(name = "Auto Blue Warehouse")
public class AutoOpModeBlueWarehouse extends CommandOpMode {
    private Servo box;
    private RevTouchSensor limit;

    //motors
    private Motor carousel, arm;

    //subsystems
    private ArmPIDSubsystem armSubsystem;
    private BoxSubsystem boxSubsystem;
    private CarouselSubsystem carouselSubsystem;
    private MecanumDriveSubsystem driveSubsystem;

    //commands
    private ArmBoxCommand armCommand;
    private ArmResetCommand armResetCommand;
    private AutoCarouselWarehouseBlueAlliance autoCommand;

    @Override
    public void initialize() {
        this.arm = new Motor(hardwareMap, "arm");
        this.carousel = new Motor(hardwareMap, "carousel");
        this.box = hardwareMap.get(Servo.class, "floor");
        this.limit = new RevTouchSensor(hardwareMap, "limit");

        this.armSubsystem = new ArmPIDSubsystem(this.arm, this.limit);
        this.carouselSubsystem = new CarouselSubsystem(this.carousel);
        this.boxSubsystem = new BoxSubsystem(this.box);
        this.driveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        this.armCommand = new ArmBoxCommand(new ArmCommand(armSubsystem, telemetry), new ArmResetCommand(armSubsystem, telemetry), boxSubsystem);
        this.armResetCommand = new ArmResetCommand(armSubsystem, telemetry);
        this.autoCommand = new AutoCarouselWarehouseBlueAlliance(driveSubsystem, carouselSubsystem, armResetCommand,
                armCommand, boxSubsystem, this);

        schedule(autoCommand);
    }
}