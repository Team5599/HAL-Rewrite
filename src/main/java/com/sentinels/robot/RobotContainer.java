/***************************************************************
                The Sentinels - FRC Team 5599
        Benjamin N. Cardozo High School Robotics Team

    This work is licensed under the terms of the MIT license.
    Copyright (c) 2023 The Sentinels. All rights reserved.
***************************************************************/

package com.sentinels.robot;

import com.sentinels.robot.Constants.Ports;
import com.sentinels.robot.commands.autonomous.Autos;
import com.sentinels.robot.commands.driving.DrivetrainDrive;
import com.sentinels.robot.subsystems.drive.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();

  // Input Devices
  private final CommandXboxController driver = new CommandXboxController(Ports.kDriverController);

  public static SendableChooser<Boolean> controlChooser = new SendableChooser<>();
  private static SendableChooser<Command> autonChooser = new SendableChooser<>();
  private boolean arcadeDriveActive;
  
  public RobotContainer() {
    configureDriverBindings();
    configureDefaultCommands();
    configureAutonCommands();

    DriverStation.silenceJoystickConnectionWarning(true);
  }

  private void configureDriverBindings() {
    controlChooser.setDefaultOption("Tank Drive", false);
    controlChooser.addOption("Tank Drive", false);
    controlChooser.addOption("Arcade Drive", true);

    SmartDashboard.putData("Control Scheme", controlChooser);
    arcadeDriveActive = controlChooser.getSelected();
  }

  private void configureDefaultCommands() {
    drivetrain.setDefaultCommand(new DrivetrainDrive(drivetrain, driver, arcadeDriveActive));
  }

  private void configureAutonCommands() {
    autonChooser.addOption("Simple Drive Forward", Autos.simpleTimedDrive(drivetrain, Constants.Drivetrain.kTimedDriveTime));
    autonChooser.setDefaultOption("Simple Drive Forward", Autos.simpleTimedDrive(drivetrain, Constants.Drivetrain.kTimedDriveTime));
    
    SmartDashboard.putData("Selected Autonomous", autonChooser);
  }

  public Command getAutonomousCommand() {
    return autonChooser.getSelected();
  }
}
