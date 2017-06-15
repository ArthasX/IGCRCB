/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;

/**
 * 角色组织架构关系信息BL
 */
public interface IGDRM10BL extends BaseBL {
	/**
	 * 角色组织架构关系初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initIGDRM1002Action(IGDRM10DTO dto) throws BLException;
	
	/**
	 * 角色组织架构关系修改查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO editIGDRM1002Action(IGDRM10DTO dto) throws BLException;
	
	/**
	 * 角色组织架构关系更新或插入方法
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchRole(IGDRM10DTO dto) throws BLException;

    /** 
     * @Title: deleteRoleRelation 
     * @param dto
     * @return    
     * IGDRM10DTO    
     * @throws 
     */
    public IGDRM10DTO deleteRoleRelation(IGDRM10DTO dto)throws BLException;
    /**
	 * 数据信息删除处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO realdeleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException ;
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
    /**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001Action(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据信息详细画面返回显示
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001BackAction(IGDRM10DTO dto) throws BLException ;
	/**
	 * 数据分类信息查询处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据分类新增处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO saveIGDRM1003Action(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1004Action(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO insertCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO updateCodeDetailDefAction(IGDRM10DTO dto) throws BLException;
	/**
	 * 查询应急组织架构下的四个层
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchCodeDetailDef(IGDRM10DTO dto) throws BLException;
	
	/**
     * 角色组织架构关系初始化查询
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGDRM10DTO searchRoleAndUser(IGDRM10DTO dto) throws BLException;
    /**
	 * 数据分类信息查询处理
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1007Action(IGDRM10DTO dto) throws BLException;

	/**
	 * 导出组织架构树
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO exportOrgTree(IGDRM10DTO dto) throws BLException;

	/**
	 * 初始化流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkFlowAction(IGDRM10DTO dto) throws BLException;

	/**
	 * 流程处理操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO doFlowAction(IGDRM10DTO dto) throws BLException;

	/**
	 * 发送短信
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendSMS(IGDRM10DTO dto) throws BLException;

	/**
	 * 推送通知
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendNotice(IGDRM10DTO dto) throws BLException;

	/**
	 * 初始化工作台
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkbenchAction(IGDRM10DTO dto) throws BLException;
	
	/**
	 * 查询工作台日志
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */

	public IGDRM10DTO searchLog(IGDRM10DTO dto) throws BLException;
	
	/**
	 * 附件上传
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO uploadAtt(IGDRM10DTO dto) throws BLException;

	/**
	 * 查询场景中的预计恢复时间
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchSenceTimes(IGDRM10DTO dto) throws BLException;

	/**
	 * 根据流程状态查询处置说明表单值
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchDesc(IGDRM10DTO dto) throws BLException;

	/**
	 * 更新状态表单(处置说明)
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO saveDesc(IGDRM10DTO dto) throws BLException;
}