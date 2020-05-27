package Citation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CitanceFileReader 
{
	public static ArrayList<String> readCitanceFiles(ArrayList<String> citance)
	{
		//ArrayList
		ArrayList<String> citances = new ArrayList();
		ArrayList<String> citanceXml = new ArrayList();
		//String
		String citancefile;
		String line;
		//Integer
		int countSection;
		//Hashset
		HashSet<String> sectioncounts = new HashSet();
		
		for(int i = 0;i<citance.size();i++)
		{
				citancefile=citance.get(i);
				
				citanceXml = readFile(citancefile);
				countSection =0;
				for(int j = 0; j<citanceXml.size();j++)
				{
					line = citanceXml.get(j);
					if(line.contains("SECTION")&&line.contains("title"))
					{
						
						//System.out.println(line);
				    countSection++;
					//titles.add(title);
				}
					
					
				
		}
				//only add Files, which have more than 2 titles 
				if(countSection>2)
					{
						//System.out.println(citancefile);
						sectioncounts.add(citancefile);
						//System.out.println(countSection);
						
					}
					
			
				
		}
		
		citances.addAll(sectioncounts);
		return citances;
	}
	public static ArrayList<String> readFile(String filename )
	{
		//ArrayList
		ArrayList<String> CitanceXML = new ArrayList();
		//HashSet
		HashSet<String> xmlCitance = new HashSet();
		File file1 = new File(filename);
	    BufferedReader in = null;
	    if(!file1.canRead()|| !file1.isFile())
	    {
	        System.exit(0);
	    }
	    try{
	        in = new BufferedReader(new FileReader(file1));
	        String zeile = null;
	        while(( zeile= in.readLine())!=null)
	        {
	        	if(zeile.isEmpty()==true)
	        	{
	        		continue;
	        	}
	        	else
	        	{
	        		xmlCitance.add(zeile);
	        	}
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally
	    {
	        if(in !=null)
	            try
	            {
	                in.close();
	            }
	            catch (Exception e)
	            {

	            }
	    }

		CitanceXML.addAll(xmlCitance);
		return CitanceXML;
	}

}

