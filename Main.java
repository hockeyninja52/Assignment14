package wk13d3;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		HashTableChaining Hash = new HashTableChaining(10);
		/*
		for(int i = 0; i < 10; i++) {
			input = rand.nextInt(10);
			value = Integer.toString(input);
		}
		*/
		Hash.Insert(1, "6");
		Hash.Insert(2, "7");
		Hash.Insert(3, "4");
		Hash.Insert(4, "0");
		Hash.Insert(5, "3");
		Hash.Insert(6, "9");
		Hash.Insert(7, "8");
		Hash.Insert(8, "2");
		Hash.Insert(9, "1");
		Hash.Insert(0, "5");
		
		/* Adding another 10 values using linear probing
		Hash.Insert(11, "13");
		Hash.Insert(12, "17");
		Hash.Insert(13, "14");
		Hash.Insert(14, "10");
		Hash.Insert(15, "13");
		Hash.Insert(16, "19");
		Hash.Insert(17, "18");
		Hash.Insert(18, "12");
		Hash.Insert(19, "11");
		Hash.Insert(20, "15");
		*/
		
		//removing two value by key and printing
		Node node1 = Hash.Search(6);
		Node node2 = Hash.Search(1);
		System.out.println("The first number is" + " " + node1.Value);
		System.out.println("The second value is" + " " + node2.Value);
		Hash.Display();
		
		
	}

}
