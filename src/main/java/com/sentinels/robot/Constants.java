/***************************************************************
                The Sentinels - FRC Team 5599
        Benjamin N. Cardozo High School Robotics Team

    This work is licensed under the terms of the MIT license.
    Copyright (c) 2023 The Sentinels. All rights reserved.
***************************************************************/

package com.sentinels.robot;

public interface Constants {

  public interface Ports {
    // Controllers
    int kDriverController = 0;
    int kOperatorController = 1;

    // Motors
    int FRONTLEFT = 1;
    int BACKLEFT = 2;

    int FRONTRIGHT = 3;
    int BACKRIGHT = 4;
  }

  public interface Drivetrain {
    double kDriveSpeedCap = 0.7;
    double kTimedDriveVoltage = 2.5;
    double kTimedDriveTime = 3;
  }
}
