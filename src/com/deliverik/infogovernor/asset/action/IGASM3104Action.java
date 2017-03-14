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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3104Form;
import com.deliverik.infogovernor.asset.vo.IGASM31041VO;

/**
 * ����ָ��������Ϣ��ϸ����Action����
 *
 */
public class IGASM3104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3104Action.class);

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
		IGASM3104Form form = (IGASM3104Form)actionForm;
		//BLȡ��
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		//DTO����
		IGASM31DTO dto = new IGASM31DTO();
		dto.setRiid(Integer.parseInt(form.getEiid()));
		dto.setRimdesc(form.getRimdesc());
		dto.setRimsql(form.getRimsql());
		dto.setRimtype(form.getRimtype());
		dto.setFingerprint(form.getFingerprint());
		req.getSession().setAttribute("ADcount", 0);
		req.getSession().setAttribute("ADcheckCount", 0);
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//����ָ��������Ϣ�Ǽǻ��������ʾ����
			log.debug("========����ָ��������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM3104");
			PagingDTO pDto = new PagingDTO(null,0,0,0);
			//DTO��������趨

			dto.setPagingDto(pDto);
			dto.setIgasm3104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			dto = ctlBL.checkEntityItemDomain(dto);
			//����ָ��������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM3104Action(dto);
			
			//dto = ctlBL.searchEntityItemAction(dto);
			//������ָ��������Ϣ��������趨��VO��
			IGASM31041VO vo = new IGASM31041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setLooksign(form.getLooksign());
			vo.setEiorgname(dto.getEiorgname());
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			req.getSession().setAttribute("looksign", form.getLooksign());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			
			vo.setSelecteiversion(Integer.parseInt(dto.getSearchRiskIndexSearchVWList().get(0).getEiversion()));
			super.<IGASM31041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","����ָ��������Ϣ"));
			saveToken(req);
			log.debug("========����ָ��������Ϣ�Ǽǻ��������ʾ��������========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//����ָ��������Ϣ�༭
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//����ָ��������Ϣ�༭���水�·��ذ�ťʱ�ķ��ش���
				if (form.getRoute().equals("0")){
					//���ط���ָ���ѯ����
					return mapping.findForward("BACK1");
				} else {
					//���ط���ָ��Ǽǻ���
					return mapping.findForward("BACK2");
				}
			}
			log.debug("========����ָ��������Ϣ�༭����ʼ========");
			
			String[] civalue =  form.getCivalue();
			//�趨�����й�����ID
			civalue[6]= form.getHiddenmguserid();
			form.setCivalue(civalue);
			//DTO��������趨
			dto.setIgasm3104Form(form);
			//DTO��������趨
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========����ָ��������Ϣ�༭��������========");
			ctlBL.insertMaintenance(dto);
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
