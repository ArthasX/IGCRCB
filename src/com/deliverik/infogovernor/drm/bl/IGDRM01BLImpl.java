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
 * Ԥ������ҵ���߼�ʵ��
 *
 */
public class IGDRM01BLImpl extends BaseBLImpl implements IGDRM01BL {

	static Log log = LogFactory.getLog(IGDRM01BLImpl.class);
	/**����״̬����ҵ���߼�����BL*/
	protected IG333BL ig333BL;
	/**���̲����߶���ҵ���߼�����BL*/
	protected IG222BL ig222BL;
	/**���̲����߶���ҵ���߼�����BL*/
	protected UserRoleBL userRoleBL;
	/**�û�����BL*/
	protected UserBL userBL;
    /**�û�����BL*/
    protected RoleBL roleBL;
	 /**SOC0151BL����*/
    protected SOC0151BL soc0151BL;
	 /**SOC0117BL����*/
	protected SOC0117BL soc0117BL;
	 /**PlanBL����*/
	protected PlanBL planBL;
	/** ���ݷ�����ϢBL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	/** ������ϸ��ϢBL */
	protected StructureRoleBL structureRoleBL;
	/** ���¹���API�� */
	protected FlowSetBL flowSetBL;
    /** ��ѯ�๦��API�� */
	protected FlowSearchBL flowSearchBL;
    /**���̲����߶���ҵ���߼�����BL*/
	protected IG560BL ig560BL;
	/**���̲����߶���ҵ���߼�����BL*/
	protected IG561BL ig561BL;
    /**���̲����߶���ҵ���߼�����BL*/
	protected AttachmentBL attachmentBL;
	
	/**ÿ���ڵ��Ԥ�ڿ�ʼʱ��*/
	protected Map<String,Integer> nodeTimeMap = new HashMap<String,Integer>();
	/**��¼���ߵ�����*/
	protected List<StepLine> lineArr = new ArrayList<StepLine>();
	/**��¼�߷�������*/
	protected Map<String,IG333Info> stepMap = new HashMap<String,IG333Info>();
	/** �ʲ��ϲ���ͼ */
	protected SOC0118VWBL soc0118VWBL;
	/** �ʲ���ϵBl */
	protected SOC0119BL soc0119BL;

	/** ������Ӧ����BL */
	protected ResponseStrategyBL responseStrategyBL;

	/**��ֵBL*/
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
	 * ��ȡnodeTimeMap  
	 * @return nodeTimeMap 
	 */
	public Map<String, Integer> getNodeTimeMap() {
		return nodeTimeMap;
	}
	/**  
	 * ����nodeTimeMap  
	 * @param nodeTimeMap
	 */
	
	public void setNodeTimeMap(Map<String, Integer> nodeTimeMap) {
		this.nodeTimeMap = nodeTimeMap;
	}
	/**  
	 * ��ȡlineArr  
	 * @return lineArr 
	 */
	public List<StepLine> getLineArr() {
		return lineArr;
	}
	/**  
	 * ����lineArr  
	 * @param lineArr
	 */
	
	public void setLineArr(List<StepLine> lineArr) {
		this.lineArr = lineArr;
	}
	/**  
	 * ��ȡstepMap  
	 * @return stepMap 
	 */
	public Map<String, IG333Info> getStepMap() {
		return stepMap;
	}
	/**  
	 * ����stepMap  
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
	 * ��ѯ�ڵ�״̬��Ϣ
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStautsInfo(IGDRM01DTO dto)throws BLException{
		String stepPdid = dto.getIgdrm0101Form().getStepPdid();
		IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
		ig007Cond.setPdid(stepPdid);//����ID
		ig007Cond.setPidname("Ӧ����Դ");//������
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
		//Ӧ����Դ pidid
		String pidid = lst_ProcessInfoDef.get(0).getPidid();
		
		//�ڵ���Ϣ��ѯ
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(stepPdid);
		List<IG333Info> ig333Lt = ig333BL.searchIG333Info(cond);
		//����������״̬�ڵ����򣨹رսڵ�ŵ����нڵ�����λ�ã�
		List<IG333Info> ig333List = new ArrayList<IG333Info>();
		for(IG333Info info:ig333Lt){
			////���˵��رսڵ�
			if("C".equals(info.getPsdcode())){
				continue;
			}
			ig333List.add(info);
		}
		//��󽫹رսڵ���ӵ�List��
		ig333List.add(ig333Lt.get(1));
		
		//�ڵ�MAP-LST
		List<Map<String,Object>> stautsMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> stautsMap = null;
		//ѭ���ڵ�    
		for(int i = 0; i<ig333List.size() ; i++){
			stautsMap = new LinkedHashMap<String,Object>();
			//��ѯӦ����Դ��Ӧ��eiid
			IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
			ig560Cond.setPsdid_l(ig333List.get(i).getPsdid());
			ig560Cond.setPidid_l(pidid);
			ig560Cond.setUsedToAll("F");
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			//Ӧ����Դ��Ӧ��eiid
			String eiid = "";
			//Ӧ����Դ��Ӧ��eiid
			String einame = "";
			//Ӧ����Դ��Ӧ��eiid
			Integer eiversion = 0;
			if(null!=ig560List&&ig560List.size()>0){
				//Ӧ����Դ��Ӧ��eiid
				eiid = ig560List.get(0).getDfvalue();
			}
			//���״̬����Ӧ���ʲ� ��ֵ
			if(!StringUtils.isBlank(eiid)){
				//�ʲ�ʵ����Ϣ
				EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(Integer.valueOf(eiid));
				//Ӧ����Դ��Ӧ��eiid
				einame = eiInfo.getEiname();
				//Ӧ����Դ��Ӧ��eiid
				eiversion = eiInfo.getEiversion();
			}
			stautsMap.put("eiid",nullToEmpty(eiid));
			stautsMap.put("einame",nullToEmpty(einame));
			stautsMap.put("eiversion",eiversion);
			
			//״̬�ڵ�����-��������
			stautsMap.put("psdNo",i+1);
			//״̬�ڵ�����-��������
			stautsMap.put("psdname", ig333List.get(i).getPsdname());
			
			//�����������ַ���
			String participantNameStr = "";
			String roleNameStr = "";
			IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
			ig222Cond.setPsdid(ig333List.get(i).getPsdid());
			List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
			//������Աlist
			List<Integer> roleIdList = new ArrayList<Integer>();
			//������Աlist
			List<String> userIdList = new ArrayList<String>();
			for(int j = 0; j<ig222List.size() ; j++){
				String userid = ig222List.get(j).getUserid();
				Integer roleid = ig222List.get(j).getRoleid();
				//���������ָ������
				if(StringUtils.isNotBlank(userid)){
					userIdList.add(userid);
				}else{//���������û��ָ������ ��ȡ�����ɫ��������
					Integer roleId = ig222List.get(j).getRoleid();
					UserRoleSearchCondImpl userroleSearchCondImpl = new UserRoleSearchCondImpl();
					//ͨ��roleId��ȡuserIdList
					userroleSearchCondImpl.setRoleid(roleId);
					List<UserRole> userRoleList = userRoleBL.searchUserRole(userroleSearchCondImpl);
					for(UserRole ur:userRoleList){
						userIdList.add(ur.getUserid());
					}
				}
				roleIdList.add(roleid);
			}
			//ȥ�ظ�userID
			HashSet<String> set = new HashSet<String>(userIdList); 
			userIdList.clear(); 
			userIdList.addAll(set); 
			//ͨ��id��ȡuserMail
			for(String userID : userIdList){
				User userinfo = userBL.searchUserByKey(userID);
				participantNameStr+=userinfo.getUsername()+",";
			}
			//ȥ�����һ���ַ�","
			if(!"".equals(participantNameStr)){
				participantNameStr = participantNameStr.substring(0,participantNameStr.length()-1);
			}
			//״̬�ڵ������
			stautsMap.put("participant", participantNameStr);
			
			//ȥ�ظ�roleID
			HashSet<Integer> roleSet = new HashSet<Integer>(roleIdList); 
			roleIdList.clear(); 
			roleIdList.addAll(roleSet); 
			//ͨ��id��ȡroleName
			for(Integer roleId : roleIdList){
				Role roleInfo = roleBL.searchRoleByKey(roleId);
				roleNameStr+=roleInfo.getRolename()+",";
			}
			//ȥ�����һ���ַ�","
			if(!"".equals(roleNameStr)){
				roleNameStr = roleNameStr.substring(0,roleNameStr.length()-1);
			}
			//״̬�ڵ�����Ŷ�
			stautsMap.put("roleName", roleNameStr);
			
			stautsMapList.add(stautsMap);
		}
		Gson gson = new Gson();
		String json = gson.toJson(stautsMapList);
		return json;
	}
	/**
	 * ��ѯ����ʵ���ڵ����Ѿ��������Ϣ
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStautsFormLog(IGDRM01DTO dto)throws BLException{
		String stepPdid = dto.getIgdrm0101Form().getStepPdid();
		String stepPrid = dto.getIgdrm0101Form().getStepPrid();
		//��ѯ��
		IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
		ig007Cond.setPdid(stepPdid);
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
		//����˵��
		String desPidid = "";
		//���ý��
		String resPidid = "";
		//����
		String attPidid = "";
		//��ȡpidid
		for(IG007Info ig007Info:lst_ProcessInfoDef){
			if("����˵��".equals(ig007Info.getPidname())){
				desPidid = ig007Info.getPidid();
			}
			else if("���ý��".equals(ig007Info.getPidname())){
				resPidid = ig007Info.getPidid();
			}
			else if("����".equals(ig007Info.getPidname())){
				attPidid = ig007Info.getPidid();
			}
		}
		
		IG561SearchCondImpl ig561Cond = new IG561SearchCondImpl();
		ig561Cond.setPrid_q(stepPrid);
		List<IG561Info> ig561List = ig561BL.searchIG561(ig561Cond);
		Map<String,IG561Info> ig561Map = new HashMap<String,IG561Info>();
		for(IG561Info info:ig561List){//��װ561map
			ig561Map.put(info.getPsdid()+"_"+info.getPidid(), info);
		}
		
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(stepPdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(cond);
		//�Լ��ڵ�
		List<Map<String,Object>> stautsMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> stautsMap = null;
		//ѭ��һ���ڵ�    
		for(int i = 0; i<ig333List.size() ; i++){
			stautsMap = new LinkedHashMap<String,Object>();
			if(ig561Map.containsKey(ig333List.get(i).getPsdid()+"_"+desPidid)){
				IG561Info  desInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+desPidid);
				IG561Info  resInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+resPidid);
				IG561Info  attInfo = ig561Map.get(ig333List.get(i).getPsdid()+"_"+attPidid);
				//״̬�ڵ�����-��������
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
	 * ��ѯӦ����֯�ܹ���Ϣ
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public IGDRM01DTO getOrgInfo(IGDRM01DTO dto)throws BLException{
		//������ϸ��Ϣ��ѯ
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		//��֯�ܹ�ccid
		cond.setCcid("230");
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//��֯�ܹ���Ϣ
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
			//Ӧ����֯�ܹ�������ɫlist
			List<StructureRoleInfo> srList= structureRoleBL.searchStructureRole(srCond);
			//��֯�ܹ� �ڵ�����Ӧ�Ľ�ɫ��Ϣ
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
	 * ��ѯ��������״̬������key
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getAttKey(IGDRM01DTO dto)throws BLException{
		IGDRM0101Form form = dto.getIgdrm0101Form();
		String pdid = form.getStepPdid();
		List<ProcessStatusInfo> psList = flowSearchBL.searchProcessStatusList(pdid);
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//����ID
		cond.setPidname("����");//������
		List<IG007Info> lst_ProcessInfoDef = workFlowDefinitionBL.searchProcessInfoDef(cond);
		String pidid = lst_ProcessInfoDef.get(0).getPidid();
		
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		ig560Cond.setPsdid_l(pdid);
		ig560Cond.setUsedToAll("F");
		List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
		//״̬�ڵ㸽����Ϣ
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
					attKeyXml.append(" attKey= \""+nullToEmpty(attKey)+"\"");//����attKey
					String attLabel = "";
					if(null!=attKey&&""!=attKey){
						List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attKey);
						if(null!=attList&&attList.size()>0){
							attLabel = attList.get(0).getAttname();
							attLabel = attLabel.split("_")[1];
						}
					}
					attKeyXml.append(" attLabel= \""+attLabel+"\"");//����attKey
					attKeyXml.append(" />");
				}
			}
		}
		attKeyXml.append("</attList>");
		return attKeyXml.toString();
	}
	/**
	 * ��ѯ��������״̬����XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateForm(IGDRM01DTO dto)throws BLException{
		IGDRM0101Form form = dto.getIgdrm0101Form();
		String pdid = form.getStepPdid();
		List<ProcessStatusInfo> psList = flowSearchBL.searchProcessStatusList(pdid);
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);//����ID
		cond.setPidmode("2");//״̬����
		cond.setPiduse("1");
		List<IG007Info> formLst = workFlowDefinitionBL.searchProcessInfoDef(cond);
		Map<String,IG007Info> ig007Map = new HashMap<String,IG007Info>();
		for(IG007Info ig007Info:formLst){
			//xml��ȥ������
			if(!ig007Info.getPidname().equals("����")&&!ig007Info.getPidname().equals("ҵ��ϵͳ")){
				ig007Map.put(ig007Info.getPidid(), ig007Info);
			}
		}
		//�������������нڵ�
		//״̬�ڵ㸽����Ϣ
		StringBuffer formListXml = new StringBuffer("<StateFormList>");
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		ig560Cond.setPsdid_l(pdid);
		ig560Cond.setUsedToAll("F");
		List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
		Map<String,IG560Info> ig560Map = new HashMap<String,IG560Info>();
		//���������µ�״̬��ֵ ��Ϣ��װ��map
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
				if(!ig007Info.getPidname().equals("����")&&!ig007Info.getPidname().equals("ҵ��ϵͳ")){
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
	
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * �����ʲ���ѯҳ-��ʼ��ҳ������
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
			//�豸��Ϣ��ѯ����ȡ�� 
			pcond = new PlanSearchCondImpl();
			pcond.setEsyscoding_like(soc0117.getEsyscoding());
			//�ж�Ȩ�ޣ������ҵ�������Թ���Ա
			if(getRoleType(dto.getLoginUser().getUserid())){
			}
			else{
				//��������
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
	 * ��ѯ�����ʲ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchPlan(IGDRM01DTO dto)throws BLException{
		//�����ʲ���ѯҳ-��ʼ��ҳ������
		initIgdrm0102Action(dto);
		IGDRM0104Form form = dto.getIgdrm0104Form();
		PlanSearchCondImpl cond = new PlanSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
//		//�ж�Ȩ�ޣ������ҵ�������Թ���Ա
//		if(getRoleType(dto.getLoginUser().getUserid())){
//		}else{
//			//��������
//			cond.setEiorgsyscoding_like(dto.getLoginUser().getOrgid());
//		}
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.planBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========Ԥ����ѯ���ݲ�����========");
			//Ԥ����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("=======Ԥ����ѯ���ݼ�������========");
			//Ԥ����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<PlanInfo> planList = this.planBL.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setPlanList(planList);
		log.debug("========Ԥ����ѯ��������========");
		return dto;
		
	}
	
	/**
	 * ��ȡ��¼�˵�roleid���ж��Ƿ�Ϊҵ�������Թ���Ա
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public boolean getRoleType(String uesrid) throws BLException{
		
		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
		//���ò�ѯ����
		urcond.setUserid(uesrid);
		List<UserRole> urList = userRoleBL.searchUserRole(urcond);
		for(UserRole ur :urList){
			//��¼��Ա���ڽ�ɫroleid
			Integer roleid = ur.getRoleid();
			RoleBL roleBL = (RoleBL) WebApplicationSupport.getBean("roleBL");
			Role roleInfo = roleBL.searchRoleByKey(roleid);
			//PLAN_ADMINISTRATOR_ROLETYPE����ҵ�������Թ���Ա ��ɫ���ڽ�ɫ����-Ӧ��ִ�в㣺roleTYPE
			if(IGPRDCONSTANTS.PLAN_ADMINISTRATOR_ROLETYPE.equals(roleInfo.getRoletype())){
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ѯӦ���ƶ�ģ����
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
	 * ��ѯӦ���ƶȷ����б�
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityList(IGDRM01DTO dto) throws BLException {
		IGDRM0105Form form = (IGDRM0105Form) dto.getForm();
		
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		
		cond.setEparcoding(form.getEparcoding());
		
		// Ӧ���ƶȷ����ѯ����ȡ��
		int totalCount = this.soc0117BL.getEntitySearchCount(cond);

		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// Ӧ���ƶȷ����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			// Ӧ���ƶȷ����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
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
	 * ��ѯ������Ϣ�洢��form��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSceneByEiid(IGDRM01DTO dto) throws BLException {
		IGDRM0108Form form = dto.getIgdrm0108Form();;
		IG731BL ig731BL = (IG731BL) WebApplicationSupport.getBean("ig731BL");
		//��ѯ���̹����ĳ����ʲ�eiid
		IG731Info ig731Info = ig731BL.searchSenceBySePrid(form.getPrid(), form.getFlowType()).get(0);
		form.setEiid(ig731Info.getEiid().toString());
		dto.setIgdrm0108Form(form);
		return dto;
	}
	
	
	
	/**
	 * ��ѯ������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getScene(IGDRM01DTO dto) throws BLException {

		log.debug("==========��ѯ������ϸ��Ϣ��ʼ==========");

		IGDRM0108Form form = dto.getIgdrm0108Form();

		PlanInfo planInfo = planBL.findByPK(Integer.valueOf(form.getEiid()));
		//����ID
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

		log.debug("==========��ѯ������ϸ��Ϣ���==========");

		return dto;
	}
	
	/**
	 * ��ѯ�����е�������ϸ��Ϣ
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
		// �ڵ�list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		// �����List
		Map<String, FlowDetail> flowDetailMap = new HashMap<String, FlowDetail>();
		// ����ӽڵ��List
		Map<String, Map<String, FlowDetail>> childFlowDetailMap = new HashMap<String, Map<String, FlowDetail>>();
		if (ig333List != null && ig333List.size() > 0) {
			for (IG333Info ig333Info : ig333List) {
				FlowDetail flowDetail = new FlowDetail();
				// �洢�ڵ�
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				// ��ѯ560�е����ݲ���ӵ�flowDetail��
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				//����Ӧ����Դ�������齨���Map;
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
				
				//����
				flowDetail.setDuty(ig333Info.getPsddesc());
				// ��ѯ�����˲��洢
				Map<String, UserInfo> userMap = new LinkedHashMap<String, UserInfo>();
				// ��ѯ�����˲��洢
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
				// �ж��Ƿ�Ϊ�ӽڵ�
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

		// �Ը��ڵ���������
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
		// ����childFlowDetailMap���ӽڵ�ŵ����ڵ��List��
		for (String ppsdid : childFlowDetailMap.keySet()) {
			Map<String, String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String, FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for (String psdid : childStepMap.keySet()) {
				childList.add(childFlowMap.get(psdid));
			}
			for (FlowDetail parentStep : parentStepList) {
				if (parentStep.getIg333Info().getPsdid().equals(ppsdid)) {
					// �������̽ڵ���
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

		// ����ƴ�ӽ�����ʾ
		StringBuffer outPrintStr = new StringBuffer();
		outPrintStr.append("<table class='table_style4'>");
		outPrintStr.append("<tr><th width='5%'>���</th><th width='12%'>����</th> <th width='12%'>�ָ�ʱ��</th><th width='20%'>����</th><th>Ӧ����Դ</th><th width='15%'>������</th></tr>");
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
	 * ��ѯ���������е�������ϸ��Ϣ
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
		// �ڵ�list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		// �����List
		Map<String, FlowDetail> flowDetailMap = new HashMap<String, FlowDetail>();
		// ����ӽڵ��List
		Map<String, Map<String, FlowDetail>> childFlowDetailMap = new HashMap<String, Map<String, FlowDetail>>();
		if (ig333List != null && ig333List.size() > 0) {
			for (IG333Info ig333Info : ig333List) {
				FlowDetail flowDetail = new FlowDetail();
				// �洢�ڵ�
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				// ��ѯ560�е����ݲ���ӵ�flowDetail��
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				//����Ӧ����Դ�������齨���Map;
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
				
				//����
				flowDetail.setDuty(ig333Info.getPsddesc());
				
				//��ѯ�Ƿ���Ӧ�����������Ӧ��ָ������
				IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
				ig599Cond.setPrid(prid);;
				ig599Cond.setPivarname("ָ������prid");
				List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
				//���������в�ѯָ�����̵�prid����ѯָ�������г����Ĳ�����
				if(ig599List!=null && ig599List.size()>0&&StringUtils.isNotEmpty(ig599List.get(0).getPivarvalue())){
					prid = Integer.parseInt(ig599List.get(0).getPivarvalue());	
				}
				
				/*
				 * Ӳ����Ϊ����ÿһ�ж�ֻ����һ���ڵ�Ĳ�������Ϣ����ô�кźͽڵ�ID�������Ψһ��ֻ����ô�������ݷ�Ϊ���¼���
				 * 1���������ʽ��ֵ��ÿһ�У���ͬһ�ڵ���Ϣ����һ��
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
						//��ɫ_role_�û�
	        			String[] roleusers = us.split("_roleuser_");
	        			for(String roleuser : roleusers){
	        				if(StringUtils.isNotBlank(roleuser)){
	        					//[0]��ɫid#��ɫname , [1]�û�id#�û�name_user_�û�id#�û�name
	        					String[] roleAnduser = roleuser.split("_role_");
	        					if(roleAnduser != null && roleAnduser.length > 1){
	        						//�û�id#�û�name
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
				
				// ��ѯ�����˲��洢
				
				Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();
				//��ѯ��ǰ�ڵ��Ѵ��������
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
				
				// �ж��Ƿ�Ϊ�ӽڵ�
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
		
		
		// �Ը��ڵ���������
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
		// ����childFlowDetailMap���ӽڵ�ŵ����ڵ��List��
		for (String ppsdid : childFlowDetailMap.keySet()) {
			Map<String, String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String, FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for (String psdid : childStepMap.keySet()) {
				childList.add(childFlowMap.get(psdid));
			}
			for (FlowDetail parentStep : parentStepList) {
				if (parentStep.getIg333Info().getPsdid().equals(ppsdid)) {
					// �������̽ڵ���
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

		// ����ƴ�ӽ�����ʾ
		StringBuffer outPrintStr = new StringBuffer();
		outPrintStr.append("<table class='table_style4'>");
		outPrintStr.append("<tr><th width='5%'>���</th><th width='12%'>����</th> <th width='12%'>�ָ�ʱ��</th><th width='20%'>����</th><th>Ӧ����Դ</th><th width='15%'>������</th></tr>");
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
		// Ԥ�ƻָ�ʱ��
		outPrintStr.append("<td>" + flowDetail.getIg333Info().getBysequence() + "����</td>");
		if (flowDetail.getDuty() != null) {
			outPrintStr.append("<td  style='text-align:left;'>" + flowDetail.getDuty() + "</td>");
		} else {
			outPrintStr.append("<td ></td>");
		}
		outPrintStr.append("<td width='38%' style='text-align:left;'>");
		if (flowDetail.getSoc0118Map() != null && flowDetail.getSoc0118Map().size() > 0) {
			for(String key:flowDetail.getSoc0118Map().keySet()){
				//����ո������
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
					outPrintStr.append( key.split("_")[1]+"��<br/>"+spaceStr+"<span style='cursor: pointer;color: blue;' onclick='openSOCDetail(" + soc0118.getId() + "," + soc0118.getEiid() + ")'>" + soc0118.getEiname() + "</span><br/>");
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
					outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "��");
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
	 * ����������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO exportSenceDetail(IGDRM01DTO dto,Integer prid) throws BLException {
		log.debug("=============����������ϸ��Ϣ��ʼ===============");
		WritableWorkbook wwb;
		try {
			wwb = Workbook.createWorkbook(dto.getOps());
			WritableSheet ws = wwb.createSheet("����������Ϣ", 10); // ����һ��������

			// ���õ�Ԫ������ָ�ʽ
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableFont rootWf = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat rootWcf = new WritableCellFormat(rootWf);
			rootWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			rootWcf.setAlignment(Alignment.CENTRE);
			rootWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			rootWcf.setLocked(false);
			// ������Ϣ�и�ʽ
			WritableCellFormat contentWcf = new WritableCellFormat(wf);
			contentWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			contentWcf.setAlignment(Alignment.LEFT);
			contentWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			contentWcf.setLocked(false);

			// ��������ʽ
			WritableCellFormat titWcf = new WritableCellFormat(wf);
			titWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			titWcf.setAlignment(Alignment.LEFT);
			titWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			titWcf.setBackground(Colour.BLUE_GREY);

			int blankRow = 2, blankCol = 0;
			// ������еĿ��
			ws.setColumnView(blankCol + 1, 18);
			ws.setColumnView(blankCol + 2, 30);
			ws.setColumnView(blankCol + 3, 30);
			ws.setColumnView(blankCol + 4, 30);
			ws.setColumnView(blankCol + 5, 20);
			ws.setColumnView(blankCol + 6, 60);
			ws.setColumnView(blankCol + 7, 60);
			//����������Ϣ
			Label label = new Label(blankCol + 1, blankRow - 1, "����������Ϣ", rootWcf);
			
			ws.addCell(label);
			//�ϲ���Ԫ����Ŀ
			ws.mergeCells(blankCol + 1, blankRow - 1, blankCol + 6, blankRow - 1);
			
			ws.addCell(new Label(blankCol + 1, blankRow, "�������", titWcf));
			ws.addCell(new Label(blankCol + 2, blankRow, "��������", titWcf));
			ws.addCell(new Label(blankCol + 3, blankRow, "������������", titWcf));
			ws.addCell(new Label(blankCol + 4, blankRow, "�Ƿ�������", titWcf));
			ws.addCell(new Label(blankCol + 5, blankRow, "Ԥ�ƻָ�ʱ��", titWcf));
			ws.addCell(new Label(blankCol + 6, blankRow, "����˵��", titWcf));
			PlanInfo planInfo = dto.getPlanInfo();
			int curRow = blankRow + 1;
			log.debug("=============��������������Ϣ��ʼ===============");
			//�������
			ws.addCell(new Label(blankCol + 1, curRow, planInfo.getEilabel(), contentWcf));
			//��������
			ws.addCell(new Label(blankCol + 2, curRow, planInfo.getScename(), contentWcf));
			//����
			ws.addCell(new Label(blankCol + 3, curRow, planInfo.getOrgname(), contentWcf));
			//�Ƿ�����
			ws.addCell(new Label(blankCol + 4, curRow, planInfo.getIsplan(), contentWcf));
			//����ʹ�����ʱ��
			ws.addCell(new Label(blankCol + 5, curRow, dto.getMaxTime()+"����", contentWcf));
			//ʹ��˵��
			ws.addCell(new Label(blankCol + 6, curRow, planInfo.getScedes(), contentWcf));
			log.debug("=============��������������Ϣ����===============");
			//������ϸ��Ϣ
			curRow ++;
			label = new Label(blankCol + 1, curRow, "�����������ϸ��Ϣ", rootWcf);
			
			ws.addCell(label);
			ws.mergeCells(blankCol + 1, curRow, blankCol + 7, curRow);
			curRow ++;
						
			ws.addCell(new Label(blankCol + 1, curRow, "���", titWcf));
			ws.addCell(new Label(blankCol + 2, curRow, "�ڵ�����", titWcf));
			ws.addCell(new Label(blankCol + 3, curRow, "�ָ�ʱ��", titWcf));
			ws.addCell(new Label(blankCol + 4, curRow, "����", titWcf));
			ws.addCell(new Label(blankCol + 5, curRow, "Ӧ����Դ����", titWcf));
			ws.addCell(new Label(blankCol + 6, curRow, "Ӧ����Դ", titWcf));
			ws.addCell(new Label(blankCol + 7, curRow, "������", titWcf));
			//�����������ϸ��Ϣ����
			log.debug("=============���������������ϸ��Ϣ���ݿ�ʼ===============");
			List<FlowDetail> parentStepList = dto.getParentStepList();
			if(parentStepList!=null && parentStepList.size()>0){
				curRow ++;
				for(int stepIndex = 0;stepIndex<parentStepList.size();stepIndex++){
					FlowDetail flowDetail = parentStepList.get(stepIndex);
					Map<String, List<SOC0118VWInfo>> soc0118Map = flowDetail.getSoc0118Map();
					//�ж��Ƿ���Ӧ����Դ����Ӧ����Դ�����Ӧ����Դ�������������Һϲ���Ԫ�񣬷���ֱ�ӵ���
					if(soc0118Map!=null && soc0118Map.size()>0){
						int startRoleRow = curRow;
						//�ڵ����
						ws.addCell(new Label(blankCol + 1, curRow, (stepIndex+1)+"", contentWcf));
						//�ڵ�����
						ws.addCell(new Label(blankCol + 2, curRow, flowDetail.getIg333Info().getPsdname(), contentWcf));
						//Ԥ��ʹ��ʱ��
						ws.addCell(new Label(blankCol + 3, curRow, flowDetail.getIg333Info().getBysequence() + "����", contentWcf));
						//��������
						ws.addCell(new Label(blankCol + 4, curRow, flowDetail.getDuty(), contentWcf));
						//ƴ�Ӳ�����
						StringBuffer outPrintStr = new StringBuffer();
						if (flowDetail.getUserMap() != null && flowDetail.getUserMap().size() > 0) {
							int index = 0;
							for (String key : flowDetail.getUserMap().keySet()) {
								index++;
								if (index < flowDetail.getUserMap().size()) {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "��");
								} else {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
								}
							}
						}
						//������
						ws.addCell(new Label(blankCol + 7, curRow, outPrintStr.toString(), contentWcf));
						
						for(String key:soc0118Map.keySet()){
							//Ӧ����Դ����
							ws.addCell(new Label(blankCol + 5, curRow, key.split("_")[1], contentWcf));
							List<SOC0118VWInfo> list = soc0118Map.get(key);
							for(SOC0118VWInfo soc0118VWInfo :list){
								ws.addCell(new Label(blankCol + 6, curRow, soc0118VWInfo.getEiname(), contentWcf));
								curRow++;
							}
							//Ӧ����Դ
							ws.mergeCells(blankCol + 5, startRoleRow, blankCol + 5, curRow - 1);
						}
						//�ϲ���Ԫ��
						ws.mergeCells(blankCol + 1, startRoleRow, blankCol + 1, curRow - 1);
						ws.mergeCells(blankCol + 2, startRoleRow, blankCol + 2, curRow - 1);
						ws.mergeCells(blankCol + 3, startRoleRow, blankCol + 3, curRow - 1);
						ws.mergeCells(blankCol + 4, startRoleRow, blankCol + 4, curRow - 1);
						ws.mergeCells(blankCol + 7, startRoleRow, blankCol + 7, curRow - 1);
					}else{
						//���
						ws.addCell(new Label(blankCol + 1, curRow, (stepIndex+1)+"", contentWcf));
						//�ڵ�����
						ws.addCell(new Label(blankCol + 2, curRow, flowDetail.getIg333Info().getPsdname(), contentWcf));
						//�ڵ�Ԥ��ʹ��ʱ��
						ws.addCell(new Label(blankCol + 3, curRow, flowDetail.getIg333Info().getBysequence() + "����", contentWcf));
						//��������
						ws.addCell(new Label(blankCol + 4, curRow, flowDetail.getDuty(), contentWcf));
						//ƴ�Ӳ�����
						StringBuffer outPrintStr = new StringBuffer();
						if (flowDetail.getUserMap() != null && flowDetail.getUserMap().size() > 0) {
							int index = 0;
							for (String key : flowDetail.getUserMap().keySet()) {
								index++;
								if (index < flowDetail.getUserMap().size()) {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername() + "��");
								} else {
									outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
								}
							}
						}
						//Ӧ����Դ����(ռλ��)
						ws.addCell(new Label(blankCol + 5, curRow, "", contentWcf));
						//Ӧ����Դ����(ռλ��)
						ws.addCell(new Label(blankCol + 6, curRow, "", contentWcf));
						//������
						ws.addCell(new Label(blankCol + 7, curRow, outPrintStr.toString(), contentWcf));
						curRow ++;
					}
				}
			}
			log.debug("=============���������������ϸ��Ϣ���ݽ���===============");
			wwb.setProtected(false);
			wwb.write();
			wwb.close();
		} catch (IOException e) {
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		}
		log.debug("=============����Ӧ����֯�ܹ����===============");

		return dto;
	}
	/**
	 * ��ѯҵ��ϵͳ
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO switchMaster(IGDRM01DTO dto) throws BLException{
		log.debug("==========��ѯҵ��ϵͳ��ʼ==========");
		String flowType = "";
		String prid = dto.getPrid().toString();
		IG731BL ig731BL = (IG731BL) WebApplicationSupport.getBean("ig731BL");
		IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivarvalue(prid);
		cond.setPivarname("����prid");
		List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(cond);
		if(ig599InfoList!=null && ig599InfoList.size()>0){
			flowType = "����prid";
		}else{
			flowType = "�����������prid";
		}
		log.debug("==========����prid="+prid+"====�������ͱ�(����pridΪӦ��ָ�����̣������������pridΪ��������)="+flowType+"=====");
		List<IG731Info> ig731List = ig731BL.searchIG731InfoBySePrid(dto.getPrid(),flowType);
		log.debug("==========��ѯҵ��ϵͳ����==========");
		String result = "";
		//�ж�ҵ��ϵͳ�ʲ��Ƿ����
		if(ig731List!=null && ig731List.size()>0){
			
			//��ȡ�л�������ť��url
			String switchMasterUrl = ResourceUtility.getString("SWITCHMASTER_URL");
			BufferedReader in = null;
			for(IG731Info ig731Info:ig731List){
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("systemid", ig731Info.getEiid().toString()));
				
				HttpParams params = new BasicHttpParams();
				params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1 * 60 * 1000);
				params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 1 * 60 * 1000);
				
				// ʵ�ֽ����� �Ĳ�����װ��װ��HttpEntity�С�
				UrlEncodedFormEntity entity;
				try {
					entity = new UrlEncodedFormEntity(list, "utf-8");
					// ʹ��HttpPost����ʽ
					HttpPost httpPost = new HttpPost(switchMasterUrl);
					// �������������Form�С�
					httpPost.setEntity(entity);
					log.debug("========================����url��ʼ===========================");
					log.debug("========================����url��ַ��"+switchMasterUrl+".do?systemid="+ig731Info.getEiid().toString()+"===========================");
					// ʵ����һ��Ĭ�ϵ�Http�ͻ���
					DefaultHttpClient client = new DefaultHttpClient(params);
					// ִ�����󣬲������Ӧ����
					HttpResponse httpResponse = client.execute(httpPost);
					String result1 = EntityUtils.toString(httpResponse.getEntity());
					System.out.println(result1);
					result += result1+"\n";
					log.debug("========================����url���ؽ����+"+result1+"===========================");
					log.debug("========================����url����===========================");
				} catch (Exception e) {
					log.debug("========================����urlʧ��ԭ��"+e.getMessage()+"===========================");
					log.debug("========================����urlʧ��===========================");
					e.printStackTrace();
				}
			}
		}
		dto.setResult(result);
		return dto;
	}

	/**
	 * ���ݳ�����ѯ��������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============��ѯ�����������Կ�ʼ==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		PlanInfo planInfo = planBL.findByPK(form.getSenceid());

		ResponseStrategySearchCondImpl cond = new ResponseStrategySearchCondImpl();

		cond.setSenceid(form.getSenceid());

		List<ResponseStrategyInfo> responseStrategyList = responseStrategyBL.searchResponseStrategy(cond);


		dto.setPlanInfo(planInfo);
		dto.setResponseStrategyList(responseStrategyList);

		log.info("============��ѯ���������������==============");
		return dto;
	}

	/**
	 * ��ѯ������������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============��ȡ�����������Կ�ʼ==============");
		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		ResponseStrategyInfo responseStrategyInfo = responseStrategyBL.searchResponseStrategyByPK(form.getRsid());

		dto.setResponseStrategyInfo(responseStrategyInfo);

		log.info("============��ȡ���������������==============");
		return dto;
	}

	/**
	 * ��ѯ������������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO saveSenceStrategy(IGDRM01DTO dto) throws BLException {
		log.info("============���泡���������Կ�ʼ==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();

		ResponseStrategyTB responseStrategyTB = null;
		if (form.getRsid() != null && form.getRsid() > 0) {
			// �޸�
			responseStrategyTB = (ResponseStrategyTB) responseStrategyBL.searchResponseStrategyByPK(form.getRsid());
			BeanUtils.copyProperties(form, responseStrategyTB);

			responseStrategyBL.updateResponseStrategy(responseStrategyTB);
		} else {
			responseStrategyTB = new ResponseStrategyTB();
			BeanUtils.copyProperties(form, responseStrategyTB);
			responseStrategyBL.registResponseStrategy(responseStrategyTB);

		}
		log.info("============���泡�������������==============");
		return dto;


	}
	
	/**
	 * ɾ��������������
	 * @param rsid
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO delSenceStrategy(IGDRM01DTO dto) throws BLException{
		log.info("============ɾ�������������Կ�ʼ==============");

		IGDRM0119Form form = (IGDRM0119Form) dto.getForm();
		if(form.getRsid()!=null){
			responseStrategyBL.deleteResponseStrategyByPK(form.getRsid());
		}
		log.info("============���泡�������������==============");
		return dto;
	}
}
