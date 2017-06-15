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

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0515Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05151VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_��һ��Ʒ���ͳ�ƹ���_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0515Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0515Action.class);
	
	/**
	 * <p>
	 * Description:��Ʒ����»���ͳ�Ʋ�ѯACTION����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author wuzhenqiu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGLOM0515Form form = (IGLOM0515Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��һ��Ʒ���ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��һ��Ʒ�����ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//ʵ����DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========��һ��Ʒ����»���ͳ�Ʋ�ѯ����ʼ========");
			getPaginDTO(request,"IGLOM0515");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			dto.setSingleGoodsStockSearchCond(form);
			dto.setIglom0515Form(form);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchSingleGoodsStockAction(dto);
			
			//����VO
			IGLOM05151VO vo = new IGLOM05151VO();
			vo.setSingleGoodsStockList(dto.getSingleGoodsStockList());
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			super.<IGLOM05151VO>setVO(request, vo);
			
			log.debug("========��һ��Ʒ����»���ͳ�Ʋ�ѯ��������========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========��һ��Ʒ����»���ͳ�Ʋ�ѯ����ʼ========");
			form.setEdate("report");
			dto.setSingleGoodsStockSearchCond(form);
			dto.setIglom0515Form(form);
			//����BL��ѯ
			dto = ctlBL.searchSingleGoodsStockAction(dto);
			
			//����VO
			IGLOM05151VO vo = new IGLOM05151VO();
			vo.setSingleGoodsStockList(dto.getSingleGoodsStockList());
			super.<IGLOM05151VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05151VO", vo);
			request.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			request.setAttribute("goods", form.getGoods());
			form.setEdate("");
			log.debug("========��һ��Ʒ���ͳ����ϸ��ѯ��������========");
			return mapping.findForward("REPORT");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
