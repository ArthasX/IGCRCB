/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;

/**
  * ����: ��ѵ������ҵ���߼��ӿ�
  * ��������: ��ѵ������ҵ���߼��ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainparticipateBL extends BaseBL {

	/**
	 * ��ѵ������ʵ��ȡ��
	 *
	 * @return ��ѵ������ʵ��
	 */
	public TrainparticipateTB getTrainparticipateTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainparticipateInfo> searchTrainparticipate();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainparticipateInfo searchTrainparticipateByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainparticipateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainparticipateInfo> searchTrainparticipate(
			TrainparticipateSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainparticipateInfo registTrainparticipate(TrainparticipateInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainparticipateInfo updateTrainparticipate(TrainparticipateInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainparticipateByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainparticipate(TrainparticipateInfo instance)
		throws BLException;

}