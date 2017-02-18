package org.usfirst.frc.team4161.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that controls the hopper actuator.
 */
public class HopperActuator extends Subsystem {

	private Talon motor;

	public HopperActuator(Talon motorController){
		motor = motorController;
	}
	
	/**
	 * Sets the intensity of the actuation.
	 * @param speed Intensity, in range [0,1]
	 */
	public void setIntensity(double speed){
		motor.setSpeed(Math.abs(speed*0.75));
	}
	
	/**
	 * Stops the actuation of the motor.
	 */
	public void stopActuation(){
		setIntensity(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

