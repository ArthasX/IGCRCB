package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * ����ѡ����FORM
 * 
 */
public class IGASM1105Form extends BaseForm implements SOC0603SearchCond{

	private static final long serialVersionUID = 1L;

	/** ����ID */
	protected Integer eiid;
	
	/** ������ */
	protected String eilabel;
	
	/** �������� */
	protected String einame;
	
	/** ������ */
	protected String u_total;
	
	/** ��ǰ�������ID */
	protected String cur_room_eiid;
	
	/** ��ǰ��������� */
	protected String cur_room_name;
	
	/** ��ǰ�������λ�ã�X�� */
	protected String cur_room_x_value;
	
	/** ��ǰ�������λ�ã�Y�� */
	protected String cur_room_y_value;
	
	/** ��ѡ����ID */
	protected String sel_container_eiid;
	
	/** ����ѡ�����ʶ */
	protected String success = "0";
	
	/** �����ʲ�ID */
	protected String room_eid;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */

	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �������趨
	 *
	 * @param eilabel ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * ����߶ȣ�U���趨
	 *
	 * @param u_total ����߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**
	 * ��ǰ�������IDȡ��
	 * @return ��ǰ�������ID
	 */
	public String getCur_room_eiid() {
		return cur_room_eiid;
	}

	/**
	 * ��ǰ�������ID�趨
	 *
	 * @param cur_room_eiid ��ǰ�������ID
	 */
	public void setCur_room_eiid(String cur_room_eiid) {
		this.cur_room_eiid = cur_room_eiid;
	}

	/**
	 * ��ǰ���������ȡ��
	 * @return ��ǰ���������
	 */
	public String getCur_room_name() {
		return cur_room_name;
	}

	/**
	 * ��ǰ����������趨
	 *
	 * @param cur_room_name ��ǰ���������
	 */
	public void setCur_room_name(String cur_room_name) {
		this.cur_room_name = cur_room_name;
	}

	/**
	 * ��ǰ�������λ�ã�X��ȡ��
	 * @return ��ǰ�������λ�ã�X��
	 */
	public String getCur_room_x_value() {
		return cur_room_x_value;
	}

	/**
	 * ��ǰ�������λ�ã�X���趨
	 *
	 * @param cur_room_x_value ��ǰ�������λ�ã�X��
	 */
	public void setCur_room_x_value(String cur_room_x_value) {
		this.cur_room_x_value = cur_room_x_value;
	}

	/**
	 * ��ǰ�������λ�ã�Y��ȡ��
	 * @return ��ǰ�������λ�ã�Y��
	 */
	public String getCur_room_y_value() {
		return cur_room_y_value;
	}

	/**
	 * ��ǰ�������λ�ã�Y���趨
	 *
	 * @param cur_room_y_value ��ǰ�������λ�ã�Y��
	 */
	public void setCur_room_y_value(String cur_room_y_value) {
		this.cur_room_y_value = cur_room_y_value;
	}


	/**
	 * ��ѡ����IDȡ��
	 * @return ��ѡ����ID
	 */
	public String getSel_container_eiid() {
		return sel_container_eiid;
	}

	/**
	 * ��ѡ����ID�趨
	 *
	 * @param sel_container_eiid ��ѡ����ID
	 */
	public void setSel_container_eiid(String sel_container_eiid) {
		this.sel_container_eiid = sel_container_eiid;
	}

	/**
	 * ����ѡ�����ʶȡ��
	 * @return ����ѡ�����ʶ
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * ����ѡ�����ʶ�趨
	 *
	 * @param success ����ѡ�����ʶ
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * �����ʲ�IDȡ��
	 * @return �����ʲ�ID
	 */
	public String getRoom_eid() {
		return room_eid;
	}

	/**
	 * �����ʲ�ID�趨
	 *
	 * @param room_eid �����ʲ�ID
	 */
	public void setRoom_eid(String room_eid) {
		this.room_eid = room_eid;
	}

	public String getGraphstatus() {
		return null;
	}

	public String getContainertype() {
		return null;
	}

	public String getEitype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getU_value() {
		// TODO Auto-generated method stub
		return null;
	}


    public String getU_last() {
        // TODO Auto-generated method stub
        return null;
    }


    public String getLoad_last() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getPower_last() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.SOC0603SearchCond#getEilabel_like()
     */
    public String getEilabel_like() {
        // TODO Auto-generated method stub
        return null;
    }

	public Integer getRoom_eiid() {
		// TODO Auto-generated method stub
		return null;
	}
}
