package com.deliverik.infogovernor.action;

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
import com.deliverik.infogovernor.form.IGCOM0302Form;
import com.deliverik.infogovernor.form.IGCOM0329Form;
import com.deliverik.infogovernor.vo.IGCOM03021VO;
import com.deliverik.infogovernor.vo.IGCOM03291VO;

/**
 * �ʲ����ѯHELP������Action����
 *
 */
public class IGCOM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0302Action.class);

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
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCOM0329Form form = (IGCOM0329Form)actionForm;
		
		//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO����
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========�ʲ���HELP��ѯ���������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameAction(dto);
				form.setEname(dto.getEname());
			}
			//���²�ѯ���������
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			log.debug("========�ʲ���HELP��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ���HELP��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========�ʲ����ѯHELP����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCOM0302");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCOM0329Form) req.getSession().getAttribute("IGCOM0329Form");
				if ( form== null){
					form = new IGCOM0329Form();
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
					form = (IGCOM0329Form) req.getSession().getAttribute("IGCOM0329Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//���õ���ҳ�治��ʾ�ѱ����豸
			form.setEistatus("0");
//			pDto.setFromCount(form.getFromCount());
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCOM0302");
			
			//DTO��������趨
			dto.setSoc0214SearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			
			if("SEARCH2".equals(mapping.getParameter())){
				form.setEcategory("SVR");
				dto.setSoc0214SearchCond(form);
				//�����ѯ��ť�������
				if (req.getParameter("PAGING") == null) {
					req.getSession().removeAttribute("ADSelectEntity");
					form.setSelectId(null);
				}
			}
			
			dto.setPagingDto(pDto);
			

			//�ʲ�����Ϣ�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���ʲ�����Ϣ��������趨��VO��
			IGCOM03291VO vo = new IGCOM03291VO(dto.getSoc0124List());
			
			super.<IGCOM03291VO>setVO(req, vo);
			
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
