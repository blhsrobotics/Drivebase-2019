package org.usfirst.frc.team3218.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	
	XboxController xbox = new XboxController(RobotMap.xboxPort);
	
	JoystickButton aButton = new JoystickButton(xbox, RobotMap.aButtonPort);
	
	
	
	public double getLeftJoystickY() { 
		return xbox.getY(Hand.kLeft);
	}
	
	public double getLeftJoystickZ() {
		return xbox.getX(Hand.kLeft);
	}
}
