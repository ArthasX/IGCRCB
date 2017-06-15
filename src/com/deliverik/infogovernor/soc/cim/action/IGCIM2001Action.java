package com.deliverik.infogovernor.soc.cim.action;

import java.util.Date;
import java.util.Iterator;
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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM20011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �����豸�ǼǴ���ACTION
 *
 */
public class IGCIM2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2001Action.class);

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
				IGCIM2001Form form = (IGCIM2001Form)actionForm;
				
				//BLȡ��
				IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
				
				//DTO����
				IGCIM20DTO dto = new IGCIM20DTO();
				
				dto.setLocale(this.getLocale(req));
				
				//������ת�趨
				String forward = null;
		
				if( "DISP".equals(mapping.getParameter())){
					//�����豸�Ǽǻ��������ʾ����
					log.debug("========�����豸�Ǽǻ��������ʾ����ʼ========");
					form = new IGCIM2001Form();
					
					Date nowDateTime = new Date();
					String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
					
					form.setEiinsdate(date);

					dto.setIgcim2001Form(form);
					
					dto = ctlBL.searchEntityItemLableAction(dto);

					IGSYM03DTO sym03dto = new IGSYM03DTO();
					IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
					sym03dto = treeBL.getRoleDomainTree(sym03dto);
					Map<String,TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
					if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
						if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
								Iterator<String> it=treeNodeMap.keySet().iterator();
								while(it.hasNext()){
									Object obj = it.next();
									String key=(String)obj;	
									TreeNode treeNode=treeNodeMap.get(key);
									if(ResourceUtility.getString("XB_QB").equals(treeNode.getId())){
										req.setAttribute("deforgsys", treeNode.getId());
										req.setAttribute("deforgname", treeNode.getName());
										break;
									}
								}
								
						}
					}
					req.setAttribute("IGCIM2001Form", form);
					
					addMessage(req, new ActionMessage("IGCO10000.I001","�豸������Ϣ"));
					log.debug("========�����豸�Ǽǻ��������ʾ��������========");
					return mapping.findForward("DISP");
				}
				if( "INSERT".equals(mapping.getParameter())){
					//�豸�༭����
					if (form.getMode().equals("0")){
						//�豸�ǼǴ���
						log.debug("========�豸�ǼǴ���ʼ========");
						
						User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
						
						form.setEiuserid(user.getUserid());
						
						form.setEiusername(user.getUsername());
						
						//DTO��������趨
						dto.setIgcim2001Form(form);
						
						//�豸��Ϣ�Ǽ��߼�����
						dto = ctlBL.insertEntityItemAction(dto);
						
						//���Ǽ����˵��豸��Ϣ�趨��VO��
						IGCIM20011VO vo = new IGCIM20011VO(dto.getIgcim2001Form());
						
						super.<IGCIM20011VO>setVO(req.getSession(), vo);
						
						log.debug("========�����豸�ǼǴ�������========");
						
						forward = "DISP";

					}
				}
				
				if("RESULT".equals(mapping.getParameter())){
					if (req.getParameter("btn_add_conf")!=null) {
						//�豸������Ϣ��ӻ�����ת
						saveToken(req);
						log.debug("========������Ϣ���========");
						return mapping.findForward("CONF");
					}
					if (req.getParameter("btn_back")!=null) {
						//�豸������Ϣ��ӻ�����ת
						log.debug("========������Ϣ���========");
						return mapping.findForward("BACK");
					}
				}
		
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward("DISP");
	}
}
