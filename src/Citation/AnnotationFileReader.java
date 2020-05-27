package Citation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class AnnotationFileReader 
{
	public static String method = "Method";
	public static String result = "Result";
	public static String aim = "Aim";
	public static String hypothesis = "Hypothesis";
	public static String implication = "Implication";
	public static ArrayList<String> readannotionFile(ArrayList<String> annotations)
	{
		//ArrayList
		ArrayList<String> annotationsXML = new ArrayList();
		ArrayList<String> annotationXml = new ArrayList();
		//HashSet
		HashSet<String> citations = new HashSet();
		for(int i =0; i<annotations.size();i++)
		{
			String annotationFile = annotations.get(i);
			annotationXml =readannotation(annotationFile);
			citations.addAll(annotationXml);
			//System.out.print(annotationXml.size());
		}
		annotationsXML.addAll(citations);
		return annotationsXML;
	}
	public static ArrayList<String>readannotation(String annotationFile)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> lines = new HashSet();
		//String
		String number;
		String title;
		String ending;
	    //Integer 
		int numberofCitances =0;
	    File file1 = new File(annotationFile);
	    BufferedReader in = null;
	    if(!file1.canRead()|| !file1.isFile())
	    {
	        System.exit(0);
	    }
	    try{
	        in = new BufferedReader(new FileReader(file1));
	        String line = null;
	        while(( line= in.readLine())!=null)
	        {
	        	if(line.isEmpty()==true)
	        	{
	        		continue;
	        	}
	        	else
	        	{
	        		
	        		number = line.substring(line.lastIndexOf("Citation Text:")+15);
					title = number.substring(number.lastIndexOf("Reference Offset:")-3);
					line = number.substring(0,number.length()-title.length());
					//System.out.println("Line: "+line);
					numberofCitances = readLine(line);
					//System.out.println(numberofCitances);
	        		//annotationsXML.add(line);
					if(numberofCitances >1)
					{
						for(int k = 0;k<(numberofCitances-1);k++)
						{
							ending = line.substring(line.lastIndexOf("<S "));
							//System.out.println("Citance"+ending);
							//System.out.println("Line after ending remove: "+ending);
							lines.add(ending);
							line = line.substring(0,line.length()-ending.length());
						
						}
						
					}
					else
					{	
						//System.out.println(line);
						lines.add(line);
					}
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
	    xmlAnnotation.addAll(lines);
		return xmlAnnotation;
	}
	public static int readLine(String line)
	{
		//Integer
		int countCitances = 0;
		//String
		String ending;
		for(int i= 0; i<line.length();i++)
		{
			
		if(line.contains("</S>"))
		{
			countCitances++;
			ending = line.substring(line.lastIndexOf("</S>"));
			line = line.substring(0,line.length()-ending.length()-1);
			
		}
		else
		{
			continue;
		}
		}
		
		return countCitances;
	}
	public static ArrayList<String> findMethods(ArrayList<String> annotations)
	{
		//ArrayList
		ArrayList<String> methods = new ArrayList();
		ArrayList<String> annotation = new ArrayList();
		annotation = readannotionmethodFile(annotations);
		
		
		return annotation;
	}
	public static ArrayList<String> readannotionmethodFile(ArrayList<String> annotations)
	{
		//ArrayList
		ArrayList<String> annotationsXML = new ArrayList();
		ArrayList<String> annotationXml = new ArrayList();
		//HashSet
		HashSet<String> citations = new HashSet();
		for(int i =0; i<annotations.size();i++)
		{
			String annotationFile = annotations.get(i);
			annotationXml =readannotationmethod(annotationFile);
			citations.addAll(annotationXml);
			//System.out.print(annotationXml.size());
		}
		annotationsXML.addAll(citations);
		
		//System.out.println(citations.size());
		return annotationsXML;
	}
	public static ArrayList<String>readannotationmethod(String annotationFile)
	{
		//ArrayList
				ArrayList<String> xmlAnnotation = new ArrayList();
				//HashSet
				HashSet<String> methods = new HashSet();
			    //Integer 
				int numberofCitances =0;
			    File file1 = new File(annotationFile);
			    BufferedReader in = null;
			    if(!file1.canRead()|| !file1.isFile())
			    {
			        System.exit(0);
			    }
			    try{
			        in = new BufferedReader(new FileReader(file1));
			        String line = null;
			        while(( line= in.readLine())!=null)
			        {
			        	if(line.isEmpty()==true)
			        	{
			        		continue;
			        	}
			        	else
			        	{
			        		methods.add(line);
			        		//System.out.println("Line "+line);
			        	}
			        	}
			        	}
	  catch (FileNotFoundException e) {
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
			    xmlAnnotation.addAll(methods);
			    return xmlAnnotation;
	}
	public static ArrayList<String>findfacetMethod(ArrayList<String> annotationlines)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> methods = new HashSet();
		//String
		String line;
		String annotationline;
		String facet;
		String annotator;
		String ending;
		String open;
		String close;
		String method1 = " ";
		String method2= " ";
		String method3 = " ";
	    //Integer 
		for(int i = 0; i<annotationlines.size(); i++)
		{
			line = annotationlines.get(i);
			annotationline=line;
			facet = line.substring(line.lastIndexOf("Discourse Facet:")+17);
			if(facet.contains("Annotator:"))
    		{
			    annotator = facet.substring(facet.lastIndexOf("Annotator:")-3);
				line = facet.substring(0,facet.length()-annotator.length());
    		}
			else
			{
    			ending = facet.substring(facet.lastIndexOf('|'));
    			line = facet.substring(0,facet.length()-ending.length());
    		}
			if(line.contains("]"))
			{
				open = line.substring(line.lastIndexOf("['")+2);
				close = open.substring(open.lastIndexOf("']"));
				line = open.substring(0,open.length()-close.length());
			//	System.out.println("Line: "+line);
			}
			if(line.contains(","))
			{
				
					method1 = line.substring(line.lastIndexOf('\'')+1);
					//System.out.println("Method1:"+method1);
					line = line.substring(0,line.length()-method1.length());
					ending = line.substring(line.lastIndexOf("',"));
					//System.out.println("Citance"+ending);
					method2 =line.substring(0,line.length()-ending.length());
					//System.out.println("Method2:"+method2);
					//System.out.println("Line after ending remove: "+ending);
			}
			else 
			{
				method3 = line;
			}
			
			if(method1.contains(method)|| method2.contains(method)||method3.contains(method))
			{
				methods.add(annotationline);
			}
		}
	
	    xmlAnnotation.addAll(methods);
	   	return xmlAnnotation;
	}
	public static ArrayList<String>findfacetResult(ArrayList<String> annotationlines)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> methods = new HashSet();
		//String
		String line;
		String annotationline;
		String facet;
		String annotator;
		String ending;
		String open;
		String close;
		String method1 = " ";
		String method2= " ";
		String method3 = " ";
	    //Integer 
		for(int i = 0; i<annotationlines.size(); i++)
		{
			line = annotationlines.get(i);
			annotationline=line;
			facet = line.substring(line.lastIndexOf("Discourse Facet:")+17);
			if(facet.contains("Annotator:"))
    		{
			    annotator = facet.substring(facet.lastIndexOf("Annotator:")-3);
				line = facet.substring(0,facet.length()-annotator.length());
    		}
			else
			{
    			ending = facet.substring(facet.lastIndexOf('|'));
    			line = facet.substring(0,facet.length()-ending.length());
    		}
			if(line.contains("]"))
			{
				open = line.substring(line.lastIndexOf("['")+2);
				close = open.substring(open.lastIndexOf("']"));
				line = open.substring(0,open.length()-close.length());
			//	System.out.println("Line: "+line);
			}
			if(line.contains(","))
			{
				
					method1 = line.substring(line.lastIndexOf('\'')+1);
					//System.out.println("Method1:"+method1);
					line = line.substring(0,line.length()-method1.length());
					ending = line.substring(line.lastIndexOf("',"));
					//System.out.println("Citance"+ending);
					method2 =line.substring(0,line.length()-ending.length());
					//System.out.println("Method2:"+method2);
					//System.out.println("Line after ending remove: "+ending);
			}
			else 
			{
				method3 = line;
			}
			
			if(method1.contains(result)|| method2.contains(result)||method3.contains(result))
			{
				methods.add(annotationline);
			}
		}
	
	    xmlAnnotation.addAll(methods);
	   	return xmlAnnotation;
	}
	public static ArrayList<String>findfacetAim(ArrayList<String> annotationlines)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> methods = new HashSet();
		//String
		String line;
		String annotationline;
		String facet;
		String annotator;
		String ending;
		String open;
		String close;
		String method1 = " ";
		String method2= " ";
		String method3 = " ";
	    //Integer 
		for(int i = 0; i<annotationlines.size(); i++)
		{
			line = annotationlines.get(i);
			annotationline=line;
			facet = line.substring(line.lastIndexOf("Discourse Facet:")+17);
			if(facet.contains("Annotator:"))
    		{
			    annotator = facet.substring(facet.lastIndexOf("Annotator:")-3);
				line = facet.substring(0,facet.length()-annotator.length());
    		}
			else
			{
    			ending = facet.substring(facet.lastIndexOf('|'));
    			line = facet.substring(0,facet.length()-ending.length());
    		}
			if(line.contains("]"))
			{
				open = line.substring(line.lastIndexOf("['")+2);
				close = open.substring(open.lastIndexOf("']"));
				line = open.substring(0,open.length()-close.length());
			//	System.out.println("Line: "+line);
			}
			if(line.contains(","))
			{
				
					method1 = line.substring(line.lastIndexOf('\'')+1);
					//System.out.println("Method1:"+method1);
					line = line.substring(0,line.length()-method1.length());
					ending = line.substring(line.lastIndexOf("',"));
					//System.out.println("Citance"+ending);
					method2 =line.substring(0,line.length()-ending.length());
					//System.out.println("Method2:"+method2);
					//System.out.println("Line after ending remove: "+ending);
			}
			else 
			{
				method3 = line;
			}
			
			if(method1.contains(aim)|| method2.contains(aim)||method3.contains(aim))
			{
				methods.add(annotationline);
			}
		}
	
	    xmlAnnotation.addAll(methods);
	   	return xmlAnnotation;
	}
	public static ArrayList<String>findfacetHypothesis(ArrayList<String> annotationlines)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> methods = new HashSet();
		//String
		String line;
		String annotationline;
		String facet;
		String annotator;
		String ending;
		String open;
		String close;
		String method1 = " ";
		String method2= " ";
		String method3 = " ";
	    //Integer 
		for(int i = 0; i<annotationlines.size(); i++)
		{
			line = annotationlines.get(i);
			annotationline=line;
			facet = line.substring(line.lastIndexOf("Discourse Facet:")+17);
			if(facet.contains("Annotator:"))
    		{
			    annotator = facet.substring(facet.lastIndexOf("Annotator:")-3);
				line = facet.substring(0,facet.length()-annotator.length());
    		}
			else
			{
    			ending = facet.substring(facet.lastIndexOf('|'));
    			line = facet.substring(0,facet.length()-ending.length());
    		}
			if(line.contains("]"))
			{
				open = line.substring(line.lastIndexOf("['")+2);
				close = open.substring(open.lastIndexOf("']"));
				line = open.substring(0,open.length()-close.length());
			//	System.out.println("Line: "+line);
			}
			if(line.contains(","))
			{
				
					method1 = line.substring(line.lastIndexOf('\'')+1);
					//System.out.println("Method1:"+method1);
					line = line.substring(0,line.length()-method1.length());
					ending = line.substring(line.lastIndexOf("',"));
					//System.out.println("Citance"+ending);
					method2 =line.substring(0,line.length()-ending.length());
					//System.out.println("Method2:"+method2);
					//System.out.println("Line after ending remove: "+ending);
			}
			else 
			{
				method3 = line;
			}
			
			if(method1.contains(hypothesis)|| method2.contains(hypothesis)||method3.contains(hypothesis))
			{
				methods.add(annotationline);
			}
		}
	
	    xmlAnnotation.addAll(methods);
	   	return xmlAnnotation;
	}
	public static ArrayList<String>findfacetImplication(ArrayList<String> annotationlines)
	{
		//ArrayList
		ArrayList<String> xmlAnnotation = new ArrayList();
		//HashSet
		HashSet<String> methods = new HashSet();
		//String
		String line;
		String annotationline;
		String facet;
		String annotator;
		String ending;
		String open;
		String close;
		String method1 = " ";
		String method2= " ";
		String method3 = " ";
	    //Integer 
		for(int i = 0; i<annotationlines.size(); i++)
		{
			line = annotationlines.get(i);
			annotationline=line;
			facet = line.substring(line.lastIndexOf("Discourse Facet:")+17);
			if(facet.contains("Annotator:"))
    		{
			    annotator = facet.substring(facet.lastIndexOf("Annotator:")-3);
				line = facet.substring(0,facet.length()-annotator.length());
    		}
			else
			{
    			ending = facet.substring(facet.lastIndexOf('|'));
    			line = facet.substring(0,facet.length()-ending.length());
    		}
			if(line.contains("]"))
			{
				open = line.substring(line.lastIndexOf("['")+2);
				close = open.substring(open.lastIndexOf("']"));
				line = open.substring(0,open.length()-close.length());
			//	System.out.println("Line: "+line);
			}
			if(line.contains(","))
			{
				
					method1 = line.substring(line.lastIndexOf('\'')+1);
					//System.out.println("Method1:"+method1);
					line = line.substring(0,line.length()-method1.length());
					ending = line.substring(line.lastIndexOf("',"));
					//System.out.println("Citance"+ending);
					method2 =line.substring(0,line.length()-ending.length());
					//System.out.println("Method2:"+method2);
					//System.out.println("Line after ending remove: "+ending);
			}
			else 
			{
				method3 = line;
			}
			
			if(method1.contains(implication)|| method2.contains(implication)||method3.contains(implication))
			{
				methods.add(annotationline);
			}
		}
	
	    xmlAnnotation.addAll(methods);
	   	return xmlAnnotation;
	}
}
