/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03091VO;

/**
 * ����: �豸��ϸ��ϢAction����
 * ��������: �豸��ϸ��ϢAction����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGCIM0309Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0309Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0309Form form = (IGCIM0309Form)actionForm;
		
		//BLȡ��
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�豸������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0309");
			
			//DTO��������趨
			dto.setIgcim0309Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�豸������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGCIM0309Action(dto);
			
			//���豸������Ϣ��������趨��VO��
			IGCIM03091VO vo = new IGCIM03091VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setSoc0128List(dto.getConfigItemVersionTime());
			super.<IGCIM03091VO>setVO(req.getSession(), vo);
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
			IGCIM0309Form finalform = new IGCIM0309Form();
			BeanUtils.copyProperties(finalform, form);
			req.getSession().setAttribute("ADfinalform", finalform);
			req.setAttribute("eiidValue", form.getEiid());
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
