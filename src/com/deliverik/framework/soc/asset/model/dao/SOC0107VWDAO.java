package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCondImpl;



/**
 * �ʲ���������ϢDAO�ӿ�
 * 
 */
public interface SOC0107VWDAO extends BaseHibernateDAO<SOC0107VWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0107VWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0107VWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0107VWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0107VWInfo> findByCond(
			final SOC0107VWSearchCond cond, final int start,
			final int count);
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107VWSearchCondImpl cond);
	
	/**
	 * �����ʲ�ģ��ID��ȡ������Ϣ
	 * @param eiid �ʲ�ID
	 * @return List<SOC0107VWInfo>
	 */
	public List<SOC0107VWInfo> getConfigItemByEid(final SOC0107VWSearchCondImpl cond);
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
}
