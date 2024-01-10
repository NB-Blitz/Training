// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems
    private final DriveSubsystem m_robotDrive = new DriveSubsystem();

    // The driver's controllers
    private final Joystick leftJoystick = new Joystick(0);
    private final Joystick righJoystick = new Joystick(1);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        m_robotDrive.setDefaultCommand(
            // The Y axis of the left stick controls the left side of the robot.
            // The Y axis of the right stick controls the right side of the robot.
            new RunCommand(() -> m_robotDrive.drive(
                -MathUtil.applyDeadband(leftJoystick.getY(), 0.1),
                -MathUtil.applyDeadband(righJoystick.getY(), 0.1)),
            m_robotDrive));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
     * subclasses ({@link Joystick} or {@link edu.wpi.first.wpilibj.XboxController}), and then
     * passing it to a {@link JoystickButton}.
     */
    private void configureButtonBindings() {
        // Set the left joystick's button 0 to make the robot stop.
        new JoystickButton(leftJoystick, 0)
            .whileTrue(new RunCommand(
                () -> m_robotDrive.brake(),
                m_robotDrive));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new InstantCommand();
    }
}
