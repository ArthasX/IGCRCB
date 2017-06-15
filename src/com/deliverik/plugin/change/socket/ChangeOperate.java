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

	private Socket socket;// socket对象

	/**
	 * 流程日志SOCKET操作类 构造方法
	 * 
	 * @param socket
	 *            socket对象
	 */
	public ChangeOperate(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 流程日志SOCKET操作类 执行方法
	 */
	public void run() {
		log.debug("变更事件开始---------------------------");
		BufferedInputStream in = null; 
		String fileName = "";
		String url = "";
		String attkey = "";
		//设定一些发起的角色ID
		String role_id = "1206,1207,1208,1209,1210,1211,1212,1213,1214,1215,1216,1217,1218,1219,1220,1221,1222,3015,3016,3017,1227,1228,1229,1230,1146";
		File file = null ;
		try {
			//初始化字节流数
			in =new BufferedInputStream(socket.getInputStream());
			//获取数字的字节长度
			byte[] numByteLength = new byte[1];
			//读取一个字节
			in.read(numByteLength);
			//得到数据的长度的字节数
			int numLength = numByteLength[0];
			 
			//初始化文本长度大小的数组
			byte[] contextLengthSize = new byte[numLength];
			//读取正文长度的数据
			in.read(contextLengthSize);
			//正文内容长度
			String contextLength = new String(contextLengthSize,0,numLength);
			 
			//获取正文内容
			byte[] info = new byte[Integer.parseInt(contextLength)];
			//读取正文
			in.read(info);
			String contextMsg = new String(info,"GBK").trim();
			System.out.println(contextMsg);
			//分隔符 分割正文
			String[] acceptMsg = contextMsg.split("\\(\\#\\)");
			for(int h=0;h<acceptMsg.length;h++){
				System.out.println(acceptMsg[h]);
			}
			
			if(acceptMsg.length>23 && null!= acceptMsg[23]){
				//取得文件名及其扩展名
				fileName = acceptMsg[23];				
			}
			if(StringUtils.isEmpty(fileName) || null==fileName){
				System.out.println("没有附件");
			}else {
				
			
			//设置跟路径
			String rootPath = ResourceUtility
					.getString("UPLOAD_FILE_ROOT_PATH");
			StringBuffer sb = new StringBuffer(rootPath);
			//svc流程附件保存路径
			sb.append(CommonDefineUtils.APPLICATIONNAME);
			sb.append(File.separator);
			//获取attkey
			if(StringUtils.isBlank(attkey))
				attkey = IGStringUtils.getAttKey();
			sb.append(attkey);
			sb.append("_");
			sb.append(fileName);
			url = sb.toString();
			//设置文件
			file = new File(url);
			int i = 1;
			String finalFileName = "";
			while(file.exists()){
				finalFileName = fileName.substring(0,fileName.indexOf(".",-1)) +"(" + i + ")" + fileName.substring(fileName.indexOf(".",-1));
				file = new File(sb.substring(0,sb.indexOf(".",-1)) +"(" + i++ + ")" + sb.substring(sb.indexOf(".",-1)));
			}
			fileName = StringUtils.isNotBlank(finalFileName)?finalFileName:fileName;
			
			/** 上传文件保存流缓存取得 */
			BufferedOutputStream outBuffer = new BufferedOutputStream( new FileOutputStream(file));
			
			//定义字节数组
			byte[] b = new byte[8096];
			
			//循环读写文件
			while ((numLength = in.read(b)) !=- 1) {
				//写文件
				outBuffer.write(b,0,numLength);
			}
			outBuffer.flush();
			
			//获取附件操作BL
			AttachmentBL attachmentBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			//记录上传附件
			this.uploadFile(fileName, attachmentBL , attkey);
			
			}

			/**
			 * 对正文数据开始操作
			 *  IGCHANGE01BLImpl  操作bl
			 *  IGCHANGE01DTO     dto
			 *  IGCHANGE0101Form  form
			 *  InitiateChangLogTB 实体TB
			 */
			
			// 获取BL
			IGCHANGE01BLImpl ctlBL = (IGCHANGE01BLImpl) WebApplicationSupport
					.getBean("iGCHANGE01BLImpl");
			// 实例化dto
			IGCHANGE01DTO dto = new IGCHANGE01DTO();
			// 实例化form
			IGCHANGE0101Form form = new IGCHANGE0101Form();
			//实例化 日志信息TB
			InitiateChangLogTB tb = new InitiateChangLogTB();
			//设定时间
			tb.setSendTime(CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
			if(StringUtils.isNotBlank(acceptMsg[0])){
				UserBL userBL  =  (UserBL) WebApplicationSupport.getBean("userBL");
				//用户查询
				UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
				//设定用户名 查询用户信息，不计重复 只取第一个（客户定的）
				cond.setUsername_forPms(acceptMsg[0]);
				List<UserInfo> userInfo = userBL.searchUserInfo(cond);
				
				if(userInfo.size()!=0 && null != userInfo){
					//设定用户ID
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
			System.out.println(acceptMsg[6]+" 第六个位置");
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
			//设定实体
			dto.setInitTB(tb);
			dto.setAttkey(attkey);
			//调用bl插入数据
			dto = ctlBL.saveInitiacteChangeAction(dto);
			// 数据插入成功
			if (dto.getIcid() != null) {
				System.out.println("数据插入成功");
				// 设定form
				dto.setIgchange0101Form(form);
				// 发起流程
				ctlBL.registIGCHANGEAction(dto);
				log.debug("数据查询成功");
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
	 * 流程用上传附件操作，附件存放在属性问配置文件目录的svc文件夹中
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
			// 上传文件名保存
			attachment.setAttname(attkey + "_" + fileName);
			// 上传文件路径保存
			attachment.setAtturl(CommonDefineUtils.APPLICATIONNAME);
			//上传文件
			attachmentBL.registAttachment(attachment);
		}
	}
}
