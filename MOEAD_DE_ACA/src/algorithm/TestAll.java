package algorithm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import experiments.GenericTest;

public class TestAll {

	public static void PrintWeights(List<double[]> weights, 
			String fileName, String problema, String objetivos){

		FileOutputStream myFile;
		try {
			myFile = new FileOutputStream("D:\\" + fileName + "-" + objetivos +
					"-" + weights.size() + ".csv", false);
			PrintStream myStream = new PrintStream(myFile);
			
			for (double[] weight : weights) {
				for (double w: weight){
					myStream.print(w + ",");
				}
				myStream.println();
			}
			myStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static double Norm2(double[] vector){
		double norm = 0.0;
		for (int i=0; i < vector.length; i++)
			norm = norm + (vector[i]*vector[i]);
		norm = Math.sqrt(norm);
		return norm;
	}
	
	public static double CosineSimilarity(double[] vector1, double[] vector2){
		double norm1 = Norm2(vector1);
		double norm2 = Norm2(vector2);
		double numerator = 0.0;
		for (int i=0; i < vector1.length; i++)
			numerator = numerator + vector1[i] * vector2[i];
		return numerator / (norm1 * norm2);
	}
	
	public static void PrintMinAngleWeights(List<double[]> weights, String fileName, 
			String problem, String objectives){
		try {
			FileOutputStream myFile2 = new FileOutputStream("D:\\" + problem + "-" + objectives + 
					"-" + fileName + "-Edges.csv", false);
			PrintStream myStream2 = new PrintStream(myFile2);

			myStream2.println("Source;Target;Type;Weight");
			for (int i = 0; i < weights.size()-1; i++){
				for (int j = i + 1; j < weights.size(); j++){
					double angle = 180 * Math.acos(CosineSimilarity(weights.get(i), weights.get(j))) / Math.PI;
					String dis = Double.toString(angle);
					dis = dis.replace('.',  ',');
					myStream2.println(i + ";" + j + ";undirected;"+ dis);
				}
			}
			myStream2.close();	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		for (int exp=0; exp <10; exp++){
			GenericTest prueba = new GenericTest();
			prueba.Execute(exp);
		}
	}	
}