package wordCount.bst;

import wordCount.visitors.VisitorInterface;

/**
 * This Interface declared all the methods which are
 * used by the Tree for various operations
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface TreeInterface {
	
	/**
	 * @return Node
	 */
	Node getRootNode();
	
	/**
	 * Accepts the Visitor to Implement Visit method
	 */
	void accept(VisitorInterface visitor);
	
	/**
	 * Inserts a word to the Tree
	 * @param word
	 * 
	 */
	void insertWord(String word);
	
	/**
	 * constructs a back tree
	 * @param Nodes
	 */
	void insertWordBackup(Node currNode, Node root);
	
	/**
	 * This method is to print the trees using the InOrder traversal
	 */
	void printWordsInorder();
	
	/**
	 * This method is to update the backup tree as original tree
	 * is updated
	 * @param tree
	 * @param updateVal
	 */
	void update(TreeInterface tree, int updateVal);
	
	/*
	 * This method is to display the few words in the
	 * backup trees
	 */
	void display();

}
