package wordCount.util;

/**
 * This Interface deifnes the methods needed to
 * perform the write operations
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface OutputWriterInterface {
	
	/**
	 * Method to write to the output file
	 * 
	 */
	public void write(String s);
	
	
	/**
	 * Method is to return the resources to the system
	 */
	public void close();

}
