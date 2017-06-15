package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0504Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05041VO;

/**
 * ר��Ԥ���ʲ�������Ϣ��ϸ����Action����
 *
 */
public class IGDRM0504Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0504Action.class);

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
		IGDRM0504Form form = (IGDRM0504Form)actionForm;
		//BLȡ��
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		//DTO����
		IGDRM05DTO dto = new IGDRM05DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		req.setAttribute("backPage", req.getParameter("backPage"));
		
		if( "DISP".equals(mapping.getParameter())){
			//ר��Ԥ���ʲ�������Ϣ�Ǽǻ��������ʾ����
			log.debug("========ר��Ԥ���ʲ�������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0504");

			//DTO��������趨
			dto.setIgdrm0504Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//ר��Ԥ���ʲ�������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGDRM0504Action(dto);
			
			
			
			//��ר��Ԥ���ʲ�������Ϣ��������趨��VO��
			IGDRM05041VO vo = new IGDRM05041VO(dto.getEntityItemVW(),
					dto.getConfigItemVWInfoMap());
			//����-��ϵ�ʲ�map - List
			vo.setEntityItemList(dto.getEntityItemList());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.isFlag());
			vo.setEiorgname(dto.getEiorgname());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			
			super.<IGDRM05041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","ר��Ԥ���ʲ�������Ϣ"));
			saveToken(req);
			log.debug("========ר��Ԥ���ʲ�������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//ר��Ԥ���ʲ�������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//ר��Ԥ���ʲ�������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//����ר��Ԥ���ʲ���ѯ����
					return mapping.findForward("BACK1");
				} else {
					//����ר��Ԥ���ʲ��Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========ר��Ԥ���ʲ�������Ϣ�༭����ʼ========");

			//DTO��������趨
			dto.setIgdrm0504Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========ר��Ԥ���ʲ�������Ϣ�༭��������========");
			forward = "DISP";
		}else if("DETAIL".equals(mapping.getParameter())){
			dto.setPdid(req.getParameter("pdid"));
			dto = ctlBL.searchFlowDetail(dto);
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				out.print(dto.getOutPrintStr());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}

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
