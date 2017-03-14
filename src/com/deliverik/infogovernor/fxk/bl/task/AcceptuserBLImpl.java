/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.AcceptuserDAO;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;

/**
  * ����: ���չ�����ʾ���������ݱ�ҵ���߼�ʵ��
  * ��������: ���չ�����ʾ���������ݱ�ҵ���߼�ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class AcceptuserBLImpl extends BaseBLImpl implements
		AcceptuserBL {

	/** ���չ�����ʾ���������ݱ�DAO�ӿ� */
	protected AcceptuserDAO acceptuserDAO;
	
	/**
	 * ���չ�����ʾ���������ݱ�DAO�ӿ��趨
	 *
	 * @param acceptuserDAO ���չ�����ʾ���������ݱ�DAO�ӿ�
	 */
	public void setAcceptuserDAO(AcceptuserDAO acceptuserDAO) {
		this.acceptuserDAO = acceptuserDAO;
	}

	/**
	 * ���չ�����ʾ���������ݱ�ʵ��ȡ��
	 *
	 * @return ���չ�����ʾ���������ݱ�ʵ��
	 */
	public AcceptuserTB getAcceptuserTBInstance() {
		return new AcceptuserTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AcceptuserInfo> searchAcceptuser() {
		return acceptuserDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AcceptuserInfo searchAcceptuserByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AcceptuserSearchCond cond) {
		return acceptuserDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond) {
		return acceptuserDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond, int start,
			int count) {
		return acceptuserDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AcceptuserInfo registAcceptuser(AcceptuserInfo instance)
		throws BLException {
		return acceptuserDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AcceptuserInfo updateAcceptuser(AcceptuserInfo instance)
		throws BLException {
		checkExistInstance(instance.getApid());
		return acceptuserDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAcceptuserByPK(Integer pk)
		throws BLException {
		acceptuserDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAcceptuser(AcceptuserInfo instance)
		throws BLException {
		acceptuserDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AcceptuserInfo checkExistInstance(Integer pk)
		throws BLException {
		AcceptuserInfo instance = acceptuserDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}