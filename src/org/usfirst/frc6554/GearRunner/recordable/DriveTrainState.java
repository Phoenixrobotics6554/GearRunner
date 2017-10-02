package org.usfirst.frc6554.GearRunner.recordable;

import java.io.Serializable;

public class DriveTrainState implements Serializable {
	
	public double left, right;
	
	public DriveTrainState(double left, double right) {
		this.left = left;
		this.right = right;
	}
	
}
