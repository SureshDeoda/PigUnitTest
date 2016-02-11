import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.apache.pig.pigunit.PigTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_pig extends PigTestBase{
	
	private final String SCRIPT = "/root/Desktop/test/pig_demo.pig";
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
	public void firsttest() throws ParseException,IOException, org.apache.pig.tools.parameters.ParseException {
		String[] args = {
				"ip_file=/root/Desktop/test/marks_ip"
		};
		
		PigTest test = super.createDefaultTest(args, SCRIPT);
		String[] input = {
				"1\tRNG\t40",
				"1\tSCI\t45",
				"1\tMAT\t50"
				
		};
		
		String[] output = {"(1,45.0)"};
		MockPigFeed mockPigFeed = mockPigFeed(test);
		mockPigFeed.mockInputAlias("mark_file", input);
		test.assertOutput("op",output);
		

	}

}
