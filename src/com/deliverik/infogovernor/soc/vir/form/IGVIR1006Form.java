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
 * Description: ���⻯�û���ҳForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1006Form extends BaseForm{

	/** ������� */
	protected String vmname;
	
	/** ���״̬ */
	protected String powerState;

	/** vcenter���� */
    protected Integer vcid;

	/**
	 * �������ȡ��
	 * @return vmname �������
	 */
	public String getVmname() {
		return vmname;
	}

	/**
	 * ��������趨
	 * @param vmname �������
	 */
	public void setVmname(String vmname) {
		this.vmname = vmname;
	}

	/**
	 * ���״̬ȡ��
	 * @return powerState ���״̬
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * ���״̬�趨
	 * @param powerState ���״̬
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

    /**
     * ��ȡvcenter����
     * @return vcenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vcenter����
     * @param vcid vcenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
}
