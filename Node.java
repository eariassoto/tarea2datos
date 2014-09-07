
/**
 * Super cool container.
 * 
 * @author Emmanuel Arias
 * @version 27/8/14
 */
public class Node
{
    // maybe I can make it a template
    public int value, id;
    public Node next;
    
    /**
     * Empty constructor for objects of class Node
     */
    public Node()
    {
        // initialise instance variables
        value = 0;
        next = null;
    }

     /**
     * Constructor for objects of class Node
     */
    public Node(int id, int value, Node n)
    {
        // initialise instance variables
        this.value = value;
        this.id = id;
        next = n;
    }
    
    /**
     * Constructor for objects of class Node
     */
    public Node(int id, int value)
    {
        // initialise instance variables
        this.value = value;
        this.id = id;
        next = null;
    }
}
