package wordCount.driver;

import java.io.File;
import java.io.IOException;
import wordCount.bst.BST;
import wordCount.bst.TreeInterface;
import wordCount.util.FileProcessor;
import wordCount.util.InputReaderInterface;
import wordCount.util.Logger;
import wordCount.util.OutputWriterInterface;
import wordCount.util.Logger.debugLevels;
import wordCount.visitors.BackupVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.VisitorInterface;
import wordCount.visitors.WordCountVisitor;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class Driver {

	public static void main(String[] args) {
	    Driver driver = new Driver();
		if(!driver.validateInpurArgs(args)){
			System.exit(1);
		}
	    
		int no_iterations = Integer.parseInt(args[2]);
	    TreeInterface tree = null;
		TreeInterface backupTree = null;
		int updateVal = 4;
		Logger.setDebugLevel(1);
	    
		long startTime = System.currentTimeMillis();
		for(int i=0; i< no_iterations; i++){
			
			tree = new BST();
			backupTree = new BST();
			
			InputReaderInterface inputReader = new FileProcessor(args[0], "r");
			OutputWriterInterface outputWriter = new FileProcessor(args[1], "rw");
			
			VisitorInterface populateVisitor = new PopulateVisitor(inputReader);
			VisitorInterface wordCountVisitor = new WordCountVisitor(outputWriter);
			
			tree.accept(populateVisitor);
			tree.accept(wordCountVisitor);
			
			inputReader.close();
			outputWriter.close();
		}

		long finishTime = System.currentTimeMillis();
		long totalTime = (finishTime - startTime)/no_iterations;
		Logger.writeOutput(debugLevels.RESULT, "Amortized Time of Operation : "+totalTime +" mili seconds");
		
		VisitorInterface backupVisitor = new BackupVisitor(backupTree, updateVal);
		tree.accept(backupVisitor);
		
		Logger.writeOutput(Logger.debugLevels.RESULT, "\n\nDisplaying updated Original Tree: \n");
		tree.display();
		Logger.writeOutput(Logger.debugLevels.RESULT, "\n\nDisplaying updated Backup Tree: \n");
		backupTree.display();
	}

	/**
	 * @param args
	 * @return boolean 
	 */
	private boolean validateInpurArgs(String[] args) {
		return (lengthCheck(args.length) && checkInFile(args[0]) && checkOutputFile(args[1]) && checkNoIterations(args[2]));
	}

	/**
	 * Checks whether the Number of Iterations input, is Integer or not
	 * @param string
	 * @return boolean
	 */
	private static boolean checkNoIterations(String iterationsIn) {
			try{
				int iterations = Integer.parseInt(iterationsIn);
			} catch(NumberFormatException e){
				System.out.println("Please Enter the Number of Iterations as Integer");
				e.printStackTrace();
				System.exit(1);
			}
			return true;
	}

	/**
	 * Checks the output file name is valid
	 * @param string
	 * @return boolean
	 */
	private static boolean checkOutputFile(String outFileIn) {
		File file = new File(outFileIn);
		if(file.delete()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Error while creating Output File");
				e.printStackTrace();
				System.exit(1);
			}
		}
		return true;
	}

	/**
	 * Checks whether the input file name is valid
	 * @param string
	 * @return boolean
	 */
	private static boolean checkInFile(String fileIn) {
		boolean res= false;
		File file = new File(fileIn);
		if(file.isFile() && file.canRead() && file.length() > 0){
			res = true;
		}
		else{
			System.err.println("Please provide a Valid Input File");
			System.exit(1);
		}
		return res;
	}

	/**
	 * Checks for the correct number of input arguements
	 * @param length
	 * @return boolean
	 */
	private static boolean lengthCheck(int lengthIn) {
		if(lengthIn != 3){
			System.err.println("Please Enter the Valid Number of Input Arguements");
			System.exit(1);
		}
		return true;
	}
	
}
