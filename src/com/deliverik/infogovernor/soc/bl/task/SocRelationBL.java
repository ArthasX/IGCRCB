/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;

/**
 * 
 * SOC��ϵ��Ϣҵ���߼��ӿ�
 *
 */
public interface SocRelationBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(SocRelationSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return ���ռ����Ϣ
	 */
	public SocRelation searchSocRelationByKey(Integer srid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ����Ϣ��Ϣ
	 */
	public List<SocRelation> searchSocRelationAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SocRelation> searchSocRelation(SocRelationSearchCond cond, int start, int count);
	
	/**
	 * ���洦��
	 * 
	 * @param SocRelation ��������
	 * @return 
	 */
	public SocRelation registSocRelation(SocRelation SocRelation) throws BLException;

	
}
