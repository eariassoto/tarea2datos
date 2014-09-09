/**
 * Autor: Emmanuel Arias Soto
 * 
 */
public class Node
{
    public int value, id;
    public Node next;
    
    /**
     * Empty constructor for objects of class Node
     */
    public Node()
    {
        value = 0;
        next = null;
    }

     /**
     * Constructor for objects of class Node
     */
    public Node(int id, int value, Node n)
    {
        this.value = value;
        this.id = id;
        next = n;
    }
    
    /**
     * Constructor for objects of class Node
     */
    public Node(int id, int value)
    {
        this.value = value;
        this.id = id;
        next = null;
    }
}
