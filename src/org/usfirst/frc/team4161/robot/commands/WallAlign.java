package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.AngleTools;
import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.RobotMap;
import org.usfirst.frc.team4161.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Aligns with a wall (or straight surface) using the left and right ultrasonic
 * sensors to seek proper alignment
 */
public class WallAlign extends Command {

	private double tolerance;// degree tolerance before quitting.
	private DriveTrain driveTrain = Robot.driveTrain;
	private boolean isDone = false, endless = false;

	/**
	 * Initializes a WallAlign command which makes the robot face perpendicular
	 * to a linear surface using the ultrasonic sensor. Once the robot gets
	 * within +-3 degrees of the desired angle, the command quits.
	 */
	public WallAlign() {
		this(3, false);
	}

	/**
	 * Initializes a WallAlign command which makes the robot face perpendicular
	 * to a linear surface using the ultrasonic sensor. Once the robot gets
	 * within +-tolerance degrees of the desired angle, the command quits unless
	 * the endless option is specified.
	 * 
	 * @param tolerance The tolerance for error. The higher the number, the lower the accuracy. 
	 * @param endless If true, the command will never terminate.
	 */
	public WallAlign(double tolerance, boolean endless) {
		requires(Robot.driveTrain);
		this.endless = endless;
		this.tolerance = tolerance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double lDist = RobotMap.lUltrasonic.getMDistance(), rDist = RobotMap.rUltrasonic
				.getMDistance();

		// using trig to find the angle that the drivetrain is off.
		// a negative angle means a left turn is needed, a positive means right
		// turn.
		double angleDiff = Math.toDegrees(Math.atan((rDist - lDist)
				/ Robot.BODY_WIDTH)), power = AngleTools
				.computePower(angleDiff);

		if (Math.abs(angleDiff) <= tolerance) {// if within the tolerance range,
												// consider it done.
			driveTrain.setDrive(0, 0);
			isDone = true;
			return;
		}

		if (angleDiff < 0)// turn left
			driveTrain.setDrive(-1 * power, power);
		else
			driveTrain.setDrive(power, -1 * power);// turn right
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//if it is done and not endless, the command is over.
		return isDone && !endless;
	}

	// Called once after isFinished returns true
	protected void end() {
		driveTrain.setDrive(0, 0);//nullify leftover drive powers
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
