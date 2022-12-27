//Micheal Callahan 
//Project 6 Binary Search Tree
//11-3-22
//CST 201


//-------------------------------------------
//BST class
//-------------------------------------------
class BST
{

  //-------------------------------------------
  //Node class
  //-------------------------------------------
  class Node
  {
    //Initialize variables
    String key;
    Node left, right;

    //Constructor
    public Node(String d)
    {
      //Set key = to data
      key = d;
      left = right = null;
    }  
    
  }

  //Make object of Node class
  Node root;

  //Constructor to initialize root to null
  public BST()
  {
    root = null;
  }

  //Helper method for insert
  void newInsert(String data)
  {
    root = insert(root, data);
  }
  
  //Insert
  Node insert(Node root, String data)
  {
    //If root is null then make data the new root
    if(root == null)
    {
      //Create new node
      Node n = new Node(data);
      
      //set root to reference the new data
      root = n;

      //Return
      return root;
    }

    //If root key is less than data insert left (data > root.data)
    if(data.compareTo(root.key) < 0)
    {
      //Use recursion to insert on left node
      root.left = insert(root.left, data);
    }
    //Else root right 
    else if(data.compareTo(root.key) > 0)
    {
      //Use recursion to insert on right node
      root.right = insert(root.right, data);
    }
    //Return root
    return root;
  }

  //Inorder method to pass the root into inorderPrint
  void inorder()
  {
    inorderPrint(root);
  }

  //Recursive print to do LPR
  void inorderPrint(Node root)
  {
    //If root is not = to null then print
    if(root != null)
    {
      //LPR
      inorderPrint(root.left);
      
      System.out.print(root.key + " ");
      
      inorderPrint(root.right);
    }
  }

  //Search to call searchRecrusive
  boolean searchCall(String data)
  {
    //Create temp node to see what the search finds
    Node temp;
    
    //Call searchRecur
    temp = searchRecur(root, data, 0);

    //If root does not equal null then return true
    if(temp != null)
    {
      return true;
    }
    //Else then false
    else
    {
      return false;
    }    
  }

  //Search recursive
  Node searchRecur(Node root, String data, int count)
  {
    //If root equals null or root = key then return node
    //Either will have gone through finding nothing or have found the word
    if(root == null || data.compareTo(root.key) == 0)
    {
      count++;

      System.out.println("\n" + count + " elements were inspected.");
      return root;
    }
    //If root key is less than data insert left (data > root.data)
    if(data.compareTo(root.key) < 0)
    { 
      count++;
      //Use recursion to insert on left node
      return searchRecur(root.left, data, count);
    }
    //Else root right (data greater than root key)
    else
    {
      count++;
      //Use recursion to insert on right node
      return searchRecur(root.right, data, count);
    }
  }

  //Helper for delete
  String minValue(Node root)
  {
    //Set minval = to root key
    String minVal = root.key;

    //Move left until root.left = null
    if(root.left != null)
    {
      //Minval recursion call root.left
      minValue(root.left);

      //Move root to keep moving left
      root = root.left;
    }

    //Return
    return minVal;
  }

  //Call delete
  void deleteCall(String key)
  {
    root = delete(root, key);
  }

  //Delete method
  Node delete(Node temp, String data)
  {
    //If root equals null then return root
    if(temp == null)
    {
      System.out.println(data + " was not found.");
      return temp;
    }
    //if the data is less than the root.key
    else if(data.compareTo(temp.key) < 0)
    {
      temp.left = delete(temp.left, data);
    }
    //Else if data is bigger than root key then delete right
    else if(data.compareTo(temp.key) > 0)
    {
      temp.right = delete(temp.right, data);
    }
    //Else data if data = root key
    else if(data.compareTo(temp.key) == 0)
    {
      
      //If left node is empty then replace with right node
      if(temp.left == null)
      {
        return temp.right;
      }
      //Else if right node is empty then replace with left node
      else if(temp.right == null)
      {
        return temp.left;
      }

      //Else has two children then find the minValue to set that as the new head
      temp.key = minValue(temp.right);
      temp.right = delete(temp.right, temp.key);

    }
    //Return root
    return temp;
  }
}
