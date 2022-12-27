//Micheal Callahan
//Project 6 Binary Search Tree
//11-3-22
//CST 201

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//-------------------------------------------
//Main class
//-------------------------------------------

class Main 
{
  public static void main(String[] args) 
  {
    // Initialize variables to read
    BST b = new BST();

    //Insert
    insert(b);

    //Print
    b.inorder();

    //Search
    search(b);
    
    //Delete
    deleteNode(b);
  }

  //Read from a file
  public static void insert(BST b)
  {
    //Initialize variables for try catch
    Scanner fileInput = null;
    String str = "";

    // Try catch to read from file then insert in BST
    try
      {
        fileInput = new Scanner(new File("text.txt"));
      }
      
    // Catch an error
    catch(FileNotFoundException e)
      {
        e.printStackTrace();
      }

    // While loop to read file
    while(fileInput.hasNext())
      {
        //Get rid of all not letter chars
        str = fileInput.next().toLowerCase();
        str = str.replaceAll("[^a-z]", "");
        b.newInsert(str);
      }

    System.out.println();

  }

  //Search for the key
  public static void search(BST b)
  {
    //Variables for while loop
    Scanner scnr = new Scanner(System.in);
    String input = "";
    boolean found = false;

    //While loop for searching
    while(input.compareTo("-1") != 0)
    {
      System.out.print("\n\nEnter a string to search for or -1 to bail out: ");
      input = scnr.next();

      //Call search
      if(input.compareTo("-1") != 0)
      {
        found = b.searchCall(input);

        //Print if word was found or not
        if(found == true)
        {
          System.out.println(input + " was found.");
        }
        else
        {
          System.out.println(input + " was not found.");
        }
      }
    }
  }

  //Delete the key
  public static void deleteNode(BST b)
  {
    //Variables for while loop
    Scanner scnr = new Scanner(System.in);
    String input = "";

    //While loop for deleting
    while(input.compareTo("-1") != 0)
    {
      System.out.print("\n\nEnter a string to delete or -1 to bail out: ");
      input = scnr.next();

      //Call delete
      if(input.compareTo("-1") != 0)
      {
        b.deleteCall(input);
      }
    }

    //Print the list
    System.out.println("\n\nBST now looks like:\n");
    b.inorder();
  }
}
