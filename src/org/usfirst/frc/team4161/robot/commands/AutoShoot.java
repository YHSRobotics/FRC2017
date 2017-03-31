package org.usfirst.frc.team4161.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShoot extends CommandGroup {

    public AutoShoot() {
    	addSequential(new DriveStraight(50,1));
    	addSequential(new TurnRobot(50,true));
    	addParallel(new AutoShooter());
    	addSequential(new TurnRobot(20,true,0.25));
    	addSequential(new TurnRobot(20,false,0.25));
    	addSequential(new TurnRobot(20,true,0.25));
    	addSequential(new TurnRobot(20,false,0.25));
    	addSequential(new TurnRobot(20,true,0.25));
    	addSequential(new TurnRobot(20,false,0.25));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
