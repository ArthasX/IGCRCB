/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0169Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01691VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0169Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0169Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		req.getSession().setAttribute("ADcategory_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�ֿ������ѯ��ʼ������ʼ========");
			
			log.debug("========�ֿ������ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========�ֿ������ѯ����ʼ========");
			ITEMS0169Form form = (ITEMS0169Form)actionForm;
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS_CKWC);//���ó���״̬Ϊ��������_�������
			form.setOutstockorg(DefineUtils.DEFAULT_ORGNO);//������������ΪĬ�϶�������
			dto.setTime_f(form.getOuttime_f());
			dto.setTime_t(form.getOuttime_t());
			dto.setOutStockSearchCond(form);
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			//����BL
			dto = items01BL.searchITEMS0169Action(dto);
			//����VO
			ITEMS01691VO vo = new ITEMS01691VO();
			vo.setItems01692VOList(dto.getItems01692VOList());//�ֿ�����
			super.<ITEMS01691VO>setVO(req, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			log.debug("========�ֿ������ѯ��������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========�ֿ������ѯ����ʼ========");
			ITEMS0169Form form = (ITEMS0169Form)actionForm;
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS_CKWC);//���ó���״̬Ϊ��������_�������
			form.setOutstockorg(DefineUtils.DEFAULT_ORGNO);//������������ΪĬ�϶�������
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			
			//����BL
			dto = items01BL.searchITEMS0169Action(dto);
			//����VO
			ITEMS01691VO vo = new ITEMS01691VO();
			vo.setItems01692VOList(dto.getItems01692VOList());//�ֿ�����
			super.<ITEMS01691VO>setVO(req, vo);
			return mapping.findForward("REPORT");

		}
		return mapping.findForward("DISP");
	}
	
}
