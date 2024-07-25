package frc.robot.subsystems;

import static frc.robot.Constants.leftFollow1ID;
import static frc.robot.Constants.leftFollow2ID;
import static frc.robot.Constants.leftLeadID;
import static frc.robot.Constants.rightFollow1ID;
import static frc.robot.Constants.rightFollow2ID;
import static frc.robot.Constants.rightLeadID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CommandStopAction;

public class Drivebase extends SubsystemBase implements CommandStopAction {
    private TalonSRX leftLead;
    private TalonSRX leftFollow1;
    private TalonSRX leftFollow2;

    private TalonSRX rightLead;
    private TalonSRX rightFollow1;
    private TalonSRX rightFollow2;

    public Drivebase() {
        leftLead = new TalonSRX(leftLeadID);
        leftFollow1 = new TalonSRX(leftFollow1ID);
        leftFollow2 = new TalonSRX(leftFollow2ID);

        rightLead = new TalonSRX(rightLeadID);
        rightFollow1 = new TalonSRX(rightFollow1ID);
        rightFollow2 = new TalonSRX(rightFollow2ID);

        leftFollow1.follow(leftLead);
        leftFollow2.follow(leftLead);
        rightFollow1.follow(rightLead);
        rightFollow2.follow(rightLead);

        leftFollow1.setInverted(InvertType.FollowMaster);
        leftFollow2.setInverted(InvertType.FollowMaster);
        leftLead.setInverted(true);
    }

    public void drive(double left, double right) {
        leftLead.set(ControlMode.PercentOutput, left);
        rightLead.set(ControlMode.PercentOutput, right);
    }

    public void setRight(double speed) {
        rightLead.set(ControlMode.PercentOutput, speed);
    }

    public void setLeft(double speed) {
        leftLead.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public Command stopAction() {
        return Commands.run(() -> this.drive(0, 0), this);
    }
}
