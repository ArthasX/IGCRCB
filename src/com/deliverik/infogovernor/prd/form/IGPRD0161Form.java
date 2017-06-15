/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * 表单信息查询画面Form
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0161Form extends BaseForm implements IG992Info{

	protected String mode = "0";


	protected Integer Pedid;


	/** 外部事件ID */
	protected String pedeventid;

	/** 外部动作 */
	protected String pedaction;

	/** 外部事件描述 */
	protected String peddesc;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPedid() {
		return Pedid;
	}

	/**
	 * 主键设定
	 *
	 * @param Pedid 主键
	 */
	public void setPedid(Integer Pedid) {
		this.Pedid = Pedid;
	}

	/**
	 * 事件ID取得
	 *
	 * @return 事件ID
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * 事件ID设定
	 *
	 * @param pedeventid 事件ID
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * 外部事件动作取得
	 *
	 * @return 外部事件动作
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * 外部事件动作设定
	 *
	 * @param pedaction 外部事件动作
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * 描述设定
	 *
	 * @param peddesc 描述
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

}
