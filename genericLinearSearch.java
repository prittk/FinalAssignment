//FINAL ASSIGNMENT
//KASH PRITT
//SE320
public class genericLinearSearch {
	public static void main(String[] args)
	{
		Integer[] list = {3,4,5,1,-3,5,-1};
		
		System.out.println(linearSearch(list,2));
		
		System.out.println(linearSearch(list, 5));
		
		char[] charList = {'a','b','c'};
		//Doesnt accept other elements
		//System.out.println(linearSearch(charList, 'b'));
	}
	//https://www.geeksforgeeks.org/linear-search-vs-binary-search/#
	//https://stackoverflow.com/questions/8537500/java-the-meaning-of-t-extends-comparablet
	//Used to gain the idea on making this
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	{
		 for(int i = 0; i<list.length; i++)
		 {
			 if (list[i].compareTo(key) ==0) //<E Extends Comparable<E>> allow the use of the comparable, without we would have to use list[i].equals(key)
			 {
				 return i;//End search when found
			 }
		 }
		return -1;//Else return 

}
}