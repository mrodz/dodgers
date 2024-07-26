package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeederSubsystem;

public class FeedCommand extends Command {
  private final FeederSubsystem feeder;
  private final double percentOutput;

  public FeedCommand(FeederSubsystem feeder, double percentOutput) {
    this.feeder = feeder;
    this.percentOutput = percentOutput;

    this.addRequirements(feeder);
  }

  @Override
  public void execute() {
    this.feeder.set(this.percentOutput);
  }
}
