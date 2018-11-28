/**
 * Interface for a Bag.
 *
 * @author Nick Massa.
 * @version September 17th, 2018.
 */
public interface BagInterface<T> {
    /**
     * Method for getting the number of items in the bag.
     *
     * @return This will return the current number of entries in the bag.
     */
    public int getCurrentSize();

    /**
     * Method for seeing if the bag is empty.
     *
     * @return This will return true if the bag is empty.
     */
    public boolean isEmpty();

    /**
     * Method for adding a given object to the bag.
     *
     * @param newEntry This will be the new entry being added.
     */
    public boolean add(T newEntry);

    /**
     * Method for removing all entries from the bag.
     */
    public boolean clear();

    /**
     * Method for removing one unspecified entry from the bag.
     */
    public boolean remove();

    /**
     * Method for removing one occurance of a particular entry from the bag, if possible.
     *
     * @param anEntry This will be the entry being removed.
     */
    public boolean remove(T anEntry);

    /**
     * Method for counting the number of times a certain object occurs in the bag
     *
     * @param anEntry This will be the entry we are looking for.
     *
     * @return This will return the number of times an entry occurs.
     */

    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether the bag contains a given entry.
     *
     * @param anEntry This will be the entry we are looking for.
     *
     * @return This will return if the entry is in the bag.
     */
    public boolean contains(T anEntry);

    /**
     * Method for printing all the objects in the bag.
     */
    public T[] toArray();

    /**
     * Method for getting a random entry from the bag.
     *
     * @return This will return a random number from the bag.
     */
    public T randomEntry();

}

