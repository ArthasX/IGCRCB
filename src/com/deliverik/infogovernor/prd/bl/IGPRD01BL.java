/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;

/**
 * 概述: 流程定义业务逻辑接口
 * 功能描述: 流程定义业务逻辑接口 
 * 创建记录: 2010/11/07		liupeng@deliverik.com
 * 修改记录: 2013/02/25		130225	流程机构相关修改
 */
public interface IGPRD01BL extends BaseBL {
	
	//-----------------------------------------------------------流程定义----------------------------------------------------------------------
	/**
	 * 判断当前是否存在未关闭的流程在使用模板
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO isProcessDefinitionInUse(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义测试处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO testProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchLastProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程历史定义信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchHistoryProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息登记处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息变更处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息变更处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息停用/启用处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	
	/**
	 * 流程定义信息变更初始化处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0102Action(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------分派角色----------------------------------------------------------------------
	/**
	 * 获取分派角色
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchDispatchProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 设定分派角色
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO assignProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 清除分派角色
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO clearProcessParticipant(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------前处理----------------------------------------------------------------------
	/**
	 * 流程事件查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchPreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 按钮事件定义查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 按钮事件定义查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefByPK(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件添加处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertPreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件添加处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件修改处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updatePreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件修改处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deletePreProcessEventDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程事件删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------规则定义----------------------------------------------------------------------
	
	/**
	 * 规则定义信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 规则定义信息新增处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 规则定义信息删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 并行节点规则定义信息新增处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 并行节点规则定义信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 并行节点规则定义信息删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------表单信息----------------------------------------------------------------------
	
	/**
	 * 表单信息信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单信息信息登记处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO insertProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单信息信息删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO orderProcessInfoDefAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO deleteProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException ;
	
	public IGPRD01DTO searchProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	
	//-----------------------------------------------------------流程状态----------------------------------------------------------------------
	/**
	 * 流程状态信息查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态信息删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态信息登记处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态信息变更初始化处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0105Action(IGPRD01DTO dto) throws BLException;

	/**
	 * 流程状态信息变更处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 获取流程状态参与者
	 * </p>
	 */
	
	public IGPRD01DTO getProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
     * 状态参与者支持机构选择
     * @param dto
     * @return
     * @throws BLException
     */
	public IGPRD01DTO getProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加流程状态参与者 
	 * </p>
	 */
	
	public IGPRD01DTO addProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除流程状态参与者
	 * </p>
	 */
	
	public IGPRD01DTO removeProcessParticipants(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程状态参与者权限页面初始化
	 * </p>
	 */
	
	public IGPRD01DTO processInfoParticipantDefInitAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程状态参与者授权处理
	 * </p>
	 */
	
	public IGPRD01DTO grantPermissionAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程状态缺省参与者权限页面初始化
	 * </p>
	 */
	
	public IGPRD01DTO participantDefaultVariableInitAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程状态缺省参与者授权处理
	 * </p>
	 */
	
	public IGPRD01DTO grantDefaultPermissionAction(IGPRD01DTO dto) throws BLException;
	
	//-----------------------------------------------------------动态标签----------------------------------------------------------------------
	/**
	 * <p>
	 * Description: 根据流程定义id、流程状态取得该流程状态的名称
	 * </p>
	 */
	
	public String getPsNameByPdidAndPsdidAction(String pdid,String psdcode);
	
	//-----------------------------------------------------------流程图----------------------------------------------------------------------
	/**
	 * <p>
	 * Description: 根据流程状态及规则构建流程图
	 * </p>
	 */
	
	public IGPRD01DTO initVmlAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 保存流程图
	 * </p>
	 */
	
	public IGPRD01DTO savePdXmlAction(IGPRD01DTO dto) throws BLException;
	
	public IGPRD01DTO insertProcessInfoDefFromProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: 已选角色类型
	 * </p>
	 */
	public IGPRD01DTO getProcessRoleTypeDefAction(IGPRD01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 增加角色类型
	 * </p>
	 */
	public IGPRD01DTO addProcessRoleTypes(IGPRD01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 删除角色类型
	 * </p>
	 */
	public IGPRD01DTO removeProcessRoleTypes(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 增加共通变量初始化查询页（IGPRD0119）
	 */
	public IGPRD01DTO searchProcessInfoDefGeneralActionFor0119(IGPRD01DTO dto) throws BLException;
	
	//文本域绑定附件
	public  List<Attachment> searchInofAtt(String piattkey);
	
	/**
	 * <p>
	 * Description: 流程级联管理查询
	 * </p>
	 */
	public IGPRD01DTO searchProcessLinkageDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程级联插入
	 * </p>
	 */
	public IGPRD01DTO insertProcessLinkageDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程级联删除
	 * </p>
	 */
	public void deleteProcessLinkageDef(String plid) throws BLException;
	
	/**
	 * <p>
	 * Description: 流程级联更改
	 * </p>
	 */
	public IG286Info editProcessLinkageDef(String plid) throws BLException;
	
	/**
	 * 流程定义升版处理
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO upgradeProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义复制处理
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO copyProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义导入处理
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO importProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义导出处理
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO exportProcessDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可分派角色查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusRoleDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可分派角色新增
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusRoleDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可分派角色删除
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusRoleDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程表单信息修改
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0111Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程通知策略查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程通知策略设定处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程通知基本信息设定处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO setIGPRD0158Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程通知策略查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0159Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程系统定义按钮集合
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessButtonDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 外部事件定义查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefByPK(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 外部事件修改处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 外部事件添加
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessExteralDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 外部事件删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 外部事件查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 通用表单信息变更初始化处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0118Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程定义信息变更处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态查询
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可调整参与者查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可调整参与者设定处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单初始化配置查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单初始化配置新增处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单初始化配置删除处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单初始化配置修改初始化处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单初始化配置修改处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIG373InfoAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 表单权限查询初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleConfigAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 删除表单权限角色
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleConfig(IGPRD01DTO dto) throws BLException;

	/**
	 * 添加表单权限角色
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleConfig(IGPRD01DTO dto) throws BLException;

	/**
	 * 表单查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleFormRelationAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 删除表单权限
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleFormRelation(IGPRD01DTO dto) throws BLException;

	/**
	 * 添加表单权限
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleFormRelation(IGPRD01DTO dto)throws BLException;
	
	/**
     * 相关发起的流程定义信息查询处理
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * 设置相关发起的自定义流程类型信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRD01DTO grantRelevantProcessAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * 缺省权限的相关发起的流程定义信息查询处理
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchDefaultRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * 设置缺省权限的相关发起的自定义流程类型信息
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRD01DTO grantDefaultRelevantProcessAction(IGPRD01DTO dto) throws BLException;
    
    /**
     * 查询可选的一级菜单列表
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchActionListAction(IGPRD01DTO dto) throws BLException;
    

	/**
	 * 自定义流程页面设置查询
	 *
	 *崔学志
	 *2012-11-13上午9:09:27
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessJspInfoAction(IGPRD01DTO dto)throws BLException;

	/**
	 * 自定义流程页面设置登记
	 *
	 *崔学志
	 *2012-11-13下午1:14:19
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO insertProcessJspAction(IGPRD01DTO dto)throws BLException;
	/***
	 * 自定义流程页面设置修改
	 *
	 *崔学志
	 *2012-11-13下午3:39:08
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO editProcessJspAction(IGPRD01DTO dto)throws BLException;
	/**
	 * 自定义流程页面设置删除
	 *
	 *崔学志
	 *2012-11-13下午4:48:45
	 * @param pjdid
	 * @throws BLException
	 */
	public IGPRD01DTO deleteProcessJspAction(IGPRD01DTO dto)throws BLException;

	/**
	 * 流程状态信息变更处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefZAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 查询条件设定页面初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessInfoQueryInfo(IGPRD01DTO dto) throws BLException;

	/**
	 * 查询条件删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessInfoQuery(IGPRD01DTO dto) throws BLException;

	/**
	 * 查询条件新增操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessInfoQuery(IGPRD01DTO dto) throws BLException;
	
	//====>130225Begin
	/**
	 * 查询参与者类型
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchCodedetailFromPsdassign(IGPRD01DTO dto) throws BLException ;
	
	/**
	 * 流程状态可分派机构查询处理
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusOrgDefAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可分派机构删除
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusOrgDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 流程状态可分派机构新增
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusOrgDef(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 添加机构参与人
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * 删除机构参与人
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * 流程机构范围选择
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessOrgDefAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 移除机构范围
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessOrg(IGPRD01DTO dto) throws BLException;

	/**
	 * 添加机构范围
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessOrg(IGPRD01DTO dto) throws BLException;
	//====>130225End

	/**
	 * 表格类表单预览
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchColumnInfoAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 流程参与者变更操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessParticipants(IGPRD01DTO dto) throws BLException;

	/**
	 * 查询返回URL
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchBackURLAction(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 查询流程策略通知类角色
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchRoleByIGBP06Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 查询流程策略处理Bl定义
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessBLByIGBP06Action(IGPRD01DTO dto) throws BLException;
	
	/**
	 * 取得流程模板信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessTemplateAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 查询流程定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessDefinitonsAction(IGPRD01DTO dto) throws BLException;
/**
     * 
     * @Title: initStatusDefault
     * @Description: 状态级私有表单默认值初始化
     * @param dto
     * @return dto
     * @throws BLException
     * @throws
     */
	public IGPRD01DTO initStatusDefault(IGPRD01DTO dto)throws BLException;

	/**
	 * 更改流程查询设定操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessQueryAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 流程查询显示列定义初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initProcessQueryShowColumnAction(IGPRD01DTO dto) throws BLException;

	/**
	 * 流程查询定义列宽度调整
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO editProcessQueryShowColumnWidthAction(IGPRD01DTO dto) throws BLException;
	
	
	
	/***********************************流程设计器***************************************************************/
	
	/**
	 * 保存流程设计器的编辑结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD01DTO updFlowXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * 加载流程设计器初始数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initFlowXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * 保存流程图xml
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD01DTO savePdXML(IGPRD01DTO dto)throws BLException;
	
	/**
	 * 查询流程参与人xml 流程设计器用
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchUserRoleInfoForPDeg(IGPRD01DTO dto) throws BLException;
	
	/**
     * 缺省权限的相关发起的流程定义信息查询处理
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public String searchProcessDefinitionList(IGPRD01DTO dto) throws BLException;
}

