package org.usfirst.frc.team4161.robot;

import org.usfirst.frc.team4161.robot.sensors.UltrasonicSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	//public static int leftMotor = 1;
	//public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	private final static int LWheelsID = 0, RWheelsID = 1, HopperActuatorID = 2, ShooterMotorID = 3,
			SweeperMotorID = 4;
	
	public static Spark LWheels = new Spark(LWheelsID), RWheels = new Spark(RWheelsID);
	
	public static Talon HopperActuator = new Talon(HopperActuatorID);
	
	public static Talon shooterMotor = new Talon(ShooterMotorID), sweeperMotor = new Talon(SweeperMotorID);
	
	public static UltrasonicSensor ultrasonic = new UltrasonicSensor(new AnalogInput(0)); 
}