package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;

/**
 * 设备选择画面FORM
 * 
 */
public class IGASM1115Form extends BaseForm implements SOC0602SearchCond{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected Integer eiid;
	
	/** 设备编号 */
	protected String eilabel;
	
	/** 设备名称 */
	protected String einame;
	
	/** 设备高 */
	protected String u_total;
	
	/** 当前处理机柜ID */
	protected String cur_container_eiid;
	
	/** 当前处理机柜名 */
	protected String cur_container_name;
	
	/** 当前处理机柜位置（U） */
	protected String cur_container_u_value;
	
	/** 被选设备ID */
	protected String sel_device_eiid;
	
	/** 设备选择处理标识 */
	protected String success = "0";
	
	/** 机柜资产ID */
	protected String container_eid;
	
	/** 设备状态 */
	protected String[] eiStatuses;
	
	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 设备编号取得
	 * @return 设备编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备编号设定
	 *
	 * @param eilabel 设备编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 设备名称取得
	 * @return 设备名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备名称设定
	 *
	 * @param einame 设备名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备高度（U）取得
	 * @return 设备高度（U）
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * 设备高度（U）设定
	 *
	 * @param u_total 设备高度（U）
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**
	 * 当前处理机柜ID取得
	 * @return 当前处理机柜ID
	 */
	public String getCur_container_eiid() {
		return cur_container_eiid;
	}

	/**
	 * 当前处理机柜ID设定
	 *
	 * @param cur_container_eiid 当前处理机柜ID
	 */
	public void setCur_container_eiid(String cur_container_eiid) {
		this.cur_container_eiid = cur_container_eiid;
	}

	/**
	 * 当前处理机柜名取得
	 * @return 当前处理机柜名
	 */
	public String getCur_container_name() {
		return cur_container_name;
	}

	/**
	 * 当前处理机柜名设定
	 *
	 * @param cur_container_name 当前处理机柜名
	 */
	public void setCur_container_name(String cur_container_name) {
		this.cur_container_name = cur_container_name;
	}

	/**
	 * 当前处理机柜位置（U）取得
	 * @return 当前处理机柜位置（U）
	 */
	public String getCur_container_u_value() {
		return cur_container_u_value;
	}

	/**
	 * 当前处理机柜位置（U）设定
	 *
	 * @param cur_container_u_value 当前处理机柜位置（U）
	 */
	public void setCur_container_u_value(String cur_container_u_value) {
		this.cur_container_u_value = cur_container_u_value;
	}

	/**
	 * 被选设备ID取得
	 * @return 被选设备ID
	 */
	public String getSel_device_eiid() {
		return sel_device_eiid;
	}

	/**
	 * 被选设备ID设定
	 *
	 * @param sel_device_eiid 被选设备ID
	 */
	public void setSel_device_eiid(String sel_device_eiid) {
		this.sel_device_eiid = sel_device_eiid;
	}

	/**
	 * 设备选择处理标识取得
	 * @return 设备选择处理标识
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * 设备选择处理标识设定
	 *
	 * @param success 设备选择处理标识
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * 机柜资产ID取得
	 * @return 机柜资产ID
	 */
	public String getContainer_eid() {
		return container_eid;
	}

	/**
	 * 机柜资产ID设定
	 *
	 * @param container_eid 机柜资产ID
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
