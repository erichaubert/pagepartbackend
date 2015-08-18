package com.ehaubert.digabit;

import java.io.File;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.ehaubert.digabit.entity.PageEntity;
import com.ehaubert.digabit.entity.PartEntity;
import com.ehaubert.digabit.model.Page;
import com.ehaubert.digabit.model.Part;

public class PageInputBoundary {
	private static final Logger LOG = Logger.getLogger(PageInputBoundary.class.getName());
	
	public void	mergePagePartRecordsFromFile(String xmlFilePath) throws JAXBException{
		LOG.info("processing xml input from file: "+xmlFilePath);
		Page page = (Page)JAXBContext.newInstance("com.ehaubert.digabit.model").createUnmarshaller().unmarshal(new File(xmlFilePath));
		
		EntityManager em = Persistence.createEntityManagerFactory("digabitPU").createEntityManager();
		em.getTransaction().begin();
		
		PageEntity pageEntity = new PageManager().createOrUpdatePageEntity(page, em);
		for(Part part : page.getPart()){
			PartEntity partEntity = new PartManager().createOrUpdatePartEntity(em,part);
			new PagePartManager().createOrUpdatePagePartEntity(em, pageEntity, part, partEntity);
		}
		em.getTransaction().commit();
	}
	
	public static void main(String[] args ) throws JAXBException{
		new PageInputBoundary().mergePagePartRecordsFromFile(args[0]);
	}
}
