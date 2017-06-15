package com.deliverik.infogovernor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.broker.DashBoardJobProxy;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.form.IGCOM0101Form;

/**
 * 登录画面用Action处理
 *
 */
public class IGCOM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);
	private boolean flag = true;

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========登录画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001", "用户名和密码登录系统"));
			//启用后勤物品每月盘点
//			InventoryJobProxy.getInstance().addInventoryJob();
//			DashBoardJobProxy.getInstance().addDashBoardRTJob();
			log.debug("========登录画面初期显示处理结束========");
			return mapping.findForward("DISP");
		}else{
			//DTO
			log.debug("========用户登录处理开始========");
		
			//试用版过期校验
			//*************add by tangxiaona at 2010-06-17******************
				
//			BASE64Decoder base64De = new BASE64Decoder();// 实例化一个解密类
//			// 从配置文件中获得过期日期,把String 类型的密文解密
//			String endday =  new String (base64De.decodeBuffer(IniReader.getValue("DATE_KEY")));
//			String startday = new String (base64De.decodeBuffer(IniReader.getValue("START_DATE_KEY")));
//			String path = this.getServlet().getServletContext().getRealPath(File.separator);
//			System.out.println(path+"===path===");
//			System.out.println(File.separator+"===File.separator===");
//			
//			File file = new File(path+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"file.txt");
//			
//			System.out.println(file+"===file===");
//			
//			
//			FileInputStream fis = new FileInputStream(file); 
//			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); 
//			String lastDate="";//获取上次登录记录时间
//			lastDate=in.readLine();
//			if(!"".equals(lastDate)&&lastDate!=null){
//				lastDate = new String (base64De.decodeBuffer(lastDate));
//			}
//			String today = IGStringUtils.getCurrentDate().replaceAll("/", "");  //当天日期
//			if(Integer.parseInt(today)<Integer.parseInt(startday)){
//				throw new BLException("IGCOM0101.E008");//当前时间小于开始时间，抛系统时间异常信息
//			}
//			else if(Integer.parseInt(today)>Integer.parseInt(endday)){
//				throw new BLException("IGCOM0101.E004");//许可证已经过期，抛异常
//			}
//			else{//如果在指定时间范围内，要求当前系统时间大于上次记录时间
//				BASE64Encoder base64en = new BASE64Encoder();// 实例化一个加密类
//				if("".equals(lastDate)||lastDate==null){//如果当前首次登陆，将系统日期写入file文件中
//					if (!file.exists()) {
//						file.createNewFile();
//					}
//
//					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//					bw.write(base64en.encode(today.getBytes()));
//					bw.close();
//				} else {// 如果不是首次登陆，那么判断当前系统时间是否大于上次记录时间
//					if (Integer.parseInt(lastDate) > Integer.parseInt(today)) {
//						throw new BLException("IGCOM0101.E008");
//					} else {
//
//						BufferedWriter bw = new BufferedWriter(new FileWriter(
//								file));
//						bw.write(base64en.encode(today.getBytes()));
//						bw.close();
//
//					}
//
//				}
//			}
	
			//*************add by tangxiaona at 2010-06-17******************
			IGCOM01DTO dto = new IGCOM01DTO();
			flag = true;
			//验证登陆权限BL
			IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
			IGCOM0101Form form = (IGCOM0101Form) actionForm;
			
			//取屏幕当前分辨率
			if(form.getPage_width()!=null && !"".equals(form.getPage_width())){
				req.setAttribute("page_width", form.getPage_width());
			}
			
			//判断登陆方式
			String loginType = "";//登陆方式
			String localuser = "";//本地登陆用户组
			CodeListUtils ctlBL =  (CodeListUtils)getBean("codeListUtils");
			loginType = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
			localuser = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
			
			for(int i=0,j=localuser.split(",").length;i<j;i++){//判断当前登陆用户是否在本地登陆组中
				String localUserId =  localuser.split(",")[i];
				if(null!=localUserId && form.getUserid().equals(localUserId)){
					flag = false;
				}
			}
			
			dto.setUserSearchCond(form);
			dto.setIGCOM0101Form(form);
			
			//使用LDAP方式登陆
			if("1".equals(loginType) && flag){
				
				dto = ctrlBl.loginActionByLDAP(dto);

			}else{
				
				//获取AD参数
				loginType = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_AUTHORIZATIONTYPE);
				localuser = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_LOCALORIZATIONTYPE);
				//使用AD方式登录
				if("1".equals(loginType) && flag){
					dto = ctrlBl.loginActionByAD(dto);
				}else{
					//使用普通方式登陆
					dto = ctrlBl.loginAction(dto);
				}
				
			}
			
			//用户信息显示
			int msgCnt = dto.getMessageList().size();
			if(msgCnt > 0){
				for(ActionMessage ms : dto.getMessageList()){
					addMessage(req, ms);
				}
			}
			setSessionAttribute(req, SESSION_KEY_LOGIN_USER, dto.getUser());
			
			log.debug("========用户登录处理结束========");
			return mapping.findForward("SUCCESS");
		}
	}

}
