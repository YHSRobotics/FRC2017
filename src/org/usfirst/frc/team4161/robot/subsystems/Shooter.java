package org.usfirst.frc.team4161.robot.subsystems;

import org.usfirst.frc.team4161.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class Shooter extends Subsystem {
   
	Talon ballShooter = RobotMap.BallCollector;
   // Put methods for controlling this subsystem
   // here. Call these from Commands.
	
	/**
	 * Set the speed of the collector wheels. A positive value indicates
	 * shooting, a negative value is pulling the ball in..
	 * 
	 * @param speed The speed of the ball collector wheels. Positive is shooting, negative is receiving.
	 */
	public void setShooterSpeed(double speed) {

		ballShooter.set(speed/2);

	}
	
	public void stopShot(){
		ballShooter.set(0);
	}
	
   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
}
