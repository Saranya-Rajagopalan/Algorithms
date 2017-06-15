package TowerOfHanoi;

import java.util.Scanner;

public class TowerOfHanoi {
	private int number_of_discs;
	private Tower A, B, C;
	private final String demarcator = "----------------------------------------------------";
	private int number_of_moves;

	public TowerOfHanoi(int size) throws Exception {
		this.number_of_discs = size;
		A= new Tower(size);
		for(int i=size; i >= 1; i--){
			A.push(i);
		}
		B= new Tower(size);
		C= new Tower(size);
		number_of_moves = 0;
	}
	
	private void moveTopDisc(Tower source, Tower destination) throws Exception{
		destination.push(source.pop());
		this.number_of_moves++;
		this.printCurrentState();
	}
	
	public void printCurrentState(){
		System.out.println(demarcator);
		System.out.println("MOVE: "+ number_of_moves);
		System.out.print("A :");
		this.A.print();
		System.out.print("B :");
		this.B.print();
		System.out.print("C :");
		this.C.print();
		System.out.println(demarcator);
	}
	
	private void solve(int size, Tower source, Tower destination, Tower temp) throws Exception{
		if(size == 1){
			this.moveTopDisc(source, destination);
			return;
		}
		this.solve(size-1, source, temp, destination);
		this.moveTopDisc(source, destination);
		this.solve(size-1, temp, destination, source);
				
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of discs");
		int n = in.nextInt();
		TowerOfHanoi t = new TowerOfHanoi(n);
		t.solve(t.number_of_discs, t.A, t.C, t.B);
		
	}

}
