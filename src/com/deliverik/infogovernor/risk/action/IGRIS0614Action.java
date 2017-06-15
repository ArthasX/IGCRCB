package com.deliverik.infogovernor.risk.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06071VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ������ѯ����Action����
 *
 */
public class IGRIS0614Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0614Action.class);

	/**
	 * ������ѯ
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
		IGRIS0614Form igris0614form = (IGRIS0614Form) actionForm;
		
		//BLȡ��
		IGRIS06BL ctrlBL = (IGRIS06BL) getBean("igris06BL");
		
		//DTO����
		IGRIS06DTO dto = new IGRIS06DTO();
		dto.setIgris0614form(igris0614form);
		//��ȡ��ǰ�û�
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//��ȡ��ѯ�ʲ����BL�ӿ�ʵ��
		IGSYM03BL ctl03BL = (IGSYM03BL) getBean("igsym03BL");
		//ʵ�������dto
		IGSYM03DTO igsym03dto = new IGSYM03DTO();
		//��ȡ��ǰ�û�
		igsym03dto.setSubtype("999021");
		//��ȡ���������dto
		igsym03dto = ctl03BL.getAssetDomainTree(igsym03dto, "IGBP19", user);
		//��ʼ������б�
		List<IGRIS06022VO> labelAndValueList = new ArrayList<IGRIS06022VO>();
		labelAndValueList.add(new IGRIS06022VO());
		//��ȡ��� ����
		Map<String, TreeNode> treeMap = igsym03dto.getTreeNodeMap();
		for(Map.Entry<String, TreeNode> entry : treeMap.entrySet()){
			TreeNode treeNode = entry.getValue();
			LinkedHashMap<String, TreeNode> linkHashMap = treeNode.getChildTreeNodeMap();
			for(Map.Entry<String, TreeNode> subEntry : linkHashMap.entrySet()){
				TreeNode subTreeNode = subEntry.getValue();
				labelAndValueList.add(new IGRIS06022VO(subTreeNode.getName(),subTreeNode.getId().split("_")[1]));
			}
		}
		//���浽request
		req.setAttribute("labelAndValueList", labelAndValueList);
		
		if ("DISP".equals(mapping.getParameter())){
			//���յ��޸Ĵ�����ʾ
			log.debug("========���յ��ѯ��ʼ����ʾ��ʼ========");
			
			IGRIS06071VO vo=new IGRIS06071VO();
			super.<IGRIS06071VO>setVO(req, vo);
			//ʵ����vo
			log.debug("=======������ʲ���ѯ�������========");
			
		}else if("SEARCH".equals(mapping.getParameter()) || "BACK".equals(mapping.getParameter())){
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("BACK".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
				if ( igris0614form == null ) {
					igris0614form = new IGRIS0614Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(igris0614form.getFromCount());
					} else {
						igris0614form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
					if (igris0614form !=null) {
						igris0614form.setFromCount(0);
					}
				 }
			}
			
			int maxCnt = getMaxDataCount("IGRIS0614");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����bl �������ݴ���
			ctrlBL.searchCheckItemListAction(dto);
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgris0614form(igris0614form);

			//TODO ��ü������ϸ��Ϣ����
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			vo.setIgris0614form(igris0614form);
			//������
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if("SEARCH1".equals(mapping.getParameter()) || "BACK1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("BACK1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
				if ( igris0614form == null ) {
					igris0614form = new IGRIS0614Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(igris0614form.getFromCount());
					} else {
						igris0614form.setFromCount(pDto.getFromCount());
					}
				}
			}
			int maxCnt = getMaxDataCount("IGRIS0614");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			String eiidStr = igris0614form.getEiids();
			
			StringBuffer eiid_in = new StringBuffer();
			if(eiidStr!=null && !(eiidStr.equals("")) && !(eiidStr.equals("0"))){
				String[] eiids = eiidStr.split(",");
				for(int i = 0; i <eiids.length;i++){
					 eiid_in.append("'").append(eiids[i]).append("'");
					 if(i < eiids.length-1){
						 eiid_in.append(",");
					 }
				}
			}
			dto.getIgris0614form().setEiids(eiid_in.toString());	
			
			//����bl �������ݴ���
			ctrlBL.searchCheckItemWindowAction(dto);
			
			dto.setIgris0614form(igris0614form);

			//��ü������ϸ��Ϣ����
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			String eiidSt = "";
			if(igris0614form.getEiids()!=null && !(igris0614form.getEiids().equals("0"))){
				eiidSt = igris0614form.getEiids().replaceAll("'", "");
				igris0614form.setEiids(eiidSt);
			}
			vo.setIgris0614form(igris0614form);
			//������
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if("SEARCH2".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
			igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
			if ( igris0614form == null ) {
				igris0614form = new IGRIS0614Form();
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(igris0614form.getFromCount());
				} else {
					igris0614form.setFromCount(pDto.getFromCount());
				}
			}
			int maxCnt = getMaxDataCount("IGRIS0614");
			String eiidStr = igris0614form.getEiids();
			
			StringBuffer eiid_in = new StringBuffer();
			if(eiidStr!=null && !(eiidStr.equals("")) && !(eiidStr.equals("0"))){
				String[] eiids = eiidStr.split(",");
				for(int i = 0; i <eiids.length;i++){
					 eiid_in.append("'").append(eiids[i]).append("'");
					 if(i < eiids.length-1){
						 eiid_in.append(",");
					 }
				}
			}
			dto.getIgris0614form().setEiids(eiid_in.toString());
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����bl �������ݴ���
			ctrlBL.searchCheckItemListNotPageAction(dto);
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			StringBuffer eiids = new StringBuffer();
			StringBuffer eiversions = new StringBuffer();
			if(igris0614form.getDeleteEiid()!=null && igris0614form.getDeleteEiid().length>0){
				for(int i=0;i<igris0614form.getDeleteEiid().length;i++){
					eiids.append(igris0614form.getDeleteEiid()[i]);
					if(i<igris0614form.getDeleteEiid().length-1){
						eiids.append(",");
					}
				}
			}
			igris0614form.setEiids(eiids.toString());
			
			dto.setIgris0614form(igris0614form);
			
			//��ü������ϸ��Ϣ����
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			String eiidSt = "";
			if(igris0614form.getEiids()!=null && !(igris0614form.getEiids().equals("0"))){
				eiidSt = igris0614form.getEiids().replaceAll("'", "");
				igris0614form.setEiids(eiidSt);
			}
			vo.setIgris0614form(igris0614form);
			//������
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if ("DELETE".equals(mapping.getParameter())){
			//�����ɾ������
			log.debug("========�����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(igris0614form.getDeleteEiid());
			
			//�������Ϣɾ���߼�����
			ctrlBL.deleteEntityItemAction(dto);
			
			log.debug("========�����ɾ����������========");
		}else if("SELECT".equals(mapping.getParameter())){
			
		}
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
