package com.deliverik.plugin.change.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;
import com.deliverik.plugin.change.form.IGCHANGE0101Form;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

public class ChangeOperate extends Thread {

	static Log log = LogFactory.getLog(ChangeOperate.class);

	private Socket socket;// socket����

	/**
	 * ������־SOCKET������ ���췽��
	 * 
	 * @param socket
	 *            socket����
	 */
	public ChangeOperate(Socket socket) {
		this.socket = socket;
	}

	/**
	 * ������־SOCKET������ ִ�з���
	 */
	public void run() {
		log.debug("����¼���ʼ---------------------------");
		BufferedInputStream in = null; 
		String fileName = "";
		String url = "";
		String attkey = "";
		//�趨һЩ����Ľ�ɫID
		String role_id = "1206,1207,1208,1209,1210,1211,1212,1213,1214,1215,1216,1217,1218,1219,1220,1221,1222,3015,3016,3017,1227,1228,1229,1230,1146";
		File file = null ;
		try {
			//��ʼ���ֽ�����
			in =new BufferedInputStream(socket.getInputStream());
			//��ȡ���ֵ��ֽڳ���
			byte[] numByteLength = new byte[1];
			//��ȡһ���ֽ�
			in.read(numByteLength);
			//�õ����ݵĳ��ȵ��ֽ���
			int numLength = numByteLength[0];
			 
			//��ʼ���ı����ȴ�С������
			byte[] contextLengthSize = new byte[numLength];
			//��ȡ���ĳ��ȵ�����
			in.read(contextLengthSize);
			//�������ݳ���
			String contextLength = new String(contextLengthSize,0,numLength);
			 
			//��ȡ��������
			byte[] info = new byte[Integer.parseInt(contextLength)];
			//��ȡ����
			in.read(info);
			String contextMsg = new String(info,"GBK").trim();
			System.out.println(contextMsg);
			//�ָ��� �ָ�����
			String[] acceptMsg = contextMsg.split("\\(\\#\\)");
			for(int h=0;h<acceptMsg.length;h++){
				System.out.println(acceptMsg[h]);
			}
			
			if(acceptMsg.length>23 && null!= acceptMsg[23]){
				//ȡ���ļ���������չ��
				fileName = acceptMsg[23];				
			}
			if(StringUtils.isEmpty(fileName) || null==fileName){
				System.out.println("û�и���");
			}else {
				
			
			//���ø�·��
			String rootPath = ResourceUtility
					.getString("UPLOAD_FILE_ROOT_PATH");
			StringBuffer sb = new StringBuffer(rootPath);
			//svc���̸�������·��
			sb.append(CommonDefineUtils.APPLICATIONNAME);
			sb.append(File.separator);
			//��ȡattkey
			if(StringUtils.isBlank(attkey))
				attkey = IGStringUtils.getAttKey();
			sb.append(attkey);
			sb.append("_");
			sb.append(fileName);
			url = sb.toString();
			//�����ļ�
			file = new File(url);
			int i = 1;
			String finalFileName = "";
			while(file.exists()){
				finalFileName = fileName.substring(0,fileName.indexOf(".",-1)) +"(" + i + ")" + fileName.substring(fileName.indexOf(".",-1));
				file = new File(sb.substring(0,sb.indexOf(".",-1)) +"(" + i++ + ")" + sb.substring(sb.indexOf(".",-1)));
			}
			fileName = StringUtils.isNotBlank(finalFileName)?finalFileName:fileName;
			
			/** �ϴ��ļ�����������ȡ�� */
			BufferedOutputStream outBuffer = new BufferedOutputStream( new FileOutputStream(file));
			
			//�����ֽ�����
			byte[] b = new byte[8096];
			
			//ѭ����д�ļ�
			while ((numLength = in.read(b)) !=- 1) {
				//д�ļ�
				outBuffer.write(b,0,numLength);
			}
			outBuffer.flush();
			
			//��ȡ��������BL
			AttachmentBL attachmentBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			//��¼�ϴ�����
			this.uploadFile(fileName, attachmentBL , attkey);
			
			}

			/**
			 * ���������ݿ�ʼ����
			 *  IGCHANGE01BLImpl  ����bl
			 *  IGCHANGE01DTO     dto
			 *  IGCHANGE0101Form  form
			 *  InitiateChangLogTB ʵ��TB
			 */
			
			// ��ȡBL
			IGCHANGE01BLImpl ctlBL = (IGCHANGE01BLImpl) WebApplicationSupport
					.getBean("iGCHANGE01BLImpl");
			// ʵ����dto
			IGCHANGE01DTO dto = new IGCHANGE01DTO();
			// ʵ����form
			IGCHANGE0101Form form = new IGCHANGE0101Form();
			//ʵ���� ��־��ϢTB
			InitiateChangLogTB tb = new InitiateChangLogTB();
			//�趨ʱ��
			tb.setSendTime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
			if(StringUtils.isNotBlank(acceptMsg[0])){
				UserBL userBL  =  (UserBL) WebApplicationSupport.getBean("userBL");
				//�û���ѯ
				UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
				//�趨�û��� ��ѯ�û���Ϣ�������ظ� ֻȡ��һ�����ͻ����ģ�
				cond.setUsername_forPms(acceptMsg[0]);
				List<UserInfo> userInfo = userBL.searchUserInfo(cond);
				
				if(userInfo.size()!=0 && null != userInfo){
					//�趨�û�ID
					tb.setPruserId(userInfo.get(0).getUserida());
					
					UserRoleBL userRoleBL =  (UserRoleBL) WebApplicationSupport.getBean("userRoleBL");
					UserRoleSearchCondImpl roleCond = new UserRoleSearchCondImpl();
					roleCond.setUserid(userInfo.get(0).getUserida());
					List<UserRole> userRole = userRoleBL.searchUserRole(roleCond);
					
					for(int j=0;j<userRole.size();j++){
						UserRole role = userRole.get(j);
						if(role_id.contains(role.getRoleid()+"")){
							tb.setPrroleId(role.getRoleid()+"");
						}
						
					}
					}
				}
			tb.setChangeName(acceptMsg[2]);
			tb.setChangeDescription(acceptMsg[3]);
			tb.setBeginTime(acceptMsg[4]);
			tb.setEndTime(acceptMsg[5]);
			tb.setChangeType(acceptMsg[6]);
			System.out.println(acceptMsg[6]+" ������λ��");
			tb.setSelectedChangeType(acceptMsg[6].split("_tree_")[1].split("-")[0]);
			tb.setChangeCategory(acceptMsg[7]);
			tb.setChangeClassify(acceptMsg[8]);
			tb.setUpdatePlatform(acceptMsg[9]);
			tb.setChangeReasonClassify(acceptMsg[10]);
			tb.setChangeReason(acceptMsg[11]);
			tb.setChangeContent(acceptMsg[12]);
			tb.setPrjid(acceptMsg[13]);
			tb.setPrjtitle(acceptMsg[14]);
			tb.setIsBusiness(acceptMsg[15]);
			tb.setBusinessScope(acceptMsg[16]);
			tb.setBusinessTime(acceptMsg[17]);
			tb.setDeliveryProgram(acceptMsg[18]);
			tb.setRollbackProgram(acceptMsg[19]);
			tb.setVerificationProgram(acceptMsg[20]);
			tb.setTicketid(acceptMsg[21]);
			if(StringUtils.isNotEmpty(attkey)){
				tb.setAttkey(attkey);
			}
			//�趨ʵ��
			dto.setInitTB(tb);
			dto.setAttkey(attkey);
			//����bl��������
			dto = ctlBL.saveInitiacteChangeAction(dto);
			// ���ݲ���ɹ�
			if (dto.getIcid() != null) {
				System.out.println("���ݲ���ɹ�");
				// �趨form
				dto.setIgchange0101Form(form);
				// ��������
				ctlBL.registIGCHANGEAction(dto);
				log.debug("���ݲ�ѯ�ɹ�");
			}
						
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (BLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}finally{
				try {
					if(socket!=null){
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * �������ϴ�������������������������������ļ�Ŀ¼��svc�ļ�����
	 * @param fileName
	 * @param attachmentBL
	 * @param attkey
	 * @throws BLException
	 */
	private void uploadFile(String fileName ,AttachmentBL attachmentBL,String attkey ) throws BLException {
		if (StringUtils.isNotBlank(fileName)) {
			AttachmentTB attachment = attachmentBL
					.getAttachmentTBInstance();
			attachment.setAttkey(attkey);
			// �ϴ��ļ�������
			attachment.setAttname(attkey + "_" + fileName);
			// �ϴ��ļ�·������
			attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
			//�ϴ��ļ�
			attachmentBL.registAttachment(attachment);
		}
	}
}
