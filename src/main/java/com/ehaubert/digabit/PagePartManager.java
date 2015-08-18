package com.ehaubert.digabit;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.ehaubert.digabit.entity.PageEntity;
import com.ehaubert.digabit.entity.PagePartEntity;
import com.ehaubert.digabit.entity.PartEntity;
import com.ehaubert.digabit.model.Part;

public class PagePartManager {
	private static final Logger LOG = Logger.getLogger(PagePartManager.class.getName());
	
	public void createOrUpdatePagePartEntity(EntityManager em, PageEntity pageEntity, Part part, PartEntity partEntity) {
		PagePartEntity pagePartEntity = getMatchingPagePartEntity(pageEntity, part);
		if(pagePartEntity == null){
			pagePartEntity = new PagePartEntity();
		}
		mapToPagePartEntity(pagePartEntity,pageEntity, part, partEntity);
		em.persist(pagePartEntity);
	}

	protected void mapToPagePartEntity(PagePartEntity pagePartEntity,PageEntity pageEntity, Part part, PartEntity partEntity) {
		pagePartEntity.setInstanceId(part.getInstanceId() == null ? 0 : part.getInstanceId().intValue());//TODO: validate requirements
		pagePartEntity.setItem(part.getItem());
		pagePartEntity.setQuantity(part.getQuantity());
		pagePartEntity.setPage(pageEntity);
		pagePartEntity.setPart(partEntity);
	}

	protected PagePartEntity getMatchingPagePartEntity(PageEntity pageEntity, Part part) {
		if(pageEntity.getPageparts() != null){
			for(PagePartEntity ppe : pageEntity.getPageparts()){
				if(ppe.getItem().equals(part.getItem()) 
						&& ppe.getPart().getPartNumber().equals(part.getPartNumber()) 
						&& ppe.getPart().getSupplierKey().equals(part.getSupplierKey())){
					LOG.info("Found existing PagePart id: "+ ppe.getId());
					return ppe;
				}
			}
		}
		return null;
	}
}
