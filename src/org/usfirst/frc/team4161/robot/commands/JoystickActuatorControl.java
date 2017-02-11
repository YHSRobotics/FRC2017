package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.subsystems.HopperActuator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickActuatorControl extends Command {

	private Joystick js;
	private HopperActuator actuator = Robot.hopperActuator;

	public JoystickActuatorControl(Joystick joystick) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		js = joystick;
		requires(Robot.hopperActuator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		actuator.stopActuation();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double power = js.getZ();//get power (in range [-1,1])
		
		power *= -1;//negate for natural feeling control
		
		//scale into range [0,1]
		power++;
		power /=2;
		actuator.setIntensity(power);
	}

	/**
	 * This command should never end. Will always return false.
	 */
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		actuator.stopActuation();
	}

	/**
	 * Emergency stops the actuation if interrupted
	 */
	protected void interrupted() {
		actuator.stopActuation();
	}
}
