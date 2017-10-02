package org.usfirst.frc6554.GearRunner.recordable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.wpi.first.wpilibj.command.Command;

public class SaveRecord extends Command {
	
	Recorder<DriveTrainState> rec;
	String fileName;
	
	public SaveRecord(Recorder<DriveTrainState> rec, String filename) {
		this.rec = rec;
		fileName = filename;
	}
	
	@Override
	protected void initialize() {
		try {
			Recorder.save(rec, new FileOutputStream(fileName));
			System.out.println("successfully saved");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("io error");
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
