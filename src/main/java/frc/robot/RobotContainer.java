package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;

public class RobotContainer {
    // Subsystems
    private final Drivebase base = new Drivebase();
    private final Indexer indexer = new Indexer();
    private final Turret turret = new Turret();
    private final Flywheel flywheel = new Flywheel();

    // Commands
    private final MoveTurret moveTurretRight = new MoveTurret(turret, TurretMoveSpeed);
    private final MoveTurret moveTurretLeft = new MoveTurret(turret, -TurretMoveSpeed);
    private final SpinFlywheelToSpeed spinFlywheelToSpeed = new SpinFlywheelToSpeed(flywheel);
    private final SpinIndexer spinIndexer = new SpinIndexer(indexer, TurretMoveSpeed);

    public CommandXboxController controller;

    private final DriveWithJoysticks driveWithJoysticks = new DriveWithJoysticks(base, this::getSpeed, this::getTurn);

    private double getSpeed() {
        final double raw = controller.getLeftY() / 3;
        if (Math.abs(raw) < controllerDeadZone)
            return 0;
        return raw;
    }

    private double getTurn() {
        final double raw = -controller.getRightX() / 3;
        if (Math.abs(raw) < controllerDeadZone)
            return 0;
        return raw;
    }

    public RobotContainer() {
        base.setDefaultCommand(driveWithJoysticks);
        turret.setDefaultCommand(turret.stopAction());
        flywheel.setDefaultCommand(flywheel.stopAction());
        indexer.setDefaultCommand(indexer.stopAction());

        controller = new CommandXboxController(controllerPort);

        configureBindings();
    }

    private void configureBindings() {
        controller.rightBumper().whileTrue(spinFlywheelToSpeed);
        controller.leftBumper().whileTrue(spinIndexer);
        controller.x().whileTrue(moveTurretLeft);
        controller.b().whileTrue(moveTurretRight);
    }

    public Command getAutonomousCommand() {
        return Commands.print("The DodgerBot does not have an autonomous protocol");
    }
}
