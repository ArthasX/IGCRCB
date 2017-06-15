/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * ����: ��ѵ�ƻ���ҵ���߼��ӿ�
  * ��������: ��ѵ�ƻ���ҵ���߼��ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainplanBL extends BaseBL {

	/**
	 * ��ѵ�ƻ���ʵ��ȡ��
	 *
	 * @return ��ѵ�ƻ���ʵ��
	 */
	public TrainplanTB getTrainplanTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainplanInfo> searchTrainplan();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainplanInfo searchTrainplanByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainplanSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainplanInfo> searchTrainplan(
			TrainplanSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainplanInfo registTrainplan(TrainplanInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainplanInfo updateTrainplan(TrainplanInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainplanByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainplan(TrainplanInfo instance)
		throws BLException;

}