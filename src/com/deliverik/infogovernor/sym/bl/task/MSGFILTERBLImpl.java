/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;
import com.deliverik.infogovernor.sym.model.dao.MSGFILTERDAO;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
 * ����: MSGFILTERҵ���߼�ʵ�� ��������: MSGFILTERҵ���߼�ʵ�� ������¼: 2013/08/21 �޸ļ�¼:
 */
public class MSGFILTERBLImpl extends BaseBLImpl implements MSGFILTERBL {

	/** MSGFILTERDAO�ӿ� */
	public MSGFILTERDAO mSGFILTERDAO;

	public void setmSGFILTERDAO(MSGFILTERDAO mSGFILTERDAO) {
		this.mSGFILTERDAO = mSGFILTERDAO;
	}

	/**
	 * MSGFILTERDAO�ӿ��趨
	 * 
	 * @param mSGFILTERDAO
	 *            MSGFILTERDAO�ӿ�
	 */

	/**
	 * MSGFILTERʵ��ȡ��
	 * 
	 * @return MSGFILTERʵ��
	 */
	public MSGFILTERTB getMSGFILTERTBInstance() {
		return new MSGFILTERTB();
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<MSGFILTERInfo> searchMSGFILTER() {
		return mSGFILTERDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param pk
	 *            ����
	 * @return �������
	 */
	public MSGFILTERInfo searchMSGFILTERByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(MSGFILTERSearchCond cond) {
		return mSGFILTERDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(MSGFILTERSearchCond cond) {
		return mSGFILTERDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(MSGFILTERSearchCond cond,
			int start, int count) {
		return mSGFILTERDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 * 
	 * @param instance
	 *            ����ʵ��
	 * @return ����ʵ��
	 */
	public MSGFILTERInfo registMSGFILTER(MSGFILTERInfo instance)
			throws BLException {
		return mSGFILTERDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 * 
	 * @param instance
	 *            �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MSGFILTERInfo updateMSGFILTER(MSGFILTERInfo instance)
			throws BLException {
		checkExistInstance(instance.getId());
		return mSGFILTERDAO.save(instance);
	}

	/**
	 * ɾ������
	 * 
	 * @param pk
	 *            ����
	 */
	public void deleteMSGFILTERByPK(Integer pk) throws BLException {
		mSGFILTERDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 * 
	 * @param instance
	 *            ɾ��ʵ��
	 */
	public void deleteMSGFILTER(MSGFILTERInfo instance) throws BLException {
		mSGFILTERDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * 
	 * @param pk
	 *            ����
	 * @return ʵ��
	 */
	public MSGFILTERInfo checkExistInstance(Integer pk) throws BLException {
		MSGFILTERInfo instance = mSGFILTERDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}