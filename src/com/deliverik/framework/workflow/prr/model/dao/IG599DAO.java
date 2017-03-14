/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;

/**
 * <p>����:���̱�����ϢDAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>			 2.������������</p>
 * <p>			 3.������������</p>
 * <p>			 4.������������(�Զ������̹ر�״̬�����鿴Ȩ����ͼ)</p>
 * <p>������¼��</p>
 */
public interface IG599DAO extends BaseHibernateDAO<IG599Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG599Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param piid ����
	 * @return �������
	 */
	public IG599Info findByPK(Serializable piid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG599Info> findByCond(final IG599SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ�������������
	 * 
	 * �Զ������̹ر�״̬�����鿴Ȩ����ͼ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG599Info> searchIG599InfoForClose(final IG599SearchCond cond) ;
	
	/**
	 * ������������
	 * 
	 * �Զ������̹ر�״̬�����鿴Ȩ����ͼ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG599Info> searchIG599InfoForSee(final IG599SearchCond cond) ;
	
	/**
	 * ���ܣ���ѯ��ǰ�����ˮ��
	 * @param prserialnum ��ˮ��
	 * @param label ����
	 * @return �����ˮ��
	 */
	public String searchMaxSerialnum(String serialnum, String label) ;
}
