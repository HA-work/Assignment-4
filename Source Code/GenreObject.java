// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 3

//*********************************************************************************

//import java.util.*;

 public class GenreObject {
  
    public String genreName; // main movie name
    public int timesAppeared; // alternate name
    public GenreObject next;
   
    
    
    
//*********************************************************************************    
//Parametized Constructor
 
 /* Method public  GenreObject(String g, int t):
  * 
  * Input:
  *    String g the genre name
  *    int t the times appeared
  * Process:
  *    creates a genre object and sets the parameters
  *    
  * Output:
  *    None
  */
   
 public GenreObject(String g, int t){
      
     g = g.trim();
      
     genreName = g;
     
     timesAppeared = t;
   
      
      
     
     
     
    }
    
//*********************************************************************************    
    
    
 /* Method String toString():
  * 
  * Input:
  *    None
  * Process:
  *    makes a formatted string
  * Output:
  *    Returns a formated string of the Genre object for printing
  */
 //toString() method - uses String static method .format()
 
 public String toString() {
   
  String str = String.format("%-21s : %-21d", genreName, timesAppeared);
 
  
  
  
  return str;
 }

    
//*********************************************************************************   
    
}
//*********************************************************************************    