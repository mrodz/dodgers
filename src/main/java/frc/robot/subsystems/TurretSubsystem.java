package frc.robot.subsystems;

import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.StoppableSubsystemBase;

import static frc.robot.Constants.*;

public class TurretSubsystem extends StoppableSubsystemBase {
  private final TalonFX turretMotor = new TalonFX(ID.TURRET);

  private final TalonFXConfiguration turretMotorConfig;
  private final SoftwareLimitSwitchConfigs limitSwitchConfigs;

  public TurretSubsystem() {
    this.turretMotor.setPosition(0);

    this.turretMotorConfig = new TalonFXConfiguration();

    this.limitSwitchConfigs = new SoftwareLimitSwitchConfigs()
        .withReverseSoftLimitEnable(true)
        .withReverseSoftLimitThreshold(turretRotationsToTurretMotorRotations(-0.45))
        .withForwardSoftLimitEnable(true)
        .withForwardSoftLimitThreshold(turretRotationsToTurretMotorRotations(0.45));

    this.turretMotor.getConfigurator().apply(this.turretMotorConfig);
    this.turretMotor.getConfigurator().apply(this.limitSwitchConfigs);
  }

  public static double turretRotationsToTurretMotorRotations(double turretRots) {
    return turretRots
        * 36.0 /* 36:1 gear ratio */
        / 20.0 /* 1:20 gear ratio */
        * 140.0 /* 140:1 gear ratio (approx) */;
  }

  public static double turretMotorRotationsToTurretRotations(double motorRots) {
    return motorRots
        / 36.0 /* 36:1 gear ratio */
        * 20.0 /* 1:20 gear ratio */
        / 140.0 /* 140:1 gear ratio (approx) */;
  }

  public void set(double speed) {
    this.turretMotor.set(speed);
  }

  @Override
  public void stop() {
    this.set(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Rotations",
        turretMotorRotationsToTurretRotations(this.turretMotor.getPosition().getValueAsDouble()));
  }
}
