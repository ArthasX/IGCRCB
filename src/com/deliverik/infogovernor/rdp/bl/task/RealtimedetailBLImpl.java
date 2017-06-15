/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;
import com.deliverik.infogovernor.rdp.model.dao.RealtimedetailDAO;
import com.deliverik.infogovernor.rdp.model.entity.RealtimedetailTB;

/**
  * ����: ��־��Ϣҵ���߼�ʵ��
  * ��������: ��־��Ϣҵ���߼�ʵ��
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public class RealtimedetailBLImpl extends BaseBLImpl implements
		RealtimedetailBL {

	/** ��־��ϢDAO�ӿ� */
	protected RealtimedetailDAO realtimedetailDAO;
	
	/**
	 * ��־��ϢDAO�ӿ��趨
	 *
	 * @param realtimedetailDAO ��־��ϢDAO�ӿ�
	 */
	public void setRealtimedetailDAO(RealtimedetailDAO realtimedetailDAO) {
		this.realtimedetailDAO = realtimedetailDAO;
	}

	/**
	 * ��־��Ϣʵ��ȡ��
	 *
	 * @return ��־��Ϣʵ��
	 */
	public RealtimedetailTB getRealtimedetailTBInstance() {
		return new RealtimedetailTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RealtimedetailInfo> searchRealtimedetail() {
		return realtimedetailDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RealtimedetailInfo searchRealtimedetailByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RealtimedetailSearchCond cond) {
		return realtimedetailDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond) {
		return realtimedetailDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond, int start,
			int count) {
		return realtimedetailDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RealtimedetailInfo registRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		return realtimedetailDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RealtimedetailInfo updateRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return realtimedetailDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRealtimedetailByPK(Integer pk)
		throws BLException {
		realtimedetailDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRealtimedetail(RealtimedetailInfo instance)
		throws BLException {
		realtimedetailDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RealtimedetailInfo checkExistInstance(Integer pk)
		throws BLException {
		RealtimedetailInfo instance = realtimedetailDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}