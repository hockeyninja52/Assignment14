package wk13d3;

public class HashTableChaining {
	public int Size;
	public List[] Table;
	
	public HashTableChaining(int InitialSize) {
		this.Size = InitialSize;
		this.Table = new List[this.Size];
	}
	
	public int HashingFunction(int key) {
		return key % this.Size;
	}
	
	public void Insert(int key, String value) {
		int index = HashingFunction(key);
		//this.Table[index] = new List();
		//Gives nullPointerException Error. 
		/*
		Node oldNode = this.Table[index].Search(key);
		if (oldNode != null) {
			oldNode.Value = value;
		} else {
			Node newNode = new Node();
			newNode.Key = key;
			newNode.Value = value;
			this.Table[index].Append(newNode);
		}
		*/
		
		if(this.Table[index]!= null) {
			Node oldNode = this.Table[index].Search(key);
			oldNode.Value = value;
		}else {
			Node newNode = new Node();
			this.Table[index] = new List();
			newNode.Key = key;
			newNode.Value = value;
			this.Table[index].Append(newNode); //gives a NullPointerException error; index is 9; should be inserting node at spot 9
		}
		//System.out.println("done");
	}
	
	
	//Search in the hash table will always give a unique result
	public Node Search(int key) {
		int index = HashingFunction(key);
		return this.Table[index].Search(key);
	}
	
	public void Remove(int key) {
		int index = HashingFunction(key);
		this.Table[index].Remove(key);
	}
	
	public void Display() {
		int index = 0;
		for(int i = 0; i < Table.length; i++) {
			Node pNode = this.Table[index].Search(index);
			pNode = Table[index].Head;
				while(pNode.NextNode != null) {
					System.out.println(pNode.Value);
					pNode = pNode.NextNode;
				}
				System.out.println(pNode.Value);
				index ++;
			
		}
	}
	
	
	public void Resize() {
		//how?
		//the harder questions is what the new size should be in the hashtable
		HashTableChaining newtable = new HashTableChaining(1000);
		//how to loop through all items on the hash table?
		for(int i = 0; i < this.Size; i++) {
			List lst = this.Table[i];
			Node node = lst.Head;
			while (node != null) {
				newtable.Insert(node.Key, node.Value);
				node = node.NextNode;
			}
		}
		this.Size = newtable.Size;
		this.Table = newtable.Table;
	}
	
	/*
	public void add(HashTableChaining Hash) {
		int key = 4;
		String value = "8";
		new HashTableChaining(10).Insert(key,value);
	}
	*/

}
