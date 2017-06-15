/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM06BL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0602Form;
import com.deliverik.infogovernor.drm.vo.IGDRM06021VO;


/**
 * �����ƻ�����Action
 * @author wyw
 * 
 * 2015-2-12 ����9:51:47
 */
public class IGDRM0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0602Action.class);

	/**
	 * 
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
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDRM06BL ctlBL = (IGDRM06BL) getBean("igdrm06BL");
		
		IGDRM0602Form form = (IGDRM0602Form)actionForm;
		
		//DTO����
		IGDRM06DTO dto = new IGDRM06DTO();
		dto.setForm(form);
		dto.setUser(user);
		//������ת�趨
		String forward = "DISP";

//		if( "DISP".equals(mapping.getParameter())){
//			Calendar cal = Calendar.getInstance();
//			Integer year = cal.get(Calendar.YEAR);
//			req.setAttribute("crttimestart", year);
//			
//		    return mapping.findForward(forward);
//		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========�����ƻ���ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0602");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0602Form) req.getSession().getAttribute("IGDRM0602Form");
				if ( form == null ) {
					form = new IGDRM0602Form();
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
//					form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			form.setDid(0);
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0602");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//��ѯ
			dto = ctlBL.searchIGDRM0602Action(dto);
			req.setAttribute("crttimestart", form.getCrttimestart());
			IGDRM06021VO vo = new IGDRM06021VO();
			vo.setSearchDrillplanMap(dto.getSearchDrillplanMap());
			super.<IGDRM06021VO>setVO(req.getSession(), vo);
			log.debug("========�����ƻ���ѯ��������========");
		}
		//����
		if("TOD".equals(mapping.getParameter())){
		    ctlBL.drillplanToJudgeAction(dto);
		    addMessage(req, new ActionMessage("IGDRM0601.I001", "����ɹ���"));
		}
		
		//ɾ��
		if("DELETE".equals(mapping.getParameter())){
//		    if (isTokenValid(req, true)){
		        ctlBL.deleteDrillplanAction(dto);
//		    }else{
//	               addMessage(req, new ActionMessage("IGCO00000.E007"));
//                   return mapping.findForward("/error1");
//		    }
		    addMessage(req, new ActionMessage("IGDRM0601.I001", "ɾ���ɹ���"));
		}
		
		//����
		if("JUDGE".equals(mapping.getParameter())){
		    String status=form.getIsthrough();
		    if("F".equals(status)){
		        dto.setJudgeopinion(form.getDopinion());
		    }
		    dto.setJudgestatus(status);
		    ctlBL.drillplanJudgeAction(dto);
		    String message="";
		    if("T".equals(status)){
		        message="�����ɹ���";
		    }else{
		        message="���سɹ���";
		    }
		    addMessage(req, new ActionMessage("IGDRM0601.I001", message));
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
