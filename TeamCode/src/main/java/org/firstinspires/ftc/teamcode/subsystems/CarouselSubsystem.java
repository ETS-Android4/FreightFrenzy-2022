package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class CarouselSubsystem extends SubsystemBase {
    private Motor motor;

    public CarouselSubsystem(Motor motor) {
        this.motor = motor;
    }

    public void runCarousel() {
    motor.set(0.6);
    }

    public void runBackCarousel() {
        motor.set(-0.6);
    }

    public void endCarousel() {
        motor.stopMotor();
    }
}
