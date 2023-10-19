import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A linked list based implementation of the KQueue interface.
 * <ul>
 *      <li> The enqueue method adds an element to the "rear" of the queue.
 *      <li> The dequeue method attempts to remove an element from the
 *          "front" of the queue and returns the removed element.
 * </ul>
 *
 * @author Juniper Pasternak
 * @author Dr. Vargas-Perez (advice)
 * @version 9/27/23
 * @param <T> queue element type
 */
public class LLQueue<T> implements KQueue<T>
{
    LinkedList<T> list;

    /**
     * Instantiates a new linked list based queue.
     */
    public LLQueue()
    {
        list = new LinkedList<>();
    }

    /**
     * Returns <code>true</code> if this queue is empty;
     * <code>false</code> otherwise.
     **/
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    /**
     * Adds a specified object to the "back" of this queue.
     *
     * @param item the object to add to the queue
     **/
    public void enqueue(T item) throws NoSuchElementException
    {
        list.addLast(item);
    }

    /**
     * Removes the element at the "front" of this queue.
     *
     * @return the removed element
     * @throws NoSuchElementException if the queue is empty
     **/
    public T dequeue() throws NoSuchElementException
    {
        if (list.isEmpty())
            throw new NoSuchElementException("No element to remove from queue.");

        return list.removeFirst();
    }

    /**
     * Returns the element at the "front" of this queue, without
     * modifying the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     **/
    public T peekFront()
    {
        if (list.isEmpty())
            throw new NoSuchElementException("No element to peek in queue.");

        return list.getFirst();
    }

    /**
     * Returns the size of the queue.
     *
     * @return the amount of elements in the queue
     */
    public int size()
    {
        return list.size();
    }

    /**
     * Returns a print-ready string representation of the queue
     * in the following format:
     * <pre>
     *      [element0, element1, ...]
     * </pre>
     *
     * @return a string representation of the queue's elements
     */
    @Override
    public String toString()
    {
        if (list.isEmpty())
            return "[]";

        // Create a StringBuilder starting with "["
        StringBuilder sb = new StringBuilder("[");

        // Add each element to the StringBuilder
        for (T item : list)
            sb.append(item).append(", ");

        // Remove last ", " and then return with "]"
        String output = sb.substring(0, sb.length() - 2);
        return output + "]";
    }
}
