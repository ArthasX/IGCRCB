/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0163DAO;

/**
  * ����: �û��ʲ�ҵ���߼�ʵ��
  * ��������: �û��ʲ�ҵ���߼�ʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public class SOC0163BLImpl extends BaseBLImpl implements
		SOC0163BL {

	/** �ʲ�ģ����ͼDAO�ӿ� */
	protected SOC0163DAO soc0163DAO;
	


	/**
	 * �ʲ�ģ����ͼDAO�ӿ��趨
	 *
	 * @param soc0163DAO �ʲ�ģ����ͼDAO�ӿ�
	 */
	public void setSoc0163DAO(SOC0163DAO soc0163DAO) {
		this.soc0163DAO = soc0163DAO;
	}



	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0163Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0163SearchCond cond) {
		return soc0163DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond) {
		return soc0163DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond, int start,
			int count) {
		return soc0163DAO.findByCond(cond, start, count);
	}

	

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0163Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0163Info instance = soc0163DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}



	
	public int getSearchCountForNetAsset(SOC0163SearchCond cond) {
		return this.soc0163DAO.getSearchCountForNetAsset(cond);
	}



	public List<SOC0163Info> findByCondForNetAsset(SOC0163SearchCond cond,
			int start, int count) {
		return this.soc0163DAO.findByCondForNetAsset(cond, start, count);
	}

}