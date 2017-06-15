/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-01-31
 * �޸ļ�¼��
 */
public interface EquipmentInquireVWDAO extends BaseHibernateDAO<EquipmentInquireVWInfo>{

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EquipmentInquireVWInfo> getEquipmentAndIP(final EquipmentInquireVWSearchCond cond, final int start, final int count);
	/**
	 * �������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������
	 */
	public int getEquipmentAndIPCount(final EquipmentInquireVWSearchCond cond);
}
