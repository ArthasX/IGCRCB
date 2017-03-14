/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainparticipateDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;

/**
  * ����: ��ѵ������ҵ���߼�ʵ��
  * ��������: ��ѵ������ҵ���߼�ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainparticipateBLImpl extends BaseBLImpl implements
		TrainparticipateBL {

	/** ��ѵ������DAO�ӿ� */
	protected TrainparticipateDAO trainparticipateDAO;
	
	/**
	 * ��ѵ������DAO�ӿ��趨
	 *
	 * @param trainparticipateDAO ��ѵ������DAO�ӿ�
	 */
	public void setTrainparticipateDAO(TrainparticipateDAO trainparticipateDAO) {
		this.trainparticipateDAO = trainparticipateDAO;
	}

	/**
	 * ��ѵ������ʵ��ȡ��
	 *
	 * @return ��ѵ������ʵ��
	 */
	public TrainparticipateTB getTrainparticipateTBInstance() {
		return new TrainparticipateTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainparticipateInfo> searchTrainparticipate() {
		return trainparticipateDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainparticipateInfo searchTrainparticipateByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainparticipateSearchCond cond) {
		return trainparticipateDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainparticipateInfo> searchTrainparticipate(
			TrainparticipateSearchCond cond) {
		return trainparticipateDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainparticipateInfo> searchTrainparticipate(
			TrainparticipateSearchCond cond, int start,
			int count) {
		return trainparticipateDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainparticipateInfo registTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		return trainparticipateDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainparticipateInfo updateTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		checkExistInstance(instance.getTpaid());
		return trainparticipateDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainparticipateByPK(Integer pk)
		throws BLException {
		trainparticipateDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainparticipate(TrainparticipateInfo instance)
		throws BLException {
		trainparticipateDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public TrainparticipateInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainparticipateInfo instance = trainparticipateDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}