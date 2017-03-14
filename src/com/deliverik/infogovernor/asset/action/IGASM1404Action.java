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
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1404Form;
import com.deliverik.infogovernor.asset.vo.IGASM14041VO;

/**
 * �����¼������Ϣ��ϸ����Action����
 *
 */
public class IGASM1404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1404Action.class);

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
		IGASM1404Form form = (IGASM1404Form)actionForm;
		
		//BLȡ��
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO����
		IGASM14DTO dto = new IGASM14DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//�����¼������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�����¼������Ϣ�Ǽǻ��������ʾ����ʼ========");
			saveToken(req);
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1404");

			//DTO��������趨
			dto.setIgasm1404Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�����¼������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM1404Action(dto);
			
			//�������¼������Ϣ��������趨��VO��
			IGASM14041VO vo = new IGASM14041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGASM14041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","�����¼������Ϣ"));
			log.debug("========�����¼������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//�����¼������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//�����¼������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					saveToken(req);
					//���ط����¼��ѯ����
					return mapping.findForward("BACK1");
				} else {
					saveToken(req);
					//���ط����¼�Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========�����¼������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm1404Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUserid(user.getUserid());
			dto.setUsername(user.getUsername());
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
				req.getSession().removeAttribute("ADSelectEntity");
				req.getSession().removeAttribute("ADSelectedEntity");
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========�����¼������Ϣ�༭��������========");
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
