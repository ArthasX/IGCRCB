/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model;


/**
 * <p>概述:预算及工程分类信息视图接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */

public interface Pbsummary {
	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getPbrid();
	
	/**
	 * 获取预算表ID
	 * @return 预算表ID
	 */
	public Integer getBid();
	
	/**
	 * 获取预算类型
	 * @return 预算类型
	 */
	public String getBtype();
	
	/**
	 * 获取预算状态
	 * @return 预算状态
	 */
	public String getBstatus();
	
	/**
	 * 获取预算名称
	 * @return 预算名称
	 */
	public String getBtitle();
	
	/**
	 * 获取预算简介
	 * @return 预算简介
	 */
	public String getBdesc();
	
	/**
	 * 获取预算年份
	 * @return 预算年份
	 */
	public String getByear();
	
	/**
	 * 获取预算总额
	 * @return 预算总额
	 */
	public Double getBamount();
	
	/**
	 * 获取预算性质
	 * @return 预算性质
	 */
	public String getPquality();
	
	/**
	 * 获取预算储备预算编号
	 * @return 预算储备预算编号
	 */
	public String getPstorecode();
	
	/**
	 * 获取预算需求部门
	 * @return 预算需求部门
	 */
	public String getPneeddispart();
	
	/**
	 * 获取预算组成
	 * @return 预算组成
	 */
	public String getPbuggetform();
	
	/**
	 * 获取预算用途
	 * @return 预算用途
	 */
	public String getPuse();
	
	/**
	 * 获取预算备注
	 * @return 预算备注
	 */
	public String getRemark();
	
	/**
	 * 获取资本金开发预算总额
	 * @return 资本金开发预算总额
	 */
	public float getTotal1();
	
	/**
	 * 获取资本金硬件预算总额
	 * @return 资本金硬件预算总额
	 */
	public float getTotal2();
	
	/**
	 * 获取资本金软件预算总额
	 * @return 资本金软件预算总额
	 */
	public float getTotal3();
	
	/**
	 * 获取资本金工程预算总额
	 * @return 资本金工程预算总额
	 */
	public float getTotal4();
	
	/**
	 * 获取资本金其他预算总额
	 * @return 资本金其他预算总额
	 */
	public float getTotal5();
	
	/**
	 * 获取成本金实施预算总额
	 * @return 成本金实施预算总额
	 */
	public float getTotal6();
	
	/**
	 * 获取成本金其他预算总额
	 * @return 成本金其他预算总额
	 */
	public float getTotal7();
	
	/**
	 * 获取资本金开发已使用总额
	 * @return 资本金开发已使用总额
	 */
	public float getTotaluse1();
	
	/**
	 * 获取资本金硬件已使用总额
	 * @return 资本金硬件已使用总额
	 */
	public float getTotaluse2();
	
	/**
	 * 获取资本金软件已使用总额
	 * @return 资本金软件已使用总额
	 */
	public float getTotaluse3();
	
	/**
	 * 获取资本金工程已使用总额
	 * @return 资本金工程已使用总额
	 */
	public float getTotaluse4();
	
	/**
	 * 获取资本金其他已使用总额
	 * @return 资本金其他已使用总额
	 */
	public float getTotaluse5();
	
	/**
	 * 获取成本金实施已使用总额
	 * @return 成本金实施已使用总额
	 */
	public float getTotaluse6();
	
	/**
	 * 获取成本金其他已使用总额
	 * @return 成本金其他已使用总额
	 */
	public float getTotaluse7();
	
	/**
	 * 获取资本金开发剩余总额
	 * @return 资本金开发剩余总额
	 */
	public float getSub1();
	
	/**
	 * 获取资本金硬件剩余总额
	 * @return 资本金硬件剩余总额
	 */
	public float getSub2();
	
	/**
	 * 获取资本金软件剩余总额
	 * @return 资本金软件剩余总额
	 */
	public float getSub3();
	
	/**
	 * 获取资本金工程剩余总额
	 * @return 资本金工程剩余总额
	 */
	public float getSub4();
	
	/**
	 * 获取资本金其他剩余总额
	 * @return 资本金其他剩余总额
	 */
	public float getSub5();
	
	/**
	 * 获取成本金实施剩余总额
	 * @return 成本金实施剩余总额
	 */
	public float getSub6();
	
	/**
	 * 获取成本金其他剩余总额
	 * @return 成本金其他剩余总额
	 */
	public float getSub7();
	
	/**
	 * 获取资本金开发单笔预算使用额
	 * @return 资本金开发单笔预算使用额
	 */
	public float getUse1();
	
	/**
	 * 获取资本金硬件单笔预算使用额
	 * @return 资本金硬件单笔预算使用额
	 */
	public float getUse2();
	
	/**
	 * 获取资本金软件单笔预算使用额
	 * @return 资本金软件单笔预算使用额
	 */
	public float getUse3();
	
	/**
	 * 获取资本金工程单笔预算使用额
	 * @return 资本金工程单笔预算使用额
	 */
	public float getUse4();
	
	/**
	 * 获取资本金其他单笔预算使用额
	 * @return 资本金其他单笔预算使用额
	 */
	public float getUse5();
	
	/**
	 * 获取成本金实施单笔预算使用额
	 * @return 成本金实施单笔预算使用额
	 */
	public float getUse6();
	
	/**
	 * 获取成本金其他单笔预算使用额
	 * @return 成本金其他单笔预算使用额
	 */
	public float getUse7();
	
	/**
	 * 获取项目ID
	 * @return 项目ID
	 */
	public Integer getPid();
	
	/**
	 * 获取预算项目关系表ID
	 * @return 预算项目关系表ID
	 */
	public Integer getPbid();
}
