// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    // Create TalonSRX motor controllers
    private final TalonSRX frontLeft = new TalonSRX(1);
    private final TalonSRX frontRight = new TalonSRX(2);
    private final TalonSRX backLeft = new TalonSRX(3);
    private final TalonSRX backRight = new TalonSRX(4);

    // Create the speeds that will be set for each side
    private double leftSpeed = 0;
    private double rightSpeed = 0;

    /** Creates a new DriveSubsystem. */
    public DriveSubsystem() {}

    @Override
    public void periodic() {
        // Set each motor to its respective side's speed
        frontLeft.set(TalonSRXControlMode.PercentOutput, leftSpeed);
        frontRight.set(TalonSRXControlMode.PercentOutput, rightSpeed);
        backLeft.set(TalonSRXControlMode.PercentOutput, leftSpeed);
        backRight.set(TalonSRXControlMode.PercentOutput, rightSpeed);
    }

    /**
     * Method to drive the robot using joystick info.
     *
     * @param leftSpeed  Speed of the robot on the left side.
     * @param rightSpeed Speed of the robot on the right side.
     */
    public void drive(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = -rightSpeed;
    }

    /**
     * Stop all motors.
     */
    public void brake() {
        leftSpeed = 0;
        rightSpeed = 0;
    }
}
