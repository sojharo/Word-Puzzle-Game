
package wordpuzzlesolver;

import java.util.Random;

public class Main {
    
    public static void main(String []args)
    {
        String []wordStore={"ball", "as", "batch", "this", "hotels", "taaza", "soul",
        "so", "salt", "tool", "latest", "oath", "sat", "tab", "test", "lab", "set"};
        
        String [][]coordStoredWords = 
        {
            {"b", "t", "h", "i", "s", "a"},
            {"a", "a", "o", "a", "t", "h"},
            {"l", "a", "t", "e", "s", "t"},
            {"l", "z", "e", "c", "l", "o"},
            {"a", "a", "l", "a", "h", "o"},
            {"s", "o", "s", "o", "u", "l"}
        };
        
        for(int i=0; i<coordStoredWords.length; i++)
        {
            for(int j=0; j<coordStoredWords.length; j++)
            {
                for(int k=0; k<wordStore.length; k++)
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
        
        Random r=new Random();
        int b=r.nextInt(26)+97;
        char c=Character.toChars(b)[0];
        System.out.println(c+" "+(b-97));
    }
 }
