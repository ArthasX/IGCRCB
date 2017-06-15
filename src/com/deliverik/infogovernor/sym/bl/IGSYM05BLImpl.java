/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM05BLImpl extends BaseBLImpl implements IGSYM05BL {

	static Log log = LogFactory.getLog(IGSYM05BLImpl.class);

	/**
	 * 注入NoticeBL
	 */
	protected NoticeBL noticeBL;
	protected FileUploadBL fileUploadBL;
	protected AttachmentBL attachmentBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**消息推送BL*/
//	protected MessagePushBL messagePushBL;
	
	/**推送日志*/
//	protected EmergencyLogBL emergencyLogBL;
	
	protected UserBL userBL;
	
	protected UserRoleBL userRoleBL;
	
	protected SendMailBL sendMailBL;
	
	protected SendMessageBL sendMessageBL;
	
	/**
	 * 消息推送BL
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
	 * 设置NoticeBL
	 * @param noticeBL NoticeBL
	 */
	
	public void setNoticeBL(NoticeBL noticeBL) {
		this.noticeBL = noticeBL;
	}
	
	/**
	 * <p>
	 * Description: 取得需要滚动显示的通知信息
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO getNoticeInfo(IGSYM05DTO dto) throws BLException {
		
		int num = Integer.parseInt(ResourceUtility.getString("NOTICE_SHOW_NUM"));//规定的通知显示数目
		int totalCount = noticeBL.getSearchCount(dto
				.getNoticeSearchCond());
		if(totalCount==0){
			return dto;
		}else if(totalCount<=num){
			//调用DAO接口查询
			List<Notice> noticeList = noticeBL.searchNotice(dto
					.getNoticeSearchCond(),0,totalCount);

			dto.setNoticeCondList(noticeList);
		}else{
			//调用DAO接口查询
			List<Notice> noticeList = noticeBL.searchNotice(dto
					.getNoticeSearchCond(),0,(num+1));

			dto.setNoticeCondList(noticeList);
		}
		
		
		log.debug("========通知查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 通知查询
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========通知查询处理开始========");
		
		//判断该角色是否在可以看见的角色里
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
		
		// 查询记录总数
		int totalCount = noticeBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<Notice> noticeList = noticeBL.searchNotice(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setNoticeCondList(noticeList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========通知查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 通知删除
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO deleteNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========通知删除处理开始========");
		//循环删除
		for( int i=0;i<dto.getDeleteNid().length;i++ ){
			//通知删除主键
			String nid = dto.getDeleteNid()[i];

			noticeBL.deleteNotice(new Integer(nid));
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "通知基本信息"));
		log.debug("========通知删除处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 通知新增
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO insertNoticeAction(IGSYM05DTO dto) throws BLException {
		log.debug("========通知新增处理开始========");
		IGSYM0502Form form = (IGSYM0502Form) dto.getAttachFile();
		if(form.getFileList(0).getFile()!=null && !form.getFileList(0).getFile().getFileName().equals("")){
			String attkey = insertFileListAction(dto);
			form.setNattkey(attkey);
		}
		
		String isSend = form.getIsSend();//是否推送通知标识
		if("0".equals(isSend)){//不推送通知时注意
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
			form.setNtargettype(null);
		} else if("1".equals(isSend)) {
			if ("1".equals(form.getNtargettype()) && !"".equals(form.getNtargetuserid())) {//如果选择人员类型并不为空
				form.setNtargetroleid(null);
				form.setNtargetrolename(null);
			} else if ("2".equals(form.getNtargettype()) && !"".equals(form.getNtargetroleid())) {//如果选择角色类型并不为空
				form.setNtargetuserid(null);
				form.setNtargetusername(null);
			} 
		}
		
		dto.setNotice(form);
		Notice notice = noticeBL.registNotice(dto.getNotice());
		dto.setNotice(notice);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "通知基本信息") );
		
		/*
		此功能暂不使用 2015-2-9 14:29:40
		String noticeTime = notice.getNtime();
		String noticeContnt = notice.getNdesc();
		String noticeUser = notice.getNusername();
		String noticeId = String.valueOf(notice.getNid());
		
		String isPush = form.getIsPush();
		String pushPrid = form.getPushPrid();*/
		
		String attkey = notice.getNattkey();//获取附件对应
		List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attkey);
		String attachment = getNoticeAttachment(attList);
		
		if("1".equals(isSend)) {//推送通知
			if("1".equals(notice.getNtargettype())) {//给人员发送通知
				String useridString = notice.getNtargetuserid();
				String[] userids = {};
				if(StringUtils.isNotEmpty(useridString)){
					userids = useridString.split(",");
				}
				for(String userid : userids){//针对发送人循环发送
					User user = userBL.searchUserByKey(userid);
					if("1".equals(form.getSendEML())) {//是否发送邮件
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>附件文件名如下："+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{user.getUseremail()}, new String[]{});
					}
					if("1".equals(form.getSendSMS())){//是否发送短信-需测试
						sendMessageBL.sendSmsToUser(user.getUserid(), "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
					}
				}
			}else if ("2".equals(notice.getNtargettype())) {//给角色下所有人员发送通知
				String roleidString = notice.getNtargetroleid();
				String[] roleids = {};
				if(StringUtils.isNotEmpty(roleidString)){
					roleids = roleidString.split(",");
				}
				Map<String, String> userMap = new HashMap<String, String>();//重新放置人员过滤重复的用户
				for(String roleid : roleids){//根据角色ID查询所有角色下的用户(注意重复用户故使用Map)
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRoleid(Integer.parseInt(roleid));
					List<UserRoleInfo> userRoleList =  userRoleBL.searchUserRoleVW(cond);
					for(UserRoleInfo userRoleInfo : userRoleList){						
						userMap.put(userRoleInfo.getUserid(), userRoleInfo.getUseremail());
					}
				}
				//根据Map进行迭代推送相应通知
				Set<String> useridSet = userMap.keySet();//获取KeySet
				if("1".equals(form.getSendEML())) {//是否发送邮件
					for(String userID : useridSet) {
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>附件文件名如下："+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{userMap.get(userID)}, new String[]{});
					}
				}
				if("1".equals(form.getSendSMS())) {//是否发送短信-需测试
					for(String userID : useridSet) {
						//短信格式:   通知提醒：标题为【标题】的通知需要您查看！
						sendMessageBL.sendSmsToUser(userID, "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
					}
				}
			}else{	//默认给所有人发通知时发短信 2015-3-9 13:48:05
				UserSearchCondImpl cond = new UserSearchCondImpl();
				List<User> userList = userBL.searchUser(cond);
				for (User user : userList) {
					//短信格式:   通知提醒：标题为【标题】的通知需要您查看！
					sendMessageBL.sendSmsToUser(user.getUserid(), "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
				}
			}
		}

		/*
		  此功能暂不使用 2015-2-9 14:29:40 
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
		log.debug("========通知新增处理终了========");
		return dto;
	}
	/**
	 * 拼接附件文件说明
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
				result.append("，"+key_attachment.split("_")[1]);
			}
		}
		return result.toString();
	}

	private String insertFileListAction(IGSYM05DTO dto) throws BLException {
		IGSYM0502Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测
		String attkey = null;
		if (form.getFileListInfo().get(0).getFile()!=null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		List <FormFileInfo> astFormFileInfo = form.getFileListInfo();
		for (int i = 0; i < astFormFileInfo.size(); i++) {
			FormFile file = astFormFileInfo.get(i).getFile();
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("sym");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// 上传文件名保存
				attachment.setAttname(attkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}	
			return attkey;
		}

	
	/**
	 * 修改处理多个附件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String updateFileListAction(IGSYM05DTO dto) throws BLException {
		IGSYM0502Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测
	
	
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
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility
							.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					// 根目录
					pathBuf.append(rootPath);
					// 机能ID
					pathBuf.append("sym");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// 文件上传处理
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
								+ "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
					// 上传文件名保存
					attachment.setAttname(attkey + "_" + fileName.toString());
					// 上传文件名URL
					attachment.setAtturl("fin");
					this.attachmentBL.registAttachment(attachment);
				}
			}
		 }
		return attkey;
	}
	/**
	 * <p>
	 * Description: 通知变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO initIGSYM0502Action(IGSYM05DTO dto) throws BLException {
		log.debug("========变更用通知基本信息查询处理开始========");
		IGSYM0502Form form = dto.getIgsym0502Form();
		Notice notice = noticeBL.searchNoticeByKey(form.getNid());
		if ( notice == null ){
			throw new BLException("IGCO10000.E004","变更对象通知基本");
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
		//变更初始化模式
		form.setMode("1");
	
		if(StringUtils.isNotEmpty(notice.getNattkey())) {
			List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(notice.getNattkey());
			if(!list.isEmpty()){
				
				Attachment attachment = list.get(0);
				AttachmentTB aTB = (AttachmentTB) SerializationUtils.clone(attachment);
				
				form.setAttacthname(aTB.getAttname().toString().substring(aTB.getAttname().toString().indexOf("_")+1));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I001","通知基本信息"));
		log.debug("========变更用通知基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 通知变更
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
		
		if("1".equals(form.getNtargettype())){//1:人员    置空角色字段
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
		}else if ("2".equals(form.getNtargettype())){// 2:角色  置空人员字段
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
		}else if("0".equals(form.getNtargettype())){// 0:全部   置空角色,人员字段
			form.setNtargetroleid(null);
			form.setNtargetrolename(null);
			form.setNtargetuserid(null);
			form.setNtargetusername(null);
		}
		
		//删除附件
		if(StringUtils.isNotEmpty(form.getDeletekeys())){
			String[] keys = form.getDeletekeys().split(",");
			for(String key : keys){
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
			
		}
		//更新附件
		if(form.getFileListInfo().get(0).getFile()!=null &&
				!form.getFileListInfo().get(0).getFile().getFileName().equals("")){
			String attkey = updateFileListAction(dto);
			form.setNattkey(attkey);
		}
		
		String isSend = form.getIsSend();//是否推送通知标识
		if("0".equals(isSend)){//不推送通知时注意
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
//		dto.addMessage(new ActionMessage( "IGCO10000.I004", "通知基本信息") );
		
		dto.setNotice(form);
		noticeBL.updateNotice(dto.getNotice());//更新消息
		
		
		String attkey = notice.getNattkey();//获取附件对应
		List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(attkey);
		String attachment = getNoticeAttachment(attList);
		
		if("1".equals(isSend)) {//推送通知
			if("1".equals(notice.getNtargettype())) {//给人员发送通知
				String useridString = notice.getNtargetuserid();
				String[] userids = {};
				if(StringUtils.isNotEmpty(useridString)){
					userids = useridString.split(",");
				}
				for(String userid : userids){//针对发送人循环发送
					User user = userBL.searchUserByKey(userid);
					if("1".equals(form.getSendEML())) {//是否发送邮件
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>附件文件名如下："+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{user.getUseremail()}, new String[]{});
					}
					if("1".equals(form.getSendSMS())){//是否发送短信-需测试
						sendMessageBL.sendSmsToUser(user.getUserid(), "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
					}
				}
			}else if ("2".equals(notice.getNtargettype())) {//给角色下所有人员发送通知
				String roleidString = notice.getNtargetroleid();
				String[] roleids = {};
				if(StringUtils.isNotEmpty(roleidString)){
					roleids = roleidString.split(",");
				}
				Map<String, String> userMap = new HashMap<String, String>();//重新放置人员过滤重复的用户
				for(String roleid : roleids){//根据角色ID查询所有角色下的用户(注意重复用户故使用Map)
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRoleid(Integer.parseInt(roleid));
					List<UserRoleInfo> userRoleList =  userRoleBL.searchUserRoleVW(cond);
					for(UserRoleInfo userRoleInfo : userRoleList){						
						userMap.put(userRoleInfo.getUserid(), userRoleInfo.getUseremail());
					}
				}
				//根据Map进行迭代推送相应通知
				Set<String> useridSet = userMap.keySet();//获取KeySet
				if("1".equals(form.getSendEML())) {//是否发送邮件
					for(String userID : useridSet) {
						String attachmentString = "";
						if(StringUtils.isNotEmpty(attkey)){
							attachmentString = "<br/>附件文件名如下："+attachment;
						}
						sendMailBL.sendMail(notice.getNname(), notice.getNdesc()+attachmentString, new String[]{userMap.get(userID)}, new String[]{});
					}
				}
				if("1".equals(form.getSendSMS())) {//是否发送短信-需测试
					for(String userID : useridSet) {
						//短信格式:   通知提醒：标题为【标题】的通知需要您查看！
						sendMessageBL.sendSmsToUser(userID, "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
					}
				}
			}else{	//默认给所有人发通知时发短信 2015-3-9 13:48:05
				UserSearchCondImpl cond = new UserSearchCondImpl();
				List<User> userList = userBL.searchUser(cond);
				for (User user : userList) {
					//短信格式:   通知提醒：标题为【标题】的通知需要您查看！
					sendMessageBL.sendSmsToUser(user.getUserid(), "通知提醒：标题为【"+notice.getNname()+"】的通知需要您查看！");
				}
			}
		}
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "通知基本信息") );
		return dto;
	}
	
	/**
	 * <p>
	 * Description:通知单个详细查询
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeDetail(IGSYM05DTO dto)throws BLException {
          log.debug("========通知单个查询处理开始========");
      dto.getIgsym0501Form();

         //调用DAO接口查询
         Notice notice = noticeBL.searchNoticeByKey(  Integer.parseInt(dto.getNoticeSearchCond().getNid()));
       
      
         dto.setNotice(notice);
         
         log.debug("========通知单个查询处理终了========");
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
