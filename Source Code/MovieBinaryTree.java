// Name: Hassan Akbar
// Class: CISC 3115 
// Section: TY9
// Professor Chuang
// Assignment 3

//*********************************************************************************

// file has a lot of edge cases that are hard to all account for

//171495,Cosmos,(no genres listed)
//171631,Maria Bamford: Old Baby,(no genres listed)
//171695,Robin Williams: Live on Broadway (2002),Comedy
//171701,The Death of Louis XIV (2016),Drama
//171749,Death Note: Desu nôto (2006–2007),(no genres listed)
// 69757,(500) Days of Summer (2009),Comedy|Drama|Romance

////2009//69757//Comedy|Drama|Romance//500 Days of Summer 
//'71//2014//117867//Action|Drama|Thriller|War
//'Hellboy': The Seeds of Creation//2004//97757//Action|Adventure|Comedy|Documentary|Fantasy



// some movies with no release dates

//40697,Babylon 5,Sci-Fi
//140956,Ready Player One,Action|Sci-Fi|Thriller





// 161008,The Forbidden Dance (1990),(no genres listed)

// Wonderful, Horrible Life of Leni Riefenstahl, The 

// 27008,From Dusk Till Dawn 2: Texas Blood Money (1999) ,Comedy|Crime|Horror
// for some reason needed white space to be trimmed

//171749,Death Note: Desu nôto (2006–2007),(no genres listed)
// for some reason this has a release range

// movies with no year
// movies with a range as the year
// movies with single quotes
// multiple commas and brackets in the actual name

// multiple names is easy to handle
// multiple , commas in a name is hard to handle
// cant think of a way to fix this






// there are no movies from 5 years ago or more recent in the first 500 data members
// could increase to fix this problem
// would lead to larger input and output though
//*********************************************************************************


import java.io.*; // import file class
import java.util.Scanner; // import scanner
import java.util.ArrayList; // import arraylist
import java.util.*;
// should not print from a class
// easier though
// saved as a string instead

 public class MovieBinaryTree {
  
   
   
   // have an arraylist of genre names
   // can use this to get the names and put in a sorted array at the end
   
    public Movie root; // first movie in the tree
    
    public int count; // number of movies in the tree
    // since we also have an arraylist might not need a count
    
    public Movie firstAlphabeticalMovie;
    public Movie lastAlphabeticalMovie;
    
    // could have methods to find these with tree traversal instead
    
    public int maxSize = 7000;
    // changed
    
    public HashMap hm = new HashMap(100);
    public HashMap hm5Years = new HashMap(100);
    
    // used the default hashmap because making one seemed too difficult
    
    public ArrayList<String> listOfGenres = new ArrayList<String>();
    public ArrayList<String> listOfGenres5Years = new ArrayList<String>();
    
    
    // have two more arraylist with insertion methods for each
    
    public OrderedGenreList gi = new OrderedGenreList() ;
    public OrderedGenreList gi5Years   = new OrderedGenreList() ;
    
    
    public int numberOfMovies; // main movie name
    public int numberOfGenres;
    
    public int numberOfMovies5Years; // main movie name
    public int numberOfGenres5Years;
    
    public double averageMoviesPerGenre;
    public double averageMoviesPerGenre5Years;
    
    
    
    public HashMap hmYears = new HashMap(200);
    
    public OrderedYearList yi = new OrderedYearList() ;
    
    public ArrayList<String> listOfYears = new ArrayList<String>();
    
    // have an arraylist for sorted genres
    // and another one for sorted years
    
    
    // the error file is quite large because of movie names with commas , in it
    // max size can be increased to around 7400 with no major problems
    // some movie titles will be sorted weird because of brackets in the names
    // names with commas , are not sorted and put in an error file
    // cant handle a movie with a range as a release date
    // also some movies have no genre listed
    
    // the main problem comes just after though because the list
    // has a movie that has a year range instead of a release year
    // this is hard to account for but could be
    // would need to be stored as a string though or just take the first year
    
    
    
    // the number of movies is about 9000
    // needed to trim whitespace from some entries when reading in data to work
    
    
    // can write immideately to a file from the class
    // would break convention though
    // would be better though
    // in this case it would be easier and better to break the convention because of the
    // size of the data involved
    
    
    // also aded problem of when a movie with multiple names has commas in the name
    
    
    public String display = "" ; // string representation of tree in alphabetical order
    // should be cleared eachtime
    // should have a get string method that clears the array list and string then calls
    // inOrder to make them again
    
    
    public ArrayList<Movie> listOfMovies = new ArrayList<Movie>();// the tree in 
    // alphabetical list form
    // used to find subsets
    
    public ArrayList<Movie> listOfMovies5Years = new ArrayList<Movie>();

    
//*********************************************************************************    
    
 //Parametized Constructor
 
 /* Method  public MovieBinaryTree(String fileName) throws IOException:
  * 
  * Input:
  *    String fileName the name of the file to read in
  * Process:
  *    reads in a file and parses the data nad inserts it
  *    into the list
  *    also writes errors to the error file
  *    and inserts the movie into the tree
  * Output:
  *    None
  */   
    

  public MovieBinaryTree(String fileName) throws IOException {
    
   
   root = null;
 
    
   // need an error file
   // there are data problems
    
   // error file
   // will have any errors
    
   String errorFileName = ( "errors" + fileName );
   
   // is there a way to append instead?
    
   PrintWriter errorFile = new PrintWriter(errorFileName);   // file
   
   int problemEntries = 0 ;
   
   int lineCount = 2; // data strats from line 2
    
   errorFile.println(" Hassan Akbar"); 
   errorFile.println(" CISC 3130");
   errorFile.println(" Professor Chuang");
   errorFile.println(" HW 1");
   errorFile.println();
     
   // maybe add a way to check if the errors in the file have been corrected  
   // someone would need to manually remove the extra commas
   
   
   errorFile.println("List of errors and line they appear on" );
   
   errorFile.println("File: " + fileName );
   // print file name
     
   errorFile.println();
   
   
   
   // Inputfile
   File inFile = new File(fileName);
     

   //create Scanner object
   Scanner sc = new Scanner(inFile, "UTF-8");
   // fixed the scanner problem by adding "UTF-8" to the creation of the scanner object
   // this increases the character limit of the scanner
       
   String line;
     
  
   line = sc.nextLine(); // skip unneeded line
  
   // 2nd line is where the data starts
   
    
   while (sc.hasNext() && count < maxSize ) {
     // could just be hasNext
     // has some data problems though because of one movie having a release year range 2006-2007
      
     
     // movie names with , in the title cause problems
     // check tokens length
     
     
     //read next line of data 
     line = sc.nextLine();
     

     line = line.replaceAll("\"" , "");
     // remove "" from movie titles
     
     // data stored as
     //171695,Robin Williams: Live on Broadway (2002),Comedy
     // movieId,   movie name (movie release year), genres
     // and sometimes
     // movieId,   movie name (movie alternate name) (movie alternate name) (movie release year), genres
   
     String[] tokens1 = line.split(","); //tokenize a String using method split()
     // will need an error file
     // do not know how to handel movie names with , in the title
     // will put these in an error file
     // the data should have been stored with a different delimitter to avoid this
   
     
     // checks if a title has a comma in it
     
     if (tokens1.length > 3){
       
       do {
         
         
           
        problemEntries++;
        
        errorFile.println("Error Number: " + problemEntries  );
        errorFile.println("Error on Line Number : " + lineCount);
        
        // add number to the start?
        
        errorFile.println(line);
        errorFile.println();
        line = sc.nextLine();
        lineCount++; // increase line count
        tokens1 = line.split(",");
        // checks if a problem occurs
        // skips the problem
        // could save the errors to an array
        // this way the error file can have statistics at the top instead of the bottom
        // decided to print immediately though
         
        // could use a better way to skip
         
       } while (tokens1.length > 3);
     
     
      
       
     }
     
     
     
     
     String movieID = tokens1[0];
   
     String genre = tokens1[2];
     
     // tokens1[1] needs to be split and parsed for titles and year
   
    
     String remainder = tokens1[1];
     
     remainder = remainder.replaceAll("\\)" , "");
     
     String[] tokens2 = remainder.split("\\(");
     
     // reserved characters need to show
     // adding \\ worked
     
     String movieTitle = tokens2[0];
     // the movie title is always the first token
     // the release year depends on how many alternate names there are
     // it is usually the last one though
     // could use size to get it
     
     
     
     Movie movieToAdd = new Movie(movieTitle, movieID, genre);
     
//*********************************************************************************  
     
     // fill the genre hash table
      
    
     
     for(int i=0; i < movieToAdd.genreList.size() ; i++){
       
       if(hm.containsKey(movieToAdd.genreList.get(i))){
         
         GenreObject temp = (GenreObject) hm.get(movieToAdd.genreList.get(i));
         // needed to type cast
         
         temp.timesAppeared = temp.timesAppeared + 1;
         
       } else{
         
         hm.put(movieToAdd.genreList.get(i), new GenreObject(movieToAdd.genreList.get(i),1));
         
         listOfGenres.add(movieToAdd.genreList.get(i));
         //numberOfGenres++;
         
         // should make a genre object with genre name and times appeared
       }
              
     }
     
     
     
     
     
     
     // add the genre to the hashmap
     // check the genrelist
     // if not there place with a count of 1
     // if there increment the value
     
//*********************************************************************************       
     
     if (tokens2.length == 2){
       // no alternate name
       
       int ry = Integer.parseInt(tokens2[1].trim());
       // need to trim any white spaces to reduce errors
       
       movieToAdd.releaseYear = ry ;
       
       
     }
     
     if (tokens2.length == 3){
       // 1 alternate name
       
       movieToAdd.secondName = tokens2[1].trim();
       
       int ry = Integer.parseInt(tokens2[2].trim());
       movieToAdd.releaseYear = ry ;
       
       
     }
     
     
     if (tokens2.length == 4){
       // two alternate names
       
       movieToAdd.secondName = tokens2[1].trim();
       
       movieToAdd.thirdName = tokens2[2].trim();
       
       int ry = Integer.parseInt(tokens2[3].trim());
       movieToAdd.releaseYear = ry ;
       
       
     }
     
     
     
     if (tokens2.length == 5){
       // three alternate names
       
       movieToAdd.secondName = tokens2[1].trim();
       
       movieToAdd.thirdName = tokens2[2].trim();
       
       movieToAdd.fourthName = tokens2[3].trim();
       
       
       int ry = Integer.parseInt(tokens2[4].trim());
       movieToAdd.releaseYear = ry;
       
       
     }
     
     
     
//*********************************************************************************    
     
     
     // could sort the data at the end using quicksort instead of insertion sort
     
     
     String release = "";
     
     // filling the year hash table
     // a year object has a genre hashtable 
     // so need to fill 2 hash tables
     
     // using the hash table to store object refrences
     // so can change the object instead of the value
     
     
     
     release = release + movieToAdd.releaseYear;
     
     if(hmYears.containsKey(release)){
         
         YearObject temp = (YearObject) hmYears.get(release);
         // needed to type cast
         
         temp.listOfMovies.add(movieToAdd);
         
         
         for(int i=0; i < movieToAdd.genreList.size() ; i++){
       
          if(temp.genreMap.containsKey(movieToAdd.genreList.get(i))){
         
            GenreObject temp2 = (GenreObject) temp.genreMap.get(movieToAdd.genreList.get(i));
            // needed to type cast
         
            temp2.timesAppeared = temp2.timesAppeared + 1;
         
          } else{
         
            temp.genreMap.put(movieToAdd.genreList.get(i), new GenreObject(movieToAdd.genreList.get(i),1));
         
            temp.listOfGenres.add(movieToAdd.genreList.get(i));
         
            //temp.listOfMovies.add(movieToAdd);
         
            //temp.gl.insert(movieToAdd.genreList.get(i));
            //numberOfGenres++;
         
            // should make a genre object with genre name and times appeared
          }
              
        }
         
         
         
         
       } else{
         
         listOfYears.add(release);
         
         hmYears.put(release, new YearObject(release));
         
         // yi.insertYear((YearObject) yearsList.get(release));
         
         
         YearObject temp = (YearObject) hmYears.get(release);
         // needed to type cast
         temp.listOfMovies.add(movieToAdd);
         
         for(int i=0; i < movieToAdd.genreList.size() ; i++){
       
           if(temp.genreMap.containsKey(movieToAdd.genreList.get(i))){
         
           GenreObject temp2 = (GenreObject) temp.genreMap.get(movieToAdd.genreList.get(i));
           // needed to type cast
         
            temp2.timesAppeared = temp2.timesAppeared + 1;
         
           } else{
         
            temp.genreMap.put(movieToAdd.genreList.get(i), new GenreObject(movieToAdd.genreList.get(i),1));
         
            temp.listOfGenres.add(movieToAdd.genreList.get(i));
         
            //temp.gl.add(movieToAdd.genreList.get(i));
            //numberOfGenres++;
         
            // should make a genre object with genre name and times appeared
          }
              
        }
         
         
         
         
         //listOfGenres.add(movieToAdd.genreList.get(i));
         //numberOfGenres++;
         
         // should make a genre object with genre name and times appeared
     }
     
     
     
     
//*********************************************************************************       
     
     
     
     
     
     // 5 years needed to be done later because of parsing
     
     
    if (movieToAdd.releaseYear >= 2015 ){
     
      //numberOfMovies5Years++; 
       
      listOfMovies5Years.add(movieToAdd); 
       
      for(int i=0; i < movieToAdd.genreList.size() ; i++){
       
       if(hm5Years.containsKey(movieToAdd.genreList.get(i))){
         
         GenreObject temp = (GenreObject) hm5Years.get(movieToAdd.genreList.get(i));
         // needed to type cast
         
         temp.timesAppeared = temp.timesAppeared + 1;
         
       } else{
         
         hm5Years.put(movieToAdd.genreList.get(i), new GenreObject(movieToAdd.genreList.get(i),1));
         
         listOfGenres5Years.add(movieToAdd.genreList.get(i));
         //numberOfGenres5Years++;
         
         // should make a genre object with genre name and times appeared
       }
              
     }
     
     
   }
     
    
     insertMovie(movieToAdd);
     count++;
     
   
     lineCount++;
     
   
 
}
     
     
   sc.close();
   
   
   
   errorFile.println();
   errorFile.println("Number of Errors in file : " + problemEntries);
   
   
   errorFile.flush();
   errorFile.close();
   
  
   
   double sum = 0;
   
   for(int i=0; i < listOfGenres.size() ; i++){
     
     
     GenreObject temp = (GenreObject) hm.get(listOfGenres.get(i));
    // outFile3.println(temp);
     
     gi.insertGenre(temp.genreName, temp.timesAppeared);
     
     sum = temp.timesAppeared + sum;
     
     
     
   }
   
   
   
   averageMoviesPerGenre = sum / listOfGenres.size();
   
  
   
   double sum2 = 0;
   
   for(int i=0; i < listOfGenres5Years.size() ; i++){
     
     
     GenreObject temp = (GenreObject) hm5Years.get(listOfGenres5Years.get(i));
    // outFile4.println(temp);
     
     
     
     sum2 = temp.timesAppeared + sum2;
     
     gi5Years.insertGenre(temp.genreName, temp.timesAppeared);
     
   }
   
   
   
   averageMoviesPerGenre5Years = sum2 / listOfGenres5Years.size();
  
   
   
 
 
   
   
   
   // put the data in a sorted list insertion
   // have the average
   // output in descending order
   
   
   inOrder(root); // makes the display and list
   
   
   
   
   // print the movies from 2015 to 2020 in a file
   
   
   PrintWriter outFile3 = new PrintWriter("output3.txt");
   
   outFile3.println("Number of Movies in 5 Years : " + listOfMovies5Years.size() );
   
  // not in alphabetical order
  // could be 
  // would take a little more work
   
   
   
   for(int i=0; i < listOfMovies5Years.size() ; i++){
     
     
     Movie temp = listOfMovies5Years.get(i);
     outFile3.println(temp);
     
     
     
   }
   
  
   
   
   outFile3.close();
   
   
   PrintWriter outFile4 = new PrintWriter("output4.txt");
   
   gi.numMovies = listOfMovies.size()  ;
   gi.avgMovies = averageMoviesPerGenre;
   
   outFile4.println(gi.toString());
   
   outFile4.close();
   
   
   
    
   PrintWriter outFile5 = new PrintWriter("output5.txt");
   
   gi5Years.numMovies = listOfMovies5Years.size()  ;
   gi5Years.avgMovies = averageMoviesPerGenre5Years;
   
   outFile5.println("For the last 5 years");
   
   outFile5.println(gi5Years.toString());
   
   outFile5.close();
   
   
   
   
   PrintWriter outFile6 = new PrintWriter("output6.txt");
   
     
     
     
   
   for(int i=0; i < listOfYears.size() ; i++){
     
     // System.out.println(listOfYears.get(i));
     
     YearObject tempo = (YearObject) hmYears.get(listOfYears.get(i));
     
     yi.insertYear(tempo);
     
   
     
   }
   
   
   
   outFile6.println(yi.toString());
   
   outFile6.close();
   
  
   
   
   PrintWriter outFile7 = new PrintWriter("output7.txt");
 
   
   outFile7.println(yi.printMovieList());
   
   outFile7.close();
   
   
   
   
   
   
  }
  
  
 
//*********************************************************************************   
    
     
/* public void insertMovie(Movie add):
  * 
  * Input:
  *    Movie add the movie to put in the tree
  *    String num the number of times the artist appeared
  *    String v the total views of the artist
  *    
  * Process:
  *   adds the movie to the binary tree
  *   
  * Output:
  *    None
  */    
    
     public void insertMovie(Movie add){
     
       if (root == null) {
         
         root = add;
         
         firstAlphabeticalMovie = root;
         
         lastAlphabeticalMovie = root;
         
         
       } else {
         
         
         
         if (add.movieTitle.compareToIgnoreCase(firstAlphabeticalMovie.movieTitle) < 0) {
           
           firstAlphabeticalMovie = add;
           
         }
         
         
         if (add.movieTitle.compareToIgnoreCase(lastAlphabeticalMovie.movieTitle) > 0) {
           
           lastAlphabeticalMovie = add;
           
         }
         
         
         
         Movie current = root;
         Movie parent;
         
         while (true){
           
           parent = current;
           
           if (add.movieTitle.compareToIgnoreCase(current.movieTitle) <= 0) {
             // should not need <= only < as auumed no duplicates
             // there are titles with the same name though as remakes
             // 101 Dalmations
             // i have the left side be less than or equal
             // a better soultion is to give a node a counter
             // but the movies do have other unique information 
             
             // by removing <=  and putting < the same name would go to the right
             
             current = current.leftChild;
             
             if (current == null) {
               // return is how you leave
               
               parent.leftChild = add;
               add.parent = parent;
               return;
               
             } 
             
             // assumed no duplicates because movies are uniqe
             
             
           } else {
             
              
             
             current = current.rightChild;
             
             if (current == null) {
               // return is how you leave
               
               parent.rightChild = add;
               add.parent = parent;
               return;
               
             } 
             
             
             
             
           }
           
           
           
           
         }
         
         
         
         
       }
       
       
       
    }

//*********************************************************************************    
    
    
/* public  public void inOrder(Movie localRoot):
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String of the linked list
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
  // prints the tree in order to a file   
  // can be called to upload the list display
     
  // maybe pass a print writer object as a parameter
     
      public void inOrder(Movie localRoot){
        
        
     
        if (localRoot != null) {
          
          inOrder(localRoot.leftChild);
          
          display = display + String.format(localRoot + "%n"); // adds to the display
         
          listOfMovies.add(localRoot); // adds to the list
         
          inOrder(localRoot.rightChild);
          
          
          
        }
        
        
   
        
        
        
     }
     
     // could use a tree to store the list of movies and genres so we do not need insertion sort
      
     // how to print the contents of a hash map
     // how to go through a hashmap in a certain order
  
//*********************************************************************************   
      
    
    
/* public String toString():
  * 
  * Input:
  *    None
  * Process:
  *    Creates a formated String list of the binary tree
  * Output:
  *    None
  */       
  
  // add numbers maybe
    
  // prints the tree in order to a file   
     
     
      public String toString(){
     
        // clear the list and display first
        // call inorder
        // this ensures the data is fresh
        
        display = "";// refreshes the data
        
        listOfMovies.clear();// refreshes the list
        
        inOrder(root); //sets the diplay and list again
        // this is to keep the data fresh and if any insertions happen beyond the original file
        // not needed though if e assume no extra insertions
        
        
        return display;
        
        
     }
     
     
     
      
      
//*********************************************************************************  
  
  
 
    
/* Method  public String subSet(String start, String end):
  * 
  * Input:
  *    String start where the subset should start from
  *    String end where the subset should end at
  * Process:
  *    searches the list representation of the tree for the subset
  *    makes a string of the section
  * Output:
  *    String str the subset in list form
  */      
    
    
      
    // the return a subset thing should probably use recursion
    // i find it difficult to think recursively though
    // it is easier to think linearly
    // could find the first instance of a subset member and prune the tree from there
      
       
    // better method
    // find the first element that is an instance of the range
    // check its children
    // ignore children that are not in the range
  
    // could try to make this method
    // needs trial and error though
    // also might have problem with duplicates
    
    public String subSet(String start, String end){
      
      boolean startFound, endFound;
      startFound = false;
      endFound = false;
      
   
      
      
      int startIndex = 0 ;
      
      int endIndex = listOfMovies.size() -1 ;
      
      // possible error if the range given reversed like Z to A
      
      // since the list is sorted could use a binary search instead pn the names
      // some names repeat though so linear might be more accurate
      // how does a binary search handle duplicates?
      
      String str = "";
      
      int index1 = 0;
      
      while (startFound == false){
        
        // start
        
        if (start.compareToIgnoreCase(listOfMovies.get(index1).movieTitle) <=0){
          
          
          startFound = true;
          startIndex = index1;
          // find the first intsance that is in the range
          
          
        } else {
        
        
        
        index1++;
          
        }
        
      }
      
      int index2 = listOfMovies.size() - 1;
      // starts searching for the end from the bottom because of duplicates
      
      
      while (endFound == false){
        
        if (end.compareToIgnoreCase(listOfMovies.get(index2).movieTitle) >=0){
          
          // find the last instance in the range
          
          endFound = true;
          endIndex = index2;
          
          
        } else {
        
        
        
        index2--;
          
        }
        
      }
      
      
      
      int subSetCount = endIndex - startIndex + 1;
      // could find by incrementing a count instead
      // this accomplishes the same with less work i think
      
      
      str = str + String.format("Number of Movies found : " + subSetCount + "%n");
      
      
      for( int i =  startIndex; i <= endIndex; i++) {
        
       
        
        str = str + listOfMovies.get(i).toString();
        
        String str2 = String.format("%n");
          
          str = str + str2;
       
        
      }
      
      
     
      
      return str;
      
      
      
      
    }
    
          
      
//*********************************************************************************      
      
      
      
}
    
//*********************************************************************************      