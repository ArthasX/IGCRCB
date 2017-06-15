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
import com.deliverik.infogovernor.asset.bl.IGASM02BL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.vo.IGASM02041VO;

/**
 * ������������Ϣ��ϸ����Action����
 *
 */
public class IGASM0204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0204Action.class);

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
		IGASM0204Form form = (IGASM0204Form)actionForm;
		
		//BLȡ��
		IGASM02BL ctlBL = (IGASM02BL) getBean("igasm02BL");
		
		//DTO����
		IGASM02DTO dto = new IGASM02DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//������������Ϣ�Ǽǻ��������ʾ����
			log.debug("========������������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0204");

			//DTO��������趨
			dto.setIgasm0204Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//������������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM0204Action(dto);
			
			//��������������Ϣ��������趨��VO��
			IGASM02041VO vo = new IGASM02041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGASM02041VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","������������Ϣ"));
			log.debug("========������������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} 

		if( "EDIT".equals(mapping.getParameter())){
			//������������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//������������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//�����������ѯ����
					return mapping.findForward("BACK1");
				} else {
					//����������Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========������������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgasm0204Form(form);
			
			//����������Ϣ�༭�߼�����
			dto = ctlBL.editEntityItemAction(dto);
			

			log.debug("========������������Ϣ�༭��������========");
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
