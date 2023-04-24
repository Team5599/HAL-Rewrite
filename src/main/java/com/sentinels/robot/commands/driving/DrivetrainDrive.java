/***************************************************************
                The Sentinels - FRC Team 5599
        Benjamin N. Cardozo High School Robotics Team

    This work is licensed under the terms of the MIT license.
    Copyright (c) 2023 The Sentinels. All rights reserved.
***************************************************************/

package com.sentinels.robot.commands.driving;

import com.sentinels.robot.subsystems.drive.Drivetrain;
import com.sentinels.robot.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DrivetrainDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final Drivetrain drivetrain;
  private final CommandXboxController driver;

  private double driverLeftY;
  private double driverRightY;
  private double driverLeftX;
  private Boolean arcadeDriveActive;
  private final double driveSpeedCap;

  public DrivetrainDrive(Drivetrain drivetrain, CommandXboxController driver, boolean arcadeDriveActive) {
    this.drivetrain = drivetrain;
    this.driver = driver;
    this.arcadeDriveActive = arcadeDriveActive;
    this.driveSpeedCap = Constants.Drivetrain.kDriveSpeedCap;

    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    driverLeftX = 0;
    driverRightY = 0;
    driverLeftY = 0;
  }

  @Override
  public void execute() {
    driverLeftY = driver.getLeftY();
    driverRightY = driver.getRightY();
    driverLeftX = driver.getLeftX();

    if (arcadeDriveActive) {
      drivetrain.arcadeDrive(driverRightY * driveSpeedCap, driverLeftX * driveSpeedCap);
    } else {
      drivetrain.tankDrive(driverLeftY * driveSpeedCap, driverRightY * driveSpeedCap);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
