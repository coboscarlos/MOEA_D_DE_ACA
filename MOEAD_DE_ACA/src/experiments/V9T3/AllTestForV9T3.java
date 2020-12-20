package experiments.V9T3;
import java.io.IOException;

import experiments.GenericTest;

public class AllTestForV9T3 {

	public static void main(String[] args) throws IOException {
		
		for (int exp = 20; exp < 29; exp ++){
			GenericTest p = new GenericTest();
			p.Execute(exp);
		}
	}	
}