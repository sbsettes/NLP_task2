package Citation;

import java.util.ArrayList;
import java.util.HashSet;

public class CountMethods 
{
	static public String methodline;
	static public String line;
	
	public static int countFacetIntroduction(ArrayList<String> annotations,ArrayList<String> introduction)
	{
		//Integer
		int countmethod =0;
		//Hashset
		HashSet<String> introline = new HashSet();
		for(int i = 0; i<annotations.size();i++)
		{
			methodline = annotations.get(i);
			//System.out.println("Methodline:"+methodline);
			for(int j = 0; j<introduction.size();j++)
			{
				line = introduction.get(j);
				 if(line.contains("<S"))
				 {
					 
				 
				 line=line.substring(line.lastIndexOf("<S"));
				// System.out.println(line);
				 }
				 else
				 {
					 continue;
				 }
				 if(methodline.contains(line))
				 {
					 introline.add(methodline);
					 
				 }
			}
		}
		
		countmethod = introline.size();
		return countmethod;
	}
	public static int countFacetMiddle(ArrayList<String> annotations,ArrayList<String> middle)
	{
		//Integer
		int countmethod =0;
		//HashSet
		HashSet<String> middlemethods = new HashSet();
		for(int i = 0; i<annotations.size();i++)
		{
			methodline = annotations.get(i);
			//System.out.println("Methodline:"+methodline);
			for(int j = 0; j<middle.size();j++)
			{
				line = middle.get(j);
				 if(line.contains("<S"))
				 {
					 
				 
				 line=line.substring(line.lastIndexOf("<S"));
				// System.out.println(line);
				 }
				 else
				 {
					 continue;
				 }
				 if(methodline.contains(line))
				 {
					 middlemethods.add(methodline);
				 }
			}
			
		}
		
		countmethod = middlemethods.size();
		return countmethod;
	}
	public static int countFacetConclusion(ArrayList<String> annotations,ArrayList<String> conclusion)
	{
		//Integer
		int countmethod =0;
		//Hashset
		HashSet<String> conlines = new HashSet();
		for(int i = 0; i<annotations.size();i++)
		{
			methodline = annotations.get(i);
			//System.out.println("Methodline:"+methodline);
			for(int j = 0; j<conclusion.size();j++)
			{
				line = conclusion.get(j);
				 if(line.contains("<S"))
				 {
					 
				 
				 line=line.substring(line.lastIndexOf("<S"));
				// System.out.println(line);
				 }
				 else
				 {
					 continue;
				 }
				 if(methodline.contains(line))
				 {
					 conlines.add(methodline);
				 }
			}
		}
		
		countmethod = conlines.size();
		return countmethod;
	}


}
