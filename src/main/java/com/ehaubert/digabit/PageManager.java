package com.ehaubert.digabit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ehaubert.digabit.entity.PageEntity;
import com.ehaubert.digabit.model.Page;

public class PageManager {
	
	public PageEntity createOrUpdatePageEntity(Page page, EntityManager em) {
		TypedQuery<PageEntity> pageQuery = em.createNamedQuery("PageEntity.findByHashKey", PageEntity.class);
		pageQuery.setParameter("hashKey", page.getHashKey());
		List<PageEntity> pageQueryResults = pageQuery.getResultList();
		
		PageEntity pageEntity = null;
		if(pageQueryResults.size() == 0){
			pageEntity = new PageEntity();
			pageEntity.setHashKey(page.getHashKey());
		}else{
			pageEntity = pageQueryResults.get(0);
		}
		pageEntity.setPageFile(page.getPageFile());
		em.persist(pageEntity);
		return pageEntity;
	}
}
