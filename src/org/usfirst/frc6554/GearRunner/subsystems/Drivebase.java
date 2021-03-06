// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6554.GearRunner.subsystems;

import org.usfirst.frc6554.GearRunner.RobotMap;
import org.usfirst.frc6554.GearRunner.commands.*;

import org.usfirst.frc6554.GearRunner.recordable.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivebase extends Subsystem implements Recordable<DriveTrainState>{

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rightSide = RobotMap.drivebaserightSide;
    private final SpeedController leftSide = RobotMap.drivebaseleftSide;
    private final RobotDrive robotDrive = RobotMap.drivebaseRobotDrive;
  //  private final Encoder rightencoder =  new Encoder(); 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

      //  setDefaultCommand(new ArcadeDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDrive (double Speed, double Turn) {
    	robotDrive.arcadeDrive(Speed, Turn, true);
    
    	//might need to delete the extra "-" on the "oops.getX(); 
    	
    }
    
    public void driveStraight(double speed) {
    	robotDrive.tankDrive(speed, -speed);
    }

	@Override
	public DriveTrainState record() {
		return new DriveTrainState(leftSide.get(), rightSide.get());
	}

	@Override
	public void repeat(DriveTrainState action) {
		leftSide.set(action.left);
		rightSide.set(action.right);
	}
   
}

