package Citation;

import java.util.ArrayList;
import java.util.HashSet;

public class SortLinesIntoGroups
{
	public static ArrayList<String> findIntroductionlines(ArrayList<String> files)
	{
		//ArrayList
		ArrayList<String> introduction = new ArrayList();
		ArrayList<String> citanceXml = new ArrayList();
		//Hashset
		HashSet<String> introductionlines = new HashSet();
		//String
		String file;
		String line;
		String number;
		String title;
		//Integer
		int countSection;
		for(int i = 0;i<files.size();i++)
		{
		
		file=files.get(i);
		
		citanceXml = CitanceFileReader.readFile(file);
		countSection =0;
		for(int j = 0; j<citanceXml.size();j++)
		{
			line = citanceXml.get(j);
			if(line.contains("PAPER")|| line.contains("ABSTRACT"))
			{
				continue;
			}
			else if(line.contains("SECTION")&&line.contains("title"))
			{
				if(line.contains("number"))
				{
					number = line.substring(line.lastIndexOf("number")+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				}
				else 
				{
					
					number = line.substring(line.lastIndexOf('>')+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				
				}
				
				if(title.toLowerCase().contains("introduction"))
				{
					countSection =1;
				}
				else if(title.toLowerCase().contains("conclusion"))
				{
					countSection =3;
				}
				else
				{
					countSection =2;
				}
				//System.out.println(title);
		    
			
			}
			if(countSection ==1 && !line.contains("SECTION"))
			{
				introductionlines.add(line);
			//	System.out.println("Introduction: "+line);
			}
		
			
		}
		
}
		introduction.addAll(introductionlines);
		
		return introduction;
	

	}
	

	public static ArrayList<String> findMiddlelines(ArrayList<String> files)
	{
		//ArrayList
		ArrayList<String> middle = new ArrayList();
		ArrayList<String> citanceXml = new ArrayList();
		//Hashset
		HashSet<String> middlelines = new HashSet();
		//String
		String file;
		String line;
		String number;
		String title;
		//Integer
		int countSection;
		for(int i = 0;i<files.size();i++)
		{
		
		file=files.get(i);
		
		citanceXml = CitanceFileReader.readFile(file);
		countSection =0;
		for(int j = 0; j<citanceXml.size();j++)
		{
			line = citanceXml.get(j);
			if(line.contains("PAPER")|| line.contains("ABSTRACT"))
			{
				continue;
			}
			else if(line.contains("SECTION")&&line.contains("title"))
			{
				if(line.contains("number"))
				{
					number = line.substring(line.lastIndexOf("number")+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				}
				else 
				{
					
					number = line.substring(line.lastIndexOf('>')+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				
				}
				
				if(title.toLowerCase().contains("introduction"))
				{
					countSection =1;
				}
				else if(title.toLowerCase().contains("conclusion"))
				{
					countSection =3;
				}
				else
				{
					countSection =2;
				}
				//System.out.println(title);
		    
			
			}
			 if(countSection == 2 && !line.contains("SECTION"))
			{
				middlelines.add(line);
				//System.out.println("Middle: "+line);
			}
		
			
		}
		
}
		middle.addAll(middlelines);
		
		return middle;
	

	}	public static ArrayList<String> findConclusionlines(ArrayList<String> files)
	{
		//ArrayList
		ArrayList<String> conclusion = new ArrayList();
		ArrayList<String> citanceXml = new ArrayList();
		//Hashset
		HashSet<String> conclusionlines = new HashSet();
		//String
		String file;
		String line;
		String number;
		String title;
		//Integer
		int countSection;
		for(int i = 0;i<files.size();i++)
		{
		
		file=files.get(i);
		
		citanceXml = CitanceFileReader.readFile(file);
		countSection =0;
		for(int j = 0; j<citanceXml.size();j++)
		{
			line = citanceXml.get(j);
			if(line.contains("PAPER")|| line.contains("ABSTRACT"))
			{
				continue;
			}
			else if(line.contains("SECTION")&&line.contains("title"))
			{
				if(line.contains("number"))
				{
					number = line.substring(line.lastIndexOf("number")+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				}
				else 
				{
					
					number = line.substring(line.lastIndexOf('>')+1);
					line = line.substring(0,line.length()-number.length()-1);
					title = line.substring(line.lastIndexOf('=')+1);
				
				}
				
				if(title.toLowerCase().contains("introduction"))
				{
					countSection =1;
				}
				else if(title.toLowerCase().contains("conclusion"))
				{
					countSection =3;
				}
				else
				{
					countSection =2;
				}
				//System.out.println(title);
		    
			
			}
			
			
			 if(countSection ==3 &&!line.contains("SECTION"))
			{
				conclusionlines.add(line);
				//System.out.println("Conclusion: "+line);
			}
			
			
		}
		
}
		conclusion.addAll(conclusionlines);
		
		return conclusion;
	

	}
}
