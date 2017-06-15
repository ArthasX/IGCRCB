package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1804Form;
import com.deliverik.infogovernor.asset.vo.IGASM18041VO;

/**
 * ϵͳ������Ϣ��ϸ����Action����
 *
 */
public class IGASM1804Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1804Action.class);

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
		IGASM1804Form form = (IGASM1804Form)actionForm;
		
		//BLȡ��
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO����
		IGASM18DTO dto = new IGASM18DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//ϵͳ������Ϣ�Ǽǻ��������ʾ����
			log.debug("========ϵͳ������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1804");

			//DTO��������趨
			dto.setIgasm1804Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//ϵͳ������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM1804Action(dto);
			
			//��ϵͳ������Ϣ��������趨��VO��
			IGASM18041VO vo = new IGASM18041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM18041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","ϵͳ������Ϣ"));
			saveToken(req);
			log.debug("========ϵͳ������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		}  if( "EDIT".equals(mapping.getParameter())){
			//ϵͳ������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//ϵͳ������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//����ϵͳ��ѯ����
					return mapping.findForward("BACK1");
				} else {
					//����ϵͳ�Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========ϵͳ������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm1804Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========ϵͳ������Ϣ�༭��������========");
			forward = "DISP";
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
