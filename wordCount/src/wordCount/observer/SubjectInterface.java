package wordCount.observer;

/**
 * This Interface defines the Methods which Subject need to
 * perform inorder to act on the Listeners/Observers
 * 
 * @author ${Shreyas Mahanthappa Nagaraj}
 * 
 */
public interface SubjectInterface {
	
	/**
	 * Registers the Observer
	 * @param observerIn
	 */
	public void registerObserver(ObserverInterface observerIn);

	/**
	 * Removes the Observer
	 * @param observerIn
	 */
	public void removeObserver(ObserverInterface observerIn);
	
	/**
	 * Notifies the Observer
	 * @param value
	 */
	public void notifyObserver(int value);

}
