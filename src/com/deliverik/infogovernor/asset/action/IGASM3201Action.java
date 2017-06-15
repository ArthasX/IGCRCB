package com.deliverik.infogovernor.asset.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM32BL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3201Form;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.asset.vo.IGASM32011VO;

/**
 * �ĵ��༭����Action����
 *
 * @author
 */
public class IGASM3201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3201Action.class);

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
		IGASM3201Form form = (IGASM3201Form)actionForm;
		
		//BLȡ��
		IGASM32BL ctlBL = (IGASM32BL) getBean("IGASM32BL");
		
		//DTO����
		IGASM32DTO dto = new IGASM32DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�����¼���ѯ���������ʾ����ʼ========");
			forward = "DISP";
			log.debug("========�����¼���ѯ���������ʾ�������========");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM3201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�ĵ���ѯ����
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM3201Form) req.getSession().getAttribute("IGASM3201Form");
				if ( form== null){
					form = new IGASM3201Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM3201Form) req.getSession().getAttribute("IGASM3201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM3201");
			
			//��ѯ���°汾
			form.setEiversion("0");
			
			//DTO��������趨
			dto.setIgasm3201Form(form);
			copyArgu(dto);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�ĵ������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���ĵ���Ϣ��������趨��VO��
			IGASM32011VO vo = new IGASM32011VO(dto.getRiskcaseVWList());
			super.<IGASM32011VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			forward = "SUCCESS";
		}else if("SHOW".equals(mapping.getParameter())){
			dto.setEiid(Integer.parseInt(req.getParameter("eiid")));
			PrintWriter out = null;
			try {
				dto = ctlBL.searchRiskPolicyAction(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getRiskPolicy())){
					out.print(dto.getRiskPolicy());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}
	
	private void copyArgu(IGASM32DTO dto){
		RiskcaseVWSearchCondImpl cond= new RiskcaseVWSearchCondImpl();
		IGASM3201Form form = dto.getIgasm3201Form();
		cond.setEiid(form.getEiid());
		cond.setVersion(form.getEiversion());
		cond.setFccategory(form.getFccategory());
		cond.setFcname(form.getFcname());
		cond.setFcorigin(form.getFcorigin());
		cond.setFcpolicy(form.getFcpolicy());
		cond.setRiskcatchtime_from(form.getRiskcatchtime_from());
		cond.setRiskcatchtime_to(form.getRiskcatchtime_to());
		cond.setRiskid(form.getRiskid());
		cond.setRiskreviewresult(form.getRiskreviewresult());
		cond.setEISTATUS(form.getEistatus());
		dto.setRiskcaseVWSearchCond(cond);
	}
}
