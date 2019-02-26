import java.util.* ;

public class mainnn {
	public static void main(String[] args){
    String[] family_array = {"Chan", "Kendra", "Yoonmo", "Jongsuk", "Bill"};
    for (String array_name : family_array){
    System.out.println(array_name);
    }
    
		List<String> family = new ArrayList<String>();
		family.add("Chan");
		family.add("Kendra");
		family.add("Yoonmo");
		family.add("Jongsuk");
		family.add("Bill");
		
		for (String names : family){
		System.out.println(names);
		}
	}
	// try with the list too later
}
