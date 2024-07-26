package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveBase;

public class ArcadeDriveCommand extends Command {
  private final DriveBase driveSubsystem;
  private final DoubleSupplier speedFunction, turnFunction;

  public ArcadeDriveCommand(DriveBase driveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
    this.driveSubsystem = driveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;

    this.addRequirements(driveSubsystem);
  }

  @Override
  public void execute() {
    final double realTimeSpeed = this.speedFunction.getAsDouble();
    final double realTimeTurn = this.turnFunction.getAsDouble() * 0.66;

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;

    this.driveSubsystem.setLeft(left);
    this.driveSubsystem.setRight(right);
  }
}
