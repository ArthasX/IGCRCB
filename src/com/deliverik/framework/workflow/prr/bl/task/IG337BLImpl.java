/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG337DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * 流程参与用户信息业务逻辑实现
 * </p>
 */
public class IG337BLImpl extends BaseBLImpl implements IG337BL {
	
	/**流程参与者操作*/
	IG337DAO ig337DAO;
	
	/**
	 * 设置流程参与者操作
	 * @param ig337DAO
	 */
	public void setIg337DAO(IG337DAO ig337DAO) {
		this.ig337DAO = ig337DAO;
	}
	
	/**
	 * <p>
	 * Description: 获取指定流程的发起者
	 * </p>
	 * 
	 * @param processId Integer
	 * @param openStatus String
	 * @return ProcessParticipant
	 */
	
	public IG337Info getProcessOpener(Integer processId,String openStatus){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPpstatus(openStatus);
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		if(ppList.isEmpty() && ppList.size() != 1){
			return null;
		}else{
			return ppList.get(0);
		}
	}
	
	/**
	 * <p>
	 * Description: 增加指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info ProcessParticipant
	 * @return ProcessParticipant
	 * @throws BLException
	 */
	
	public IG337Info registIG337Info(IG337Info ig337Info) throws BLException{
		return ig337DAO.save(ig337Info);
	}
	
	/**
	 * <p>
	 * 增加指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337InfoList List<ProcessParticipant>
	 * @throws BLException
	 */
	
	public void registIG337Info(List<IG337Info> ig337InfoList) throws BLException{
		ig337DAO.saveOrUpdateAll(ig337InfoList);
	}
	
	/**
	 * <p>
	 * Description: 删除指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info ProcessParticipant
	 * @throws BLException
	 */
	
	public void deleteIG337Info(IG337Info ig337Info) throws BLException{
		checkExistProcessParticipant(ig337Info.getPpid());
		ig337DAO.delete(ig337Info);
	}
	
	/**
	 * <p>
	 * Description: 删除指定流程的处理人员
	 * </p>
	 * 
	 * @param participants List<ProcessParticipant>
	 * @throws BLException
	 */
	
	public void deleteIG337Info(List<IG337Info> ig337InfoList) throws BLException{
		ig337DAO.delete(ig337InfoList);
	}
	
	/**
	 * <p>
	 * Description: 修改指定流程的处理人员
	 * </p>
	 * 
	 * @param ig337Info ProcessParticipant
	 * @return ProcessParticipant
	 * @throws BLException
	 */
	
	public IG337Info updateIG337Info(IG337Info ig337Info) throws BLException{
		checkExistProcessParticipant(ig337Info.getPpid());
		return ig337DAO.save(ig337Info);
	}
	
	/**
	 * <p>
	 * Description: 获取指定流程状态的未处理参与者
	 * </p>
	 * 
	 * @param processId Integer
	 * @param status String
	 * @return List<ProcessParticipant>
	 * @throws BLException
	 */
	
	public List<IG337Info> getIG337InfoTodoRoles(Integer processId, String status){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPpstatus(status);
		cond.setPpproctimeIsNull("Y");
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		return ppList;
	}
	
	/**
	 * <p>
	 * Description: 获取指定流程状态的已处理参与者
	 * </p>
	 * 
	 * @param processId Integer
	 * @param status String
	 * @return List<ProcessParticipant>
	 * @throws BLException
	 */
	
	public List<IG337Info> getIG337InfoDoneRoles(Integer processId, String status){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPpstatus(status);
		cond.setPpproctimeIsNull("N");
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		return ppList;
	}
	
	/**
	 * <p>
	 * Description: 根据流程ID和状态获取指定角色参与人员
	 * </p>
	 * 
	 * @param processId Integer
	 * @param roleid Integer
	 * @param status String
	 * @return ProcessParticipant
	 * @throws BLException
	 */
	
	public IG337Info getIG337Info(Integer processId, Integer roleid, String status){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPproleid(roleid);
		cond.setPpstatus(status);
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		if(ppList.isEmpty() && ppList.size() != 1){
			return null;
		}else{
			return ppList.get(0);
		}
	}
	
	/**
	 * <p>
	 * Description: 根据流程ID和状态获取指定角色参与人员
	 * </p>
	 * 
	 * @param processId Integer
	 * @param userid Integer
	 * @param status String
	 * @return ProcessParticipant
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IG337Info getIG337Info(Integer processId, String userid, String status){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPpuserid(userid);
		cond.setPpstatus(status);
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		if(ppList == null || ppList.size() != 1){
			return null;
		}else{
			return ppList.get(0);
		}
	}

	/**
	 * <p>
	 * Description: 根据流程ID和状态获取指定角色的参与人员
	 * </p>
	 * 
	 * @param processId Integer
	 * @param roleid Integer
	 * @param status String
	 * @return List<ProcessParticipant>
	 * @throws BLException
	 */
	
	public List<IG337Info> getIG337Infos(Integer processId, Integer roleid, String status) throws BLException{
		if(processId == null || processId == 0) {
			throw new BLException("IGCO10000.E004","流程ID");
		}
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPproleid(roleid);
		cond.setPpstatus(status);
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		return ppList;
	}
	
	/**
	 * <p>
	 * Description: 根据流程ID和处理状态获取未处理人员总数
	 * </p>
	 * 
	 * @param processId Integer
	 * @param status String
	 * @return int
	 * @throws BLException
	 */
	
	public int getTodoIG337InfoCount(Integer processId, String status){
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(processId);
		cond.setPpstatus(status);
		cond.setPpproctimeIsNull("Y");
		List<IG337Info> ppList = ig337DAO.findByCond(cond, 0, 0);
		return ppList.size();
	}
	
	/**
	 * <p>
	 * Description: 获取参与者实例
	 * </p>
	 * 
	 * @return ProcessParticipantTB
	 * @throws BLException
	 */
	
	public IG337TB getIG337TBInstance(){
		return new IG337TB();
	}
	
	/**
	 * <p>
	 * Description: 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 */
	
	public List<IG337Info> getIG337Infos(IG337SearchCond cond){
		return ig337DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * Description: 获取指定参与者
	 * </p>
	 * 
	 * @param ppid Integer
	 * @return ProcessParticipant
	 * @throws BLException 
	 */
	
	public IG337Info searchIG337InfoByKey(Integer ppid) throws BLException{
		return checkExistProcessParticipant(ppid);
	}
	
	/**
	 * 指定用户负责的流程处理角色检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG337Info> queryRolemanager(String userid, Integer prid) {
		return ig337DAO.queryRolemanager(userid, prid);
	}
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchIG602Info(String userid, Integer prid) {
		return ig337DAO.searchIG602Info(userid, prid);
	}
	
	/**
	 * 流程可分派人检索处理
	 * @param roleid 角色ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid) {
		return ig337DAO.searchSuperAssignExecutors(roleid, prid);
	}
	
	/**
	 * 参与者信息存在检查
	 * 
	 * @param ppid 参与者ID
	 * @return 参与者信息
	 * @throws BLException 
	 */
	protected IG337Info checkExistProcessParticipant(Integer ppid) throws BLException{
		IG337Info info = ig337DAO.findByPK(ppid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","参与者基本");
		}
		
		return info;
	}
	
	/**
	 * <p>
	 * Description: 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 * @author liupeng@deliverik.com
	 */
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond){
		return ig337DAO.findByCondRun(cond);
	}

	/**
     * <p>
     * Description: 查询流程参与者进行中的工作数量
     * </p>
     * 
     * @param cond ProcessParticipantSearchCond
     * @return List<ProcessParticipant>
     */
    public int searchParticipateNumberOfJobs(IG337SearchCond cond){
        return ig337DAO.getCountByCond(cond);
    }
}
