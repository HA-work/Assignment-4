// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 3

//*********************************************************************************

import java.util.*;

 public class YearObject {
  
    public String year; // main movie name
    public int yearInt; // alternate name
    public OrderedGenreList gl = new OrderedGenreList() ;
 
    
    public int numMovies;
    
    public int numGenres;
    
    public double avgMovies;
    
    public ArrayList<String> listOfGenres = new ArrayList<String>();
    
    public ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
    
    public HashMap genreMap = new HashMap(100);
   
    public YearObject next;
    
    
//*********************************************************************************    
//Parametized Constructor
 
 /* Method public  YearObject(String y):
  * 
  * Input:
  *    String y the year
  * Process:
  *    creates a year object and sets the parameters
  *    
  * Output:
  *    None
  */
   
 public YearObject(String y){
      
     
   
    year = y; 
    yearInt = Integer.parseInt(y); 
      
     
     
     
    }
    
//*********************************************************************************    
    
    
 /* Method String toString():
  * 
  * Input:
  *    None
  * Process:
  *    makes a formatted string
  * Output:
  *    Returns a formated string of the Year object for printing
  */
 //toString() method - uses String static method .format()
 
 public String toString() {
   
   fillList();
   
   
   String str1 = String.format("%n");
          
          
   
   str1 = str1 +  "Year : " + yearInt;
   
   String str2 = String.format("%n");
   
   str1 = str1 + str2;
  
  // str2 = String.format("%n%-21s %-21s %n","Genre" , "Times appeared");
     
 // str1 = str1 + str2;
  
  str2 = String.format(gl.toString());
  
  str1 = str1 + str2;
  
  return str1;
}

    
 
 //*********************************************************************************    
//Parametized Constructor
 
 /* Method public void fillList():
  * 
  * Input:
  *    None
  * Process:
  *    uses the list of genres and the hashmap to fill the ordered list
  *    
  * Output:
  *    None
  */
   // fill ordered list
 public void fillList(){
      
     
   double sum = 0;
   
   for ( int i = 0 ; i < listOfGenres.size() ; i++){
        
        
     
     
        GenreObject temp = (GenreObject) genreMap.get(listOfGenres.get(i));
        
        gl.insertGenre(temp.genreName, temp.timesAppeared);
        
        sum = sum + temp.timesAppeared;
        
       
   }
   
   
     numMovies = listOfMovies.size();
     
     gl.numMovies = numMovies;
     
     numGenres = gl.count;
     
    
     avgMovies = sum/ numGenres;
     
     gl.avgMovies = avgMovies;
     
     
     
     
    }
    
//*********************************************************************************    
 
 
 
 
  
    
}
//*********************************************************************************    