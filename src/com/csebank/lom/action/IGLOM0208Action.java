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
import com.csebank.lom.form.IGLOM0208Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM02081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * ��Ʒ����Action
 * 
 */
public class IGLOM0208Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0208Action.class);
	
	/**
	 * ��Ʒ����
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
		req.setAttribute("category_options", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��Ʒ������ѯ��ʼ��������ʼ========");
			saveToken(req);
			log.debug("========��Ʒ������ѯ��ʼ����������========");
		}else if("TO".equals(mapping.getParameter())){
			log.debug("========��Ʒ������ѯ��ʼ��������ʼ========");
			saveToken(req);
			log.debug("========��Ʒ������ѯ��ʼ����������========");
		}else if("SEARCH".equals(mapping.getParameter())  || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========��Ʒ������ѯ������ʼ========");
			saveToken(req);
			IGLOM0208Form form = (IGLOM0208Form)actionForm;
			if ("SEARCH1".equals(mapping.getParameter())){//����ҳ.do
				form = (IGLOM0208Form) req.getSession().getAttribute("IGLOM0208Form");
			}
			//��ȡ��ҳBean
			getPaginDTO(req,"IGLOM0208");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0208Form) req.getSession().getAttribute("IGLOM0208Form");
				if ( form == null ) {
					form = new IGLOM0208Form();
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
					form = (IGLOM0208Form) req.getSession().getAttribute("IGLOM0208Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("IGLOM0208");
			dto.setIglom0208Form(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			dto.setOrg_q(IGLOMCONSTANTS.DEFAULT_ORGSYSCODING);//����Ĭ�ϻ�����Ϊ���л�����
			//����BL��ѯ
			dto = iglom02BL.searchGoodsForEditAction(dto);
			if(dto.getGstockList()!=null){
				if(!"SEARCH1".equals(mapping.getParameter())){
					Integer[] gsids = new Integer[dto.getGstockList().size()];
					Integer[] goinnums = new Integer[dto.getGstockList().size()];
					String[] gcategorys = new String[dto.getGstockList().size()];
					String[] gnames = new String[dto.getGstockList().size()];
					String[] gcodes = new String[dto.getGstockList().size()];
					
					form.setGsids(gsids);
					form.setGoinnums(goinnums);
					form.setGcategorys(gcategorys);
					form.setGnames(gnames);
					form.setGcodes(gcodes);
				}else{
					Integer[] goinnums = form.getGoinnums();
					Integer[] new_goinnums = new Integer[goinnums.length];
					for(int i=0,j=goinnums.length;i<j;i++){
						if(goinnums[i]==0){
							new_goinnums[i] = null;
						}else{
							new_goinnums[i] = goinnums[i];
						}
					}
					form.setGoinnums(new_goinnums);
				}
			}else{
				Integer[] gsids = new Integer[1];
				Integer[] goinnums = new Integer[1];
				String[] gcategorys = new String[1];
				String[] gnames = new String[1];
				String[] gcodes = new String[1];
				
				form.setGsids(gsids);
				form.setGoinnums(goinnums);
				form.setGcategorys(gcategorys);
				form.setGnames(gnames);
				form.setGcodes(gcodes);
			}
			

			req.getSession().setAttribute("ADcount", 0);//���������
			req.getSession().setAttribute("ADcheckCount", 0);
			
			//����VO
			IGLOM02081VO vo = new IGLOM02081VO();
			vo.setItemsCategoryList(dto.getGstockList());
			super.<IGLOM02081VO>setVO(req, vo);
			
			log.debug("========��Ʒ������ѯ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========������Ʒ������ʼ========");
			IGLOM0208Form form = (IGLOM0208Form)actionForm;
			dto.setUser(user);

			dto.setIglom0208Form(form);
			
			//����BL
			if(isTokenValid(req, true)){
				dto = iglom02BL.doStock(dto,"editGoutStockAction");
//				if("CK_NUM_ERROR".equals(dto.getGotoError())){
//					//�������������������
//					return mapping.findForward("CK_NUM_ERROR");//���ش�����ʾ��Ϣҳ
//				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========������Ʒ��������========");
		}else if("READ".equals(mapping.getParameter())){
			log.debug("========��Ʒ�����鿴��ϸ������ʼ========");
			saveToken(req);
			
			log.debug("========��Ʒ�����鿴��ϸ��������========");
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