/*
	creator: masphei @2013
*/
import java.util.Scanner;

public class HashTable{
	private String[] listOfObject;
	private final int MAXIMUM_SIZE = 65516;
	
	public HashTable(){
		listOfObject = new String[MAXIMUM_SIZE];
	}
	public int hashFunction(String key){
		int sum = 0;
		for (int i=0;i<key.length();i++){
			sum += (int)key.charAt(i);
		}
		return sum;
	}
	// insertion
	public void insertKey(String key){
		if (searchKey(key)!= true)
			listOfObject[hashFunction(key)] = key;
	}
	// searching
	public boolean searchKey(String key){
		if (listOfObject[hashFunction(key)]!=null && listOfObject[hashFunction(key)].equals(key))
			return true;
		else return false;
	}
	// deletion
	public void deleteKey(String key){
		if (searchKey(key)== true)
			listOfObject[hashFunction(key)] = null;	
	}
	public void printValues(){
		for (int i=0;i<MAXIMUM_SIZE;i++)
			if(listOfObject[i]!= null)
				System.out.println(listOfObject[i]);
	}
	public static void main(String[] args){
		HashTable table = new HashTable();
		String menu = "1";
		boolean finish = false;
		Scanner ob=new Scanner(System.in);
		while (finish != true){
			System.out.println("#------------------- Menu -------------------#");
			System.out.println("# 1. Insert Key                              #");
			System.out.println("# 2. Search Key                              #");
			System.out.println("# 3. Delete Key                              #");
			System.out.println("# 4. Print All Keys                          #");
			System.out.println("# 5. Exit                                    #");
			System.out.println("#--------------------------------------------#");
			System.out.println("Your choice: (1-5)");
			menu = ob.nextLine(); 
			System.out.println("Your choice: "+menu);
			if (menu.equals("1")){
				System.out.println("Input a key to insert: ");
				menu = ob.nextLine(); 
				table.insertKey(menu);
			}else if (menu.equals("2")){
				System.out.println("Input a key to search: ");
				menu = ob.nextLine(); 
				if (table.searchKey(menu)!= false)
					System.out.println("Key is found");	
				else
					System.out.println("Key is not found");						
			}else if (menu.equals("3")){
				System.out.println("Input a key to delete: ");
				menu = ob.nextLine(); 
				table.deleteKey(menu);
			}else if (menu.equals("4")){
				table.printValues();
			}else if (menu.equals("5")){
				finish = true;
			}else {
				System.out.println("Your choice is invalid. Please try again");
			}
			if (!finish){
				System.out.println("Press enter to continue");
				menu = ob.nextLine(); 
			}
		}
	}
}