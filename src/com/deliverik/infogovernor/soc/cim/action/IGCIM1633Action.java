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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1633Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16321VO;

/**
 * ���������ϵ����Action����
 *
 */
public class IGCIM1633Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1633Action.class);

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
				IGCIM1633Form form = (IGCIM1633Form)actionForm;
				
				//BLȡ��
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO����
				IGCIM16DTO dto = new IGCIM16DTO();
				dto.setLocale(this.getLocale(req));
				//������ת�趨
				String forward = null;
				
				if( "INSERT".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
					//�豸��ϵ�����������ʾ����
					//DTO��������趨
					dto.setIgcim1633Form(form);
					
					if (isTokenValid(req, true)){
						
						dto = ctlBL.insertBusiessRelation(dto);
						
						forward = "DISP";
						
					}else{
						addMessage(req, new ActionMessage("IGCO00000.E007"));
						return mapping.findForward("/error1");
					}

					log.debug("========�豸��ϵ�ǼǴ�������========");
				}
				if ("EDIT".equals(mapping.getParameter())) {
					log.debug("==============���������ϵ���ҳ��Ԥ����ʼ=================");
					form = new IGCIM1633Form();
					//���session�е�form��
					req.getSession().setAttribute("IGCIM1633Form", form);
					form.setEiid(Integer.valueOf(req.getParameter("eiid")));
					dto.setIgcim1633Form(form);
					
					dto = ctlBL.initIGCIM1632EditAction(dto);
					IGCIM16321VO vo = new IGCIM16321VO();
					vo.setEntityItemData(dto.getSoc0124Info());
					setVO(req, vo);
					forward = "DISP";
					log.debug("==============���������ϵ���ҳ��Ԥ�������=================");
				}
				
				

				//�߼���������е���Ϣ��ʾ
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward(forward);
			}
}
