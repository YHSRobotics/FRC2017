package org.usfirst.frc.team4161.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4161.robot.commands.DriveStraight;
import org.usfirst.frc.team4161.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team4161.robot.commands.JoystickActuatorControl;
import org.usfirst.frc.team4161.robot.commands.JoystickShooterControl;
import org.usfirst.frc.team4161.robot.commands.JoystickSweeperControl;
import org.usfirst.frc.team4161.robot.commands.KickbackAndShoot;
import org.usfirst.frc.team4161.robot.commands.SpinHopperActuator;
import org.usfirst.frc.team4161.robot.commands.TurnRobot;
import org.usfirst.frc.team4161.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4161.robot.subsystems.HopperActuator;
import org.usfirst.frc.team4161.robot.subsystems.Shooter;
import org.usfirst.frc.team4161.robot.subsystems.Sweeper;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Sweeper sweeper = new Sweeper();
	public static final HopperActuator hopperActuator = new HopperActuator(RobotMap.HopperActuator);
	public static OI oi;

	Command autonomousCommand;
	Command driveWithJoystick, joystickActuatorControl;
	SendableChooser<Command> chooser = new SendableChooser<>();
	Preferences prefs;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		prefs = Preferences.getInstance();
		
		oi = new OI();
		RobotMap.RWheels.setInverted(true);//invert the right side.
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
//		SmartDashboard.putData("Drive With Joystick", new DriveWithJoystick(OI.DriveJoystick));
		
		//set the two buttons for hopper actuator control
		OI.lowHopperActuator.whileHeld(new SpinHopperActuator(0.75));
		OI.highHopperActuator.whileHeld(new SpinHopperActuator(1));
		OI.shooterButton.whileHeld(new KickbackAndShoot(OI.RJoystick));
		
		//forward sweeper control
		OI.sweeperButton.whileHeld(new JoystickSweeperControl(OI.LJoystick));
		//backwards sweeper (partial power) control.
		OI.sweeperReverseButton.whileHeld(new JoystickSweeperControl(OI.LJoystick, 1/2, true));
		
		//set up autonomous chooser
		chooser.addDefault("No Autonomous", null);
		chooser.addObject("Drive Straight", new DriveStraight(50, true));
		
//		prefs.putInt("DriveTickCount", 100);
//		prefs.putInt("TurnTickCount", 100);
		SmartDashboard.putData("Drive for x ticks", new DriveStraight(prefs));
		SmartDashboard.putData("Turn for x ticks", new TurnRobot(prefs));


		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		System.out.println("Running auto: " + autonomousCommand);
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Avg Ultrasonic: ", (RobotMap.lUltrasonic.getMDistance()+RobotMap.rUltrasonic.getMDistance()/2));
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		// start the autonomous commands.
		driveWithJoystick = new DriveWithJoystick(OI.LJoystick, OI.RJoystick);
		driveWithJoystick.start();// start it!
		
		//start the actuator control
		joystickActuatorControl = new JoystickActuatorControl(OI.LJoystick);
//		joystickActuatorControl.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		SmartDashboard.putNumber("L Ultrasonic: ", RobotMap.lUltrasonic.getMDistance());
		SmartDashboard.putNumber("R Ultrasonic: ", RobotMap.rUltrasonic.getMDistance());
		SmartDashboard.putNumber("Avg Ultrasonic: ", (RobotMap.lUltrasonic.getMDistance()+RobotMap.rUltrasonic.getMDistance())/2);
		SmartDashboard.putNumber("Sweeper Speed ", RobotMap.sweeperMotor.getSpeed());
		SmartDashboard.putNumber("Shooter Speed ", RobotMap.shooterMotor.getSpeed());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}