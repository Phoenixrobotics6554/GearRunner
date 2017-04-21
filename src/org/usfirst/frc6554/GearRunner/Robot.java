// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc6554.GearRunner;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc6554.GearRunner.commands.*;
import org.usfirst.frc6554.GearRunner.subsystems.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static pusher pusher;
	public static Drivebase drivebase;
	public static Climber climber;
	public static LEDs lEDs;
	public static Timer timer = new Timer();

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	ADXRS450_Gyro gyro;
	public final double kp = 0.3;
	public boolean extended = false;

	public void robotInit() {
		RobotMap.init();
		// CameraServer server = CameraServer.getInstance();
		// server.startAutomaticCapture(0);
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		pusher = new pusher();
		drivebase = new Drivebase();
		climber = new Climber();
		lEDs = new LEDs();
		

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// ADXRS450_Gyro

		gyro = new ADXRS450_Gyro();
		gyro.reset();
		gyro.calibrate();
		CameraServer.getInstance().startAutomaticCapture();

		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.

		// CameraServer server = CameraServer.getInstance();
		// server.setSize(0);
		// server.startAutomaticCapture(0);
		// server.startAutomaticCapture();

		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		autonomousCommand = new AutonomousCommand();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		timer.reset();
		timer.start();
		
		 

		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

		double currenttime = timer.get();
		double angle = gyro.getAngle();
		// double lencoder = leftencoder.getValue();
		// double rencoder = rightencoder.getValue();


		

		if (currenttime > 0.5 && currenttime < 3.2) {
			//was at 4.7
			drivebase.arcadeDrive(-.7, (   - angle) * kp);
			Timer.delay(0.01); }
		
		if (currenttime > 3.4 && currenttime < 3.54) {
			//was at 4.7
			drivebase.arcadeDrive(1, (   - angle) * kp);
			Timer.delay(0.01); }

      /*
		if (currenttime > 4) {
			extended = true;
			pusher.extend();
		}
		
		if (currenttime > 4.5 && currenttime < 5.5) {
			
			drivebase.arcadeDrive(.7, -angle * kp);

			Timer.delay(0.01);
		}
//comment out if doing straight baseline
		       */
 
		Scheduler.getInstance().run();
      }

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		System.out.println(gyro.getAngle()); 
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
