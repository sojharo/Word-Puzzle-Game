
package wordpuzzlemakerreadfilerrandom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WordPuzzleMakerReadFilerRandom {
    
    public static void main(String []args) throws FileNotFoundException, IOException, NullPointerException
    {
        
        FileReader ca = new FileReader("wordsAll.dat");
        BufferedReader sa = new BufferedReader(ca);
            
        String []wordStore = new String[114179-1000];
        String s=sa.readLine();
        
        try{
            int countWords=0;
            int index=0;
            while(s!=null)
            {
                countWords++;
                s=sa.readLine();
                if(countWords<1003)
                    continue;
                wordStore[index]=s.trim().toLowerCase();
                index++;
            }
        }catch(NullPointerException r)
        {}

        sa.close();
        
        Random r=new Random();
        
        String [][]coordStoredWords=new String[6][6];
        
        for(int i=0; i<coordStoredWords.length; i++)
            for(int j=0; j<coordStoredWords.length; j++)
                coordStoredWords[i][j]=Character.toString(Character.toChars(r.nextInt(26)+97)[0]);
        

        for(int i=0; i<coordStoredWords.length; i++)
        {
            for(int j=0; j<coordStoredWords.length; j++)
            {
                for(int k=0; k<wordStore.length-5; k++)
                {
                    int charNo=0;
                    int matchedCharsCount=0;
                    
                    if(coordStoredWords[i][j].charAt(0)==wordStore[k].charAt(charNo))
                    {
                        charNo++;
                        matchedCharsCount++;
                        int []xCord=new int[wordStore[k].length()];
                        int []yCord=new int[wordStore[k].length()];
                        int cordIndex=0;
                        xCord[cordIndex]=i;
                        yCord[cordIndex]=j;
                        
                        // go downward
                        
                        for(int l=i+1; l<coordStoredWords.length; l++)
                        {
                            if(coordStoredWords[l][j].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=l;
                                yCord[cordIndex]=j;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        // go upward
                        
                        for(int l=i-1; l>=0; l--)
                        {
                            if(coordStoredWords[l][j].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=l;
                                yCord[cordIndex]=j;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        //go forward
                        
                        for(int l=j+1; l<coordStoredWords.length; l++)
                        {
                            if(coordStoredWords[i][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=i;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        // go backward
                        
                        for(int l=j-1; l>=0; l--)
                        {
                            if(coordStoredWords[i][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=i;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        // go forward downward
                        
                        for(int l=j+1, m=i+1; (l<coordStoredWords.length && m<coordStoredWords.length); l++, m++)
                        {
                            if(coordStoredWords[m][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=m;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        // go forward upward
                        
                        for(int l=j+1, m=i-1; (l<coordStoredWords.length && m>=0); l++, m--)
                        {
                            if(coordStoredWords[m][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=m;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                        
                        // go backward downward
                        
                        for(int l=j-1, m=i+1; (l>=0 && m<coordStoredWords.length); l--, m++)
                        {
                            if(coordStoredWords[m][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=m;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                        
                        matchedCharsCount=1;
                        charNo=1;
                        cordIndex=0;
                         
                        // go backward upward
                        
                        for(int l=j-1, m=i-1; (l>=0 && m>=0); l--, m--)
                        {
                            if(coordStoredWords[m][l].charAt(0)==wordStore[k].charAt(charNo))
                            {
                                charNo++;
                                matchedCharsCount++;
                                cordIndex++;
                                xCord[cordIndex]=m;
                                yCord[cordIndex]=l;
                                if(matchedCharsCount==wordStore[k].length())
                                {
                                    charNo=1;
                                    matchedCharsCount=1;
                                    cordIndex=0;
                                    System.out.print("Matched: "+ wordStore[k] +" => ");
                                    for(int ind=0; ind<xCord.length; ind++)
                                        System.out.print("("+ xCord[ind] +", "+ yCord[ind] +") ");
                                    System.out.println();
                                    break;
                                }
                            }
                            else
                            {
                                matchedCharsCount=1;
                                charNo=1;
                                cordIndex=0;
                                break;
                            }
                        }
                    }
                }
                //System.out.print(coordStoredWords[i][j] +"  ");
            }
            //System.out.println();
        }
        
        for(int i=0; i<coordStoredWords.length; i++)
        {
            for(int j=0; j<coordStoredWords.length; j++)
                System.out.print(coordStoredWords[i][j] +"  ");
            System.out.println();
        }
    }
 }
