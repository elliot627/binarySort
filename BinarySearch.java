import java.util.ArrayList;

public class BinarySearch {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 99; i++){
			int fresh = (int)(Math.random()*100);
			list.add(fresh);
		}
		System.out.println("\nThe randomly generated list is: --------------------------------------------------" + list);
		System.out.println("\nThe item to be searched for is: " + list.get(0));
		int searchingFor = list.get(0);
		System.out.println("Starting QuickSort....\n");
		quickSort2(list, 0, list.size() - 1);
		System.out.print("\nThe list after quickSort2 is: --------------------------------------------------\n" + list + "\"n");
		//binarySearch(list, searchingFor, 0, list.size()-1);
		System.out.println("\n" + searchingFor + " is located at index " + binarySearch(list, searchingFor, 0, list.size()-1));
		
	}
	
	public static int binarySearch(ArrayList<Integer> list, int value, int left, int right){
		// searches for the value in the ArrayList in the range (left to right) and returns its position
		//if not found, return -1
		if(left > right){
			return -1;
		}
		int midpoint = (left + right)/2;
		if(list.get(midpoint) == value){
			return midpoint;
		}
		if(value < list.get(midpoint)){
			return binarySearch(list, value, left, midpoint - 1);
		}
		else{
			return binarySearch(list, value, midpoint, right);
		}
		
	}
	
	public static void quickSort2(ArrayList<Integer> list, int left, int right){
		if(left >= right){
			return;
		}
		int i = left;
		int j = right;
		int midpoint = (left + right)/2;
		int pivot = list.get(midpoint);
		System.out.println("Pivot is: " + pivot);
		while(i < j){
			while(list.get(i) < pivot){
				i++;
			}
			while(list.get(j) > pivot){
				j--;
			}
			if(i <= j){
				swap(list,i,j);
				i++;
				j--;
			}
		}
		System.out.println("Smaller: " + list.subList(left, j+1));
		System.out.println("Larger: " + list.subList(i, right+1));
		quickSort2(list,left,j);
		quickSort2(list,i,right);
	}
	
	public static  void swap(ArrayList<Integer> list, int firstLoc, int secondLoc){
		int temp = list.get(firstLoc);
		list.set(firstLoc, list.get(secondLoc));
		list.set(secondLoc, temp);
	}
}
