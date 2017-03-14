package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM13BL;
import com.deliverik.infogovernor.asset.dto.IGASM13DTO;
import com.deliverik.infogovernor.asset.form.IGASM1302Form;
import com.deliverik.infogovernor.asset.vo.IGASM13021VO;
/**
 * �豸ͳ�Ʒ�����ϢAction����
 *
 */
public class IGASM1302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1302Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BLȡ��
		IGASM13BL asmBL = (IGASM13BL) getBean("igasm13BL");
		IGASM1302Form form = (IGASM1302Form)actionForm;
		IGASM13DTO dto = new IGASM13DTO();
		
		//ȡ�û��������б�
		req.setAttribute("room_list", asmBL.getComputerRoomList(dto));
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��������ͳ�Ʒ������������ʾ����ʼ========");	

			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��������ͳ�Ʒ������������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��������ͳ�Ʒ�������ʼ========");

			//��ȡ��ҳBean
			getPaginDTO(req,"IGASM1302");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM1302Form) req.getSession().getAttribute("IGASM1302Form");
				if ( form== null){
					form = new IGASM1302Form();
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
					form = (IGASM1302Form) req.getSession().getAttribute("IGASM1302Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			int maxCnt = getMaxDataCount("DEFAULT");
			
			dto.setPagingDto(pDto);
			dto.setMaxSearchCount(maxCnt);
			dto.setComputerRoomAndContainerVWSearchCond(form);
			
			dto = asmBL.searchComputerRoomAndContainer(dto);
			//����VO
			IGASM13021VO vo = new IGASM13021VO();
			vo.setRoomandcontainerList(dto.getCrcList());
			super.<IGASM13021VO>setVO(req, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			
			log.debug("========��������ͳ�Ʒ�����������========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			}
		}
		
		return mapping.findForward("DISP");
	}

}
