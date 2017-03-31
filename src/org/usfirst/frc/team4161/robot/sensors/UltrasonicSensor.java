package org.usfirst.frc.team4161.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Ultrasonic sensor wrapper library for the MB1013 Ultrasonic Sensor. 
 * @author Micah Raney
 *
 */
public class UltrasonicSensor {

	private AnalogInput ultrasonic;
	/**
	 * The number of bits of oversampling, as described in the AnalogInput api.
	 * Average sets the average number of bits.
	 */
	private static int oversample = 1, average = 1;
	
	/**
	 * millimeters per volt.
	 */
	private double scalingFactor = 5120/5;

	/**
	 * Initializes the Ultrasonic sensor based on the given analog port.
	 * @param analogPort Analog port that the sensor is based on.
	 */
	public UltrasonicSensor(AnalogInput analogPort) {
		ultrasonic = analogPort;
		ultrasonic.setOversampleBits(oversample);
		ultrasonic.setAverageBits(average);
	}
	
	
	/**
	 * Returns the sensed distance, in meters.
	 * @return Meter distance sensed by the sensor
	 */
	public double getMDistance(){
		double distance = ultrasonic.getAverageVoltage();
		distance *= scalingFactor;//scale to millimeters`
		distance /= 1000;//scale to meters
		return distance;
	}
	
	

}
