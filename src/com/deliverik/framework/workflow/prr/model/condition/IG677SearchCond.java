package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>
 * 流程记录与参与用户信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prtype</td>
 * <td>流程记录类型</td>
 * </tr>
 * <tr>
 * <td>ppuserid</td>
 * <td>流程参与用户ID</td>
 * </tr>
 * <tr>
 * <td>ppstatus</td>
 * <td>流程参与用户的参与状态</td>
 * </tr>
 * <tr>
 * <td>pproleid</td>
 * <td>流程参与用户角色ID</td>
 * </tr>
 * <tr>
 * <td>propentime</td>
 * <td>流程记录建立时间（大等于）</td>
 * </tr>
 * <tr>
 * <td>prclosetime</td>
 * <td>流程记录建立时间（小等于）</td>
 * </tr>
 * <tr>
 * <td>pcode</td>
 * <td>流程记录相关项目编号</td>
 * </tr>
 * <tr>
 * <td>prassetid</td>
 * <td>流程记录相关资产ID</td>
 * </tr>
 * <tr>
 * <td>prassetcategory</td>
 * <td>流程记录相关资产类型</td>
 * </tr>
 * <tr>
 * <td>prserialnum</td>
 * <td>流程记录工单号</td>
 * </tr>
 * <tr>
 * <td>prsubstatus</td>
 * <td>流程记录状态子状态</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG677SearchCond {
	/**
	 * 流程记录相关资产ID取得
	 * @return 流程记录相关资产ID
	 */
	public Integer getPrassetid();

	/**
	 * 流程记录相关资产类型取得
	 * @return 流程记录相关资产类型
	 */
	public String getPrassetcategory();

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus();

	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle();

	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype();

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus();
	
	/**
	 * 流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid();

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid();

	/**
	 * 流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime();

	/**
	 * 流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime();
	
	/**
	 * 流程参与用户处理完成开始时间取得
	 * @return 流程参与用户处理开始时间
	 */
	public String getPpproctime_from();
	
	/**
	 * 流程参与用户处理完成结束时间取得
	 * @return 流程参与用户处理完成结束时间
	 */
	public String getPpproctime_to();

	/**
	 * 流程参与用户名字取得
	 * @return 流程参与用户名字
	 */
	public String getPpusername();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency();

	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime();
	/**
	 * 流程记录建立时间（小等于）取得
	 * @return 流程记录建立时间（小等于）
	 */
	public String getPrclosetime();

	/**
	 * 流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode();

	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime();

	/**
	 * 流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration();

	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus();

	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();
	
	
	/**
	 * 平台保留
	 * @return 
	 */
	public String getMode();

	/**
	 * 平台保留
	 * @return 
	 */
	public String getPrActive();

	/**
	 * 平台保留
	 * @return 
	 */
	public boolean isTodo();
	
	/**
	 * 平台保留
	 * @return 
	 */
	public int getIsWork();

	/**
	 * 平台保留
	 * @return 
	 */
	public String getSelectMode();

	/**
	 * 平台保留
	 * @return 
	 */
	public boolean isToImplement();
	
	/**
	 * 功能：发文流程状态过滤条件取得
	 * @return 发文流程状态过滤条件
	 */
	public String getDsstatus();
	
	 /**
     * 流程模版取得
     *
     * @return prpdid 流程模版
     */
    public String getPrpdid();
    
    /**
     * 取得
     *
     * @return prtypes 
     */
    public String[] getPrtypes();
    
    /**
	 * 流程节点状态表示码(完全匹配)取得
	 * @return
	 */
	public String getPsdid_eq();
	
	/**
	 * 发起人机构码(完全匹配)取得
	 * @return
	 */
	public String getPporgid_eq();
}
