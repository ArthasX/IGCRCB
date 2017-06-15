/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.asset.model.dao.IG749DAO;
import com.deliverik.framework.asset.model.entity.IG749VW;

/**
  * ����: �ʲ�ģ����ͼҵ���߼�ʵ��
  * ��������: �ʲ�ģ����ͼҵ���߼�ʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public class IG749BLImpl extends BaseBLImpl implements
		IG749BL {

	/** �ʲ�ģ����ͼDAO�ӿ� */
	protected IG749DAO ig749DAO;
	
	/**
	 * �ʲ�ģ����ͼDAO�ӿ��趨
	 *
	 * @param ig749DAO�ʲ�ģ����ͼDAO�ӿ�
	 */
	public void setIg749DAO(IG749DAO ig749DAO) {
		this.ig749DAO = ig749DAO;
	}

	/**
	 * �ʲ�ģ����ͼʵ��ȡ��
	 *
	 * @return �ʲ�ģ����ͼʵ��
	 */
	public IG749VW getIG749VWInstance() {
		return new IG749VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG749Info> searchIG749Info() {
		return ig749DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public IG749Info searchIG749InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(IG749SearchCond cond) {
		return ig749DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond) {
		return ig749DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond, int start,
			int count) {
		return ig749DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public IG749Info registIG749Info(IG749Info ig749Info)
		throws BLException {
		return ig749DAO.save(ig749Info);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG749Info updateIG749Info(IG749Info ig749Info)
		throws BLException {
		checkExistInstance(ig749Info.getEiid());
		return ig749DAO.save(ig749Info);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteIG749InfoByPK(Integer pk)
		throws BLException {
		ig749DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteIG749Info(IG749Info ig749Info)
		throws BLException {
		ig749DAO.delete(ig749Info);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public IG749Info checkExistInstance(Integer pk)
		throws BLException {
		IG749Info instance = ig749DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}