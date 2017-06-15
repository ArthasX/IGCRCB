package com.deliverik.infogovernor.risk.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0604Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06041VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * �����������Ϣ�޸Ļ���Action����
 *
 */
public class IGRIS0604Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0604Action.class);

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
		IGRIS0604Form form = (IGRIS0604Form)actionForm;
		
		//BLȡ��
		IGRIS06BL ctlBL = (IGRIS06BL) getBean("igris06BL");
		
		//DTO����
		IGRIS06DTO dto = new IGRIS06DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
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
		
		
		if( "DISP".equals(mapping.getParameter())){
			//�����������Ϣ�Ǽǻ��������ʾ����
			log.debug("========�����������Ϣ�Ǽǻ��������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGRIS0604");

			//DTO��������趨
			dto.setIgris0604Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			//�����������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGRIS0604Action(dto);
			//����ո����б�
			form.setAttachmentList(new ArrayList<Attachment>());
			if (form.getCivalue()[3]!=null &&!form.getCivalue()[3].equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getCivalue()[3]);
				form.setAttachmentList(attachmentList);
			}
			
			form.setHiddenmguserid(dto.getHiddenmguserid());
			//�������������Ϣ��������趨��VO��
			IGRIS06041VO vo = new IGRIS06041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			vo.setItemList(dto.getItemList());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			vo.setRiskToZhRelateList(dto.getRiskToZhRelateList());
			vo.setIgris0604Form(form);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGRIS06041VO>setVO(req.getSession(), vo);
			
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
			form.setCivalue(civalue);
			//DTO��������趨
			dto.setIgris0604Form(form);
			if (isTokenValid(req, true)){
				//����������Ϣ�༭�߼�����
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			//����ո����б�
			form.setAttachmentList(new ArrayList<Attachment>());
			if (form.getCivalue()[3]!=null &&!form.getCivalue()[3].equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getCivalue()[3]);
				form.setAttachmentList(attachmentList);
			}
			log.debug("========�����������Ϣ�༭��������========");
			//��ո����ϴ�
			form.setFileList(new ArrayList<FormFileInfo>());
			forward = "DISP";
		}else if("LOADFILE".equals(mapping.getParameter())){
			//��������
			if ("LOADFILE".equals(mapping.getParameter())){
				log.debug("========֪ͨ�������ش���ʼ========");
				String attId = req.getParameter("attid");	
				String type = "sym";
				req.setAttribute("type", type);
				req.setAttribute("attId", attId);

				log.debug("========֪ͨ�������ش������========");
				return mapping.findForward("LOADFILE");
			}
		}else if("STATUS".equals(mapping.getParameter())){
			//form����dto
			dto.setIgris0604Form(form);
			//���¼����״̬
			dto.setUser(user);
			int success = ctlBL.updateCheckItemStatus(dto);
			if(success < 1){
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			forward = "DISP";
		}
		
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		form.setDeletekeys("");
		return mapping.findForward(forward);
	}
}
