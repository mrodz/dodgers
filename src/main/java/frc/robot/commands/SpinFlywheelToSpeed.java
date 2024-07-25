// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.FlywheelSpeed;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Flywheel;

public class SpinFlywheelToSpeed extends Command {
  private final Flywheel flywheel;

  /** Creates a new SpinFlywheelToSpeed. */
  public SpinFlywheelToSpeed(Flywheel flywheel) {
    this.flywheel = flywheel;
    addRequirements(flywheel);
  }

  @Override
  public void execute() {
    flywheel.slewLimitedSpin(SmartDashboard.getNumber("Flywheel Speed", FlywheelSpeed));
  }
}
