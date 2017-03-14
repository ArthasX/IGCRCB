/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;

/**
 * <p>����:��ͨ����ҵ���߼��ӿ�</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.ȫ����������</p>
 * <p>          3.������������</p>
 * <p>          4.ɾ������</p>
 * <p>          5.�������</p>
 * <p>������¼��</p>
 */

public interface IG202BL extends BaseBL {

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG202InfoSearchCount(IG202SearchCond cond);

	
	/**
	 * ���ܣ�ȫ����������
	 * @param cond ��������
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond, int start, int count);

	/**
	 * ���ܣ����봦��
	 * @param ig202Info
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public IG202Info registIG202Info(IG202Info ig202Info) throws BLException;

	/**
	 * ���ܣ�ɾ������
	 * @param ppdid ɾ���������̲���������
	 * @throws BLException
	 */
	public void deleteIG202Info(Integer ppdid) throws BLException;
	
	/**
	 * ���ܣ�ɾ������
	 * @param IG222 ���̲�����
	 * @throws BLException
	 */
	public void deleteIG202Info(IG202Info processInfoDefGeneral) throws BLException;

	/**
	 * ���ܣ��������
	 * @param IG222 �������
	 * @return ���̲�������Ϣ
	 * @throws BLException
	 */
	public IG202Info updateIG202Info(IG202Info processInfoDefGeneral) throws BLException;
	
	
	
	/**
	 * ���ܣ�ȫ����������
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG202Info> searchIG202InfoAll();
	
	/**
	 * ���ܣ�����������������
	 * @param pidid ����
	 * @return IG202Info
	 */
	public IG202Info findIG202InfoByPK(Integer pidid) throws BLException;
	
	/**
	 * ���ܣ�����������¼��
	 * @param cond ��������
	 * @return ����������¼��
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond);
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> searchIG202InfoFromVW(final IG202SearchCond cond, final int start, final int count);
}
