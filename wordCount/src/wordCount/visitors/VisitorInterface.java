package wordCount.visitors;

import wordCount.bst.TreeInterface;

/**
 * This is the heart of the Visitor pattern concept
 * as this defines the visit method to accept the Tree as
 * Visitors and do the specific operations on the Tree
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface VisitorInterface {
	
	/**
	 * Accepts the different visitors which are meant for
	 * specific purpose
	 * 
	 * @param tree
	 */
	public void visit(TreeInterface tree);

}
