// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;

public class SpinIndexer extends Command {
  private Indexer indexer;
  private double speed;

  public SpinIndexer(Indexer indexer, double speed) {
    this.indexer = indexer;
    this.speed = speed;
    addRequirements(indexer);
  }

  @Override
  public void execute() {
    indexer.spin(speed);
  }
}
