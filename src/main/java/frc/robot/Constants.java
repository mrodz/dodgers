// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int controllerPort = 0;
    // Deadzone
    public static final double controllerDeadZone = 0.05;

    // Joystick Axis IDs
    public static final int LeftXAxis = 0;
    public static final int LeftYAxis = 1;
    public static final int RightXAxis = 2;
    public static final int RightYAxis = 3;

    // Joystick Axis IDs
    public static final int XboxLeftYAxis = 1;
    public static final int XboxRightYAxis = 5;
    public static final int XboxLeftXAxis = 0;
    public static final int XboxRightXAxis = 4;

    // Logitech Button Constants
    public static final int LogitechButtonX = 1;
    public static final int LogitechButtonA = 2;
    public static final int LogitechButtonB = 3;
    public static final int LogitechButtonY = 4;
    public static final int LogitechLeftBumper = 5;
    public static final int LogitechRightBumper = 6;
    public static final int LogitechLeftTrigger = 7;
    public static final int LogitechRightTrigger = 8;

    // Motor IDs - Make sure to double check
    public static final int leftLeadID = 1;
    public static final int leftFollow1ID = 2;
    public static final int leftFollow2ID = 3;

    public static final int rightLeadID = 4;
    public static final int rightFollow1ID = 5;
    public static final int rightFollow2ID = 6;

    public static final int IndexerMotorID = 7;

    public static final int HoodMotorID = 8;

    public static final int flywheelLeadMotorID = 9;
    public static final int FlywheelFollwerMotorID = 10;

    public static final int TurretMotorID = 11;

    // Motor Speeds
    public static final double FlywheelSpeed = 0.75;
    public static final double HoodMoveSpeed = 0.1;
    public static final double TurretMoveSpeed = 0.3;
    public static final double IndexerSpeed = 0.4;

}
