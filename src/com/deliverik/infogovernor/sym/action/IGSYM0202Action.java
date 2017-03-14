/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import sun.misc.BASE64Decoder;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IniReader;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_新增修改ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0202Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0202Action.class);
	private boolean flag = true;
	/**
	 * <p>
	 * Description: 用户action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		flag = true;
		//实例化FORM
		IGSYM0202Form form = (IGSYM0202Form)actionForm;
		//判断登陆方式
		String loginType = "";//登陆方式
		String localuser = "";//本地登陆用户组
		User nowUser = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		String userid = nowUser.getUserid();
		CodeListUtils codeListUtils = (CodeListUtils)getBean("codeListUtils");
		loginType = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
		localuser = codeListUtils.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
		for(int i=0,j=localuser.split(",").length;i<j;i++){
			String localUserId =  localuser.split(",")[i];
			if(null!=localUserId && userid.equals(localUserId)){
				flag = false;
			}
		}
		if("1".equals(loginType) && flag){
			form.setLoginType(loginType);
		}else{
			form.setLoginType("0");
		}
		
		
		//获取BL接口实例
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//实例化DTO
		IGSYM02DTO dto = new IGSYM02DTO();
		ctlBL.searchComboBoxAction(dto);
		request.setAttribute("hpList", dto.getLst_LabelValueBean());
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========用户新增画面初期显示处理开始========");
			
			// add by songhy start 2010-06-08
			BASE64Decoder base64De = new BASE64Decoder();// 实例化一个解密类
			
			// 从配置文件中获得用户上限数,把String 类型的密文解密
			String strDes = new String (base64De.decodeBuffer(IniReader.getValue("USER_PRESENT_NUM"))); 
			
			if (StringUtils.isNotEmpty(strDes)) {
				int presetNum = Integer.parseInt(strDes);
				// 从数据库中取得用户数量
				int userNum = ctlBL.searchUserCount(dto);
				// 当用户数量已达到设定上限，禁止新增加用户
				if (userNum >= presetNum) {
					addMessage(request, new ActionMessage("IGCOM0101.E007"));
					return mapping.findForward("OUT");
				}
			}else{
				addMessage(request, new ActionMessage("IGCOM0101.E007"));
				return mapping.findForward("OUT");
			}
			// add by songhy end 2010-06-08
			
			addMessage(request, new ActionMessage("IGCO10000.I001","用户基本信息"));
			log.debug("========用户新增画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		String forward = "DISP";
		//用户新增
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========用户新增处理开始========");
				dto.setUser(form);
				dto.setIgsym0202Form(form);
				//调用BL新增
				dto = ctlBL.insertUserAction(dto);
				log.debug("========用户新增处理终了========");
			} else {
				//信息变更
				log.debug("========用户变更处理开始========");
				dto.setUser(form);
				dto.setIgsym0202Form(form);
				//调用BL变更
				dto = ctlBL.updateUserAction(dto);
				forward = "DETAIL";
				log.debug("========用户变更处理终了========");
			}
		}
		//变更页面初始化
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========用户变更初期显示处理开始========");
			dto.setIgsym0202Form(form);
			dto = ctlBL.initIGSYM0202Action(dto);
			log.debug("========用户变更初期显示处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
