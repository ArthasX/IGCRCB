/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;
import com.deliverik.infogovernor.asset.model.condition.IgdocdownSearchCond;
import com.deliverik.infogovernor.asset.model.dao.IgdocdownDAO;
import com.deliverik.infogovernor.asset.model.entity.IgdocdownTB;

/**
  * ����: ���ؼ�¼��ҵ���߼�ʵ��
  * ��������: ���ؼ�¼��ҵ���߼�ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class IgdocdownBLImpl extends BaseBLImpl implements
		IgdocdownBL {

	/** ���ؼ�¼��DAO�ӿ� */
	protected IgdocdownDAO igdocdownDAO;
	
	/**
	 * ���ؼ�¼��DAO�ӿ��趨
	 *
	 * @param igdocdownDAO ���ؼ�¼��DAO�ӿ�
	 */
	public void setIgdocdownDAO(IgdocdownDAO igdocdownDAO) {
		this.igdocdownDAO = igdocdownDAO;
	}

	/**
	 * ���ؼ�¼��ʵ��ȡ��
	 *
	 * @return ���ؼ�¼��ʵ��
	 */
	public IgdocdownTB getIgdocdownTBInstance() {
		return new IgdocdownTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgdocdownInfo> searchIgdocdown() {
		return igdocdownDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgdocdownInfo searchIgdocdownByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IgdocdownSearchCond cond) {
		return igdocdownDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond) {
		return igdocdownDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond, int start,
			int count) {
		return igdocdownDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IgdocdownInfo registIgdocdown(IgdocdownInfo instance)
		throws BLException {
		
		return igdocdownDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IgdocdownInfo updateIgdocdown(IgdocdownInfo instance)
		throws BLException {
		checkExistInstance(instance.getDdid());
		return igdocdownDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIgdocdownByPK(Integer pk)
		throws BLException {
		igdocdownDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIgdocdown(IgdocdownInfo instance)
		throws BLException {
		igdocdownDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IgdocdownInfo checkExistInstance(Integer pk)
		throws BLException {
		IgdocdownInfo instance = igdocdownDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	public void insertDate(IgdocdownSearchCond cond){
		this.igdocdownDAO.insertDate(cond);
		
	}

}