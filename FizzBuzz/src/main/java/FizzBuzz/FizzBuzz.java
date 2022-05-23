package FizzBuzz;

import java.util.ArrayList;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class FizzBuzz implements IFizzBuzz {

	@Override
	public Sequence createSeq(String lastElement) {		
		try {
			ArrayList<String> list = generateSeq(lastElement);
			return new Sequence(list);
		}catch(Exception ex) {
			throw new WebApplicationException(Response.status(Response.Status.CONFLICT)
								.entity(ex.getMessage()).type("text/plain").build());
		}
	}
	
	
	public ArrayList<String> generateSeq(String lastElement) throws Exception {
		
		
		int lastInt = 0;
		
		try {
			lastInt = Integer.parseInt(lastElement);
		}catch(NumberFormatException ex) {
			throw new Exception("Unable to parse invalid parameter");
		}
		
		if(lastInt < 0)
			throw new Exception("Given number is less then 0");

		ArrayList<String> list = new ArrayList<>();
		for(int i = 1; i <= lastInt; i++) {
			if((i%3 == 0) && (i%5 == 0)) {
				list.add("Fizz Buzz");
			}else if(i%5 == 0){
				list.add("Buzz");
			}else if(i%3 == 0){
				list.add("Fizz");
			}else {
				list.add(Integer.toString(i));
			}
		}
		return list;
	}

}
