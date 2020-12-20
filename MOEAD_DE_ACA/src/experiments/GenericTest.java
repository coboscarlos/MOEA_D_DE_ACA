package experiments;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.moeaframework.Analyzer;
import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.PRNG;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.TerminationCondition;
import org.moeaframework.core.termination.MaxFunctionEvaluations;
import org.moeaframework.problem.DTLZ.DTLZ1;
import org.moeaframework.problem.DTLZ.DTLZ2;
import org.moeaframework.problem.DTLZ.DTLZ3;
import org.moeaframework.problem.DTLZ.DTLZ4;
import org.moeaframework.problem.DTLZ.DTLZ5;
import org.moeaframework.problem.DTLZ.DTLZ6;
import org.moeaframework.problem.DTLZ.DTLZ7;
import org.moeaframework.problem.WFG.WFG1;
import org.moeaframework.problem.WFG.WFG2;
import org.moeaframework.problem.WFG.WFG3;
import org.moeaframework.problem.WFG.WFG4;
import org.moeaframework.problem.WFG.WFG5;
import org.moeaframework.problem.WFG.WFG6;
import org.moeaframework.problem.WFG.WFG7;
import org.moeaframework.problem.WFG.WFG8;
import org.moeaframework.problem.WFG.WFG9;

import algorithm.StandardAlgorithms;

/**
 * Demonstrates how only a few lines of code are necessary to setup, run
 * and statistically compare multiple algorithms.
 */
public class GenericTest {

	private int Repetitions = 1;  //31 = Based on Central Limit Theorem       
	private String ResultsPath = "D:\\";

	public ArrayList<Configuration> ConfigurationsList;
	
	public void LoadConfigurations(){
		ConfigurationsList = new ArrayList<Configuration>();

		// Experiments with strength 2 and alphabet 9
		// experiment 0
		Configuration k10v9t2 = new Configuration();
		k10v9t2.AcaName = "N136k10v9^10t2.ca";
		k10v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k10v9t2.PopulationSizeAca = 136;
		k10v9t2.CaName = "N81k10v9^10t2.ca";
		k10v9t2.PopulationSizeCa = 81;
		k10v9t2.EsteObjetivo = 10;
		k10v9t2.PositionParametersWFG = k10v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k10v9t2); 

		// experiment 1
		Configuration k20v9t2 = new Configuration();
		k20v9t2.AcaName = "N174k20v9^20t2.ca";
		k20v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k20v9t2.PopulationSizeAca = 174;
		k20v9t2.CaName = "N132k20v9^20t2.ca";
		k20v9t2.PopulationSizeCa = 132;
		k20v9t2.EsteObjetivo = 20;
		k20v9t2.PositionParametersWFG = k20v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k20v9t2); 
		
		// experiment 2
		Configuration k30v9t2 = new Configuration();
		k30v9t2.AcaName = "N197k30v9^30t2.ca";
		k30v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k30v9t2.PopulationSizeAca = 197;
		k30v9t2.CaName = "N148k30v9^30t2.ca";
		k30v9t2.PopulationSizeCa = 148;
		k30v9t2.EsteObjetivo = 30;
		k30v9t2.PositionParametersWFG = k30v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k30v9t2); 

		// experiment 3
		Configuration k40v9t2 = new Configuration();
		k40v9t2.AcaName = "N215k40v9^40t2.ca";
		k40v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k40v9t2.PopulationSizeAca = 215;
		k40v9t2.CaName = "N153k40v9^40t2.ca";
		k40v9t2.PopulationSizeCa = 153;
		k40v9t2.EsteObjetivo = 40;
		k40v9t2.PositionParametersWFG = k40v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k40v9t2); 

		// experiment 4
		Configuration k50v9t2 = new Configuration();
		k50v9t2.AcaName = "N232k50v9^50t2.ca";
		k50v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k50v9t2.PopulationSizeAca = 232;
		k50v9t2.CaName = "N153k50v9^50t2.ca";
		k50v9t2.PopulationSizeCa = 153;
		k50v9t2.EsteObjetivo = 50;
		k50v9t2.PositionParametersWFG = k50v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k50v9t2); 

		// experiment 5
		Configuration k60v9t2 = new Configuration();
		k60v9t2.AcaName = "N245k60v9^60t2.ca";
		k60v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k60v9t2.PopulationSizeAca = 245;
		k60v9t2.CaName = "N153k60v9^60t2.ca";
		k60v9t2.PopulationSizeCa = 153;
		k60v9t2.EsteObjetivo = 60;
		k60v9t2.PositionParametersWFG = k60v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k60v9t2);
		
		// experiment 6
		Configuration k70v9t2 = new Configuration();
		k70v9t2.AcaName = "N256k70v9^70t2.ca";
		k70v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k70v9t2.PopulationSizeAca = 256;
		k70v9t2.CaName = "N153k70v9^70t2.ca";
		k70v9t2.PopulationSizeCa = 153;
		k70v9t2.EsteObjetivo = 70;
		k70v9t2.PositionParametersWFG = k70v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k70v9t2);
		
		// experiment 7
		Configuration k80v9t2 = new Configuration();
		k80v9t2.AcaName = "N266k80v9^80t2.ca";
		k80v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k80v9t2.PopulationSizeAca = 266;
		k80v9t2.CaName = "N153k80v9^80t2.ca";
		k80v9t2.PopulationSizeCa = 153;
		k80v9t2.EsteObjetivo = 80;
		k80v9t2.PositionParametersWFG = k80v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k80v9t2);
		
		// experiment 8
		Configuration k90v9t2 = new Configuration();
		k90v9t2.AcaName = "N277k90v9^90t2.ca";
		k90v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k90v9t2.PopulationSizeAca = 277;
		k90v9t2.CaName = "N153k90v9^90t2.ca";
		k90v9t2.PopulationSizeCa = 153;
		k90v9t2.EsteObjetivo = 90;
		k90v9t2.PositionParametersWFG = k90v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k90v9t2);
		
		// experiment 9
		Configuration k100v9t2 = new Configuration();
		k100v9t2.AcaName = "N288k100v9^100t2.ca";
		k100v9t2.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k100v9t2.PopulationSizeAca = 288;
		k100v9t2.CaName = "N160k100v9^100t2.ca";
		k100v9t2.PopulationSizeCa = 160;
		k100v9t2.EsteObjetivo = 100;
		k100v9t2.PositionParametersWFG = k100v9t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k100v9t2);
		
		// Experiments with strength 2 and alphabet 17
		// experiment 10
		Configuration k10v17t2 = new Configuration();
		k10v17t2.AcaName = "N416k10v17^10t2.ca";
		k10v17t2.alphabetCA = 16; // with v17 you have from 0 to 16, here you put the maximum
		k10v17t2.PopulationSizeAca = 416;
		k10v17t2.CaName = "N416k10v17^10t2.ca"; // Not tested. Use the ACA file
		k10v17t2.PopulationSizeCa = 416;
		k10v17t2.EsteObjetivo = 10;
		k10v17t2.PositionParametersWFG = k10v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k10v17t2); 
		
		// experiment 11
		Configuration k20v17t2 = new Configuration();
		k20v17t2.AcaName = "N514k20v17^20t2.ca";
		k20v17t2.alphabetCA = 16; // with v17 you have from 0 to 16, here you put the maximum
		k20v17t2.PopulationSizeAca = 514;
		k20v17t2.CaName = "N514k20v17^20t2.ca"; // Not tested. Use the ACA file
		k20v17t2.PopulationSizeCa = 514;
		k20v17t2.EsteObjetivo = 20;
		k20v17t2.PositionParametersWFG = k20v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k20v17t2); 
		
		// experiment 12
		Configuration k30v17t2 = new Configuration();
		k30v17t2.AcaName = "N679k30v17^30t2.ca";
		k30v17t2.alphabetCA = 16; // with v17 you have from 0 to 16, here you put the maximum
		k30v17t2.PopulationSizeAca = 679;
		k30v17t2.CaName = "N679k30v17^30t2.ca"; // Not tested. Use the ACA file
		k30v17t2.PopulationSizeCa = 679;
		k30v17t2.EsteObjetivo = 30;
		k30v17t2.PositionParametersWFG = k30v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k30v17t2); 
		
		// experiment 13
		Configuration k40v17t2 = new Configuration();
		k40v17t2.AcaName = "N727k40v17^40t2.ca";
		k40v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k40v17t2.PopulationSizeAca = 727;
		k40v17t2.CaName = "N727k40v17^40t2.ca"; // Not tested. Use the ACA file
		k40v17t2.PopulationSizeCa = 727;
		k40v17t2.EsteObjetivo = 40;
		k40v17t2.PositionParametersWFG = k40v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k40v17t2);
		
		// experiment 14
		Configuration k50v17t2 = new Configuration();
		k50v17t2.AcaName = "N753k50v17^50t2.ca";
		k50v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k50v17t2.PopulationSizeAca = 753;
		k50v17t2.CaName = "N753k50v17^50t2.ca"; // Not tested. Use the ACA file
		k50v17t2.PopulationSizeCa = 753;
		k50v17t2.EsteObjetivo = 50;
		k50v17t2.PositionParametersWFG = k50v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k50v17t2);
		
		// experiment 15
		Configuration k60v17t2 = new Configuration();
		k60v17t2.AcaName = "N763k60v17^60t2.ca";
		k60v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k60v17t2.PopulationSizeAca = 763;
		k60v17t2.CaName = "N763k60v17^60t2.ca"; // Not tested. Use the ACA file
		k60v17t2.PopulationSizeCa = 763;
		k60v17t2.EsteObjetivo = 60;
		k60v17t2.PositionParametersWFG = k60v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k60v17t2);

		// experiment 16
		Configuration k70v17t2 = new Configuration();
		k70v17t2.AcaName = "N785k70v17^70t2.ca";
		k70v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k70v17t2.PopulationSizeAca = 785;
		k70v17t2.CaName = "N785k70v17^70t2"; // Not tested. Use the ACA file
		k70v17t2.PopulationSizeCa = 785;
		k70v17t2.EsteObjetivo = 70;
		k70v17t2.PositionParametersWFG = k70v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k70v17t2);

		// experiment 17
		Configuration k80v17t2 = new Configuration();
		k80v17t2.AcaName = "N807k80v17^80t2.ca";
		k80v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k80v17t2.PopulationSizeAca = 807;
		k80v17t2.CaName = "N838k80v17^80t2.ca"; // Not tested. Use the ACA file
		k80v17t2.PopulationSizeCa = 807;
		k80v17t2.EsteObjetivo = 80;
		k80v17t2.PositionParametersWFG = k80v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k80v17t2);
		
		// experiment 18
		Configuration k90v17t2 = new Configuration();
		k90v17t2.AcaName = "N824k90v17^90t2.ca";
		k90v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k90v17t2.PopulationSizeAca = 824;
		k90v17t2.CaName = "N824k90v17^90t2.ca"; // Not tested. Use the ACA file
		k90v17t2.PopulationSizeCa = 824;
		k90v17t2.EsteObjetivo = 90;
		k90v17t2.PositionParametersWFG = k90v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k90v17t2);
		
		// experiment 19
		Configuration k100v17t2 = new Configuration();
		k100v17t2.AcaName = "N838k100v17^100t2.ca";
		k100v17t2.alphabetCA = 16; // with v9 you have from 0 to 8, here you put the maximum
		k100v17t2.PopulationSizeAca = 838;
		k100v17t2.CaName = "N838k100v17^100t2.ca"; // Not tested. Use the ACA file
		k100v17t2.PopulationSizeCa = 838;
		k100v17t2.EsteObjetivo = 100;
		k100v17t2.PositionParametersWFG = k100v17t2.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k100v17t2);
		
		// Experiments with strength 3 and alphabet 9
		// experiment 20
		Configuration k10v9t3 = new Configuration();
		k10v9t3.AcaName = "N729k10v9^10t3.ca";
		k10v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k10v9t3.PopulationSizeAca = 729;
		k10v9t3.CaName = "N729k10v9^10t3.ca"; // Not tested. Use the ACA file
		k10v9t3.PopulationSizeCa = 729;
		k10v9t3.EsteObjetivo = 10;
		k10v9t3.PositionParametersWFG = k10v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k10v9t3);
		
		// experiment 21
		Configuration k20v9t3 = new Configuration();
		k20v9t3.AcaName = "N1377k20v9^20t3.ca";
		k20v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k20v9t3.PopulationSizeAca = 1377;
		k20v9t3.CaName = "N1377k20v9^20t3.ca"; // Not tested. Use the ACA file
		k20v9t3.PopulationSizeCa = 1377;
		k20v9t3.EsteObjetivo = 20;
		k20v9t3.PositionParametersWFG = k20v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k20v9t3);
		
		// experiment 22
		Configuration k30v9t3 = new Configuration();
		k30v9t3.AcaName = "N1449k30v9^30t3.ca";
		k30v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k30v9t3.PopulationSizeAca = 1449;
		k30v9t3.CaName = "N1449k30v9^30t3.ca"; // Not tested. Use the ACA file
		k30v9t3.PopulationSizeCa = 1449;
		k30v9t3.EsteObjetivo = 30;
		k30v9t3.PositionParametersWFG = k30v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k30v9t3);
		
		// experiment 23
		Configuration k40v9t3 = new Configuration();
		k40v9t3.AcaName = "N1449k40v9^40t3.ca";
		k40v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k40v9t3.PopulationSizeAca = 1449;
		k40v9t3.CaName = "N1449k40v9^40t3.ca"; // Not tested. Use the ACA file
		k40v9t3.PopulationSizeCa = 1449;
		k40v9t3.EsteObjetivo = 40;
		k40v9t3.PositionParametersWFG = k40v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k40v9t3);
		
		// experiment 24
		Configuration k50v9t3 = new Configuration();
		k50v9t3.AcaName = "N1449k50v9^50t3.ca";
		k50v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k50v9t3.PopulationSizeAca = 1449;
		k50v9t3.CaName = "N1449k50v9^50t3.ca"; // Not tested. Use the ACA file
		k50v9t3.PopulationSizeCa = 1449;
		k50v9t3.EsteObjetivo = 50;
		k50v9t3.PositionParametersWFG = k50v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k50v9t3);	
		
		// experiment 25
		Configuration k60v9t3 = new Configuration();
		k60v9t3.AcaName = "N1449k60v9^60t3.ca";
		k60v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k60v9t3.PopulationSizeAca = 1449;
		k60v9t3.CaName = "N1449k60v9^60t3.ca"; // Not tested. Use the ACA file
		k60v9t3.PopulationSizeCa = 1449;
		k60v9t3.EsteObjetivo = 60;
		k60v9t3.PositionParametersWFG = k60v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k60v9t3);
		
		// experiment 26
		Configuration k70v9t3 = new Configuration();
		k70v9t3.AcaName = "N1449k70v9^70t3.ca";
		k70v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k70v9t3.PopulationSizeAca = 1449;
		k70v9t3.CaName = "N1449k70v9^70t3.ca"; // Not tested. Use the ACA file
		k70v9t3.PopulationSizeCa = 1449;
		k70v9t3.EsteObjetivo = 70;
		k70v9t3.PositionParametersWFG = k70v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k70v9t3);
		
		// experiment 27
		Configuration k80v9t3 = new Configuration();
		k80v9t3.AcaName = "N1457k80v9^80t3.ca";
		k80v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k80v9t3.PopulationSizeAca = 1457;
		k80v9t3.CaName = "N1457k80v9^80t3.ca"; // Not tested. Use the ACA file
		k80v9t3.PopulationSizeCa = 1457;
		k80v9t3.EsteObjetivo = 80;
		k80v9t3.PositionParametersWFG = k80v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k80v9t3);
		
		// experiment 28
		Configuration k90v9t3 = new Configuration();
		k90v9t3.AcaName = "N1457k90v9^90t3.ca";
		k90v9t3.alphabetCA = 8; // with v9 you have from 0 to 8, here you put the maximum
		k90v9t3.PopulationSizeAca = 1457;
		k90v9t3.CaName = "N1457k90v9^90t3.ca"; // Not tested. Use the ACA file
		k90v9t3.PopulationSizeCa = 1457;
		k90v9t3.EsteObjetivo = 90;
		k90v9t3.PositionParametersWFG = k90v9t3.EsteObjetivo - 1; // One less than the number of objectives
		ConfigurationsList.add(k90v9t3);
	}
	
	public void Execute(int IdExperiment) throws IOException {
		LoadConfigurations();
		Configuration currentExperiment = ConfigurationsList.get(IdExperiment);
		
		String[] problems = {"DTLZ1", "DTLZ2", "DTLZ3", "DTLZ4", "DTLZ5", "DTLZ6", "DTLZ7", "WFG1", "WFG2", "WFG3", "WFG4", "WFG5", "WFG6", "WFG7", "WFG8", "WFG9"}; 
		String[] algorithms = {"MOEAD", "MOEAD2", "NSGAIII"}; // , "IBEA", "MSOPS", "NSGAII", "SPEA2", "MSOPS"

		String txtCAFileName = currentExperiment.AcaName;			
		int populationSize = currentExperiment.PopulationSizeAca;
		int alphabetCA = currentExperiment.alphabetCA;
		int thisObjective = currentExperiment.EsteObjetivo;
		int positionParametersWFG = currentExperiment.PositionParametersWFG;
		
		for (String txtproblem: problems){
					
			Problem problem = null;
			int maxGenerations = 0;
			
			switch(txtproblem){
				case "DTLZ1": problem = new DTLZ1(thisObjective); maxGenerations = 600; break;
				case "DTLZ2": problem = new DTLZ2(thisObjective); maxGenerations = 500; break;
				case "DTLZ3": problem = new DTLZ3(thisObjective); maxGenerations = 800; break;
				case "DTLZ4": problem = new DTLZ4(thisObjective); maxGenerations = 500; break;
				case "DTLZ5": problem = new DTLZ5(thisObjective); maxGenerations = 500; break;
				case "DTLZ6": problem = new DTLZ6(thisObjective); maxGenerations = 500; break;
				case "DTLZ7": problem = new DTLZ7(thisObjective); maxGenerations = 500; break;
				case "WFG1": problem = new WFG1(positionParametersWFG, 10, thisObjective); maxGenerations = 600; break;
				case "WFG2": problem = new WFG2(positionParametersWFG, 10, thisObjective); maxGenerations = 600; break;
				case "WFG3": problem = new WFG3(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG4": problem = new WFG4(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG5": problem = new WFG5(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG6": problem = new WFG6(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG7": problem = new WFG7(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG8": problem = new WFG8(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
				case "WFG9": problem = new WFG9(positionParametersWFG, 10, thisObjective); maxGenerations = 500; break;
			}
				
			System.out.println(txtproblem + " " + problem.getNumberOfObjectives() + " objetivos " + problem.getNumberOfVariables() + " variables");

			int maxEvaluations = maxGenerations * populationSize;

			Analyzer analyzer = new Analyzer()
					.withProblem(problem)				
					.includeInvertedGenerationalDistance()
					.includeSpacing()
					.includeAdditiveEpsilonIndicator();
			
			long[][]times = new long[algorithms.length][];
			int alg = 0;
			
			for (String algorithm : algorithms) {
				times[alg] = new long[Repetitions];
				
				NondominatedPopulation AllNDS = new NondominatedPopulation();
				for(int thisSeed = 0; thisSeed < Repetitions; thisSeed++){
									
					if (algorithm == "MOEAD3"){
						txtCAFileName = currentExperiment.CaName;
						populationSize = currentExperiment.PopulationSizeCa;
					}else{
						txtCAFileName = currentExperiment.AcaName;
						populationSize = currentExperiment.PopulationSizeAca;
					}
					
					Algorithm x =  run(thisSeed, problem, algorithm, txtCAFileName, alphabetCA,
							                        populationSize, maxEvaluations);
					NondominatedPopulation res = x.getResult();
					analyzer.add(algorithm, res);

					for (int i = 0; i < res.size(); i++)
						AllNDS.add(res.get(i).copy());
										
					times[alg][thisSeed] = elapsedtime;
					System.out.println(algorithm + " " + thisSeed + " Time: " + 
							elapsedtime + " Popualtion: " + 
							((AbstractAlgorithm)x).PopulationSize);
				}	
				
				SavePF(AllNDS, algorithm, thisObjective, problem.getName());

				alg++;
			}
							
	        System.out.println("start ------------------------------------------------" + getCurrentTime());

			FileOutputStream myFile = new FileOutputStream(ResultsPath + "MAOPS-"+ thisObjective + ".txt", true);
			PrintStream myStream = new PrintStream(myFile);
			myStream.println(txtproblem + " " + problem.getNumberOfObjectives() + " objetivos " + problem.getNumberOfVariables() + " variables");
			analyzer.printAnalysis(myStream);
			
			String result = "";
			for (alg = 0; alg < algorithms.length; alg++){
				result += algorithms[alg] + "\t" + txtproblem + "\t" + 
							problem.getNumberOfObjectives() + "\t" + mean(times[alg]) + "\n";
			}
			myStream.println(result);
			myStream.close();
			System.out.println("end   ------------------------------------------------" + getCurrentTime());
		}
	}	
	
	public void SavePF(NondominatedPopulation ndp, String algorithm, 
			int Objectives, String problem) throws FileNotFoundException{
		
		FileOutputStream myFile = new FileOutputStream("D:\\PC-" + problem + "-" + 
									Objectives + ".csv", true);
		PrintStream myStream = new PrintStream(myFile);

		for (int obj = 0; obj < Objectives; obj++)
			myStream.print("objective" + (obj+1) + ",");
		myStream.println("algorithm,problem,objectives,color");

		int color = 0;
		switch(algorithm){
			case "MOEAD2": color = 0; break;
			case "MOEAD": color = 1; break;
			case "NSGAIII": color = 2; break;
		}
		
		for (int i = 0; i < ndp.size(); i++){
			Solution s = ndp.get(i);		
			for (int obj = 0; obj < Objectives; obj++){
				double valor = s.getObjective(obj);
				myStream.print(valor + ",");
			}
			myStream.println(algorithm + "," + problem + "," + Objectives + "," + color);
		}
		
		myStream.close();
	}
	
	public long elapsedtime;
	
	public Algorithm run(int seed, Problem problem, String algorithmString,
			String nameCA, int alphabetCA, int populationSize, int maxEvaluations) {

		StandardAlgorithms myCreador = new StandardAlgorithms();

		Properties properties = new Properties();

		properties.setProperty("nameCA", nameCA);
		properties.setProperty("alphabetCA", Integer.toString(alphabetCA));
		properties.setProperty("populationSize", Integer.toString(populationSize));
		
		Algorithm algorithm = myCreador.getAlgorithm(algorithmString, properties, problem);
				
		TerminationCondition terminationCondition = new MaxFunctionEvaluations(maxEvaluations);
		
		long startTime = System.currentTimeMillis();
		terminationCondition.initialize(algorithm);
		PRNG.setRandom(new Random (seed));
		
		while (!algorithm.isTerminated() &&
			   !terminationCondition.shouldTerminate(algorithm)) {
			algorithm.step();
		}
		System.out.println("FFEs: " + algorithm.getNumberOfEvaluations());
		elapsedtime = System.currentTimeMillis() - startTime;
		return algorithm;
	}
	
	public double mean(long[] v) {
	    double tot = 0.0;
	    for (int i = 0; i < v.length; i++)
	      tot += v[i];
	    return tot / v.length;
	  }
	
	public String getCurrentTime() {
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
	    return formateador.format(ahora);
	}
}