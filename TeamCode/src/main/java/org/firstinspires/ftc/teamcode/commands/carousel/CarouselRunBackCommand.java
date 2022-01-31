package org.firstinspires.ftc.teamcode.commands.carousel;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.robocol.Command;

import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;

public class CarouselRunBackCommand extends CommandBase {
    private CarouselSubsystem subsystem;

    public CarouselRunBackCommand(CarouselSubsystem subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public void execute() {
        subsystem.runBackCarousel();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.endCarousel();
    }
}
