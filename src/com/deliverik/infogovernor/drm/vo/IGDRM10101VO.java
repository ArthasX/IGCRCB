/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ������̨VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM10101VO extends BaseVO{

	/** ����̨��Ϣ */
	protected Map<String, String> workbenchMap;

	/**
	 * ����̨��Ϣȡ��
	 * @return workbenchMap ����̨��Ϣ
	 */
	public Map<String, String> getWorkbenchMap() {
		return workbenchMap;
	}

	/**
	 * ����̨��Ϣ�趨
	 * @param workbenchMap ����̨��Ϣ
	 */
	public void setWorkbenchMap(Map<String, String> workbenchMap) {
		this.workbenchMap = workbenchMap;
	}
}
