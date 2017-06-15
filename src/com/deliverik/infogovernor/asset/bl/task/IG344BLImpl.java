/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG344DAO;

/**
  * ����: ҵ���߼�ʵ��
  * ��������: ҵ���߼�ʵ��
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
public class IG344BLImpl extends BaseBLImpl implements
		IG344BL {

	/** ig344dao�ӿ� */
	protected IG344DAO ig344DAO;
	

    /**
     * ig344dao�ӿ��趨
     *
     * @param ig344dao ig344DAO
     */
    public void setIg344DAO(IG344DAO ig344dao) {
        ig344DAO = ig344dao;
    }


    /**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<IG344Info> searchIG344(IG344SearchCond cond, int start, int count) {
        return ig344DAO.findByCond(cond, start, count);
    }
}