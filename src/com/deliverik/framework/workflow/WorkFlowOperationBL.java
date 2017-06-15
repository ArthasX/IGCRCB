/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow;

import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;

/**
 * <p>
 * 流程处理业务逻辑
 * </p>
 * 
 */

public interface WorkFlowOperationBL extends BaseBL{
	
	
	/**
	 * <p>
	 * 流程信息对象实例取得
	 * <p>
	 * 
	 * @return 流程信息对象实例
	 */
	public IG500TB getProcessRecordTBInstance();
	
	/**
	 * <p>
	 * 流程变量信息对象实例取得
	 * <p>
	 * 
	 * @return 流程变量信息对象实例
	 */
	public IG599TB getProcessInfoTBInstance();

	/**
	 * <p>
	 * 参与者信息对象实例取得
	 * <p>
	 * 
	 * @return 参与者信息对象实例
	 */
	public IG337TB getProcessParticipantTBInstance();

	/**
	 * <p>
	 * 日志信息对象实例取得
	 * <p>
	 * 
	 * @return 日志信息对象实例
	 */
	public IG036TB getRecordLogTBInstance();
	
	/**
	 * <p>
	 * 新的流程关系信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程关系信息对象实例取得
	 */
	
	public IG512TB getProcessRecordRelationTBInstance();
	
	
	/**
	 * <p>
	 * 流程发起
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	public IG500Info createProcessRecord(IG500Info processRecord, User user, Integer roleid,
			String comment, String desc, Map<Integer, FormFile> filemap, String type, String pbdid, String prstatus)
			throws BLException;

	/**
	 * <p>
	 * 流程发起
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param participantList 流程参与者信息
	 * @param processInfoList 流程变量信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	public IG500Info createProcessRecord(IG500Info processRecord, List<IG337Info> participantList,
			List<IG599Info> processInfoList, User user, Integer roleid, 
			String comment, String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus)
			throws BLException;

	/**
	 * <p>
	 * 流程状态跃迁
	 * </p>
	 * 
	 * @param srcStatus 流程跃迁时状态，即原状态
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser授权人用户信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(String srcStatus,IG500Info processRecord,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,User authorizeuser, String pbdid, String prstatus)
			throws BLException;
	
	/**
	 * <p>
	 * 流程信息更新(流程状态不改变)
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser授权人用户信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException;
	
	/**
	 * <p>
	 * 流程信息更新(流程状态不改变,不记录日志信息)
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	public IG500Info updateProcessRecord(IG500Info processRecord) throws BLException;
	
	/**
	 * <p>
	 * 指定流程ID查询流程信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程信息
	 * @throws BLException 
	 *
	 */
	public IG500Info searchProcessRecordByKey(Integer prid) throws BLException;
	
	/**
	 * <p>
	 * 指定工单号查询流程信息
	 * </p>
	 * 
	 * @param prserialnum 流程工单号
	 * @return 流程信息
	 * @throws BLException 
	 *
	 */
	public IG500Info searchProcessRecordBySerialnum(String prserialnum) throws BLException;

	/**
	 * 根据检索条件取得流程信息列表（分页查询用）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	public List<IG500Info> searchProcessRecord(IG500SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件（包括表单条件）取得流程信息列表（分页查询用）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得流程信息列表
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息检索结果列表
	 */
	public List<IG500Info> searchProcessRecord(IG500SearchCond cond);

	/**
	 * <p>
	 * 根据检索条件取得流程信息条数
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息条数
	 */
	public int getProcessRecordSearchCount(IG500SearchCond cond);
	
	/**
	 * 根据检索条件取得流程信息列表（包含事件处理子状态）（平台保留）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	public List<IG500Info> searchProcessRecordSubStatusList(IG500SearchCond cond, int start, int count);

	/**
	 * 根据检索条件取得流程信息列表（包含事件处理子状态）（平台保留）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	public List<IG500ONLYInfo> searchProcessRecordONLYSubStatusList(IG500SearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * 根据检索条件取得流程信息条数（包含事件处理子状态）（平台保留）
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息条数
	 */
	public int getProcessRecordSubStatusSearchCount(IG500SearchCond cond);

	/**
	 * <p>
	 * 根据检索条件取得流程信息条数（包含事件处理子状态）（平台保留）
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息条数
	 */
	public int getProcessRecordONLYSubStatusSearchCount(IG500SearchCond cond);
	
	/**
	 * <p>
	 * 指定流程ID查询流程发起者
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param initStatus 流程发起状态
	 * @return 流程发起者信息
	 *
	 */
	public IG337Info searchProcessOpener(Integer prid,String initStatus);
	
	/**
	 * <p>
	 * Description: 获取指定参与者
	 * </p>
	 * 
	 * @param ppid 参与者ID
	 * @return 参与者信息
	 * @throws BLException 
	 */
	
	public IG337Info searchProcessParticipantByKey(Integer ppid) throws BLException;

	/**
	 * <p>
	 * 指定流程ID、流程状态查询未处理参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 未处理参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status);
	
	/**
	 * <p>
	 * 指定流程ID、流程状态、参与者子状态查询未处理参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ppsubstatus 参与者子状态
	 * @return 未处理参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status, String ppsubstatus);
	
	/**
	 * <p>
	 * 指定流程ID、流程状态查询已处理参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 已处理参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(Integer prid, String status);
	
	/**
	 * <p>
	 * 指定流程ID、流程状态、参与者子状态查询已处理参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ppsubstatus 参与者子状态
	 * @return 已处理参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(Integer prid, String status, String ppsubstatus);

	/**
	 * <p>
	 * 流程参与者增加
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser授权人用户信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type, User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	/**
	 * <p>
	 * 流程参与者增加
	 * </p>
	 * @param processParticipant 参与者信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant) throws BLException;

	/**
	 * <p>
	 * 流程参与者删除
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */
	public void removeProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type,User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	/**
	 * <p>
	 * 流程参与者删除
	 * 不记录日志
	 * </p>
	 * @param processParticipant 参与者信息
	 * @throws BLException
	 */
	
	public void removeProcessParticipant(IG337Info processParticipant) throws BLException;

	/**
	 * <p>
	 * 参与者信息更新(状态不改变)
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */
	public IG337Info updateProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,List<IG599Info> prInfoList, User authorizeuser, String pbdid, String prstatus) throws BLException;

	/**
	 * <p>
	 * 参与者信息更新(状态不改变,不记录日志信息）
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public IG337Info updateProcessParticipant(IG337Info processParticipant) throws BLException;
	/**
	 * <p>
	 * 指定流程ID、流程状态查询未处理参与者角色ID信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 未处理参与者角色ID信息
	 *
	 */
	public List<Integer> searchProcessParticipantTodoRoleId(Integer prid,String status);

	/**
	 * <p>
	 * 指定流程ID、用户ID、流程状态查询参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * @return 参与者信息
	 *
	 */
	public IG337Info searchProcessParticipant(Integer prid,String userId, String status);

	/**
	 * <p>
	 * 指定流程ID、角色ID、流程状态查询参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param roleId 角色ID
	 * @param status 流程状态
	 * @return 参与者信息
	 *
	 */
	public IG337Info searchProcessParticipant(Integer prid,Integer roleId, String status);

	/**
	 * <p>
	 * 指定流程ID、流程状态查询参与者信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipant(Integer prid, String status) throws BLException;
	
	/**
	 * <p>
	 * 根据检索条件查询参与者信息
	 * </p>
	 * 
	 * @param IG337SearchCond 参与者信息检索条件
	 * @return 参与者信息
	 *
	 */
	public List<IG337Info> searchProcessParticipants(IG337SearchCond cond);

	/**
	 * <p>
	 * 指定流程ID、流程状态查询未处理参与者的条数
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 未处理参与者的条数
	 *
	 */
	public int getTodoProcessParticipantCount(Integer prid, String status);

	/**
	 * <p>
	 * 日志增加,roleid为null则不记录操作角色名称
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param type 日志类型 0系统日志，1批准，2驳回，3提交，4中止，5更新
	 * @param pbdid 处理按钮ID
	 * @return 参与者信息
	 * @return 日志信息
	 * @throws BLException
	 *
	 */
	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment,
			String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus) throws BLException;
	
	/**
	 * 流程日志信息更新
	 * @param info 修改流程日志信息
	 * @throws BLException 
	 */
	public void updateRecordLog(IG036Info info) throws BLException;
	/**
	 * <p>
	 * 指定流程ID查询流程历史记录
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程历史记录
	 *
	 */
	public Map<IG036Info, List<Attachment>> searchRecordLog(Integer prid);

	/**
	 * <p>
	 * 查询除系统管理员外的流程中可增加的参与者角色
	 * </p>
	 * 
	 * @param processParticipantList 参与者信息
	 * @return 流程中可增加的参与者角色
	 *
	 */
	public List<Role> getRoleNotInProcessParticipants(List<IG337Info> processParticipantList);
	
	/**
	 * <p>
	 * 查询流程中可增加的审批角色
	 * </p>
	 * 
	 * @param  processParticipantList 已添加的审批角色
	 * @return 流程中可增加的审批角色
	 *
	 */
	public List<Role> getApproveRolesNotAdd(List<IG337Info> processParticipantList);

	/**
	 * <p>
	 * 指定流程ID、用户ID、流程状态查询用户可处理角色信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * 
	 * @return 用户可处理角色信息
	 *
	 */
	public List<UserRoleInfo> getUserRolesInProcessParticipants(Integer prid, String userId, String status);
	
	/**
	 * <p>
	 * 指定流程ID、用户ID、流程状态查询用户可处理角色信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * 
	 * @return 用户可处理角色信息
	 *
	 */
	public List<IG337Info> getUserRolesInProcessParticipants(Integer prid, String userId, String status, String na);

	/**
	 * <p>
	 * 查询指定流程定义的流程变量定义信息
	 * </p>
	 * 
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义信息
	 */
	public List<IG007Info> getProcessInfoDefs(String processDefinitionId);
	
	/**
	 * <p>
	 * 查询指定流程定义的流程变量定义信息(不包括缺省变量)（平台保留）
	 * </p>
	 * 
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量定义信息
	 */
	public List<IG007Info> getProcessInfoDefsNoDefault(String processDefinitionId);
	
	/**
	 * <p>
	 * 查询流程发起时所保存的流程变量信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程变量信息
	 *
	 */
	public List<IG599Info> getProcessInfo(Integer prid);
	
	/**
	 * <p>
	 * 查询流程变量信息
	 * </p>
	 * 
	 * @param piid 流程变量ID
	 * @return 流程变量信息
	 * @throws BLException 
	 *
	 */
	public IG599Info getProcessInfoByID(Integer piid) throws BLException;
	
	/**
	 * <p>
	 * 流程变量信息设定
	 * </p>
	 * 
	 * @param processInfoList 流程变量信息
	 *
	 */
	public List<IG599Info> saveOrUpdProcessInfos(List<IG599Info> processInfoList) throws BLException;
	/**
	 * <p>
	 * 流程变量信息设定
	 * </p>
	 * 
	 * @param processInfoList 流程变量信息
	 *
	 */
	public IG599Info saveProcessInfo(IG599Info processInfo) throws BLException;
	
	/**
	 * <p>
	 * 查询指定查询条件下的流程模板信息
	 * </p>
	 * 
	 * @param ProcessTemplateSearchCond 流程模板查询条件
	 * @return 流程模板信息
	 *
	 */
	public List<IG259Info> getActiveProcessTemplates() throws BLException;
	
	/**
	 * 查询指定流程模板
	 * @param ptid 流程模板ID
	 * @return 流程模板
	 * @throws BLException 
	 */
	public IG259Info getProcessTemplateByKey(Integer ptid) throws BLException;

	/**
	 * 查询指定流程类型定义信息
	 * @param pdid 流程类型定义信息ID
	 * @return 流程类型定义信息
	 * @throws BLException
	 */
	public IG380Info getProcessDefinitionByKey(String pdid) throws BLException;
	
	/**
	 * <p>
	 * 指定用户id、流程类型查询该用户发起的未关闭的流程信息
	 * </p>
	 * 
	 * @param userId 用户id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG500Info> getActiveProcessRecordsInitByUser(String userId, String prtype);
	
	/**
	 * <p>
	 * 指定角色id、流程类型查询该角色发起的未关闭的流程信息
	 * </p>
	 * 
	 * @param roleId 角色id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG500Info> getActiveProcessRecordsInitByRole(Integer roleId, String prtype);
	
	/**
	 * <p>
	 * 指定角色id、流程类型查询未关闭的流程信息
	 * </p>
	 * 
	 * @param roleId 角色id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG677Info> getWorkAssignedToMyManyRole(Integer roleId, String prtype);
	
	/**
	 * <p>
	 * 指定用户id、流程类型查询未关闭的流程信息
	 * </p>
	 * 
	 * @param userId 用户id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG677Info> getWorkAssignedToMe(String userId, String prtype,String pdid,String prstatus);
	
	/**
	 * 指定流程类型查询未关闭的流程信息
	 * 
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG500Info> getAllActiveProcessRecords(String prtype);
	
	/**
	 * 缺省审批人查询（平台保留）
	 * @param pdid 流程类型ID
	 * @return  缺省审批人列表
	 */
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * 缺省审批分派人查询（平台保留）
	 * @param pdid 流程类型ID
	 * @return  缺省审批分派人列表
	 */
	public List<IG337Info> getDefaultApprovorDispatcher(String pdid);
	
	/**
	 * 指定用户ID、流程ID查询该用户负责的流程的处理角色信息
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 处理角色信息
	 */
	public List<IG337Info> queryRolemanager(String userid , Integer prid);
	
	/**
	 * 服务请求信息条件检索处理（平台保留）
	 * @param cond 服务请求检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 服务请求信息列表
	 */
	public List<IG500Info> queryServiceRequestList(IG500SearchCond cond, int start, int count);
	
	/**
	 * 服务请求信息条件检索记录数取得（平台保留）
	 * @param cond 服务请求检索条件
	 * @return 服务请求信息记录数
	 */
	public int queryServiceRequestListCount(IG500SearchCond cond);
	
	/**
	 * 指定用户未处理流程条件检索处理
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid);

	/**
	 * 流程分派者角色未处理流程条件检索处理
	 * @param roleId 流程分派角色ID
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	public List<IG677Info> getWorkAssignedToFPRole(Integer roleId, String prtype);
	
	/**
	 * 检测指定用户是否具有指定流程查看权限（目前只支持变更，发布）
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 权限标识
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid);

	/**
	 * 当流程指定到角色时,在角色负责人的我的工作中显示此条流程信息
	 * @param userid 用户ID
	 * @return
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid);

	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果数量
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * 指定角色未处理流程条件检索处理
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid);
	
	/**
	 * <p>
	 * 流程关系建立
	 * </p>
	 * 
	 * @param processRecordRelation 流程关系信息
	 * @return 流程关系信息
	 * @throws BLException
	 *
	 */
	public IG512Info createProcessRecordRelation(IG512Info processRecordRelation) throws BLException;
	
	/**
	 * <p>
	 * 根据检索条件取得流程关系
	 * </p>
	 * 
	 * @param cond 流程关系信息检索条件
	 * @return 流程关系信息检索结果列表
	 *
	 */
	public List<IG512Info> searchProcessRecordRelation(IG512SearchCond cond);
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param processRecordRelationList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> processRecordRelationList);
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	public void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Integer pgrid) throws BLException;
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态数组
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	public void addRecordStatusLog(IG500Info processRecord, IG333Info fpsd, Integer psdnum,
			String[] tostatus, int statustype, User user, Integer roleid, User authorizeuser, String pbdid) throws BLException;
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentRecordStatusLog(Integer prid, String status) throws BLException;
	
	/**
	 * 当前流程状态标识集合取得
	 * 
	 * @param prid 流程ID
	 * @return 当前流程状态标识集合
	 * @throws BLException 
	 */
	public List<String> searchCurrentRecordStatus(Integer prid) throws BLException;
	
	/**
	 * <p>
	 * 指定流程状态日志查询
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 指定流程状态日志
	 *
	 */
	public List<IG224Info> searchRecordStatusLog(Integer prid);
	
	/**
	 * <p>
	 * 根据流程ID查询关联了该流程的流程记录
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程记录
	 *
	 */

	public List<IG500Info> searchProcessRecordsByPrid(Integer prid) throws BLException;

	
	/**
	 * <p>
	 * 根据查询条件查询流程变量信息
	 * </p>
	 * @param IG599SearchCond 流程变量查询条件
	 * @return 流程变量信息 
	 */
	public List<IG599Info> searchProcessInfoByCond(IG599SearchCond cond);
	
	/**
	 * <p>
	 * 根据查询条件查询流程变量定义信息
	 * </p>
	 * @param IG007SearchCond 流程变量定义查询条件
	 * @return 流程变量定义信息 
	 */
	public List<IG007Info> searchProcessInfoDefByCond(IG007SearchCond cond);
	
	/**
	 * 发起流程
	 * 
	 * @param processRecord 流程记录内容
	 * @param user	        用户
	 * @param roleid		角色ID
	 * @param filemap		附件map
	 * @param pts           流程类型
	 * @param prInfoList	流程变量信息
	 * @param rlcomment	    日志信息
	 * @param psdid	        流程状态ID
	 * @param action	    动作标识
	 * @param authorizeuser	授权人用户信息
	 */
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,
			String pts,List<IG599Info> prInfoList,String rlcomment,
			String psdid, String action, User authorizeuser)
			throws BLException;
	
	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransitionForCreate(User user,String fpsdid,Integer roleid,String action,
			Integer prid,List<IG599Info> piList, User authorizeuser) throws BLException;
	
	/**
	 * 匹配跃迁规则(运维计划用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransition(User user,String fpsdid,Integer roleid,String action,Integer prid,
			List<IG599Info> piList) throws BLException;
	
	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null(发起自定义流程时使用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param authorizeuser授权人用户信息
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,
			Integer prid,String nodeType,
			Map<Integer, List<String>> participants,String ppsuper,User authorizeuser) throws BLException;
	
	
	/**
	 * 获取下一流程状态的ID
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return IG333 跃迁后的流程状态
	 * @throws BLException
	 */
	public IG333Info checkTransition(String fpsdid,Integer roleid,String action,List<IG599Info> piList) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加参与者
	 * </p>
	 * 
	 * @param tpsdid tpsdid
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public List<IG337Info> addParticipants(String tpsdid,User user,Integer prid,Integer roleid,String desc,String nodetype,
			Map<Integer, List<String>> participants,String ppsuper, User authorizeuser, String pbdid, String prstatus) throws BLException;
	
	
	/**
	 * <p>
	 * Description: 流程跃迁 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	
	public void doFlow(Integer prid, User user,Integer roleid, String datetime, String rolename,
			String psdid,String action,String desc,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException;
	
	/**
	 * 流程跳转JSP取得
	 * 
	 * @param pdid流程定义ID
	 * @param prid流程ID
	 * @param pjdtype页面类型
	 * @param user登录用户信息
	 */
	public String searchForwardJsp(String pdid, Integer prid, String pjdtype, User user) throws BLException;
	
	/**
	 * 增加表单日志信息
	 * 
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param IG036Info	   流程日志
	 * @return 是否保存成功,成功是返回true,当传入的表单变量不存在时返回false
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl)throws BLException;
	
	/**
	 * 根据流程日志查询该流程日志对应的表单日志信息
	 * 
	 * @param IG036Info 流程日志
	 * @return 表单日志信息
	 */
	public List<IG113Info> searchRecordLogVarInfo(IG036Info recordLog) throws BLException;
	
	
	/**
	 * 根据流程日志ID查询该流程日志对应的表单日志信息
	 * 
	 * @param rlid 流程日志ID
	 * @return 表单日志信息
	 */
	public List<IG113Info> searchRecordLogVarInfoByRecordId(Integer rlid) throws BLException;
	
	/**
	 * 查询表单日志
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG113Info> searchRecordLogVarInfoByCond(IG113SearchCond cond) throws BLException;
	
	/**
	 * <p>
	 * 指定流程历史记录查询(自定义流程使用)
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 指定流程历史记录
	 *
	 */

	public List<IG036Info> searchRecordLogForProcessDef(Integer prid) throws BLException;
	
	/**
	 * 根据用户角色查找角色日志
	 * 
	 * @param RecordLogSearchCond流程定义ID
	 */
	public List<IG036Info> searchUserRoleRecondLog(IG036SearchCond cond);
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond);
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count);
	
	
	/**
	 * 自定义流程相关工作条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond);
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count);
	
	/**
	 * 获取流程参与者变量权限
	 * @param psdid流程状态ID
	 * @param roleid流程参与者角色ID
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchParticipantVariableVW(String psdid , Integer roleid);
	
	/**
	 * 授予指定角色值班人提交权限
	 * @param prid流程ID
	 * @param roleid流程参与者角色ID
	 * @throws BLException 
	 */
	public void grantDutyPerson(Integer prid , Integer roleid) throws BLException;
	
	/**
	 * 流程驱动时根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForPRR(List<IG337Info> processParticipantList,RoleSearchCond cond, int start, int count);
	
	/**
	 * 流程定义时根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForSelfPRD(RoleSearchCond cond, int start, int count);
	
	/**
	 * 根据流程变量ID获取流程变量参数值信息集合
	 * @param piid 流程变量ID
	 * @throws BLException 
	 */
	public IG599Info searchProcessInfoByPiid(Integer piid) throws BLException;
	
	/**
	 * 流程管理员修改表单信息
	 * 
	 */
	public void editVarInfo(IG500Info processRecord,User user, Integer roleid, Map<Integer, FormFile> filemap,
			List<IG599Info> prInfoList,String rlcomment, String prstatus) throws BLException;
	
	/**
	 * 删除流程
	 * @param prid
	 * @throws BLException
	 */
	public void delProcessRecord(Integer prid) throws BLException;
	
	/**
	 * 流程与资产关系设定
	 * @param ig731
	 */
	public IG731Info saveProcessInfoEntity(IG731Info processInfoEntity) throws BLException;

	/**
	 * 流程与资产关系信息查询
	 * @param prid 流程ID
	 * @return
	 */
	public List<IG731Info> searchProcessInfoEntityByPrid(Integer prid);
	
	/**
	 * 流程相关资产检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG731Info> searchProcessInfoEntityByCond(IG731SearchCond cond);

	/**
	 * 流程与资产关系信息删除操作
	 * @param pieid 流程资产关系ID
	 */
	public void deleteProcessInfoEntityById(Integer pieid) throws BLException;
	
	//取processinfo附件
	public  List<Attachment> searchProcessInofAtt(String piattkey);
	//文本域绑定附件上传并返回附件ID
	public IG599Info addProcessInfo(Map<Integer, FormFile> filemap) throws BLException ;
	public IG599Info updateProcessInfo(Map<Integer, FormFile> filemap,IG599Info pi) throws BLException;
	public void updateProcessInfo(IG599Info pi) throws BLException;
	public void addProcessInfoAtt(Map<Integer, FormFile> filemap,String attkey) throws BLException;
//	public String addAtt(Map<Integer, FormFile> filemap) throws BLException;
	//文本域绑定附件删除处理
	public  Attachment delAttachment(String attkey) throws BLException;


	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,Map<String, FormFile> filemapMuti,
			String pts,List<IG599Info> prInfoList,String rlcomment,
			String psdid, String action,Map<String,List<Attachment>> copyMap, User authorizeuser,
			Map<Integer, String> processInfoEntityMap,Map<String, Object> tableFormValueMap,
			Map<String, List<IG506TB>> participantFormValueMap,String isServiceStart,Integer parprid)
			throws BLException;
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchProcessInfoForClose(Integer prid, String pdid, String userid);
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchProcessInfoForSee(Integer prid, String pdid, String userid);
	
	
	/**
	 * 保存私有变量处理
	 * 
	 * @param lst_ProcessInfo 表单变量集合
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException 
	 */
	public void registProcessPrivateInfo(List<IG599Info> lst_ProcessInfo, Integer roleid, String userid, String orgid) throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG899Info> searchProcessPrivateInfo(IG899SearchCond cond) throws BLException;
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG899Info updateProcessPrivateInfo(IG899Info instance) throws BLException;
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchProcessExecutors(String userid, Integer prid);
	
	/**
	 * 流程可分派人检索处理
	 * @param roleid 角色ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid);
	
	/**
	 * <p>
	 * Description: 添加参与者
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	public void addParticipant(User user,Integer prid, String pdid, String psdcode,
			String executorRoleid, String executorUserid, String ppsuper,User authorizeuser, String pbdid, String prstatus) throws BLException;
	

	
	/**
	 * 流程触发按钮事件
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid处理角色ID
	 * @param authorizeuser授权人用户信息
	 */
	public void processStatusButtonTreatmentExecute(WorkFlowStatusEventBean bean) throws BLException;
	
	/**
	 * 发送通知
	 * @param status 状态标识
	 * @param lst_Userid 用户ID列表
	 * @param sms 短信内容
	 * @param lst_Roleid 角色ID列表
	 * @param title 标题
	 * @param content 邮件内容
	 * @param ig500 流程信息
	 * @throws BLException
	 */
	public void sendMessage(String status, List<String> lst_Userid, String sms,
			List<Integer> lst_Roleid, String title, String content, IG500Info ig500) throws BLException;
	
	/**
	 * 获取流程参与者最大权限
	 * @param psdid流程状态ID
	 * @param roleid流程参与者角色ID
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchParticipantMaxVariableVW(String psdid , Integer roleid,Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap);
	
	/**
	 * 功能：条件检索结果件数取得(可根据表单查询)
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(IG500SearchCond cond);
	
	/**
	 * 功能：带有当前处理人的本月工作查询取得(根据当前月，和当前登录人角色)
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<CurrentMonthWorkVWInfo> SearchCurrentWorkWithManage(CurrentMonthWorkVWSearchCond cond,int start,int count);
	
	/**
	 * 功能：带有当前处理人的本月工作查询取得(根据当前月，和当前登录人角色)
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public int SearchCurrentWorkWithManageCount(CurrentMonthWorkVWSearchCond cond);
	
	/**
	 * 取得流程类表单值
	 * @param prid
	 * @param value
	 * @return
	 * @throws BLException
	 */
	public String getProcessFormValue(Integer prid,String value) throws BLException;
	
	/**
	 * 取得人员类表单值
	 * @param prid 流程主键
	 * @param pvList 人员类表单值实体集合
	 * @param value 表单值
	 * @return
	 */
	public String getParticipantFormValue(Integer prid,List<IG506TB> pvList,String value) throws BLException;
	
	/**
	 * 表格类表单列查询
	 * @param pdid 流程定义主键
	 * @return 
	 * @throws BLException
	 */
	public Map<String, List<IG007Info>> initTableFormAction(String pdid) throws BLException;
	
	/**
	 * 表格类表单列值保存处理
	 * @param process 流程信息
	 * @param column_value 值集合
	 * @param column_pidid 列定义主键集合
	 * @param column_rownum 列行号集合
	 * @throws BLException
	 */
	public void saveTableFormValue(IG500Info process,String[] column_value,String[] column_pidid,String[] column_rownum,Map<Integer, FormFile> fileMap,String fileStr,String fileDelStr) throws BLException;
	
	/**
	 * 保存资产表单中的资产信息
	 * 资产对应的表单信息不存在时抛异常
	 * @param processInfoList 表单值集合
	 * @param processInfoEntityMap 资产信息map
	 * @throws BLException
	 */
	public Map<String,String> saveProcessInfoEntity(List<IG599Info> processInfoList,Map<Integer, String> processInfoEntityMap) throws BLException;
	
	/**
	 * 功能：条件检索结果件数取得(可根据表单查询)
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int searchProcessCount(IG500SearchCond cond,String type)throws BLException;
	
	/**
	 * 根据检索条件（包括表单条件）取得流程信息列表（分页查询用）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessByType(IG500SearchCond cond, int start, int count,String type)throws BLException;
	
	/**
	 * <p>
	 * Description: 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 * @author liupeng@deliverik.com
	 */
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond);
	
	
	/**
	 * 根据流程主键查询流程类表单
	 * @param prid 流程主键
	 * @return 流程类表单集合
	 * @throws BLException
	 */
	public List<IG505Info> searchIG505InfoByprid(Integer prid) throws BLException;
	
	/**
	 * 根据流程主键查询人员类表单
	 * @param prid 流程主键
	 * @return 人员类表单集合
	 * @throws BLException
	 */
	public List<IG506Info> searchIG506InfoByprid(Integer prid) throws BLException;
	
	/**
	 * 根据流程主键查询流程与服务工单关系
	 * @param prid 流程主键
	 * @return 流程与服务工单关系实体集合
	 * @throws BLException
	 */
	public List<IG715Info> searchServiceProcessRecordRelationByPrid(Integer prid) throws BLException;
	
	/**
	 * 注册表格式表单值
	 * @param entity 表格式表单值实体
	 * @return 表格式表单值实体
	 * @throws BLException
	 */
	public IG898Info registTableFormValue(IG898Info entity) throws BLException;
	
	/**
	 * 表格式表单值查询
	 * @param cond 查询条件实体
	 * @return 表格式表单值集合
	 * @throws BLException
	 */
	public List<IG898Info> searchTableFormValue(IG898SearchCond cond) throws BLException;
	
	/**
	 * 主键检索表格式表单
	 * @param pk 主键
	 * @return 表格式表单实体
	 * @throws BLException
	 */
	public IG898Info searchTableFormValueByKey(IG898PK pk) throws BLException;
	
	/**
	 * 删除表格式表单值
	 * @param entitys 表格式表单实体集合
	 * @throws BLException
	 */
	public void deleteTableFormValue(List<IG898Info> entitys) throws BLException;
	
	/**
	 * 主键检索服务工单
	 * @param sfid 服务工单主键
	 * @return 服务工单信息
	 * @throws BLException
	 */
	public IG933Info searchServiceFormByKey(Integer sfid) throws BLException;
	
	/**
	 * 授权工作检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG463Info> searchProcessProxyWork(IG463SearchCond cond) throws BLException;
	
	/**
	 * 更新授权工作
	 * @param entity 授权工作实体
	 * @throws BLException
	 */
	public void updateProcessProxyWork(IG463Info entity) throws BLException;
	
	/**
	 * 用户授权检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG711Info> searchProcessAccredit(IG711SearchCond cond) throws BLException;
	
	/**
	 * 查询指定监管报表key关联的流程
	 * @param type 报表类型
	 * @param pdid 报表定义ID
	 * @param key 报表实例key
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 关联流程
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(String type, String pdid, String key, Boolean isClose) throws BLException;
	
	/**
	 * 功能：根据工单标识查询当前最大流水号
	 * @param prserialnum 工单标识
	 * @return 最大流水号
	 */
	public String searchMaxPrserialnum(String prserialnum);
	
	/**
	 * 检验当前状态所有参与者是否处理完成，
	 * 如果全部处理完成则按处理时间最后一个参与者的处理记录进行状态跃迁，
	 * 如果有参与者未处理则不做任何操作.
	 * 
	 * @param prid 流程ID
	 * @throws BLException 
	 */
	public void checkAllUserWorkDone(Integer prid) throws BLException;
	
	/**
	 * 获取流程当前状态显示名称
	 * @param prid 流程ID
	 * @return 流程当前状态显示名称
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException;
	
	/**
	 * 获取流程当前状态
	 * @param prid 流程ID
	 * @return 流程当前状态
	 */
	public List<String> searchCurrentStatus(Integer prid) throws BLException;
	
	/**
	 * 状态日志检索
	 * @param cond 检索条件 
	 * @return
	 */
	public List<IG224Info> searchProcessStatusLog(IG224SearchCond cond);
	
	/**
	 * 条件检索
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException;
	
	/**
	 * 校验是否是挂起状态
	 * @param prid 流程ID
	 * @param psdid 状态ID
	 * @return 是否是挂起状态
	 */
	public boolean checkPendStatus(Integer prid, String psdid);
	
    /**
     * 状态级私有表单值查询
     * @Title: searchStatusValue
     * @Description: 状态级私有表单值查询
     * @param pdid 流程id 待版本号
     * @param psdid 节点id
     * @param prid 可以为空（发起时）
     * @return Map</key pidid,value为默认值/实际存储值> 
     * @throws BLException
     */
    public Map<String,IG561Info> searchStatusValue(String pdid,String psdid,String prid) throws BLException;

    /**
     * 状态级私有表单保存或更新
     * @Title: registIG561Info
     * @Description: 状态级表单保存或更新
     * @param list599 表单列表
     * @param psdid 节点id
     * @param userid 用户id
     * @param entitySaveMap 资产保存后的map
     * @throws BLException
     * wyw
     */
    public void registIG561Info(List<IG599Info> list599, String psdid,String userid,Map<String,String> entitySaveMap) throws BLException;

    /** 
     * 
     * @Title: searchIG561VW 
     * @Description: TODO 状态级私有表单关闭节点查询
     * @param prid 流程id
     * @param userid 用户id
     * @return List<IG561VWInfo>    
     * List<IG561VWInfo>  已经有用户权限的IG560TB  
     * @throws BLException
     * wyw
     */
    public List<IG561VWInfo> searchIG561VW(String prid, String userid, boolean isAdmin)throws BLException;
    
    /**
     * @Description: 状态级私有表单值检索
     * @param cond 561状态级私有表单值记录表检索条件
     * @return List<IG561Info>
     */
    public List<IG561Info> searchIG561Info(IG561SearchCondImpl cond)throws BLException;

    /** 
     * @Title: searchProcessByTypeStatusAndParticanpant 
     * @Description:  旧的wkm流程查询 增加导出，重新封装查询列 
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> searchProcessByTypeStatusAndParticanpant(IG500SearchCond prSearchCond, int i, int j, String type)throws BLException;

    /**
     * @param prid 发起场景定义的流程id
     * @param emcproeiname 专项预案资产名称
     * @param sceneeiname 场景资产名称
     * @param scenepdid 场景定义流程的流程定义id
     * @param propentime 场景定义流程的流程发起时间
     * @throws BLException 
     */
    public void send(Integer prid,String emcproeiname,String sceneeiname,String scenepdid,String propentime) throws BLException;
    
    /**
     * 获取场景处理人信息
     * @param prid 发起场景定义流程的流程id
     * @return
     * @throws BLException
     */
    public List<UserRoleInfo> getSceneParticipant(Integer prid) throws BLException;
}
