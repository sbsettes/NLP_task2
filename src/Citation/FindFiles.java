package Citation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class FindFiles 
{
	public static ArrayList<String> findCitationFile(ArrayList<String> citationFile)
	{
		//Arraylist
		ArrayList<String> citation = new ArrayList();
		ArrayList<String> citations = new ArrayList();
		//HashSet
		HashSet<String> allCitationFiles = new HashSet();
		//String
		String citationfile;
		//File
		File dir;
		for(int i = 0; i<citationFile.size(); i++)
		{
			citationfile = citationFile.get(i);
			dir = new File(citationfile);
			citations = findCitancesFiles(dir);
			allCitationFiles.addAll(citations);
			
		}
		citation.addAll(allCitationFiles);
		
		return citation;
		
	}
	public static ArrayList<String> findCitancesFiles(File dir)
	{
		//ArrayList
		ArrayList<String> citance = new ArrayList();
		//HashSet
		HashSet<String> citanceFiles = new HashSet();
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				//System.out.print(files[i].getAbsolutePath());
				File file1 = files[i];
				String file = file1.getPath();
					if (files[i].isDirectory()) {
					//System.out.println(" (Ordner)\n");
					findCitancesFiles(files[i]); // ruft sich selbst mit dem 
						// Unterverzeichnis als Parameter auf
				}
				else {
					
						if(file.contains(".xml"))
						{
							citanceFiles.add(file);
							//System.out.println(" xmlfile:"+file);
						}
						
					}
			}
		}
		//System.out.println(citanceFiles.size());
		citance.addAll(citanceFiles);
	
		return citance;

	}
	public static ArrayList<String> findAnnotationFile(ArrayList<String> annotationFile)
	{
		//Arraylist
		ArrayList<String> annotation = new ArrayList();
		ArrayList<String> annotations = new ArrayList();
		//HashSet
		HashSet<String> allAnnotationFiles = new HashSet();
		//String
		String annotationfile;
		//File
		File dir;
		for(int i = 0; i<annotationFile.size(); i++)
		{
			annotationfile = annotationFile.get(i);
			dir = new File(annotationfile);
			annotations = findAnnotations(dir);
			allAnnotationFiles.addAll(annotations);
			
		}
		annotation.addAll(allAnnotationFiles);
		
		return annotation;
		
	}
	public static ArrayList<String> findAnnotations(File dir)
	{
		//ArrayList
		ArrayList<String> annotations = new ArrayList();
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				//System.out.print(files[i].getAbsolutePath());
				File file1 = files[i];
				String file = file1.getPath();
					if (files[i].isDirectory()) {
					//System.out.println(" (Ordner)\n");
					findAnnotations(files[i]); // ruft sich selbst mit dem 
						// Unterverzeichnis als Parameter auf
				}
				else {
					
					
					
						annotations.add(file);
						//System.out.println(" annotationfile:"+file);
					
		
				}
			}
		}
		return annotations;
	}
}
