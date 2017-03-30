package org.usfirst.frc.team4161.robot.subsystems;

import org.usfirst.frc.team4161.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class Sweeper extends Subsystem {
   
	Talon sweeper = RobotMap.sweeperMotor;
   // Put methods for controlling this subsystem
   // here. Call these from Commands.
	
	/**
	 * Set the speed of the collector wheels. A positive value indicates
	 * shooting, a negative value is pulling the ball in..
	 * 
	 * @param speed The speed of the ball collector wheels. Positive is shooting, negative is receiving.
	 */
	public void setSweeperSpeed(double speed) {

		sweeper.set(-speed);

	}
	
	public void stopSweeper(){
		sweeper.set(0);
	}
	
   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
}
