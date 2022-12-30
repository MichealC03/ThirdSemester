//Micheal Callahan
//Project 2 (LinkedList and Node Classes)
//Prof Sarlo CST-201
//20 September, 2022

class LinkedList
{
  //Head of list
  Node head = null;

    //Node Class
    static class Node 
    {
      int data;      //Variable to store the data
      Node next;     //Variable to store pointer

      //Constructor to create Node
      Node(int d)
      {
        data = d;
        next = null;
      }
    }

  //Insert class
  //This will create a new node with given data
  //O(n)
  //Worked with Trevor Pope on this method
  public static LinkedList insert(LinkedList list, int d)
  {
    //Create a newNode passing in data
    Node newNode = new Node(d);

    //If list is empty then made head equal to the newNode
    if(list.head == null)
    {
      list.head = newNode;
    }
    //Else, move down list till last node and insert newNode
    else
    {
      //Temp = to list.head and pre = to null so pre can be set to temp later
      Node temp = list.head;
      Node pre = null;
      
      //While temp is not null and d is bigger than temp data move down list
      while(temp != null && d > temp.data)
      {
        pre = temp;
        temp = temp.next;
      }

      //If temp is not set to list head meaning it moved run this code
      if(temp != list.head)
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
        list.head = newNode;
      }
      
    }
    
    //Return list
    return list;
  }

  //Display class
  //O(n)
  public static void display(LinkedList list)
  {
    //Create a node object
    Node n = list.head;

    System.out.print("\nLinked List: ");

    //While lastNext does not equal null move down list
    while(n != null)
    {
      //Print
      System.out.print(n.data + " ");
      
      //Set last = to the next node
      n = n.next;    
    }
  }

  //Front class
  //O(1)
  public static int front(LinkedList list)
  {
    //Create new node object
    Node n = list.head;

    //Return front of list
    return n.data;
  }

  //Back class
  //O(n)
  public static int back(LinkedList list)
  {
    //Create new node object
    Node n = list.head;

    //while loop until next == null
    while(n.next != null)
    {
      n = n.next;
    }
    
    //Return front of list
    return n.data;
  }
  
  //Pop front class
  //O(1)
  public static LinkedList pop_front(LinkedList list)
  {
    //Make new node = to the head
    Node temp = list.head;

    //Set head = to next element
    list.head = temp.next;

    return list;

  }

  //Pop back class
  //O(n)
  public static LinkedList pop_back(LinkedList list)
  {
    //Make new node = to head
    Node n = list.head;

    //Make previous node for deleting tail
    Node temp = null;

    //Go through list while setting temp = to n
    while(n.next != null)
    {
      temp = n;
      n = n.next;
    }

    //Temp is = to the second to the last node
    //Set temp.next (50) to n.next (null) which will make temp the new tail
    temp.next = n.next;

    //Return the list
    return list;
  }

  //Check if empty, if not then give value
  //O(n)
  public static void empty(LinkedList list, int in)
  {
    //Set new node = to the list head
    Node n = list.head;

    //For loop to find element at which user asks
    for(int i = 1; i < in; i++)
    {
      //If n.next == null then break
      if(n == null)
      {
        break;
      }

      n = n.next;
    }

    //If n == null then return empty
    if(n == null)
    {
      System.out.println("Element at index " + in + " is empty.");
    }
    //Else return the data at the index
    else
    {
      System.out.println("Element at index " + in + " is " + n.data + ".");
    }
  }

  //Get size of list
  //O(n)
  public static int size(LinkedList list)
  {
    //Intialize node variable to head of list
    Node n = list.head;

    //Initialize count to get size
    int count = 1;

    //Go through list while counting every step
    while(n.next != null)
    {
      count++;
      n = n.next;
    }

    //Return count
    return count;
  }

  //Reverse list
  //O(n)
  //Got help from geeksforgeeks
  public static void reverse(LinkedList list)
  {
    //Initialize variables
    Node pre = null;
    Node curr = list.head;
    Node next;

    //While statement to reverse
    while(curr != null)
    {
      //Set next to curr.next
      next = curr.next;

      //Current now knows it is pointing to the previous node
      curr.next = pre;
      
      //Set pre = to curr which will mean curr.next is now pointing to node val          before it in original ssl
      pre = curr;

      //Moves down the original ssl
      curr = next;
    }

    //Curr is still pointing to one space ahead so make last curr = to head of         node
    list.head = pre;
  }

  //Merge lists
  //O(n)
  public static void merge(LinkedList list, LinkedList list2)
  {
    //Set new node = to the list head
    Node n = list2.head;

    //For loop with size of list2
    for(int i = 0; i < size(list2); i++)
    {
      //Insert the data at start of list2 into list
      insert(list, n.data);

      //Set list2 to next data int it
      n = n.next;
    }
  }
}
