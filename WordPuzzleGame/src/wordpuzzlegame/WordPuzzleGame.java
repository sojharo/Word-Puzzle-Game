
package wordpuzzlegame;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class WordPuzzleGame extends Applet implements Runnable, MouseListener
{

    private static final long serialVersionUID = 1L;
	
    Thread runner;
    
    String [][]coordStoredWords;
    
    int [][]xPos;
    int [][]yPos;
    
    Font b;
    Font b2;
    
    ArrayList<String> gotWords;
        
    public void init()
    {
    	this.setSize(900, 500);
        this.setBackground(Color.BLACK);
        
        b=new Font("Arial", 24, 24);
        b2=new Font("Arial", 20, 20);
        
        generatePuzzle();
        while(gotWords.isEmpty())
        {
            System.out.println("Found Empty");
            generatePuzzle();
        }
          
     }
    
    public void generatePuzzle()
    {
        gotWords=new ArrayList<String>();
        
        try{
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
        
        coordStoredWords=new String[6][6];
        xPos=new int[coordStoredWords.length][coordStoredWords.length];
        yPos=new int[coordStoredWords.length][coordStoredWords.length];
        
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
                                    gotWords.add(wordStore[k]);
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
        }catch(FileNotFoundException e)
        {}
        catch(IOException ee)
        {}
        catch(IndexOutOfBoundsException eee)
        {}
        finally
        {}
        
        this.addMouseListener(this);
    }
     public void start()
     {
            if(runner == null )
            {
                runner = new Thread(this);
                runner.start();
            }
     }

     public void stop()
     {
            if(runner != null)
            {
                runner=null;
            }
     }

     public void run()
     {
            while(true)
            {
                
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                repaint();
            }
     }
     
     Random r=new Random();
     public void paint(Graphics g)
     {
         super.paintComponents(g);
         g.setFont(b);
         
         for(int i=0; i<this.getHeight()+200; i+=80)
         {
             for(int j=0; j<this.getWidth()+200; j+=80)
             {
                 int rand=r.nextInt(15);
                 if(rand < 15)
                     g.setColor(Color.YELLOW);
                 if(rand < 10)
                     g.setColor(Color.LIGHT_GRAY);
                 if(rand < 7)
                     g.setColor(Color.CYAN);
                 if(rand < 4)
                     g.setColor(Color.ORANGE);
                 
                 g.fillOval(i+r.nextInt(16), j+r.nextInt(16), rand, rand);
             }
         }
         
             
         for(int i=0, length=100; i<coordStoredWords.length; i++, length+=60)
         {
             for(int j=0, width=100; j<coordStoredWords.length; j++, width+=60)
             {
                 g.setColor(Color.GREEN);
                 g.fillOval(width-12, length-25, 40, 40);
                 xPos[i][j]=width-12;
                 yPos[i][j]=length-25;
                 g.setColor(Color.BLACK);
                 g.drawString(coordStoredWords[i][j], width, length);
             }
         }
         
         g.setColor(Color.red);
         if(gotWords.size()==0)
         {
             g.fill3DRect(2, this.getHeight()-32, 894, 35, true);
             g.setColor(Color.YELLOW);
             g.drawString("Congratulations! You have won this game.", 7, this.getHeight()-10);
             xPos=null;
             yPos=null;
             gotWords.clear();
             //generatePuzzle();
         }
         else
         {
             g.setFont(b2);
             for(int i=0, height=40; i<gotWords.size(); i++, height+=20)
             {
                 g.setColor(Color.CYAN);
                 g.fillRect(this.getWidth()-110, height-15, 100, 25);
                 g.setColor(Color.red);
                 g.drawString(gotWords.get(i), this.getWidth()-100, height);
             }
         }
         
     }

    @Override
    public void mouseClicked(MouseEvent e) throws UnsupportedOperationException {
        try{
        
        }catch(UnsupportedOperationException ee)
        {}
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try{
        
        }catch(UnsupportedOperationException ee)
        {}
    }
    
    
    int letterMatchedNo=0;
    int wordMatchedIndex=-1;
    @Override
    public void mouseReleased(MouseEvent e) {
        try{
            if(e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON1)
            {
                int x=e.getX();
                int y=e.getY();
                
                for(int i=0; i<xPos.length; i++)
                {
                    for(int j=0; j<xPos.length; j++)
                    {
                        if((x>=xPos[i][j] && x<=(xPos[i][j]+40)) && (y>=yPos[i][j] && y<=(yPos[i][j]+40)))
                        {
                            System.out.println("you pressed "+ coordStoredWords[i][j]);
                            if(wordMatchedIndex==-1)
                            {
                                for(int k=0; k<gotWords.size(); k++)
                                {
                                    if(gotWords.get(k).charAt(letterMatchedNo) == coordStoredWords[i][j].charAt(0))
                                    {
                                        System.out.println("letter no "+ (letterMatchedNo+1) +" matched with "+ gotWords.get(k));
                                        wordMatchedIndex=k;
                                        letterMatchedNo++;
                                        break;
                                    }
                                }
                            }
                            else
                            {
                                if(gotWords.get(wordMatchedIndex).charAt(letterMatchedNo) == coordStoredWords[i][j].charAt(0))
                                {
                                    System.out.println("letter no "+ (letterMatchedNo+1) +" matched with "+ gotWords.get(wordMatchedIndex));
                                    letterMatchedNo++;
                                }
                                else
                                {
                                    Boolean found=false;
                                    char characterFirst=gotWords.get(wordMatchedIndex).charAt(0);
                                    while(wordMatchedIndex<gotWords.size())
                                    {
                                        if(gotWords.get(wordMatchedIndex).charAt(0) == characterFirst)
                                        {
                                            if(gotWords.get(wordMatchedIndex).charAt(letterMatchedNo) == coordStoredWords[i][j].charAt(0))
                                            {
                                                System.out.println("Jumped to the next word: "+ gotWords.get(wordMatchedIndex));
                                                found=true;
                                                letterMatchedNo++;
                                                break;
                                            }
                                        }
                                        wordMatchedIndex++;
                                    }
                                    
                                    if(!found)
                                    {
                                        wordMatchedIndex=-1;
                                        letterMatchedNo=0;
                                    }
                                }
                            }
                            if(wordMatchedIndex!=-1)
                            {
                                if(letterMatchedNo == gotWords.get(wordMatchedIndex).length())
                                {
                                    System.out.println("You got one word correct");
                                    gotWords.remove(wordMatchedIndex);
                                    wordMatchedIndex=-1;
                                    letterMatchedNo=0;
                                }
                            }
                        }
                    }
                }
            }
        }catch(UnsupportedOperationException ee)
        {}
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try{
        
        }catch(UnsupportedOperationException ee)
        {}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try{
        
        }catch(UnsupportedOperationException ee)
        {}
    }
}


