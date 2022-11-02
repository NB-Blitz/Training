package org.team5148.training;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {

	CANSparkMax frontLeft = new CANSparkMax(1, MotorType.kBrushless);
	CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
	CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);
	CANSparkMax backRight = new CANSparkMax(4, MotorType.kBrushless);
	//CANSparkMax m_frontLeft = new CANSparkMax(1);
	//CANSparkMax m_rearLeft = new CANSparkMax(3);
	MotorControllerGroup m_left = new MotorControllerGroup(frontLeft , backLeft);
 
	//MotorControllerGroup m_frontRight = new MotorControllerGroup(2);
	//MotorControllerGroup m_rearRight = new MotorController(4);
	MotorControllerGroup m_right = new MotorControllerGroup(frontRight , backRight);
 
	ahrs = new AHRS(SerialPort.Port.kMXP); 
	

	//xbox controller
	XboxController driveController = new XboxController(0);

	//define a drive
	DifferentialDrive DDrive = new DifferentialDrive(m_left , m_right);

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
		
	 	
		
		Double LeftSpeed = driveController.getLeftY();
		Double RightSpeed = driveController.getRightY();
		//Double Rotation = driveController.getRightY(); 
		DDrive.tankDrive(LeftSpeed , RightSpeed);
		//m_left.set(LeftSpeed);
		
	}
}


