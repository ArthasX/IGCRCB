/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * 流程定义业务逻辑
 * </p>
 * 
 */

public interface WorkFlowDefinitionBL extends BaseBL {
	

	/**
	 * <p>
	 * 流程模板信息对象实例取得
	 * <p>
	 * 
	 * @return 流程模板信息对象实例
	 */
	public IG259TB getProcessTemplateTBInstance();
	
	/**
	 * <p>
	 * 流程类型信息对象实例取得
	 * <p>
	 * 
	 * @return 流程类型信息对象实例
	 */
	public IG380TB getProcessDefinitionTBInstance();
	
	/**
	 * <p>
	 * 流程变量定义信息对象实例取得
	 * <p>
	 * 
	 * @return 流程变量定义信息对象实例
	 */
	public IG007TB getIG007TBInstance();

	/**
	 * 查询指定类型的使用中的流程模板信息
	 * @param prtype 流程模板类型
	 * @return 流程模板信息
	 */
	public IG259Info searchProcessTemplateByPrType(String prtype);
	
	/**
	 * 根据检索条件取得流程模板信息列表
	 * @param cond 流程模板信息检索条件
	 * @return 流程模板信息列表
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond);
	
	/**
	 * 根据检索条件取得流程模板信息列表（分页查询用）
	 * @param cond 流程模板信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程模板信息列表
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond, int start, int count);
	
	/**
	 * 根据流程模板ID查询流程模板信息
	 * @param ptid 流程模板ID
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info searchProcessTemplateByKey(Integer ptid) throws BLException;
	
	/**
	 * 新增流程模板信息处理
	 * 
	 * @param processTemplate 流程模板信息
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info registProcessTemplate(IG259Info processTemplate) throws BLException;
	
	
	/**
	 * 删除流程模板信息处理
	 * 
	 * @param ptid 流程模版ID
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessTemplateByKey(Integer ptid) throws BLException;
	
	/**
	 * 变更流程模板信息处理
	 * 
	 * @param processTemplate 流程模板信息
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info updateProcessTemplate(IG259Info processTemplate) throws BLException;
	
	
	/**
	 * 根据流程模版ID查询流程定义信息列表
	 * @param processTemplateId 流程模版ID
	 * @return  流程定义信息列表
	 */
	public List<IG380Info> searchProcessDefinitionsByPtid(Integer processTemplateId);
	
	/**
	 * 根据流程定义ID查询流程定义信息
	 * @param pdid 流程定义ID
	 * @return 流程定义信息
	 * @throws BLException
	 */
	public IG380Info searchProcessDefinitionByKey(String pdid) throws BLException;
	
	/**
	 * 根据检索条件取得流程定义信息条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息条数
	 */
	public int getProcessDefinitionSearchCount(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond);

	/**
	 * 根据检索条件取得流程定义信息列表（分页查询用）
	 * 
	 * @param cond 流程定义信息检索条件
	 * @param start 检索起始条数
	 * @param count 检索个数
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond,int start,int count);
	
	/**
	 * 新增流程定义信息处理
	 * 
	 * @param processDefinition 新增流程定义信息
	 * @return 流程定义信息
	 * @throws BLException
	 */
	public IG380Info registProcessDefinition(IG380Info processDefinition) throws BLException;

	/**
	 * 删除流程定义信息处理
	 * 
	 * @param pdid 流程定义信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessDefinitionByKey(String pdid) throws BLException;

	/**
	 * 更新流程定义信息处理
	 * 
	 * @param processDefinition 流程定义信息
	 * @return 流程定义信息
	 * @throws BLException
	 */
	public IG380Info updateProcessDefinition(IG380Info processDefinition) throws BLException;
	
	/**
	 * 功能：根据检索条件取得历史流程定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 历史流程定义信息结果条数
	 */
	public int getProcessDefinitionSearchHistoryCount(IG380SearchCond cond);
	
	/**
	 * 功能：根据检索条件取得历史流程定义信息列表（分页查询使用）
	 * 
	 * @param cond 流程定义检索条件
	 * @param start 检索起始条数
	 * @param count 检索个数
	 * @return 历史流程定义信息列表
	 */
	public List<IG380Info> searchHistoryProcessDefinition(IG380SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * 流程定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getProcessDefinitionPK(String firstsite,String pdsequence);
	
	/**
	 * 根据检索条件取得流程定义最新信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getProcessDefinitionSearchLastCount(IG380SearchCond cond);
	
	/**
	 * 根据检索条件取得流程定义最新信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchLastProcessDefinition(IG380SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得相关发起的自定义流程类型的信息
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond);
	
	/**
     * 根据检索条件取得缺省权限的相关发起的自定义流程类型的信息
     * 
     * @param cond 流程定义检索条件
     * @return 流程定义信息列表
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond);
    
	/**
     * 缺省状态参与者关联流程类型定义主键值取得
     * @param 流程状态ID
     * @return 缺省状态参与者关联流程类型定义主键值
     */
    public String getDefaultParticipantRelevantDefPK(String psdid) throws BLException;
    
    /**
     * 注册缺省状态参与者关联流程类型定义
     * @param entity 缺省状态参与者关联流程类型定义实体
     * @return 缺省状态参与者关联流程类型定义实体
     * @throws BLException
     */
    public IG931Info registDefaultParticipantRelevantDefInfo(IG931Info entity) throws BLException;
    
    /**
     * 根据主键删除缺省状态参与者关联流程类型定义
     * @param pk 主键
     * @throws BLException
     */
    public void deleteDefaultParticipantRelevantDefInfoByKey(String pk) throws BLException;
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond);
    
	/**
	 * 流程定义不存在检查
	 * 
	 * @param ptid 流程模板ID
	 * @param pdname 流程定义名称
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistProcessDefinition(Integer ptid, String pdname) throws BLException;
	
	/**
	 * 流程定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public String copyProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * 根据流程定义ID查询流程变量定义信息
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义信息列表
	 */
	public List<IG007Info> searchProcessInfoDefsByPdid(String processDefinitionId);

	/**
	 * 根据流程定义ID查询不包括缺省变量的流程变量定义信息（平台保留）
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义信息列表
	 */
	public List<IG007Info> searchProcessInfoDefsNoDefault(String processDefinitionId);

	/**
	 * 流程变量定义信息条件检索结果条数取得
	 * 
	 * @param cond 流程变量定义信息检索条件
	 * @return 流程变量定义信息条数
	 */
	public int getProcessInfoDefSearchCount(IG007SearchCond cond);

	/**
	 * 根据检索条件取得流程变量定义信息列表
	 * 
	 * @param cond 流程变量信息定义检索条件
	 * @return 流程变量定义信息列表
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond);
	
	/**
	 * 根据检索条件取得流程变量定义信息列表(分页查询用)
	 * 
	 * @param cond 流程变量定义信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程变量定义信息列表
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond, int start, int count);

	/**
	 * 根据流程变量定义ID查询流程变量定义信息
	 * 
	 * @param pidid 流程变量定义ID
	 * @return 流程变量定义信息
	 * @throws BLException 
	 */
	public IG007Info searchProcessInfoDefByKey(String pidid) throws BLException;
	
	/**
	 * 新增流程变量定义信息处理
	 * 
	 * @param processInfoDef 流程变量定义信息
	 * @return 流程变量定义信息
	 * @throws BLException
	 */
	public IG007Info registProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * 变更流程变量定义信息处理
	 * 
	 * @param processInfoDef 流程变量定义信息
	 * @return 流程变量定义信息
	 * @throws BLException
	 */
	public IG007Info updateProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * 运行状态检索表单定义
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond);
	
	/**
	 * 删除流程变量定义信息处理
	 * 
	 * @param pidid 流程变量定义信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDefByKey(String pidid) throws BLException;
	
	/**
	 * 删除流程变量定义信息处理
	 * 
	 * @param processInfoDef 流程变量定义信息
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * 表单定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PIDID主键值
	 */
	public String getProcessInfoDefPK(String pdid);
	
	/**
	 * 功能：获取流程变量缺省审批人
	 * @param pdid 流程定义ID
	 * @return  Map<String,List<IG337Info>> 流程变量缺省审批人
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * 功能：获取流程变量缺省审批分派人(ppcomment获取之后不用要清空)
	 * @param pdid 流程定义ID
	 * @return  List<IG337Info> 流程变量缺省审批分派人
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid);
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG105Info> searchProcessStrategyDef(IG105SearchCond cond);
	
	/**
	 * 查询角色配置
	 * @param cond 查询条件
	 * @return 角色配置信息集合
	 * @throws BLException
	 */
	public List<IG001Info> searchOARoleConfig(IG001SearchCond cond) throws BLException;
	
	/**
	 * 删除角色配置
	 * @param entity 角色配置信息
	 * @throws BLException
	 */
	public void deleteOARoleConfig(IG001Info entity) throws BLException;
	
	/**
	 * 删除角色配置
	 * @param entity 角色配置信息
	 * @throws BLException
	 */
	public void deleteOARoleConfig(List<IG001Info> entitys) throws BLException;
	
	/**
	 * 注册角色配置
	 * @param entity 角色配置信息
	 * @return 角色配置信息
	 * @throws BLException
	 */
	public IG001Info registOARoleConfig(IG001Info entity) throws BLException;
	
	/**
	 * 根据类型查询配置角色主键
	 * @param type 类型
	 * @return
	 * @throws BLException
	 */
	public List<Integer> searchOARoleidByType(String type) throws BLException;
	
	/**
	 * 角色授权表单检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG701Info> searchRoleForm(IG701SearchCond cond);
	
	/**
	 * 事件处理检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG413Info> searchWorkFlowEventHandler(IG413SearchCond cond);
	
	/**
	 * 事件处理主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getWorkFlowEventHandlerPK(String psdid);
	
	/**
	 * 注册事件处理
	 * @param entity 事件处理实体
	 * @return 事件处理实体
	 * @throws BLException
	 */
	public IG413Info registWorkFlowEventHandler(IG413Info entity) throws BLException;
	
	/**
	 * 更新事件处理
	 * @param entity 事件处理实体
	 * @return 事件处理实体
	 * @throws BLException
	 */
	public IG413Info updateWorkFlowEventHandler(IG413Info entity) throws BLException;
	
	/**
	 * 根据主键删除事件处理
	 * @param key 事件处理主键
	 * @throws BLException
	 */
	public void deleteWorkFlowEventHandlerByKey(String key) throws BLException;
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getProcessStatusDefSearchCount(IG333SearchCond cond) throws BLException;
	
	/**
	 * 状态信息检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG333Info> searchProcessStatusDef(IG333SearchCond cond);
	
	/**
	 * 可被分派节点检索
	 * @param psdid 分派节点定义id
	 * @param pbdid 操作按钮
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid,String pbdid) throws BLException;
	
	/**
	 * 主键检索状态定义
	 * @param psdid 主键
	 * @return 状态定义信息
	 * @throws BLException
	 */
	public IG333Info searchProcessStatusDefByKey(String psdid) throws BLException;
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	public List<IG333Info> searchAdjustStatus(String psdid);
	
	/**
	 * 功能：根据状态code获取指定流程类型的状态ID
	 * @param pdid 流程定义ID
	 * @param psdcode 流程状态标识
	 * @return 流程状态ID
	 * @throws BLException 
	 */
	public String searchProcessStatusKey(String pdid,String psdcode) throws BLException;
	
	/**
	 * 新增流程状态定义
	 * @param entity 流程状态定义实体
	 * @return 流程状态定义实体
	 * @throws BLException
	 */
	public IG333Info registProcessStatus(IG333Info entity) throws BLException;
	
	/**
	 * 流程状态定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return 流程状态定义主键值
	 */
	public String getProcessStatusDefPK(String pdid_one);
	
	/**
	 * 根据主键删除状态定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessStatusDefByPK(String pk) throws BLException;
	
	/**
	 * 更新流程状态定义
	 * @param entity 流程状态定义实体
	 * @return 流程状态定义实体
	 * @throws BLException
	 */
	public IG333Info updateProcessStatus(IG333Info entity) throws BLException;
	
	/**
	 * 功能：获取指定用户具有的发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid,String pdid);
	
	/**
	 * 参与者可视按钮查询
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 可视按钮列表
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid);
	
	/**
	 * 参与人定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG222Info> searchParticipantDef(IG222SearchCond cond);
	
	/**
	 * 根据主键查询参与人定义信息
	 * @param pk 主键
	 * @return 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info searchParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * 参与人定义主键值取得
	 * 
	 * @param 流程状态ID
	 * @return 参与人定义主键值
	 */
	public String getParticipantDefPK(String pdid_one) throws BLException;
	
	/**
	 * 新增参与人定义信息
	 * @param entity 参与人定义实体
	 * @return 参与人定义实体
	 * @throws BLException
	 */
	public IG222Info registParticipantDef(IG222Info entity) throws BLException;
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getParticipantSearchCount(IG222SearchCond cond) throws BLException;
	
	/**
	 * 删除参与人定义信息
	 * @param entity 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info deleteParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * 更新参与人定义信息
	 * @param entity 参与人定义信息
	 * @return 参与人定义信息
	 * @throws BLException
	 */
	public IG222Info updateParticipantDef(IG222Info entity) throws BLException;
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getParticipantDefSearchCount(IG222SearchCond cond) throws BLException;
	
	/**
	 * 同角色所有人提交跃迁按钮查询（普通权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid);
	
	/**
	 * 同角色所有人提交跃迁按钮查询（缺省权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid);
	
	/**
	 * 表单初始化事件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG373Info> searchInitFormEventHandler(IG373SearchCond cond);
	
	/**
	 * 表单初始化事件主键值取得
	 * @param 流程状态ID
	 * @return 表单初始化事件主键值
	 */
	public String getInitFormEventHandlerPK(String psdid) throws BLException;
	
	/**
	 * 注册表单初始化事件
	 * @param entity 表单初始化事件实体
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info registInitFormEventHandler(IG373Info entity) throws BLException;
	
	/**
	 * 更新表单初始化事件
	 * @param entity 表单初始化事件实体
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info updateInitFormEventHandler(IG373Info entity) throws BLException;
	
	/**
	 * 主键检索表单初始化事件
	 * @param pk 主键
	 * @return 表单初始化事件实体
	 * @throws BLException
	 */
	public IG373Info searchInitFormEventHandlerByKey(String pk) throws BLException;
	
	/**
	 * 根据主键删除表单初始化事件
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteInitFormEventHandlerByKey(String pk) throws BLException;
	
	/**
	 * 注册角色授权表单
	 * @param entity 角色授权表单实体
	 * @return 角色授权表单实体
	 * @throws BLException
	 */
	public IG701Info registRoleForm(IG701Info entity) throws BLException;
	
	/**
	 * 根据主键删除角色授权表单
	 * @param pk
	 * @throws BLException
	 */
	public void deleteRoleForm(IG701PK pk) throws BLException;
	
	/**
	 * 流程标题定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG243Info> searchProcessTitleDef(IG243SearchCond cond);
	
	/**
	 * 流程标题定义主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PTDID主键值
	 */
	public String getProcessTitleDefPK(String pdid_one);
	
	/**
	 * 新增流程标题定义
	 * @param entity 流程标题定义实体
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info registProcessTitleDef(IG243Info entity) throws BLException;
	
	/**
	 * 主键查询流程标题定义
	 * @param pk 主键
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info searchProcessTitleDefByPK(String pk) throws BLException;
	
	/**
	 * 更新流程标题定义
	 * @param entity 流程标题定义实体
	 * @return 流程标题定义实体
	 * @throws BLException
	 */
	public IG243Info updateProcessTitleDef(IG243Info entity) throws BLException;
	
	/**
	 * 根据状态主键查询可被分派参与者(角色)
	 * @param psdid 状态主键
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG298Info> searchProcessStatusRoleDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * 可被分派参与者(角色)实例存在检测
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 实例
	 * @throws BLException
	 */
	public IG298Info checkProcessStatusRoleDefInfo(String psdid, Integer roleid) throws BLException;
	
	/**
	 * 可被分派参与者(角色)主键值取得
	 * @param psdid 流程状态ID
	 * @return 可被分派参与者(角色)主键值
	 */
	public String getProcessStatusRoleDefInfoPK(String psdid) throws BLException;
	
	/**
	 * 注册可被分派参与者(角色)
	 * @param entity 可被分派参与者(角色)实体
	 * @return 可被分派参与者(角色)实体
	 * @throws BLException
	 */
	public IG298Info registProcessStatusRoleDefInfo(IG298Info entity) throws BLException;
	
	/**
	 * 删除可被分派参与者(角色)
	 * @param entity 可被分派参与者(角色)实体
	 * @throws BLException
	 */
	public void deleteProcessStatusRoleDefInfoByKey(String pk) throws BLException;
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid);
	
	/**
	 * 根据状态主键查询可被分派参与者(机构)
	 * @param psdid 状态主键
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG299Info> searchProcessStatusOrgDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * 可被分派的机构检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的机构列表
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid);
	
	/**
	 * 可被分派的机构主键值取得
	 * @param 流程状态ID
	 * @return 可被分派的机构主键值
	 */
	public String getProcessStatusOrgDefInfoPK(String psdid) throws BLException;
	
	/**
	 * 注册可被分派的机构
	 * @param entity 可被分派的机构实体
	 * @return 可被分派的机构实体
	 * @throws BLException
	 */
	public IG299Info registProcessStatusOrgDefInfo(IG299Info entity) throws BLException;
	
	/**
	 * 根据主键删除可被分派的机构
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessStatusOrgDefInfoByKey(String pk) throws BLException;
	
	/**
	 * 角色范围检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG213Info> searchProcessRoleTypeDef(IG213SearchCond cond);
	
	/**
	 * 角色范围主键值取得
	 * @param 流程定义ID
	 * @return 角色范围主键值
	 */
	public String getProcessRoleTypeDefPK(String pdid_one) throws BLException;
	
	/**
	 * 注册角色范围信息
	 * @param entity 角色范围信息实体
	 * @return 角色范围信息实体
	 * @throws BLException
	 */
	public IG213Info registProcessRoleTypeDef(IG213Info entity) throws BLException;
	
	/**
	 * 根据主键删除角色范围信息
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessRoleTypeDefByKey(String pk) throws BLException;
	
	/**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond);
    
	/**
	 * 相关发起流程状态为启用状态的状态参与者相关发起信息取得
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond);
	
	/**
     * 状态参与者关联流程类型定义主键值取得
     * @param 流程状态ID
     * @return 状态参与者关联流程类型定义主键值
     */
	public String getParticipantRelevantDefPK(String psdid) throws BLException;
	
	/**
	 * 注册状态参与者关联流程类型定义
	 * @param entity 状态参与者关联流程类型定义实体
	 * @return 状态参与者关联流程类型定义实体
	 * @throws BLException
	 */
	public IG911Info registParticipantRelevantDefInfo(IG911Info entity) throws BLException;
	
	/**
	 * 根据主键删除状态参与者关联流程类型定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteParticipantRelevantDefInfoByKey(String pk) throws BLException;
	
	/**
	 * 相关发起可发起流程的流程定义信息取得（根据IG911关联取得IG380的信息）
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG380Info> searchIg380ByIg911Cond(IG911SearchCond cond);
	
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond);
    
	/**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG931Info> searchIg931RelevantPdid(IG931SearchCond cond);
    
    /**
     * 根据流程定义主键检索机构范围
     * @param pdid 流程定义主键
     * @return 检索结果
     */
    public List<IG123Info> searchProcessOrgScopeByPdid(String pdid);
    
	/**
	 * 机构范围主键值取得
	 * 
	 * @param 流程定义ID
	 * @return 机构范围主键值
	 */
    public String getProcessOrgScopePK(String pdid_one) throws BLException;
    
    /**
     * 注册机构范围
     * @param entity 机构范围实体
     * @return 机构范围实体
     * @throws BLException
     */
    public IG123Info registProcessOrgScope(IG123Info entity) throws BLException;
    
    /**
     * 删除机构范围
     * @param entity 机构范围实体
     * @throws BLException
     */
    public void deleteProcessOrgScope(List<IG123Info> entitys) throws BLException;
    
    /**
     * 流程状态按钮定义检索
     * @param cond 检索条件
     * @return 流程状态按钮定义信息集合
     * @throws BLException
     */
    public List<IG156Info> searchProcessStatusButtonDef(IG156SearchCond cond) throws BLException;
    
    /**
     * 主键检索流程状态按钮定义
     * @param pk 主键
     * @return 流程状态按钮定义信息
     * @throws BLException
     */
    public IG156Info searchProcessStatusButtonDefByKey(String pk) throws BLException;
    
	/**
	 * 状态按钮定义主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getProcessStatusButtonDefPK(String psdid);
	
	/**
	 * 注册状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @return 状态按钮定义实体
	 * @throws BLException
	 */
	public IG156Info registProcessStatusButtonDef(IG156Info entity) throws BLException;
	
	/**
	 * 更新状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @return 状态按钮定义实体
	 * @throws BLException
	 */
	public IG156Info updateProcessStatusButtonDef(IG156Info entity) throws BLException;
	
	/**
	 * 根据主键删除状态按钮定义
	 * @param entity 状态按钮定义实体
	 * @throws BLException
	 */
	public void deleteProcessStatusButtonDefByPK(String pk) throws BLException;
	
	/**
	 * 表单联动定义信息检索
	 * @param cond 检索条件 
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG286Info> searchProcessLinkageDef(IG286SearchCond cond) throws BLException;
	
	/**
	 * 表单联动定义信息主键值取得
	 * @param 流程定义ID
	 * @return 表单联动定义信息主键值
	 */
	public String getProcessLinkageDefPK(String pdid_one) throws BLException;
	
	/**
	 * 注册表单联动定义信息
	 * @param entity 表单联动定义信息实体
	 * @return 表单联动定义信息实体
	 * @throws BLException
	 */
	public IG286Info registProcessLinkageDef(IG286Info entity) throws BLException;
	
	/**
	 * 删除表单联动定义信息
	 * @param entity 表单联动定义信息实体
	 * @return 表单联动定义信息实体
	 * @throws BLException
	 */
	public void deleteProcessLinkageDef(IG286Info entity) throws BLException;
	
	/**
	 * 主键检索表单联动定义信息
	 * @param pk 主键
	 * @return 表单联动定义信息
	 * @throws BLException
	 */
	public IG286Info searchProcessLinkageDefByKey(String pk) throws BLException;
	
	/**
	 * 参与人按钮定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG132Info> searchParticipantButtonDef(IG132SearchCond cond) throws BLException;
	
	/**
	 * 主键检索参与人按钮定义
	 * @param pk 主键
	 * @return 参与人按钮定义信息
	 * @throws BLException
	 */
	public IG132Info searchParticipantButtonDefByKey(String pk) throws BLException;
	
	/**
	 * 参与人按钮定义主键值取得
	 * @param 流程定义ID
	 * @return 参与人按钮定义主键值
	 */
	public String getParticipantButtonDefPK(String pbdid) throws BLException;
	
	/**
	 * 注册参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @return 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public IG132Info registParticipantButtonDef(IG132Info entity) throws BLException;
	
	/**
	 * 根据主键删除参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public void deleteParticipantButtonDefByKey(String pk) throws BLException;
	
	/**
	 * 更新参与人按钮定义信息 
	 * @param entity 参与人按钮定义信息实体
	 * @return 参与人按钮定义信息实体
	 * @throws BLException
	 */
	public IG132Info updateParticipantButtonDef(IG132Info entity) throws BLException;
	
	/**
	 * 参与人按钮定义视图检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG221Info> searchParticipantButtonVW(IG221SearchCond cond) throws BLException;
	
	/**
	 * 缺省参与人按钮定义视图检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG221Info> searchDefaultParticipantButtonVW(IG221SearchCond cond) throws BLException;
	
	/**
	 * 流程参与者变量权限视图查询
	 * @param cond 查询条件
	 * @return 流程参与者变量权限
	 * @throws BLException 
	 */
	public List<IG100Info> searchProcessInfoParticipantDefVW(IG100SearchCond cond) throws BLException;
	
	/**
	 * 主键检索参与人变量权限信息
	 * @param pk 主键
	 * @return 参与人变量权限信息
	 * @throws BLException
	 */
	public IG881Info searchProcessInfoParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * 参与人变量权限主键值取得
	 * @param 流程状态参与者定义ID
	 * @return 参与人变量权限主键值
	 */
	public String getProcessInfoParticipantDefPK(String ppdid) throws BLException;
	
	/**
	 * 注册参与人变量权限
	 * @param entity 参与人变量权限实体
	 * @return 参与人变量权限实体
	 * @throws BLException
	 */
	public IG881Info registProcessInfoParticipantDef(IG881Info entity) throws BLException;
	
	/**
	 * 更新参与人变量权限
	 * @param entity 参与人变量权限实体
	 * @return 参与人变量权限实体
	 * @throws BLException
	 */
	public IG881Info updateProcessInfoParticipantDef(IG881Info entity) throws BLException;
	
	/**
	 * 跃迁规则检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG273Info> searchProcessTransitionDef(IG273SearchCond cond) throws BLException;
	
	/**
	 * 跃迁规则主键值取得
	 * @param 流程状态ID
	 * @return 跃迁规则主键值
	 */
	public String getProcessTransitionDefPK(String psdid) throws BLException;
	
	/**
	 * 注册跃迁规则
	 * @param entity 跃迁规则实体
	 * @return 跃迁规则实体
	 * @throws BLException
	 */
	public IG273Info registProcessTransitionDef(IG273Info entity) throws BLException;
	
	/**
	 * 更新跃迁规则
	 * @param entity 跃迁规则实体
	 * @return 跃迁规则实体
	 * @throws BLException
	 */
	public IG273Info updateProcessTransitionDef(IG273Info entity) throws BLException;
	
	/**
	 * 根据主键删除跃迁规则
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessTransitionDefByKey(String pk) throws BLException;
	
	/**
	 * 缺省参与人按钮定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG725Info> searchParticipantDefaultButtonDef(IG725SearchCond cond) throws BLException;
	
	/**
	 * 新增确认按钮处理
	 * @param psdid 流程状态ID
	 */
	public void registConfirmButton(String psdid) throws BLException;
	
	/**
	 * 删除确认按钮处理
	 * @param psdid 流程状态ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException;
	
	/**
	 * 缺省参与人按钮定义主键值取得
	 * @param 流程定义ID
	 * @return 缺省参与人按钮定义主键值
	 */
	public String getParticipantDefaultButtonDefPK(String psdid) throws BLException;
	
	/**
	 * 注册缺省参与人按钮定义
	 * @param entity 缺省参与人按钮定义实体
	 * @return 缺省参与人按钮定义实体
	 * @throws BLException
	 */
	public IG725Info registParticipantDefaultButtonDef(IG725Info entity) throws BLException;
	
	/**
	 * 更新缺省参与人按钮定义
	 * @param entity 缺省参与人按钮定义实体
	 * @return 缺省参与人按钮定义实体
	 * @throws BLException
	 */
	public IG725Info updateParticipantDefaultButtonDef(IG725Info entity) throws BLException;
	
	/**
	 * 根据主键删除缺省参与人按钮定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteParticipantDefaultButtonDefByKey(String pk) throws BLException;
	
	/**
	 * 根据主键删除缺省参与人按钮定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public IG725Info searchParticipantDefaultButtonDefByKey(String pk) throws BLException;
	
	/**
	 * 定制页面检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG126Info> searchProcessJspDef(IG126SearchCond cond) throws BLException;
	
	/**
	 * 定制页面主键值取得
	 * @param 流程定义ID
	 * @return 定制页面主键值
	 */
	public String getProcessJspDefPK(String pdid) throws BLException;
	
	/**
	 * 注册定制页面
	 * @param entity 定制页面实体
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info registProcessJspDef(IG126Info entity) throws BLException;
	
	/**
	 * 更新定制页面
	 * @param entity 定制页面实体
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info updateProcessJspDef(IG126Info entity) throws BLException;
	
	/**
	 * 主键检索定制页面
	 * @param pk 主键
	 * @return 定制页面实体
	 * @throws BLException
	 */
	public IG126Info searchProcessJspDefByKey(String pk) throws BLException;
	
	/**
	 * 根据主键删除定制页面
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessJspDefByKey(String pk) throws BLException;
	
	/**
	 * 流程缺省变量权限视图查询
	 * @param cond 查询条件
	 * @return 流程缺省变量权限
	 * @throws BLException 
	 */
	public List<IG909Info> searchParticipantDefaultVariableVW(IG909SearchCond cond) throws BLException;
	
	/**
	 * 流程缺省变量权限主键值取得
	 * 
	 * @param 流程状态ID
	 * @return 流程缺省变量权限主键值
	 */
	public String getParticipantDefaultVariablePK(String pdid) throws BLException;
	
	/**
	 * 注册流程缺省变量权限
	 * @param entity 流程缺省变量权限实体
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info registParticipantDefaultVariable(IG699Info entity) throws BLException;
	
	/**
	 * 更新流程缺省变量权限
	 * @param entity 流程缺省变量权限实体
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info updateParticipantDefaultVariable(IG699Info entity) throws BLException;
	
	/**
	 * 主键检索流程缺省变量权限
	 * @param pk 主键
	 * @return 流程缺省变量权限实体
	 * @throws BLException
	 */
	public IG699Info searchParticipantDefaultVariableByKey(String pk) throws BLException;
	
	/**
	 * 缺省变量权限检索
	 * @param cond 检索条件
	 * @return 缺省变量权限集合
	 * @throws BLException
	 */
	public List<IG699Info> searchParticipantDefaultVariable(IG699SearchCond cond) throws BLException;
	
	/**
	 * 流程查看角色检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG700Info> searchProcessSeeRoleInfo(IG700SearchCond cond) throws BLException;
	
	/**
	 * 注册流程查看角色
	 * @param entity 流程查看角色实体
	 * @return 流程查看角色实体
	 * @throws BLException
	 */
	public IG700Info registProcessSeeRoleInfo(IG700Info entity) throws BLException;
	
	/**
	 * 根据主键删除流程查看角色
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessSeeRoleInfoByKey(IG700PK pk) throws BLException;
	
	/**
	 * 流程共通变量检索结果件数
	 * @param cond 检索条件
	 * @return 检索件数
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralSearchCount(IG202SearchCond cond) throws BLException;
	
	/**
	 * 流程共通变量检索(分页用)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneral(IG202SearchCond cond,int start,int count) throws BLException;

	/**
	 * 流程共通变量检索结果件数
	 * @param cond 检索条件
	 * @return 检索件数
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralVWSearchCount(IG202SearchCond cond) throws BLException;
	
	/**
	 * 流程共通变量检索(分页用)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneralVW(IG202SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * 主键检索流程共通变量
	 * @param pk 主键
	 * @return 流程共通变量
	 * @throws BLException
	 */
	public IG202Info searchProcessInfoDefGeneralByKey(Integer pk) throws BLException;
	
	/**
	 * 注册流程共通变量
	 * @param entity 流程共通变量实体
	 * @return 流程统统变量实体
	 * @throws BLException
	 */
	public IG202Info registProcessInfoDefGeneral(IG202Info entity) throws BLException;
	
	/**
	 * 流程共通变量更新
	 * @param entity 流程共通变量实体
	 * @return 流程共通变量实体
	 * @throws BLException
	 */
	public IG202Info updateProcessInfoDefGeneral(IG202Info entity) throws BLException;
	
	/**
	 * 根据主键删除流程共通变量
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessInfoDefGeneralByKey(Integer pk) throws BLException;
	
	/**
	 * 注册流程通知策略
	 * @param entity 流程通知策略实体
	 * @return 流程通知策略实体
	 * @throws BLException
	 */
	public IG212Info registProcessNoticeStrategyDefInfo(IG212Info entity) throws BLException;
	
	/**
	 * 流程通知策略查询
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	public List<IG238Info> searchProcessNoticeStrategyVWInfoByPdid(String pdid) throws BLException;
	
	/**
	 * 流程策略通知人检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG237Info> searchProcessNoticeStrategyUserInfo(IG237SearchCond cond);
	
	/**
	 * 删除流程策略通知人
	 * @param entity 流程策略通知人实体
	 * @throws BLException
	 */
	public void deleteProcessNoticeStrategyUserInfo(IG237Info entity) throws BLException;
	
	/**
	 * 注册流程策略通知人
	 * @param entitys 流程策略通知人实体集合
	 * @throws BLException
	 */
	public void registProcessNoticeStrategyUserInfo(List<IG237Info> entitys) throws BLException;
	
	/**
	 * 主键检索流程外部调用定义
	 * @param pk 主键
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info searchProcessExternalDefInfoByKey(Integer pk) throws BLException;
	
	/**
	 * 注册流程外部调用定义
	 * @param entity 流程外部调用定义实体
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info registProcessExternalDefInfo(IG992Info entity) throws BLException;
	
	/**
	 * 更新流程外部调用定义
	 * @param entity 流程外部调用定义实体
	 * @return 流程外部调用定义实体
	 * @throws BLException
	 */
	public IG992Info updateProcessExternalDefInfo(IG992Info entity) throws BLException;
	
	/**
	 * 根据主键删除流程外部调用定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteProcessExternalDefInfoByKey(Integer pk) throws BLException;
	
	/**
	 * 流程外部调用定义检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG992Info> searchProcessExternalDefInfo(IG992SearchCond cond) throws BLException;
	
	/**
	 * 流程状态参与者调整检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG258Info> searchProcessStatusPrtChangeDefInfo(IG258SearchCond cond) throws BLException;
	
	/**
	 * 流程状态参与者调整主键值取得
	 * @param 流程定义ID
	 * @return 流程状态参与者调整主键值
	 */
	public String getProcessStatusPrtChangeDefPK(String psdid) throws BLException;
	
	/**
	 * 注册流程状态参与者调整
	 * @param entity 流程状态参与者调整实体
	 * @return 流程状态参与者调整实体
	 * @throws BLException
	 */
	public IG258Info registProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException;
	
	/**
	 * 删除流程状态参与者调整
	 * @param entity 流程状态参与者调整实体
	 * @throws BLException
	 */
	public void deleteProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException;
	
	/**
	 * 注册分派定义
	 * @param entity 分派定义实体
	 * @return 分派定义实体
	 * @throws BLException
	 */
	public IG233Info registAssignedDefInfo(IG233Info entity) throws BLException;
	
	/**
	 * 查询指定状态的分派信息
	 * @param psdid 状态ID
	 * @return 分派信息结合
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * 条件检索状态的分派信息
	 * @param cond 检索条件
	 * @return 分派信息结合
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfo(IG233SearchCond cond) throws BLException;
	
	/**
	 * 删除分派信息
	 * @param entitys 分派信息实体集合
	 * @throws BLException
	 */
	public void deleteAssignedDefInf(List<IG233Info> entitys) throws BLException;
	
	/**
	 * 根据流程定义主键查询表单查询条件定义
	 * @param pdid 流程定义主键
	 * @return 表单查询条件定义实体
	 * @throws BLException
	 */
	public List<IG108Info> searchFormQueryDefByPdid(String pdid) throws BLException;
	
	/**
	 * 注册表单查询条件
	 * @param entity 表单查询条件实体
	 * @return 表单查询条件实体
	 * @throws BLException
	 */
	public IG108Info registFormQueryDefInfo(IG108Info entity) throws BLException;
	
	/**
	 * 根据主键删除表单查询条件定义
	 * @param pk 主键
	 * @throws BLException
	 */
	public void deleteFormQueryDefByKey(Integer pk) throws BLException;
	
	/**
	 * 通知策略检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG334Info> searchInformStrategy(IG334SearchCond cond) throws BLException;
	
	/**
	 * 注册通知策略
	 * @param entity 通知策略实体
	 * @return 通知策略实体
	 * @throws BLException
	 */
	public IG334Info registInformStrategy(IG334Info entity) throws BLException;
	
	/**
	 * 删除通知策略
	 * @param entity 通知策略实体
	 * @throws BLException
	 */
	public void deleteInformStrategy(IG334Info entity) throws BLException;
	
	/**
	 * 表单策略检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategy(IG335SearchCond cond) throws BLException;
	
	/**
	 * 超时通知策略查询
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategyVW(String pdid,  String psdid, String pidid, String psdconfirm) throws BLException;
	
	/**
	 * 注册表单策略
	 * @param entity 表单策略实体
	 * @return 表单策略实体
	 * @throws BLException
	 */
	public IG335Info registFormStrategy(IG335Info entity) throws BLException;
	
	/**
	 * 表单策略删除
	 * @param entitys 表单策略实体集合
	 * @throws BLException
	 */
	public void deleteFormStrategy(List<IG335Info> entitys) throws BLException;
	
	/**
	 * XML脚本导出处理
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public String exportXML(String pdid) throws BLException;
	
	/**
	 * XML脚本导入处理
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(List<org.jdom.Element> elements) throws BLException;
	
	/**
	 * 表单角色范围注册
	 * @param entity 表单角色范围实体
	 * @return 表单角色范围实体
	 * @throws BLException
	 */
	public IG008Info registFormRoleScope(IG008Info entity) throws BLException;

	/**
	 * 根据表单定义ID检索表单角色限定范围
	 * @param pidid 表单定义主键
	 * @return
	 */
	public List<IG008Info> searchFormRoleScopeByPidid(String pidid);
	
	/**
	 * 表单角色限定范围删除
	 * @param entitys 表单角色限定范围实体集合
	 */
	public void deleteFormRoleScope(List<IG008Info> entitys) throws BLException;
	
    /**
     * 状态级私有表单单保存或更改
     * @Description: 状态级私有表单单保存或更改
     * @param dfvalue 默认值
     * @param usedToAll 是否应用到所有状态
     * @param psdid 状态id
     * @param pidid 表单id
     * @throws BLException
     */
    public void saveOrUpdateStatusDefault(String dfvalue, boolean usedToAll, String psdid, String pidid) throws BLException;
    
    /**
     * 查询某一状态或某一表单的默认值，如果同一个表单有多个默认值，则取最高权限。
     * @Description: 查询某一状态或某一表单的默认值，如果同一个表单有多个默认值，则取最高权限。
     * @param psdid 节点id,like查询
     * @param pidid 表单id,like查询
     * @throws BLException
     */
    public List<IG560VWInfo> searchIG560VWInfo(String psdid, String pidid) throws BLException;
    
    /**
     * 状态级私有表单默认值 cond检索
     * @Description: 状态级私有表单默认值 cond检索
     * @param cond 
     * @return
     * @throws BLException
     */
    public List<IG560Info> searchIG560TBInfo(IG560SearchCond cond) throws BLException;

    /**
     * 保存状态级私有表单默认值
     * @Description: 保存状态级私有表单默认值
     * @param list ig560list
     * @throws BLException
     */
    public void saveStatusDefaultList(List<IG560Info> list) throws BLException;

    /**
     * 流程查询显示列查询
     * @param pdid 流程定义ID
     * @return 流程查询显示列集合
     * @throws BLException
     */
	public List<IG110Info> searchProcessQueryShowColumnByPdid(String pdid) throws BLException;

	/**
	 * 流程查询条件查询
	 * @param pdid 流程定义ID
	 * @return 流程查询条件集合
	 * @throws BLException
	 */
	public List<IG111Info> searchprocessQueryByPdid(String pdid) throws BLException;

	/**
	 * 删除流程查询显示列
	 * @param instance 流程查询显示列
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumn(IG110Info instance) throws BLException;

	/**
	 * 删除流程查询条件
	 * @param instance 流程查询条件
	 * @throws BLException
	 */
	public void deleteProcessQuery(IG111Info instance) throws BLException;

	/**
	 * 流程查询显示列定义登记处理
	 * @param instance 流程查询显示列实体
	 * @return 流程查询显示列实体
	 * @throws BLException
	 */
	public IG110Info registProcessQueryShowColumn(IG110Info instance) throws BLException;
	
	/**
	 * 流程查询显示列定义更新处理
	 * @param instance 流程查询显示列实体
	 * @return 流程查询显示列实体
	 * @throws BLException
	 */
	public IG110Info updateProcessQueryShowColumn(IG110Info instance) throws BLException;
	
	/**
	 * 取得查询显示列实体的下一个ID
	 * @param pdid 流程定义ID
	 * @return 流程显示列实体ID
	 * @throws BLException
	 */
	public String getProcessQueryShowColumnNextId(String pdid) throws BLException;
	
	/**
	 * 取得查询条件实体的下一个ID
	 * @param pdid 流程定义ID
	 * @return 流程查询条件实体ID
	 * @throws BLException
	 */
	public String getProcessQueryNextId(String pdid) throws BLException;

	/**
	 * 流程查询条件登记处理
	 * @param instance 流程查询条件实体
	 * @return 流程查询条件实体
	 * @throws BLException
	 */
	public IG111Info registProcessQuery(IG111Info instance) throws BLException;
	/**
	 * 功能：根据流程组定义ID获取流程组定义
	 * @param pgdid 流程定义ID
	 * @return 流程组定义信息
	 * @throws BLException
	 */
	public IG480Info searchGroupProcessDefinitionByKey(String pgdid) throws BLException;
	/**
	 * 功能：更新流程组定义信息
	 * 
	 * @param processDefinition 流程组定义信息
	 * @return 流程组定义
	 * @throws BLException
	 */
	public IG480Info updateGroupProcessDefinition(IG480Info processDefinition) throws BLException;
	/**
	 * 流程组定义升版处理存储过程
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException;
	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 */
	public String copyGroupProcessDefVersion(String pgdid) throws BLException;

	/**
	 * 根据pdid删除流程查询显示列
	 * 
	 * @param instance
	 *            流程查询显示列
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumnByPdid(String pdid) throws BLException;

	/**
	 * 根据pdid删除流程查询条件
	 * 
	 * @param instance
	 *            流程查询条件
	 * @throws BLException
	 */
	public void deleteProcessQueryByPdid(String pdid) throws BLException;

}
