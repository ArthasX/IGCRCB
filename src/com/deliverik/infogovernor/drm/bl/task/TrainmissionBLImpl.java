/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainmissionDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * ����: ��ѵ�����ҵ���߼�ʵ��
  * ��������: ��ѵ�����ҵ���߼�ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public class TrainmissionBLImpl extends BaseBLImpl implements
		TrainmissionBL {

	/** ��ѵ�����DAO�ӿ� */
	protected TrainmissionDAO trainmissionDAO;
	
	/**
	 * ��ѵ�����DAO�ӿ��趨
	 *
	 * @param trainmissionDAO ��ѵ�����DAO�ӿ�
	 */
	public void setTrainmissionDAO(TrainmissionDAO trainmissionDAO) {
		this.trainmissionDAO = trainmissionDAO;
	}

	/**
	 * ��ѵ�����ʵ��ȡ��
	 *
	 * @return ��ѵ�����ʵ��
	 */
	public TrainmissionTB getTrainmissionTBInstance() {
		return new TrainmissionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainmissionInfo> searchTrainmission() {
		return trainmissionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainmissionInfo searchTrainmissionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainmissionSearchCond cond) {
		return trainmissionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond) {
		return trainmissionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond, int start,
			int count) {
		return trainmissionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainmissionInfo registTrainmission(TrainmissionInfo instance)
		throws BLException {
		return trainmissionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainmissionInfo updateTrainmission(TrainmissionInfo instance)
		throws BLException {
		checkExistInstance(instance.getTmid());
		return trainmissionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainmissionByPK(Integer pk)
		throws BLException {
		trainmissionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainmission(TrainmissionInfo instance)
		throws BLException {
		trainmissionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public TrainmissionInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainmissionInfo instance = trainmissionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ��������������ѯ
	 * @param tpid String
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getListByRid (String tpid) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("tpid", tpid);
		return this.trainmissionDAO.getList(new String[]{"TrainmissionDetail.View"}, paramMap);
	} // end method getListByRid 
}