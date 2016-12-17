package wordCount.util;

import java.util.List;

/**
 * This Interface defines methods which are needed to perform
 * the input file read operations
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface InputReaderInterface {
	
	/**
	 * Reads the input file and returns all the words as strings
	 * @return List
	 */
	public List<String> read();
	
	/**
	 * This method is to return the resources to the system
	 */
	public void close();
	
}
