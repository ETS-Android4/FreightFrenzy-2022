package org.firstinspires.ftc.teamcode.opModes.auto;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.commands.auto.AutoRoutine;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

@Autonomous
@Disabled
public class AutoOpMode extends CommandOpMode {
    private AutoRoutine autoRoutine;

    private Motor intakeL, intakeR, liftMotorL, liftMotorR;
    private CRServo floor;

    private IntakeSubsystem intakeSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private LiftSubsystem armSubsystem;

    @Override
    public void initialize() {
        this.intakeL = new Motor(hardwareMap, "intakeL");
        this.liftMotorL = new Motor(hardwareMap, "liftL");
        this.liftMotorR = new Motor(hardwareMap, "liftR");

        this.floor = new CRServo(hardwareMap, "floor");

        this.intakeSubsystem = new IntakeSubsystem(new MotorGroup(intakeL));
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
        this.armSubsystem = new LiftSubsystem(liftMotorL, liftMotorR);

        this.autoRoutine = new AutoRoutine(this.mecanumDriveSubsystem, this.armSubsystem, this);

        schedule(autoRoutine);
    }
}
