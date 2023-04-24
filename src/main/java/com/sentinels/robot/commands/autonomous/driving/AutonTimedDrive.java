/***************************************************************
                The Sentinels - FRC Team 5599
        Benjamin N. Cardozo High School Robotics Team

    This work is licensed under the terms of the MIT license.
    Copyright (c) 2023 The Sentinels. All rights reserved.
***************************************************************/

package com.sentinels.robot.commands.autonomous.driving;

import com.sentinels.robot.subsystems.drive.Drivetrain;
import com.sentinels.robot.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonTimedDrive extends CommandBase {

  private Drivetrain drivetrain;
  private boolean reverseEnabled;
  private final double timedDriveVoltage;

  public AutonTimedDrive(Drivetrain drivetrain, boolean reverseEnabled) {
    this.drivetrain = drivetrain;
    this.reverseEnabled = reverseEnabled;
    this.timedDriveVoltage = Constants.Drivetrain.kTimedDriveVoltage;

    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (reverseEnabled) {
      drivetrain.voltageDrive(-timedDriveVoltage, -timedDriveVoltage);
    } else {
      drivetrain.voltageDrive(timedDriveVoltage, timedDriveVoltage);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}