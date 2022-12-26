//Micheal Callahan
//Project 7 Hash Table
//CST 201
//17 Novemeber 2022

class LinkedList
{
  //Head of list
  private Node head;

    //Node Class
    class Node 
    {
      String data;      //Variable to store the data
      Node next;     //Variable to store pointer
      
      //Constructor to create Node
      Node(String d)
      {
        data = d;
        next = null;
      }

    }

  //Insert class
  //This will create a new node with given data
  //O(n)
  public Node insert(String d)
  {
    //Create a newNode passing in data
    Node newNode = new Node(d);

    //If list is empty then made head equal to the newNode
    if(head == null)
    {
      head = newNode;
    }
    //Else, move down list till last node and insert newNode
    else
    {
      //Temp = to list.head and pre = to null so pre can be set to temp later
      Node temp = head;
      Node pre = null;
      
      //While temp is not null and d is bigger than temp data move down list
      while(temp != null && d.compareTo(temp.data) > 0) 
      {
        pre = temp;
        temp = temp.next;
      }

      //If temp is not set to list head meaning it moved run this code
      if(temp != head)
      {
        //This lets newNode know that its next node is temp in the list
        newNode.next = temp;
        
        //Pre now knows that its next node is going to be newNode
        pre.next = newNode;
      }
      //If temp has not moved then run this code
      else
      {
        //New Node's next will be temp
        newNode.next = temp;

        //The head is now set = to newNode
        head = newNode;
      }
      
    }
    
    //Return list
    return newNode;
  }

  //Display class
  //O(n)
  public void display()
  {
    //Create a node object
    Node n = head;
    
    //While lastNext does not equal null move down list
    while(n != null)
    {
      //Print
      System.out.print(n.data + " ");
      
      //Set last = to the next node
      n = n.next;    
    }
  }
  
  //Search
  //O(n)
  public boolean search(String d)
  {
    //Create a node object
    Node n = head;

    //Count how many elements looked at
    int count = 1;

    //Boolean for if found or not
    boolean found = false;
    
    //While n does not equal null move down list
    while(n != null)
    {
      //If data = n then it is found
      if(d.compareTo(n.data) == 0)
      {
        found = true;
        System.out.println(d + " was found! " + count + " elements were inspected.");

        break;
      }
      //Else go to next node and add 1 to count
      else
      {
        count++; 
        n = n.next;
      }
    }

    return found;
  }
}