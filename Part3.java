package StringsSecondAssignments;


/**
 * Write a description of Part3 here.
 * How Many Genes
 * @author Tareq Khammash
 * @version (a version number or a date)
 */
public class Part3 {
public int findStopCodon(String dna, int startIndex, String stopCodon)
{   
    int currIndex = dna.indexOf(stopCodon, startIndex+3);
    while (currIndex !=-1)
    {
        if ((currIndex - startIndex) % 3 == 0)
        {
            return currIndex;
        }
        else
        {
           currIndex = dna.indexOf(stopCodon, currIndex+1);
        }
        
    }
    return dna.length(); 
}

public String findGene(String dna, int where)
{
    //dna = dna.toUpperCase();
    String gene = "";
    int startIndex = dna.indexOf("atg", where);
    if(startIndex == -1)
    {
        return gene;
    }
    int stopCodonTAA = findStopCodon(dna,startIndex,"taa");
    int stopCodonTAG = findStopCodon(dna,startIndex,"tag");
    int stopCodonTGA = findStopCodon(dna,startIndex,"tga");
    //case 1: find min of index stopTAA / stopTAG / stopTGA (that is not -1)
    int minTAA_TAG = Math.min(stopCodonTAA,stopCodonTAG);
    int minStopCodon = Math.min(stopCodonTGA, minTAA_TAG);
    // minStopCodon is not -1
    if(minStopCodon != -1 && minStopCodon != dna.length())
    {
        gene = dna.substring(startIndex, minStopCodon+3);
    }
    return gene;
}
public void printAllGenes(String dna)
{
    //int currindex = 0;
    int startIndex = 0;
    while(true)
    {
        String gene = findGene(dna, startIndex);
        System.out.println(gene);
        if(gene.isEmpty())
        {
            break;
        }
        startIndex = dna.indexOf(gene) + gene.length();
        //int posn = dna.indexOf(gene);
        //int len = gene.length();
        // dna = atgxxxxxxtaa
        //dna = dna.substring(posn+len-1);
        
    }
}
public int countGenes(String dna)
{
    int counter = 0;
    int startIndex = 0;
    while(true)
    {
        String gene = findGene(dna,startIndex);
        System.out.println(gene);
        if(gene.isEmpty())
        {
            break;
        }
        counter = counter +1;
        startIndex = dna.indexOf(gene) + gene.length();
    }
    return counter;
}
public void testCountGenes()
{
    String dna1 = "xxxatgxxxtaaxxatgxxxtag";
    int counter = countGenes(dna1);
    System.out.println(counter);
    String dna2 = "xxxatgxxxtaaxxatgatgxxatgxxxtagxxxxxxxatgtgaxxxxxatgtaatga";
    counter = countGenes(dna2);
    System.out.println(counter);
    //dna2 = "xxxatgxxxtaaxxatgatgxxatgxxxtagxxxxxxxatgtgaxxxxxatgtaatgaxxxxxxxxtaatgaatgxxxxxxx";
    dna2 = "xxxxxtaaaatgxxtga";
    counter = countGenes(dna2);
    System.out.println(counter);
    dna2 = "atgxxxtgaxxatgxxxxxxtaa";
    counter = countGenes(dna2);
    System.out.println(counter);
    dna2 = "atgxxxtgaxxatgxxxxxxtaaxxxxxxxxatgxtga";
    counter = countGenes(dna2);
    System.out.println(counter);
    dna2 = "atgxxxatgtaa";
    counter = countGenes(dna2);
    System.out.println(counter);
}
}
