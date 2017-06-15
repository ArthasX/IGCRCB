/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;
import com.deliverik.infogovernor.drm.model.dao.DrillplanDAO;
import com.deliverik.infogovernor.drm.model.entity.DrillplanTB;

/**
  * ����: �����ƻ�ҵ���߼�ʵ��
  * ��������: �����ƻ�ҵ���߼�ʵ��
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public class DrillplanBLImpl extends BaseBLImpl implements DrillplanBL {

	/** �����ƻ�DAO�ӿ� */
	protected DrillplanDAO drillplanDAO;
	
	/**
	 * �����ƻ�DAO�ӿ��趨
	 *
	 * @param drillplanDAO �����ƻ�DAO�ӿ�
	 */
	public void setDrillplanDAO(DrillplanDAO drillplanDAO) {
		this.drillplanDAO = drillplanDAO;
	}

	/**
	 * �����ƻ�ʵ��ȡ��
	 *
	 * @return �����ƻ�ʵ��
	 */
	public DrillplanTB getDrillplanTBInstance() {
		return new DrillplanTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DrillplanInfo> searchDrillplan() {
		return drillplanDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DrillplanInfo searchDrillplanByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DrillplanSearchCond cond) {
		return drillplanDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DrillplanInfo> searchDrillplan(
			DrillplanSearchCond cond) {
		return drillplanDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return drillplanDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DrillplanInfo registDrillplan(DrillplanInfo instance)
		throws BLException {
		return drillplanDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DrillplanInfo updateDrillplan(DrillplanInfo instance)
		throws BLException {
		checkExistInstance(instance.getDid());
		return drillplanDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDrillplanByPK(Integer pk)
		throws BLException {
		drillplanDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDrillplan(DrillplanInfo instance)
		throws BLException {
		drillplanDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public DrillplanInfo checkExistInstance(Integer pk)
		throws BLException {
		DrillplanInfo instance = drillplanDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
     * ��ѯ�����ƻ���Ŀ��ͼ
     * @param cond
     * @return
     */
    public List<DrillplanVWInfo> getDrillPlanVW( DrillplanVWSearchCond cond, int start, int count)throws BLException{
        return this.drillplanDAO.getDrillPlanVW(cond, start, count);
    }
    /**
     * ��ѯ��������
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount( DrillplanVWSearchCond cond)throws BLException{
        return this.drillplanDAO.getDrillPlanVWCount(cond);
    }
    
    /**
     * ����diid��ȡ�ƻ���Ŀ��ͼ
     * @param diid
     * @return
     * @throws BLException
     */
    public DrillplanVWInfo getDrillPlanVWByDiid(int diid) throws BLException{
    	return this.drillplanDAO.getDrillPlanVWByDiid(diid);
    }
    /**
	 * ͳ�������ƻ�����������Ŀ�ļ���
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 */
	public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count)
	{
		return this.drillplanDAO.searchDrilledPlanByCond(cond, start, count);
	}
}