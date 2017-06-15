/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;


 /**
  * <P>����:����������ϸ��¼��BL�ӿ�</p>
  * <p>����������1.�־û�</p>
  * <p>			2.������������</p>
  * <p>			3.ȫ������</p>
  * <p>			4.���������������ȡ��</p>
  * <p>			5.������������</p>
  * <p>			6.ɾ������</p>
  * <p>������¼��songhy 20101129</p>
  */

public interface IG229BL extends BaseBL {
	/**
	 * �־û�����
	 * 
	 * @param IG229Infoʵ����
	 * @return IG229Infoʵ����
	 */
	public IG229Info saveIG229Info(
			IG229Info ig229Info) throws BLException;

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public IG229Info findIG229InfoByPK(Integer id)
			throws BLException;

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG229Info> findAllIG229Info()
			throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG229SearchCond cond)
			throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG229Info> findIG229InfoByCond(
			IG229SearchCond cond, int start, int count)
			throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param IG229Infoʵ����
	 */
	public void deleteIG229Info(
			IG229Info processAssessmentDetail) throws BLException;

}

