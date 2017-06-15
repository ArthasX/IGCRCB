package com.deliverik.infogovernor.drm.bl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeCategoryDefBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.asset.vo.IGASM21081VO;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.PlanBL;
import com.deliverik.infogovernor.drm.bl.task.ResponseStrategyBL;
import com.deliverik.infogovernor.drm.bl.task.StructureRoleBL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0101Form;
import com.deliverik.infogovernor.drm.form.IGDRM0104Form;
import com.deliverik.infogovernor.drm.form.IGDRM0105Form;
import com.deliverik.infogovernor.drm.form.IGDRM0108Form;
import com.deliverik.infogovernor.drm.form.IGDRM0119Form;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;
import com.deliverik.infogovernor.drm.util.ComputingTime;
import com.deliverik.infogovernor.drm.util.FlowDetail;
import com.deliverik.infogovernor.drm.util.StepLine;
import com.google.gson.Gson;


/**
 * 预案管理业务逻辑实现
 *
 */
public class IGDRM01BLImpl extends BaseBLImpl implements IGDRM01BL {

	static Log log = LogFactory.getLog(IGDRM01BLImpl.class);
	/**流程状态定义业务逻辑处理BL*/
	protected IG333BL ig333BL;
	/**流程参与者定义业务逻辑处理BL*/
	protected IG222BL ig222BL;
	/**流程参与者定义业务逻辑处理BL*/
	protected UserRoleBL userRoleBL;
	/**用户处理BL*/
	protected UserBL userBL;
    /**用户处理BL*/
    protected RoleBL roleBL;
	 /**SOC0151BL操作*/
    protected SOC0151BL soc0151BL;
	 /**SOC0117BL操作*/
	protected SOC0117BL soc0117BL;
	 /**PlanBL操作*/
	protected PlanBL planBL;
	/** 数据分类信息BL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	/** 数据详细信息BL */
	protected CodeDetailDefBL codeDetailDefBL;
	/** 数据详细信息BL */
	protected StructureRoleBL structureRoleBL;
	/** 更新功能API类 */
	protected FlowSetBL flowSetBL;
    /** 查询类功能API类 */
	protected FlowSearchBL flowSearchBL;
    /**流程参与者定义业务逻辑处理BL*/
	protected IG560BL ig560BL;
	/**流程参与者定义业务逻辑处理BL*/
	protected IG561BL ig561BL;
    /**流程参与者定义业务逻辑处理BL*/
	protected AttachmentBL attachmentBL;
	
	/**每个节点的预期开始时间*/
	protected Map<String,Integer> nodeTimeMap = new HashMap<String,Integer>();
	/**记录连线的数组*/
	protected List<StepLine> lineArr = new ArrayList<StepLine>();
	/**记录走法的数组*/
	protected Map<String,IG333Info> stepMap = new HashMap<String,IG333Info>();
	/** 资产合并视图 */
	protected SOC0118VWBL soc0118VWBL;
	/** 资产关系Bl */
	protected SOC0119BL soc0119BL;

	/** 场景响应策略BL */
	protected ResponseStrategyBL responseStrategyBL;

	/**表单值BL*/
	protected IG599BL ig599BL;

	protected WorkFlowOperationBL workFlowOperationBL;

	
	
	public IG599BL getIg599BL() {
		return ig599BL;
	}
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public void setResponseStrategyBL(ResponseStrategyBL responseStrategyBL) {
		this.responseStrategyBL = responseStrategyBL;
	}
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}
	/**  
	 * 获取nodeTimeMap  
	 * @return nodeTimeMap 
	 */
	public Map<String, Integer> getNodeTimeMap() {
		return nodeTimeMap;
	}
	/**  
	 * 设置nodeTimeMap  
	 * @param nodeTimeMap
	 */
	
	public void setNodeTimeMap(Map<String, Integer> nodeTimeMap) {
		this.nodeTimeMap = nodeTimeMap;
	}
	/**  
	 * 获取lineArr  
	 * @return lineArr 
	 */
	public List<StepLine> getLineArr() {
		return lineArr;
	}
	/**  
	 * 设置lineArr  
	 * @param lineArr
	 */
	
	public void setLineArr(List<StepLine> lineArr) {
		this.lineArr = lineArr;
	}
	/**  
	 * 获取stepMap  
	 * @return stepMap 
	 */
	public Map<String, IG333Info> getStepMap() {
		return stepMap;
	}
	/**  
	 * 设置stepMap  
	 * @param stepMap
	 */
	
	public void setStepMap(Map<String, IG333Info> stepMap) {
		this.stepMap = stepMap;
	}
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	public void setPlanBL(PlanBL planBL) {
		this.planBL = planBL;
	}
	public void setStructureRoleBL(StructureRoleBL structureRoleBL) {
		this.structureRoleBL = structureRoleBL;
	}
	
	public void setCodeCategoryDefiBL(CodeCategoryDefBL codeCategoryDefiBL) {
		this.codeCategoryDefiBL = codeCategoryDefiBL;
	}
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * @param ig561bl the ig561BL to set
	 */
	public void setIg561BL(IG561BL ig561bl) {
		ig561BL = ig561bl;
	}
	/**
	 * 查询节点状态信息
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStautsInfo(IGDRM01DTO dto)throws BLException{
		String stepPdid = dto.getIgdrm0101Form().getStepPdid();
		IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
		ig007Cond.setPdid(stepPdid);//流程ID
		ig007Cond.setPidname("应急资源");//表单名称
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
		//应急资源 pidid
		String pidid = lst_ProcessInfoDef.get(0).getPidid();
		
		//节点信息查询
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(stepPdid);
		List<IG333Info> ig333Lt = ig333BL.searchIG333Info(cond);
		//给场景流程状态节点排序（关闭节点放到所有节点的最后位置）
		List<IG333Info> ig333List = new ArrayList<IG333Info>();
		for(IG333Info info:ig333Lt){
			////过滤掉关闭节点
			if("C".equals(info.getPsdcode())){
				continue;
			}
			ig333List.add(info);
		}
		//最后将关闭节点添加到List中
		ig333List.add(ig333Lt.get(1));
		
		//节点MAP-LST
		List<Map<String,Object>> stautsMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> stautsMap = null;
		//循环节点    
		for(int i = 0; i<ig333List.size() ; i++){
			stautsMap = new LinkedHashMap<String,Object>();
			//查询应急资源对应的eiid
			IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
			ig560Cond.setPsdid_l(ig333List.get(i).getPsdid());
			ig560Cond.setPidid_l(pidid);
			ig560Cond.setUsedToAll("F");
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			//应急资源对应的eiid
			String eiid = "";
			//应急资源对应的eiid
			String einame = "";
			//应急资源对应的eiid
			Integer eiversion = 0;
			if(null!=ig560List&&ig560List.size()>0){
				//应急资源对应的eiid
				eiid = ig560List.get(0).getDfvalue();
			}
			//如果状态存在应急资产 表单值
			if(!StringUtils.isBlank(eiid)){
				//资产实体信息
				EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(Integer.valueOf(eiid));
				//应急资源对应的eiid
				einame = eiInfo.getEiname();
				//应急资源对应的eiid
				eiversion = eiInfo.getEiversion();
			}
			stautsMap.put("eiid",nullToEmpty(eiid));
			stautsMap.put("einame",nullToEmpty(einame));
			stautsMap.put("eiversion",eiversion);
			
			//状态节点名称-操作步骤
			stautsMap.put("psdNo",i+1);
			//状态节点名称-操作步骤
			stautsMap.put("psdname", ig333List.get(i).getPsdname());
			
			//参与人名称字符串
			String participantNameStr = "";
			String roleNameStr = "";
			IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
			ig222Cond.setPsdid(ig333List.get(i).getPsdid());
			List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
			//参与人员list
			List<Integer> roleIdList = new ArrayList<Integer>();
			//参与人员list
			List<String> userIdList = new ArrayList<String>();
			for(int j = 0; j<ig222List.size() ; j++){
				String userid = ig222List.get(j).getUserid();
				Integer roleid = ig222List.get(j).getRoleid();
				//如果参与者指定到人
				if(StringUtils.isNotBlank(userid)){
					userIdList.add(userid);
				}else{//如果参与者没有指定到人 则取参与角色下所有人
					Integer roleId = ig222List.get(j).getRoleid();
					UserRoleSearchCondImpl userroleSearchCondImpl = new UserRoleSearchCondImpl();
					//通过roleId获取userIdList
					userroleSearchCondImpl.setRoleid(roleId);
					List<UserRole> userRoleList = userRoleBL.searchUserRole(userroleSearchCondImpl);
					for(UserRole ur:userRoleList){
						userIdList.add(ur.getUserid());
					}
				}
				roleIdList.add(roleid);
			}
			//去重复userID
			HashSet<String> set = new HashSet<String>(userIdList); 
			userIdList.clear(); 
			userIdList.addAll(set); 
			//通过id获取userMail
			for(String userID : userIdList){
				User userinfo = userBL.searchUserByKey(userID);
				participantNameStr+=userinfo.getUsername()+",";
			}
			//去掉最后一个字符","
			if(!"".equals(participantNameStr)){
				participantNameStr = participantNameStr.substring(0,participantNameStr.length()-1);
			}
			//状态节点参与人
			stautsMap.put("participant", participantNameStr);
			
			//去重复roleID
			HashSet<Integer> roleSet = new HashSet<Integer>(roleIdList); 
			roleIdList.clear(); 
			roleIdList.addAll(roleSet); 
			//通过id获取roleName
			for(Integer roleId : roleIdList){
				Role roleInfo = roleBL.searchRoleByKey(roleId);
				roleNameStr+=roleInfo.getRolename()+",";
			}
			//去掉最后一个字符","
			if(!"".equals(roleNameStr)){
				roleNameStr = roleNameStr.substring(0,roleNameStr.length()-1);
			}
			//状态节点参与团队
			stautsMap.put("roleName", roleNameStr);
			
			stautsMapList.add(stautsMap);
		}
		Gson gson = new Gson();
		String json = gson.toJson(stautsMapList);
		return json;
	}
	/**
	 * 查询场景实例节点中已经填过表单信息
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStautsFormLog(IGDRM01DTO dto)throws BLException{
		String stepPdid = dto.getIgdrm0101Form().getStepPdid();
		String stepPrid = dto.getIgdrm0101Form().getStepPrid();
		//查询表单
		IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
		ig007Cond.setPdid(stepPdid);
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
		//处置说明
		String desPidid = "";
		//处置结果
		String resPidid = "";
		//附件
		String attPidid = "";
		//获取pidid
		for(IG007Info ig007Info:lst_ProcessInfoDef){
			if("处置说明".equals(ig007Info.getPidname())){
				desPidid = ig007Info.getPidid();
			}
			else if("处置结果".equals(ig007Info.getPidname())){
				resPidid = ig007Info.getPidid();
			}
			else if("附件".equals(ig007Info.getPidname())){
				attPidid = ig007Info.getPidid();
			}
		}
		
		IG561SearchCondImpl ig561Cond = new IG561SearchCondImpl();
		ig561Cond.setPrid_q(stepPrid);
		List<IG561Info> ig561List = ig561BL.searchIG561(ig561Cond);
		Map<String,IG561Info> ig561Map = new HashMap<String,IG561Info>();
		for(IG561Info info:ig561List){//封装561map
			ig561Map.put(info.getPsdid()+"_"+info.getPidid(), info);
		}
		
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(stepPdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(cond);
		//以及节点
		List<Map<String,Object>> stautsMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> stautsMap = null;
		//循环一级节点    
		for(int i = 0; i<ig333List.size() ; i++){
			stautsMap = new LinkedHashMap<String,Object>();
			if(ig561Map.containsKey(ig333List.get(i).getPsdid()+"_"+desPidid)){
				IG561Info  desInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+desPidid);
				IG561Info  resInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+resPidid);
				IG561Info  attInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+attPidid);
				//状态节点名称-操作步骤
				stautsMap.put("psdNo",i+1);
				stautsMap.put("psdname",ig333List.get(i).getPsdname());
				stautsMap.put("des",desInfo.getPivarvalue());
				stautsMap.put("res",resInfo.getPivarvalue());
				stautsMap.put("att",attInfo.getPivarvalue());
				stautsMapList.add(stautsMap);
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(stautsMapList);
		return json;
	}
	/**
	 * 查询应急组织架构信息
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public IGDRM01DTO getOrgInfo(IGDRM01DTO dto)throws BLException{
		//数据详细信息查询
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		//组织架构ccid
		cond.setCcid("230");
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//组织架构信息
		StringBuffer xml = new StringBuffer("<root>");
		
		for(int i=0;i<codeDetailList.size();i++){
			String syscoding = codeDetailList.get(i).getSyscoding();
			String teamName = codeDetailList.get(i).getCvalue();
			xml.append("<team ");
			xml.append(" syscoding= \""+syscoding+"\"");
			xml.append(" teamName= \""+teamName+"\"");
			xml.append(" >");
			StructureRoleSearchCondImpl srCond = new StructureRoleSearchCondImpl();
			srCond.setSyscoding_q(syscoding);
			//应急组织架构关联角色list
			List<StructureRoleInfo> srList= structureRoleBL.searchStructureRole(srCond);
			//组织架构 节点所对应的角色信息
			for(int j=0;j<srList.size();j++){
				Integer roleId = srList.get(j).getRoleid();
				String roleName = srList.get(j).getRolename();
				xml.append("<role ");
				xml.append(" roleId= \""+roleId+"\"");
				xml.append(" roleName= \""+roleName+"\"");
				xml.append(" >");
				UserRoleVWSearchCondImpl urCond = new UserRoleVWSearchCondImpl();
				urCond.setRoleid(roleId);
				List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urCond);
				for(int k=0;k<urList.size();k++){
					String userId = urList.get(k).getUserid();
					String userName = urList.get(k).getUsername();
					String orgName = urList.get(k).getOrgname();
					xml.append("<user ");
					xml.append(" userId= \""+userId+"\"");
					xml.append(" userName= \""+userName+"\"");
					xml.append(" userOrg= \""+orgName+"\"");
					xml.append(" />");
				}
				xml.append("</role>");
			}
			xml.append("</team>");
		}
		xml.append("</root>");
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	/**
	 * 查询该流程下状态级附件key
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getAttKey(IGDRM01DTO dto)throws BLException{
		IGDRM0101Form form = dto.getIgdrm0101Form();
		String pdid = form.getStepPdid();
		List<ProcessStatusInfo> psList = flowSearchBL.searchProcessStatusList(pdid);
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//流程ID
		cond.setPidname("附件");//表单名称
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(cond);
		String pidid = lst_ProcessInfoDef.get(0).getPidid();
		
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		ig560Cond.setPsdid_l(pdid);
		ig560Cond.setUsedToAll("F");
		List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
		//状态节点附件信息
		StringBuffer attKeyXml = new StringBuffer("<attList>");
		for(int i=0;i<psList.size();i++){
			for(int j=0;j<ig560List.size();j++){
				String psdid = psList.get(i).getPsdid();
				//PSDID && PIDID
				if(psdid.equals(ig560List.get(j).getPsdid())&&pidid.equals(ig560List.get(j).getPidid())){
					attKeyXml.append("<attInfo ");
					attKeyXml.append(" divd= \""+ig560List.get(j).getDvid()+"\"");
					attKeyXml.append(" psdid= \""+nullToEmpty(psdid)+"\"");
					attKeyXml.append(" pidid= \""+nullToEmpty(pidid)+"\"");
					String attKey = ig560List.get(j).getDfvalue();
					attKeyXml.append(" attKey= \""+nullToEmpty(attKey)+"\"");//附件attKey
					String attLabel = "";
					if(null!=attKey&&""!=attKey){
						List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attKey);
						if(null!=attList&&attList.size()>0){
							attLabel = attList.get(0).getAttname();
							attLabel = attLabel.split("_")[1];
						}
					}
					attKeyXml.append(" attLabel= \""+attLabel+"\"");//附件attKey
					attKeyXml.append(" />");
				}
			}
		}
		attKeyXml.append("</attList>");
		return attKeyXml.toString();
	}
	/**
	 * 查询该流程下状态级表单XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateForm(IGDRM01DTO dto)throws BLException{
		IGDRM0101Form form = dto.getIgdrm0101Form();
		String pdid = form.getStepPdid();
		List<ProcessStatusInfo> psList = flowSearchBL.searchProcessStatusList(pdid);
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//流程ID
		cond.setPidmode("2");//状态级表单
		cond.setPiduse("1");
		List<IG007Info> formLst = workFlowDefinitionBL.searchProcessInfoDef(cond);
		Map<String,IG007Info> ig007Map = new HashMap<String,IG007Info>();
		for(IG007Info ig007Info:formLst){
			//xml过去掉附件
			if(!ig007Info.getPidname().equals("附件")&&!ig007Info.getPidname().equals("业务系统")){
				ig007Map.put(ig007Info.getPidid(), ig007Info);
			}
		}
		//遍历流程下所有节点
		//状态节点附件信息
		StringBuffer formListXml = new StringBuffer("<StateFormList>");
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		ig560Cond.setPsdid_l(pdid);
		ig560Cond.setUsedToAll("F");
		List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
		Map<String,IG560Info> ig560Map = new HashMap<String,IG560Info>();
		//将该流程下的状态表单值 信息封装成map
		for(IG560Info ig560Info:ig560List){
			ig560Map.put(ig560Info.getPsdid()+"_"+ig560Info.getPidid(), ig560Info);
		}
		for(int i=0;i<psList.size();i++){
			ProcessStatusInfo psInfo = psList.get(i);
			formListXml.append("<StepForm psdid= \""+psInfo.getPsdid()+"\" >");
			String psdid = psInfo.getPsdid();
			if(ig560List!=null &&ig560List.size()>0){
				for(IG560Info ig560Info:ig560List){
					if(ig007Map.get(ig560Info.getPidid())!=null&&ig560Info.getPsdid().equals(psInfo.getPsdid())){
						formListXml.append("<FormInfo ");
						formListXml.append(" psdid= \""+psInfo.getPsdid()+"\" ");
						formListXml.append(" pidid= \""+ig560Info.getPidid()+"\" ");
						formListXml.append(" pidname= \""+ig007Map.get(ig560Info.getPidid()).getPidname()+"\" ");
						formListXml.append(" pidtype= \""+ig007Map.get(ig560Info.getPidid()).getPidtype()+"\" ");
						String dfvalue = ig560Info.getDfvalue();
						if("4".equals(ig007Map.get(ig560Info.getPidid()).getPidtype())&&!StringUtils.isBlank(dfvalue)){
							Integer id = 0;
							Integer eiid = 0;
							if(dfvalue.split("_").length>1){
								id = Integer.parseInt(dfvalue.split("_")[0]);
								eiid = Integer.parseInt(dfvalue.split("_")[1]);
							}
							EntityItemInfo itemInfo = flowSearchBL.searchEntityItem( id , eiid);
							dfvalue = dfvalue.split("_SOC_")[0]+"_EIID_"+itemInfo.getEiname()+"_SOC_"+dfvalue.split("_SOC_")[1];
						}
						formListXml.append(" dfvalue= \""+nullToEmpty(dfvalue)+"\"  />");
					}
			}
			
		}else{
			for(int j=0;j<formLst.size();j++){
				IG007Info ig007Info = formLst.get(j);
				if(!ig007Info.getPidname().equals("附件")&&!ig007Info.getPidname().equals("业务系统")){
					formListXml.append("<FormInfo ");
					formListXml.append(" psdid= \""+psInfo.getPsdid()+"\" ");
					formListXml.append(" pidid= \""+ig007Info.getPidid()+"\" ");
					formListXml.append(" pidname= \""+ig007Info.getPidname()+"\" ");
					formListXml.append(" pidtype= \""+ig007Info.getPidtype()+"\" ");
					String dfvalue = "";
					if(ig560Map.containsKey(psdid+"_"+ig007Info.getPidid())){
						dfvalue = ig560Map.get(psdid+"_"+ig007Info.getPidid()).getDfvalue();
					}
					if("F".equals(ig007Info.getPidtype())&&!"".equals(dfvalue)){
						List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(dfvalue);
						if(null!=attList&&attList.size()>0){
							dfvalue = attList.get(0).getAttname();
						}
					}
					if("4".equals(ig007Info.getPidtype())&&!StringUtils.isBlank(dfvalue)){
						EntityItemInfo itemInfo = flowSearchBL.searchEntityItem(Integer.valueOf(dfvalue));
						dfvalue = dfvalue+"_EIID_"+itemInfo.getEiname();   
					}
					formListXml.append(" dfvalue= \""+nullToEmpty(dfvalue)+"\"  />");
				}
				
			}
			
		}
			formListXml.append("</StepForm>");	
		}
		
		
//		for(int i=0;i<psList.size();i++){
//			ProcessStatusInfo psInfo = psList.get(i);
//			formListXml.append("<StepForm psdid= \""+psInfo.getPsdid()+"\" >");
//			String psdid = psInfo.getPsdid();
//			for(int j=0;j<formLst.size();j++){
//				IG007Info ig007Info = formLst.get(j);
//				formListXml.append("<FormInfo ");
//				formListXml.append(" psdid= \""+psInfo.getPsdid()+"\" ");
//				formListXml.append(" pidid= \""+ig007Info.getPidid()+"\" ");
//				formListXml.append(" pidname= \""+ig007Info.getPidname()+"\" ");
//				formListXml.append(" pidtype= \""+ig007Info.getPidtype()+"\" ");
//				String dfvalue = "";
//				if(ig560Map.containsKey(psdid+"_"+ig007Info.getPidid())){
//					dfvalue = ig560Map.get(psdid+"_"+ig007Info.getPidid()).getDfvalue();
//				}
//				if("F".equals(ig007Info.getPidtype())&&!"".equals(dfvalue)){
//					List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(dfvalue);
//					if(null!=attList&&attList.size()>0){
//						dfvalue = attList.get(0).getAttname();
//					}
//				}
//				if("4".equals(ig007Info.getPidtype())&&!StringUtils.isBlank(dfvalue)){
//					EntityItemInfo itemInfo = flowSearchBL.searchEntityItem(Integer.valueOf(dfvalue));
//					dfvalue = dfvalue+"_EIID_"+itemInfo.getEiname();   
//				}
//				formListXml.append(" dfvalue= \""+nullToEmpty(dfvalue)+"\"  />");
//			}
//			formListXml.append("</StepForm>");
//		}
		formListXml.append(" </StateFormList>");
		
		return formListXml.toString();
	}
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 场景资产查询页-初始化页面数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO initIgdrm0102Action(IGDRM01DTO dto)throws BLException{
		
		List<LabelValueBean>  labelValues = soc0151BL.searchLabelValueBeanList("505");
		dto.setPlanTypeValues(labelValues);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setSyscoding_q("999060");
		List<SOC0117Info> soc0117List = soc0117BL.searchEntity(cond);
		Hashtable<String,TreeNode>  tempMap =  new  Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		PlanSearchCondImpl pcond;
		for(SOC0117Info soc0117:soc0117List){
			TreeNode node = new TreeNode();
			node.setId(soc0117.getEsyscoding());
			node.setRemark(soc0117.getEparcoding());
			//设备信息查询件数取得 
			pcond = new PlanSearchCondImpl();
			pcond.setEsyscoding_like(soc0117.getEsyscoding());
			//判断权限，如果是业务连续性管理员
			if(getRoleType(dto.getLoginUser().getUserid())){
			}
			else{
				//机构过滤
				pcond.setEiorgsyscoding_like(dto.getLoginUser().getOrgid());
			}
//			pcond.setEiorgsyscoding_like(dto.getLoginUser().getOrgid());
			int totalCount = this.planBL.getSearchCount(pcond);
			node.setName(soc0117.getEname()+"("+totalCount+")");
			
			if(allNode.get(soc0117.getEparcoding())==null){
				tempMap.put(soc0117.getEsyscoding(), node);
			}else{
				allNode.get(soc0117.getEparcoding()).addChildTreeNode(soc0117.getEsyscoding(), node);
			}
			allNode.put(soc0117.getEsyscoding(), node);
		}
		dto.setNodeMap(tempMap);
		return dto;
	}
	
	/**
	 * 查询场景资产方法
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchPlan(IGDRM01DTO dto)throws BLException{
		//场景资产查询页-初始化页面数据
		initIgdrm0102Action(dto);
		IGDRM0104Form form = dto.getIgdrm0104Form();
		PlanSearchCondImpl cond = new PlanSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
//		//判断权限，如果是业务连续性管理员
//		if(getRoleType(dto.getLoginUser().getUserid())){
//		}else{
//			//机构过滤
//			cond.setEiorgsyscoding_like(dto.getLoginUser().getOrgid());
//		}
		//设备信息查询件数取得 
		int totalCount = this.planBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========预案查询数据不存在========");
			//预案查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("=======预案查询数据件数过多========");
			//预案查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<PlanInfo> planList = this.planBL.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setPlanList(planList);
		log.debug("========预案查询处理终了========");
		return dto;
		
	}
	
	/**
	 * 获取登录人的roleid，判断是否为业务连续性管理员
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public boolean getRoleType(String uesrid) throws BLException{
		
		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
		//设置查询条件
		urcond.setUserid(uesrid);
		List<UserRole> urList = userRoleBL.searchUserRole(urcond);
		for(UserRole ur :urList){
			//登录人员所在角色roleid
			Integer roleid = ur.getRoleid();
			RoleBL roleBL = (RoleBL) WebApplicationSupport.getBean("roleBL");
			Role roleInfo = roleBL.searchRoleByKey(roleid);
			//PLAN_ADMINISTRATOR_ROLETYPE代表业务连续性管理员 角色所在角色类型-应急执行层：roleTYPE
			if(IGPRDCONSTANTS.PLAN_ADMINISTRATOR_ROLETYPE.equals(roleInfo.getRoletype())){
				return true;
			}
		}
		return false;
	}

	/**
	 * 查询应急制度模型树
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityTreeForIgdrm0105Action(IGDRM01DTO dto) throws BLException {

		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNum(IGDRMCONSTANTS.EMERGENCY_INSTITUTION_ESYSCODING);
		Hashtable<String, TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String, TreeNode> allNode = new HashMap<String, TreeNode>();
		for (Map<String, Object> map : soc0117List) {
			TreeNode node = new TreeNode();
			node.setId(map.get("ESYSCODING").toString());
			node.setRemark(map.get("EPARCODING").toString());

			if (dto.isCountNum()) {
				node.setName(map.get("ENAME").toString() + "(" + map.get("ACCOUNT").toString() + ")");
			} else {
				node.setName(map.get("ENAME").toString());
			}

			if (allNode.get(map.get("EPARCODING").toString()) == null) {
				tempMap.put(map.get("ESYSCODING").toString(), node);
			} else {
				allNode.get(map.get("EPARCODING").toString()).addChildTreeNode(map.get("ESYSCODING").toString(), node);
			}
			allNode.put(map.get("ESYSCODING").toString(), node);
		}
		dto.setNodeMap(tempMap);

		return dto;
	}

	/**
	 * 查询应急制度分类列表
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityList(IGDRM01DTO dto) throws BLException {
		IGDRM0105Form form = (IGDRM0105Form) dto.getForm();
		
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		
		cond.setEparcoding(form.getEparcoding());
		
		// 应急制度分类查询件数取得
		int totalCount = this.soc0117BL.getEntitySearchCount(cond);

		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 应急制度分类查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========资产域定义信息查询数据件数过多========");
			// 应急制度分类查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);

		List<SOC0117Info> entityList = soc0117BL.searchEntity(cond, pDto.getFromCount(), pDto.getPageDispCount());

		dto.setEntityList(entityList);

		return dto;
	}
	
	/**
	 * null->""
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String nullToEmpty(String str) throws BLException{
		if(null==str){
			str = "";
		}	
		return str;
	}
	/**
	 * 查询场景信息存储到form中
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSceneByEiid(IGDRM01DTO dto) throws BLException {
		IGDRM0108Form form = dto.getIgdrm0108Form();;
		IG731BL ig731BL = (IG731BL) WebApplicationSupport.getBean("ig731BL");
		//查询流程关联的场景资产eiid
		IG731Info ig731Info = ig731BL.searchSenceBySePrid(form.getPrid(), form.getFlowType()).get(0);
		form.setEiid(ig731Info.getEiid().toString());
		dto.setIgdrm0108Form(form);
		return dto;
	}
	
	
	
	/**
	 * 查询场景信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getScene(IGDRM01DTO dto) throws BLException {

		log.debug("==========查询场景详细信息开始==========");

		IGDRM0108Form form = dto.getIgdrm0108Form();

		PlanInfo planInfo = planBL.findByPK(Integer.valueOf(form.getEiid()));
		//流程ID
		String pdid = planInfo.getScepdid();
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
		ig333Cond.setPdid(pdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
		if(ig333List!=null && ig333List.size()>0){
			for(IG333Info ig333Info:ig333List){
					ig333Map.put(ig333Info.getPsdid(), ig333Info);
			}
		}
		
		ComputingTime computingTime = new ComputingTime();
		dto.setMaxTime(computingTime.countTotalTime(ig333Map).toString());
		dto.setPlanInfo(planInfo);
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setPareiid(planInfo.getEiid());
		cond.setParversion(planInfo.getEiversion());
		cond.setDeleteflag("0");
		List<SOC0119Info> soc0119InfoLst = soc0119BL.searchEntityItemRelation(cond);
		List<SOC0118VWInfo> soc0118InfoLst = new ArrayList<SOC0118VWInfo>();
		for (SOC0119Info info : soc0119InfoLst) {
			Integer cldEiid = info.getCldeiid();
			SOC0118VWInfo soc118Info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(1, cldEiid));
			soc0118InfoLst.add(soc118Info);
		}
		dto.setZyList(soc0118InfoLst);

		log.debug("==========查询场景详细信息完成==========");

		return dto;
	}
	
	/**
	 * 查询场景中的流程详细信息
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchFlowDetail(IGDRM01DTO dto) throws BLException {

		UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
		IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
		SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
		ig333Cond.setPdid(dto.getPdid());
		// 节点list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		// 结果集List
		Map<String, FlowDetail> flowDetailMap = new HashMap<String, FlowDetail>();
		// 存放子节点的List
		Map<String, Map<String, FlowDetail>> childFlowDetailMap = new HashMap<String, Map<String, FlowDetail>>();
		if (ig333List != null && ig333List.size() > 0) {
			for (IG333Info ig333Info : ig333List) {
				FlowDetail flowDetail = new FlowDetail();
				// 存储节点
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				// 查询560中的数据并添加到flowDetail中
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				//遍历应急资源，并且组建类别Map;
				if(ig560List != null && ig560List.size()>0){
					if(flowDetail.getSoc0118Map()==null){
						flowDetail.setSoc0118Map(new HashMap<String, List<SOC0118VWInfo>>());
					}
					for(IG560Info ig560Info : ig560List){
						if(ig560Info.getDfvalue()!=null &&!ig560Info.getDfvalue().isEmpty()){
							String type = ig560Info.getDfvalue().split("_SOC_")[1];
							soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
							soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
							SOC0118VWInfo soc0118VWInfo = soc0118VWBL.searchEntityItem(soc0118Cond).get(0);
							if(flowDetail.getSoc0118Map().get(type)!=null){
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}else{
								flowDetail.getSoc0118Map().put(type, new ArrayList<SOC0118VWInfo>());
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}
						}
						
					}
				}
				
				//描述
				flowDetail.setDuty(ig333Info.getPsddesc());
				// 查询参与人并存储
				Map<String, UserInfo> userMap = new LinkedHashMap<String, UserInfo>();
				// 查询参与人并存储
				Map<String, UserInfo> userMap2 = new LinkedHashMap<String, UserInfo>();
				List<String> userids=new ArrayList<String>();
				ig222Cond.setPsdid(ig333Info.getPsdid());
				List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
				if (ig222List != null && ig222List.size() > 0) {
					for (IG222Info ig222Info : ig222List) {
						if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
							userCond.setUserida(ig222Info.getUserid());
							List<UserInfo> userList = userBL.searchUserInfo(userCond);
							if (userList != null && userList.size() > 0) {
								UserInfo user = (UserInfo) userList.get(0);
								userMap.put(user.getUserida(), user);
								userids.add(user.getUserida());
							}
						} else {
							List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
							if (userInfoList != null && userInfoList.size() > 0) {
								for (int i = 0; i < userInfoList.size(); i++) {
									UserInfoVW user = new UserInfoVW();
									BeanUtils.copyProperties(userInfoList.get(i), user);
									user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
									userMap.put(user.getUserida(), user);
									userids.add(user.getUserida());
								}
							}
						}
					}
					Collections.sort(userids,new Comparator<String>() {
			            public int compare(String arg0, String arg1) {
			                return arg0.compareTo(arg1);
			            }
			        });
					for(String userid:userids){
						userMap2.put(userid, userMap.get(userid));
					}
					
					flowDetail.setUserMap(userMap2);
				}
				// 判断是否为子节点
				if (StringUtils.isNotEmpty(ig333Info.getPpsdid())) {
					if (childFlowDetailMap.get(ig333Info.getPpsdid()) == null) {
						Map<String, FlowDetail> childStepMap = new HashMap<String, FlowDetail>();
						childStepMap.put(ig333Info.getPsdid(), flowDetail);
						childFlowDetailMap.put(ig333Info.getPpsdid(), childStepMap);
					} else {
						childFlowDetailMap.get(ig333Info.getPpsdid()).put(ig333Info.getPsdid(), flowDetail);
					}
				} else {
					flowDetailMap.put(ig333Info.getPsdid(), flowDetail);
				}

			}
		}

		// 对父节点流程排序
		ComputingTime computingTime = new ComputingTime();
		Map<String, String> parentStepMap = computingTime.getOrderStep(dto.getPdid(), "null");
		List<FlowDetail> parentStepList = new ArrayList<FlowDetail>();
		Integer parentIndex = 0;
		for (String key : parentStepMap.keySet()) {
			parentIndex++;
			FlowDetail flowDetail = flowDetailMap.get(key);
			flowDetail.setSequence(parentIndex.toString());
			parentStepList.add(flowDetail);
		}
		// 遍历childFlowDetailMap将子节点放到父节点的List中
		for (String ppsdid : childFlowDetailMap.keySet()) {
			Map<String, String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String, FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for (String psdid : childStepMap.keySet()) {
				childList.add(childFlowMap.get(psdid));
			}
			for (FlowDetail parentStep : parentStepList) {
				if (parentStep.getIg333Info().getPsdid().equals(ppsdid)) {
					// 给子流程节点编号
					Integer childIndex = 0;
					String parentSequence = parentStep.getSequence();
					for (FlowDetail childStep : childList) {
						childIndex++;
						childStep.setSequence(parentSequence + "." + childIndex);
					}
					parentStep.setChildStepList(childList);
				}
			}
		}

		// 遍历拼接界面显示
		StringBuffer outPrintStr = new StringBuffer();
		outPrintStr.append("<table class='table_style4'>");
		outPrintStr.append("<tr><th width='5%'>序号</th><th width='12%'>名称</th> <th width='12%'>恢复时间</th><th width='20%'>描述</th><th>应急资源</th><th width='15%'>参与人</th></tr>");
		for (FlowDetail flowDetail : parentStepList) {
			appendString(outPrintStr, flowDetail, 1);
			if (flowDetail.getChildStepList() != null && flowDetail.getChildStepList().size() > 0) {
				for (FlowDetail childStep : flowDetail.getChildStepList()) {
					appendString(outPrintStr, childStep, 0);
				}
				outPrintStr.append("</table>");
			}

		}
		outPrintStr.append("</table>");
		dto.setOutPrintStr(outPrintStr.toString());

		return dto;
	}

	
	/**
	 * 查询导出场景中的流程详细信息
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchExportFlowDetail(IGDRM01DTO dto,Integer prid) throws BLException {

		UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
		IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
		SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
		ig333Cond.setPdid(dto.getPdid());
		// 节点list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		// 结果集List
		Map<String, FlowDetail> flowDetailMap = new HashMap<String, FlowDetail>();
		// 存放子节点的List
		Map<String, Map<String, FlowDetail>> childFlowDetailMap = new HashMap<String, Map<String, FlowDetail>>();
		if (ig333List != null && ig333List.size() > 0) {
			for (IG333Info ig333Info : ig333List) {
				FlowDetail flowDetail = new FlowDetail();
				// 存储节点
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				// 查询560中的数据并添加到flowDetail中
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				//遍历应急资源，并且组建类别Map;
				if(ig560List != null && ig560List.size()>0){
					if(flowDetail.getSoc0118Map()==null){
						flowDetail.setSoc0118Map(new HashMap<String, List<SOC0118VWInfo>>());
					}
					for(IG560Info ig560Info : ig560List){
						if(ig560Info.getDfvalue()!=null &&!ig560Info.getDfvalue().isEmpty()){
							String type = ig560Info.getDfvalue().split("_SOC_")[1];
							soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
							soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
							SOC0118VWInfo soc0118VWInfo = soc0118VWBL.searchEntityItem(soc0118Cond).get(0);
							if(flowDetail.getSoc0118Map().get(type)!=null){
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}else{
								flowDetail.getSoc0118Map().put(type, new ArrayList<SOC0118VWInfo>());
								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
								soc0118VWInfoList.add(soc0118VWInfo);
								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
							}
						}
						
					}
				}
				
				//描述
				flowDetail.setDuty(ig333Info.getPsddesc());
				
				//查询是否是应急演练发起的应急指挥流程
				IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
				ig599Cond.setPrid(prid);;
				ig599Cond.setPivarname("指挥流程prid");
				List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
				//演练流程中查询指挥流程的prid，查询指挥流程中场景的参与人
				if(ig599List!=null && ig599List.size()>0&&StringUtils.isNotEmpty(ig599List.get(0).getPivarvalue())){
					prid = Integer.parseInt(ig599List.get(0).getPivarvalue());	
				}
				
				/*
				 * 硬性认为表格的每一行都只包含一个节点的参与人信息，那么行号和节点ID都是相对唯一的只，那么处理数据分为如下几部
				 * 1、遍历表格式表单值的每一行，将同一节点信息放在一起
				 */
				Map<String, Map<String, String>> tempMap = new HashMap<String, Map<String,String>>();
				IG898SearchCondImpl tableFormCond = new IG898SearchCondImpl();
				tableFormCond.setPrid(prid);
				List<IG898Info> tableFormValueList = workFlowOperationBL.searchTableFormValue(tableFormCond);
				for(IG898Info info:tableFormValueList){
					if(tempMap.get(info.getPvrownumber()) == null){
						tempMap.put(info.getPvrownumber(), new HashMap<String, String>());
					}
					if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDID.equals(info.getPvcolname())){
						tempMap.get(info.getPvrownumber()).put("psdid", info.getPvalue());
	        		}else if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
	        			tempMap.get(info.getPvrownumber()).put("users", info.getPvalue());
	        		}
				}
				
				Map<String, Map<String, UserInfo>> psdUserMap = new HashMap<String, Map<String,UserInfo>>();
				for(Iterator<Entry<String, Map<String, String>>> iter = tempMap.entrySet().iterator();iter.hasNext();){
					Entry<String, Map<String, String>> entry = iter.next();
					Map<String, String> map = entry.getValue();
					String psdid = map.get("psdid");
					String us = map.get("users");
					Map<String, UserInfo> temp = new LinkedHashMap<String, UserInfo>();
					if(StringUtils.isNotEmpty(us)){
						//角色_role_用户
	        			String[] roleusers = us.split("_roleuser_");
	        			for(String roleuser : roleusers){
	        				if(StringUtils.isNotBlank(roleuser)){
	        					//[0]角色id#角色name , [1]用户id#用户name_user_用户id#用户name
	        					String[] roleAnduser = roleuser.split("_role_");
	        					if(roleAnduser != null && roleAnduser.length > 1){
	        						//用户id#用户name
	    							String[] users = roleAnduser[1].split("_user_");
	    							for(String user : users){
	    								if(StringUtils.isNotBlank(user)){
	    									String[] userinfo = user.split("#");
	    									if(userinfo.length > 1){
	    										UserInfoVW u = new UserInfoVW();
	    										u.setUsername(userinfo[1]);
	    										temp.put(userinfo[0], u);
	    									}
	    								}
	    							}
	        					}
	        				}
	        			}
					}
					psdUserMap.put(psdid, temp);
				}
				
				// 查询参与人并存储
				
				Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
				//查询当前节点已处理参与人
				List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipantDoneRole(prid, ig333Info.getPsdid());
				if(!ppList.isEmpty()){
					for(IG337Info info:ppList){
						if(StringUtils.isNotEmpty(info.getPpuserid())){
							UserInfoVW user = new UserInfoVW();
							user.setUsername(info.getPpusername());
							userMap.put(info.getPpuserid(), user);
						}
					}
				}else{
					if(!psdUserMap.isEmpty()){
						Map<String, UserInfo> map = psdUserMap.get(ig333Info.getPsdid());
						if(map != null){
							for(Iterator<Entry<String, UserInfo>> iter = map.entrySet().iterator();iter.hasNext();){
								Entry<String, UserInfo> entry = iter.next();
								userMap.put(entry.getKey(), entry.getValue());
							}
						}
					}else{
						ig222Cond = new IG222SearchCondImpl();
						userCond = new UserInfoSearchCondImpl();
						ig222Cond.setPsdid(ig333Info.getPsdid());
						List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
						if (ig222List != null && ig222List.size() > 0) {
							for (IG222Info ig222Info : ig222List) {
								if (StringUtils.isNotEmpty(ig222Info.getUserid())) {
									userCond.setUserida(ig222Info.getUserid());
									List<UserInfo> userList = userBL.searchUserInfo(userCond);
									if (userList != null && userList.size() > 0) {
										UserInfo user = (UserInfo) userList.get(0);
										userMap.put(user.getUserida(), user);
									}
								} else {
									List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
									if (userInfoList != null&& userInfoList.size() > 0) {
										for (int i = 0; i < userInfoList.size(); i++) {
											UserInfoVW user = new UserInfoVW();
											BeanUtils.copyProperties(userInfoList.get(i), user);
											user.setUserida(((UserTB) userInfoList.get(i)).getUserid());
											userMap.put(user.getUserida(), user);
										}
									}
								}
							}
						}
						
					}
				}
				flowDetail.setUserMap(userMap);
				
				// 判断是否为子节点
				if (StringUtils.isNotEmpty(ig333Info.getPpsdid())) {
					if (childFlowDetailMap.get(ig333Info.getPpsdid()) == null) {
						Map<String, FlowDetail> childStepMap = new HashMap<String, FlowDetail>();
						childStepMap.put(ig333Info.getPsdid(), flowDetail);
						childFlowDetailMap.put(ig333Info.getPpsdid(), childStepMap);
					} else {
						childFlowDetailMap.get(ig333Info.getPpsdid()).put(ig333Info.getPsdid(), flowDetail);
					}
				} else {
					flowDetailMap.put(ig333Info.getPsdid(), flowDetail);
				}

			}
		}
		
		
		// 对父节点流程排序
		ComputingTime computingTime = new ComputingTime();
		Map<String, String> parentStepMap = computingTime.getOrderStep(dto.getPdid(), "null");
		List<FlowDetail> parentStepList = new ArrayList<FlowDetail>();
		Integer parentIndex = 0;
		for (String key : parentStepMap.keySet()) {
			parentIndex++;
			FlowDetail flowDetail = flowDetailMap.get(key);
			flowDetail.setSequence(parentIndex.toString());
			parentStepList.add(flowDetail);
		}
		// 遍历childFlowDetailMap将子节点放到父节点的List中
		for (String ppsdid : childFlowDetailMap.keySet()) {
			Map<String, String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String, FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for (String psdid : childStepMap.keySet()) {
				childList.add(childFlowMap.get(psdid));
			}
			for (FlowDetail parentStep : parentStepList) {
				if (parentStep.getIg333Info().getPsdid().equals(ppsdid)) {
					// 给子流程节点编号
					Integer childIndex = 0;
					String parentSequence = parentStep.getSequence();
					for (FlowDetail childStep : childList) {
						childIndex++;
						childStep.setSequence(parentSequence + "." + childIndex);
					}
					parentStep.setChildStepList(childList);
				}
			}
		}

		// 遍历拼接界面显示
		StringBuffer outPrintStr = new StringBuffer();
		outPrintStr.append("<table class='table_style4'>");
		outPrintStr.append("<tr><th width='5%'>序号</th><th width='12%'>名称</th> <th width='12%'>恢复时间</th><th width='20%'>描述</th><th>应急资源</th><th width='15%'>参与人</th></tr>");
		for (FlowDetail flowDetail : parentStepList) {
			appendString(outPrintStr, flowDetail, 1);
			if (flowDetail.getChildStepList() != null && flowDetail.getChildStepList().size() > 0) {
				for (FlowDetail childStep : flowDetail.getChildStepList()) {
					appendString(outPrintStr, childStep, 0);
				}
				outPrintStr.append("</table>");
			}

		}
		outPrintStr.append("</table>");
		dto.setOutPrintStr(outPrintStr.toString());
		dto.setParentStepList(parentStepList);
		return dto;
	}

	
	private void appendString(StringBuffer outPrintStr, FlowDetail flowDetail, int sign) {
		if (sign == 0) {
			outPrintStr.append("<tr><td colspan='5' style='border-width:0px;'><table class='table_style3'>");
		}

		outPrintStr.append("<tr><td style=\"text-align:center;\">" + flowDetail.getSequence() + "</td>");
		outPrintStr.append("<td>" + flowDetail.getIg333Info().getPsdname() + "</td>");
		// 预计恢复时间
		outPrintStr.append("<td>" + flowDetail.getIg333Info().getBysequence() + "分钟</td>");
		if (flowDetail.getDuty() != null) {
			outPrintStr.append("<td  style='text-align:left;'>" + flowDetail.getDuty() + "</td>");
		} else {
			outPrintStr.append("<td ></td>");
		}
		outPrintStr.append("<td width='38%' style='text-align:left;'>");
		if (flowDetail.getSoc0118Map() != null && flowDetail.getSoc0118Map().size() > 0) {
			for(String key:flowDetail.getSoc0118Map().keySet()){
				//计算空格的数量
				String spaceStr = "";
				for(int spaceIndex = 0;spaceIndex<20;spaceIndex++){
					spaceStr += "&nbsp;";
					
				}
				List<SOC0118VWInfo> soc0118List = flowDetail.getSoc0118Map().get(key);
				for (int index = 0; index < soc0118List.size(); index++) {
				SOC0118VWInfo soc0118 = soc0118List.get(index);
					// if (index == soc0118List.size() - 1) {
					// outPrintStr.append(spaceStr+"<span style='cursor: pointer;color: blue;' onclick='openSOCDetail("
					// + soc0118.getId() + "," + soc0118.getEiid() + ")'>" +
					// soc0118.getEiname() + "</span><br/>");
					// }else
					if (index == 0) {
					outPrintStr.append( key.split("_")[1]+"：<br/>"+spaceStr+"<span style='cursor: pointer;color: blue;' onclick='openSOCDetail(" + soc0118.getId() + "," + soc0118.getEiid() + ")'>" + soc0118.getEiname() + "</span><br/>");
				}else {
					outPrintStr.append(spaceStr+"<span style='cursor: pointer;color: blue;' onclick='openSOCDetail(" + soc0118.getId() + "," + soc0118.getEiid() + ")'>" + soc0118.getEiname() + "</span><br/>");
				}
			}
				
			}
		}
		outPrintStr.append("<td   style='text-align:left;'>");

		if (flowDetail.getUserMap() != null && flowDetail.getUserMap().size() > 0) {
			int index = 0;
			for (String key : flowDetail.getUserMap().keySet()) {
				index++;
				if (index < flowDetail.getUserMap().size()) {
					outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "、");
				} else {
					outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
				}
			}
		}
		outPrintStr.append("</td></tr>");
		if (sign == 0) {
			outPrintStr.append("</table></td></tr>");
		}
	}
	
	/**
	 * 导出场景信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO exportSenceDetail(IGDRM01DTO dto,Integer prid) throws BLException {
		log.debug("=============导出场景详细信息开始===============");
		WritableWorkbook wwb;
		try {
			wwb = Workbook.createWorkbook(dto.getOps());
			WritableSheet ws = wwb.createSheet("场景基本信息", 10); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableFont rootWf = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat rootWcf = new WritableCellFormat(rootWf);
			rootWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			rootWcf.setAlignment(Alignment.CENTRE);
			rootWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			rootWcf.setLocked(false);
			// 定义信息列格式
			WritableCellFormat contentWcf = new WritableCellFormat(wf);
			contentWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			contentWcf.setAlignment(Alignment.LEFT);
			contentWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			contentWcf.setLocked(false);

			// 定义标题格式
			WritableCellFormat titWcf = new WritableCellFormat(wf);
			titWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			titWcf.setAlignment(Alignment.LEFT);
			titWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			titWcf.setBackground(Colour.BLUE_GREY);

			int blankRow = 2, blankCol = 0;
			// 定义各列的宽度
			ws.setColumnView(blankCol + 1, 18);
			ws.setColumnView(blankCol + 2, 30);
			ws.setColumnView(blankCol + 3, 30);
			ws.setColumnView(blankCol + 4, 30);
			ws.setColumnView(blankCol + 5, 20);
			ws.setColumnView(blankCol + 6, 60);
			ws.setColumnView(blankCol + 7, 60);
			//场景基本信息
			Label label = new Label(blankCol + 1, blankRow - 1, "场景基本信息", rootWcf);
			
			ws.addCell(label);
			//合并单元格题目
			ws.mergeCells(blankCol + 1, blankRow - 1, blankCol + 6, blankRow - 1);
			
			ws.addCell(new Label(blankCol + 1, blankRow, "场景编号", titWcf));
			ws.addCell(new Label(blankCol + 2, blankRow, "场景名称", titWcf));
			ws.addCell(new Label(blankCol + 3, blankRow, "场景所属机构", titWcf));
			ws.addCell(new Label(blankCol + 4, blankRow, "是否已演练", titWcf));
			ws.addCell(new Label(blankCol + 5, blankRow, "预计恢复时间", titWcf));
			ws.addCell(new Label(blankCol + 6, blankRow, "场景说明", titWcf));
			PlanInfo planInfo = dto.getPlanInfo();
			int curRow = blankRow + 1;
			log.debug("=============导出场景基本信息开始===============");
			//场景编号
			ws.addCell(new Label(blankCol + 1, curRow, planInfo.getEilabel(), contentWcf));
			//场景名称
			ws.addCell(new Label(blankCol + 2, curRow, planInfo.getScename(), contentWcf));
			//机构
			ws.addCell(new Label(blankCol + 3, curRow, planInfo.getOrgname(), contentWcf));
			//是否演练
			ws.addCell(new Label(blankCol + 4, curRow, planInfo.getIsplan(), contentWcf));
			//场景使用最大时间
			ws.addCell(new Label(blankCol + 5, curRow, dto.getMaxTime()+"分钟", contentWcf));
			//使用说明
			ws.addCell(new Label(blankCol + 6, curRow, planInfo.getScedes(), contentWcf));
			log.debug("=============导出场景基本信息结束===============");
			//场景详细信息
			curRow ++;
			label = new Label(blankCol + 1, curRow, "场景步骤的详细信息", rootWcf);
			
			ws.addCell(label);
			ws.mergeCells(blankCol + 1, curRow, blankCol + 7, curRow);
			curRow ++;
						
			ws.addCell(new Label(blankCol + 1, curRow, "序号", titWcf));
			ws.addCell(new Label(blankCol + 2, curRow, "节点名称", titWcf));
			ws.addCell(new Label(blankCol + 3, curRow, "恢复时间", titWcf));
			ws.addCell(new Label(blankCol + 4, curRow, "描述", titWcf));
			ws.addCell(new Label(blankCol + 5, curRow, "应急资源分类", titWcf));
			ws.addCell(new Label(blankCol + 6, curRow, "应急资源", titWcf));
			ws.addCell(new Label(blankCol + 7, curRow, "参与人", titWcf));
			//场景步骤的详细信息内容
			log.debug("=============导出场景步骤的详细信息内容开始===============");
			List<FlowDetail> parentStepList = dto.getParentStepList();
			if(parentStepList!=null && parentStepList.size()>0){
				curRow ++;
				for(int stepIndex = 0;stepIndex<parentStepList.size();stepIndex++){
					FlowDetail flowDetail = parentStepList.get(stepIndex);
					Map<String, List<SOC0118VWInfo>> soc0118Map = flowDetail.getSoc0118Map();
					//判断是否有应急资源，有应急资源则根据应急资源的数量导出并且合并单元格，否则直接导出
					if(soc0118Map!=null && soc0118Map.size()>0){
						int startRoleRow = curRow;
						//节点序号
						ws.addCell(new Label(blankCol + 1, curRow, (stepIndex+1)+"", contentWcf));
						//节点名称
						ws.addCell(new Label(blankCol + 2, curRow, flowDetail.getIg333Info().getPsdname(), contentWcf));
						//预期使用时间
						ws.addCell(new Label(blankCol + 3, curRow, flowDetail.getIg333Info().getBysequence() + "分钟", contentWcf));
						//任务描述
						ws.addCell(new Label(blankCol + 4, curRow, flowDetail.getDuty(), contentWcf));
						//拼接参与人
						StringBuffer outPrintStr = new StringBuffer();
						if (flowDetail.getUserMap() != null && flowDetail.getUserMap().size() > 0) {
							int index = 0;
							for (String key : flowDetail.getUserMap().keySet()) {
								index++;
								if (index < flowDetail.getUserMap().size()) {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "、");
								} else {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
								}
							}
						}
						//参与人
						ws.addCell(new Label(blankCol + 7, curRow, outPrintStr.toString(), contentWcf));
						
						for(String key:soc0118Map.keySet()){
							//应急资源分类
							ws.addCell(new Label(blankCol + 5, curRow, key.split("_")[1], contentWcf));
							List<SOC0118VWInfo> list = soc0118Map.get(key);
							for(SOC0118VWInfo soc0118VWInfo :list){
								ws.addCell(new Label(blankCol + 6, curRow, soc0118VWInfo.getEiname(), contentWcf));
								curRow++;
							}
							//应急资源
							ws.mergeCells(blankCol + 5, startRoleRow, blankCol + 5, curRow - 1);
						}
						//合并单元格
						ws.mergeCells(blankCol + 1, startRoleRow, blankCol + 1, curRow - 1);
						ws.mergeCells(blankCol + 2, startRoleRow, blankCol + 2, curRow - 1);
						ws.mergeCells(blankCol + 3, startRoleRow, blankCol + 3, curRow - 1);
						ws.mergeCells(blankCol + 4, startRoleRow, blankCol + 4, curRow - 1);
						ws.mergeCells(blankCol + 7, startRoleRow, blankCol + 7, curRow - 1);
					}else{
						//编号
						ws.addCell(new Label(blankCol + 1, curRow, (stepIndex+1)+"", contentWcf));
						//节点名称
						ws.addCell(new Label(blankCol + 2, curRow, flowDetail.getIg333Info().getPsdname(), contentWcf));
						//节点预期使用时间
						ws.addCell(new Label(blankCol + 3, curRow, flowDetail.getIg333Info().getBysequence() + "分钟", contentWcf));
						//任务描述
						ws.addCell(new Label(blankCol + 4, curRow, flowDetail.getDuty(), contentWcf));
						//拼接参与人
						StringBuffer outPrintStr = new StringBuffer();
						if (flowDetail.getUserMap() != null && flowDetail.getUserMap().size() > 0) {
							int index = 0;
							for (String key : flowDetail.getUserMap().keySet()) {
								index++;
								if (index < flowDetail.getUserMap().size()) {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "、");
								} else {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
								}
							}
						}
						//应急资源分类(占位用)
						ws.addCell(new Label(blankCol + 5, curRow, "", contentWcf));
						//应急资源名称(占位用)
						ws.addCell(new Label(blankCol + 6, curRow, "", contentWcf));
						//参与人
						ws.addCell(new Label(blankCol + 7, curRow, outPrintStr.toString(), contentWcf));
						curRow ++;
					}
				}
			}
			log.debug("=============导出场景步骤的详细信息内容结束===============");
			wwb.setProtected(false);
			wwb.write();
			wwb.close();
		} catch (IOException e) {
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		}
		log.debug("=============导出应急组织架构完成===============");

		return dto;
	}
	/**
	 * 查询业务系统
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO switchMaster(IGDRM01DTO dto) throws BLException{
		log.debug("==========查询业务系统开始==========");
		String flowType = "";
		String prid = dto.getPrid().toString();
		IG731BL ig731BL = (IG731BL) WebApplicationSupport.getBean("ig731BL");
		IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivarvalue(prid);
		cond.setPivarname("场景prid");
		List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(cond);
		if(ig599InfoList!=null && ig599InfoList.size()>0){
			flowType = "场景prid";
		}else{
			flowType = "场景相关流程prid";
		}
		log.debug("==========场景prid="+prid+"====场景类型表单(场景prid为应急指挥流程，场景相关流程prid为演练流程)="+flowType+"=====");
		List<IG731Info> ig731List = ig731BL.searchIG731InfoBySePrid(dto.getPrid(),flowType);
		log.debug("==========查询业务系统结束==========");
		String result = "";
		//判断业务系统资产是否存在
		if(ig731List!=null && ig731List.size()>0){
			
			//获取切换主备按钮的url
			String switchMasterUrl = ResourceUtility.getString("SWITCHMASTER_URL");
			BufferedReader in = null;
			for(IG731Info ig731Info:ig731List){
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("systemid", ig731Info.getEiid().toString()));
				
				HttpParams params = new BasicHttpParams();
				params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1 * 60 * 1000);
				params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 1 * 60 * 1000);
				
				// 实现将请求 的参数封装封装到HttpEntity中。
				UrlEncodedFormEntity entity;
				try {
					entity = new UrlEncodedFormEntity(list, "utf-8");
					// 使用HttpPost请求方式
					HttpPost httpPost = new HttpPost(switchMasterUrl);
					// 设置请求参数到Form中。
					httpPost.setEntity(entity);
					log.debug("========================访问url开始===========================");
					log.debug("========================访问url地址："+switchMasterUrl+".do?systemid="+ig731Info.getEiid().toString()+"===========================");
					// 实例化一个默认的Http客户端
					DefaultHttpClient client = new DefaultHttpClient(params);
					// 执行请求，并获得响应数据
					HttpResponse httpResponse = client.execute(httpPost);
					String result1 = EntityUtils.toString(httpResponse.getEntity());
					System.out.println(result1);
					result += result1+"\n";
					log.debug("========================访问url返回结果：+"+result1+"===========================");
					log.debug("========================访问url结束===========================");
				} catch (Exception e) {
					log.debug("========================访问url失败原因："+e.getMessage()+"===========================");
					log.debug("========================访问url失败===========================");
					e.printStackTrace();
				}
			}
		}
		dto.setResult(result);
		return dto;
	}

	/**
	 * 根据场景查询触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============查询场景触发策略开始==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		PlanInfo planInfo = planBL.findByPK(form.getSenceid());

		ResponseStrategySearchCondImpl cond = new ResponseStrategySearchCondImpl();

		cond.setSenceid(form.getSenceid());

		List<ResponseStrategyInfo> responseStrategyList = responseStrategyBL.searchResponseStrategy(cond);


		dto.setPlanInfo(planInfo);
		dto.setResponseStrategyList(responseStrategyList);

		log.info("============查询场景触发策略完成==============");
		return dto;
	}

	/**
	 * 查询单条触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============获取场景触发策略开始==============");
		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		ResponseStrategyInfo responseStrategyInfo = responseStrategyBL.searchResponseStrategyByPK(form.getRsid());

		dto.setResponseStrategyInfo(responseStrategyInfo);

		log.info("============获取场景触发策略完成==============");
		return dto;
	}

	/**
	 * 查询单条触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO saveSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============保存场景触发策略开始==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		ResponseStrategyTB responseStrategyTB = null;
		if (form.getRsid() != null && form.getRsid() > 0) {
			// 修改
			responseStrategyTB = (ResponseStrategyTB) responseStrategyBL.searchResponseStrategyByPK(form.getRsid());
			BeanUtils.copyProperties(form, responseStrategyTB);

			responseStrategyBL.updateResponseStrategy(responseStrategyTB);
		} else {
			responseStrategyTB = new ResponseStrategyTB();
			BeanUtils.copyProperties(form, responseStrategyTB);
			responseStrategyBL.registResponseStrategy(responseStrategyTB);

		}
		log.info("============保存场景触发策略完成==============");
		return dto;


	}
	
	/**
	 * 删除单条触发策略
	 * @param rsid
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO delSenceStrategy(IGDRM01DTO dto) throws BLException{
		log.info("============删除场景触发策略开始==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();
		if(form.getRsid()!=null){
			responseStrategyBL.deleteResponseStrategyByPK(form.getRsid());
		}
		log.info("============保存场景触发策略完成==============");
		return dto;
	}
}
