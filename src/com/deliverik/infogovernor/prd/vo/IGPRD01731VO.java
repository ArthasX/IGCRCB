/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Ԥ��vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01731VO extends BaseVO{

	/** ������������Ϣ */
	protected IG007Info pidInfo;

	/**
	 * ������������Ϣȡ��
	 * @return pidInfo ������������Ϣ
	 */
	public IG007Info getPidInfo() {
		return pidInfo;
	}

	/**
	 * ������������Ϣ�趨
	 * @param pidInfo ������������Ϣ
	 */
	public void setPidInfo(IG007Info pidInfo) {
		this.pidInfo = pidInfo;
	}
	
}
