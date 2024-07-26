package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TurretSubsystem;

public class TurretCommand extends Command {
  private final TurretSubsystem turret;
  private final double speed;

  public TurretCommand(TurretSubsystem turret, double speed) {
    this.turret = turret;
    this.speed = speed;

    this.addRequirements(turret);
  }

  @Override
  public void initialize() {
    this.turret.set(this.speed);
  }
}
