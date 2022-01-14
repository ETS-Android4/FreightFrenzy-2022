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
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                if (level == 0) {
                    subsystem.setDesiredPosition(300);
                    level++;
                } else if(level == 1) {
                    subsystem.setDesiredPosition(500);
                    level++;
                } else {
                    subsystem.setDesiredPosition(700);
                    level = 0;
                }
            }
            subsystem.setMotorPosition(subsystem.getDesiredPosition());
        }
    }
}
