/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:������
 * ����������������
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
public class IGPRR02BLImpl extends BaseBLImpl implements IGPRR02BL{
	 static Log log = LogFactory.getLog(IGPRR02BLImpl.class);	
	
	 private final static String XML_HEADER= "%3C?xml%20version=%221.0%22%20encoding=%22utf-8%22%20?%3E";
	
	/**������BL*/
	protected CopyReadUserBL copyReadUserBL;
	
	/** �û��ͽ�ɫBL */
	protected UserRoleBL userRoleBL;
	
	/**���¹���API�� */
	protected FlowSetBL flowSetBL;

	/** ��������BL */
	protected CodeListUtils codeListUtils;
	
	/** ��������BL */
	protected SysManageBL sysManageBL;
	
	/** ��ɫBL */
	protected RoleBL roleBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected UserBL userBL;
   
	/** ���ʼ�API�� */
    protected SendMailBL sendMailBL;
    
	/**
	 * ������BL�趨
	 *
	 * @param copyReadUserBL ������BL
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
     * ���ʼ�API�� �趨
     * @param sendMailBL ���ʼ�API�� 
     */
    public void setSendMailBL(SendMailBL sendMailBL) {
        this.sendMailBL = sendMailBL;
    }

    public IGPRR02DTO getPeopleUnderRoleAction(IGPRR02DTO dto)
			throws BLException {		
        //dto����ȡ��
        IGPRR0114Form form = dto.getIgprr0114form();
		//�½�һ��map���ϣ���Ϊ��ɫ���ƣ�ֵΪ�ý�ɫ�µ������� 
		Map<String,List<UserRoleInfo>> map_cru = new HashMap<String,List<UserRoleInfo>>();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype("IGCR01");		
		List<UserRoleInfo> list= userRoleBL.searchUserRoleVW(cond);
		boolean flag = false;
		//�������Ͻ���ɫ����Ա��Ϣ�Ž�map������
		for(UserRoleInfo userrole:list){
			//�жϲ�ѯ����
			//�û������ͻ������ѯ����ͬʱ����
		    if(form != null){
		        if(StringUtils.isNotEmpty(form.getUsername_q()) && StringUtils.isNotEmpty(form.getOrgid_q())){
		            if(userrole.getUserid().contains(dto.getIgprr0114form().getUsername_q())&&userrole.getOrgid().equals(dto.getIgprr0114form().getOrgid_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //�½�һ����ʱlist����
		                    List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
		                    list_temp.add(userrole);
		                    map_cru.put(userrole.getRolename(), list_temp);
		                }else{
		                    map_cru.get(userrole.getRolename()).add(userrole);
		                }			
		            }
		        }
		        
		        //ֻ�л������ѯ��������
		        else if(StringUtils.isNotEmpty(form.getOrgid_q())){
		            if(userrole.getOrgid().equals(form.getOrgid_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //�½�һ����ʱlist����
		                    List<UserRoleInfo> list_temp = new ArrayList<UserRoleInfo>();
		                    list_temp.add(userrole);
		                    map_cru.put(userrole.getRolename(), list_temp);
		                }else{
		                    map_cru.get(userrole.getRolename()).add(userrole);
		                }	
		            }
		        }
		        //ֻ���û�������ѯ��������
		        else if(StringUtils.isNotEmpty(form.getUsername_q())){
		            if(userrole.getUserid().contains(form.getUsername_q())){
		                if(map_cru.get(userrole.getRolename().toString())==null){
		                    //�½�һ����ʱlist����
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
			//û�в�ѯ����
			if(flag){
				if(map_cru.get(userrole.getRolename().toString())==null){
					//�½�һ����ʱlist����
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
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//formȡ��
		IGPRR0114Form form = dto.getIgprr0114form();
		//ʵ����cond
		CopyReadUserSearchCondImpl cond = new CopyReadUserSearchCondImpl();
		//���form��Ϊ���򽫽������Ž�cond����
		if(form!=null){
			//����������Ʋ�Ϊ�����������ƷŽ�cond����
			if(StringUtils.isNotEmpty(form.getPrtitle())){
				cond.setPrtitle(form.getPrtitle());
			}
			//����Ƿ��Ѿ��鿴��Ϊ�����������ƷŽ�cond����
			if(StringUtils.isNotEmpty(form.getIslook())){
				cond.setIslook(form.getIslook());
			}
		}
		cond.setPruserid(dto.getUser().getUserid());
		List<CopyReadUserInfo> list = null;
		if(dto.getPagingDto()!=null){
			//�õ���¼������
			int totalcount = copyReadUserBL.getCopyReadUserCount(cond);
			pDto.setTotalCount(totalcount);
			//����ѯ���������̨���õ�������
			list = copyReadUserBL.getCopyReadUserInfo(cond,pDto.getFromCount(), pDto.getPageDispCount());
		}else{
			list = copyReadUserBL.getCopyReadUserInfo(cond,0, 0);
		}	
		dto.setList(list);
		return dto;
	}
	
    /**
     * ��ӳ�����
     * @param dto 
     * @return dto
     */
	public IGPRR02DTO saveCopyReadInfoByPkAction(IGPRR02DTO dto)
			throws BLException {
		
		
		//����������ѯ������Ϣ
		IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getIgprr0114form().getPrid()));
		//��ѯ���̲����߱�
		List<IG337Info> list_ig337 = workFlowOperationBL.searchProcessParticipantTodoRole(ig500.getPrid(), ig500.getPrstatus());
		//������ӵĳ����˵�������ȷ����Ӷ�������
		for(String userid:dto.getIgprr0114form().getUserid()){
			//���ַ�����
			String user[] = userid.split("_");
			//��ѯ�ó������ڴ��������Ƿ��Ѵ���
			//��������id��ѯ�����˱���ѯ������û�idƴ���ַ���			
			CopyReadUserSearchCondImpl cond = new CopyReadUserSearchCondImpl();
			cond.setPrid(Integer.parseInt(dto.getIgprr0114form().getPrid()));
			List<CopyReadUserInfo> list = copyReadUserBL.getCopyReadUserInfo(cond, 0, 0);
			//�������ϲ�ѯ�Ƿ���ڴ˳�����
			for(CopyReadUserInfo info:list){
				if(info.getPruserid().equals(user[0])){
//					throw new BLException("IGPRR0114.E001");
					throw new BLException("IGPRR0201.E002");
				}
			}
		}
		//��ѯ�����˽�ɫ���ƺͽ�ɫ����
		String copytypename = sysManageBL.searchCodeValue(IGPRR01BLType.ROLE_TYPE, IGPRR01BLType.COPYUSER_TYPE);
		//���ݽ�ɫ���Ͳ�ѯ�����˵Ľ�ɫ����
		List<Role> list_r = roleBL.getRoleByType(IGPRR01BLType.COPYUSER_TYPE);
		String copyname = "";
		if(list_r.size()!=0){
			copyname=list_r.get(0).getRolename();
		}
		
		// ���伯��
		List<String> receiverList = new ArrayList<String>();
		//������ӵĳ����˵�������ȷ����Ӷ�������
		for(String userid:dto.getIgprr0114form().getUserid()){
			//���ַ�����
			String user[] = userid.split("_");		
			//�½�һ��������ʵ��
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
			//�ύʱ�ĵ�ǰʱ��
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			copyReadUserTB.setPrassigntime(df.format(new Date()));
			//�ύʱ�鿴״̬��ʶΪ0��δ�鿴��
			copyReadUserTB.setIslook("0");
			copyReadUserBL.registCopyReadUser(copyReadUserTB);			
			workFlowOperationBL.addRecordLog(ig500.getPrid(),
					userBL.searchUserByKey(dto.getUser().getUserid()),
					list_ig337.get(0).getPproleid(), "���"+copyname+"��"+user[3]+"��",
					"����", null, Constants.PROCESS_LOG_TYPE_PROCESSING, "07", null);
			receiverList.add(dto.getUser().getUseremail());
			dto.setIg500(ig500);	
		}		
		
		// ��֪ͨ�˷����ʼ�
		sendEmail(ig500, receiverList);
//		dto.addMessage(new ActionMessage("IGPRR0114.I001"));
		dto.addMessage(new ActionMessage("IGPRR0201.I001"));
		return dto;
	}

	/**
	 * �����ʼ�
	 * 
	 * @param ig500 ������Ϣ
	 * @param receiverList ��Ҫ���������伯��
	 */
	private void sendEmail(IG500Info ig500, List<String> receiverList){
	    StringBuffer msm = new StringBuffer();
        msm.append("�𾴵��û���<br /><br/>");
        msm.append("�й�����Ҫ��ȷ�ϡ�<br />");
        msm.append("�����ţ�");
        msm.append(ig500.getPrserialnum());
        msm.append("<br />");
        msm.append("�������ƣ�");
        msm.append(ig500.getPrtitle());
        msm.append("<br />");
        msm.append("����������");
        msm.append(ig500.getPrdesc());
        msm.append("<br />");
        String title = "���ڹ���֪ͨȷ��";
        
        if(receiverList.size() > 0){
            sendMailBL.sendMail(title, msm.toString(), (String[])receiverList.toArray(new String[receiverList.size()]));
        }
	}
	public IGPRR02DTO updateIsLookAction(IGPRR02DTO dto) throws BLException {
		//����������ѯ�����˱�
		CopyReadUserInfo copyReadUserInfo = copyReadUserBL.searchCopyReadUserByPK(dto.getIgprr0114form().getCruid());
		CopyReadUserTB copyReadUserTB = (CopyReadUserTB)SerializationUtils.clone(copyReadUserInfo);
		//��ѯ�����˽�ɫ���ƺͽ�ɫ����
//		String copytypename = sysManageBL.searchCodeValue(IGPRR01BLType.ROLE_TYPE, IGPRR01BLType.COPYUSER_TYPE);
		//���ݽ�ɫ���Ͳ�ѯ�����˵Ľ�ɫ����
		List<Role> list_r = roleBL.getRoleByType(IGPRR01BLType.COPYUSER_TYPE);
		String copyname = "";
		if(list_r.size()!=0){
			copyname=list_r.get(0).getRolename();
		}
		//�ύʱ�鿴״̬��ʶΪ1���Ѳ鿴��
		copyReadUserTB.setIslook("1");
		//�ύʱ�ĵ�ǰʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		copyReadUserTB.setPrlooktime(df.format(new Date()));
		copyReadUserBL.updateCopyReadUser(copyReadUserTB);
		//����������ѯ������Ϣ
		IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getIgprr0114form().getPrid()));
		//��ѯ���̲����߱�
		List<IG337Info> list_ig337 = workFlowOperationBL.searchProcessParticipantTodoRole(ig500.getPrid(), ig500.getPrstatus());
		//���������־��
		WorkFlowLog wfl = new WorkFlowLog();
		wfl.setPrid(ig500.getPrid());
		wfl.setExecutorid(dto.getUser().getUserid());
		if(list_ig337.size()>0){			
			if(list_ig337.get(0).getPprolename()!=null){				
				wfl.setExecutorRoleid(list_ig337.get(0).getPproleid());
			}
		}
		wfl.setAuthuserid("");
		wfl.setComment(copyname+"��"+dto.getUser().getUsername()+"����ȷ��");
		flowSetBL.setProcessLog(wfl, "ȷ��", Constants.PROCESS_LOG_TYPE_PROCESSING);
		dto.setIg500(ig500);
		
		dto.addMessage(new ActionMessage("IGPRR0114.I002"));
		return dto;
	}

	public IGPRR02DTO generateImageAction(IGPRR02DTO dto) throws BLException {
		if(StringUtils.isNotEmpty(dto.getPrid())){			
			//����������ѯ������Ϣ
			IG500Info ig500 = workFlowOperationBL.searchProcessRecordByKey(Integer.parseInt(dto.getPrid()));
			dto.setPicuXml(createImageXml(ig500.getPrid(), ig500.getPrserialnum(),
					ig500.getPrtitle(), ig500.getPrdesc(), "1"));
			dto.setPicsXml(createImageXml(ig500.getPrid(), ig500.getPrserialnum(),
					ig500.getPrtitle(), ig500.getPrdesc(), "2"));
			
		}
		return dto;
	}

	/**
	 * ����Ӱ�����XML
	 * @param eiid ��ͬID
	 * @param eilabel ��ͬ���
	 * @param einame ��ͬ����
	 * @param eidesc ��ͬ˵��
	 * @param operType �������ͣ�1�鿴��2�ϴ�
	 * @return XML
	 */
	private String createImageXml(Integer eiid, String eilabel,
			String einame, String eidesc, String operType) {
		//����XML
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
		//���ɼ��ܺ��XML
		StringBuffer xml = new StringBuffer();
		xml.append(this.codeListUtils.getCodeValue("158", null, null, "1"));
		xml.append(XML_HEADER);
		log.debug(sbf.toString());
		try {
			xml.append(URLEncoder.encode(sbf.toString(), "UTF-8"));
			xml.append("&nocache=");
			xml.append(new Date());
		} catch (UnsupportedEncodingException e) {
			log.error("�쳣��", e);
		}
		return xml.toString();
	}
   
}
