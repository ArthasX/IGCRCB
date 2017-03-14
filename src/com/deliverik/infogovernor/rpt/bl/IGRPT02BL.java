/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;

/**
 * 概述: 事件和变更服务效率业务逻辑接口
 * 功能描述: 事件和变更服务效率业务逻辑接口
 * 创建记录: 2011/11/23
 * 修改记录: 
 */
public interface IGRPT02BL extends BaseBL {

	/**
	 * 执行添加事件服务效率处理
	 * @throws BLException
	 */
	public void saveIncidentEfficiency() throws BLException;

	/**
	 * 执行添加变更服务效率处理
	 * @throws BLException
	 */
	public void saveAlterationEfficiency() throws BLException;
	/**
	 * 自动报表查询
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportTemplateByCond(IGRPT02DTO dto)throws BLException;
	/**
	 * 自动报表删除
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 自动报表新增
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 自动报表更新
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportTemplateInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 添加附件调用
	 * @param dto
	 * @return Map<String,String> 返回文件信息
	 */
	public Map<String, String> insertFileAction(IGRPT02DTO dto)throws BLException;
	/**
	 * 初始化新增画面
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initInsertAction(IGRPT02DTO dto)throws BLException;
	/**
	 * 自动报表模板更新画面显示方法
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportTemplateAction(IGRPT02DTO dto)
			throws BLException;

	/**
	 * 初始化查询附加报表
	 * @param dto
	 * @return IGRPT01DTO
	 * @throws BLException
	 */
	public IGRPT02DTO searchInitAnnexationAction(IGRPT02DTO dto)throws BLException;
	
	/**
	 * 删除附加报表
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportAnnexationInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 报表管理分页查询
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportManageByCond(IGRPT02DTO dto)throws BLException;
	/**
	 * 报表管理删除
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 报表管理新增
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 新增报告初始化
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInitAction(IGRPT02DTO dto)throws BLException;
	/**
	 * 修改映射关系
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateSOC0206(IGRPT02DTO dto)throws BLException; 
	/**
	 * 修改报告初始化
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 报表管理修改
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportManageInstance(IGRPT02DTO dto)throws BLException;
	/**
	 * 自定义报告快速链接
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchSOC0204Action(IGRPT02DTO dto)throws BLException;
}
