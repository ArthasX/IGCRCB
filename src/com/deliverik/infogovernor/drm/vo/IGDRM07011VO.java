/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM07011VO extends BaseVO{
	/**������������׶�����*/
	protected List<IG500Info> ig500InfoList;

	public List<IG500Info> getIg500InfoList() {
		return ig500InfoList;
	}

	public void setIg500InfoList(List<IG500Info> ig500InfoList) {
		this.ig500InfoList = ig500InfoList;
	}
	
	
}
