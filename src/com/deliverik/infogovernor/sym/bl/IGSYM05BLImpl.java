/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.infogovernor.sym.bl.task.NoticeBL;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0502Form;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.FormFileInfo;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCondImpl;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM05BLImpl extends BaseBLImpl implements IGSYM05BL {

	static Log log = LogFactory.getLog(IGSYM05BLImpl.class);

	/**
	 * ע��NoticeBL
	 */
	protected NoticeBL noticeBL;
	protected FileUploadBL fileUploadBL;
	protected AttachmentBL attachmentBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**��Ϣ����BL*/
//	protected MessagePushBL messagePushBL;
	
	/**������־*/
//	protected EmergencyLogBL emergencyLogBL;
	
	protected UserBL userBL;
	
	protected UserRoleBL userRoleBL;
	
	protected SendMailBL sendMailBL;
	
	protected SendMessageBL sendMessageBL;
	
	/**
	 * ��Ϣ����BL
	 * @param MessagePushBL messagePushBL
	 */
/*	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}*/
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

/*	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}*/

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}
	
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * ����NoticeBL
	 * @param noticeBL NoticeBL
	 */
	
	public void setNoticeBL(NoticeBL noticeBL) {
		this.noticeBL = noticeBL;
	}
	
	/**
	 * <p>
	 * Description: ȡ����Ҫ������ʾ��֪ͨ��Ϣ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO getNoticeInfo(IGSYM05DTO dto) throws BLException {
		
		int num = Integer.parseInt(ResourceUtility.getString("NOTICE_SHOW_NUM"));//�涨��֪ͨ��ʾ��Ŀ
		int totalCount = noticeBL.getSearchCount(dto
				.getNoticeSearchCond());
		if(totalCount==0){
			return dto;
		}else if(totalCount<=num){
			//����DAO�ӿڲ�ѯ
			List<Notice> noticeList = noticeBL.searchNotice(dto
					.getNoticeSearchCond(),0,totalCount);

			dto.setNoticeCondList(noticeList);
		}else{
			//����DAO�ӿڲ�ѯ
			List<Notice> noticeList = noticeBL.searchNotice(dto
					.getNoticeSearchCond(),0,(num+1));

			dto.setNoticeCondList(noticeList);
		}
		
		
		log.debug("========֪ͨ��ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ֪ͨ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========֪ͨ��ѯ����ʼ========");
		
		//�жϸý�ɫ�Ƿ��ڿ��Կ����Ľ�ɫ��
		NoticeSearchCondImpl cond = new NoticeSearchCondImpl();
		cond.setNid(dto.getNoticeSearchCond().getNid());
		cond.setNname(dto.getNoticeSearchCond().getNname());
		cond.setNtime_from(dto.getNoticeSearchCond().getNtime_from());
		cond.setNtime_to(dto.getNoticeSearchCond().getNtime_to());
		if(dto.getUser() != null){
			UserRoleVWSearchCondImpl ucond = new UserRoleVWSearchCondImpl();
			ucond.setUserid(dto.getUser().getUserid());
			List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(ucond, 0, 0);
			cond.setTuserid(dto.getUser().getUserid());
			String[] roles = new String[roleList.size()];
			for (int i = 0; i < roles.length; i++) {
				roles[i] = String.valueOf(roleList.get(i).getRoleid());
			}
			cond.setTroleids(roles);
		}
		
		// ��ѯ��¼����
		int totalCount = noticeBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<Notice> noticeList = noticeBL.searchNotice(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setNoticeCondList(noticeList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========֪ͨ��ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ֪ͨɾ��
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO deleteNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========֪ͨɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteNid().length;i++ ){
			//֪ͨɾ������
			String nid = dto.getDeleteNid()[i];

			noticeBL.deleteNotice(new Integer(nid));
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "֪ͨ������Ϣ"));
		log.debug("========֪ͨɾ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ֪ͨ����
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO insertNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========֪ͨ��������ʼ========");
		IGSYM0502Form form = (IGSYM0502Form) dto.getAttachFile();
		if(form.getFileList(0).getFile()!=null && !form.getFileList(0).getFile().getFileName().equals("")){
			String attkey = insertFileListAction(dto);
			form.setNattkey(attkey);
		}
		
		String isSend = form.getIsSend();//�Ƿ�����֪ͨ��ʶ
		if("0".equals(isSend)){//������֪ͨʱע��
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
			form.setNtargettype(null);
		} else if("1".equals(isSend)) {
			if ("1".equals(form.getNtargettype()) && !"".equals(form.getNtargetuserid())) {//���ѡ����Ա���Ͳ���Ϊ��
				form.setNtargetroleid(null);
				form.setNtargetrolename(null);
			} else if ("2".equals(form.getNtargettype()) && !"".equals(form.getNtargetroleid())) {//���ѡ���ɫ���Ͳ���Ϊ��
				form.setNtargetuserid(null);
				form.setNtargetusername(null);
			} 
		}
		
		dto.setNotice(form);
		Notice notice = noticeBL.registNotice(dto.getNotice());
		dto.setNotice(notice);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "֪ͨ������Ϣ") );
		
		/*
		�˹����ݲ�ʹ�� 2015-2-9 14:29:40
		String noticeTime = notice.getNtime();
		String noticeContnt = notice.getNdesc();
		String noticeUser = notice.getNusername();
		String noticeId = String.valueOf(notice.getNid());
		
		String isPush = form.getIsPush();
		String pushPrid = form.getPushPrid();*/
		
		String attkey = notice.getNattkey();//��ȡ������Ӧ
		List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attkey);
		String attachment = getNoticeAttachment(attList);
		
		if("1".equals(isSend)) {//����֪ͨ
			if("1".equals(notice.getNtargettype())) {//����Ա����֪ͨ
				String useridString = notice.getNtargetuserid();
				String[] userids = {};
				if(StringUtils.isNotEmpty(useridString)){
					userids = useridString.split(",");
				}
				for(String userid : userids){//��Է�����ѭ������
					User user = userBL.searchUserByKey(userid);
					if("1".equals(form.getSendEML())) {//�Ƿ����ʼ�
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>�����ļ������£�"+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{user.getUseremail()}, new String[]{});
					}
					if("1".equals(form.getSendSMS())){//�Ƿ��Ͷ���-�����
						sendMessageBL.sendSmsToUser(user.getUserid(), "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
					}
				}
			}else if ("2".equals(notice.getNtargettype())) {//����ɫ��������Ա����֪ͨ
				String roleidString = notice.getNtargetroleid();
				String[] roleids = {};
				if(StringUtils.isNotEmpty(roleidString)){
					roleids = roleidString.split(",");
				}
				Map<String, String> userMap = new HashMap<String, String>();//���·�����Ա�����ظ����û�
				for(String roleid : roleids){//���ݽ�ɫID��ѯ���н�ɫ�µ��û�(ע���ظ��û���ʹ��Map)
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRoleid(Integer.parseInt(roleid));
					List<UserRoleInfo> userRoleList =  userRoleBL.searchUserRoleVW(cond);
					for(UserRoleInfo userRoleInfo : userRoleList){						
						userMap.put(userRoleInfo.getUserid(), userRoleInfo.getUseremail());
					}
				}
				//����Map���е���������Ӧ֪ͨ
				Set<String> useridSet = userMap.keySet();//��ȡKeySet
				if("1".equals(form.getSendEML())) {//�Ƿ����ʼ�
					for(String userID : useridSet) {
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>�����ļ������£�"+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{userMap.get(userID)}, new String[]{});
					}
				}
				if("1".equals(form.getSendSMS())) {//�Ƿ��Ͷ���-�����
					for(String userID : useridSet) {
						//���Ÿ�ʽ:   ֪ͨ���ѣ�����Ϊ�����⡿��֪ͨ��Ҫ���鿴��
						sendMessageBL.sendSmsToUser(userID, "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
					}
				}
			}else{	//Ĭ�ϸ������˷�֪ͨʱ������ 2015-3-9 13:48:05
				UserSearchCondImpl cond = new UserSearchCondImpl();
				List<User> userList = userBL.searchUser(cond);
				for (User user : userList) {
					//���Ÿ�ʽ:   ֪ͨ���ѣ�����Ϊ�����⡿��֪ͨ��Ҫ���鿴��
					sendMessageBL.sendSmsToUser(user.getUserid(), "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
				}
			}
		}

		/*
		  �˹����ݲ�ʹ�� 2015-2-9 14:29:40 
		 if("1".equals(isPush)){	
			messagePushBL.pushNotice(noticeTime, noticeContnt, noticeUser, noticeId, "2", pushPrid,"");
			
			EmergencyLogTB elTB = new EmergencyLogTB();
			elTB.setEllidtime(noticeTime);
			elTB.setElliinfo(noticeContnt);
			elTB.setEllitype("2");
			elTB.setElprid(Integer.parseInt(pushPrid));
			elTB.setEluserid(notice.getNuserid());
			elTB.setElusername(noticeUser);
			emergencyLogBL.registEmergencyLog(elTB);
		}*/
		log.debug("========֪ͨ������������========");
		return dto;
	}
	/**
	 * ƴ�Ӹ����ļ�˵��
	 * @param attachmentList
	 * @return
	 */
	private String getNoticeAttachment(List<Attachment> attachmentList) {
		StringBuffer result = new StringBuffer("");
		for(Attachment attachment : attachmentList){
			String key_attachment = attachment.getAttname();
			if(StringUtils.isEmpty(result.toString())){
				result.append(key_attachment.split("_")[1]);
			}else {				
				result.append("��"+key_attachment.split("_")[1]);
			}
		}
		return result.toString();
	}

	private String insertFileListAction(IGSYM05DTO dto) throws BLException {
		IGSYM0502Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����
		String attkey = null;
		if (form.getFileListInfo().get(0).getFile()!=null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		List <FormFileInfo> astFormFileInfo = form.getFileListInfo();
		for (int i = 0; i < astFormFileInfo.size(); i++) {
			FormFile file = astFormFileInfo.get(i).getFile();
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("sym");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}	
			return attkey;
		}

	
	/**
	 * �޸Ĵ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String updateFileListAction(IGSYM05DTO dto) throws BLException {
		IGSYM0502Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����
	
	
	    String  attkey = form.getNattkey();
	 
		if (attkey==null ||attkey.equals("")) {
			attkey = IGStringUtils.getAttKey();		
		} 
		 attachment.setAttkey(attkey);
		 
		 if (form.getFileListInfo().get(0).getFile()!=null) {
			List <FormFileInfo> astFormFileInfo = form.getFileListInfo();
			for (int i = 0; i < astFormFileInfo.size(); i++) {
				FormFile file = astFormFileInfo.get(i).getFile();
				if (file != null && file.getFileSize() > 0) {
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					// ��Ŀ¼
					pathBuf.append(rootPath);
					// ����ID
					pathBuf.append("sym");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// �ļ��ϴ�����
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
								+ "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + fileName.toString());
					// �ϴ��ļ���URL
					attachment.setAtturl("fin");
					this.attachmentBL.registAttachment(attachment);
				}
			}
		 }
		return attkey;
	}
	/**
	 * <p>
	 * Description: ֪ͨ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO initIGSYM0502Action(IGSYM05DTO dto) throws BLException {
		log.debug("========�����֪ͨ������Ϣ��ѯ����ʼ========");
		IGSYM0502Form form = dto.getIgsym0502Form();
		Notice notice = noticeBL.searchNoticeByKey(form.getNid());
		if ( notice == null ){
			throw new BLException("IGCO10000.E004","�������֪ͨ����");
		}
		form.setNattkey(notice.getNattkey());
		form.setNdesc(notice.getNdesc());
		form.setNid(notice.getNid());
		form.setNname(notice.getNname());
		form.setNorgid(notice.getNorgid());
		form.setNorgname(notice.getNorgname());
		form.setNtime(notice.getNtime());
		form.setNuserid(notice.getNuserid());
		form.setNusername(notice.getNusername());
		form.setUserid(notice.getUserid());
		form.setRoleid(notice.getRoleid());
		form.setNtargettype(notice.getNtargettype());
		form.setNtargetuserid(notice.getNtargetuserid());
		form.setNtargetusername(notice.getNtargetusername());
		form.setNtargetroleid(notice.getNtargetroleid());
		form.setNtargetrolename(notice.getNtargetrolename());
		//�����ʼ��ģʽ
		form.setMode("1");
	
		if(StringUtils.isNotEmpty(notice.getNattkey())) {
			List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
			if(!list.isEmpty()){
				
				Attachment attachment = list.get(0);
				AttachmentTB aTB = (AttachmentTB) SerializationUtils.clone(attachment);
				
				form.setAttacthname(aTB.getAttname().toString().substring(aTB.getAttname().toString().indexOf("_")+1));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I001","֪ͨ������Ϣ"));
		log.debug("========�����֪ͨ������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ֪ͨ���
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM05DTO updateNoticeAction(IGSYM05DTO dto) throws BLException{
		IGSYM0502Form form = (IGSYM0502Form) dto.getAttachFile();
		
		if("1".equals(form.getNtargettype())){//1:��Ա    �ÿս�ɫ�ֶ�
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
		}else if ("2".equals(form.getNtargettype())){// 2:��ɫ  �ÿ���Ա�ֶ�
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
		}else if("0".equals(form.getNtargettype())){// 0:ȫ��   �ÿս�ɫ,��Ա�ֶ�
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
		}
		
		//ɾ������
		if(StringUtils.isNotEmpty(form.getDeletekeys())){
			String[] keys = form.getDeletekeys().split(",");
			for(String key : keys){
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
			
		}
		//���¸���
		if(form.getFileListInfo().get(0).getFile()!=null &&
				!form.getFileListInfo().get(0).getFile().getFileName().equals("")){
			String attkey = updateFileListAction(dto);
			form.setNattkey(attkey);
		}
		
		String isSend = form.getIsSend();//�Ƿ�����֪ͨ��ʶ
		if("0".equals(isSend)){//������֪ͨʱע��
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
			form.setNtargettype(null);
		} else if("1".equals(isSend)) {
			if ("1".equals(form.getNtargettype())) {
				form.setNtargetroleid(null);
				form.setNtargetrolename(null);
			} else if ("2".equals(form.getNtargettype())) {
				form.setNtargetuserid(null);
				form.setNtargetusername(null);
			} 
		}
		dto.setNotice(form);
		Notice notice = noticeBL.registNotice(dto.getNotice());
		dto.setNotice(notice);
//		dto.addMessage(new ActionMessage( "IGCO10000.I004", "֪ͨ������Ϣ") );
		
		dto.setNotice(form);
		noticeBL.updateNotice(dto.getNotice());//������Ϣ
		
		
		String attkey = notice.getNattkey();//��ȡ������Ӧ
		List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attkey);
		String attachment = getNoticeAttachment(attList);
		
		if("1".equals(isSend)) {//����֪ͨ
			if("1".equals(notice.getNtargettype())) {//����Ա����֪ͨ
				String useridString = notice.getNtargetuserid();
				String[] userids = {};
				if(StringUtils.isNotEmpty(useridString)){
					userids = useridString.split(",");
				}
				for(String userid : userids){//��Է�����ѭ������
					User user = userBL.searchUserByKey(userid);
					if("1".equals(form.getSendEML())) {//�Ƿ����ʼ�
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>�����ļ������£�"+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{user.getUseremail()}, new String[]{});
					}
					if("1".equals(form.getSendSMS())){//�Ƿ��Ͷ���-�����
						sendMessageBL.sendSmsToUser(user.getUserid(), "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
					}
				}
			}else if ("2".equals(notice.getNtargettype())) {//����ɫ��������Ա����֪ͨ
				String roleidString = notice.getNtargetroleid();
				String[] roleids = {};
				if(StringUtils.isNotEmpty(roleidString)){
					roleids = roleidString.split(",");
				}
				Map<String, String> userMap = new HashMap<String, String>();//���·�����Ա�����ظ����û�
				for(String roleid : roleids){//���ݽ�ɫID��ѯ���н�ɫ�µ��û�(ע���ظ��û���ʹ��Map)
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRoleid(Integer.parseInt(roleid));
					List<UserRoleInfo> userRoleList =  userRoleBL.searchUserRoleVW(cond);
					for(UserRoleInfo userRoleInfo : userRoleList){						
						userMap.put(userRoleInfo.getUserid(), userRoleInfo.getUseremail());
					}
				}
				//����Map���е���������Ӧ֪ͨ
				Set<String> useridSet = userMap.keySet();//��ȡKeySet
				if("1".equals(form.getSendEML())) {//�Ƿ����ʼ�
					for(String userID : useridSet) {
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>�����ļ������£�"+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{userMap.get(userID)}, new String[]{});
					}
				}
				if("1".equals(form.getSendSMS())) {//�Ƿ��Ͷ���-�����
					for(String userID : useridSet) {
						//���Ÿ�ʽ:   ֪ͨ���ѣ�����Ϊ�����⡿��֪ͨ��Ҫ���鿴��
						sendMessageBL.sendSmsToUser(userID, "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
					}
				}
			}else{	//Ĭ�ϸ������˷�֪ͨʱ������ 2015-3-9 13:48:05
				UserSearchCondImpl cond = new UserSearchCondImpl();
				List<User> userList = userBL.searchUser(cond);
				for (User user : userList) {
					//���Ÿ�ʽ:   ֪ͨ���ѣ�����Ϊ�����⡿��֪ͨ��Ҫ���鿴��
					sendMessageBL.sendSmsToUser(user.getUserid(), "֪ͨ���ѣ�����Ϊ��"+notice.getNname()+"����֪ͨ��Ҫ���鿴��");
				}
			}
		}
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "֪ͨ������Ϣ") );
		return dto;
	}
	
	/**
	 * <p>
	 * Description:֪ͨ������ϸ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeDetail(IGSYM05DTO dto)throws BLException {
          log.debug("========֪ͨ������ѯ����ʼ========");
      dto.getIgsym0501Form();

         //����DAO�ӿڲ�ѯ
         Notice notice = noticeBL.searchNoticeByKey(  Integer.parseInt(dto.getNoticeSearchCond().getNid()));
       
      
         dto.setNotice(notice);
         
         log.debug("========֪ͨ������ѯ��������========");
         return dto;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	public IGSYM05DTO searchDateWorkAction(String userid) throws BLException{
		GregorianCalendar currentDay = new GregorianCalendar();
		int month = currentDay.get(Calendar.MONTH);
		month++;
		String date = String.valueOf(month);
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid);
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
	public IGSYM05DTO searchDateWorkAction(String date, String userid) throws BLException{
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid);
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list) throws BLException{
		GregorianCalendar currentDay = new GregorianCalendar();
		int month = currentDay.get(Calendar.MONTH);
		month++;
		String date = String.valueOf(month);
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid, list);
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list) throws BLException{
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid, list);
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list, String temp) throws BLException{
		GregorianCalendar currentDay = new GregorianCalendar();
		int month = currentDay.get(Calendar.MONTH);
		month++;
		String date = String.valueOf(month);
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid, list, "");
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list, String temp) throws BLException{
		if(date.length()==1){
			date = "0"+date;
		}
		List<DateWorkVWInfo> dateWorkList = this.noticeBL.searchDateWorkInfo(date, userid, list, "");
		IGSYM05DTO dto = new IGSYM05DTO();
		dto.setDateWorkList(dateWorkList);
		return dto;
	}
}
