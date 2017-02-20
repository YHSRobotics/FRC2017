package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.subsystems.Shooter;
import org.usfirst.frc.team4161.robot.subsystems.Sweeper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickSweeperControl extends Command {

	private Joystick js;
	private Sweeper sweeper= Robot.sweeper;
	private boolean reverse;
	private double scaling;

	public JoystickSweeperControl(Joystick joystick){
		this(joystick, 1, false);
	}
	
	public JoystickSweeperControl(Joystick joystick, double scaling, boolean reverse) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		js = joystick;
		this.reverse = reverse;
		this.scaling = scaling;
		if(scaling < 0 || scaling > 1)
			throw new IllegalArgumentException("Scaling must be in range [0,1]! Invalid: " + scaling);
		requires(sweeper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		sweeper.stopSweeper();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double power = js.getZ();//get power (in range [-1,1])
		
		power *= -scaling;//negate and scale for natural feeling control
		
		//scale into range [0,1]
		power++;
		power /=2;
		sweeper.setSweeperSpeed(reverse?-power:power);//set the power (reverse if set)
//		System.out.println("pow: " + power + " rev: " + reverse);
	}

	/**
	 * This command should never end. Will always return false.
	 */
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		sweeper.stopSweeper();
	}

	/**
	 * Emergency stops the shooter if interrupted
	 */
	protected void interrupted() {
		sweeper.stopSweeper();
	}
}
