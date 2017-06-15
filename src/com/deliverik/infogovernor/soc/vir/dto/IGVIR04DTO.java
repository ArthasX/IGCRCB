/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Դ��������DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR04DTO extends BaseDTO{

	/** ����ID */
	protected Integer prid;
	
	/** ��ĿID */
	protected Integer pid;
	
	/** ���ID */
	protected Integer[] vmids;
	
	/** �û���Ϣ */
	protected User user;
	
	/** json��� */
	protected String jsonResult;

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ���IDȡ��
	 * @return vmids ���ID
	 */
	public Integer[] getVmids() {
		return vmids;
	}

	/**
	 * ���ID�趨
	 * @param vmids ���ID
	 */
	public void setVmids(Integer[] vmids) {
		this.vmids = vmids;
	}

	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * json���ȡ��
	 * @return jsonResult json���
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json����趨
	 * @param jsonResult json���
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
}
