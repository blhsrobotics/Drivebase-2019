package org.usfirst.frc.team3218.robot.subsystems;

import org.usfirst.frc.team3218.robot.RobotMap;
import org.usfirst.frc.team3218.robot.chassis.commands.DriveWithXbox;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Chassis extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	SpeedController leftTopMotor = new PWMTalonSRX(RobotMap.leftTopMotorPort);
	SpeedController rightTopMotor = new PWMTalonSRX(RobotMap.rightTopMotorPort);
	SpeedController leftBottomMotor = new PWMTalonSRX(RobotMap.leftBottomMotorPort);
	SpeedController rightBottomMotor = new PWMTalonSRX(RobotMap.rightBottomMotorPort);
	
	SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftTopMotor,leftBottomMotor);
	SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightTopMotor,rightBottomMotor);
	
	DifferentialDrive dDrive = new DifferentialDrive(leftMotors, rightMotors);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithXbox());
    }



    public void drive(double y, double z) {
    	if(y<.1 && y>-.1)
    		y=0;
    	if(z<.1 && z>-.1)
    		z=0;
    	dDrive.arcadeDrive(y, z, false);
    }

}

