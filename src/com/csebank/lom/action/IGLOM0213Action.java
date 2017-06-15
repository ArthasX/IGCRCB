/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0213Form;
import com.csebank.lom.vo.IGLOM02131VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * ���Ԥ��Action
 * 
 */
public class IGLOM0213Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0213Action.class);
	
	/**
	 * ���Ԥ��
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		IGLOM02BL iglom02BL = (IGLOM02BL)this.getBean("iglom02BL");
		
		IGLOM02DTO dto = new IGLOM02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		//ȡ�ö�̬����
		//req.setAttribute("category_options", LOMHelper.getItemsCodes(CodeUtils.ITEMSCODES_GSTOCK_GCATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ��ʼ������ʼ========");
			saveToken(req);
			log.debug("========��Ʒ�����ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����ѯ����ʼ========");
			saveToken(req);
			IGLOM0213Form form = (IGLOM0213Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (IGLOM0213Form) req.getSession().getAttribute("IGLOM0213Form");
			}
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0205");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0213Form) req.getSession().getAttribute("IGLOM0213Form");
				if ( form == null ) {
					form = new IGLOM0213Form();
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
					form = (IGLOM0213Form) req.getSession().getAttribute("IGLOM0213Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0205");
			dto.setIglom0213Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setOrg_q(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//����Ĭ�ϻ�����Ϊ���л�����
			//����BL��ѯ
			dto = iglom02BL.searchGstockWarningAction(dto);
			
			//����VO
			IGLOM02131VO vo = new IGLOM02131VO();
			vo.setGstockVWList(dto.getGstockVWList());
			super.<IGLOM02131VO>setVO(req, vo);
			
			log.debug("========��Ʒ�����ѯ��������========");
		}else if("EXCEL".equals(mapping.getParameter())){
			log.debug("========������Ʒ����ʼ========");
			
			log.debug("========������Ʒ��������========");
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
