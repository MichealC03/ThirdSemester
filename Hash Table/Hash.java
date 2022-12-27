//Micheal Callahan
//Project 7 Hash Table
//CST 201
//17 Novemeber 2022

class Hash
{
  //Create a array of Linked List
  public LinkedList arr[];

  //Create a size var
  public int size = 20;
  
  //Create the hash table
  Hash()
  {
    arr = new LinkedList[size];
  }
  
  //Insert 
  //(O(n)
  void insert(String d)
  {
    //Get val of string
    int strVal = 0;
    for(int i = 0; i < d.length(); i++)
    {
      strVal += d.charAt(i);   
    }

    //Find which bucket to put in by doing val mod size of arr
    int bucket = strVal % size;
    
    //Insert the string into the linkedlist assigned to the bucket
    arr[bucket].insert(d);
  }

  //Dislpay
  //O(n)
  void display()
  {
    //For loop to display all of the values
    for(int i = 0; i < size; i++)
    {
      //Formatting
      if(i < 9 ) { System.out.print(" "); }
      
      //Printing
      System.out.print((i + 1) + ": ");
      arr[i].display();  
      System.out.println();
    }
  }

  //Helper to call search
  //O(n)
  void search(String d)
  {
    //Boolean for if found or not
    boolean found = false;
    
    //For loop to search each LinkedList
    for(int i = 0; i < size; i++)
    {
      found = arr[i].search(d);

      //If found then break
      if(found) { i = size; }
    }

    //If found = false then return that it wasn't found
    if(!found)
    {
      System.out.println(d + " was NOT found... all elements were inspected.");
    }
  }
}
