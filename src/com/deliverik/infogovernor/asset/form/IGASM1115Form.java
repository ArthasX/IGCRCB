package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;

/**
 * �豸ѡ����FORM
 * 
 */
public class IGASM1115Form extends BaseForm implements SOC0602SearchCond{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected Integer eiid;
	
	/** �豸��� */
	protected String eilabel;
	
	/** �豸���� */
	protected String einame;
	
	/** �豸�� */
	protected String u_total;
	
	/** ��ǰ�������ID */
	protected String cur_container_eiid;
	
	/** ��ǰ��������� */
	protected String cur_container_name;
	
	/** ��ǰ�������λ�ã�U�� */
	protected String cur_container_u_value;
	
	/** ��ѡ�豸ID */
	protected String sel_device_eiid;
	
	/** �豸ѡ�����ʶ */
	protected String success = "0";
	
	/** �����ʲ�ID */
	protected String container_eid;
	
	/** �豸״̬ */
	protected String[] eiStatuses;
	
	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * �豸���ȡ��
	 * @return �豸���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸����趨
	 *
	 * @param eilabel �豸���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�����趨
	 *
	 * @param einame �豸����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸�߶ȣ�U��ȡ��
	 * @return �豸�߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * �豸�߶ȣ�U���趨
	 *
	 * @param u_total �豸�߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**
	 * ��ǰ�������IDȡ��
	 * @return ��ǰ�������ID
	 */
	public String getCur_container_eiid() {
		return cur_container_eiid;
	}

	/**
	 * ��ǰ�������ID�趨
	 *
	 * @param cur_container_eiid ��ǰ�������ID
	 */
	public void setCur_container_eiid(String cur_container_eiid) {
		this.cur_container_eiid = cur_container_eiid;
	}

	/**
	 * ��ǰ���������ȡ��
	 * @return ��ǰ���������
	 */
	public String getCur_container_name() {
		return cur_container_name;
	}

	/**
	 * ��ǰ����������趨
	 *
	 * @param cur_container_name ��ǰ���������
	 */
	public void setCur_container_name(String cur_container_name) {
		this.cur_container_name = cur_container_name;
	}

	/**
	 * ��ǰ�������λ�ã�U��ȡ��
	 * @return ��ǰ�������λ�ã�U��
	 */
	public String getCur_container_u_value() {
		return cur_container_u_value;
	}

	/**
	 * ��ǰ�������λ�ã�U���趨
	 *
	 * @param cur_container_u_value ��ǰ�������λ�ã�U��
	 */
	public void setCur_container_u_value(String cur_container_u_value) {
		this.cur_container_u_value = cur_container_u_value;
	}

	/**
	 * ��ѡ�豸IDȡ��
	 * @return ��ѡ�豸ID
	 */
	public String getSel_device_eiid() {
		return sel_device_eiid;
	}

	/**
	 * ��ѡ�豸ID�趨
	 *
	 * @param sel_device_eiid ��ѡ�豸ID
	 */
	public void setSel_device_eiid(String sel_device_eiid) {
		this.sel_device_eiid = sel_device_eiid;
	}

	/**
	 * �豸ѡ�����ʶȡ��
	 * @return �豸ѡ�����ʶ
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * �豸ѡ�����ʶ�趨
	 *
	 * @param success �豸ѡ�����ʶ
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * �����ʲ�IDȡ��
	 * @return �����ʲ�ID
	 */
	public String getContainer_eid() {
		return container_eid;
	}

	/**
	 * �����ʲ�ID�趨
	 *
	 * @param container_eid �����ʲ�ID
	 */
	public void setContainer_eid(String container_eid) {
		this.container_eid = container_eid;
	}

	public String getInJiguiFlg() {
		return null;
	}

	public String getEsyscoding() {
		return null;
	}

	public String getInroomFlg() {
		return null;
	}

	/**
	 * @return the eiStatuses
	 */
	public String[] getEiStatuses() {
		return eiStatuses;
	}

	/**
	 * @param eiStatuses the eiStatuses to set
	 */
	public void setEiStatuses(String[] eiStatuses) {
		this.eiStatuses = eiStatuses;
	}

    public Integer getRoom_eiid() {
        return null;
    }

	public Integer getContainer_eiid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCabinet() {
		// TODO Auto-generated method stub
		return null;
	}
}
