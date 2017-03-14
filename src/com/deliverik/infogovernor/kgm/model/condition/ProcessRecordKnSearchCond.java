/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * @Description: 知识管理查询
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public interface ProcessRecordKnSearchCond {
	public String getPrktitle();

	public String getPrktype();

	public String getPrkstatus();

	public Integer getPrkid();

	public String getPcode();

	public String getPrkusername();

	public String getPrkurgency();

	public String getPrkopentime();

	public String getPrkclosetime();

	public String getPrkActive();

	public String getPrkuserid();

	public Integer getPrkroleid();

	public String getPrkplantime();

	public String getPrkduration();

	public String getSelectMode();

	public int getIsWork();

	public Integer getPrkassetid();

	public String getPrkassetcategory();

	public String getPrkserialnum();

	public String getPrksubstatus();
	
	public String getPrkkey_q();
	
	public String getPrktitle_q();
	
	public String getPrstatus();
	
}
