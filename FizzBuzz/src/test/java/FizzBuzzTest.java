import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Test;
import FizzBuzz.FizzBuzz;

public class FizzBuzzTest {

	FizzBuzz fizzbuzz = new FizzBuzz();
	
	@Test
	public void CorrectParamTest1() {
		
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = fizzbuzz.generateSeq("20");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("1", list.get(0));
		assertEquals("Fizz", list.get(2));
		assertEquals("Buzz", list.get(4));
		assertEquals("Fizz Buzz", list.get(14));
		assertTrue(list.size() == 20);
	}
	
	@Test
	public void StringParamTest(){
		
		try {
			fizzbuzz.generateSeq("input");
		    fail( "My method didn't throw when I expected it to" );
		} catch (Exception ex) {
			assertEquals("Unable to parse invalid parameter", ex.getMessage());	
		}
		
	}
	
	@Test
	public void MinusParamTest() {
		
		try {
			fizzbuzz.generateSeq("-1");
		    fail( "My method didn't throw when I expected it to" );
		} catch (Exception ex) {
			assertEquals("Given number is less then 0", ex.getMessage());
		}
		
	}
	
	

}
