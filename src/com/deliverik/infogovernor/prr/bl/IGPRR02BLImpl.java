/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.prr.bl.task.CopyReadUserBL;
import com.deliverik.infogovernor.prr.dto.IGPRR02DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0114Form;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCondImpl;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;


/**
 * 概述:抄阅人
 * 功能描述：抄阅人
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
public class IGPRR02BLImpl extends BaseBLImpl implements IGPRR02BL{
	 static Log log = LogFactory.getLog(IGPRR02BLImpl.class);	
	
	 private final static String XML_HEADER= "%3C?xml%20version=%221.0%22%20encoding=%22utf-8%22%20?%3E";
	
	/**抄阅人BL*/
	protected CopyReadUserBL copyReadUserBL;
	
	/** 用户和角色BL */
	protected UserRoleBL userRoleBL;
	
	/**更新功能API类 */
	protected FlowSetBL flowSetBL;

	/** 基础数据BL */
	protected CodeListUtils codeListUtils;
	
	/** 基础数据BL */
	protected SysManageBL sysManageBL;
	
	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected UserBL userBL;
   
	/** 发邮件API类 */
    protected SendMailBL sendMailBL;
    
	/**
	 * 抄阅人BL设定
	 *
	 * @param copyReadUserBL 抄阅人BL
	 */
	public void setCopyReadUserBL(CopyReadUserBL copyReadUserBL) {
		this.copyReadUserBL = copyReadUserBL;
	}
	
	public UserRoleBL getUserRoleBL() {
		return userRoleBL;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
	    this.codeListUtils = codeListUtils;
    }
		
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/** 
     * 发邮件API类 设定
     * @param sendMailBL 发邮件API类 
     */
    public void setSendMailBL(SendMailBL sendMailBL) {
        this.sendMailBL = sendMailBL;
    }

    public IGPRR02DTO getPeopleUnderRoleAction(IGPRR02DTO dto)
			throws BLException {		
        //dto参数取得
        IGPRR0114Form form = dto.getIgprr0114form();
		//新建一个map集合，键为角色名称，值为该角色下的所有人 
		Map<String,List<UserRoleInfo>> map_cru = new HashMap<String,List<UserRoleInfo>>();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype("IGCR01");		
		List<UserRoleInfo> list= userRoleBL.searchUserRoleVW(cond);
		boolean flag = false;
		//遍历集合将角色及人员信息放进map集合中
		for(UserRoleInfo userrole:list){
			//判断查询条件
			//用户姓名和机构码查询条件同时存在
		    if(form != null){
		        if(StringUtils.isNotEmpty(form.getUsername_q()) && StringUtils.isNotEmpty(form.getOrgid_q())){
		            if(userrole.getUserid().contains(dto.getIgprr0114form().getUsername_q())&&userrole.getOrgid().equals(dto.getIgprr0114form().getOrgid_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //新建一个临时list集合
		                    List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
		                    list_temp.add(userrole);
		                    map_cru.put(userrole.getRolename(), list_temp);
		                }else{
		                    map_cru.get(userrole.getRolename()).add(userrole);
		                }			
		            }
		        }
		        
		        //只有机构码查询条件存在
		        else if(StringUtils.isNotEmpty(form.getOrgid_q())){
		            if(userrole.getOrgid().equals(form.getOrgid_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //新建一个临时list集合
		                    List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
		                    list_temp.add(userrole);
		                    map_cru.put(userrole.getRolename(), list_temp);
		                }else{
		                    map_cru.get(userrole.getRolename()).add(userrole);
		                }	
		            }
		        }
		        //只有用户姓名查询条件存在
		        else if(StringUtils.isNotEmpty(form.getUsername_q())){
		            if(userrole.getUserid().contains(form.getUsername_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //新建一个临时list集合
		                    List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
		                    list_temp.add(userrole);
		                    map_cru.put(userrole.getRolename(), list_temp);
		                }else{
		                    map_cru.get(userrole.getRolename()).add(userrole);
		                }	
		            }
		        } else{
		            flag = true;
		        }
		    }else{
		        flag = true;
		    }
			//没有查询条件
			if(flag){
				if(map_cru.get(userrole.getRolename().toString())==null){
					//新建一个临时list集合
					List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
					list_temp.add(userrole);
					map_cru.put(userrole.getRolename(), list_temp);
				}else{
					map_cru.get(userrole.getRolename()).add(userrole);
				}	
			}
			
		}
		dto.setMap_cru(map_cru);
		return dto;
	}

	public IGPRR02DTO getCopyReadInfoByCondAction(IGPRR02DTO dto)
			throws BLException {
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//form取得
		IGPRR0114Form form = dto.getIgprr0114form();
		//实例化cond
		CopyReadUserSearchCondImpl cond = new CopyReadUserSearchCondImpl();
		//如果form不为空则将将条件放进cond里面
		if(form!=null){
			//如果流程名称不为空则将流程名称放进cond里面
			if(StringUtils.isNotEmpty(form.getPrtitle())){
				cond.setPrtitle(form.getPrtitle());
			}
			//如果是否已经查看不为空则将流程名称放进cond里面
			if(StringUtils.isNotEmpty(form.getIslook())){
				cond.setIslook(form.getIslook());
			}
		}
		cond.setPruserid(dto.getUser().getUserid());
		List<CopyReadUserInfo> list = null;
		if(dto.getPagingDto()!=null){
			//得到记录总条数
			int totalcount = copyReadUserBL.getCopyReadUserCount(cond);
			pDto.setTotalCount(totalcount);
			//将查询条件传入后台，得到处理结果
			list = copyReadUserBL.getCopyReadUserInfo(cond,pDto.getFromCount(), pDto.getPageDispCount());
		}else{
			list = copyReadUserBL.getCopyReadUserInfo(cond,0, 0);
		}	
		dto.setList(list);
		return dto;
	}
	
    /**
     * 添加抄阅人
     * @param dto 
     * @return dto
     */
	public IGPRR02DTO saveCopyReadInfoByPkAction(IGPRR02DTO dto)
			throws BLException {
		
		
		//根据主键查询流程信息
		IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getIgprr0114form().getPrid()));
		//查询流程参与者表
		List<IG337Info> list_ig337 = workFlowOperationBL.searchProcessParticipantTodoRole(ig500.getPrid(), ig500.getPrstatus());
		//根据添加的抄阅人的人数来确定添加多少数据
		for(String userid:dto.getIgprr0114form().getUserid()){
			//将字符串拆开
			String user[] = userid.split("_");
			//查询该抄阅人在此流程中是否已存在
			//根据流程id查询抄阅人表将查询结果的用户id拼成字符串			
			CopyReadUserSearchCondImpl cond = new CopyReadUserSearchCondImpl();
			cond.setPrid(Integer.parseInt(dto.getIgprr0114form().getPrid()));
			List<CopyReadUserInfo> list = copyReadUserBL.getCopyReadUserInfo(cond, 0, 0);
			//遍历集合查询是否存在此抄阅人
			for(CopyReadUserInfo info:list){
				if(info.getPruserid().equals(user[0])){
//					throw new BLException("IGPRR0114.E001");
					throw new BLException("IGPRR0201.E002");
				}
			}
		}
		//查询抄阅人角色名称和角色类型
		String copytypename = sysManageBL.searchCodeValue(IGPRR01BLType.ROLE_TYPE, IGPRR01BLType.COPYUSER_TYPE);
		//根据角色类型查询抄阅人的角色名称
		List<Role> list_r = roleBL.getRoleByType(IGPRR01BLType.COPYUSER_TYPE);
		String copyname = "";
		if(list_r.size()!=0){
			copyname=list_r.get(0).getRolename();
		}
		
		// 邮箱集合
		List<String> receiverList = new ArrayList<String>();
		//根据添加的抄阅人的人数来确定添加多少数据
		for(String userid:dto.getIgprr0114form().getUserid()){
			//将字符串拆开
			String user[] = userid.split("_");		
			//新建一个抄阅人实体
			CopyReadUserTB copyReadUserTB = new CopyReadUserTB();
			copyReadUserTB.setPrid(ig500.getPrid());
			copyReadUserTB.setPrserialnum(ig500.getPrserialnum());
			copyReadUserTB.setPrtitle(ig500.getPrtitle());
			copyReadUserTB.setPrpdname(ig500.getPrpdname());			
			copyReadUserTB.setPrrolename(copyname);
			copyReadUserTB.setPrusername(user[3]);
			copyReadUserTB.setCrustatus(copytypename);
			copyReadUserTB.setPruserid(user[0]);
			copyReadUserTB.setPrassigntime("");
			copyReadUserTB.setPrpdid(ig500.getPrpdid());
			copyReadUserTB.setPrstarttime(ig500.getPropentime());
			//提交时的当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			copyReadUserTB.setPrassigntime(df.format(new Date()));
			//提交时查看状态标识为0（未查看）
			copyReadUserTB.setIslook("0");
			copyReadUserBL.registCopyReadUser(copyReadUserTB);			
			workFlowOperationBL.addRecordLog(ig500.getPrid(),
					userBL.searchUserByKey(dto.getUser().getUserid()),
					list_ig337.get(0).getPproleid(), "添加"+copyname+"（"+user[3]+"）",
					"抄阅", null, Constants.PROCESS_LOG_TYPE_PROCESSING, "07", null);
			receiverList.add(dto.getUser().getUseremail());
			dto.setIg500(ig500);	
		}		
		
		// 给通知人发生邮件
		sendEmail(ig500, receiverList);
//		dto.addMessage(new ActionMessage("IGPRR0114.I001"));
		dto.addMessage(new ActionMessage("IGPRR0201.I001"));
		return dto;
	}

	/**
	 * 发送邮件
	 * 
	 * @param ig500 流程信息
	 * @param receiverList 需要发生的邮箱集合
	 */
	private void sendEmail(IG500Info ig500, List<String> receiverList){
	    StringBuffer msm = new StringBuffer();
        msm.append("尊敬的用户：<br /><br/>");
        msm.append("有工单需要您确认。<br />");
        msm.append("工单号：");
        msm.append(ig500.getPrserialnum());
        msm.append("<br />");
        msm.append("工单名称：");
        msm.append(ig500.getPrtitle());
        msm.append("<br />");
        msm.append("工单描述：");
        msm.append(ig500.getPrdesc());
        msm.append("<br />");
        String title = "关于工单通知确认";
        
        if(receiverList.size() > 0){
            sendMailBL.sendMail(title, msm.toString(), (String[])receiverList.toArray(new String[receiverList.size()]));
        }
	}
	public IGPRR02DTO updateIsLookAction(IGPRR02DTO dto) throws BLException {
		//根据主键查询抄阅人表
		CopyReadUserInfo copyReadUserInfo = copyReadUserBL.searchCopyReadUserByPK(dto.getIgprr0114form().getCruid());
		CopyReadUserTB copyReadUserTB = (CopyReadUserTB)SerializationUtils.clone(copyReadUserInfo);
		//查询抄阅人角色名称和角色类型
//		String copytypename = sysManageBL.searchCodeValue(IGPRR01BLType.ROLE_TYPE, IGPRR01BLType.COPYUSER_TYPE);
		//根据角色类型查询抄阅人的角色名称
		List<Role> list_r = roleBL.getRoleByType(IGPRR01BLType.COPYUSER_TYPE);
		String copyname = "";
		if(list_r.size()!=0){
			copyname=list_r.get(0).getRolename();
		}
		//提交时查看状态标识为1（已查看）
		copyReadUserTB.setIslook("1");
		//提交时的当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		copyReadUserTB.setPrlooktime(df.format(new Date()));
		copyReadUserBL.updateCopyReadUser(copyReadUserTB);
		//根据主键查询流程信息
		IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getIgprr0114form().getPrid()));
		//查询流程参与者表
		List<IG337Info> list_ig337 = workFlowOperationBL.searchProcessParticipantTodoRole(ig500.getPrid(), ig500.getPrstatus());
		//添加流程日志表
		WorkFlowLog wfl = new WorkFlowLog();
		wfl.setPrid(ig500.getPrid());
		wfl.setExecutorid(dto.getUser().getUserid());
		if(list_ig337.size()>0){			
			if(list_ig337.get(0).getPprolename()!=null){				
				wfl.setExecutorRoleid(list_ig337.get(0).getPproleid());
			}
		}
		wfl.setAuthuserid("");
		wfl.setComment(copyname+"（"+dto.getUser().getUsername()+"）已确认");
		flowSetBL.setProcessLog(wfl, "确认", Constants.PROCESS_LOG_TYPE_PROCESSING);
		dto.setIg500(ig500);
		
		dto.addMessage(new ActionMessage("IGPRR0114.I002"));
		return dto;
	}

	public IGPRR02DTO generateImageAction(IGPRR02DTO dto) throws BLException {
		if(StringUtils.isNotEmpty(dto.getPrid())){			
			//根据主键查询流程信息
			IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getPrid()));
			dto.setPicuXml(createImageXml(ig500.getPrid(), ig500.getPrserialnum(),
					ig500.getPrtitle(), ig500.getPrdesc(), "1"));
			dto.setPicsXml(createImageXml(ig500.getPrid(), ig500.getPrserialnum(),
					ig500.getPrtitle(), ig500.getPrdesc(), "2"));
			
		}
		return dto;
	}

	/**
	 * 生成影像加密XML
	 * @param eiid 合同ID
	 * @param eilabel 合同编号
	 * @param einame 合同名称
	 * @param eidesc 合同说明
	 * @param operType 操作类型：1查看，2上传
	 * @return XML
	 */
	private String createImageXml(Integer eiid, String eilabel,
			String einame, String eidesc, String operType) {
		//生成XML
		StringBuffer sbf = new StringBuffer();
		sbf.append("<pluginBean>");
		sbf.append("<signType>");
		sbf.append("1");
		sbf.append("</signType>");
		sbf.append("<serviceType>");
		sbf.append(operType);
		sbf.append("</serviceType>");
		sbf.append("<index>");
		sbf.append("<operId>");
		sbf.append(this.codeListUtils.getCodeValue("158", null, null, "5"));
		sbf.append("</operId>");
		sbf.append("<contractId>");
		sbf.append(eiid);
		sbf.append("</contractId>");
		sbf.append("<contractLabel>");
		sbf.append(StringUtils.isEmpty(eilabel) ? "" : eilabel.trim());
		sbf.append("</contractLabel>");
		sbf.append("<contractName>");
		sbf.append(StringUtils.isEmpty(einame) ? "" : einame.trim());
		sbf.append("</contractName>");
		sbf.append("<contractDesc>");
		sbf.append(StringUtils.isEmpty(eidesc) ? "" : eidesc.trim());
		sbf.append("</contractDesc>");
		sbf.append("</index>");
		sbf.append("<fileType>");	
		sbf.append(this.codeListUtils.getCodeValue("158", null, null, "6"));
		sbf.append("</fileType>");
		sbf.append("</pluginBean>");
		//生成加密后的XML
		StringBuffer xml = new StringBuffer();
		xml.append(this.codeListUtils.getCodeValue("158", null, null, "1"));
		xml.append(XML_HEADER);
		log.debug(sbf.toString());
		try {
			xml.append(URLEncoder.encode(sbf.toString(), "UTF-8"));
			xml.append("&nocache=");
			xml.append(new Date());
		} catch (UnsupportedEncodingException e) {
			log.error("异常：", e);
		}
		return xml.toString();
	}
   
}
