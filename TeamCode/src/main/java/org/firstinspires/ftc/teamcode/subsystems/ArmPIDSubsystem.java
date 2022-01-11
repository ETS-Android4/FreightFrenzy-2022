package org.firstinspires.ftc.teamcode.subsystems;

/*
 * once again, thx 21864
 * might need to change this to match arm pid
 */

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

public class ArmPIDSubsystem extends SubsystemBase {
//    private static final double kS = 1.0;
//    private static final double kCos = 1.0;
//    private static final double kV = 1.0;
//    private static final double kA = 1.0;
//    private static final double kP = 10.0;
//    private static final double kI = 0;
//    private static final double kD = 0;
//    private final ArmFeedforward armFeedforward = new ArmFeedforward(kS, kCos, kV, kA);
//    private final double distancePerPulse = Math.PI * 0.05 / 537.7; //change based on encoder pulses for given motor
    private final Motor armMotor;

    public ArmPIDSubsystem(Motor motor) {
        this.armMotor = motor;
        armMotor.setInverted(true);
//        armMotor.encoder.setDistancePerPulse(distancePerPulse);
    }

    public void moveToPosition(int position){
        armMotor.setRunMode(Motor.RunMode.PositionControl);
        armMotor.setTargetPosition(position);
        armMotor.setPositionCoefficient(0.05);
        armMotor.setPositionTolerance(13.6);
        armMotor.set(0.75);
    }

    public boolean atPosition(){
        return armMotor.atTargetPosition();
    }
    public void setMotor() {
        armMotor.set(0.5);
    }
}