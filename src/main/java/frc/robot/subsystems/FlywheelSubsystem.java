package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.StoppableSubsystemBase;

import static frc.robot.Constants.*;

public class FlywheelSubsystem extends StoppableSubsystemBase {
  private final TalonSRX flywheelLead = new TalonSRX(ID.FLYWHEEL_LEAD);
  private final TalonSRX flywheelFollower = new TalonSRX(ID.FLYWHEEL_FOLLOW);
  private final SlewRateLimiter flywheelSlewRateLimiter = new SlewRateLimiter(0.3);

  public FlywheelSubsystem() {
    this.flywheelLead.setInverted(true);
    this.flywheelFollower.follow(this.flywheelLead);

    SmartDashboard.putNumber("Flywheel Speed", DEFAULT_FLYWHEEL_SPEED);
  }

  public void slewLimitedSet(double percentOutput) {
    this.set(this.flywheelSlewRateLimiter.calculate(percentOutput));
  }

  public void set(double percentOutput) {
    this.flywheelLead.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }

  @Override
  public void stop() {
    this.set(0);
  }
}
