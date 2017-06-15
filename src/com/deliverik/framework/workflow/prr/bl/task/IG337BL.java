/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * 流程参与用户信息业务逻辑
 * </p>
 */
public interface IG337BL extends BaseBL {

	/**
	 * <p>
	 * 增加指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info 流程参与用户信息
	 * @return 流程参与用户信息
	 * @throws BLException
	 */
	
	public IG337Info registIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * 增加指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337InfoList 流程参与用户信息集合
	 * @throws BLException
	 */
	
	public void registIG337Info(List<IG337Info> ig337InfoList) throws BLException;
	
	/**
	 * <p>
	 * 删除指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info 流程参与用户信息
	 * @throws BLException
	 */
	
	public void deleteIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * 删除指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337InfoList 流程参与用户信息集合
	 * @throws BLException
	 */
	
	public void deleteIG337Info(List<IG337Info> ig337InfoList) throws BLException;
	
	/**
	 * <p>
	 * 修改指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info 流程参与用户信息
	 * @return 流程参与用户信息
	 * @throws BLException
	 */
	
	public IG337Info updateIG337Info(IG337Info ig337Info) throws BLException;
	
	/**
	 * <p>
	 * 获取指定流程状态的未处理流程参与用户
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param status 流程状态
	 * @return 未处理流程参与用户集合
	 */
	
	public List<IG337Info> getIG337InfoTodoRoles(Integer processId, String status);
	
	/**
	 * <p>
	 * 获取指定流程状态的已处理流程参与用户
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param status 流程状态
	 * @return 已处理流程参与用户集合
	 */
	
	public List<IG337Info> getIG337InfoDoneRoles(Integer processId, String status);
	
	/**
	 * <p>
	 * 根据流程ID和状态获取指定角色的参与人员
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param roleid 角色ID
	 * @param status 流程状态
	 * @return 流程参与用户信息
	 */
	
	public IG337Info getIG337Info(Integer processId, Integer roleid, String status);
	
	/**
	 * <p>
	 * 根据流程ID和状态获取指定参与人员
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param userid 用户ID
	 * @param status 流程状态
	 * @return 流程参与用户信息
	 */
	
	public IG337Info getIG337Info(Integer processId, String userid, String status);

	/**
	 * <p>
	 * 根据流程ID和状态获取指定参与人员
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param status 流程状态
	 * @return 流程参与用户信息集合
	 */
	
	public List<IG337Info> getIG337Infos(Integer processId, Integer roleid, String status) throws BLException;
	
	/**
	 * <p>
	 * 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond 流程参与用户信息检索条件
	 * @return 流程参与用户信息集合
	 */
	
	public List<IG337Info> getIG337Infos(IG337SearchCond cond);
	
	/**
	 * <p>
	 * 根据流程ID和状态获取未处理人员总数
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @param status 流程状态
	 * @return 结果总数
	 */
	
	public int getTodoIG337InfoCount(Integer processId, String status);
	
	/**
	 * <p>
	 * 获取流程参与用户实例
	 * </p>
	 * 
	 * @return 流程参与用户信息实体
	 */
	
	public IG337TB getIG337TBInstance();
	
	/**
	 * <p>
	 * 根据参与者ID获取指定参与者信息
	 * </p>
	 * 
	 * @param ppid 参与者ID
	 * @return 参与者信息
	 * @throws BLException 
	 */
	
	public IG337Info searchIG337InfoByKey(Integer ppid) throws BLException;
	
	/**
	 * 指定用户负责的流程处理角色检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG337Info> queryRolemanager(final String userid , final Integer prid);
	
	/**
	 * <p>
	 * 获取指定流程的发起者
	 * </p>
	 * 
	 * @param processId 流程ID
	 * @param openStatus 流程参与用户状态
	 * @return 流程参与用户信息
	 */
	
	public IG337Info getProcessOpener(Integer processId,String openStatus);
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchIG602Info(String userid, Integer prid);
	
	/**
	 * 流程可分派人检索处理
	 * @param roleid 角色ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid);

	/**
	 * <p>
	 * 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond 流程参与用户信息检索条件
	 * @return 流程参与用户信息集合
	 */
	
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond);
	
	/**
     * <p>
     * Description: 查询流程参与者进行中的工作数量
     * </p>
     * 
     * @param cond ProcessParticipantSearchCond
     * @return List<ProcessParticipant>
     */
    public int searchParticipateNumberOfJobs(IG337SearchCond cond);
}
