//so remove some specific character in the string, for example "student" if we want to remove "u" and "n" that should returen "stdet" 

public class CharacterRemoval {
	
	 public static String removeChar(String st)
	 {
		 //i will be all the procesed stuff and kept, i is not included
		 //j dwill be all the processed stuff and j is not included
	     int i=0;
	     int j=0;
	     char[] chararray=st.toCharArray();
	     
	     while(j!=st.length())
	     {
	    	 if(chararray[j]!='u' && chararray[j]!='n')
	    	 {
	    		 chararray[i]=chararray[j];
	    		 i++;
	    		 j++;
	    	 }
	    	 else
	    	 {
	    		 j++;
	    		 
	    	 }
	     }
	     return new String(chararray).substring(0, i);
	 }
	
	
	public static void main(String[] args)
	{
		
		String teststring="student";
		String res=removeChar(teststring);
		System.out.println(res);
	}
}
