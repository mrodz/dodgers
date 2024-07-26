package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.StoppableSubsystemBase;

import static frc.robot.Constants.*;

public class DriveBase extends StoppableSubsystemBase {
  private final TalonSRX leftLead = new TalonSRX(ID.LEFT_LEAD);
  private final TalonSRX leftFollow1 = new TalonSRX(ID.LEFT_FOLLOW);
  private final TalonSRX leftFollow2 = new TalonSRX(ID.LEFT_FOLLOW_2);

  private final TalonSRX rightLead = new TalonSRX(ID.RIGHT_LEAD);
  private final TalonSRX rightFollow1 = new TalonSRX(ID.RIGHT_FOLLOW);
  private final TalonSRX rightFollow2 = new TalonSRX(ID.RIGHT_FOLLOW_2);

  public DriveBase() {
    this.leftFollow1.follow(this.leftLead);
    this.leftFollow2.follow(this.leftLead);
    this.rightFollow1.follow(this.rightLead);
    this.rightFollow2.follow(this.rightLead);

    this.leftFollow1.setInverted(InvertType.FollowMaster);
    this.leftFollow2.setInverted(InvertType.FollowMaster);
    this.leftLead.setInverted(true);
  }

  public void setRight(double percentOutput) {
    this.rightLead.set(ControlMode.PercentOutput, percentOutput);
  }

  public void setLeft(double percentOutput) {
    this.leftLead.set(ControlMode.PercentOutput, percentOutput);
  }

  @Override
  public void stop() {
    this.setLeft(0);
    this.setRight(0);
  }
}
