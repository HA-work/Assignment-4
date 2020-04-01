// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

// could be a tree instead
// could have a sort method instead
// quicksort would be good


 public class OrderedYearList {
  
    public YearObject first;
    
    public int count; 
    
    public int numMovies;
    
   
   
    
//*********************************************************************************  
    
 //No-Arg Constructor
 
 /* Method public OrderedYearList():
  * 
  * Input:
  *    None
  * Process:
  *    creates OrderedYearList object
  *    Sets first to null
  *    sets int data members to 0
  * Output:
  *    None
  */    
    
    public OrderedYearList(){
      first = null;
      
      count = 0;
      
      
      
    }
    
    
//*********************************************************************************    
 
  
  
  
    
/* Method public boolean isEmpty():
  * 
  * Input:
  *    None
  * Process:
  *    checks if the linked list is empty
  *    returns true if it is
  *    false if its not
  * Output:
  *    boolean
  */      
    
    
    
    public boolean isEmpty(){
     return (first == null);
    }
    
    
//*********************************************************************************   
    
     
/* public void insertYear(YearObject add):
  * 
  * Input:
  *    YearObject add the year to add to the list
  *    
  * Process:
  *    adds the year object to the list
  * 
  *    uses insertion sort to sort the list
  * 
  *    increments count
  *    
  *    sorts so the earlier date is first
  *   
  * Output:
  *    None
  */    
    
    
    /
    
  public void insertYear(YearObject add){ 
     
     // could have a sort method instead
     
    
    
      YearObject previous = null;
      YearObject current = first;
    
    
    
      
      
      while ( current != null && add.yearInt > current.yearInt) {
        
      
        
        previous = current;
        current = current.next;
        
      }
     
      
  
      
      if (previous == null) {
        
        first = add;
        //last = add;
        
       } else {
        
        previous.next = add;
        
        
        
       }
      
      
      count++;
      
      
      
      add.next = current;
      
      
      
    
  
}


//*********************************************************************************    
     
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the linked list
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
   public String toString() {
     
    String str = String.format("List of Years and Genres %n");
  
    String str2;
    
    
    str2 =  String.format("Number of Years : %d %n", count); //////////////////////
    str = str + str2;
  
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
     
     //current starts from first
     YearObject current = first;
     //move forward
     while(current != null) {
     
    
       
      str2 =  current.toString();
      str = str + str2;
       
      str2 =  String.format("%n");
      str = str + str2;
    
      
      current = current.next;
       
     }
    
    
     return str;
   
   }
   
   
   
//*********************************************************************************    
    
    
/* public String printMovieList() :
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the movies that were used to get the data
  * Output:
  *    None
  */       
  
  // add numbers maybe
  // would be better if ordered
    
   public String printMovieList() {
     
     
    String str = String.format("List of Years and Movies %n");
  
    String str2;
    
    
    str2 =  String.format("Number of Years : %d %n", count); //////////////////////
    str = str + str2;
  
   
    
     
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
   
     
     //current starts from first
     YearObject current = first;
     //move forward
     while(current != null) {
     
    
       
     
       
       str = str +  "Year : " + current.yearInt;
   
       str2 = String.format("%n");
       
       str = str + str2;
       
       
       str = str +  "Number Of Movies : " + current.listOfMovies.size();
   
       str2 = String.format("%n");
       
       str = str + str2;
       
       
       
        for ( int i = 0 ; i < current.listOfMovies.size() ; i++){
        
        
          Movie temp = current.listOfMovies.get(i);
      
          str2 = temp.toString();
      
          str = str + str2;
      
          str2 = String.format("%n");
       
          str = str + str2;
     
        
      
     
       }
       
       
   
       
       
      str2 =  String.format("%n");
      str = str + str2;
    
      
      current = current.next;
       
     }
    
    
     return str;
   
   }
   
   
   
//*********************************************************************************   
}
    
    