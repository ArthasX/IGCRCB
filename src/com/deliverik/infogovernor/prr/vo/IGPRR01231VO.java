/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG113Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����־��ʾVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR01231VO extends BaseVO{

	/** ����־����*/
	protected List<IG113Info> varLogList;

	/**
	 * ����־����ȡ��
	 * @return varLogList ����־����
	 */
	public List<IG113Info> getVarLogList() {
		return varLogList;
	}

	/**
	 * ����־�����趨
	 * @param varLogList ����־����
	 */
	public void setVarLogList(List<IG113Info> varLogList) {
		this.varLogList = varLogList;
	}
}
