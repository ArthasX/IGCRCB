/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.risk.form.IGRIS0203Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����������VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC04031VO extends BaseVO{

	/** ������Ϣ */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;

	protected IGRIS0203Form form;
	
	protected Integer[] prids;
	/**
	 * ������Ϣȡ��
	 * @return assignInfo ������Ϣ
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	/**
	 * ������Ϣ�趨
	 * @param assignInfo ������Ϣ
	 */
	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	/**
	 * @return the form
	 */
	public IGRIS0203Form getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(IGRIS0203Form form) {
		this.form = form;
	}

	/**
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}

	/**
	 * @param prids the prids to set
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	
	
	
}
