package OOP_assignment_3;

import java.io.*;
import java.util.*;

public class LibraryInfoSystem {
	
	private static final String BOOKSINPUTFILE ="/Users/DabinKIM/Desktop/for_git/JAVA/assignment_3/booksinutfile.txt";
	private static final String STUDENTSINPUTFILE ="/Users/DabinKIM/Desktop/for_git/JAVA/assignment_3/studentsinputfile.txt";
	private static HashMap<String,LibraryItem> Books;
	private static HashMap<String,Student> Students;

	private void init(){
		
		try{
			Scanner scanner=new Scanner(new File(BOOKSINPUTFILE)).useDelimiter("#");
			Books=new HashMap<String,LibraryItem>();
			
			while(scanner.hasNext()){
			
				String[] in=new String[4];
				
				for(int i=0;i<4;i++){
					in[i]=scanner.next();
				}
				scanner.nextLine();

				if(in[3].equals("G")){
					GeneralWorks tmp=new GeneralWorks(in[0],in[1],in[2]);
					Books.put(in[0],tmp);
				}
				else{
					ReservedWorks tmp=new ReservedWorks(in[0],in[1],in[2]);
					Books.put(in[0],tmp);
				}
			}
			
			scanner.close();
			
		}catch(FileNotFoundException e){ 
			System.out.println(e.getMessage()+" Cannot find the FILE!");
			return;
		}
		try{
			Scanner scanner=new Scanner(new File(STUDENTSINPUTFILE)).useDelimiter("#");
			Students=new HashMap<String,Student>();
			
			while(scanner.hasNext()){
				
				String[] in=new String[2];
				
				for(int i=0;i<2;i++){
					in[i]=scanner.next();
				}
				scanner.nextLine();
				
				Student tmp=new Student(in[0],in[1]);
				Students.put(in[1],tmp);
			}
			
			scanner.close();

		} catch(FileNotFoundException e){ 
			System.out.println(e.getMessage()+" Cannot find the FILE!");
			return;
		} 
	}

	public static void main(String[] args) { 
		
		LibraryInfoSystem input=new LibraryInfoSystem();
		input.init();
		int number=0;
		
		while(number!=5){
			
			System.out.println("*******Library Management System*******");
			System.out.println("(1) Borrow an Item:");
			System.out.println("(2) Return an Item:");
			System.out.println("(3) Search for Book");
			System.out.println("(4) Search for Student");
			System.out.println("(5) Exit the program");
			System.out.println("****************************************");

			Scanner keyboard=new Scanner(System.in);
			number=keyboard.nextInt();
			
			switch(number){
				case 1:
					System.out.println("Please enter Student's ID:");
					String id=keyboard.next();
					if(Students.containsKey(id)){
						Student working=Students.get(id);
						System.out.println("Please enter the id of the item to borrow:");
						String book_id=keyboard.next();
						if(Books.containsKey(book_id)){
							if(working.acquireItem(Books.get(book_id))) System.out.println("Book successfully loaned.");
							else System.out.println("Unable to loan.");
						}
						else System.out.println("The book doesn't exist!");
					}
					else System.out.println("The student id is not enrolled!");
					break;
				case 2:
					System.out.println("Please enter Student's ID:");
					String id_2=keyboard.next();
					if(Students.containsKey(id_2)){
						Student working=Students.get(id_2);
						System.out.println("Please enter the id of the item to return:");
						String book_id=keyboard.next();
						if(Books.containsKey(book_id)){
							if(working.releaseItem(Books.get(book_id))) System.out.println("Book successfully returned.");
							else System.out.println("Unable to return.");
						}
						else System.out.println("The book doesn't exist!");
					}
					else System.out.println("The student id is not enrolled!");
					break;
				case 3:
					System.out.println("Please enter the item's id number:");
					String book_id=keyboard.next();
					if(Books.containsKey(book_id)){
						LibraryItem search=Books.get(book_id);
						System.out.println(search.toString());
					}
					else System.out.println("The book doesn't exist!");
					break;
				case 4:
					System.out.println("Please enter the student's id number:");
					String id_3=keyboard.next();
					if(Students.containsKey(id_3)){
						Student search=Students.get(id_3);
						System.out.println(search.toString());
					}
					else System.out.println("The student id is not enrolled!");
					break;
				case 5:
					System.out.println("Exit the Program!");
					break;
			}
		}
	}
}
