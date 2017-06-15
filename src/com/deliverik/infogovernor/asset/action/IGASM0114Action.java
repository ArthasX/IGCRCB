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
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;
import com.deliverik.infogovernor.asset.vo.IGASM01141VO;

/**
 * �ʲ�����Ĭ��ֵ����Action����
 *
 */
public class IGASM0114Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0114Action.class);

	/**
	 * �ʲ�����Ĭ��ֵ����Action����
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
		IGASM0114Form form = (IGASM0114Form)actionForm;
		//BLȡ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		//DTO����
		IGASM01DTO dto = new IGASM01DTO();
		dto.setIgASM0114Form(form);
		req.getSession().setAttribute("ADcount", 0);
		req.getSession().setAttribute("ADcheckCount", 0);
		req.getSession().setAttribute("ADmapcount", 0);
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			//�ʲ�����Ĭ��ֵ�Ǽǻ��������ʾ����
			log.debug("========�ʲ�����Ĭ��ֵ�༭���������ʾ����ʼ========");
			//�ʲ�����Ĭ��ֵ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM0114Action(dto);
			//���ʲ�����Ĭ��ֵ��������趨��VO��
			IGASM01141VO vo = new IGASM01141VO(dto.getMap_IG612Info());
			super.<IGASM01141VO>setVO(req.getSession(), vo);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist" + entry.getKey(), entry.getValue());
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","�ʲ�����Ĭ��ֵ"));
			log.debug("========�ʲ�����Ĭ��ֵ�༭���������ʾ��������========");
			saveToken(req);
		}
		else if( "EDIT".equals(mapping.getParameter())){
			log.debug("========�ʲ�����Ĭ��ֵ�༭����ʼ========");
			dto.setIgASM0114Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editIGASM0114Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========�ʲ�����Ĭ��ֵ�༭��������========");
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
