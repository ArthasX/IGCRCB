/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;

/**
 * ������Ӧ������ͳ��DAO
 * ����������Ӧ������ͳ��DAO�ӿ�
 * ������¼��2015/5/23
 * zhnagjian
 */
public interface StatisticsDAO extends BaseHibernateDAO<Object> {


	/**
	 * Ԥ��ͳ�Ʋ�ѯ
	 * ͳ��Ԥ������,�޶�����,��������
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond );
	/**
	 * ����ͳ�Ʋ�ѯ
	 * �����ƻ�ͳ��,��������ͳ��,����ִ��ͳ��
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond );
	/**
	 * ������ʽͳ��
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond );
	/**
	 * Ԥ��ͳ�Ʋ�ѯ-��ȡԤ�������ġ����������ĳ�����eiid����
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond );
	

}