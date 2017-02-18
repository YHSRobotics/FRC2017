package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedShooter extends Command {

	private Shooter shooter = Robot.shooter;
	private int tick, totalTicks;
	private double power;

	public TimedShooter(int ticksToRun, double power) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		totalTicks = ticksToRun;
		this.power = power;
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		shooter.setShooterSpeed(power);
		tick = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		tick++;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (tick >= totalTicks);
	}

	// Called once after isFinished returns true
	protected void end() {
		shooter.stopShot();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		shooter.stopShot();
	}
}
