//Micheal Callahan
//Project 7 Hash Table
//CST 201
//17 Novemeber 2022

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) 
  {
    //Create new hash object
    Hash h = new Hash();

    // For loop to populate the array with linked lists
    for(int i = 0; i < h.arr.length; i++) 
    {
      h.arr[i] = new LinkedList();
    }

    //Insert txt file
    insert(h);

    //Display
    h.display();

    //Search
    search(h);
  }

  //Read from a file
  //O(n)
  public static void insert(Hash h)
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

        //As long as str does not = whitespace insert
        if(str.compareTo("") != 0) { h.insert(str); }
      }

    System.out.println();

  }

  //Search for the string
  //O(n)
  public static void search(Hash h)
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
        h.search(input);
      }
    }
  }
}