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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.vo.IGASM27041VO;

/**
 * ���յ�������Ϣ��ϸ����Action����
 *
 */
public class IGASM2704Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2704Action.class);

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
		IGASM2704Form form = (IGASM2704Form)actionForm;
		
		//BLȡ��
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		//DTO����
		IGASM27DTO dto = new IGASM27DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//���յ�������Ϣ�Ǽǻ��������ʾ����
			log.debug("========���յ�������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2704");

			//DTO��������趨
			dto.setIgasm2704Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			//���յ�������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM2704Action(dto);
			
			//�����յ�������Ϣ��������趨��VO��
			IGASM27041VO vo = new IGASM27041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			vo.setRiskPointList(dto.getRiskPointList());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			vo.setSearchRiskCheckList(dto.getSearchRiskCheckList());
			vo.setRiskToZhRelateList(dto.getRiskToZhRelateList());
			vo.setIgASM2704Form(dto.getIgasm2704Form());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM27041VO>setVO(req.getSession(), vo);
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			req.getSession().setAttribute("looksign", form.getLooksign());
			addMessage(req, new ActionMessage("IGCO10000.I001","���յ�������Ϣ"));
			saveToken(req);
			log.debug("========���յ�������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//���յ�������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���յ�������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//���ط��յ��ѯ����
					return mapping.findForward("BACK1");
				} else {
					//���ط��յ�Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========���յ�������Ϣ�༭����ʼ========");
			//��ȡ����ֵ
			String[] civalue =  form.getCivalue();
			//�趨�����й�����ID
			civalue[1]= form.getHiddenmguserid();
			form.setCivalue(civalue);
			//DTO��������趨
			dto.setIgasm2704Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========���յ�������Ϣ�༭��������========");
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
