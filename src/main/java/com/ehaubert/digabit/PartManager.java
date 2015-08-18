package com.ehaubert.digabit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ehaubert.digabit.entity.PartEntity;
import com.ehaubert.digabit.model.Part;

public class PartManager {
	public PartEntity createOrUpdatePartEntity(EntityManager em, Part part) {
		TypedQuery<PartEntity> query = em.createNamedQuery("PartEntity.findBySupplierPartNumber", PartEntity.class);
		query.setParameter("partNumber", part.getPartNumber());
		query.setParameter("supplierKey", part.getSupplierKey());
		List<PartEntity> results = query.getResultList();
		PartEntity partEntity = null;
		if(results.size() == 0){
			partEntity = new PartEntity();
		}else{
			partEntity = results.get(0);
		}
		mapToPartEntity(partEntity,part);
		em.persist(partEntity);
		return partEntity;
	}
	
	protected void mapToPartEntity(PartEntity partEntity,Part part) {
		partEntity.setDiscountedPrice(part.getDiscountedPrice()==null ? 0 : part.getDiscountedPrice().doubleValue());
		partEntity.setOrderable(part.getOrderable() != null &&  part.getOrderable()? (byte)1 :(byte)0);
		partEntity.setPartNumber(part.getPartNumber());
		partEntity.setRetailPrice(part.getRetailPrice() == null ? 0: part.getRetailPrice().doubleValue());
		partEntity.setSupplierKey(part.getSupplierKey());
		partEntity.setUnitOfMeasure(part.getUnitOfMeasure());
		partEntity.setWholesalePrice(part.getWholesalePrice() == null ? 0 : part.getWholesalePrice().doubleValue());
	}
}
