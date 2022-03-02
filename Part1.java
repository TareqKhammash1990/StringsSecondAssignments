package StringsSecondAssignments;


/**
 * Write a description of Part1 here.
 * Finding many Genes
 * @author Tareq Khammash
 * @version (a version number or a date)
 */
public class Part1 
{

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

public String findGene(String dna)
{
    //dna = dna.toUpperCase();
    String gene = "";
    int startIndex = dna.indexOf("atg");
    if(startIndex == -1)
    {
        return gene;
    }
    int stopCodonTAA = findStopCodon(dna,startIndex,"taa");
    int stopCodonTAG = findStopCodon(dna,startIndex,"tag");
    int stopCodonTGA = findStopCodon(dna,startIndex,"tga");
    //case 1: find min of index stopTAA / stopTAG / stopTGA (that is not -1)
    int minTAA_TAG = minnum(stopCodonTAA,stopCodonTAG);
    int minStopCodon = minnum(stopCodonTGA, minTAA_TAG);
    // minStopCodon is not -1
    if(minStopCodon != -1 && minStopCodon != dna.length())
    {
        gene = dna.substring(startIndex, minStopCodon+3);
    }
    return gene;
}

public int minnum(int a, int b)
{
    int min;
    if(a < b)
    {
        min = a;
    }
    else
    {
        min = b;
    }
    return min;
}
public void testFindGene()
{
// test case 1, no ATG
String dna = "xtggtaaxxxxxxxxxx";
System.out.println(dna);
String gene = findGene(dna);
System.out.println("the gene is "+gene);
// test case 2, ATG + valid stop Codon
String dna1 = "xxxxxxxatgxxxxxxxxxtagxxxxxx";
System.out.println(dna1);
String gene1 = findGene(dna1);
System.out.println("the gene is "+gene1);
// test case 3, DNA with “ATG” and multiple valid stop codons
String dna2 = "xxxxxxxatgxxxxxxtgataatagxxx";
System.out.println(dna2);
String gene2 = findGene(dna2);
System.out.println("the gene is "+gene2);

// test case4, DNA with “ATG” and no valid stop codons
String dna3 = "xxxxxxxatgxxxxtgataatagxxx";
System.out.println(dna3);
String gene3 = findGene(dna3);
System.out.println("the gene is "+gene3);

// test case5, DNA with “ATG” and random stop codons
String dna4 = "xxxxxxxatgxtagtgaxxxtaaxtaaxxxxtagxxx";
System.out.println(dna4);
String gene4 = findGene(dna4);
System.out.println("the gene is "+gene4);

}
public void printAllGenes(String dna)
{
    int currindex = 0;
    while(true)
    {
        String gene = findGene(dna);
        System.out.println(gene);
        if(gene==""){
            break;
        }
        int posn = dna.indexOf(gene);
        int len = gene.length();
        // dna = atgxxxxxxtaa
        dna = dna.substring(posn+len-1);
        
    }
}
public void testFindStopCodon()
{
    String dna = "ccatgxxtga";
    String stopCodon = "tga";
    int startIndex = 0;
    int answer = findStopCodon(dna,startIndex, stopCodon);
    System.out.println(answer);
    
    String dna1 = "ccccatgxxctaa";
    String stopCodon1 = "taa";
    int startIndex1 = 4;
    int answer1 = findStopCodon(dna1,startIndex1, stopCodon1);
    System.out.println(answer1);
    
    String dna2 = "ccccatgxxctag";
    String stopCodon2 = "tag";
    int startIndex2 = 4;
    int answer2 = findStopCodon(dna2,startIndex2, stopCodon2);
    System.out.println(answer2);
    
    String dna3 = "ccccatgxxctga";
    String stopCodon3 = "taa";
    int startIndex3 = 4;
    int answer3 = findStopCodon(dna3,startIndex3, stopCodon3);
    System.out.println(answer3);
}
}

