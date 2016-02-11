import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Samp_pig {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTop2Queries() throws IOException, ParseException {
	    String[] args = {
	        "n=2",
	        };
	 
	    PigTest test = new PigTest("/root/Desktop/test/top_queries.pig", args);
	 
	    String[] input = {
	        "yahoo",
	        "yahoo",
	        "yahoo",
	        "twitter",
	        "facebook",
	        "facebook",
	        "linkedin",
	    };
	 
	    String[] output = {
	        "(yahoo,3)",
	        "(facebook,1)",
	    };
	 
	    test.assertOutput("data", input, "queries_limit", output);
	  }

}
