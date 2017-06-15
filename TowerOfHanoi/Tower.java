package TowerOfHanoi;

public class Tower{
	private int[] data;
	private int last_index;
	private int size;
	
	public Tower(int size) {
	this.size = size;
	data = new int[size];
	last_index = -1;
	}
	
	public void push(int n) throws Exception{
		if(last_index == size-1){
			throw new Exception("The tower is full!");
		}
		else if(this.last_index<0 || n<this.data[this.last_index]){
			this.data[++last_index] = n;
		}
		else{
			throw new Exception("New element is larger than the last element in the tower!");
		}
	}
	
	public int pop() throws Exception{
		if(last_index<0){
			throw new Exception("The tower is empty. Can't pop any items");
		}
		else{
			return this.data[last_index--];
		}
	}

	public void print(){
		for(int i=0; i<=last_index; i++){
			System.out.print(this.data[i] + " ");
		}
		System.out.println();
	}
	
}
