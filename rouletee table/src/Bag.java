import java.lang.Math;
/**
 * This will be represent a bag containing any type of entries.
 *
 * @author Nick Massa.
 * @version September 17th, 2018.
 */
public class Bag<T> implements BagInterface<T> {
    /**
     * This will represent the actual bag.
     */
    private final T[] bag;
    /**
     * This will represent the current size of the bag.
     */
    private int currentSize;
    /**
     * This will represent the max size a bag could be.
     */
    private static final int MAX_AMOUNT = 25;

    /**
     * Constructor for the Bag with a certain amount.
     *
     * @amount This will the specific amount.
     */
    public Bag(int amount) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[amount];
        bag = tempBag;
        currentSize = 0;
    }

    /**
     * Constructor for the bag with a default size.
     */
    public Bag() {
        this(MAX_AMOUNT);
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        boolean results = false;
        if (currentSize == 0) {
            results = true;
        }
        return results;
    }

    @Override
    public boolean add(T newEntry) {
        boolean results = false;
        if (currentSize < bag.length) {
            int index = currentSize;
            bag[index] = newEntry;
            currentSize++;
            results = true;
        }
        return results;
    }

    @Override
    public boolean clear() {
        boolean results = false;
        if (getCurrentSize() >= 1) {
            for (int index = 0; index < getCurrentSize(); index++) {
                bag[index] = null;
            }
            currentSize = 0;
            results = true;
        }
        return results;
    }

    @Override
    public boolean remove() {
        boolean results = false;
        int size = getCurrentSize();
        if (size >= 1) {
            bag[size - 1] = null;
            size--;
            results = true;
        }
        return results;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean results = false;
        if (getCurrentSize() >= 1) {
            for (int index = 0; index < getCurrentSize(); index++) {
                if (bag[index] == (anEntry)) {
                    for (int innerIndex = index; innerIndex < getCurrentSize() - 1; innerIndex++) {
                        bag[index] = bag[index + 1];
                    }
                    currentSize = getCurrentSize() - 1;
                    results = true;
                }
            }
        }
        return results;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int index = 0; index < getCurrentSize(); index++) {
            if (bag[index] == anEntry) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean results = false;
        for (int index = 0; index < getCurrentSize(); index++) {
            if (bag[index] == anEntry) {
                results = true;
            }
        }
        return results;
    }

    @Override
    public T[] toArray() {
        T[] tempBag = (T[]) new Object[currentSize];
        for (int index = 0; index < currentSize; index++) {
            tempBag[index] = bag[index];
        }
        return tempBag;
    }

    @Override
    public T randomEntry() {
        T randomEntry;
        int max = getCurrentSize();
        int min = 1;
        int range = max - min + 1;
        int randomNumber = (int) (Math.random() * range) + min;
        randomEntry = bag[randomNumber];
        return randomEntry;
    }
}
