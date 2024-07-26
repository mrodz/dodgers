package frc.robot;

public final class Constants {
  public static final int CONTROLLER_PORT = 0;
  public static final double CONTROLLER_DEAD_ZONE = 0.05;

  public static class ID {
    public static final int LEFT_LEAD = 1;
    public static final int LEFT_FOLLOW = 2;
    public static final int LEFT_FOLLOW_2 = 3;

    public static final int RIGHT_LEAD = 4;
    public static final int RIGHT_FOLLOW = 5;
    public static final int RIGHT_FOLLOW_2 = 6;

    public static final int FEEDER = 7;

    public static final int FLYWHEEL_LEAD = 9;
    public static final int FLYWHEEL_FOLLOW = 10;

    public static final int TURRET = 11;
  }

  public static final double DEFAULT_FLYWHEEL_SPEED = 0.72;
  public static final double TURRET_SPEED = 0.3;
  public static final double FEEDER_SPEED = 0.4;
}
