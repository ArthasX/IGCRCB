package com.deliverik.infogovernor.soc.mnt.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0106Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01061VO;

/**
 * �ʲ����ѯHELP������Action����
 *
 */
public class IGMNT0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMNT0106Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGMNT0106Form form = (IGMNT0106Form)actionForm;
		
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		
		//DTO����
		IGMNT01DTO dto = new IGMNT01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========�ʲ���HELP��ѯ���������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameAction(dto);
				form.setEname(dto.getEname());
			}
			//���²�ѯ���������
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			//��ȡ�����б����
			dto=ctlBL.searchEsyscodingAction(dto);
			List<LabelValueBean> esyscodingList = dto.getEsyscodingList();
			req.getSession().setAttribute("esyscodingList", esyscodingList);
			
			//���������б�Ĭ��ֵ
			String mtId = form.getMtId();
			if(StringUtils.isNotEmpty(mtId)){
				dto.setMtId(mtId);
				MonitorTypeInfo monitorType = ctlBL.searchMonitorTypeByPK(dto);
				String mtSyscoding = monitorType.getMtSyscoding();
				if(mtSyscoding.equals("001001")){//DMX
					form.setEsyscoding("999001009001");
				}else if(mtSyscoding.equals("001002")){//IBM
					form.setEsyscoding("999001009002");
				}else if(mtSyscoding.equals("001003")){//CX
					form.setEsyscoding("999001009003");
				}else if(mtSyscoding.equals("002001")){//Brocade
					form.setEsyscoding("999001006001");
				}else if(mtSyscoding.equals("002002")){//Cisco
					form.setEsyscoding("999001006002");
				}else if(mtSyscoding.equals("002003")){//Mcdata
					form.setEsyscoding("999001006003");
				}
			}
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			log.debug("========�ʲ���HELP��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ���HELP��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========�ʲ����ѯHELP����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGMNT0106");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGMNT0106Form) req.getSession().getAttribute("IGMNT0106Form");
				if ( form== null){
					form = new IGMNT0106Form();
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
					form = (IGMNT0106Form) req.getSession().getAttribute("IGMNT0106Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			
			
//			pDto.setFromCount(form.getFromCount());
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGMNT0106");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			
			if("SEARCH2".equals(mapping.getParameter())){
				//�����ѯ��ť�������
				if (req.getParameter("PAGING") == null) {
					req.getSession().removeAttribute("ADSelectEntity");
					form.setSelectId(null);
				}
			}
			
			dto.setPagingDto(pDto);
			

			//�ʲ�����Ϣ�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���ʲ�����Ϣ��������趨��VO��
			IGMNT01061VO vo = new IGMNT01061VO(dto.getEntityItemVWInfoList());
			
			super.<IGMNT01061VO>setVO(req, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========�ʲ���HELP��ѯ��������========");
		}
		return mapping.findForward("DISP");
	}
}
