import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Main
{
    static int length, random;

    public static String sortList(int sortId, List l){
        long startTime;
        long endTime;

        switch(sortId){
            case 0:
            startTime = System.currentTimeMillis();
            ListsSorter.sortByInsertion(l);
            endTime = System.currentTimeMillis();
            return "Insertion time: " + (endTime - startTime) + " ms.\n";
            case 1:
            startTime = System.currentTimeMillis();
            ListsSorter.sortBySelection(l);
            endTime = System.currentTimeMillis();
            return "Selection time: " + (endTime - startTime) + " ms.\n";
            case 2:
            startTime = System.currentTimeMillis();
            ListsSorter.sortByBubble(l);
            endTime = System.currentTimeMillis();
            return "Bubble Sort time: " + (endTime - startTime) + " ms.\n";
            case 3:
            startTime = System.currentTimeMillis();
            ListsSorter.sortByQuickSort(l);
            endTime = System.currentTimeMillis();
            return "QuickSort time: " + (endTime - startTime) + " ms.\n";
            case 4:
            startTime = System.currentTimeMillis();
            ListsSorter.sortByShell(l);
            endTime = System.currentTimeMillis();
            return "ShellSort time: " + (endTime - startTime) + " ms.\n";
        }
        return "";
    }

    public static void clean(JTextArea area){
        area.setText("");
    }

    public static void initLists(int length, int random, List[] l){
        l[0] = new List(length);
        Random randomGenerator = new Random();
        int r;
        for(int i = 0; i < length; i++){
            r = randomGenerator.nextInt(random);
            l[0].addLast(r);
        }
        for(int j = 1; j < l.length; j++){
            l[j] = new List(l[0]);
        }

    }

    public static void main(String args[]){
        JButton btn = new JButton();
        JTextField txtLength = new JTextField(),
        txtRandom = new JTextField();
        JTextArea areaOrig = new JTextArea(),
        areaSort = new JTextArea(),
        areaResult = new JTextArea();

        length = 1000;
        random = 2000;

        txtLength.setText(String.valueOf(length));
        txtRandom.setText(String.valueOf(random));

        List[] listArr = new List[5];
        initLists(length, random, listArr);

        areaOrig.setText(listArr[0].print());

        btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String res = "";
                    for(int i = 0; i < listArr.length; i++){
                        res += sortList(i, listArr[i]);
                    }     
                    areaSort.setText(listArr[4].print());
                    areaResult.setText(res);
                    btn.setEnabled(false);
                }
            }); 

        txtLength.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    try{
                        int l = Integer.parseInt(evt.getActionCommand());
                        length = l;
                        initLists(length, random, listArr);
                        areaOrig.setText(listArr[0].print());
                        clean(areaSort);
                        clean(areaResult);
                        btn.setEnabled(true);
                    }catch(Exception e){
                    }

                }

            });

        txtRandom.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    try{
                        int r = Integer.parseInt(evt.getActionCommand());
                        random = r;
                        initLists(length, random, listArr);
                        areaOrig.setText(listArr[0].print());
                        clean(areaSort);
                        clean(areaResult);
                        btn.setEnabled(true);
                    }catch(Exception e){
                    }

                }

            });
        mainFrame main = new mainFrame(btn, txtLength, txtRandom, areaOrig, areaSort, areaResult);

    }
}
