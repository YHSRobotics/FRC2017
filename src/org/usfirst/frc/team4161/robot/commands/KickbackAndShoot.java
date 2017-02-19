package org.usfirst.frc.team4161.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class KickbackAndShoot extends CommandGroup {

    public KickbackAndShoot(Joystick js) {
    	addSequential(new TimedShooter(5, -1));//kickback for 300 ticks
    	addSequential(new JoystickShooterControl(js));
    }
}
