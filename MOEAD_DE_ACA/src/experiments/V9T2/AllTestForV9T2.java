package experiments.V9T2;
import java.io.IOException;

import experiments.GenericTest;

public class AllTestForV9T2 {

	public static void main(String[] args) throws IOException {
		
		for (int exp = 0; exp < 10; exp ++){
			GenericTest p = new GenericTest();
			p.Execute(exp);
		}
	}	
}