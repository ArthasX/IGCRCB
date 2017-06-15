/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * ����: ��ѵ�����ҵ���߼��ӿ�
  * ��������: ��ѵ�����ҵ���߼��ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainmissionBL extends BaseBL {

	/**
	 * ��ѵ�����ʵ��ȡ��
	 *
	 * @return ��ѵ�����ʵ��
	 */
	public TrainmissionTB getTrainmissionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainmissionInfo> searchTrainmission();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainmissionInfo searchTrainmissionByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainmissionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainmissionInfo> searchTrainmission(
			TrainmissionSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainmissionInfo registTrainmission(TrainmissionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainmissionInfo updateTrainmission(TrainmissionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainmissionByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainmission(TrainmissionInfo instance)
		throws BLException;
	/**
	 * ��������������ѯ
	 * @param tpid String
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getListByRid (String tpid);

}