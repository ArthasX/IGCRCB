/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;

/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼDAO�ӿ�
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼDAO�ӿ�
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

public interface EntityItemUntreatedVWDAO extends
		BaseHibernateDAO<EntityItemUntreatedVWInfo> {

	/**
	 * δ�ϼܻ��񡢿յ���ups�б�ȡ��
	 *
	 * @return list ��������б�
	 */
	public List<EntityItemUntreatedVWInfo> getToolsData();
}
