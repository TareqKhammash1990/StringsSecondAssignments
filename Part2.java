package StringsSecondAssignments;


/**
 * Write a description of Part2 here.
 * Finding Multiple Occurences
 * @author Tareq Khammash 
 * @version (a version number or a date)
 */
public class Part2 {

public int howMany(String stringa, String stringb)
{
    int counter = 0;
    int index = stringb.indexOf(stringa);
    while (index !=-1)
    {
        counter = counter + 1 ;
        index = stringb.indexOf(stringa,index + stringa.length());
    }
    return counter;
}
public void testHowMany()
{
    String stringa;
    String stringb;
    int counter;
    
    stringa = "aaa";
    stringb = "xxxaaaaaxxxaaa";
    counter = howMany(stringa, stringb);
    System.out.println(counter);
}
}
