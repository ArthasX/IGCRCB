/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息查询删除Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0401Form extends BaseForm implements SdlInfoSearchCond{
	
	/**信息删除主键*/
	protected String[] deleteSdlInfoid;
	
	/**类别*/
	protected String sitype;

	/**开始时间*/
	protected String sibegin;
	
	/**结束时间*/
	protected String siend;

	/**相关资产ID*/
	protected Integer sieiid;
	
	/**相关资产名称*/
	protected String sieiname;
	
	/**相关流程ID*/
	protected Integer siprid;
	
	/**相关事件流程名称*/
	protected String siprtitle;
	
	/**评分*/
	protected String simark;
	
	/**信息ID*/
	protected Integer siid;

	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * 获取类别
	 * 
	 * @return 类别
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * 设置类别
	 * @param sitype 类别
	 */
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * 获取开始时间
	 * 
	 * @return 开始时间
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * 设置开始时间
	 * @param sibegin 开始时间
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * 获取结束时间
	 * 
	 * @return 结束时间
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * 设置结束时间
	 * @param siend 结束时间
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * 获取相关资产ID
	 * 
	 * @return 相关资产ID
	 */
	public Integer getSieiid() {
		if(sieiid != null && sieiid != 0){
			return sieiid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关资产ID
	 * @param sieiid 相关资产ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * 获取相关流程ID
	 * 
	 * @return 相关流程ID
	 */
	public Integer getSiprid() {
		if(siprid != null && siprid != 0){
			return siprid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关流程ID
	 * @param siprid 相关流程ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * 获取评分
	 * 
	 * @return 评分
	 */
	public String getSimark() {
		return simark;
	}

	/**
	 * 设置评分
	 * @param simark 评分
	 */
	public void setSimark(String simark) {
		this.simark = simark;
	}
	
	/**
	 * 获取信息删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteSdlInfoid() {
		return deleteSdlInfoid;
	}

	/**
	 * 设置信息删除主键
	 * @param deleteSdlInfoid String[]
	 */
	
	public void setDeleteSdlInfoid(String[] deleteSdlInfoid) {
		this.deleteSdlInfoid = deleteSdlInfoid;
	}
	
	/**
	 * 获取相关资产名称
	 * @return 相关资产名称
	 */
	public String getSieiname() {
		return sieiname;
	}

	/**
	 * 设置相关资产名称
	 * @param sieiname 相关资产名称
	 */
	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}
	
	/**
	 * 获取相关流程名称
	 * @return 相关流程名称
	 */
	public String getSiprtitle() {
		return siprtitle;
	}

	/**
	 * 设置相关流程名称
	 * @param siprtitle 相关流程名称
	 */
	public void setSiprtitle(String siprtitle) {
		this.siprtitle = siprtitle;
	}
	
}
