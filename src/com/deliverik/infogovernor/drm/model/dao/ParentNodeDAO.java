/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ��������ѯ���ڵ���ϢDAO�ӿ�
 * ������������ѯ���ڵ���ϢDAO�ӿ�
 * ������¼��2014/05/19
 */
public interface ParentNodeDAO extends BaseHibernateDAO<Object> {

	/**
	 * ��������id ��ѯ��ǰ�ڵ���Ϣ
	 */
	public List<Map<String,Object>> searchParentNodes(String psdid); 
	

}