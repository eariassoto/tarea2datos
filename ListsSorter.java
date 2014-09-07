
/**
 * Write a description of class ListsSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListsSorter
{
    public ListsSorter() {}

    public static List sortByInsertion(List l){
        for(int i = 1; i < l.length; i++){
            int key = l.getValueByIndex(i);
            int j = i;
            while(j > 0 && l.getValueByIndex(j-1) > key){
                l.getNodeByIndex(j).value = l.getValueByIndex(j-1);
                j--;
            }
            l.getNodeByIndex(j).value = key;
        }
        return l;
    }

    public static List sortByBubble(List l)
    {
        Node tmp;
        for(int i = 0; i < l.length-1; i++){
            tmp = l.head;
            for(int j = 0; j < (l.length-1 - i); j++){
                if(tmp.value > tmp.next.value){
                    int aux = tmp.value;
                    tmp.value = tmp.next.value;
                    tmp.next.value = aux;
                }
                tmp = tmp.next;
            }
        }
        return l;
    }

    public static List sortBySelection(List l){
        Node tmpOut = l.head, tmpIn, aux;
        int iAux;

        for(int j = 0; j < l.length-1; j++){
            aux = tmpIn = tmpOut;
            for(int i = j; i < l.length; i++){
                if(tmpIn.value < aux.value){
                    aux = tmpIn;
                }
                tmpIn = tmpIn.next;
            }
            iAux = aux.value;
            aux.value = tmpOut.value;
            tmpOut.value = iAux;

            tmpOut = tmpOut.next;
        } 
        return l;
    }

    public static void swap(Node n1, Node n2){
        int aux = n1.value;
        n1.value = n2.value;
        n2.value = aux;
    }

    private static Node sortPartition(Node start, Node end){
        Node pivot = end,
        pivotIndex = start,
        tmp = start;

        while(tmp != end){
            if(tmp.value <= pivot.value){
                swap(tmp, pivotIndex);
                pivotIndex = pivotIndex.next;
            }
            tmp = tmp.next;
        }
        swap(pivotIndex, pivot);
        return pivotIndex;
    }

    public static void sortByQuickSort(List l){
        sortByQuickSort(l, l.head, l.getLast());
    }

    private static void sortByQuickSort(List l, Node start, Node end){
        if(start != null && end != null && start.id < end.id){
            Node pivotIndex = sortPartition(start, end); 

            sortByQuickSort(l, pivotIndex.next, end);
            Node prePivot = l.getNodePrev(start, pivotIndex);
            sortByQuickSort(l, start, prePivot);
        }
    }
}
