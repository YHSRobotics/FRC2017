package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooter extends Command {

	private int ticks = 0;

	/**
	 * Runs the shooter automatically for the number of ticks.
	 * 
	 * @param ticks
	 */
	public AutoShooter(int ticks) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
		requires(Robot.hopperActuator);
		this.ticks = ticks;
	}
	
	/**
	 * Runs the shooter automatically for the number of ticks.
	 * 
	 * @param ticks
	 */
	public AutoShooter() {
		this(Integer.MAX_VALUE);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.shooter.setShooterSpeed(1);
		Robot.hopperActuator.setIntensity(0.8);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return ticks <= 0;
	}

	// Called once after isFinished returns true
	protected void end() {
		ticks = 0;
		Robot.shooter.setShooterSpeed(0);
		Robot.hopperActuator.setIntensity(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
