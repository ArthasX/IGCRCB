/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG221DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG221VW;

/**
  * ����: �����߰�ť������Ϣ����ͼҵ���߼�ʵ��
  * ��������: �����߰�ť������Ϣ����ͼҵ���߼�ʵ��
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public class IG221BLImpl extends BaseBLImpl implements
		IG221BL {

	/** �����߰�ť������Ϣ����ͼDAO�ӿ� */
	protected IG221DAO ig221DAO;
	
	/**
	 * �����߰�ť������Ϣ����ͼDAO�ӿ��趨
	 *
	 * @param ig221DAO �����߰�ť������Ϣ����ͼDAO�ӿ�
	 */
	public void setIg221DAO(IG221DAO ig221DAO) {
		this.ig221DAO = ig221DAO;
	}

	/**
	 * �����߰�ť������Ϣ����ͼʵ��ȡ��
	 *
	 * @return �����߰�ť������Ϣ����ͼʵ��
	 */
	public IG221VW getProcessParticipantButtonDefVWTBInstance() {
		return new IG221VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG221Info> searchIG221Info() {
		return ig221DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG221SearchCond cond) {
		return ig221DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond) {
		return ig221DAO.findByCond(cond, 0, 0);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221InfoVW(
			IG221SearchCond cond) {
		return ig221DAO.findDefaultByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond, int start,
			int count) {
		return ig221DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG221Info registIG221Info(IG221Info instance)
		throws BLException {
		return ig221DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG221Info updateIG221Info(IG221Info instance)
		throws BLException {
		return ig221DAO.save(instance);
	}


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG221Info(IG221Info instance)
		throws BLException {
		ig221DAO.delete(instance);
	}

}