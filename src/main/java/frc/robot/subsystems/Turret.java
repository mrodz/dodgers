package frc.robot.subsystems;

import static frc.robot.Constants.TurretMotorID;

import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandStopAction;

public class Turret extends SubsystemBase implements CommandStopAction {
  private TalonFX turretMotor;
  private TalonFXConfiguration turretMotorConfig;
  private SoftwareLimitSwitchConfigs limitSwitchConfigs;
  private boolean limitsEnabled;

  /** Creates a new Turret. */
  public Turret() {
    turretMotor = new TalonFX(TurretMotorID);

    turretMotor.setPosition(0);
    turretMotorConfig = new TalonFXConfiguration();
    limitsEnabled = true;

    SmartDashboard.putBoolean("Turret encoder limits", this.limitsEnabled);
        this.limitSwitchConfigs = new SoftwareLimitSwitchConfigs()
                .withReverseSoftLimitEnable(this.limitsEnabled)
                .withReverseSoftLimitThreshold(turretRotationsToTurretMotorRotations(-0.45))
                .withForwardSoftLimitEnable(this.limitsEnabled)
                .withForwardSoftLimitThreshold(turretRotationsToTurretMotorRotations(0.45));

        turretMotor.getConfigurator().apply(this.turretMotorConfig);
        turretMotor.getConfigurator().apply(this.limitSwitchConfigs);
  }

  @Override
  public void periodic() {
     SmartDashboard.putNumber("Rotations", turretMotorRotationsToTurretRotations(this.turretMotor.getPosition().getValueAsDouble()));
  }

  public static double turretRotationsToTurretMotorRotations(double turretRots) {
    return turretRots
        * 36.0 /* 36:1 gear ratio */
        / 20.0 /* 1:20 gear ratio (maybe???) */
        * 140.0 /* 140:1 gear ratio (approx) */;
  }

  public static double turretMotorRotationsToTurretRotations(double motorRots) {
    return motorRots
        / 36.0 /* 36:1 gear ratio */
        * 20.0 /* 1:20 gear ratio (maybe???) */
        / 140.0 /* 140:1 gear ratio (approx) */;
  }
  
  public void setSpeed(double speed) {
    turretMotor.set(speed);
  }

  public boolean getLimitsEnabled() {
    return this.limitsEnabled;
  }

  @Override
  public Command stopAction() {
    return Commands.run(() -> this.setSpeed(0), this);
  }
}
