package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.BoxSubsystem;

@TeleOp
public class ServoTest extends CommandOpMode {
    private Servo servo;
    private BoxSubsystem subsystem;
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.servo = hardwareMap.get(Servo.class, "servo");

        this.subsystem = new BoxSubsystem(servo);

        driver = new GamepadEx(gamepad1);
        driver.getGamepadButton(GamepadKeys.Button.X)
            .whenPressed(new ConditionalCommand(
                new InstantCommand(subsystem::activate),
                new InstantCommand(subsystem::reset),
                () -> {
                    subsystem.toggle();
                    return subsystem.isActive();
                }
            ));
    }
}
