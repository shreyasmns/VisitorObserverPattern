package wordCount.bst;

import java.util.ArrayList;

import wordCount.observer.ObserverInterface;
import wordCount.observer.SubjectInterface;
import wordCount.util.Logger;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class Node implements SubjectInterface, ObserverInterface {
	
	/*
	 * Represents the leftChild of the Node
	 */
	private Node leftChild;
	
	/*
	 * Represents the rightChild of the Node
	 */
	private Node rightChild;
	
	/*
	 * Represents the Word in a Node
	 */
	private String word;
	
	/*
	 * Represents the number of characters in the Node word
	 */
	private int noCharacters;
	
	/*
	 * Represents the frequency of the word of the Node
	 */
	private int wordFrequency;
	
	/*
	 * List of references to the observers
	 */
	ArrayList<ObserverInterface> observers = new ArrayList<>();
	
	public Node(String wordIn){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR,"Node Constructor is in execution");
		this.word = wordIn;
		this.wordFrequency = 1;
	}
	
	public Node (Node currNode, SubjectInterface node){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR,"Node Constructor is in execution");
		this.word = currNode.getWord();
		this.wordFrequency = 1;
		node.registerObserver(this);
	}

	/**
	 * @return the leftChild
	 */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public Node getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * @return the noCharacters
	 */
	public int getNoCharacters() {
		return noCharacters;
	}

	/**
	 * @param noCharacters the noCharacters to set
	 */
	public void setNoCharacters(int noCharacters) {
		this.noCharacters = noCharacters;
	}

	/**
	 * @return the wordFrequency
	 */
	public int getWordFrequency() {
		return wordFrequency;
	}

	/**
	 * @param wordFrequency the wordFrequency to set
	 */
	public void setWordFrequency(int wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	/**
	 * @param Observer
	 * @return none
	 */
	@Override
	public void registerObserver(ObserverInterface observerIn) {
		observers.add(observerIn);
	}

	/**
	 * @param Observer
	 * @return none
	 */
	@Override
	public void removeObserver(ObserverInterface observerIn) {
		observers.remove(observerIn);
	}
	

	/**
	 * @param int
	 * @return none
	 */
	@Override
	public void notifyObserver(int value) {
		for(ObserverInterface obs : observers){
			obs.update(value);
		}
	}
	
	/**
	 * @param int
	 * @return none
	 */
	public void update(int updateValue) {
		this.wordFrequency += updateValue; 
	}

	@Override
	public String toString(){
		return "word : "+getWord() + ", leftChild :"+getLeftChild() + ", rightChild : "+getRightChild() +
				", frequency : "+getWordFrequency() + ", characters : "+getNoCharacters();
	}
	
}
