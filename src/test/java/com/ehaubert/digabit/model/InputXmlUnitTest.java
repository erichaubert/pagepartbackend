package com.ehaubert.digabit.model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.ehaubert.digabit.model.Page;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class InputXmlUnitTest {
	@Test
	public void inputXmlMatchesOutputXml() throws JAXBException, SAXException, IOException {
		JAXBContext ctx = JAXBContext.newInstance("com.ehaubert.digabit.model");
		String expected = Resources.toString(Resources.getResource("exampleInput.xml"), Charsets.UTF_8);
		Object o = ctx.createUnmarshaller().unmarshal(new StringReader(expected));
		assertTrue(o instanceof Page);
		StringWriter stringWriter = new StringWriter();
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(o, stringWriter);
		
		XMLUnit.setIgnoreWhitespace(true);
		Diff diff = new DetailedDiff(new Diff(expected, stringWriter.toString()));
		assertTrue(diff.toString(),diff.identical());
	}
}
