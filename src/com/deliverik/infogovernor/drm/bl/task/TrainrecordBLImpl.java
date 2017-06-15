/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainrecordDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * ����: ��ѵ��¼ҵ���߼�ʵ��
  * ��������: ��ѵ��¼ҵ���߼�ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainrecordBLImpl extends BaseBLImpl implements
		TrainrecordBL {

	
	/** ��ѵ��¼DAO�ӿ� */
	protected TrainrecordDAO trainrecordDAO;
	
	/**
	 * ��ѵ��¼DAO�ӿ��趨
	 *
	 * @param trainrecordDAO ��ѵ��¼DAO�ӿ�
	 */
	public void setTrainrecordDAO(TrainrecordDAO trainrecordDAO) {
		this.trainrecordDAO = trainrecordDAO;
	}

	/**
	 * ��ѵ��¼ʵ��ȡ��
	 *
	 * @return ��ѵ��¼ʵ��
	 */
	public TrainrecordTB getTrainrecordTBInstance() {
		return new TrainrecordTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainrecordInfo> searchTrainrecord() {
		return trainrecordDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainrecordInfo searchTrainrecordByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainrecordSearchCond cond) {
		return trainrecordDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond) {
		return trainrecordDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond, int start,
			int count) {
		return trainrecordDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainrecordInfo registTrainrecord(TrainrecordInfo instance)
		throws BLException {
		return trainrecordDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainrecordInfo updateTrainrecord(TrainrecordInfo instance)
		throws BLException {
		checkExistInstance(instance.getTrid());
		return trainrecordDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainrecordByPK(Integer pk)
		throws BLException {
		trainrecordDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainrecord(TrainrecordInfo instance)
		throws BLException {
		trainrecordDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public TrainrecordInfo checkExistInstance(Integer pk)
		throws BLException {
		TrainrecordInfo instance = trainrecordDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public TrainrecordDAO getTrainrecordDAOInstance() {
		// TODO Auto-generated method stub
		return null;
	}


}