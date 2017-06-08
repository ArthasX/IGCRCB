package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * 流程记录信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prtitle</td>
 * <td>流程记录题目（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>prstatus</td>
 * <td>流程记录状态</td>
 * </tr>
 * <tr>
 * <td>pcode</td>
 * <td>流程记录相关项目编号</td>
 * </tr>
 * <tr>
 * <td>prusername</td>
 * <td>流程记录发起者用户姓名</td>
 * </tr>
 * <tr>
 * <td>prid</td>
 * <td>流程记录ID</td>
 * </tr>
 * <tr>
 * <td>prurgency</td>
 * <td>流程记录紧急程度</td>
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
 * <td>pruserid</td>
 * <td>流程记录发起者用户ID</td>
 * </tr>
 * <tr>
 * <td>prroleid</td>
 * <td>流程记录发起者角色ID</td>
 * </tr>
 * <tr>
 * <td>prpdid</td>
 * <td>流程记录流程类型ID</td>
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
 * <tr>
 * <td>approveflag</td>
 * <td>个人工作的当前用户是否存在流程审批角色</td>
 * </tr>
 * <tr>
 * <td>varnames</td>
 * <td>表单名集合</td>
 * </tr>
 * <tr>
 * <td>varvalues</td>
 * <td>表单值集合</td>
 * </tr>
 * <tr>
 * <td>pdactname</td>
 * <td>流程关联菜单</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG500SearchCond {
	/**
	 * 流程记录题目取得
	 * @return  流程记录题目
	 */
	public String getPrtitle();

	/**
	 * 流程记录类型取得
	 * @return  流程记录类型
	 */
	public String getPrtype();
	
	/**
	 * 流程记录类型数组取得
	 * @return  流程记录类型数组
	 */
	public String[] getPrtypes();

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	/**
	 * 流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode();

	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername();

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
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime();

	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid();

	/**
	 * 一组流程记录流程类型ID模糊查询取得
	 *
	 * @return prpdid_like_or 一组流程记录流程类型ID模糊查询
	 */
	public String[] getPrpdid_like_or();
	
	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid();

	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid();

	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime();
	
	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime_like();
	
	
	/**
	 * 流程记录关闭时间(like)取得
	 * @return
	 */
	public String getPrclosetime_like();

	/**
	 * 流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration();

	
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
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();

	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus();

	/**
	 * 流程记录多种流程类型数组取得
	 * @return 流程记录流程类型数组
	 */
	public String[] getPrTypeArray();
	
	/**
	 * 流程记录多种流程状态数组取得
	 * @return 流程记录流程状态数组
	 */
	public String[] getPrStatusArray();
	
	
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
	public List<Integer> getPridNotInList();

	/**
	 * 平台保留
	 * @return 
	 */
	public List<String> getPrserialnumNotInList();

	/**
	 * 平台保留
	 * @return 
	 */
	public String getPrActive();
	
	/**
	 * 平台保留
	 */
	public String getUserid_q();
	
	/**
	 * 查询内容
	 * @return 
	 */
	public String getPrdesc();
	
	/**
	 * 排序标识
	 * @return
	 * */
	public String getOrder();
	
	public String getSing();
	
	public String getPrimpact();
	
	public String getPrpriority();
	
	/**
	 * 个人工作的当前用户是否存在流程审批角色
	 * 存在:1
	 * @return
	 */
	public String getApproveflag();
	
	/**
	 * 表单名集合取得
	 * @return 表单名集合
	 */
	public String[] getVarnames();
	
	/**
	 * 表单名集合设定
	 * @return 表单名集合
	 */
	public String[] getVarvalues();
	
	/**
	 * @return the 条件标识
	 */
	public String[] getVarmodes();
	
	/**
	 * 流程参与人（like）取得
	 *
	 * @return ppusername_like 流程参与人（like）
	 */
	public String getPpusername_like();
	
	/**
	 * 流程参与人ID取得
	 * @return ppuserid 流程参与人ID
	 */
	public String getPpuserid();
	public String getPpuserid_like();

	/**
	 * 流程类型指定状态数组(数据格式：prpdid_ppstatus)取得
	 * @return 流程类型指定状态数组(数据格式：prpdid_ppstatus)
	 */
	public String[] getPrpdidAndPpstatus_or();
	
	/**
	 * 流程参与人所属流程状态取得
	 * @return 流程参与人所属流程状态
	 */
    public String getPpstatus_eq();
    
    /**
	 * 流程参与人处理时间是否为空标识取得
	 * @return 流程参与人处理时间是否为空标识
	 */
	public String getPpproctime_status_active();
	
    /**
	 * 流程参与人ID(和状态联动)取得
	 * @return 流程参与人ID(和状态联动)
	 */
	public String getPpuserid_status_eq();
	
	/**
	 * 流程参与人角色类型(和状态联动)取得
	 * @return 流程参与人角色类型(和状态联动)
	 */
	public String getRoletype_status_eq();
	
    /**
	 * 流程参与人所属角色数组(和状态联动)取得
	 * @return 流程参与人所属角色数组(和状态联动)
	 */
	public String[] getPproleid_status_in();
	
	/**
	 * 发起人机构码取得
	 * @return 发起人机构码
	 */
	public String getProrgid_like();
	
	/**
     * 流程记录工单号like数组取得
     * @return prserialnum_likeArr 流程记录工单号like数组
     */
    public String[] getPrserialnum_likeArr();

    /**
	 * 流程状态不等于取得
	 * @return prstatus_ne 流程状态不等于
	 */
	public String getPrstatus_ne();
	
	/**
	 * 流程记录建立时间（like）取得
	 * @return propentime_eq 流程记录建立时间（like）
	 */
	public String getPropentime_like();
	
	/**
	 * 内外需流程标识取得
	 * @return lctype 内外需流程标识
	 */
	public String getLctype();
	
	/**
	 * 发起人机构码取得
	 * @return prorgid_in 发起人机构码
	 */
	public String getProrgid_in();

	/**
     * 问题来源取得
     *
     * @return prassetname 问题来源
     */
    public String getPrassetname();
	
	/**
	 * 获取流程id范围
	 * @return
	 */
	public String getPrid_in();
	
	/**
	 * 关联菜单取得
	 * @return pdactname 关联菜单
	 */
	public String getPdactname();
	


	/**
	 * 发起角色ID集合取得
	 * @return prroleid_in 发起角色ID集合
	 */
	public List<Integer> getPrroleid_in();

	/**
	 * 发起角色ID集合取得
	 * @return prroleid_not_in 发起角色ID集合
	 */
	public List<Integer> getPrroleid_not_in();

	/**
	 * 处理人处理状态
	 * @return Ppstatus  处理人处理状态
	 */
	public String getPpstatus();
	
	/**
	 * 搜索关键字取得
	 * @return content 搜索关键字
	 */
	public String getContent();
	/**
	 * 表单值集合取得
	 * @return the varvalues_in
	 */
	public String[] getVarvalues_in();
	
	/**
	 * 表单名集合取得
	 * @return the varnames_in
	 */
	public String[] getVarnames_in();
	
	/**
	 * 是否为告警事件1为是0为否获取获取
	 * @return the alarm_Is
	 */
	public String getAlarm_Is();
	
	/**
	 * 事是否已经确认1为否0为是获取
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull();
		/**
	 * 变更结果的标示(Y代表成功)取得
	 * @return pivarlabel 变更结果的标示(Y代表成功)
	 */
	public String getPivarlabel();
	
	/**
	 * 事件请求分类
	 * @return PivarValue 截取前6位
	 */
	public String getPivarValue();
	
	/**
	 * 服务请求分类
	 * @return PivarValue 截取前6位
	 */
	
	public String getPppivarValue();
	/**
	 * @return the 流程组ID
	 */
	public Integer getPid();
	
	/**
	 * 是否为领导
	 * @return
	 */
	public String getLeaderFlag();
	
	/**
	 * 机构id
	 * @return
	 */
	public String getOrgID();
	
	/**flag标记*/
	public String getFlag();

	/** 处置类型(演练/应急) */
	public String getDwpType();

	/** 流程名*/
	public String getPrpdname();
}
