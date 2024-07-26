package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.FeedCommand;
import frc.robot.commands.FlywheelCommand;
import frc.robot.commands.TurretCommand;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.TurretSubsystem;

import static frc.robot.Constants.*;

public class RobotContainer {
  private final DriveBase base = new DriveBase();
  private final FeederSubsystem feeder = new FeederSubsystem();
  private final TurretSubsystem turret = new TurretSubsystem();
  private final FlywheelSubsystem flywheel = new FlywheelSubsystem();

  private final TurretCommand moveTurretRight = new TurretCommand(turret, TURRET_SPEED);
  private final TurretCommand moveTurretLeft = new TurretCommand(turret, -TURRET_SPEED);
  private final FlywheelCommand spinFlywheel = new FlywheelCommand(flywheel);
  private final FeedCommand spinFeeder = new FeedCommand(feeder, TURRET_SPEED);

  private final CommandXboxController controller = new CommandXboxController(CONTROLLER_PORT);

  private final ArcadeDriveCommand driveWithJoysticks = new ArcadeDriveCommand(base, this::getSpeed, this::getTurn);

  private double getSpeed() {
    final double raw = -this.controller.getLeftY() / 3;
    return Math.abs(raw) < CONTROLLER_DEAD_ZONE ? 0 : raw;
  }

  private double getTurn() {
    final double raw = this.controller.getRightX() / 3;
    return Math.abs(raw) < CONTROLLER_DEAD_ZONE ? 0 : raw;
  }

  public RobotContainer() {
    this.base.setDefaultCommand(driveWithJoysticks);
    this.turret.setDefaultCommand(turret.stopAction());
    this.flywheel.setDefaultCommand(flywheel.stopAction());
    this.feeder.setDefaultCommand(feeder.stopAction());

    this.configureBindings();
  }

  private void configureBindings() {
    this.controller.rightBumper().whileTrue(spinFlywheel);
    this.controller.leftBumper().whileTrue(spinFeeder);
    this.controller.x().whileTrue(moveTurretLeft);
    this.controller.b().whileTrue(moveTurretRight);
  }

  public Command getAutonomousCommand() {
    return Commands.print("The DodgerBot does not have an autonomous protocol");
  }
}
