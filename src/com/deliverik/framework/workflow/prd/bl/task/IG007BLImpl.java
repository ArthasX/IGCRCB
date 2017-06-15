/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG007DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>概述:流程变量定义业务逻辑实现</p>
 * <p>功能描述：1.获取流程变量定义实例</p>
 * <p>          2.获取流程变量集合</p>
 * <p>          3.获取流程变量集合，不包括缺省变量</p>
 * <p>          4.获取流程变量缺省审批人</p>
 * <p>          5.获取流程变量缺省一级审批人</p>
 * <p>          6.获取流程变量缺省二级审批人</p>
 * <p>          7.获取流程变量缺省三级审批人</p>
 * <p>          8.构造审批人List集合</p>
 * <p>  	    9.check相等</p>
 * <p>			10.获取流程变量缺省审批分派人(ppcomment获取之后不用要清空)</p>
 * <p>			11.条件检索结果件数取得</p>
 * <p>			12.全部检索处理</p>
 * <p>			13.条件检索处理</p>
 * <p>			14.流程变量ID查询处理</p>
 * <p>			15.登录处理</p>
 * <p>			16.更新处理</p>
 * <p>			17.删除处理</p>
 * <p>			18.全局变量存在检查</p>
 * <p>创建记录：</p>
 */
public class IG007BLImpl extends BaseBLImpl implements IG007BL {
	
	/**流程变量操作*/
	protected IG007DAO ig007DAO;
	
	/**
	 * 功能:设置流程变量操作设定
	 * @param IG007DAO
	 */
	public void setIg007DAO(IG007DAO ig007DAO) {
		this.ig007DAO = ig007DAO;
	}

	/**
	 * 功能：获取流程变量定义实例
	 * @return IG007TB
	 */
	
	public IG007TB getIG007TBInstance(){
		return new IG007TB();
	}
	
	/**
	 * 功能：获取流程变量集合
	 * @param pdid 流程定义ID
	 * @return  List<ProcessInfoDef> 流程变量集合
	 */
	
	public List<IG007Info> searchIG007InfoByPdid(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		return ig007DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：获取流程变量集合，不包括缺省变量
	 * @param pdid 流程定义ID
	 * @return  List<ProcessInfoDef> 流程变量集合
	 */
	
	public List<IG007Info> searchIG007InfoNoDefault(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		cond.setIsDefault(WorkFlowConstDefine.NO);
		return ig007DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：获取流程变量缺省审批人
	 * @param pdid 流程定义ID
	 * @return  Map<String,List<IG337Info>> 流程变量缺省审批人
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid){
		List<IG337Info> one = null;
		//二级审批人List
		List<IG337Info> two = null;
		//三级审批人List
		List<IG337Info> three = null;
		Map<String,List<IG337Info>> map = new HashMap<String,List<IG337Info>>();
		if(StringUtils.isNotEmpty(pdid)){
			one = this.getDefaultApprovorsOne(pdid);
			two = this.getDefaultApprovorsTwo(pdid);
			three = this.getDefaultApprovorsThree(pdid);
		}
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE, one);
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO, two);
		map.put(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE, three);
		return map;
	}
	
	/**
	 * 功能：获取流程变量缺省一级审批人
	 * @param processDefinitionId 流程定义ID
	 * @return  List<ProcessParticipant> 流程变量缺省一级审批人
	 */
	
	public List<IG337Info> getDefaultApprovorsOne(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//流程类型ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE);//缺省一级审批人标识
		List<IG337Info> approvorsList = null;
		//流程变量List
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//审批人个数
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//拆分属性字符串
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_ONE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	/**
	 * 功能：获取流程变量缺省二级审批人
	 * @param processDefinitionId 流程定义ID
	 * @return  List<ProcessParticipant> 流程变量缺省二级审批人
	 */
	
	public List<IG337Info> getDefaultApprovorsTwo(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//流程类型ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO);//缺省二级审批人标识
		List<IG337Info> approvorsList = null;
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//审批人个数
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//拆分属性字符串
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_TWO, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	/**
	 * 功能：获取流程变量缺省三级审批人
	 * @param processDefinitionId 流程定义ID
	 * @return  List<ProcessParticipant> 流程变量缺省三级审批人
	 */
	
	public List<IG337Info> getDefaultApprovorsThree(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);//流程类型ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE);//缺省三级审批人标识
		List<IG337Info> approvorsList = null;
		List<IG007Info> pidList = ig007DAO.findByCond(cond, 0, 0);
		//审批人个数
		int len = 0;
		for(IG007Info pid : pidList) {
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname()) && StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] approvors = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//拆分属性字符串
				len = approvors.length;
				break;
			}
		}
		if(len != 0) {
			approvorsList = this.createProcessParticipants(len);
			for(IG007Info pid : pidList) {
				if(StringUtils.isNotEmpty(pid.getPiddesc())) {
					String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);
					if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPproleid(Integer.parseInt(propertys[i]));
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPprolename(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpuserid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPpusername(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgid(propertys[i]);
						}
					} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_THREE, pid.getPidname())) {
						for(int i = 0; i < len; i++) {
							((IG337TB)approvorsList.get(i)).setPporgname(propertys[i]);
						}
					}
				}
			}
		}
		return approvorsList;
	}
	
	/**
	 * 功能：构造审批人List集合
	 * @param size int
	 * @return  List<ProcessParticipant> 审批人List集合
	 */
	private List<IG337Info> createProcessParticipants(int size) {
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		for(int i = 0; i < size; i++) {
			ppList.add(new IG337TB());
		}
		return ppList;
	}
	
	/**
	 * 功能：check相等
	 * @param left String 非null
	 * @param right String
	 * @return  boolean
	 */
	private boolean checkEqual(String left, String right) {
		return left.equals(right);
	}
	
	/**
	 * 功能：获取流程变量缺省审批分派人(ppcomment获取之后不用要清空)
	 * @param pdid 流程定义ID
	 * @return  List<IG337Info> 流程变量缺省审批分派人
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//流程类型ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVEDISPATCHER);//缺省审批分派人标识
		List<IG337Info> approvorsList = new ArrayList<IG337Info>();
		List<IG007Info> list = ig007DAO.findByCond(cond, 0, 0);
		for(IG007Info pid : list) {
			if(StringUtils.isNotEmpty(pid.getPiddesc())) {
				String[] propertys = pid.getPiddesc().split(WorkFlowConstDefine.SPILT_APPROVORS,-1);//拆分审批分派人属性
				//构造审批人
				IG337TB pp = new IG337TB();
				pp.setPproleid(Integer.parseInt(propertys[0]));
				pp.setPprolename(propertys[1]);
				pp.setPpuserid(propertys[2]);
				pp.setPpusername(propertys[3]);
				pp.setPporgid(propertys[4]);
				pp.setPporgname(propertys[5]);
				pp.setPpcomment(pid.getPidid().toString());//获取之后不用要清空
				approvorsList.add(pp);
			}
		}
		return approvorsList;
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG007InfoSearchCount(IG007SearchCond cond){
		
		return ig007DAO.getSearchCount(cond);
	}
	
	/**
	 * 功能：全部检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond){
		return ig007DAO.findByCond(cond,0,0);
	}
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond, int start, int count){
		
		return ig007DAO.findByCond(cond,start,count);
	}
	
	/**
	 * 功能：流程变量ID查询处理
	 * @param pidid 流程变量ID
	 * @return 流程变量
	 * @throws BLException 
	 */
	public IG007Info searchIG007InfoByKey(String pidid) throws BLException {
		
		return checkExistIG007Info(pidid);
	}
	
	/**
	 * 功能：登录处理
	 * @param ig007Info 登录数据
	 * @return 全局变量
	 * @throws BLException 
	 */
	public IG007Info registIG007Info(IG007Info ig007Info) throws BLException{
		
		if(ig007Info == null) {
			throw new BLException("IGCO10000.E004","全局变量基本");
		}
		return ig007DAO.save(ig007Info);
	}

	/**
	 * 功能：更新处理
	 * @param ig007Info 更新数据
	 * @return 全局变量
	 * @throws BLException 
	 */
	public IG007Info updateIG007Info(IG007Info ig007Info) throws BLException{
		
		if(ig007Info == null) {
			throw new BLException("IGCO10000.E004","全局变量基本");
		}
		return ig007DAO.save(ig007Info);
	}
	
	
	/**
	 * 功能：删除处理
	 * @param pidid 删除全局变量主键
	 */
	public void deleteIG007InfoByKey(String pidid) throws BLException{
		
		IG007Info processInfoDef = checkExistIG007Info(pidid);
		
		ig007DAO.delete(processInfoDef);
	}
	
	/**
	 * 功能：删除处理
	 * @param ig007Info 流程变量定义
	 */
	public void deleteIG007Info(IG007Info ig007Info) throws BLException{
		IG007Info pid = checkExistIG007Info(ig007Info.getPidid());
		
		ig007DAO.delete(pid);
	}


	/**
	 * 功能：全局变量存在检查
	 * @param pidid 全局变量ID
	 * @return 全局变量
	 * @throws BLException 
	 */
	protected IG007Info checkExistIG007Info(String pidid) throws BLException{
		IG007Info info = ig007DAO.findByPK(pidid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","全局变量基本");
		}
		return info;
	}
	
	/**
	 * PIDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PIDID主键值
	 */
	public String getPididSequenceNextValue(String pdid) {
		return ig007DAO.getPididSequenceNextValue(pdid);
	}
	
	/**
	 * 根据表单名查询表单定义信息
	 * 
	 * @param pdid 流程定义ID
	 * @param name 表单名
	 * @return 表单定义信息
	 * @throws BLException
	 */
	public IG007Info searchIG007Info(String pdid, String name) throws BLException {
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//流程定义ID
		cond.setPidlabel(name);//表单名称
		cond.setTableColumn("N");
		List<IG007Info> lst_ProcessInfoDef = this.searchIG007Info(cond);
		if(lst_ProcessInfoDef.isEmpty()) {
			throw new BLException("IGCO10000.E004", "表单（" + name + "）");
		} else if(lst_ProcessInfoDef.size() > 1) {
			throw new BLException("IGCO10000.E026", "表单（" + name + "）");
		} else {
			return lst_ProcessInfoDef.get(0); 
		}
	}
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond){
		return ig007DAO.findByCondRun(cond);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPidid_like(pdid);
		cond.setTableColumn("N");
		cond.setIsExport("Y");
		List<IG007Info> lst_IG007Info = this.searchIG007Info(cond);
		cond.setTableColumn("Y");
		List<IG007Info> temp = this.searchIG007Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG007>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG007Info != null) {
			if(temp != null){
				lst_IG007Info.addAll(temp);
			}
			for(IG007Info info : lst_IG007Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidname()) ? "" : IGStringUtils.filterXMLStr(info.getPidname()));
				sbf_xml.append("</PIDNAME>");
				sbf_xml.append("<PIDLABEL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidlabel()) ? "" : IGStringUtils.filterXMLStr(info.getPidlabel()));
				sbf_xml.append("</PIDLABEL>");
				sbf_xml.append("<PIDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPiddesc()));
				sbf_xml.append("</PIDDESC>");
				sbf_xml.append("<PIDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidtype()) ? "" : IGStringUtils.filterXMLStr(info.getPidtype()));
				sbf_xml.append("</PIDTYPE>");
				sbf_xml.append("<PIDOPTION>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidoption()) ? "" : IGStringUtils.filterXMLStr(info.getPidoption()));
				sbf_xml.append("</PIDOPTION>");
				sbf_xml.append("<PIDDEFAULT>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddefault()) ? "" : IGStringUtils.filterXMLStr(info.getPiddefault()));
				sbf_xml.append("</PIDDEFAULT>");
				sbf_xml.append("<PIDREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidrequired()) ? "" : IGStringUtils.filterXMLStr(info.getPidrequired()));
				sbf_xml.append("</PIDREQUIRED>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PIDSORTID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidsortid()) ? "" : IGStringUtils.filterXMLStr(info.getPidsortid()));
				sbf_xml.append("</PIDSORTID>");
				sbf_xml.append("<CCID>");
				sbf_xml.append(StringUtils.isEmpty(info.getCcid()) ? "" : IGStringUtils.filterXMLStr(info.getCcid()));
				sbf_xml.append("</CCID>");
				sbf_xml.append("<PIDGID>");
				sbf_xml.append(info.getPidgid() == null ? "" : info.getPidgid());
				sbf_xml.append("</PIDGID>");
				sbf_xml.append("<PIDMODE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidmode()) ? "" : IGStringUtils.filterXMLStr(info.getPidmode()));
				sbf_xml.append("</PIDMODE>");
				sbf_xml.append("<PRIVATESCOPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPrivatescope()) ? "" : IGStringUtils.filterXMLStr(info.getPrivatescope()));
				sbf_xml.append("</PRIVATESCOPE>");
				sbf_xml.append("<HASATTACH>");
				sbf_xml.append(StringUtils.isEmpty(info.getHasattach()) ? "" : IGStringUtils.filterXMLStr(info.getHasattach()));
				sbf_xml.append("</HASATTACH>");
				sbf_xml.append("<ROWWIDTH>");
				sbf_xml.append(StringUtils.isEmpty(info.getRowwidth()) ? "" : IGStringUtils.filterXMLStr(info.getRowwidth()));
				sbf_xml.append("</ROWWIDTH>");
				sbf_xml.append("<PIDDISPLAY>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddisplay()) ? "" : IGStringUtils.filterXMLStr(info.getPiddisplay()));
				sbf_xml.append("</PIDDISPLAY>");
				sbf_xml.append("<PIDUSE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiduse()) ? "" : IGStringUtils.filterXMLStr(info.getPiduse()));
				sbf_xml.append("</PIDUSE>");
				sbf_xml.append("<PIDWIDTH>");
				sbf_xml.append(info.getPidwidth() == null ? "" : info.getPidwidth());
				sbf_xml.append("</PIDWIDTH>");
				sbf_xml.append("<PPIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpidid()) ? "" : IGStringUtils.filterXMLStr(info.getPpidid()));
				sbf_xml.append("</PPIDID>");
				sbf_xml.append("<PIDROWS>");
				sbf_xml.append(info.getPidrows() == null ? "" : info.getPidrows());
				sbf_xml.append("</PIDROWS>");
				sbf_xml.append("<PIDHIDE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidhide()) ? "" : IGStringUtils.filterXMLStr(info.getPidhide()));
				sbf_xml.append("</PIDHIDE>");
				sbf_xml.append("<SHOWROWNUM>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowrownum()) ? "" : IGStringUtils.filterXMLStr(info.getShowrownum()));
				sbf_xml.append("</SHOWROWNUM>");
				sbf_xml.append("<SHOWLINE>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowline()) ? "" : IGStringUtils.filterXMLStr(info.getShowline()));
				sbf_xml.append("</SHOWLINE>");
				sbf_xml.append("<PIDUNIT>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidunit()) ? "" : IGStringUtils.filterXMLStr(info.getPidunit()));
				sbf_xml.append("</PIDUNIT>");
				sbf_xml.append("<REMARKS>");
				sbf_xml.append(StringUtils.isEmpty(info.getRemarks()) ? "" : IGStringUtils.filterXMLStr(info.getRemarks()));
				sbf_xml.append("</REMARKS>");
				sbf_xml.append("<SHOWSTYLES>");
				sbf_xml.append(StringUtils.isEmpty(info.getShowstyles()) ? "" : IGStringUtils.filterXMLStr(info.getShowstyles()));
				sbf_xml.append("</SHOWSTYLES>");
				sbf_xml.append("<TITLEDISPLAY>");
				sbf_xml.append(StringUtils.isEmpty(info.getTitledisplay()) ? "" : IGStringUtils.filterXMLStr(info.getTitledisplay()));
				sbf_xml.append("</TITLEDISPLAY>");
				sbf_xml.append("<NEEDIDEA>");
				sbf_xml.append(StringUtils.isEmpty(info.getNeedidea()) ? "" : IGStringUtils.filterXMLStr(info.getNeedidea()));
				sbf_xml.append("</NEEDIDEA>");
				sbf_xml.append("<JSFUNCTION>");
				sbf_xml.append(StringUtils.isEmpty(info.getJsfunction()) ? "" : IGStringUtils.filterXMLStr(info.getJsfunction()) );
				sbf_xml.append("</JSFUNCTION>");
				sbf_xml.append("<PIDRATIO>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidratio()) ? "" : IGStringUtils.filterXMLStr(info.getPidratio()));
				sbf_xml.append("</PIDRATIO>");
				sbf_xml.append("<PIDSIZE>");
				sbf_xml.append(info.getPidsize() == null ? "0" : info.getPidsize());
				sbf_xml.append("</PIDSIZE>");
				sbf_xml.append("<WRITEABLE>");
				sbf_xml.append(StringUtils.isEmpty(info.getWriteable()) ? "" : IGStringUtils.filterXMLStr(info.getWriteable()));
				sbf_xml.append("</WRITEABLE>");
				sbf_xml.append("<SELECEDLAST>");
				sbf_xml.append(StringUtils.isEmpty(info.getSelecedlast()) ? "" : IGStringUtils.filterXMLStr(info.getSelecedlast()));
				sbf_xml.append("</SELECEDLAST>");
				sbf_xml.append("<NUMBERTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getNumbertype()) ? "" : IGStringUtils.filterXMLStr(info.getNumbertype()));
				sbf_xml.append("</NUMBERTYPE>");
				sbf_xml.append("<ALIGN>");
				sbf_xml.append(StringUtils.isEmpty(info.getAlign()) ? "" : IGStringUtils.filterXMLStr(info.getAlign()));
				sbf_xml.append("</ALIGN>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG007>");
		return sbf_xml;
	}
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG007Info> lst_IG007 = new ArrayList<IG007Info>();
		IG007TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG007TBInstance();
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPidname(e.getChildText("PIDNAME"));
			entity.setPidlabel(e.getChildText("PIDLABEL"));
			entity.setPiddesc(e.getChildText("PIDDESC"));
			entity.setPidtype(e.getChildText("PIDTYPE"));
			entity.setPidoption(e.getChildText("PIDOPTION"));
			entity.setPiddefault(e.getChildText("PIDDEFAULT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidsortid(e.getChildText("PIDSORTID"));
			entity.setCcid(e.getChildText("CCID"));
			entity.setHasattach(e.getChildText("HASATTACH"));
			entity.setPidgid(StringUtils.isEmpty(e.getChildText("PIDGID")) ? null : new Integer(e.getChildText("PIDGID")));
			entity.setPidmode(e.getChildText("PIDMODE"));
			entity.setPrivatescope(e.getChildText("PRIVATESCOPE"));
			entity.setRowwidth(e.getChildText("ROWWIDTH"));			
			entity.setPiddisplay(e.getChildText("PIDDISPLAY"));
			entity.setPiduse(e.getChildText("PIDUSE"));
			entity.setPidwidth(StringUtils.isEmpty(e.getChildText("PIDWIDTH")) ? null : new Integer(e.getChildText("PIDWIDTH")));
			entity.setPpidid(StringUtils.isNotEmpty(e.getChildText("PPIDID")) ? e.getChildText("PPIDID") : null);
			entity.setPidrows(StringUtils.isEmpty(e.getChildText("PIDROWS")) ? null : new Integer(e.getChildText("PIDROWS")));
			entity.setPidhide(e.getChildText("PIDHIDE"));
			entity.setShowrownum(e.getChildText("SHOWROWNUM"));
			entity.setShowline(e.getChildText("SHOWLINE"));
			entity.setPidunit(e.getChildText("PIDUNIT"));
			entity.setRemarks(e.getChildText("REMARKS"));
			entity.setShowstyles(e.getChildText("SHOWSTYLES"));
			entity.setTitledisplay(e.getChildText("TITLEDISPLAY"));
			entity.setNeedidea(e.getChildText("NEEDIDEA"));
			entity.setJsfunction(e.getChildText("JSFUNCTION"));
			entity.setPidratio(e.getChildText("PIDRATIO"));
			entity.setPidsize(Integer.valueOf(e.getChildText("PIDSIZE")));
			entity.setWriteable(e.getChildText("WRITEABLE"));
			entity.setSelecedlast(e.getChildText("SELECEDLAST"));
			entity.setNumbertype(e.getChildText("NUMBERTYPE"));
			entity.setAlign(e.getChildText("ALIGN"));
			lst_IG007.add(entity);
		}
		this.ig007DAO.saveOrUpdateAll(lst_IG007);
	}
	
}
