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
import com.csebank.lom.form.IGLOM0514Form;
import com.csebank.lom.vo.IGLOM05141VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_��Ʒ����»���ͳ�ƹ���_ͳ�Ʋ�ѯACTION
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0514Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0505Action.class);
	
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
		IGLOM0514Form form = (IGLOM0514Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth(IGStringUtils.getCurrentDate().substring(5,7));
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		//ʵ����DTO
		IGLOM05DTO dto = new IGLOM05DTO();
		//ͳ�Ʋ�ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ����ʼ========");
			getPaginDTO(request,"IGLOM0514");
			dto.setGoodsStockSearchCond(form);
			dto.setIglom0514Form(form);
			//����BL��ѯ
			dto = ctlBL.searchGoodsStockAction(dto);
			if(dto.getGoodsStockList()!=null){
				if(dto.getGoodsStockList().size()==1){
					dto.getGoodsStockList().clear();
				}
			}
			//����VO
			IGLOM05141VO vo = new IGLOM05141VO();
			//vo.setGoodsStockList(dto.getGoodsStockList());
			vo.setMap(dto.getMap());
			vo.setInnum(dto.getInnum());
			vo.setOutnum(dto.getOutnum());
			vo.setNownum(dto.getNownum());
			super.<IGLOM05141VO>setVO(request, vo);
			
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ��������========");
		}else if( "REPORT".equals(mapping.getParameter())){
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ����ʼ========");
			form.setEtime_from("report");
			dto.setGoodsStockSearchCond(form);
			dto.setIglom0514Form(form);
			//����BL��ѯ
			
			dto = ctlBL.searchGoodsStockAction(dto);
//			if(dto.getGoodsStockList()!=null){
//				if(dto.getGoodsStockList().size()==1){
//					dto.getGoodsStockList().clear();
//				}
//			}
			//����VO
			IGLOM05141VO vo = new IGLOM05141VO();
			//vo.setGoodsStockList(dto.getGoodsStockList());
			vo.setMap(dto.getMap());
			vo.setInnum(dto.getInnum());
			vo.setOutnum(dto.getOutnum());
			vo.setNownum(dto.getNownum());
			super.<IGLOM05141VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05141VO", vo);
			form.setEtime_from("");
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ��������========");
			return mapping.findForward("REPORT");

		}else if( "REPORTD".equals(mapping.getParameter())){
			log.debug("========��Ʒ����»���ͳ����ϸ��ѯ����ʼ========");
			form.setEtime_from("report");
			dto.setGoodsStockSearchCond(form);
			dto.setIglom0514Form(form);
			//����BL��ѯ
			dto = ctlBL.searchGoodsStockDetailAction(dto);
			
			//����VO
			IGLOM05141VO vo = new IGLOM05141VO();
			vo.setGoodsStockList(dto.getGoodsStockList());
			super.<IGLOM05141VO>setVO(request, vo);
			request.setAttribute("form", form);
			request.setAttribute("IGLOM05141VO", vo);
			form.setEtime_from("");
			request.setAttribute("name", form.getGoodsN());
			log.debug("========��Ʒ����»���ͳ�Ʋ�ѯ��������========");
			
			return mapping.findForward("REPORT");

		}else if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========��Ʒ����»���ͳ����ϸ��ѯ����ʼ========");
			dto.setGoodsStockSearchCond(form);
			dto.setIglom0514Form(form);
			//����BL��ѯ
			dto = ctlBL.searchGoodsStockDetailAction(dto);
			form.setGoodsN(dto.getGoodsStockList().get(0).getGiodname());
			//����VO
			IGLOM05141VO vo = new IGLOM05141VO();
			vo.setGoodsStockList(dto.getGoodsStockList());
			
			super.<IGLOM05141VO>setVO(request, vo);
			
			log.debug("========��Ʒ����»���ͳ����ϸ��ѯ��������========");
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
