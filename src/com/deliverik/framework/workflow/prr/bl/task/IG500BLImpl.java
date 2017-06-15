/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG500DAO;
import com.deliverik.framework.workflow.prr.model.dao.IG677DAO;
import com.deliverik.framework.workflow.prr.model.dao.IG808DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;

/**
 * <p>
 * 流程记录信息业务逻辑实现
 * </p>
 */

public class IG500BLImpl  extends BaseBLImpl implements IG500BL{
	
    // 二次开发log
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);

	/** 角色组织架构关系表DAO接口 */
	protected RehearseDAO rehearseDAO;

	/**IG500DAO操作*/
	protected IG500DAO ig500DAO;
	
	/** 注入IG677DAO */
	protected IG677DAO ig677DAO;
	
	protected IG787BL ig787BL;
	
	/** 流程策略信息BL */
	protected IG105BL ig105BL;
	
	/** 流程定义信息BL */
	protected IG380BL ig380BL;

	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}
	
	public void setIg787BL(IG787BL ig787BL) {
		this.ig787BL = ig787BL;
	}
	
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * 设置流程基本信息操作
	 * @param ig500DAO IG500DAO
	 */
	
	public void setIg500DAO(IG500DAO ig500DAO){
		this.ig500DAO = ig500DAO;
	}

	/**
	 * 设置ProcessRecordVWDAO
	 * 
	 * @param ig677DAO
	 *            IG677DAO
	 */

	public void setIg677DAO(IG677DAO ig677DAO) {
		this.ig677DAO = ig677DAO;
	}
	
	
	/**
	 * 注入OrganizationProcessCountVWDAO
	 */

	protected IG808DAO ig808DAO;
	
	public void setIg808DAO(
			IG808DAO ig808DAO) {
		this.ig808DAO = ig808DAO;
	}
	
	/**
	 * 流程策略信息BL设定
	 * @param Ig105BL流程策略信息BL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}


	/**
	 * <p>
	 * 创建流程实例
	 * </p>
	 * 
	 * @param ig500Info 流程记录
	 * @return 流程记录
	 * @throws BLException
	 */

	public synchronized IG500Info registIG500Info(IG500Info ig500Info)
			throws BLException{
		IG500TB prTB = getIG500TBInstance();
		this.copyProperties(prTB,ig500Info);
		IG380Info ig380Info = null;
		if(StringUtils.isNotEmpty(ig500Info.getPrpdid())) {
			prTB.setPrStrategyVersion(this.ig105BL.getMaxgPsdversion(ig500Info.getPrpdid()));
			ig380Info = this.ig380BL.searchIG380InfoByKey(ig500Info.getPrpdid());
		}
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			//自定义流程在此处不生成工单号，改在发起之后生成
//			WorkFlowSerialnumGeneratorBL bl = null;
//			try {
//				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
//			} catch (Exception e) {
//				throw new BLException("IGCO10000.E004", "工单号生成器定义");
//			}
//			igflowlog.debug("========================工单号生成事件开始========================");
//			igflowlog.debug("流程类型名称:" + ig500Info.getPrpdname());
//			igflowlog.debug("流程类型ID:" + ig500Info.getPrpdid());
//			igflowlog.debug("流程标题:" + ig500Info.getPrtitle());
//			igflowlog.debug("调用BL:" + ig380Info.getSerialgenerator());
//			prTB.setPrserialnum(bl.serialnumGenerator());
//			igflowlog.debug("生成工单号:" + prTB.getPrserialnum());
//			igflowlog.debug("========================工单号生成事件结束========================");
		} else {
			prTB.setPrserialnum(this.getSerialNum(ig500Info.getPrtype()));
		}
		return ig500DAO.save(prTB);
	}

	/**
	 * <p>
	 * Description: 更新流程信息
	 * </p>
	 * 
	 * @param ig500Info ProcessRecord
	 * @return ProcessRecord
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IG500Info updateIG500Info(IG500Info ig500Info)
			throws BLException{
		checkExistProcessRecord(ig500Info.getPrid());
		ig500Info = ig500DAO.save(ig500Info);
		return ig500Info;
	}

	/**
	 * <p>
	 * 检索流程记录信息
	 * </p>
	 * 
	 * @param cond 流程记录信息检索条件
	 * @return 流程记录信息列表
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(IG500SearchCond cond){
		/*List<ProcessRecord> prList = ig500DAO.findByCond(cond, 0, 0);
		List<ProcessRecord> incidentList = new ArrayList<ProcessRecord>();
		List<ProcessRecord> allList = new ArrayList<ProcessRecord>();
		for(ProcessRecord pr : prList){
			if("I".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;*/
		return ig500DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * 检索流程记录信息
	 * </p>
	 * 
	 * @param cond 流程记录信息检索条件
	 * @param start 检索起始条数
	 * @param count 检索条数
	 * @return 流程记录信息列表
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(
			IG500SearchCond cond, int start, int count){
		return ig500DAO.findByCond(cond, start, count);
	}
	
	
	
	/**
	 * 演练流程查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchDrillProcess(IG500SearchCond cond, int start,  int count){
		return ig500DAO.searchDrillProcess(cond, start, count);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count){
		return ig500DAO.queryIG500EntityListByProcessInfo(cond, start, count);
	}

	/**
	 * <p>
	 * 根据流程记录ID获取流程记录信息
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @return 流程记录
	 * @throws BLException 
	 */
	
	public IG500Info searchIG500InfoByKey(Integer processId) throws BLException{
		return checkExistProcessRecord(processId);
	}
	
	/**
	 * 获取流程记录实例
	 * @return ProcessRecordTB
	 * @throws BLException
	 */
	
	public IG500TB getIG500TBInstance(){
		return new IG500TB();
	}
	
	/**
	 * <p>
	 * 检索流程记录总数
	 * </p>
	 * 
	 * @param cond 流程记录检索条件
	 * @return 流程记录总数
	 */
	
	public int getIG500InfoSearchCount(IG500SearchCond cond){
		return ig500DAO.getSearchCount(cond);
	}
	
	protected String getSerialNum(String processType){
		String serialNum = "";
		if(WorkFlowConstDefine.FLOW_NUMBER_0.equals(WorkFlowConstDefine.WORKFLOW_SERIALNUM_MODE)){
			int leftPad_index = 0;
			//监管报表
			int type_length = processType.length();
			if(type_length == 1){
				leftPad_index =  5 ;
			}else if(type_length == 2){
				leftPad_index =  4 ;
			}else if(type_length == 3){
				leftPad_index =  3 ;
			}
	//		if(processType.length() > 1){
	//			processType = processType.substring(0,1);
	//		}
			Calendar c = Calendar.getInstance();
			serialNum = processType + String.valueOf(c.get(Calendar.YEAR)).substring(2);
			String maxSerialNum =  ig500DAO.getMaxPrserialnum(serialNum);
			if(null == maxSerialNum){
				return serialNum + StringUtils.leftPad("1", leftPad_index ,"0");
			}
			String num = "";
			if(processType.length() == 3){
				num = maxSerialNum.substring(5);
			}else if(processType.length() == 2){
				num = maxSerialNum.substring(4);
			}else if(processType.length() == 1){
				num = maxSerialNum.substring(3);
			}
			
			int maxNumber = Integer.valueOf(num) + 1;
			serialNum = serialNum + StringUtils.leftPad(String.valueOf(maxNumber), leftPad_index ,"0");
		}else if(WorkFlowConstDefine.FLOW_NUMBER_1.equals(WorkFlowConstDefine.WORKFLOW_SERIALNUM_MODE)){
			Calendar c = Calendar.getInstance();
			int leftPad_index = 0;
			//监管报表
			int type_length = processType.length();
			if(type_length == 1){
				leftPad_index =  4 ;
			}else if(type_length == 2){
				leftPad_index =  3 ;
			}else if(type_length == 3){
				leftPad_index =  2 ;
			}
			serialNum = processType + String.valueOf(c.get(Calendar.YEAR)).substring(2) + IGStringUtils.getCurrentDate().substring(5, 7) + IGStringUtils.getCurrentDate().substring(8, 10);;
			String maxSerialNum =  ig500DAO.getMaxPrserialnum(serialNum);
			if(null == maxSerialNum){
				
				return serialNum + StringUtils.leftPad("1", leftPad_index ,"0");
			}
			String num = "";
			if(processType.length() == 3){
				num = maxSerialNum.substring(9);
			}else if(processType.length() == 2){
				num = maxSerialNum.substring(8);
			}else if(processType.length() == 1){
				num = maxSerialNum.substring(7);
			}
			int maxNumber = Integer.valueOf(num) + 1;
			serialNum = serialNum + StringUtils.leftPad(String.valueOf(maxNumber), leftPad_index ,"0");
		}
		return serialNum;
	}
	
	/**
	 * 服务请求条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count) {
		return ig500DAO.queryServiceRequestList(cond, start, count);
	}
	
	/**
	 * 服务请求条件检索记录数
	 * @return 条件检索记录数
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond){
		return ig500DAO.queryServiceRequestListCount(cond);
	}
	
	/**
	 * 流程(包含事件处理子状态）条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count) {
		/*List<ProcessRecord> prList = ig500DAO.queryProcessRecordSubStatusList(cond, start, count);
		List<ProcessRecord> incidentList = new ArrayList<ProcessRecord>();
		List<ProcessRecord> allList = new ArrayList<ProcessRecord>();
		for(ProcessRecord pr : prList){
			if("I".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}else if("ID".equals(pr.getPrtype())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;*/
		return ig500DAO.queryIG500InfoSubStatusList(cond, start, count);
	}
	
	
	/**
	 * 流程(包含事件处理子状态）条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count) {
		return ig500DAO.queryIG500ONLYInfoSubStatusList(cond, start, count);
	}
	
	/**
	 * 流程(包含事件处理子状态）条件检索记录数
	 * @return 条件检索记录数
	 */
	public int queryIG500InfoSubStatusListCount(IG500SearchCond cond){
		return ig500DAO.queryIG500InfoSubStatusListCount(cond);
	}
	
	/**
	 * 流程(包含事件处理子状态）条件检索记录数
	 * @return 条件检索记录数
	 */
	public int queryIG500ONLYInfoSubStatusListCount(IG500SearchCond cond){
		return ig500DAO.queryIG500ONLYInfoSubStatusListCount(cond);
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond){
		return ig500DAO.queryIG500EntityCount(cond);
	}

	
	/**
	 * <p>
	 * 获取指定角色所有的待办流程记录
	 * </p>
	 * 
	 * @param roleId 角色ID
	 * @param prType 流程记录类型
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByRole(Integer roleId,
			String prType) {

		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPproleid(roleId);
		cond.setPrtype(prType);
		cond.setTodo(true);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	
	/**
	 * <p>
	 * 获取指定用户所有的待办流程记录
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @param prType 流程记录类型
	 * @param pdid 流程定义ID
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByUser(String userId,
			String prType,String pdid,String prstatus) {
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPpuserid(userId);
		cond.setPrtype(prType);
		cond.setPrpdid(pdid);
		cond.setPpstatus(prstatus);
		cond.setTodo(true);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		
		//查询自定义流程（包含授权的流程）
//		ProcessRecordSearchCondImpl cond1 = new ProcessRecordSearchCondImpl();
//		cond1.setPrActive("Y");//未关闭
//		cond1.setUserid_q(userId2);
//		List<ProcessRecord> processRecordList = searchProcessRecordForSelfDef(cond1,0,0);
		
		//List<ProcessRecordInfo> prList = new ArrayList<ProcessRecordInfo>();
		
//		for(ProcessRecordInfo pri : temp_prList){
//			for(ProcessRecord pr:processRecordList){
//				if(pri.getPrid().equals(pr.getPrid())){
//					prList.add(pri);
//					break;
//				}
//				
//			}
//		}
		
		
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}
	
	/**
	 * <p>
	 * 查询流程相关的共通变量信息
	 * </p>
	 * 
	 */
	public List<String> getProcessInfoDefGeneral(List<IG677Info> list, Integer pidGeneralId) {
		List<String> varlist = new ArrayList<String>();
		
		for(IG677Info pr:list){

			//查询是否存在共通变量
			IG787SearchCondImpl pigcond = new IG787SearchCondImpl();
			pigcond.setPrid(pr.getPrid());
			pigcond.setPidgid(pidGeneralId);
			List<IG787Info> pigList  = ig787BL.findByCond(pigcond, 0, 0);
			
			if(pigList!=null && pigList.size()>0){
				varlist.add(pigList.get(0).getGeneralvalue().length()>=5?pigList.get(0).getGeneralvalue().substring(5):pigList.get(0).getGeneralvalue());
			}else{
				varlist.add("");
			}
				
		}
			
		return varlist;
	}
	
	
//	/**
//	 * <p>
//	 * 根据检索条件获取流程记录与参与用户信息结果条数
//	 * </p>
//	 * 
//	 * @param ProcessRecordInfoSearchCond 流程记录与参与用户信息检索条件
//	 * @return 流程记录与参与用户信息结果集合
//	 */
//
//	public int getSearchCount(ProcessRecordInfoSearchCond cond) {
//		return ig677DAO.getSearchCount(cond);
//	}
	
	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @param start 检索起始条数
	 * @param count 检索总条数
	 * @return 流程记录与参与用户信息结果集合
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond, int start, int count){
		List<IG677Info> prList = ig677DAO.findByCond(cond, start, count);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		
		for(IG677Info pr : prList){
			if("01080".equals(pr.getPrpdid())&&StringUtils.isEmpty(pr.getPrclosetime())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	
	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @return 流程记录与参与用户信息结果集合
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond){
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
		    if("01080".equals(pr.getPrpdid())&&StringUtils.isEmpty(pr.getPrclosetime())){
                incidentList.add(pr);
            }
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}

	/**
	 * <p>
	 * 根据检索条件获取流程记录与参与用户信息结果条数
	 * </p>
	 * 
	 * @param cond 流程记录与参与用户信息检索条件
	 * @return 流程记录与参与用户信息结果集合
	 */
	public int getProcessRecordVWSearchCount(IG677SearchCond cond) {
		return ig677DAO.getSearchCount(cond);
	}

	
	/**
	 * 流程记录信息存在检查
	 * 
	 * @param prid 流程记录ID
	 * @return  流程记录信息
	 * @throws BLException 
	 */
	private IG500Info checkExistProcessRecord(Integer processId) throws BLException{
		IG500Info info = ig500DAO.findByPK(processId);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程记录基本");
		}
		
		return info;
	}
	
	/**
	 * 根据流程记录信息主键删除流程记录信息处理
	 * 
	 * @param prid 删除流程记录信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecordByKey(Integer prid) throws BLException{
		IG500Info processRecord = checkExistProcessRecord(prid);
		ig500DAO.delete(processRecord);
	}
	
	/**
	 * 删除流程记录信息处理
	 * 
	 * @param processRecord 删除的流程记录信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecord(IG500Info processRecord) throws BLException{
		checkExistProcessRecord(processRecord.getPrid());
		ig500DAO.delete(processRecord);
	}
	
	/**
	 * 指定用户未处理流程条件检索处理
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid){
		return ig500DAO.queryActiveProcessByUserid(userid);
	}
	
	/**
	 * <p>
	 * 获取流程分派者角色所有的待办流程记录
	 * </p>
	 * 
	 * @param roleId 流程分派者角色ID
	 * @param prType 流程记录类型
	 * @return 流程记录与参与用户信息结果集合
	 */
	public List<IG677Info> getTodoProcessRecordsByFPRole(Integer roleId,
			String prType) {

		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPproleid(roleId);
		cond.setPrtype(prType);
		cond.setPrstatus(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		cond.setPpstatus(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		List<IG677Info> prList = ig677DAO.findByCond(cond, 0, 0);
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> allList = new ArrayList<IG677Info>();
		for(IG677Info pr : prList){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		allList.addAll(incidentList);
		prList.removeAll(incidentList);
		allList.addAll(prList);
		return allList;
	}
	
	/**
	 * 检测指定用户是否具有指定流程查看权限（目前只支持变更，发布）
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 权限标识
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid){
		return ig500DAO.checkLookDetailPermission(userid, prid);
	}
	
	/**
	 * 当流程指定到角色时,在角色负责人的我的工作中显示此条流程信息
	 * @param userid 用户ID
	 * @return 
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid){
		return ig500DAO.queryActiveProcessByFPRoleid(userid);
	}
	
	/**
	 * 流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryProcessRecordEntityList(final IG500SearchCond cond, final int start, final int count) {
		List<IG500Info> prList = ig500DAO.queryIG500EntityList(cond, start, count);
		return prList;
	}

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
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return ig500DAO.queryCorrelationProcessByUserid(cond, start, count, closeFlag, dealFlag);
	}
	
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
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return ig500DAO.queryCorrelationProcessByUseridCount(cond, start, count, closeFlag, dealFlag);
	}
	
	/**
	 * 指定角色未处理流程条件检索处理
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid){
		return ig500DAO.queryActiveProcessByRoleid(roleid);
	}
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond){
		return ig500DAO.searchIG500CountForSelfDef(cond);
	}
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count){
		return ig500DAO.searchIG500InfoForSelfDef(cond,start,count);
	}
	
	/**
	 * 自定义流程相关工作条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond){
		return ig500DAO.searchIG500InfoCountForRelatedWork(cond);
	}
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count){
		return ig500DAO.searchIG500InfoForRelatedWork(cond,start,count);
	}
	
	/**
	 * 首页上按部门统计工作数量查询处理
	 * @return 检索结果列表
	 */
	public List<IG808Info> getOrganizationProcessCount(){
		return ig808DAO.findIG808Info();
	}
	
	/**
	 * 功能：根据工单标识查询当前最大流水号
	 * @param prserialnum 工单标识
	 * @return 最大流水号
	 */
	public String searchMaxPrserialnum(String prserialnum) {
		return ig500DAO.getMaxPrserialnum(prserialnum);
	}
	
	/**
	 * 功能：根据用处理人id取得发文流程列表
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchDispatchStatistics(IG677SearchCond cond, int start, int count){
		return ig500DAO.searchDispatchStatisticsVW(cond,start,count);
	}
	
	/**
	 * 功能：根据用处理人id取得发文流程列表数量
	 * @return 记录总数
	 */
	public int findDispatchStatisticsSearchCount(IG677SearchCond cond){
		return ig500DAO.findDispatchStatisticsSearchCount(cond);
	}
	
	/**
	 * 查询指定监管报表key关联的流程
	 * @param type 报表类型
	 * @param pdid 报表定义ID
	 * @param key 报表实例key
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 关联流程
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException{
		return ig500DAO.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	}

	public List<IG500Info> searchProcessByType(IG500SearchCond cond,int start,int count, String type)
			throws BLException {
		//如果流程类型是查询所有工单信息
		if(IGPRDCONSTANTS.SEARCH_ALL_PROCESS.equals(type)){
			return ig500DAO.queryIG500EntityListByProcessInfo(cond,start,count);
		}
		//如果流程类型是查询我自己的工单信息
		if(IGPRDCONSTANTS.SEARCH_MY_PROCESS.equals(type)){
			return ig500DAO.searchMyProcess(cond,start,count);
		}
		//如果流程类型是查询同机构的工单信息
		if(IGPRDCONSTANTS.SEARCH_ORG_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByOrg(cond,start,count);
		}
		//如果流程类型是查询同角色的工单信息
		if(IGPRDCONSTANTS.SEARCH_ROLE_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByRole(cond,start,count);
		}
		//如果流程类型是查询我自己处理过的工单信息
		if(IGPRDCONSTANTS.SEARCH_MY_UN_PROCESSED.equals(type)){
			return ig500DAO.searchMyUnProcessd(cond,start,count);
		}
		return null;
	}

	public Integer searchProcessByTypeCount(IG500SearchCond cond,
			String type) throws BLException {
		//如果流程类型是查询所有工单信息
		if(IGPRDCONSTANTS.SEARCH_ALL_PROCESS.equals(type)){
			return ig500DAO.queryIG500EntityCount(cond);
		}
		//如果流程类型是查询我自己的工单信息
		if(IGPRDCONSTANTS.SEARCH_MY_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessCount(cond);
		}
		//如果流程类型是查询同机构的工单信息
		if(IGPRDCONSTANTS.SEARCH_ORG_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByOrgCount(cond);
		}
		//如果流程类型是查询同角色的工单信息
		if(IGPRDCONSTANTS.SEARCH_ROLE_PROCESS.equals(type)){
			return ig500DAO.searchMyProcessByRoleCount(cond);
		}
		return 0;
	}
	
	/**
	 * 获取流程当前状态显示名称
	 * @param prid 流程ID
	 * @return 流程当前状态显示名称
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException {
		return this.ig500DAO.searchCurrentStatusName(prid);
	}
	
	/**
	 * 获取流程当前状态
	 * @param prid 流程ID
	 * @return 流程当前状态
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException {
		return this.ig500DAO.searchCurrentStatus(prid);
	}
	
	/**
	 * 条件检索
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException {
		return ig677DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * dashboard
	 *	风险评估工作总体情况 问题数量
	 * @param months
	 * @return List<Map>
	 * <p>
	 * 	map 结构   key :(DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT)
	 * </p>
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getRiskAssess (String months,String prpdid)throws BLException{
		return ig500DAO.getRiskAssess(months,prpdid);
	}
	
	/**
	 * 问题整改
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchIssueCorrectiveInfo(cond, start, count);
	}
	
	/**
	 * 问题整改 根据领域钻取
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchIssueCorrectiveByField(cond, start, count);
	}
		/** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO 查询ig500 和流程状态，当前流程状态的参与者
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> queryIG500WithStatusAndPart(IG500SearchCond prSearchCond, int i, int j)throws BLException{
        return ig500DAO.queryIG500WithStatusAndPart( prSearchCond,  i,  j);
    }
    /**
     * 查询应急处置流程
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count){
    	return ig500DAO.getDrmFlow(cond, start, count);
    }
    
    /**
     * 查询应急处置流程数量
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public Integer countDrmFlow(final IG500SearchCond cond){
    	return ig500DAO.countDrmFlow(cond);
    }
}
