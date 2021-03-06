// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final Drivetrain drivetrain = new Drivetrain();

  private final XboxController xbx = new XboxController(1);

  private final Shooter shooter = new Shooter();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();


    drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.drive
      ((xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft) < -0.3?xbx.getY(GenericHID.Hand.kLeft):0), 
      (xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft) < -0.3?xbx.getY(GenericHID.Hand.kLeft):0),
      (xbx.getX(GenericHID.Hand.kRight) > 0.3?xbx.getX(GenericHID.Hand.kRight):xbx.getX(GenericHID.Hand.kRight) < -0.3?xbx.getX(GenericHID.Hand.kRight):0)),drivetrain));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings(){
    new JoystickButton(xbx, Button.kA.value).whileHeld(() -> shooter.shoot(1)).whenReleased(() -> shooter.shootStop());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
