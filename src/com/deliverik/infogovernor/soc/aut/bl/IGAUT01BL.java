/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT01DTO;

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

public interface IGAUT01BL extends BaseBL {

	public IGAUT01DTO getProcessRecords(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getProcessTemplate(IGAUT01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 删除流程记录
	 * </p>
	 */
	public IGAUT01DTO delProcessRecord(IGAUT01DTO dto) throws BLException;
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
	public IGAUT01DTO searchProcessRecordAction(IGAUT01DTO dto) throws BLException;
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGAUT01DTO
	 * @throws BLException
	 */
	public IGAUT01DTO searchForwardJsp(IGAUT01DTO dto) throws BLException;
	
	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGAUT01DTO dto) throws BLException;
	
	
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0101Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0102Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0103Action(IGAUT01DTO dto) throws BLException;
	public IGAUT01DTO getPivarQueryInfo0104Action(IGAUT01DTO dto) throws BLException;
	
	/**
	 * 根据PDID获取启用的流程PDID
	 */
	public IGAUT01DTO searchPdid7BitAction(IGAUT01DTO dto) throws BLException;
}
