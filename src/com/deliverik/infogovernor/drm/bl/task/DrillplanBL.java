/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanTB;

/**
  * ����: �����ƻ�ҵ���߼��ӿ�
  * ��������: �����ƻ�ҵ���߼��ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanBL extends BaseBL {

	/**
	 * �����ƻ�ʵ��ȡ��
	 *
	 * @return �����ƻ�ʵ��
	 */
	public DrillplanTB getDrillplanTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanInfo> searchDrillplan();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanInfo searchDrillplanByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DrillplanSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DrillplanInfo> searchDrillplan(
			DrillplanSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DrillplanInfo> searchDrillplan(
			DrillplanSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DrillplanInfo registDrillplan(DrillplanInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DrillplanInfo updateDrillplan(DrillplanInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDrillplanByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDrillplan(DrillplanInfo instance)
		throws BLException;
	
	/**
     * ��ѯ�����ƻ���Ŀ��ͼ
     * @param cond
     * @return
     */
    public List<DrillplanVWInfo> getDrillPlanVW( DrillplanVWSearchCond cond, int start, int count)throws BLException;
    /**
     * ��ѯ��������
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount( DrillplanVWSearchCond cond)throws BLException;
    
    public DrillplanVWInfo getDrillPlanVWByDiid(int diid)throws BLException;
	/**
	 * ͳ�������ƻ�����������Ŀ�ļ���
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 */
	public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count);

}