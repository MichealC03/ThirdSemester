//Micheal Callahan
//Project 8 Graph
//CST 201
//1 December, 2022

import java.util.Scanner;

class Main {
  public static void main(String[] args) 
  {
    //Create grid 
    int[][] map = new int[15][15];
    createGrid(map);

    //Print
    display(map);

    //Get the total distance between points
    totalDistance(map);
  }

  //Create grid
  public static void createGrid(int[][] map)
  {
    // Mohave
    map[0][1] = 14;
    map[0][11] = 14;
    map[0][12] = 9;
    
    // Coconino
    map[1][0] = 14;
    map[1][2] = 9;
    map[1][10] = 17;
    map[1][11] = 9;
    
    // Navajo
    map[2][1] = 9;
    map[2][3] = 5;
    map[2][9] = 20;
    map[2][10] = 13;
    
    // Apache
    map[3][2] = 5;
    map[3][4] = 17;
    map[3][9] = 9;
    
    // Greenlee
    map[4][3] = 17;
    map[4][5] = 16;
    map[4][9] = 4;
    
    // Cochise
    map[5][4] = 16;
    map[5][6] = 8;
    map[5][7] = 9;
    map[5][9] = 12;
    
    // Santa Cruz
    map[6][5] = 8;
    map[6][7] = 6;
    
    // Pima
    map[7][5] = 9;
    map[7][6] = 6;
    map[7][8] = 7;
    map[7][9] = 12;
    map[7][13] = 23;
    map[7][14] = 10;
    
    // Pinal
    map[8][7] = 7;
    map[8][9] = 13;
    map[8][10] = 5;
    map[8][14] = 6;
    
    // Graham
    map[9][2] = 20;
    map[9][3] = 19;
    map[9][4] = 4;
    map[9][5] = 12;
    map[9][7] = 12;
    map[9][8] = 13;
    map[9][10] = 7;
    
    // Gila
    map[10][1] = 17;
    map[10][2] = 13;
    map[10][8] = 5;
    map[10][9] = 7;
    map[10][11] = 18;
    map[10][14] = 8;
    
    // Yavapai
    map[11][0] = 14;
    map[11][1] = 9;
    map[11][10] = 18;
    map[11][12] = 15;
    map[11][14] = 9;
    
    // La Paz
    map[12][0] = 9;
    map[12][11] = 15;
    map[12][13] = 11;
    map[12][14] = 15;
    
    // Yuma
    map[13][7] = 23;
    map[13][12] = 11;
    map[13][14] = 18;
    
    // Maricopa
    map[14][7] = 10;
    map[14][8] = 6;
    map[14][10] = 8;
    map[14][11] = 9;
    map[14][12] = 15;
    map[14][13] = 18;
  }

  //Print grid
  public static void display(int[][] map)
  {
    //Strings for color
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String blank = " ";

    System.out.printf("\n%-4s", blank);
    
    //Print labels above the cols
    for(int i = 0; i < 15; i++)
    {
      System.out.printf("%4d", i);
    }

    System.out.println("\n");
    
    //Print the grid
    for(int i = 0; i < 15; i++) 
    {
      System.out.printf("%4d", i);
      for(int j = 0; j < 15; j++) 
      {
        //If coords are not zero then change color
        if(map[i][j] != 0)
        {
          System.out.printf("%s%4d%s", red, map[i][j], reset);
        }
        else
        {
          System.out.printf("%s%4d%s", green, map[i][j], reset);
        }
        
      }
      System.out.println("\n");
    }
  }

  //Get the distance between start and end
  public static void totalDistance(int[][] map)
  {
    //Ints for calculating distance
    int start = 0;
    int end = 0;
    int val = 0;
    
    //Variables for while loop
    Scanner scnr = new Scanner(System.in);
    String input = "";
    String intInput = "";
    boolean cont = false;

    //While loop for searching
    while(input.compareTo("N") != 0)
    {
      System.out.print("\n\nWould you like to find a distance? (Y/N) ");
      input = scnr.next();

      //If yes then continue
      if(input.compareTo("Y") == 0)
      {
        //While loop to make sure correct input entered
        while(!cont)
        {
          //Get the start
          System.out.print("\nEnter a starting point from 0-14: ");
          intInput = scnr.next();

          //If input is 0 to 14 then continue
          if(Integer.valueOf(intInput) >= 0 && Integer.valueOf(intInput) <= 14)
          {
            start = Integer.valueOf(intInput);
            break;
          }
          //Else let user know wrong input entered
          else
          {
            System.out.println("Wrong input...");
          }
        } 
        
        //End point
        while(!cont)
        {
          //Get the start
          System.out.print("\nEnter an end point from 0-14: ");
          intInput = scnr.next();

          //If input is 0 to 14 then continue
          if(Integer.valueOf(intInput) >= 0 && Integer.valueOf(intInput) <= 14)
          {
            end = Integer.valueOf(intInput);
            break;
          }
          //Else let user know wrong input entered
          else
          {
            System.out.println("Wrong input...");
          }
        } 

      //Calculation method
      if(start != end)
      {
        val = calculations(start, end, map);
      }
      
      System.out.println("\nThe value between points " + start + " and " + end + " is: " + val);
      }
    } 
  }

  //Do calculations for totalDistance
  public static int calculations(int s, int e, int[][] map)
  {
    //Int for the current column so end is not messed with
    int curr = e;
    int total = 0;
    boolean dec = false;

    //While loop that runs when element == 0
    while(map[s][curr] == 0)
    {
      //If curr has reach the border then set dec equal to true to decrease curr
      if(curr == 14 && !dec)
      {
        dec = true;
      }

      //If dec is true then -1 to curr
      if(dec)
      {
        curr -= 1;
      }
      //Else then increment
      else
      {
        curr += 1;
      }

      //If the element has a weight then perform this code
      if(map[s][curr] != 0)
      {
        //Print path complete
        System.out.println("Path Complete " + s + " to " + curr);

        //Add weight to total
        total += map[s][curr];

        //Make new start = to curr and curr = to the original end
        s = curr;
        curr = e;

        //Set dec = to false for when it goes back thru while loop
        dec = false;
      }
    }

    //Print and add to total one more time to account for last element
    System.out.println("Path Complete " + s + " to " + curr);
    total += map[s][curr];
    
    return total;
  }
}