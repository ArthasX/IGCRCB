/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;
import com.deliverik.infogovernor.soc.model.dao.SocRelationDAO;

/**
 * 
 * SOC��ϵ��Ϣҵ���߼��ӿ�
 *
 */
public class SocRelationBLImpl extends BaseBLImpl implements SocRelationBL{
	
	/** DAO */
	protected SocRelationDAO socRelationDAO;
	
	

	public void setSocRelationDAO(SocRelationDAO socRelationDAO) {
		this.socRelationDAO = socRelationDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(SocRelationSearchCond cond){
		
		return socRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return ���ռ����Ϣ
	 */
	public SocRelation searchSocRelationByKey(Integer srid) throws BLException{
		
		return checkExistSocRelation(srid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ����Ϣ��Ϣ
	 */
	public List<SocRelation> searchSocRelationAll(){
		
		return socRelationDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SocRelation> searchSocRelation(SocRelationSearchCond cond, int start, int count){
		
		return socRelationDAO.findByCond(cond,start,count);
	}

	/**
	 * ���洦��
	 * 
	 * @param SocRelation ��������
	 * @return 
	 */
	public SocRelation registSocRelation(SocRelation SocRelation) throws BLException{
		
		return socRelationDAO.save(SocRelation);
	}

	/**
	 * ɾ������
	 * 
	 * @param srid 
	 * @return
	 */
//	public void deleteSocRelation(Integer srid) throws BLException{
//		
//		SocRelation SocRelation = checkExistSocRelation(srid);
//		
//		socRelationDAO.delete(SocRelation);
//	}

	/**
	 * �������
	 * 
	 * @param SocRelation �������
	 * @return 
	 */
//	public SocRelation updateSocRelation(SocRelation socRelation) throws BLException{
//		
//		checkExistSocRelation(SocRelation.getSrid());
//		return socRelationDAO.save(SocRelation);
//	}

	/**
	 * ��Ϣ���ڼ��
	 * 
	 * @param srid 
	 * @return 
	 * @throws BLException 
	 */
	protected SocRelation checkExistSocRelation(Integer srid) throws BLException{
		SocRelation info = socRelationDAO.findByPK(srid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","SOC����");
		}
		return info;
	}
}
