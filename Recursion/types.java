//Micheal Callahan
//Project 5
//CST-201 Sarlo
//10/20/22


//-------------------------------------------------------------
//Types Class
//-------------------------------------------------------------

class Types 
{
  //Return true if a slip 
  //O(n)
  public boolean isSlip(String str)
  {
    //Int to go through and change thru if statement
    int c = 0;

    //bool so we can return t or f
    boolean slip = false;
    
    //Check if D or E
    if(str.charAt(c) == 'D' || str.charAt(c) == 'E')
    {
      //Go to next char
      c++;
      
      //While loop for F's
      while(str.charAt(c) == 'F')
      {
        //Next char to get the very last F by using length - 1
        if(c < str.length() - 1)
        {
          c++;  
        }
        //Else break out of loop
        else
        {
          break;
        }
      }   
      //If another slip is next, start recursion (D or E)
      if(str.charAt(c) == 'D' || str.charAt(c) == 'E')
      {
        //Recursive
        return isSlip(str.substring(c));
      }
      //If G then set to true
      else if(str.charAt(c) == 'G' && str.charAt(c - 1) != 'D')
      {
        slip = true;
      }
      //If not G then set to false
      else
      {
        slip = false;
      }
    }

    //Return bool
    return slip;
  }

  //Return true if a slap
  //O(n)
  public boolean isSlap(String str, int count)
  {
    //Int to go through and change thru if statement
    int c = 0;

    //bool so we can return t or f
    boolean slap = false;

    //If A and length is greater than 1 then continue. Also if does not equal 3 as 
    //  that would be abc
    if(str.charAt(c) == 'A' && 1 < str.length() && str.length() != 3)
    {
      //Go to next char
      c++;

      //If next char is H
      if(str.charAt(c) == 'H')
      {
        //Set slap to true if count = 0
        if(count == 0 && str.length() == 2)
        {
          slap = true;
        }
        //Else then go to next char
        else
        {
          //Go to next char then use recursion
          c++;
          return isSlap(str.substring(c), count);
        }
        
      }
      //If a B is the char then run
      else if(str.charAt(c) == 'B')
      {
        //Add 1 to count for the C's and 1 to c to go to next char
        count++;
        c++;

        //Recursion
        return isSlap(str.substring(c), count);
      }
      //If D or E figure out if slip
      else if(str.charAt(c) == 'D' || str.charAt(c) == 'E')
      {
        //Check if there is a G in the str (-1 means no G)
        if(str.indexOf('G') != -1)
        {
          //If slip returns true then recursive
          if(isSlip(str.substring(c, str.indexOf('G') + 1)) == true)
          {
            //Cut out part of string that was a slip
            str = str.substring(str.indexOf('G'));
            
            //Add 1 to count for the C's
            count++;
            
            //Recursion
            return isSlap(str.substring(c), count);
          }
          //Else false
          else
          {
            slap = false;
          }
        }
      }
      
    }

    //If char = C and the count of C's is = to the leftover str length run
    if(str.charAt(c) == 'C' && count == str.length())
    {
      //Look for how many ever the count is
      for(int i = 0; i < count; i++)
      {
        //If C then c++
        if(str.charAt(c) == 'C')
        {
          //If c position = end of length then return true
          if(c == count - 1)
          {
            slap = true;
          }
          //Else add 1 to position
          else
          {
            c++;
          }
        }
        //Else break
        else
        {
          break;
        }
      }
    }
    
    //Return bool
    return slap;
  }

  //Slop
  //O(n)
  public boolean isSlop(String str)
  {
    //Initalize count variable
    int c = 0;

    //Initialize bool variable
    boolean slop = false;

    //If first letter is A then run
    if(str.charAt(c) == 'A')
    {
      //Check if there is a C in the str (-1 means no C)
        if(str.indexOf('C') != -1)
        {
          //If slap returns true then recursive
          if(isSlap(str.substring(c, str.lastIndexOf('C') + 1), 0) == true)
          {
            //Cut out part of string that was a slip
            str = str.substring(str.lastIndexOf('C') + 1);
            
            //If slip is next then return true
            if(isSlip(str) == true)
            {
              slop = true;
            }
            //Else false
            else
            {
              slop = false;
            }
          }
          //Else false
          else
          {
            slop = false;
          }
        }
    }

    //Return slop bool
    return slop;
  }
}
