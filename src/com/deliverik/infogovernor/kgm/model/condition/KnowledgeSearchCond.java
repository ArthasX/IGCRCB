/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:流程评审Cond接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeSearchCond {
	
	/**
	 *编号
	 */
	public Integer getKnid();
	
	
	/**
	 *编号
	 */
	public String getKnserial();

	/**
	 *部门
	 */
	public String getKndepartment();

	/**
	 *归档人
	 */
	public String getKnapprover();


	/**
	 *分类
	 */
	public String getKnclass();

	/**
	 *关键字
	 */
	public String getKnkey();

	/**
	 *来源
	 */
	public String getKnorigin();

	/**
	 *知识贡献人
	 */
	public String getKnproffer();


	/**
	 *标题
	 */
	public String getKntitle();

	/**
	 *问题描述
	 */
	public String getKndes();

	/**
	 *故障原因总结
	 */
	public String getKnfaultcause();

	/**
	 *解决办法
	 */
	public String getKnsolveway();

	/**
	 *状态
	 */
	public String getKnstatus();
	
	/**
	 *关键字数组取得
	 * 
	 * @return 关键字数组
	 */
	public String[] getKnkeys();
	
	/**
	 *标题数组取得
	 * 
	 * @return 标题数组
	 */
	public String[] getKntitles();
	
	/**
	 *归档人姓名取得
	 * 
	 * @return 归档人姓名
	 */
	public String getKnapprovername();
	
	/**
	 *知识贡献人姓名取得
	 * 
	 * @return 知识贡献人姓名
	 */
	public String getKnproffername() ;
	
	/**
	 *归档时间从取得
	 * 
	 * @return 归档时间从
	 */
	public String getKnapprovetime_f();
	/**
	 *归档时间到取得
	 * 
	 * @return 归档时间到
	 */
	public String getKnapprovetime_t();
	
	/**
	 *贡献时间从取得
	 * 
	 * @return 贡献时间从
	 */
	public String getKnproffertime_f();
	
	/**
	 *贡献时间到取得
	 * 
	 * @return 贡献时间到
	 */
	public String getKnproffertime_t() ;
	
	/**
	 *业务领域取得
	 * 
	 * @return 业务领域
	 */
	public String getKnarea();
	public String getSystemid();
	/**
	 *技术领域取得
	 * 
	 * @return 技术领域
	 */
	public String getKntelarea();
	
	public Integer getKnapproverole() ;

	public Integer[] getKnapproveroles();
	
	/**
	 *知识编号取得
	 * 
	 * @return 知识编号
	 */
	public String getKnserial_like();
	public String getSing();
	public String getSelectstatus();
	public String getOrder();
	
	public String getKnclass_like();
}
