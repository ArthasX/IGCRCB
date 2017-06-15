/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0202Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02021VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

public class IGLOM0202Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0202Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL)this.getBean("iglom02BL");
		IGLOM0202Form form = (IGLOM0202Form)actionForm;
		IGLOM02DTO dto = new IGLOM02DTO();
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========���Ͳ�ѯ����ʼ========");
			getPaginDTO(req,"DEFAULT");
			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0202Form) req.getSession().getAttribute("IGLOM0202Form");
				if (form == null ) {
					form = new IGLOM0202Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0202Form) req.getSession().getAttribute("IGLOM0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("DEFAULT");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
//			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
//			dto.setUser(user);
			dto.setIglom0202Form(form);
			//����BL��ѯ
			dto = ctlBL.searchGoodsAction(dto);
			//����VO
			IGLOM02021VO vo = new IGLOM02021VO();
			vo.setGoodsList(dto.getGoodsList());
			super.<IGLOM02021VO>setVO(req, vo);
			log.debug("========���Ͳ�ѯ��������========");
			
			if("instock".equals(form.getPath())){
				return mapping.findForward("SELECT");
			}
		} else if("DELETE".equals(mapping.getParameter())){
			log.debug("========ɾ������ʼ========");
			dto.setIglom0202Form(form);
			//����BL��ѯ
			dto = ctlBL.deleteGoodsAction(dto);
			log.debug("========ɾ����������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		return mapping.findForward("DISP");
	}
	
}
