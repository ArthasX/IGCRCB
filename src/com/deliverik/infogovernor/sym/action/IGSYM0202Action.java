/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_�����޸�ACTION
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
	 * Description: �û�action����
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
		//ʵ����FORM
		IGSYM0202Form form = (IGSYM0202Form)actionForm;
		//�жϵ�½��ʽ
		String loginType = "";//��½��ʽ
		String localuser = "";//���ص�½�û���
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
		
		
		//��ȡBL�ӿ�ʵ��
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//ʵ����DTO
		IGSYM02DTO dto = new IGSYM02DTO();
		ctlBL.searchComboBoxAction(dto);
		request.setAttribute("hpList", dto.getLst_LabelValueBean());
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û��������������ʾ����ʼ========");
			
			// add by songhy start 2010-06-08
			BASE64Decoder base64De = new BASE64Decoder();// ʵ����һ��������
			
			// �������ļ��л���û�������,��String ���͵����Ľ���
			String strDes = new String (base64De.decodeBuffer(IniReader.getValue("USER_PRESENT_NUM"))); 
			
			if (StringUtils.isNotEmpty(strDes)) {
				int presetNum = Integer.parseInt(strDes);
				// �����ݿ���ȡ���û�����
				int userNum = ctlBL.searchUserCount(dto);
				// ���û������Ѵﵽ�趨���ޣ���ֹ�������û�
				if (userNum >= presetNum) {
					addMessage(request, new ActionMessage("IGCOM0101.E007"));
					return mapping.findForward("OUT");
				}
			}else{
				addMessage(request, new ActionMessage("IGCOM0101.E007"));
				return mapping.findForward("OUT");
			}
			// add by songhy end 2010-06-08
			
			addMessage(request, new ActionMessage("IGCO10000.I001","�û�������Ϣ"));
			log.debug("========�û��������������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		String forward = "DISP";
		//�û�����
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========�û���������ʼ========");
				dto.setUser(form);
				dto.setIgsym0202Form(form);
				//����BL����
				dto = ctlBL.insertUserAction(dto);
				log.debug("========�û�������������========");
			} else {
				//��Ϣ���
				log.debug("========�û��������ʼ========");
				dto.setUser(form);
				dto.setIgsym0202Form(form);
				//����BL���
				dto = ctlBL.updateUserAction(dto);
				forward = "DETAIL";
				log.debug("========�û������������========");
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========�û����������ʾ����ʼ========");
			dto.setIgsym0202Form(form);
			dto = ctlBL.initIGSYM0202Action(dto);
			log.debug("========�û����������ʾ��������========");
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
