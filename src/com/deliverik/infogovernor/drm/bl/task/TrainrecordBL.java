/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.dao.TrainrecordDAO;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * ����: ��ѵ��¼ҵ���߼��ӿ�
  * ��������: ��ѵ��¼ҵ���߼��ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainrecordBL extends BaseBL {

	
	public TrainrecordDAO getTrainrecordDAOInstance();
	/**
	 * ��ѵ��¼ʵ��ȡ��
	 *
	 * @return ��ѵ��¼ʵ��
	 */
	public TrainrecordTB getTrainrecordTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainrecordInfo> searchTrainrecord();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainrecordInfo searchTrainrecordByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TrainrecordSearchCond cond);

	
		
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TrainrecordInfo> searchTrainrecord(
			TrainrecordSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TrainrecordInfo registTrainrecord(TrainrecordInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TrainrecordInfo updateTrainrecord(TrainrecordInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTrainrecordByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTrainrecord(TrainrecordInfo instance)
		throws BLException;

}