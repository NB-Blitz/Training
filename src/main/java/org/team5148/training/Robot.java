package org.team5148.training;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SerialPort;
//import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {

	CANSparkMax frontLeft = new CANSparkMax(1, MotorType.kBrushless);
	CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
	CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
	CANSparkMax backRight = new CANSparkMax(4, MotorType.kBrushless);
	//CANSparkMax m_frontLeft = new CANSparkMax(1);
	//CANSparkMax m_rearLeft = new CANSparkMax(3);
	MotorControllerGroup m_left = new MotorControllerGroup(frontLeft , frontRight , backRight , backLeft);
 
	//MotorControllerGroup m_frontRight = new MotorControllerGroup(2);
	//MotorControllerGroup m_rearRight = new MotorController(4);
	MotorControllerGroup m_right = new MotorControllerGroup(frontRight , backRight);
 
	AHRS ahrs = new AHRS(SerialPort.Port.kMXP); 
	
	double accelX;
	double accelY;
	double accelZ;
	double angle;
	//xbox controller
	XboxController driveController = new XboxController(0);

	//define a drive
	MecanumDrive MDrive = new MecanumDrive(frontLeft , backLeft , frontRight , backRight);

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {
		frontRight.setInverted(true);
		backRight.setInverted(true);
		
	}

	@Override
	public void teleopPeriodic() {
		//use controller input to set drive system
		
	 	accelX = ahrs.getWorldLinearAccelX();
		accelY = ahrs.getWorldLinearAccelY();
		accelZ = ahrs.getWorldLinearAccelZ();
		angle = ahrs.getAngle();
		SmartDashboard.putNumber("accelX", accelX);
		SmartDashboard.putNumber("angle", angle);
		
		Double ySpeed = driveController.getLeftY();
		Double xSpeed = driveController.getRightY();
		//Double Rotation = driveController.getRightY(); 
		MDrive.driveCartesian(ySpeed, xSpeed, zRotation);
		//m_left.set(LeftSpeed);
		
	}
}


