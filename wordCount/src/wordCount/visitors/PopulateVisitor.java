package wordCount.visitors;

import java.util.List;
import wordCount.bst.TreeInterface;
import wordCount.util.InputReaderInterface;
import wordCount.util.Logger;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class PopulateVisitor implements VisitorInterface {
	
	private InputReaderInterface reader;
	
	public PopulateVisitor(InputReaderInterface readerIn){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR,"PopulateVisitor constructor is in execution ");
		reader = readerIn;
	}

	/**
	 * Visit method to Implement the Visitor Pattern
	 * It reads from the input file to build the initial
	 * Original Tree 
	 * 
	 * @param TreeInterface
	 */
	@Override
	public void visit(TreeInterface tree) {
		List<String> words = null;
		if((words = reader.read()) != null){
			for(String word : words){
				if(!word.equals("") && !word.isEmpty() && null != word){
					tree.insertWord(word);
				}
			}
		}
	}
	
}
