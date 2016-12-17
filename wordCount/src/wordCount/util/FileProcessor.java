package wordCount.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class FileProcessor implements InputReaderInterface, OutputWriterInterface {

	private FileChannel fileChannel;
	private RandomAccessFile randomaccessfile;
	private MappedByteBuffer buffer;
	private static List<Character> delimiter = Arrays.asList('\n','\r');
	
	public FileProcessor(String filenameIn, String fileModeIn){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR, "FileProcessor Constructor is in execution");
		
		try {
			 randomaccessfile = new RandomAccessFile(filenameIn, "rw");
			 fileChannel = randomaccessfile.getChannel();
			 buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
		} catch (FileNotFoundException e) {
			System.err.println("Error while creating a File");
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error while creating MappedByteBuffer");
			e.printStackTrace();
			System.exit(1);
		} 
	}
	

	/**
	 * Reads the input file and returns all the words in
	 * a file as a List of Strings
	 * @return List<Strings>
	 */
	@Override
	public List<String> read() {
		
		List<String> words = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char ch=0;
		
		for(int i=0; i< buffer.capacity(); i++){
			ch = (char)buffer.get(i);
			
			if(ch == ' ' || ch == '\t' || isDelimiter(ch)){
				words.add(sb.toString());	
				sb = new StringBuilder();
			}
			else{
				sb = sb.append(ch);
			 }
		 }
		return words;
	}
	
	
	
	
	/**
	 * Checks whether the character is delimiter
	 * @param ch
	 * @return
	 */
	private boolean isDelimiter(char ch) {
		return delimiter.contains(ch);
	}


	/**
	 * Writes to the output file
	 */
	@Override
	public void write(String s) {
		int size = s.getBytes().length;
		try {
			randomaccessfile.setLength(randomaccessfile.length());
			buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, fileChannel.position(), size);
			buffer.put(s.getBytes());
		} catch (IOException e) {
			System.err.println("Error Occured while Writing to an Output File");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	/**
	 * Closes the file i.e,Returning resources to the System
	 * 
	 */
	@Override
	public void close() {
		try {
			randomaccessfile.close();
		} catch (IOException e) {
			System.err.println("Error while closing the File");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
