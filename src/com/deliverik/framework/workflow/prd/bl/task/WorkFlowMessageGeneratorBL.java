/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 提醒信息生成BL
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface WorkFlowMessageGeneratorBL extends BaseBL{
	
	/**
	 * 初始化方法
	 * @param psname 状态名称
	 */
	public void init(Integer prid,String psname) throws BLException;

	/**
	 * 标题信息生成
	 * @param prid 流程主键
	 * @return 标题信息
	 * @throws BLException
	 */
	public String titleGenerator() throws BLException;
	
	/**
	 * 邮件内容生成
	 * @param prid 流程主键
	 * @return 邮件内容生成
	 * @throws BLException
	 */
	public String contentGenerator() throws BLException;
	
	/**
	 * 短信内容生成
	 * @param prid 流程主键
	 * @return 短信内容
	 * @throws BLException
	 */
	public String smsGenerator() throws BLException;
}
