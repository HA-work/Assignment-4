// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 2

//*********************************************************************************

// an insertion list of genres
// a tree would probably be better
// then traverse in order accotding to genre times appeared

 public class OrderedGenreList {
  
    public GenreObject first; // first artist in the list
    
    public int count; // number of artists in the list
    // could do artists read for added info but a lot of work
    
    public int numMovies;
    public double avgMovies;
    
    
    
//*********************************************************************************  
    
 //No-Arg Constructor
 
 /* Method public OrderedGenreList():
  * 
  * Input:
  *    None
  * Process:
  *    creates an OrderedGenreList object
  * Output:
  *    None
  */    
    
    public OrderedGenreList(){
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
    
     
/* public void insertGenre(String g, int t)):
  * 
  * Input:
  *    String g the genre name
  *    int t the times the genre appeared
  * Process:
  *    creates a new genre object
  *    if the list is empty it makes the object the first and last item
  *    if it is not it makes the new object the last item and makes the 
  *    objects point to eachother
  * 
  *    uses insertion sort to sort the list
  *    also checks for duplicates and avoids them
  *    sorts based on times appeared
  * 
  *    increments count
  *    adds to the song limit and total views
  *   
  * Output:
  *    None
  */    
    
   
    
  public void insertGenre(String g, int t){ 
     
    // could have a sort method instead
    // quicksort would be a good alternative
    // or a tree 
     
     
    // should have an insert method where appears is a parameter
    // this way it can be checked more
    
    
    // Create the new node
     
    GenreObject add = new GenreObject( g, t);
    
    
    
    
    GenreObject previous = null;
    GenreObject current = first;
    
    
    
      
      
      while ( current != null && add.timesAppeared < current.timesAppeared) {
        
      
        
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
     
    String str = String.format("List of Genres in Descendng order %nNumber of Genres: %d %n", count);
  
    String str2;
    
    boolean found = false;
  
  
   // str2 =  String.format("Number of Artists Read in: %d %n", count);
   // str = str + str2;
    
   
    
    str2 =  String.format("Number of Movies : %d %n", numMovies); 
    str = str + str2;
    
    
     
    str2 =  String.format("Average Movies per Genre: %f %n", avgMovies); 
    str = str + str2;
   
   
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
   
    
     
    str2 = String.format("%-21s %-21s %n","Genre" , "Times appeared");
     
    str = str + str2;
    
    str2 =  String.format("%n"); // new line
    str = str + str2;
    
    str2 = String.format("Genres above or equal to Average %n");
     
    str = str + str2;
     
    // have a seperator for when average is reached
    str2 =  String.format("%n"); // new line
    str = str + str2;
     
     
     //current starts from first
     GenreObject current = first;
     //move forward
     while(current != null) {
     
     
      //    for (int index = 0; index < count; index++){} // alternate loop using count
       
       
       if (found == false && current.timesAppeared < avgMovies)   {
       
          str2 =  String.format("%n"); // new line
          str = str + str2;
         
          str2 = String.format("Genres below Average %n");
     
          str = str + str2;
        
          str2 =  String.format("%n"); // new line
          str = str + str2;
        
          found = true;
       
       
       }
       
      str2 =  current.toString();
      str = str + str2;
       
      str2 =  String.format("%n");
      str = str + str2;
    
      
      current = current.next;
       
     }
    
    
     return str;
   
   }
   
//*********************************************************************************   
}
    
    