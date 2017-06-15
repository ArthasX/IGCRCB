package com.deliverik.infogovernor.risk.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0602Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06021VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06071VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �����༭����Action����
 *
 * @author
 */
public class IGRIS0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0602Action.class);

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
		IGRIS0602Form form = (IGRIS0602Form)actionForm;
		//BLȡ��
		IGRIS06BL ctlBL = (IGRIS06BL) getBean("igris06BL");
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
				labelAndValueList.add(new IGRIS06022VO(subTreeNode.getName(),subTreeNode.getId()));
			}
		}
		//���浽request
		req.setAttribute("labelAndValueList", labelAndValueList);
		//DTO����
		IGRIS06DTO dto = new IGRIS06DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�����Ǽǻ��������ʾ����
			log.debug("========�����Ǽǻ��������ʾ����ʼ========");
			form = new IGRIS0602Form();
			//��form �����û�
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setIgris0602Form(form);
			
			//��ȡ���
			dto = ctlBL.searchEntityItemLableAction(dto);
			
			req.setAttribute("IGRIS0602Form", form);
			saveToken(req);
			IGRIS06071VO vo = new IGRIS06071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			vo.setSoc0109List(dto.getSoc0109List());
			super.setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","����������Ϣ"));
			log.debug("========�����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�����Ǽǻ�������ʾ����
			log.debug("========�����Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�����Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		
		if( "INSERT".equals(mapping.getParameter())){
			//�����༭����
			if (form.getMode().equals("0")){
				//�����ǼǴ���
				log.debug("========�����ǼǴ���ʼ========");

				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[1]);
				form.setEimethod(form.getCivalue()[2]);
				//�Ǽ�ʱ��
				form.setEiinsdate(form.getCivalue()[5]);
				
				dto.setAttachFile(form);//����form
				//DTO��������趨
				dto.setIgris0602Form(form);
				if (isTokenValid(req, true)) {
					
					//�������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemAction(dto);
					
					//���Ǽ����˵ļ������Ϣ�趨��VO��
					IGRIS06021VO vo = new IGRIS06021VO(dto.getIgris0602Form());
					//���
					req.getSession().setAttribute("eilabel", dto.getIgris0602Form().getEilabel());
					//�����ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGRIS06021VO>setVO(req.getSession(), vo);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				
				log.debug("========�����ǼǴ�������========");
				
				forward = "DISP";

			}
		}else if( "INSERTWINDOW".equals(mapping.getParameter())){
			//�����༭����
//			PrintWriter out = null;
//			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
			if (form.getMode().equals("0")){
				//�����ǼǴ���
				log.debug("========�����ǼǴ���ʼ========");

				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[1]);
				form.setEimethod(form.getCivalue()[2]);
				
				dto.setAttachFile(form);//����form
				//DTO��������趨
				dto.setIgris0602Form(form);
				if (isTokenValid(req, true)) {
					
					//�������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemAction(dto);
					//���Ǽ����˵ļ������Ϣ�趨��VO��
					IGRIS06021VO vo = new IGRIS06021VO(dto.getIgris0602Form());
//					String ret = form.getEiid()+","+ form.getEiversion()+"," + form.getEiname();
//					out.print(ret);
					//���
					req.getSession().setAttribute("eiidWindow", dto.getEiid());
					
					super.<IGRIS06021VO>setVO(req.getSession(), vo);
			
					PrintWriter out = null;
					try {
						out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
							StringBuffer text = new StringBuffer();
							String classType = "";
							if(dto.getIgris0602Form().getCivalue()[4].equals("999021001")){
								classType = "����";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021002")){
								classType = "����";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021003")){
								classType = "ϵͳ";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021004")){
								classType = "���氲ȫ";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021005")){
								classType = "���ʿ���";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021006")){
								classType = "����";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021007")){
								classType = "����";
							}
							
							text.append(dto.getEiid())
								.append("_").append(dto.getIgris0602Form().getEiname())
								.append("_").append(dto.getIgris0602Form().getEidesc())
								.append("_").append(dto.getIgris0602Form().getEimethod())
								.append("_").append(classType);
						out.print(text.toString());
					} catch (Exception e) {
						out.print("");
						e.printStackTrace();
						addMessage(req, new ActionMessage("IGCO10000.E130",e.getMessage()));
					} finally{
						out.close();
					}
					
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}				
				log.debug("========�����ǼǴ�������========");
				return null;
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
