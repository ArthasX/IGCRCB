/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;



/**
 * �ʲ���������DAO�ӿ�
 * 
 */
public interface SOC0151DAO extends BaseHibernateDAO<SOC0151Info> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0151Info> findByCond(final SOC0151SearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151SearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0151SearchCond cond);
}
