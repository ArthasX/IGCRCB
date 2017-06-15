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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1611Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16021VO;

/**
 * ���������ϵ����Action����
 *
 */
public class IGCIM1611Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1611Action.class);

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
				IGCIM1611Form form = (IGCIM1611Form)actionForm;
				
				//BLȡ��
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO����
				IGCIM16DTO dto = new IGCIM16DTO();
				
				dto.setIgcim1611Form(form);
				
				if ("INSERT".equals(mapping.getParameter())){
					//������Ϣ����
					log.debug("========���������ϵ���洦����ʾ��ʼ========");
					ctlBL.insertSoc0502Info(dto);
					//req.setAttribute("addFlag", true);
					//req.setAttribute("pid",form.getPid());
					log.debug("========���������ϵ���洦����ʾ����========");
					
				}
				if("DISP".equals(mapping.getParameter())){
					this.clearSessionFormData(req);
					req.setAttribute("pid", form.getPid());
				}
				if ("DELETE".equals(mapping.getParameter())){
					//������Ϣɾ��
					log.debug("========���������ϵɾ��������ʾ��ʼ========");
					ctlBL.deleteSoc0501Info(dto);
					log.debug("========���������ϵɾ��������ʾ����========");
					
				}
				if("SEARCH".equals(mapping.getParameter())){
					//������Ϣ����
					log.debug("========���������ϵ���Ҵ�����ʾ��ʼ========");
					//��ҳ��DTOȡ��
					getPaginDTO(req,"IGCIM1611");
					
					PagingDTO pDto;
					
					pDto = (PagingDTO)req.getAttribute("PagingDTO");
					
					
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGCIM1611Form) req.getSession().getAttribute("IGCIM1611Form");
						//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
						if (form !=null) {
							form.setFromCount(0);
						}
					}
					int maxCnt = getMaxDataCount("IGCIM1611");
					
					dto.setMaxSearchCount(maxCnt);
					
					dto.setPagingDto(pDto);
					
					
					ctlBL.getSoc0502Info(dto);
					
					IGCIM16021VO vo = new IGCIM16021VO();
					vo.setSoc0502Infos(dto.getSoc0502List());
					vo.setSoc0501Info(dto.getSoc0501Info());
					
					super.setVO(req, vo);
					
					log.debug("========���������ϵ���Ҵ�����ʾ����========");
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
