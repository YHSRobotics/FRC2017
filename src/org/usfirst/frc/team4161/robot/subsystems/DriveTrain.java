package org.usfirst.frc.team4161.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4161.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	Spark L = RobotMap.LWheels, R = RobotMap.RWheels;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	/**
	 * Set the speed of the left and right drive train components.
	 * 
	 * @param left Speed of the left wheels from -1.0 to 1.0
	 * @param right Speed of the right wheels from -1.0 to 1.0
	 */
	public void setDrive(double left, double right){
		L.set(left);
		R.set(right);//set the speed of the motors.
	}
	
	/**
	 * Stop the wheels in place.
	 */
	public void stopDrive(){
		L.set(0);
		R.set(0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
