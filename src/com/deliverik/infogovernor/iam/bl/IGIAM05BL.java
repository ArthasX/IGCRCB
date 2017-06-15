/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.iam.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.dto.IGIAM05DTO;
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

public interface IGIAM05BL extends BaseBL {

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
	public boolean isApproveRole(String userid) throws BLException;
	
	/**
	 * 查询登录用户是否是工程师
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isEngineerFlag(IGWKM01DTO dto);
	
	/**
	 * 查询登录用户是否是服务台
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isServiceDeskFlag(IGWKM01DTO dto);
	
	/**
	 * 查询客户下拉列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<LabelValueBean> getLstClient(IGWKM01DTO dto);
	
	/**
	 * 查询故障流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchIGWKM0106Action(IGWKM01DTO dto);
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 获取带有当前处理人的本月工作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO getCurrentManagerAction(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGWKM01DTO dto) throws BLException;
	
	/**
	 * 根据PDID获取当前启用的流程PDID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto)throws BLException;

	   /**
     * <p>
     * Description: 获取处理显示状态（处理按钮权限）
     * </p>
     * 
     * @param dto IGRAM01DTO
     * @return IGRAM01DTO
     * @throws BLException
     * @author
     * @update
     */
    public IGIAM01DTO searchProcessDef(IGIAM01DTO dto)throws BLException;
    /**
     * TODO
     * IGIAM05DTO
     * 20132013-10-31 
     * @param dto
     * @return
     */
    public IGIAM05DTO getProcessRecords(IGIAM05DTO dto)throws BLException;
    
    
    public IGIAM05DTO getProcessTemplate(IGIAM05DTO dto) throws BLException;
}
