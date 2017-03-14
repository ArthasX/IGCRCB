/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.dao.IgalarmDAO;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * ����: ���ɸ澯��ҵ���߼�ʵ��
  * ��������: ���ɸ澯��ҵ���߼�ʵ��
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public class IgalarmBLImpl extends BaseBLImpl implements
		IgalarmBL {

	/** ���ɸ澯��DAO�ӿ� */
	protected IgalarmDAO igalarmDAO;
	
	/**
	 * ���ɸ澯��DAO�ӿ��趨
	 *
	 * @param igalarmDAO ���ɸ澯��DAO�ӿ�
	 */
	public void setIgalarmDAO(IgalarmDAO igalarmDAO) {
		this.igalarmDAO = igalarmDAO;
	}

	/**
	 * ���ɸ澯��ʵ��ȡ��
	 *
	 * @return ���ɸ澯��ʵ��
	 */
	public IgalarmTB getIgalarmTBInstance() {
		return new IgalarmTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgalarmInfo> searchIgalarm() {
		return igalarmDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgalarmInfo searchIgalarmByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IgalarmSearchCond cond) {
		return igalarmDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond) {
		return igalarmDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond, int start,
			int count) {
		List<IgalarmInfo>igalarmInfos= igalarmDAO.findByCond(cond, start, count);
		return igalarmInfos;
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IgalarmInfo registIgalarm(IgalarmInfo instance)
		throws BLException {
		return igalarmDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IgalarmInfo updateIgalarm(IgalarmInfo instance)
		throws BLException {
		checkExistInstance(instance.getPk());
		return igalarmDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIgalarmByPK(Integer pk)
		throws BLException {
		igalarmDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIgalarm(IgalarmInfo instance)
		throws BLException {
		igalarmDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IgalarmInfo checkExistInstance(Integer pk)
		throws BLException {
		IgalarmInfo instance = igalarmDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * �澯�¼���ѯ
	 */
	public List<IGCRC0208VWInfo> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException {
		return igalarmDAO.queryIG500EntityListByProcessInfo(cond, start, count);
	}

	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException {
		return igalarmDAO.queryIG500EntityCount(cond);
	}
	
	/**
	 * ������������(û��Ĭ������)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarmNoSort(
			IgalarmSearchCond cond, int start,
			int count) {
		List<IgalarmInfo>igalarmInfos= igalarmDAO.findByCondNoSort(cond, start, count);
		return igalarmInfos;
	}
	
	
}