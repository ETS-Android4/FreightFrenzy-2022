package org.firstinspires.ftc.teamcode.commands.carousel;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;

public class CarouselRunCommand extends CommandBase {
    private CarouselSubsystem subsystem;

    public CarouselRunCommand(CarouselSubsystem subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public void execute() {
        subsystem.runCarousel();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.endCarousel();
    }
}
