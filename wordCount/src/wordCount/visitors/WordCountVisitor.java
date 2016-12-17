package wordCount.visitors;

import java.util.Stack;
import wordCount.bst.Node;
import wordCount.bst.TreeInterface;
import wordCount.util.Logger;
import wordCount.util.OutputWriterInterface;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class WordCountVisitor implements VisitorInterface {

	private OutputWriterInterface outputWriter;
	
	public WordCountVisitor(OutputWriterInterface writerIn){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR, "WordCountVisitor constructor is isn execution");
		outputWriter = writerIn;
	}
	
	/**
	 * Visit method to Implement the Visitor Pattern
	 * In this visit method, to get the stats of a tree such as 
	 * total words, distinct words and total number of chars in a tree
	 * 
	 * @param TreeInterface
	 */
	@Override
	public void visit(TreeInterface tree) {
		TreeUtil treeutil = getResults(tree);
		outputWriter.write( "Total Words      : "+treeutil.getNumOfWords() + "\n"+
							"Distinct Words   : "+treeutil.getNumOfDistinctWords() + "\n"+
							"Total Characters : "+treeutil.getNumOfCharacters());
	 }


	/**
	 * This method fetches the different stats of the tree
	 * traversing the tree using Inorder traversal
	 * 
	 * @param tree
	 * @return TreeUtil
	 */
	private TreeUtil getResults(TreeInterface treeIn) {
		Node rootNode = treeIn.getRootNode();
		int distinctWords = getSize(rootNode);
		
		TreeUtil treeUtil = new TreeUtil();
		treeUtil.setNumOfDistinctWords(distinctWords);
		
		if (rootNode == null) {
			return treeUtil;
		}
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = rootNode;
		while (!stack.empty() || currentNode != null) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} else {
				Node node = stack.pop();
				treeUtil.setNumOfWords(treeUtil.getNumOfWords() + node.getWordFrequency());
				treeUtil.setNumOfCharacters(treeUtil.getNumOfCharacters() + (node.getWordFrequency() * node.getWord().length()));
				currentNode = node.getRightChild();
			}
		}
		return treeUtil;
	}


	/**
	 * This method returns the tree size i.e, distinct words in a tree
	 * 
	 * @param rootNode
	 * @return int
	 */
	private int getSize(Node node) {
		if (node == null) return 0; 
		else { 
		       return(getSize(node.getLeftChild())  + 1 + getSize(node.getRightChild())); 
		 } 
	 }
	
}

