//Micheal Callahan
//Project 5
//CST-201 Sarlo
//10/20/22


//-------------------------------------------------------------
//Driver Class
//-------------------------------------------------------------

class Main 
{
  public static void main(String[] args) 
  {
    Types t = new Types();

    //Slip . False case EFFFFDG
    String slipTest = ("DFFFFEFFFEFFFG").toUpperCase();

    //Formatting
    System.out.print("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("                   Slip                   ");
    System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      
    if(t.isSlip(slipTest) == true)
    {
      System.out.println("\nTRUE " + slipTest + " is a slip.\n\n");
    }
    else
    {
      System.out.println("\nFALSE " + slipTest + " is NOT a slip.\n\n");  
    }

    //Slap. False case ABC
    String slapTest = ("ABAEFGCC").toUpperCase();

    //Formatting
    System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("                   Slap                   ");
    System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    
    if(t.isSlap(slapTest, 0) == true)
    {
      System.out.println("\nTRUE " + slapTest + " is a slap.\n\n");
    }
    else
    {
      System.out.println("\nFALSE " + slapTest + " is NOT a slap.\n\n");  
    }

    //Slop. AHDFGA false case
    String slopTest = ("ABAEFGCCDFEFFFFFG").toUpperCase();

    //Formatting
    System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("                   Slop                   ");
    System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
    System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

    if(t.isSlop(slopTest) == true)
    {
      System.out.println("\nTRUE " + slopTest + " is a slop.\n\n");
    }
    else
    {
      System.out.println("\nFALSE " + slopTest + " is NOT a slop.\n\n");  
    }
  }
}
