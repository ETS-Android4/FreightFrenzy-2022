package org.firstinspires.ftc.teamcode.opModes.auto;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.auto.AutoRoutine;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.FloorSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class AutoOpMode extends CommandOpMode {
    private AutoRoutine autoRoutine;

    private Motor intake;
    private SimpleServo floor;

    private IntakeSubsystem intakeSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private FloorSubsystem floorSubsystem;

    @Override
    public void initialize() {
        this.intake = new Motor(hardwareMap, "intake");

        this.floor = new SimpleServo(
                hardwareMap, "floor", 0, 60,
                AngleUnit.DEGREES
        );

        this.floorSubsystem = new FloorSubsystem(floor);
        this.intakeSubsystem = new IntakeSubsystem(intake);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        this.autoRoutine = new AutoRoutine(this.mecanumDriveSubsystem, this.floorSubsystem);

        schedule(autoRoutine);
    }
}
