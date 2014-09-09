/**
 * Autor: Emmanuel Arias Soto
 * 
 */
public class List
{
    public int maxLength, length;
    public Node head;
    /**
     * Constructor for objects of class List
     */
    public List(int l)
    {
        head = null;
        length = 0;
        maxLength = l;
    }

    public List(List l){
        maxLength = l.maxLength;
        Node tmp = l.head;
        while(tmp != null){
            this.addLast(tmp.value);
            tmp = tmp.next;
        }
    }

    public void addLast(int value){
        if(length < maxLength){
            if(head == null){
                head = new Node(length, value);
                length++;
            }else{
                Node tmp = head;
                while(tmp.next != null){
                    tmp = tmp.next;
                }
                tmp.next = new Node(length, value);
                length++;
            }
        }
    }

    public Node getNodeByIndex(int index){
        Node tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    
    public Node getNodePrev(Node s, Node n){
        Node tmp = s;
        if(tmp == n)
            return null;
        while(tmp.next != n){
            tmp = tmp.next;
        }
        return tmp;
    }

    public int getValueByIndex(int index){
        Node tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public int getIndexOf(int value){
        Node tmp = head;
        int c = 0;
        while(tmp != null){
            if(tmp.value == value){
                return c;
            }
            c++;
            tmp = tmp.next;
        }
        return -1;
    }

    public boolean exists(int value){
        Node tmp = head;
        while(tmp != null){
            if(tmp.value == value)
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public void modify(int index, int v){
        if(index < this.length){
            this.getNodeByIndex(index).value = v;
        }
    }

    public void deleteByIndex(int index){
        if(index == 0){
            if(head != null && head.next != null){
                head = head.next;
                length--;
            }else if(head != null){
                head = null;
                length--;
            }
        }else if(index < length){
            if(getNodeByIndex(index+1) != null){
                getNodeByIndex(index-1).next = getNodeByIndex(index+1);
            }else{
                getNodeByIndex(index-1).next = null;
            }
            length--;
        }
    }

    public void deleteByValue(int value){
        Node tmp = head;
        int c = 0;
        while(tmp != null){
            if(tmp.value == value){
                deleteByIndex(c);
            }
            else{
                c++;
            }
            tmp = tmp.next;
        }
    }

    public String print(){
        String s = "";
        Node tmp = head;
        while(tmp != null){
            s += String.valueOf(tmp.value) + " ";
            tmp = tmp.next;
        }
        return s;
    }

    //bad idea
    public Node getLast(){
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }
}
