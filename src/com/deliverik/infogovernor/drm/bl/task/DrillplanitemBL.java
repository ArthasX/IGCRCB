/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
  * ����: �����ƻ���Ŀҵ���߼��ӿ�
  * ��������: �����ƻ���Ŀҵ���߼��ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanitemBL extends BaseBL {

	/**
	 * �����ƻ���Ŀʵ��ȡ��
	 *
	 * @return �����ƻ���Ŀʵ��
	 */
	public DrillplanitemTB getDrillplanitemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanitemInfo> searchDrillplanitem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanitemInfo searchDrillplanitemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DrillplanitemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DrillplanitemInfo> searchDrillplanitem(
			DrillplanitemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DrillplanitemInfo> searchDrillplanitem(
			DrillplanitemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DrillplanitemInfo registDrillplanitem(DrillplanitemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DrillplanitemInfo updateDrillplanitem(DrillplanitemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDrillplanitemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDrillplanitem(DrillplanitemInfo instance)
		throws BLException;
	
	/**��ѯ����������Ϣ*/
	public Map<String,Object> searchDrillDetailByPrid(String prid,String flowType) throws BLException;
	
}