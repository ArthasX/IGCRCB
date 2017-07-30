package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM17BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM17DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1701Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM17011VO;

/**
 * ��־��Ϣ����Action����
 *
 */
public class IGCIM1701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1701Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
				IGCIM1701Form form = (IGCIM1701Form)actionForm;
				
				//BLȡ��
				IGCIM17BL ctlBL = (IGCIM17BL) getBean("igcim17BL");
				
				//DTO����
				IGCIM17DTO dto = new IGCIM17DTO();
				
				dto.setIgcim1701Form(form);
				
				//��ѯCI����
				dto.setEsyscoding(EntityItemKeyWords.DATABASE_ESYSCODING);
				dto= ctlBL.searchSoc0113Info(dto);
				
				if ("INSERT".equals(mapping.getParameter())){
					//��־��Ϣ����
					log.debug("========��־��Ϣ���洦����ʾ��ʼ========");
					log.debug("========��־��Ϣ���洦����ʾ����========");
				}
				if ("DELETE".equals(mapping.getParameter())){
					//��־��Ϣɾ��
					log.debug("========��־��Ϣɾ��������ʾ��ʼ========");
					log.debug("========��־��Ϣɾ��������ʾ����========");
				}
				if("DISP".equals(mapping.getParameter())){
					log.debug("========��־Ԥ������ʾ��ʼ========");
					IGCIM17011VO vo = new IGCIM17011VO();
					
					vo.setCiTypes(dto.getSoc0113List());
					super.setVO(req, vo);
					
					log.debug("========��־Ԥ������ʾ����========");
					
				}
				if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
					//��ҳ��DTOȡ��
					getPaginDTO(req,"IGCIM1701");
					
					PagingDTO pDto;
					
					pDto = (PagingDTO)req.getAttribute("PagingDTO");
					//�豸��ѯ����
					log.debug("========�豸��ѯ������ʼ========");
					if ("SEARCH1".equals(mapping.getParameter())){
						//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
						form = (IGCIM1701Form)req.getSession().getAttribute("IGCIM1701Form");
						if ( form== null){
							form = new IGCIM1701Form();
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
							form = (IGCIM1701Form) req.getSession().getAttribute("IGCIM1701Form");
							if (form !=null) {
								form.setFromCount(0);
							}
						}
					}
				
				
					int maxCnt = getMaxDataCount("IGCIM1701");
					
					dto.setFormName("IGCIM1701Form");
					
					dto.setMaxSearchCount(maxCnt);
					
					dto.setPagingDto(pDto);
					
					dto.setIgcim1701Form(form);
					
					ctlBL.searchSoc0153List(dto);
					
					IGCIM17011VO vo = new IGCIM17011VO(dto.getSoc0153List());
					
					vo.setCiTypes(dto.getSoc0113List());
					
					super.setVO(req, vo);
					
					log.debug("========��־��Ϣ���Ҵ�����ʾ����========");
				}
				//�߼����������е���Ϣ��ʾ
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward("DISP");
	}
}