/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.framework.igflow.parameter.PrivateProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.StatusParticipantInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;

/**
 * 流程更新功能API
 */
public interface FlowSetBL extends BaseBL {
	
	/**
	 * 添加资产属性
	 * @param eiid 资产ID
	 * @param lst_EntityItemConfigValueInfo 资产属性信息
	 * @throws BLException
	 */
	public void createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	/**
	 * 添加资产
	 * 所属机构码不存在时抛异常
	 * 所属模型信息不存在时抛异常
	 * @param entityItem 资产信息
	 * @return 资产ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException;
	
	/**
	 * 状态参与者删除
	 * @param statusParticipantInfo 状态参与者信息
	 * @throws BLException
	 */
	public void deleteStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException;
	
	/**
	 * 以表格为单位删除公有表格式表单值
	 * 行号为空时删除该表格下所有值
	 * 流程信息不存在或表单信息不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程主键
	 * @param rownumber 行号(可为空)
	 * @throws BLException
	 */
	public void deletePublicTableFormValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber) throws BLException;
	
	/**
	 * 资产所属机构更新
	 * @param eiid 资产ID
	 * @param eiorgsyscoding 更新后的资产所属机构层次码
	 * @throws BLException
	 */
	public void setEntityItemValue(Integer eiid, String eiorgsyscoding) throws BLException;
	
	/**
	 * 资产属性值更新
	 * @param entityItemConfigValueInfo 资产属性信息
	 * @param upgrade 是否升版
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(EntityItemConfigValueInfo entityItemConfigValueInfo,
			boolean upgrade) throws BLException;
	

	/**
	 * 设置流程相关资产
	 * <BR>
	 * 流程信息不存在、表单信息不存在或者资产信息为空时抛异常
	 * @param prid 流程主键
	 * @param pidname 表单名称
	 * @param entitys 资产信息集合
	 * @throws BLException
	 */
	public void setProcessEntityItem(Integer prid, String pidname, List<ProcessInfoEntityInfo> entitys) throws BLException;
	
	/**
	 * 资产属性值更新
	 * @param lst_EntityItemConfigValueInfo 资产属性信息集合
	 * @param upgrade 是否升版
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo,
			boolean upgrade) throws BLException;
	
	/**
	 * 私有表单值更新
	 * @param privateProcessInfoValueInfo 私有表单信息
	 * @throws BLException
	 */
	public void setPrivateProcessInfoValue(PrivateProcessInfoValueInfo privateProcessInfoValueInfo) throws BLException;
	
	/**
	 * 流程日志添加
	 * @param logInfo 流程日志参数信息
	 * @param desc 日志功能描述
	 * @param type 日志类型
	 * @throws BLException
	 */
	public void setProcessLog(WorkFlowLogInfo logInfo, String desc, String type) throws BLException;

	/**
	 * 流程关系添加
	 * @param parprid 主流程ID
	 * @param cldprid 相关流程ID
	 * @throws BLException
	 */
	public void setProcessRelation(Integer parprid, Integer cldprid) throws BLException;

	/**
	 * 流程工单号更新
	 * 
	 * @param prid 流程ID
	 * @param serialnum 流程工单号
	 * @throws BLException
	 */
	public void setProcessSerialNum(Integer prid, String serialnum) throws BLException;

	/**
	 * 表格式表单公有值设定(表单层级名称中间以 "#" 隔开)
	 * <BR>
	 * 表单全路径不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程ID
	 * @param rownumber 行号
	 * @throws BLException
	 */
	public void setPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber,String value) throws BLException;

	/**
	 * 公有表单值更新
	 * @param publicProcessInfoValueInfo 公有表单信息
	 * @throws BLException
	 */
	public void setPublicProcessInfoValue(PublicProcessInfoValueInfo publicProcessInfoValueInfo) throws BLException;
	
	/**
	 * 参与角色和参与人添加
	 * @param statusParticipantInfo 状态参与者信息
	 * @throws BLException
	 */
	public void setStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException;
	
	/**
	 * 清空全部参与者处理完成时间
	 * @param prid 流程ID
	 * @param statuscode 状态标识
	 * @throws BLException
	 */
	public void setStatusParticipantAllRehandle(Integer prid, String statuscode) throws BLException;

	/**
	 * 清空指定参与者处理完成时间
	 * @param prid 流程ID
	 * @param statusname 状态名称
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException
	 */
	public void setStatusParticipantRehandle(Integer prid, String statusname, Integer roleid, String userid)
			throws BLException;
	
	/**
	 * 更新流程信息
	 * @param prid 流程主键
	 * @param valueMap 值：属性名-属性值
	 * @throws BLException
	 */
	public void updateProcessRecord(Integer prid,Map<String, Object> valueMap) throws BLException;
	
	/**
	 * 添加流程资产关系
	 * @param prid 流程主键
	 * @param pidname 表单名称
	 * @param eiid 资产ID
	 */
	public Integer setProcessEntityRelation(Integer prid,String pidname,Integer eiid,Integer eiversion,Object... dbFlag) throws BLException;
	
	/**
	 * 添加流程表格式表单关系
	 * @param sourcePrid
	 * @param sourcePivarname
	 * @param tagPrid     
	 * @param tagPivarname
	 * @param tagPdid
	 * @throws BLException
	 */
	public void setProcessSceneParticipant(Integer sourcePrid,String sourcePivarname,Integer tagPrid,String tagPivarname,String tagPdid)throws BLException;
	
}
