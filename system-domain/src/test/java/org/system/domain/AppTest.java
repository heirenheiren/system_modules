package org.system.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.Restrictions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        Map<String, String> criterias= new HashMap<String, String>();
        for (Entry<String, String> entry : criterias.entrySet()) {
			//criteria.add(Restrictions.eqProperty(entry.getKey(), entry.getValue()));
		}
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
