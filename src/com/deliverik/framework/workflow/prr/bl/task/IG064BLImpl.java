/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG064DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * ����: ���̼�¼�ڵ�������ͼҵ���߼�ʵ��
  * ��������: ���̼�¼�ڵ�������ͼҵ���߼�ʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public class IG064BLImpl extends BaseBLImpl implements
		IG064BL {

	/** ���̼�¼�ڵ�������ͼDAO�ӿ� */
	protected IG064DAO ig064DAO;
	
	/**
	 * ���̼�¼�ڵ�������ͼDAO�ӿ��趨
	 *
	 * @param ig064DAO ���̼�¼�ڵ�������ͼDAO�ӿ�
	 */
	public void setIg064DAO(IG064DAO ig064DAO) {
		this.ig064DAO = ig064DAO;
	}

	/**
	 * ���̼�¼�ڵ�������ͼʵ��ȡ��
	 *
	 * @return ���̼�¼�ڵ�������ͼʵ��
	 */
	public IG064VW getIG064VWInstance() {
		return new IG064VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG064Info> searchIG064Info() {
		return ig064DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG064SearchCond cond) {
		return ig064DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond) {
		return ig064DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond, int start,
			int count) {
		return ig064DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param ig064Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG064Info registIG064Info(IG064Info ig064Info)
		throws BLException {
		return ig064DAO.save(ig064Info);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param ig064Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG064Info updateIG064Info(IG064Info ig064Info)
		throws BLException {
		return ig064DAO.save(ig064Info);
	}


	/**
	 * ɾ������
	 *
	 * @param ig064Info ɾ��ʵ��
	 */
	public void deleteIG064Info(IG064Info ig064Info)
		throws BLException {
		ig064DAO.delete(ig064Info);
	}


}