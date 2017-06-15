/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG342DAO;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * ����: ҵ���߼�ʵ��
  * ��������: ҵ���߼�ʵ��
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public class IG342BLImpl extends BaseBLImpl implements
		IG342BL {

	/** ig342DAO�ӿ� */
	protected IG342DAO ig342DAO;
	

    /**
     * ig342DAO�ӿ��趨
     *
     * @param ig342dao ig342DAO�ӿ�
     */
    public void setIg342DAO(IG342DAO ig342dao) {
        ig342DAO = ig342dao;
    }

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG342SearchCond cond) {
		return ig342DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG342Info> searchIG342(
			IG342SearchCond cond) {
		return ig342DAO.findByCond(cond, 0, 0);
	}


    public IG342VW getIG342() {
        return new IG342VW();
    }

    public List<IG342Info> searchIG342(IG342SearchCond cond, int start, int count) {
        return ig342DAO.findByCond(cond, start, count);
    }

}