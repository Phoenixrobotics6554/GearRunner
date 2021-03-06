package org.usfirst.frc6554.GearRunner.recordable;

import java.io.Serializable;

/**
 * This interface defines something whose actions can be recorded and played back<br/>
 * Use a {@link Recorder} to handle recording and playing back the actions of some {@link Recordable}
 * @author CubeMaster007
 * 
 * @param <T> the type of Object that is a single snapshot in a recording
 */
public interface Recordable<T> extends Serializable {
	
	/**
	 * @return a signle snapshot in a recording
	 */
	T record();
	/**
	 * @param action the action to be replicated
	 */
	void repeat(T action);
	
}
