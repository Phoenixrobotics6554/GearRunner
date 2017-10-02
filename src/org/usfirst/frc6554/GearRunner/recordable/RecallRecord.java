package org.usfirst.frc6554.GearRunner.recordable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.wpi.first.wpilibj.command.Command;

public class RecallRecord extends Command {
	
	Recorder<DriveTrainState> rec;
	String fileName;
	
	public RecallRecord(Recorder<DriveTrainState> rec, String filename) {
		this.rec = rec;
		fileName = filename;
	}
	
	@Override
	protected void initialize() {
		try {
			try {
				rec = (Recorder<DriveTrainState>) Recorder.recall(new FileInputStream(fileName));
				System.out.println("successfully recalled");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("class not found");
			}
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
