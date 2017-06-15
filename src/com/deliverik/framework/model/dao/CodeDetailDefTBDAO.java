package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;

/**
 * ������ϢDAO�ӿ�
 * 
 */
public interface CodeDetailDefTBDAO extends BaseHibernateDAO<CodeDetailDef> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeDetailDef> findAll();

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetailDef findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeDetailDefSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond, 
			final int start, final int count,int orderbyFlag);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond,int orderbyFlag);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond);

	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(final String ccid);
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid);
	
	/**
	 * ���ݲ�����ѯ�÷����µ�������ĩ��ҵ��ϵͳ����
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding);

}
