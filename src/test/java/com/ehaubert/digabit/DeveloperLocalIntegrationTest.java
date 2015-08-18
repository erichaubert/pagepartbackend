package com.ehaubert.digabit;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Ignore;
import org.junit.Test;


public class DeveloperLocalIntegrationTest {
	
	@Test
	@Ignore("Used for local integration testing only")
	public void runApplicationIntegrationTest() throws IOException, JAXBException{
		new PageInputBoundary().mergePagePartRecordsFromFile("D:/dev/api/digabit_exercise/src/test/resources/exampleInput.xml");
	}

}
