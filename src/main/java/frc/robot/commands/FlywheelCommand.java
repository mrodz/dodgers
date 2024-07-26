package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlywheelSubsystem;

import static frc.robot.Constants.*;

public class FlywheelCommand extends Command {
  private final FlywheelSubsystem flywheel;

  public FlywheelCommand(FlywheelSubsystem flywheel) {
    this.flywheel = flywheel;

    this.addRequirements(flywheel);
  }

  @Override
  public void execute() {
    final double realTimeSpeed = SmartDashboard.getNumber("Flywheel Speed", DEFAULT_FLYWHEEL_SPEED);
    this.flywheel.slewLimitedSet(realTimeSpeed);
  }
}
