/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG229DAO;


 /**
  * <p>����:����������ϸ��¼��BLʵ����</p>
  * <p>����������1.�־û�</p>
  * <p>			2.������������</p>
  * <p>			3.ȫ������</p>
  * <p>			4.���������������ȡ��</p>
  * <p>			5.������������</p>
  * <p>			6.ɾ������</p>
  * <p>������¼��</p>
  */
public class IG229BLImpl extends BaseBLImpl implements
		IG229BL {

	protected IG229DAO ig229DAO;

	public void setIg229DAO(
			IG229DAO ig229DAO) {
		this.ig229DAO = ig229DAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param IG229Infoʵ����
	 * @return IG229Infoʵ����
	 */
	public IG229Info saveIG229Info(
			IG229Info ig229Info) throws BLException {
		return ig229DAO.save(ig229Info);
	}

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public IG229Info findIG229InfoByPK(Integer id)
			throws BLException {
		return ig229DAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG229Info> findAllIG229Info()
			throws BLException {
		return ig229DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG229SearchCond cond)
			throws BLException {
		return ig229DAO.getSearchCount(cond);
	}

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
			throws BLException {
		return ig229DAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param IG229Infoʵ����
	 */
	public void deleteIG229Info(
			IG229Info processAssessmentDetail) throws BLException {
		ig229DAO.delete(processAssessmentDetail);
	}

}

