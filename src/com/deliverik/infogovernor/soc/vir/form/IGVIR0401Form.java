/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Դ�������뷢��Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR0401Form extends BaseForm{

	/** ����ID */
	protected Integer prid;
	
	/** ��ĿID */
	protected Integer pid;
	
	/** ���ID */
	protected Integer[] vmids;

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
}
