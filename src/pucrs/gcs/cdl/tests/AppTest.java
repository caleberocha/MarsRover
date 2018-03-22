package pucrs.gcs.cdl.tests;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

//import junit.framework.Assert;

public class AppTest {

	@Test
	public void testApp() 
	{
		Pattern p = Pattern.compile("([0-9]+) ([0-9]+)");
		Matcher m = p.matcher("5 -5");
		
		assertEquals(false, m.find());
	}

}
