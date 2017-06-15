/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程状态级私有表单默认值表检索条件实现
  * 功能描述: 流程状态级私有表单默认值表检索条件实现
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public class IG560SearchCondImpl implements
		IG560SearchCond {
	protected String pidid_q;
	protected String psdid_q;
	protected String pidid_l;
	protected String psdid_l;
	protected String usedToAll;
	/**查询全局默认值或psdid*/
	protected String tOrpsdid;
	protected String psdid;
	public String gettOrpsdid() {
		return tOrpsdid;
	}
	public void settOrpsdid(String tOrpsdid) {
		this.tOrpsdid = tOrpsdid;
	}
	public void setPidid_q(String pidid_q) {
		this.pidid_q = pidid_q;
	}
	public void setPsdid_q(String psdid_q) {
		this.psdid_q = psdid_q;
	}
	public void setPidid_l(String pidid_l) {
		this.pidid_l = pidid_l;
	}
	public void setPsdid_l(String psdid_l) {
		this.psdid_l = psdid_l;
	}
	public void setUsedToAll(String usedToAll) {
		this.usedToAll = usedToAll;
	}
	public String getPidid_q() {
		return pidid_q;
	}
	public String getPsdid_q() {
		return psdid_q;
	}
	public String getPidid_l() {
		return pidid_l;
	}
	public String getPsdid_l() {
		return psdid_l;
	}
	public String getUsedToAll() {
		return usedToAll;
	}
	/**  
	 * 获取psdid  
	 * @return psdid 
	 */
	public String getPsdid() {
		return psdid;
	}
	/**  
	 * 设置psdid  
	 * @param psdid
	 */
	
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	
	
	
	
}