package wordCount.observer;

/**
 * This Interface defines update method to update the Observers
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface ObserverInterface {
	
	/**
	 * Takes the int as updateval and updates the corresponding node
	 * in the backup Tree
	 * 
	 * @param updateValue
	 */
	public void update(int updateValue);

}
