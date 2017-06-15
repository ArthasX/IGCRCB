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
import com.csebank.items.form.ITEMS0120Form;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

public class ITEMS0120Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0120Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		if("SEARCH".equals(mapping.getParameter())){
			ITEMS0120Form form = (ITEMS0120Form)actionForm;
			ITEMS01DTO dto = new ITEMS01DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
	
			//��ҳ��Ϣ
			getPaginDTO(req,"ITEMS0106");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
//			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("ITEMS0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//�����û�ID�жϵ�ǰ�û��Ƿ���Թ������п��
			boolean flag = items01BL.checkRoleManagerByUserID(dto);
			if(flag){
				form.setOutstockorg(DefineUtils.DEFAULT_ORGNO);
			}else{
				form.setOutstockorg(user.getOrgid());//������������ĸ������Ļ����ţ�
			}
			dto.setOutStockSearchCond(form);
			dto = items01BL.searchOutStockAction(dto);
			if(DefineUtils.ITEMSCODES_REQSTATUS_SHDSP.equals(form.getReqstatus())){ //�������
				req.setAttribute("approveType", DefineUtils.ITEMSCODES_REQSTATUS_SHDSP);
			} else if(DefineUtils.ITEMSCODES_REQSTATUS_XHDSP.equals(form.getReqstatus())){ //��������
				req.setAttribute("approveType", DefineUtils.ITEMSCODES_REQSTATUS_XHDSP);
			}
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setOutStockList(dto.getOsList());
			super.<ITEMS01011VO>setVO(req, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		}
		req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
		return mapping.findForward("DISP");
	}
	
}


