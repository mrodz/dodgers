package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;

public class MoveTurret extends Command {
    private final Turret turret;
    private final double speed;

    public MoveTurret(Turret turret, double speed) {
        this.turret = turret;
        this.speed = speed;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        turret.setSpeed(speed);
    }
}
