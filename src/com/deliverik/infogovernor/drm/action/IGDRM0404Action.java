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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;

/**
 * Ӧ���ʲ�������Ϣ��ϸ����Action����
 *
 */
public class IGDRM0404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0404Action.class);

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
		IGDRM0404Form form = (IGDRM0404Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		req.setAttribute("backPage", req.getParameter("backPage"));
		
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ���ʲ�������Ϣ�Ǽǻ��������ʾ����
			log.debug("========Ӧ���ʲ�������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
//			int maxCnt = getMaxDataCount("IGASM0504");
//
//			//DTO��������趨
//			dto.setIgdrm0404Form(form);
//			
//			dto.setMaxSearchCount(maxCnt);
//			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
//			
//			dto.setUser(user);
//			
//			//Ӧ���ʲ�������Ϣ�Ǽǻ��������ʾ�߼�����
//			dto = ctlBL.initIGDRM0404Action(dto);
//			
//			//��Ӧ���ʲ�������Ϣ��������趨��VO��
//			IGDRM04041VO vo = new IGDRM04041VO(dto.getEntityItemVW(),
//					dto.getConfigItemVWInfoMap());
//			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
//			vo.setFlag(dto.isFlag());
//			vo.setEiorgname(dto.getEiorgname());
//			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
//			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
//			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
//				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
//				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
//			}
//			super.<IGDRM04041VO>setVO(req.getSession(), vo);
//			
//			addMessage(req, new ActionMessage("IGCO10000.I001","Ӧ���ʲ�������Ϣ"));
//			saveToken(req);
//			log.debug("========Ӧ���ʲ�������Ϣ�Ǽǻ��������ʾ��������========");
//			forward = "DISP";
//		} else if( "EDIT".equals(mapping.getParameter())){
//			//Ӧ���ʲ�������Ϣ�༭
//			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
//				//Ӧ���ʲ�������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
//				if (form.getRoute().equals("0")){
//					//����Ӧ���ʲ���ѯ����
//					return mapping.findForward("BACK1");
//				} else {
//					//����Ӧ���ʲ��Ǽǻ���
//					return mapping.findForward("BACK2");
//				}
//			}
//
//			log.debug("========Ӧ���ʲ�������Ϣ�༭����ʼ========");
//
//			//DTO��������趨
//			dto.setIgdrm0404Form(form);
//			if (isTokenValid(req, true)){
//				//����������Ϣ�༭�߼�����
//				dto = ctlBL.editEntityItemAction(dto);
//			}else{
//				addMessage(req, new ActionMessage("IGCO00000.E007"));
//				return mapping.findForward("/error1");
//			}

			log.debug("========Ӧ���ʲ�������Ϣ�༭��������========");
			forward = "DISP";
		}else if("GETLABEL".equals(mapping.getParameter())){
			dto.setEsyscoding(req.getParameter("esyscoding"));
			ctlBL.getLabel(dto);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(dto.getEilabel());
			return null;
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
