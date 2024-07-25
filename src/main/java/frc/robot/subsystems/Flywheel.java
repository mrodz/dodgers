package frc.robot.subsystems;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandStopAction;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Flywheel extends SubsystemBase implements CommandStopAction {
    private TalonSRX flywheelLead;
    private TalonSRX flywheelFollower;

    private SlewRateLimiter flywheelSlewRateLimiter;

    /** Creates a new Shooter. */
    public Flywheel() {
        flywheelLead = new TalonSRX(flywheelLeadMotorID);
        flywheelFollower = new TalonSRX(FlywheelFollwerMotorID);

        flywheelSlewRateLimiter = new SlewRateLimiter(0.2);

        flywheelLead.setInverted(true);
        flywheelFollower.follow(flywheelLead);

        SmartDashboard.putNumber("Flywheel Speed", FlywheelSpeed);
    }

    public void stop() {
        flywheelLead.set(TalonSRXControlMode.PercentOutput, 0);
    }

    public void slewLimitedSpin(double speed) {
        flywheelLead.set(TalonSRXControlMode.PercentOutput, flywheelSlewRateLimiter.calculate(speed));
    }

    public void slewLimitedSpin(double speed, SlewRateLimiter rateLimiter) {
        flywheelLead.set(TalonSRXControlMode.PercentOutput, rateLimiter.calculate(speed));
    }

    public void spin(double speed) {
        flywheelLead.set(TalonSRXControlMode.PercentOutput, speed);
    }

    @Override
    public Command stopAction() {
        return Commands.run(() -> this.stop(), this);
    }
}
