package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class StoppableSubsystemBase extends SubsystemBase {
  public abstract void stop();

  public Command stopAction() {
    return Commands.run(this::stop, this);
  }
}