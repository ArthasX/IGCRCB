/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainplanDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * ����: ��ѵ�ƻ���ҵ���߼�ʵ��
  * ��������: ��ѵ�ƻ���ҵ���߼�ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public class TrainplanBLImpl extends BaseBLImpl implements
		TrainplanBL {

	/** ��ѵ�ƻ���DAO�ӿ� */
	protected TrainplanDAO trainplanDAO;
	
	/**
	 * ��ѵ�ƻ���DAO�ӿ��趨
	 *
	 * @param trainplanDAO ��ѵ�ƻ���DAO�ӿ�
	 */
	public void setTrainplanDAO(TrainplanDAO trainplanDAO) {
		this.trainplanDAO = trainplanDAO;
	}

	/**
	 * ��ѵ�ƻ���ʵ��ȡ��
	 *
	 * @return ��ѵ�ƻ���ʵ��
	 */
	public TrainplanTB getTrainplanTBInstance() {
		return new TrainplanTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainplanInfo> searchTrainplan() {
		return trainplanDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainplanInfo searchTrainplanByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainplanSearchCond cond) {
		return trainplanDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond) {
		return trainplanDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond, int start,
			int count) {
		return trainplanDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainplanInfo registTrainplan(TrainplanInfo instance)
		throws BLException {
		return trainplanDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainplanInfo updateTrainplan(TrainplanInfo instance)
		throws BLException {
		checkExistInstance(instance.getTpid());
		return trainplanDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainplanByPK(Integer pk)
		throws BLException {
		trainplanDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainplan(TrainplanInfo instance)
		throws BLException {
		trainplanDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public TrainplanInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainplanInfo instance = trainplanDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}