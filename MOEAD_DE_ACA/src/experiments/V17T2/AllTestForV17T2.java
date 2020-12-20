package experiments.V17T2;
import java.io.IOException;

import experiments.GenericTest;

public class AllTestForV17T2 {

	public static void main(String[] args) throws IOException {
		
		for (int exp = 10; exp < 20; exp ++){
			GenericTest p = new GenericTest();
			p.Execute(exp);
		}
	}	
}