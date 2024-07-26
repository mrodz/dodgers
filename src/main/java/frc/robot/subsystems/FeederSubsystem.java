package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.StoppableSubsystemBase;

import static frc.robot.Constants.*;

public class FeederSubsystem extends StoppableSubsystemBase {
  private final TalonSRX feederMotor;

  public FeederSubsystem() {
    this.feederMotor = new TalonSRX(ID.FEEDER);
    this.feederMotor.setInverted(true);
  }

  public void set(double percentOutput) {
    this.feederMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
  }

  @Override
  public void stop() {
    this.set(0);
  }
}
