/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.action;

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

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0148Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0148Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0148Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		ITEMS01DTO dto = new ITEMS01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		//req.setAttribute("category_options", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========�����嵥��ѯ��ʼ������ʼ========");
			
			log.debug("========�����嵥��ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========�����嵥��ѯ����ʼ========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (ITEMS0148Form) req.getSession().getAttribute("ITEMS0148Form");
			}
			//��ȡ��ҳBean
			
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("ITEMS0148");
			
			//�����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
//			boolean flag = items01BL.checkRoleManagerByUserID(dto);
//			if(flag){
//				form.setReqorg_q(DefineUtils.DEFAULT_ORGNO);
//			}else{
//				form.setReqorg_q(user.getOrgid());
//			}

			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//���ó���״̬Ϊ��������

			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYOUTTIME);
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);

		
			
			//����BL��ѯ
			dto = items01BL.searchOutStockBy0148Action(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutmap(dto.getOutmap());//�����嵥
			super.<ITEMS01081VO>setVO(req, vo);
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			log.debug("========�����嵥��ѯ��������========");
			
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			}
		}else if("DETAIL".equals(mapping.getParameter())){
			log.debug("========�����嵥��ϸ��ѯ����ʼ========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;
			
			//��ȡ��ҳBean
			getPaginDTO(req,"ITEMS0166");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (ITEMS0148Form) req.getSession().getAttribute("ITEMS0148Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			

			int maxCnt = getMaxDataCount("ITEMS0166");
			
			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYSEQCODE);//����Ʒ��š�����ʱ�䡢���û�����������
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//���ó���״̬Ϊ��������
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//����BL
			dto = items01BL.searchOutStockDetailBy0148Action(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStocktbList(dto.getOsList());//�����嵥��ϸ
			super.<ITEMS01081VO>setVO(req, vo);
			
			log.debug("========�����嵥��ϸ��ѯ��������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========�����嵥��ϸ��ѯ����ʼ========");
			ITEMS0148Form form = (ITEMS0148Form)actionForm;

			int maxCnt = getMaxDataCount("ITEMS0166");
			
			form.setSortType(DefineUtils.OUTSTOCK_SORT_BYSEQCODE);//����Ʒ��š�����ʱ�䡢���û�����������
			
			form.setReqstatus_q(DefineUtils.ITEMSCODES_REQSTATUS_DJS);//���ó���״̬Ϊ��������
			
			dto.setItems0148form(form);
			
			dto.setOutStockSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//����BL
			dto = items01BL.searchExcelDataBy0148Action(dto);
			//����VO
			ITEMS01081VO vo = new ITEMS01081VO();
			vo.setOutStocktbList(dto.getOsList());//�����嵥��ϸ
			super.<ITEMS01081VO>setVO(req, vo);
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			
			log.debug("========�����嵥��ϸ��ѯ��������========");
			
			return mapping.findForward("REPORT");

		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
