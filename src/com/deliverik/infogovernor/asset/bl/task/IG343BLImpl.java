/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG343DAO;
import com.deliverik.infogovernor.asset.model.entity.IG343VW;

/**
  * ����: ҵ���߼�ʵ��
  * ��������: ҵ���߼�ʵ��
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public class IG343BLImpl extends BaseBLImpl implements
		IG343BL {

	/** ig343dao�ӿ� */
	protected IG343DAO ig343DAO;
	

    /**
     * ig343dao�ӿ��趨
     *
     * @param ig343dao ig343DAO
     */
    public void setIg343DAO(IG343DAO ig343dao) {
        ig343DAO = ig343dao;
    }

    /**
	 * IG343VWʵ��ȡ��
	 *
	 * @return IG343VWʵ��
	 */
	public IG343VW getIG343() {
		return new IG343VW();
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<IG343Info> searchIG343(IG343SearchCond cond, int start, int count) {
        return ig343DAO.findByCond(cond, start, count);
    }

}