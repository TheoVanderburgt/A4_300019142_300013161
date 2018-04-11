import java.util.*;

public class ITIStringBuffer{
	private SinglyLinkedList<String> lis;
	private String str;
	private String tempStr;
	private Iterator<String> i;
	private char[] c;
	private char[] tempChar;
	private char[] tempCharFull;
	private int count;
	private int preCount;
	
   public ITIStringBuffer() {
        lis = new SinglyLinkedList<String>();
		str = "";
		i = lis.iterator();
		count = 0;
		preCount = 0;
    }

    public ITIStringBuffer(String firstString){
        lis = new SinglyLinkedList<String>();
		str = "";
		i = lis.iterator();
		lis.add(firstString);
		count = 0;
		preCount = 0;
    }

    public void append(String nextString){
        lis.add(nextString);
    }

    public String toString(){
		if (i.hasNext() !=true){
			return str;
		}
		
	   tempCharFull = str.toCharArray();
	   while (i.hasNext()){
		   
		   tempStr = i.next();
		   for(int j = 0; j< tempStr.length(); j++){
			 count++;
		   }
		   tempChar = tempStr.toCharArray();
		   
		   c = new char[count];
		   for (int j = 0; j< preCount; j++){
			   c[j] = tempCharFull[j];
		   }
		   
		   for(int l = preCount, k=0; l < count; l++, k++){
			   c[l] = tempChar[k];
		   }
		   preCount = count;
		   tempCharFull = c;
		  
		   
	   }
	   str = String.copyValueOf(c);
	   return str;
	}
}
