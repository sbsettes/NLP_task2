package Citation;
import java.io.File;
import java.util.ArrayList;

public class FindCitation
{
	// the two direction need to be changed , if you use this code on your pc, also the paths in the two files have to changes.
	// this direction works only on my pc!
	 public static String citationdir  ="C:\\Users\\Michaela\\Desktop\\Sommersemester2020\\NLP\\Presentation1\\Citations.txt";
	 public static String annotationdir = "C:\\Users\\Michaela\\Desktop\\Sommersemester2020\\NLP\\Presentation1\\annotation.txt";
 
	public static void main(String[] args) 
	{
		//ArrayLists
		ArrayList<String> citations = new ArrayList();
		ArrayList<String> annotations = new ArrayList();
		citations = CitanceFileReader.readFile(citationdir);
		annotations = CitanceFileReader.readFile(annotationdir);
		ReadXMLandAnnotations.readXMLandAnnotations(citations,annotations);
	}

}
