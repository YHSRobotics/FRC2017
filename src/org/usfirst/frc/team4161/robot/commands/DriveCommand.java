package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.RobotMap;
import org.usfirst.frc.team4161.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

	private DriveTrain driveTrain = Robot.driveTrain;

	private int ticks;
	private double lPower, rPower;
	private Preferences prefs;

	/**
	 * Makes the robot drive at the given wheel powers. A negative power will
	 * make the tread go backwards.
	 * 
	 * @param ticks
	 *            Ticks to drive for.
	 * @param maxPower
	 *            Maximum power to use. Must be in range [0, 1] (NOTE: 0 will
	 *            not go anywhere).
	 */
	public DriveCommand(int ticks, double lPower, double rPower) {
		requires(driveTrain);
		this.ticks = ticks;
		this.lPower = lPower;
		this.rPower = rPower;//initialize the wheel powers
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("DriveStraight: Commanded to drive straight for " + ticks + " ticks.");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		ticks--;
		driveTrain.setDrive(lPower, rPower);// go straight.
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return ticks <= 0;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
