package frc.robot.subsystems;

import static frc.robot.Constants.IndexerMotorID;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandStopAction;

public class Indexer extends SubsystemBase implements CommandStopAction {
  private TalonSRX indexer;

  public Indexer() {
    this.indexer = new TalonSRX(IndexerMotorID);
    this.indexer.setInverted(true);
  }

  public void spin(double speed) {
    this.indexer.set(TalonSRXControlMode.PercentOutput, speed);
  }

  @Override
  public Command stopAction() {
    return Commands.run(() -> this.spin(0), this);
  }
}
