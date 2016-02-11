import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.pig.pigunit.Cluster;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import java.io.IOException;

public class SampleTests {

	  static {
	    BasicConfigurator.configure();
	  }

	  private static final String PIG_SCRIPT = SampleTests.class.getClassLoader().getResource("/root/Desktop/test/top_queries.pig").getFile();
	  private static Cluster cluster;
	  private static final Log LOG = LogFactory.getLog(SampleTests.class);
	  private PigTest test;
	  
	  
	@BeforeClass
	public static void setUpOnce() throws IOException {
	    System.getProperties().setProperty("mapreduce.framework.name", "yarn");
	    cluster = PigTest.getCluster();
	  }
	
	@Test
	public void testTopQueries() throws IOException, ParseException {
	    String[] args = {
	        "n=2",
	    };
	    test = new PigTest(PIG_SCRIPT, args);

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
	        "(facebook,2)",
	    };

	    LOG.info("Starting script");
	    test.assertOutput("data", input, "queries_limit", output);
	    LOG.info("Done");
	  }

}
