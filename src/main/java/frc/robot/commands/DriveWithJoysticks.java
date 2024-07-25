package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivebase;

public class DriveWithJoysticks extends Command {
  private final Drivebase driveSubsystem;
  private final DoubleSupplier speedFunction, turnFunction;

  public DriveWithJoysticks(Drivebase driveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
      this.driveSubsystem = driveSubsystem;
      this.speedFunction = speedFunction;
      this.turnFunction = turnFunction;
      addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    double realTimeSpeed = this.speedFunction.getAsDouble();
    double realTimeTurn = -this.turnFunction.getAsDouble() * 0.66;

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;

    driveSubsystem.setLeft(left);
    driveSubsystem.setRight(right);
  }
}
