package org.usfirst.frc.team4161.robot;

public class ConversionFactor {

	public static double ftPerTick = 1/10, powerBase = 5;

	
	/**
	 * Returns the estimated velocity of the specified power percentage in ft/tick.
	 * 
	 * @param powerPercentage Percentage power. In range [0,100]
	 * @return The differential of position, in ft/tick
	 */
	private double getVelocity(int powerPercentage){
		return ftPerTick*Math.pow(powerBase, (powerPercentage/100.0));
	}


	/**
	 * Given the desired distance, returns the number of (estimated) ticks to
	 * drive robot at full power.
	 * 
	 * @param feet
	 *            Desired distance to drive robot. Negatives are ignored
	 * @return The number of (estimated) ticks to drive for.
	 */
	public static double feetToTick(double feet) {
		return Math.abs(Math.round(Math.abs(feet)/ftPerTick));
	}

}
