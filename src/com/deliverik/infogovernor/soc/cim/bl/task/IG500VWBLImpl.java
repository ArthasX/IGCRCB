/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;
import com.deliverik.infogovernor.soc.cim.model.dao.IG500VWDAO;


/**
 * ����: �ʲ�������̲�ѯ
 * ��������: �ʲ�������̲�ѯ
 * ������¼: 2014/03/13
 * �޸ļ�¼: 
 */
public class IG500VWBLImpl extends BaseBLImpl implements
	IG500VWBL {

	protected IG500VWDAO ig500VWDAO;
	
	/**
	 * ig500VWDAO�趨
	 * @param ig500VWDAO ig500VWDAO
	 */
	public void setIg500VWDAO(IG500VWDAO ig500vwdao) {
		ig500VWDAO = ig500vwdao;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<IG500VWInfo> findByCond(IG500VWSearchCond cond) {
		return ig500VWDAO.findByCond(cond);
	}
}