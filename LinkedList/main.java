//Micheal Callahan
//Project 2 (Main Class)
//Prof Sarlo CST-201
//20 September, 2022

import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) 
  {
    //Create an object of ssl that makes a new Node class
    LinkedList sll = new LinkedList();

    //Instance of random class
    Random rand = new Random();

    //Insert using for loop
    for(int i = 0; i < 12; i++)
    {
      LinkedList.insert(sll, rand.nextInt(100)); 
    }

    //Display
    LinkedList.display(sll);

    //Return front
    System.out.println("\n\nFront: " + LinkedList.front(sll));

    //Return back
    System.out.println("\nBack: " + LinkedList.back(sll));

    //Delete head
    LinkedList.pop_front(sll);
    System.out.print("\nRemove the front: ");
    LinkedList.display(sll);

    //Delete back
    LinkedList.pop_back(sll);
    System.out.print("\n\nRemove the tail: ");
    LinkedList.display(sll);

    //Get size
    int size = LinkedList.size(sll);
    System.out.print("\n\nThe size of the list is: " + size);

    //Check if empty according to user input
    boolean run = true;
    String ans = "";
    Scanner input = new Scanner(System.in);
    
    while(run)
    {
      //Run until Y or N received
      while(ans.compareTo("Y") != 0 && ans.compareTo("N") != 0)
      {
        System.out.print("\n\nWould you like to see if an index is empty? (Y/N) ");
        ans = input.next();
      }
      
      //If yes then get index
      if(ans.compareTo("Y") == 0)
      {
        System.out.print("\n\nWhat index would you like to examine? ");
        int in = input.nextInt();
        LinkedList.empty(sll,in);

        //Set ans back to null to run again
        ans = "";
      }
      //Else then break
      else
      {
        break;
      }
    }
    input.close();

    //Reverse list
    LinkedList.reverse(sll);
    System.out.print("\n\nReversed list");
    LinkedList.display(sll);

    //Merge lists
    
    //Create a new list
    LinkedList sll2 = new LinkedList();

    //Ppopulate using for loop
    for(int i = 0; i < 3; i++)
    {
      LinkedList.insert(sll2, rand.nextInt(100)); 
    }

    //Display new list
    System.out.print("\n\nNew list:");
    LinkedList.display(sll2);

    //Merge lists then print
    LinkedList.merge(sll,sll2);
    System.out.print("\n\nMerged lists:");
    LinkedList.display(sll);
  }
}
