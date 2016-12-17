package wordCount.bst;

import java.util.Stack;
import wordCount.bst.Node;
import wordCount.util.Logger;
import wordCount.util.Logger.debugLevels;
import wordCount.visitors.VisitorInterface;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class BST implements TreeInterface {
	
	private Node root;
	
	@Override
	public void insertWord(String wordIn){
	  Node currentNode = new Node(wordIn);
		if(root == null){
			root = currentNode;
			return;
		}
		int result;
		Node rootnode = root;
		while (true) {
			result = rootnode.getWord().compareTo(currentNode.getWord());
			if (result > 0) {
				if (null == rootnode.getLeftChild()) {
					rootnode.setLeftChild(currentNode);
					break;
				} else {
					rootnode = rootnode.getLeftChild();
				}
			} else if (result < 0) {
				if (null == rootnode.getRightChild()) {
					rootnode.setRightChild(currentNode);
					break;
				} else {
					rootnode = rootnode.getRightChild();
				}
			} else {
				rootnode.setWordFrequency(rootnode.getWordFrequency() + 1);
				break;
			}
		}
	}
	
	public void insertWordBackup(Node currNode, Node subjectNode){
	  Logger.writeOutput(debugLevels.CLONING_TREE, "cloning the node : "+currNode.getWord());
	  Node currentNode = new Node(currNode, subjectNode);
	  currentNode.setWordFrequency(currNode.getWordFrequency());
		if(root == null){
			root = currentNode;
			return;
		}
		int result;
		Node rootnode = root;
		while (true) {
			result = rootnode.getWord().compareTo(currentNode.getWord());
			if (result > 0) {
				if (null == rootnode.getLeftChild()) {
					rootnode.setLeftChild(currentNode);
					break;
				} else {
					rootnode = rootnode.getLeftChild();
				}
			} else if (result < 0) {
				if (null == rootnode.getRightChild()) {
					rootnode.setRightChild(currentNode);
					break;
				} else {
					rootnode = rootnode.getRightChild();
				}
			} else {
				rootnode.setWordFrequency(rootnode.getWordFrequency() + 1);
				break;
			}
		}
	}
	
	/**
	 * which accepts the particulat visitor and calls visit method on that
	 * 
	 */
	@Override
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}
	
	/**
	 * @param TreeInterface
	 * @param value
	 */
	public void update(TreeInterface tree, int value){
		updateValues(tree.getRootNode(), value);
	}
	
	/**
	 * @param node
	 * @param valueIn
	 */
	public void updateValues(Node node, int valueIn){
		if(node != null){
			updateValues(node.getLeftChild(), valueIn);
			node.setWordFrequency(node.getWordFrequency() + valueIn);
			node.notifyObserver(valueIn);
			updateValues(node.getRightChild(), valueIn);
		}
	}
	
	
	/**
	 * Prints the Nodes of a tree, inOrder
	 * 
	 */
	@Override
	public void printWordsInorder() {
		Stack<Node> s = new Stack<Node>();
		while(true){
			while(root != null){
				s.push(root);
				root = root.getLeftChild();
			}
			
			if(s.isEmpty())
				return;

			root = s.pop();
			System.out.println(root.getWord() + " : "+root.getWordFrequency());
			root = root.getRightChild();
		}
	}
	
	
	/**
	 * This method Displays the updated trees to prove
	 * the observer pattern working, It only displays the
	 * first 30 nodes in trees
	 * 
	 * @return none
	 */
	@Override
	public void display() {
		int count = 0;
		Stack<Node> s = new Stack<Node>();
		
		while(true){
			while(root != null){
				s.push(root);
				root = root.getLeftChild();
			}
			if(s.isEmpty())
				return;

			root = s.pop();
			if(count <  30){
				System.out.print(root.getWord() +" "+root.getWordFrequency()+", ");
				count++;
			}
			else{
				return;
			}
			root = root.getRightChild();
		}
	}
	

	/**
	 * @return Node
	 * 
	 */
	public Node getRootNode(){
		return root;
	}
	
}
