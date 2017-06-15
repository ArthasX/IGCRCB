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
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2804Form;
import com.deliverik.infogovernor.asset.vo.IGASM28041VO;

/**
 * �����������Ϣ��ϸ����Action����
 *
 */
public class IGASM2804Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2804Action.class);

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
		IGASM2804Form form = (IGASM2804Form)actionForm;
		
		//BLȡ��
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO����
		IGASM28DTO dto = new IGASM28DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//�����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2804");

			//DTO��������趨
			dto.setIgasm2804Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			//�����������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM2804Action(dto);
			form.setHiddenmguserid(dto.getHiddenmguserid());
			//�������������Ϣ��������趨��VO��
			IGASM28041VO vo = new IGASM28041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			vo.setItemList(dto.getItemList());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			vo.setCheckToRiskRelateList(dto.getCheckToRiskRelateList());
			vo.setRiskToZhRelateList(dto.getRiskToZhRelateList());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM28041VO>setVO(req.getSession(), vo);
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("looksign", form.getLooksign());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			addMessage(req, new ActionMessage("IGCO10000.I001","�����������Ϣ"));
			saveToken(req);
			log.debug("========�����������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//�����������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//�����������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//���ؼ�����ѯ����
					return mapping.findForward("BACK1");
				} else {
					//���ؼ����Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========�����������Ϣ�༭����ʼ========");
			String[] civalue =  form.getCivalue();
			civalue[1]= form.getHiddenmguserid();
			form.setCivalue(civalue);
			//DTO��������趨
			dto.setIgasm2804Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========�����������Ϣ�༭��������========");
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
