package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

@TeleOp(name = "test")
public class LinearOpModeTest extends LinearOpMode {
    private Motor armMotor;

    private ArmPIDSubsystem subsystem;

    private int level = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        armMotor = new Motor(hardwareMap, "arm");
        subsystem = new ArmPIDSubsystem(armMotor);

        waitForStart();
        while (opModeIsActive()) {
//            if (gamepad1.dpad_up) {
//                telemetry.addData("Running: ", true);
//                telemetry.addData("Level: ", level);
//                telemetry.update();
//
//                if (level == 0) {
//                    subsystem.setDesiredPosition(300);
//                    level++;
//                } else if(level == 1) {
//                    subsystem.setDesiredPosition(500);
//                    level++;
//                } else {
//                    subsystem.setDesiredPosition(700);
//                    level = 0;
//                }
//            }
//            subsystem.setMotorPosition(subsystem.getDesiredPosition());
//            while (!subsystem.atPosition()){
//                subsystem.moveToPosition();
//            }
//            subsystem.stopMotor();
//            //telemetry.addData("Is working", true);
//            //telemetry.update();

            subsystem.armMotor.setTargetPosition(500);
            subsystem.armMotor.resetEncoder();

            while (!subsystem.armMotor.atTargetPosition()) {
                subsystem.armMotor.set(0.75);
                telemetry.addData("Position", subsystem.armMotor.encoder.getPosition());
                telemetry.update();
            }
            subsystem.armMotor.stopMotor();
        }
    }
}
