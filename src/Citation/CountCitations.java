package Citation;

import java.util.ArrayList;

public class CountCitations
{
	public static String line;
	public static int countIntroductionCitations(ArrayList<String> annotations, ArrayList<String> introduction)
	{
		//Integer
		int countIntroduction =0;
		//String
		String line;
		String introductionline;
		for(int j = 0; j < annotations.size(); j++)
		{
			line =annotations.get(j);
			//System.out.println("Line: "+line);
			line = line.substring(line.lastIndexOf("<S"));
			//System.out.println("Line"+line);
			
			for(int k = 0; k<introduction.size();k++)
			{
				
				 introductionline = introduction.get(k);
				// System.out.println("Introduction "+introductionline);
				 if(introductionline.contains("<S"))
				 {
					 
				 
				 introductionline=introductionline.substring(introductionline.lastIndexOf("<S"));
				 }
				 else
				 {
					 continue;
				 }
				if(line.contains(introductionline))
				{
					countIntroduction++;
					
				//	System.out.println("Introduction "+introductionline);
					
				}
			}
		}
		
		return countIntroduction;
	}
	
public static int countMiddleCitations(ArrayList<String> annotations, ArrayList<String> middle)
{
	//Integer
	int countMiddle =0;
	// String
	String middleline;
	for(int j = 0; j < annotations.size(); j++)
	{
		line =annotations.get(j);
		//System.out.println("Line: "+line);
		line = line.substring(line.lastIndexOf("<S"));
		//System.out.println("Line"+line);
		
		for(int k = 0; k<middle.size();k++)
		{
			 middleline = middle.get(k);
			 if(middleline.contains("<S"))
			 {
			 middleline=middleline.substring(middleline.lastIndexOf("<S"));
			//System.out.println("Introduction "+introductionline);
			 } 
			 else
			 {
				 continue;
			 }
			
			if(line.contains(middleline))
			{
				countMiddle++;
				
			//	System.out.println("Middle "+middleline);
				
			}
		}
	}
	
	
	return countMiddle;
	
}
public static int countConclusionCitations(ArrayList<String> annotations, ArrayList<String> conclusion)
{
	//Integer
	int countConclusion =0;
	// String
	String conclusionline;
	for(int j = 0; j < annotations.size(); j++)
	{
		line =annotations.get(j);
		//System.out.println("Line: "+line);
		line = line.substring(line.lastIndexOf("<S"));
		//System.out.println("Line"+line);
		
		for(int k = 0; k<conclusion.size();k++)
		{
			 conclusionline = conclusion.get(k);
			 if(conclusionline.contains("<S"))
			 {
			 conclusionline=conclusionline.substring(conclusionline.lastIndexOf("<S"));
			 }
			 else
			 {
				 continue;
			 }
				if(line.contains(conclusionline))
			{
				countConclusion++;
				
				//System.out.println("Conclusion "+conclusionline);
				
			}
		}
	}
	
	
	return countConclusion;
	
}

}
