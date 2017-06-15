/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.igflow.resultset.ProcessFormLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.igflow.resultset.ProcessLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessOverdueInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;

/**
 * 流程查询功能API
 */
public interface FlowSearchBL extends BaseBL {
	
	/**
	 * 流程当前状态列表查询
	 * @param prid 流程ID
	 * @return 流程当前状态列表
	 */
	public List<ProcessStatusInfo> searchCurrentStatus(Integer prid) throws BLException;

	/**
	 * 资产信息查询
	 * <BR>
	 * 包括属性信息
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer eiid) throws BLException;

	/**
	 * 资产信息查询
	 * <BR>
	 * 模型层次码进行前方一致模糊匹配
	 * <BR>
	 * 结果为最新版信息，不包括属性信息
	 * @param esyscoding 模型层次码
	 * @return 资产信息
	 * @throws BLException
	 */
	public List<EntityItemInfo> searchEntityItem(String esyscoding) throws BLException;
	
	/**
	 * 资产信息查询
	 * <BR>
	 * 属性集合可为空，其中key：属性名称，value：属性值
	 * <BR>
	 * 默认查询属性名称=key，属性值=value的记录
	 * <BR>
	 * 当value=null时查询属性名称=key的记录
	 * <BR>
	 * 当value=""时查询属性名称=key，属性值=""的记录
	 * @param value 属性集合
	 * @return 资产ID列表
	 * @throws BLException 
	 */
	public List<Integer> searchEntityItem(Map<String, String> value) throws BLException;

	/**
	 * 资产属性值查询
	 * <BR>
	 * 当属性名称不存在时抛出异常
	 * @param assetid 资产ID
	 * @param name 资产属性名称
	 * @return 资产属性值
	 * @throws BLException 
	 */
	public String searchEntityItemConfigValue(Integer assetid, String name) throws BLException;
	
	/**
	 * 根据工单标识查询当前最大工单号
	 * <BR>
	 * 工单标识进行前方一致模糊匹配
	 * @param serialnum 工单标识
	 * @return 最大工单号
	 */
	public String searchMaxSerialnum(String serialnum) throws BLException;
	
	/**
	 * 参与者状态表单信息
	 * @param pdid 流程定义ID
	 * @param name 状态名称
	 * @param roleid 处理角色ID
	 * @return 参与者状态表单信息
	 */
	public List<ParticipantStatusFormInfo> searchParticipantStatusFormInfo(String pdid, String name, Integer roleid)
			throws BLException;
	
	/**
	 * 流程私有表单值查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param name 表单名称
	 * @return 表单值列表
	 * @throws BLException 
	 */
	public List<PrivateProcessFormInfo> searchPrivateProcessInfo(Integer prid, String name) throws BLException;
	
	/**
	 * 流程相关资产查询
	 * <BR>
	 * 当piname为空时返回该流程ID所有的相关资产，当查询无结果时返回null
	 * @param prid 流程ID
	 * @param pidname 表单名称（可为空）
	 * @return 相关资产列表
	 * @throws BLException 
	 */
	public List<ProcessInfoEntityInfo> searchProcessEntityItem(Integer prid, String pidname) throws BLException;

	/**
	 * 流程基本信息查询
	 * @param prid 流程ID （可为空）
	 * @param serialnum 流程工单号（可为空）
	 * @return 流程基本信息
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(Integer prid, String serialnum) throws BLException;

	/**
	 * 流程基本信息查询
	 * @param status 流程状态标识
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String status) throws BLException;

	/**
	 * 流程基本信息查询
	 * @param startTime 流程发起时间开始（可为空）
	 * @param endTime 流程发起时间结束（可为空）
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String startTime, String endTime) throws BLException;

	/**
	 * 流程基本信息查询
	 * @param pdid 流程定义ID
	 * @param beginTime 流程发起时间开始（可为空）
	 * @param endTime 流程发起时间结束（可为空）
	 * @return 流程基本信息列表
	 * @throws BLException
	 */
	public List<ProcessRecordInfo> searchProcessInfo(String pdid, String beginTime, String endTime) throws BLException;

	/**
	 * 流程表单描述信息查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param pdid 流程定义ID
	 * @param pidname 表单名称
	 * @return 表单描述信息
	 * @throws BLException
	 */
	public String searchProcessInfoDefDescByName(String pdid, String pidname) throws BLException;

	/**
	 * 流程处理记录查询
	 * @param prid 流程ID
	 * @param psdid 流程状态ID
	 * @param psdnum 流程状态分支编号
	 * @param userid 处理用户ID
	 * @return 流程处理记录列表
	 * @throws BLException
	 */
	public List<ProcessLogInfo> searchProcesslog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException;
	
	/**
	 * 流程表单日志查询
	 * @param prid 流程ID
	 * @param psdid 流程状态ID
	 * @param psdnum 流程状态分支编号
	 * @param userid 处理用户ID
	 * @return 流程表单日志列表
	 */
	public List<ProcessFormLogInfo> searchProcessFormlog(Integer prid, String psdid, Integer psdnum, String userid)
			throws BLException;
	
	/**
	 * 指定流程状态逾期未处理参与者查询
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 逾期未处理参与者信息
	 * @throws BLException
	 */
	public List<ProcessOverdueInfo> searchProcessOverdueInfo(Integer prid, String status)
			throws BLException;

	/**
	 * 流程关系查询
	 * <BR>
	 * 根据主流程ID查询子流程ID
	 * @param parprid 主流程ID
	 * @return 子流程ID列表
	 * @throws BLException
	 */
	public List<Integer> searchProcessRelationForCld(Integer parprid) throws BLException;
	
	/**
	 * 流程关系查询
	 * <BR>
	 * 根据子流程ID查询主流程ID
	 * @param cldprid 子流程ID
	 * @return 主流程ID
	 * @throws BLException
	 */
	public Integer searchProcessRelationForPar(Integer cldprid) throws BLException;
	
	/**
	 * 流程表格式表单定义查询
	 * <BR>
	 * 该方法的返回结果仅作为表格式表单单个值的查询与设定
	 * <BR>
	 * 定义信息不存在时抛异常
	 * @param prid 流程ID
	 * @return 表格式表单定义信息
	 * @throws BLException
	 */
	public Map<String, ProcessInfoDefinitionInfo> searchProcessTableColumnDef(Integer prid) throws BLException;

	/**
	 * 公有人员表单信息查询
	 * 流程信息不存在或表单信息不存在时抛异常
	 * @param prid 流程ID
	 * @param name 表单名称
	 * @return 人员信息集合
	 * @throws BLException
	 */
	public List<ParticipantInfo> searchPublicParticipantFormValue(Integer prid,String name) throws BLException;

	/**
	 * 流程公有表单值查询
	 * <BR>
	 * 当表单名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param pidname 表单名称
	 * @return 表单值
	 * @throws BLException
	 */
	public String searchPublicProcessInfo(Integer prid, String pidname) throws BLException;
	
	/**
	 * 表格式表单公有值查询(表单层级名称中间以 "#" 隔开)
	 * <BR>
	 * 表单全路径不存在时抛异常
	 * @param tableColumnDefMap 表格式表单列定义
	 * @param tableColumnFullName 表格式表单列全路径名称
	 * @param prid 流程ID
	 * @param rownumber 行号
	 * @return 表格式表单值
	 * @throws BLException
	 */
	public String searchPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,
			String tableColumnFullName, Integer prid,String rownumber) throws BLException ;
	
	/**
	 * 表格类表单值查询
	 * <BR>
	 * 表单全路径不存在时抛异常
	 * @param tableFullName 表格式表单全名
	 * @param prid 流程ID
	 * @param rownumber 行号(如果是顶级传空字符串)
	 * @return 表格式表单值（ArrayList）
	 * @throws BLException
	 */
	public Object searchPublicTableValue(String tableFullName, Integer prid,String rownumber) throws BLException;

	/**
	 * 监管报表信息查询
	 * <BR>
	 * 不包括不定期和中止报表
	 * @param type 报表类型
	 * @param pdid 流程定义ID
	 * @param key 年报格式：2012,季报格式：2012_一季度
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 监管报表ID列表
	 * @throws BLException
	 */
	public List<Integer> searchRegulatoryReportInfo(String type, String pdid, String key, Boolean isClose) throws BLException;
	
	/**
	 * 流程状态列表查询
	 * <BR>
	 * 只返回定义信息，时间信息为空
	 * @param pdid 流程定义ID
	 * @return 流程状态列表
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusList(String pdid) throws BLException;
	
	/**
	 * 流程状态查询
	 * <BR>
	 * 只返回定义信息，时间信息为空
	 * @param psdid 流程状态ID
	 * @return 流程状态
	 * @throws BLException 
	 */
	public ProcessStatusInfo searchProcessStatus(String psdid) throws BLException;
	
	/**
	 * 流程状态日志列表查询
	 * @param pdid 流程定义ID
	 * @return 流程状态日志列表
	 * @throws BLException 
	 */
	public List<ProcessStatusInfo> searchProcessStatusLog(Integer prid) throws BLException;

	/**
	 * 状态参与者查询
	 * <BR>
	 * 当状态名称不存在时抛出异常
	 * @param prid 流程ID
	 * @param statusname 状态名称
	 * @return 参与者列表
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipant(Integer prid, String statusname)
		throws BLException;

	/**
	 * 状态参与者查询
	 * @param prid 流程ID
	 * @param status 状态标识
	 * @return 参与者列表
	 * @throws BLException 
	 */
	public List<ParticipantInfo> searchStatusParticipantByCode(Integer prid, String status) throws BLException;
	
	/**
     * 人员表单值查询
     * @param prid 流程ID
     * @param pidname 表单名称
     * @return 人员信息集合
     * @throws 当流程ID为空时抛异常
     */
    public List<ParticipantInfo> searchProcessParticipantForm(Integer prid,String pidname) throws BLException;
	/**
	 * 资产信息查询(应急资源专用)
	 * <BR>
	 * 结果为最新版信息，包括属性信息
	 * @param id 数据库ID
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException
	 */
	public EntityItemInfo searchEntityItem(Integer id , Integer eiid) throws BLException ;
}
