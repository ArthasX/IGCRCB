package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ���ϢDAO�ӿ�
 * 
 */
public interface IG013DAO extends BaseHibernateDAO<IG013Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG013Info> findAll();

	/**
	 * ������������
	 * @param eiid ����
	 * @return �������
	 */
	public IG013Info findByPK(Serializable eiid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG013SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG013Info> findByCond(final IG013SearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ�ʲ�������ֵ �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ�������ֵ��ƽ̨������
	 */
	
	public String searchMaxIG013InfoLable(final IG013SearchCond cond);
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count);
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion);
}
