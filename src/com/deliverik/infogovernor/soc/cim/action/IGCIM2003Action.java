package com.deliverik.infogovernor.soc.cim.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2003Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM20031VO;

/**
 * �豸������Ϣ��ϸ����Action����
 *
 */
public class IGCIM2003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2003Action.class);

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
		IGCIM2003Form form = (IGCIM2003Form)actionForm;
		
		//BLȡ��
		IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
		
		//DTO����
		IGCIM20DTO dto = new IGCIM20DTO();
		dto.setLocale(this.getLocale(req));
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�豸������Ϣ�Ǽǻ��������ʾ������ʼ========");
			req.setAttribute("backurl", req.getParameter("backurl"));
			form.setRoute("0");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM2003");
			
			//DTO��������趨
			dto.setIgcim2003Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�豸������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGCIM2002Action(dto);
			
			//���豸������Ϣ��������趨��VO��
			IGCIM20031VO vo = new IGCIM20031VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			super.<IGCIM20031VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","�豸������Ϣ"));
			log.debug("========�豸������Ϣ�Ǽǻ��������ʾ��������========");
			saveToken(req);
			forward = "DISP";
			IGCIM2003Form finalform = new IGCIM2003Form();
			BeanUtils.copyProperties(finalform, form);
			req.getSession().setAttribute("ADfinalform", finalform);
			req.setAttribute("eiidValue", form.getEiid());
		} else if( "DISP_NOTOKEN".equals(mapping.getParameter())){
			//�豸������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�豸������Ϣ�Ǽǻ��������ʾ������ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0104");

			//DTO��������趨
			dto.setIgcim2003Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�豸������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGCIM2002Action(dto);
			
			//���豸������Ϣ��������趨��VO��
			IGCIM20031VO vo = new IGCIM20031VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGCIM20031VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			req.setAttribute("eiidValue", form.getEiid());
			if(req.getSession().getAttribute("ADfinalform")!=null){
				BeanUtils.copyProperties(form, req.getSession().getAttribute("ADfinalform"));
				req.getSession().removeAttribute("ADfinalform");
			}
			
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","�豸������Ϣ"));
			log.debug("========�豸������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//�豸������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//�豸������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if(req.getParameter("route")!=null){
					return mapping.findForward("BACK3");
				}
				if (form.getRoute().equals("0")){
					//�����豸��ѯ����
					return mapping.findForward("BACK1");
				} else {
					//�����豸�Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========�豸������Ϣ�༭������ʼ========");

			//DTO��������趨
			dto.setIgcim2003Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			dto.setUser(user);
			
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			req.setAttribute("eiidValue", form.getEiid());
			log.debug("========�豸������Ϣ�༭��������========");
			forward = "DISP";
		}else if("XMLDISP".equals(mapping.getParameter())){
			log.debug("========����������ϢXMLҳ���ʼ��������ʼ========");		
			saveToken(req);
			log.debug("========����������ϢXMLҳ���ʼ����������========");
			return mapping.findForward("DISP");
		}
		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
}