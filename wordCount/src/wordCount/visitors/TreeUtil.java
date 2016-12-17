package wordCount.visitors;

import wordCount.util.Logger;

/**
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public class TreeUtil {

	/**
	 * To hold the count of total number of words in a tree
	 */
	private int numOfWords;
	
	/**
	 * To hold the count of distinct number of words in a tree
	 */
	private int numOfDistinctWords;
	
	/**
	 * To hold the count of total number of characters,
	 * accounts for all the words in a tree
	 */
	private int numOfCharacters;
	
	public TreeUtil(){
		Logger.writeOutput(Logger.debugLevels.CONSTRUCTOR,
				Thread.currentThread().getStackTrace()[1].getClassName() + " - "
						+ Thread.currentThread().getStackTrace()[2].getLineNumber() + ": Constructor of "
						+ this.getClass().getSimpleName() + " class is in execution.\n\n");
		numOfWords = 0;
		numOfDistinctWords = 0;
		numOfCharacters = 0;
	}
	
	/**
	 * @return the numOfWords
	 */
	public int getNumOfWords() {
		return numOfWords;
	}

	/**
	 * @param numOfWords the numOfWords to set
	 */
	public void setNumOfWords(int numOfWords) {
		this.numOfWords = numOfWords;
	}

	/**
	 * @return the numOfDistinctWords
	 */
	public int getNumOfDistinctWords() {
		return numOfDistinctWords;
	}

	/**
	 * @param numOfDistinctWords the numOfDistinctWords to set
	 */
	public void setNumOfDistinctWords(int numOfDistinctWords) {
		this.numOfDistinctWords = numOfDistinctWords;
	}

	/**
	 * @return the numOfCharacters
	 */
	public int getNumOfCharacters() {
		return numOfCharacters;
	}

	/**
	 * @param numOfCharacters the numOfCharacters to set
	 */
	public void setNumOfCharacters(int numOfCharacters) {
		this.numOfCharacters = numOfCharacters;
	}
	
	@Override
	public String toString(){
		return "numOfWords : "+getNumOfWords() + ", numOfDistinctWords : "+getNumOfDistinctWords() + 
				", numOfCharacters : "+getNumOfCharacters();
	}
	
}
