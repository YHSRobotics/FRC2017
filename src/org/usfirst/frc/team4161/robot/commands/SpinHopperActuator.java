package org.usfirst.frc.team4161.robot.commands;

import org.usfirst.frc.team4161.robot.Robot;
import org.usfirst.frc.team4161.robot.RobotMap;
import org.usfirst.frc.team4161.robot.subsystems.HopperActuator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinHopperActuator extends Command {

	double speed;
	HopperActuator actuator = Robot.hopperActuator;
	
    public SpinHopperActuator(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	requires(actuator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	actuator.setIntensity(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	actuator.setIntensity(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	actuator.setIntensity(0);
    }
}
