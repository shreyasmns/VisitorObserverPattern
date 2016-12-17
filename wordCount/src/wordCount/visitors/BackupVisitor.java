package wordCount.visitors;

import java.util.Stack;
import wordCount.bst.Node;
import wordCount.bst.TreeInterface;
import wordCount.util.Logger;
import wordCount.util.Logger.debugLevels;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class BackupVisitor implements VisitorInterface {
	private TreeInterface backup;
	private int updateVal;
	
	public BackupVisitor(TreeInterface backuptreeIn, int updateValIn){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR,"BackupVisitor Constructor is in execution");
		this.backup = backuptreeIn;
		this.updateVal = updateValIn;
	}

	/**
	 * Visit method to Implement the Visitor Pattern, This visit method
	 * clones the Original Tree and imitates the Observer pattern
	 * showing updation of back tree as orignal tree gets updated
	 * 
	 * @param TreeInterface
	 */
	@Override
	public void visit(TreeInterface tree) {
		cloneOriginalTree(tree);		
		updateOriginalTree(tree);
	}

	/**
	 * Building the Backup tree using the Original tree
	 */
	private void cloneOriginalTree(TreeInterface tree) {
		Logger.writeOutput(debugLevels.CLONING_TREE, "Cloning the Original Tree");
		Stack<Node> s = new Stack<Node>();
		Node root = tree.getRootNode();
		
		while(true){
			while(root != null){
				s.push(root);
				root = root.getLeftChild();
			}
			if(s.isEmpty())
				return;

			root = s.pop();
			Node currNode = root;
			backup.insertWordBackup(currNode, root);
			root = root.getRightChild();
		}	
	}
	
	/**
	 * This method updates the Original Tree i.e
	 * Updates the each node's word count
	 * @param tree
	 */
	public void updateOriginalTree(TreeInterface tree) {
		tree.update(tree, updateVal);
	}
	
}
