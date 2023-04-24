/***************************************************************
                The Sentinels - FRC Team 5599
        Benjamin N. Cardozo High School Robotics Team

    This work is licensed under the terms of the MIT license.
    Copyright (c) 2023 The Sentinels. All rights reserved.
***************************************************************/

package com.sentinels.robot.commands.autonomous;

import com.sentinels.robot.commands.autonomous.driving.AutonTimedDrive;
import com.sentinels.robot.subsystems.drive.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {

  public static CommandBase simpleTimedDrive(Drivetrain drivetrain, double seconds) {
    return Commands.sequence(
      new AutonTimedDrive(drivetrain, false).withTimeout(seconds)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
