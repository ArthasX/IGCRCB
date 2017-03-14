/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_工作餐收益统计信息MODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface WorkLunchEatery {
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getWldate();
	
	/**
	 * 成本合计
	 * @return 成本合计
	 */
	public String getAllcost();
	
	/**
	 * 调味品成本
	 * @return eflavouringcost 调味品成本
	 */
	public String getEflavouringcost();
	
	/**
	 * 采购原料成本
	 * @return 采购原料成本
	 */
	public String getEstaplecost();
	
	/**
	 * 其他成本
	 * @return 其他成本
	 */
	public String getEothercost();
	
	public String getLunchcardname();
	
	public String getLunchcardnum();
	
	public String getIncost();
	
	public String getOutcost();
	
	public void setWldate(String wldate);
	
	public void setAllcost(String allcost);
	
	public void setEflavouringcost(String eflavouringcost);
	
	public void setEstaplecost(String estaplecost);
	
	public void setEothercost(String eothercost);
	
	public void setLunchcardname(String lunchcardname);
	
	public void setLunchcardnum(String lunchcardnum);
	
	public void setIncost(String incost);
	
	public void setOutcost(String outcost);
	
	public String getLunchcardprice();
	
	public void setLunchcardprice(String lunchcardprice);
	

}