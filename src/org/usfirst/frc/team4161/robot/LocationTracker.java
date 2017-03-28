package org.usfirst.frc.team4161.robot;

public class LocationTracker {

	private double x = 0, y = 0;

	/**
	 * Called every tick to estimate the position of the robot.
	 */
	public void update() {

	}

	/**
	 * Wrapper class for the position of the robot. Holds the X, Y, and
	 * direction faced.
	 * 
	 * @author Micah Raney
	 *
	 */
	public static class Position {

		private double x, y, direction;

		/**
		 * initializes the direction with the specified coordinates.
		 * 
		 * @param x
		 *            The position on the X axis
		 * @param y
		 *            the position on the Y axis
		 * @param direction
		 *            The direction faced, in degrees 0 - positive x 90 -
		 *            positive y 180 - negative x 270 - negative y
		 */
		public Position(double x, double y, double direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		/**
		 * Returns the position on the x axis.
		 * 
		 * @return Position on X Axis
		 */
		public double getX() {
			return x;
		}

		/**
		 * Returns the position on the y axis.
		 * 
		 * @return Position on Y Axis
		 */
		public double getY() {
			return y;
		}

		/**
		 * Returns the direction faced
		 * 
		 * @return Angle faced in degrees
		 */
		public double getDirection() {
			return direction;
		}
	}

}
