/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskcaseVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskcaseVWTB;

/**
  * ����: �����¼�ҵ���߼�ʵ��
  * ��������: �����¼�ҵ���߼�ʵ��
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public class RiskcaseVWBLImpl extends BaseBLImpl implements
		RiskcaseVWBL {

	/** �����¼�DAO�ӿ� */
	protected RiskcaseVWDAO riskcaseVWDAO;
	
	/**
	 * �����¼�DAO�ӿ��趨
	 *
	 * @param riskcaseVWDAO �����¼�DAO�ӿ�
	 */
	public void setRiskcaseVWDAO(RiskcaseVWDAO riskcaseVWDAO) {
		this.riskcaseVWDAO = riskcaseVWDAO;
	}

	/**
	 * �����¼�ʵ��ȡ��
	 *
	 * @return �����¼�ʵ��
	 */
	public RiskcaseVWTB getRiskcaseVWTBInstance() {
		return new RiskcaseVWTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW() {
		return riskcaseVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskcaseVWInfo searchRiskcaseVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskcaseVWSearchCond cond) {
		return riskcaseVWDAO.getSearchCount(cond);
	}

	/**
	 * �����¼����Բ�ѯ
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond) {
		return riskcaseVWDAO.findByCond(cond);
	}
	
	/**
	 * �����¼��汾��ѯ
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseByVersion(
			RiskcaseVWSearchCond cond){
			return riskcaseVWDAO.findByCondByVersion(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond, int start,
			int count) {
		return riskcaseVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskcaseVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskcaseVWInfo instance = riskcaseVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}