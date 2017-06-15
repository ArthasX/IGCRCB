package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0602Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR06021VO;

/**
 * ���⻯������Ϣ��ϸ����Action����
 *
 */
public class IGVIR0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0602Action.class);

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
		IGVIR0602Form form = (IGVIR0602Form)actionForm;
		
		//BLȡ��
		IGVIR06BL ctlBL = (IGVIR06BL) getBean("igvir06BL");
		
		//DTO����
		IGVIR06DTO dto = new IGVIR06DTO();
		dto.setLocale(this.getLocale(req));
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//���⻯������Ϣ�Ǽǻ��������ʾ����
			log.debug("========���⻯������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0104");

			//DTO��������趨
			dto.setIgvir0602Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//���⻯������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGVIR0602Action(dto);
			
			//�����⻯������Ϣ��������趨��VO��
			IGVIR06021VO vo = new IGVIR06021VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			//��ȡ��ʷ�汾����ʱ��
			vo.setConfigItemVersionTime(dto.getConfigItemVersionTime());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGVIR06021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","���⻯������Ϣ"));
			saveToken(req);
			log.debug("========���⻯������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//���⻯������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���⻯������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//����Ӧ�ò�ѯ����
					return mapping.findForward("BACK1");
				} else {
					//����Ӧ�õǼǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========���⻯������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgvir0602Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemActionApp(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========���⻯������Ϣ�༭��������========");
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
