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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0161Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01611VO;

/**
 * ���ý�����־��Ϣ����Action����
 *
 */
public class IGCIM0161Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0161Action.class);

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
				IGCIM0161Form form = (IGCIM0161Form)actionForm;
				
				//BLȡ��
				IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
				
				//DTO����
				IGCIM01DTO dto = new IGCIM01DTO();
				
				dto.setIgcim0161Form(form);
				
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
					dto= ctlBL.searchSoc0113Info(dto);
					
					IGCIM01611VO vo = new IGCIM01611VO();
					vo.setCiTypes(dto.getSoc0113List());
					super.setVO(req, vo);
					
					log.debug("========��־Ԥ������ʾ����========");
					
				}
				if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
					//��ҳ��DTOȡ��
					getPaginDTO(req,"IGCIM0161");
					
					PagingDTO pDto;
					
					pDto = (PagingDTO)req.getAttribute("PagingDTO");
					//�豸��ѯ����
					log.debug("========�豸��ѯ����ʼ========");
					if ("SEARCH1".equals(mapping.getParameter())){
						//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
						form = (IGCIM0161Form)req.getSession().getAttribute("IGCIM0161Form");
						if ( form== null){
							form = new IGCIM0161Form();
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
							form = (IGCIM0161Form) req.getSession().getAttribute("IGCIM0161Form");
							if (form !=null) {
								form.setFromCount(0);
							}
						}
					}
				
				
					int maxCnt = getMaxDataCount("IGCIM0161");
					
					dto.setMaxSearchCount(maxCnt);
					
					dto.setPagingDto(pDto);
					dto.setWarnType("2");
					dto.setIgcim0161Form(form);
					
					ctlBL.searchSoc0153List(dto);
					
					IGCIM01611VO vo = new IGCIM01611VO(dto.getSoc0153List());
					vo.setCiTypes(dto.getSoc0113List());
					super.setVO(req, vo);
					
					log.debug("========��־��Ϣ���Ҵ�����ʾ����========");
				}
				//�߼���������е���Ϣ��ʾ
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward("DISP");
	}
}
