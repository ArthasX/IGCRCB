package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * 机柜选择画面FORM
 * 
 */
public class IGASM1105Form extends BaseForm implements SOC0603SearchCond{

	private static final long serialVersionUID = 1L;

	/** 机柜ID */
	protected Integer eiid;
	
	/** 机柜编号 */
	protected String eilabel;
	
	/** 机柜名称 */
	protected String einame;
	
	/** 机房高 */
	protected String u_total;
	
	/** 当前处理机房ID */
	protected String cur_room_eiid;
	
	/** 当前处理机房名 */
	protected String cur_room_name;
	
	/** 当前处理机房位置（X） */
	protected String cur_room_x_value;
	
	/** 当前处理机房位置（Y） */
	protected String cur_room_y_value;
	
	/** 被选机柜ID */
	protected String sel_container_eiid;
	
	/** 机柜选择处理标识 */
	protected String success = "0";
	
	/** 机房资产ID */
	protected String room_eid;
	
	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */

	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 机柜编号取得
	 * @return 机柜编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机柜编号设定
	 *
	 * @param eilabel 机柜编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机柜名称设定
	 *
	 * @param einame 机柜名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 机柜高度（U）取得
	 * @return 机柜高度（U）
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * 机柜高度（U）设定
	 *
	 * @param u_total 机柜高度（U）
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**
	 * 当前处理机房ID取得
	 * @return 当前处理机房ID
	 */
	public String getCur_room_eiid() {
		return cur_room_eiid;
	}

	/**
	 * 当前处理机房ID设定
	 *
	 * @param cur_room_eiid 当前处理机房ID
	 */
	public void setCur_room_eiid(String cur_room_eiid) {
		this.cur_room_eiid = cur_room_eiid;
	}

	/**
	 * 当前处理机房名取得
	 * @return 当前处理机房名
	 */
	public String getCur_room_name() {
		return cur_room_name;
	}

	/**
	 * 当前处理机房名设定
	 *
	 * @param cur_room_name 当前处理机房名
	 */
	public void setCur_room_name(String cur_room_name) {
		this.cur_room_name = cur_room_name;
	}

	/**
	 * 当前处理机房位置（X）取得
	 * @return 当前处理机房位置（X）
	 */
	public String getCur_room_x_value() {
		return cur_room_x_value;
	}

	/**
	 * 当前处理机房位置（X）设定
	 *
	 * @param cur_room_x_value 当前处理机房位置（X）
	 */
	public void setCur_room_x_value(String cur_room_x_value) {
		this.cur_room_x_value = cur_room_x_value;
	}

	/**
	 * 当前处理机房位置（Y）取得
	 * @return 当前处理机房位置（Y）
	 */
	public String getCur_room_y_value() {
		return cur_room_y_value;
	}

	/**
	 * 当前处理机房位置（Y）设定
	 *
	 * @param cur_room_y_value 当前处理机房位置（Y）
	 */
	public void setCur_room_y_value(String cur_room_y_value) {
		this.cur_room_y_value = cur_room_y_value;
	}


	/**
	 * 被选机柜ID取得
	 * @return 被选机柜ID
	 */
	public String getSel_container_eiid() {
		return sel_container_eiid;
	}

	/**
	 * 被选机柜ID设定
	 *
	 * @param sel_container_eiid 被选机柜ID
	 */
	public void setSel_container_eiid(String sel_container_eiid) {
		this.sel_container_eiid = sel_container_eiid;
	}

	/**
	 * 机柜选择处理标识取得
	 * @return 机柜选择处理标识
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * 机柜选择处理标识设定
	 *
	 * @param success 机柜选择处理标识
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * 机房资产ID取得
	 * @return 机房资产ID
	 */
	public String getRoom_eid() {
		return room_eid;
	}

	/**
	 * 机房资产ID设定
	 *
	 * @param room_eid 机房资产ID
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
