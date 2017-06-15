/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;
import com.deliverik.infogovernor.drm.model.dao.DrillplanitemDAO;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
  * ����: �����ƻ���Ŀҵ���߼�ʵ��
  * ��������: �����ƻ���Ŀҵ���߼�ʵ��
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public class DrillplanitemBLImpl extends BaseBLImpl implements
		DrillplanitemBL {

	/** �����ƻ���ĿDAO�ӿ� */
	protected DrillplanitemDAO drillplanitemDAO;
	
	/**
	 * �����ƻ���ĿDAO�ӿ��趨
	 *
	 * @param drillplanitemDAO �����ƻ���ĿDAO�ӿ�
	 */
	public void setDrillplanitemDAO(DrillplanitemDAO drillplanitemDAO) {
		this.drillplanitemDAO = drillplanitemDAO;
	}

	/**
	 * �����ƻ���Ŀʵ��ȡ��
	 *
	 * @return �����ƻ���Ŀʵ��
	 */
	public DrillplanitemTB getDrillplanitemTBInstance() {
		return new DrillplanitemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanitemInfo> searchDrillplanitem() {
		return drillplanitemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanitemInfo searchDrillplanitemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DrillplanitemSearchCond cond) {
		return drillplanitemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DrillplanitemInfo> searchDrillplanitem(
			DrillplanitemSearchCond cond) {
		return drillplanitemDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return drillplanitemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DrillplanitemInfo registDrillplanitem(DrillplanitemInfo instance)
		throws BLException {
		return drillplanitemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DrillplanitemInfo updateDrillplanitem(DrillplanitemInfo instance)
		throws BLException {
		checkExistInstance(instance.getDiid());
		return drillplanitemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDrillplanitemByPK(Integer pk)
		throws BLException {
		drillplanitemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDrillplanitem(DrillplanitemInfo instance)
		throws BLException {
		drillplanitemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public DrillplanitemInfo checkExistInstance(Integer pk)
		throws BLException {
		DrillplanitemInfo instance = drillplanitemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**��ѯ����������Ϣ*/
	public Map<String,Object> searchDrillDetailByPrid(String prid,String flowType) throws BLException{
		Map<String,Object> drillDetailMap = drillplanitemDAO.searchDrillDetailByPrid(prid,flowType).get(0);
		return drillDetailMap;
	}
}