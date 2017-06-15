package com.deliverik.infogovernor.soc.aff.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0000Form;
import com.deliverik.infogovernor.vo.IGCOM03271VO;

/**
 * �ʲ����ѯHELP������Action����
 *
 */
public class IGAFF0000Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAFF0000Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGAFF0000Form form = (IGAFF0000Form)actionForm;
		
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�ʲ���ѯ���������ʾ����ʼ========");
			req.setAttribute("paramEsyscoding", req.getParameter("paramEsyscoding"));
			
			this.clearSessionFormData(req);
			log.debug("========�ʲ���������ʾ��������========");
			return mapping.findForward("DISP");
		} 

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========�ʲ����ѯHELP����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCOM0327");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			req.setAttribute("paramEsyscoding", form.getParamEsyscoding());
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGAFF0000Form) req.getSession().getAttribute("IGAFF0000Form");
				if ( form== null){
					form = new IGAFF0000Form();
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
					form = (IGAFF0000Form) req.getSession().getAttribute("IGAFF0000Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCOM0327");
			
			if(StringUtils.isEmpty(form.getEsyscoding())){
				form.setEsyscoding("999001");
			}
			
			//DTO��������趨
			dto.setSoc0214SearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			
			if("SEARCH2".equals(mapping.getParameter())){
				//�����ѯ��ť�������
				if (req.getParameter("PAGING") == null) {
					req.getSession().removeAttribute("ADSelectEntity");
//					form.setSelectId(null);
				}
			}
			
			dto.setPagingDto(pDto);
			

			//�ʲ�����Ϣ�����߼�����
			dto = ctlBL.searchEntityItem0327Action(dto);
			
			//���ʲ�����Ϣ��������趨��VO��
			IGCOM03271VO vo = new IGCOM03271VO(dto.getSoc0124List());
			req.setAttribute("esyscoding",form.getEsyscoding());
			super.<IGCOM03271VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========�ʲ���HELP��ѯ��������========");
		}
		return mapping.findForward("DISP");
	}
}
