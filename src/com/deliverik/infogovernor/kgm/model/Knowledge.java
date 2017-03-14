/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.Attachment;

/**
 * 概述: 知识信息接口
 * 功能描述：知识信息接口
 * 创建记录：wangxiaoqiang    2010/12/07
 * 修改记录：
 */
public interface Knowledge extends BaseModel{
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKnid();
	
	/**
	 *知识版本取得
	 * 
	 * @return 知识版本
	 */
	public Integer getKnversion();
	
	/**
	 * 编号取得
	 * 
	 * @return 编号
	 */
	public String getKnserial();

	/**
	 * 部门取得
	 * 
	 * @return 部门
	 */
	public String getKndepartment();

	/**
	 * 归档人取得
	 * 
	 * @return 归档人
	 */
	public String getKnapprover();

	/**
	 * 归档时间取得
	 * 
	 * @return 归档时间
	 */
	public String getKnapprovetime();

	/**
	 * 分类取得
	 * 
	 * @return 分类
	 */
	public String getKnclass();

	/**
	 * 关键字取得
	 * 
	 * @return 关键字
	 */
	public String getKnkey();

	/**
	 * 来源取得
	 * 
	 * @return 来源
	 */
	public String getKnorigin();
	
	/**
	 * 来源取得
	 * 
	 * @return 来源
	 */
	public String getKnoriginname();

	/**
	 * 知识贡献人取得
	 * 
	 * @return 知识贡献人
	 */
	public String getKnproffer();

	/**
	 * 贡献时间取得
	 * 
	 * @return 贡献时间
	 */
	public String getKnproffertime();

	/**
	 * 标题取得
	 * 
	 * @return 标题
	 */
	public String getKntitle();

	/**
	 * 问题描述取得
	 * 
	 * @return 问题描述
	 */
	public String getKndes();

	/**
	 * 故障原因总结取得
	 * 
	 * @return 故障原因总结
	 */
	public String getKnfaultcause();

	/**
	 * 解决办法取得
	 * 
	 * @return 解决办法
	 */
	public String getKnsolveway();

	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getKnstatus();
	
	/**
	 *类别名称取得
	 * 
	 * @return 类别名称
	 */
	public String getKnclassname() ;
	
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
	 *驳回原因取得
	 * 
	 * @return 驳回原因
	 */
	public String getKnreject();
	
	/**
	 * 附件key取得
	 * @return 附件key
	 */
	public String getKnattkey();
	
	/**
	 *业务领域取得
	 * 
	 * @return 业务领域
	 */
	public String getKnarea();
	/**
	 *业务领域名取得
	 * 
	 * @return 业务领域名
	 */
	public String getKnareaname();
	/**
	 *技术领域取得
	 * 
	 * @return 技术领域
	 */
	public String getKntelarea();
	/**
	 *技术领域取得
	 * 
	 * @return 技术领域
	 */
	public String getKntelareaname();
	
	/**
	 * 知识附件List取得
	 * @return 知识附件List
	 */
	public List<Attachment> getAttachmentList();

	/**
	 * 知识附件List设定
	 * @return 知识附件List
	 */
	public void setAttachmentList(List<Attachment> attachmentList);
	
	/**
	 * 知识审批人
	 * @return 知识审批人
	 */
	public Integer getKnapproverole();
	
	
}
