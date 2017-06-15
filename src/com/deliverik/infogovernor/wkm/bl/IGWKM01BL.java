/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.wkm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_个人工作业务逻辑接口 
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public interface IGWKM01BL extends BaseBL {

	public IGWKM01DTO getProcessRecords(IGWKM01DTO dto) throws BLException;
	public IGWKM01DTO getProcessTemplate(IGWKM01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 删除流程记录
	 * </p>
	 */
	public IGWKM01DTO delProcessRecord(IGWKM01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 判断当前用户是否存在流程审批权限
	 * </p>
	 * 
	 * @param userid String
	 * @return boolean
	 * @throws BLException
	 * @update 
	 */
	public boolean isApproveRole(String userid) throws BLException ;

    /**
	 * 流程查询操作
	 * @param dto 
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchProcessRecordAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGWKM01DTO dto) throws BLException;
	
	
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 根据PDID获取启用的流程PDID
	 */
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 导出Excel
	 */
	public IGWKM01DTO getExcel(IGWKM01DTO dto) throws BLException;
	
}
