package Citation;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class ReadXMLandAnnotations
{
	public static  void readXMLandAnnotations(ArrayList<String> citationdir, ArrayList<String> annotationdir)
	{
		
		
					//Integer
					int countIntroduction = 0;
					int countMiddle =0;
					int countConclusion = 0;
					int countIntroductionMethod = 0;
					int countMiddleMethod =0;
					int countConclusionMethod = 0;
					int countIntroductionAim = 0;
					int countMiddleAim =0;
					int countConclusionAim= 0;
					int countIntroductionResult = 0;
					int countMiddleResult =0;
					int countConclusionResult = 0;
					int countIntroductionImplication = 0;
					int countMiddleImplication =0;
					int countConclusionImplication = 0;
					int countIntroductionHypothesis= 0;
					int countMiddleHypothesis =0;
					int countConclusionHypothesis= 0;
					
					
					
					
					
				//HashSet
				HashSet<String>citations = new HashSet();
				citations.clear();
				// ArrayList
				 ArrayList<String> citance = new ArrayList();
				 ArrayList<String> annotations = new ArrayList();
				 ArrayList<String> citancesfiles = new ArrayList();
				 ArrayList<String> annotationlines = new ArrayList();
				ArrayList<String> introduction = new ArrayList();
				ArrayList<String> middle = new ArrayList();
				ArrayList<String> conclusion = new ArrayList();
				ArrayList<String> methods = new ArrayList();
				ArrayList<String> facetMethod = new ArrayList();
				ArrayList<String> facetAim = new ArrayList();
				ArrayList<String> facetResult = new ArrayList();
				ArrayList<String> facetImplication = new ArrayList();
				ArrayList<String> facetHypothesis = new ArrayList();
				
				
			citance = FindFiles.findCitationFile(citationdir);
			//System.out.println(citance.size());
		    annotations = FindFiles.findAnnotationFile(annotationdir);
		    
		    
		citancesfiles=CitanceFileReader.readCitanceFiles(citance);	
		methods = AnnotationFileReader.findMethods(annotations);
		facetMethod =AnnotationFileReader.findfacetMethod(methods);
		facetAim = AnnotationFileReader.findfacetAim(methods);
		facetResult = AnnotationFileReader.findfacetResult(methods);
		facetImplication = AnnotationFileReader.findfacetImplication(methods);
		facetHypothesis = AnnotationFileReader.findfacetHypothesis(methods);
		annotationlines = AnnotationFileReader.readannotionFile(annotations);
		introduction = SortLinesIntoGroups.findIntroductionlines(citancesfiles);
		middle = SortLinesIntoGroups.findMiddlelines(citancesfiles);
		conclusion = SortLinesIntoGroups.findConclusionlines(citancesfiles);
		
		//countIntroduction = CountCitations.countIntroductionCitations(annotationlines, introduction);
		//countMiddle = CountCitations.countMiddleCitations(annotationlines, middle);
		//countConclusion = CountCitations.countConclusionCitations(annotationlines, conclusion);
		countIntroductionMethod = CountMethods.countFacetIntroduction(facetMethod, introduction);
	/*	countIntroductionAim = CountMethods.countFacetIntroduction(facetAim, introduction);
		countIntroductionResult = CountMethods.countFacetIntroduction(facetResult, introduction);
		countIntroductionImplication = CountMethods.countFacetIntroduction(facetImplication, introduction);
		countIntroductionHypothesis = CountMethods.countFacetIntroduction(facetHypothesis, introduction);
	
		countMiddleMethod =CountMethods.countFacetMiddle(facetMethod, middle);
		countMiddleAim =CountMethods.countFacetMiddle(facetAim, middle);
		countMiddleResult =CountMethods.countFacetMiddle(facetResult, middle);
		countMiddleImplication =CountMethods.countFacetMiddle(facetImplication, middle);
		*/countMiddleHypothesis =CountMethods.countFacetMiddle(facetHypothesis, middle);
		countConclusionMethod =CountMethods.countFacetConclusion(facetMethod, conclusion);
		countConclusionAim =CountMethods.countFacetConclusion(facetAim, conclusion);
		countConclusionResult =CountMethods.countFacetConclusion(facetResult,  conclusion);
		countConclusionImplication =CountMethods.countFacetConclusion(facetImplication,  conclusion);
		countConclusionHypothesis =CountMethods.countFacetConclusion(facetHypothesis, conclusion);
		
		//System.out.println(countIntroduction);
		//System.out.println(countMiddle);
		//System.out.println(countConclusion);
		/*System.out.println("Method: "+countIntroductionMethod);
		System.out.println("Aim: "+countIntroductionAim);
		System.out.println("Result: "+countIntroductionResult);
		System.out.println("Implication: "+countIntroductionImplication);
		System.out.println("Hypothesis: "+countIntroductionHypothesis);
	
		System.out.println("Method: "+countMiddleMethod);
		System.out.println("Aim: "+countMiddleAim);
		System.out.println("Result: "+countMiddleResult);
		System.out.println("Implication: "+countMiddleImplication);
		System.out.println("Hypothesis: "+countMiddleHypothesis);
		System.out.println("Method: "+countConclusionMethod);
		System.out.println("Aim: "+countConclusionAim);
		System.out.println("Result: "+countConclusionResult);
		System.out.println("Implication: "+countConclusionImplication);
		System.out.println("Hypothesis: "+countConclusionHypothesis);
	*/
	}

	
	 

}
