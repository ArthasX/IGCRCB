package com.deliverik.infogovernor.crc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.crc.form.IGCRC3001Form;

/**
 * Զ�̷���Ƽ������������� �ϴ������ͱ�ֵ��ת�����̴�����ҳ��
 */
public class IGCRC3001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC3001Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGCRC3001Form form = (IGCRC3001Form) actionForm;
//		form.setPlatformuserid("000124");
//		form.setTitle("ϵͳ��ȫ���߼�鲻�Ϲ�����");
//		form.setDesc("linux_node116��,Windows_wx");
//		form.setTree("114006003_tree_��ȫ����-��ȫ���߼����");
//		form.setType1("��");
//		form.setType2("��");
//		form.setType3("��");
		//����key
		String attkey = "";
		//����id
		StringBuffer attstr = new StringBuffer("");
		if("DISP".equals(mapping.getParameter())){
			
			if(form.getFileMap() != null && form.getFileMap().size() > 0){
				
				FileUploadBL fileUploadBL = (FileUploadBL) getBean("fileUploadBL");
				AttachmentBL attachmentBL = (AttachmentBL) getBean("attachmentBL");
				
				//��ȡ�ϴ�֮���key
				attkey = fileUploadBL.uploadFile(form.getFileMap());
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(attkey);
				if(attachmentList != null && attachmentList.size() > 0){
					//����id
					for (int i = 0; i < attachmentList.size(); i++) {
						if(i != attachmentList.size() - 1){
							attstr.append(attachmentList.get(i).getAttid());
							attstr.append("*_*");
						}else{
							attstr.append(attachmentList.get(i).getAttid());
						}
						
					}
					attstr.append("*-*");
					//��������
					for (int i = 0; i < attachmentList.size(); i++) {
						if(i != attachmentList.size() - 1){
							attstr.append(attachmentList.get(i).getAttname().split(attachmentList.get(i).getAttkey()+"_")[1]);
							attstr.append("*_*");
						}else{
							attstr.append(attachmentList.get(i).getAttname().split(attachmentList.get(i).getAttkey()+"_")[1]);
						}
						
					}
				}
				
			}
			
			//�û�id
			request.setAttribute("platformuserid", form.getPlatformuserid());
			//������������
			request.setAttribute("ptitle", form.getTitle());
			//������������
			request.setAttribute("pdesc", form.getDesc());
			//�����������
			request.setAttribute("tree", form.getTree());
			//�Ƿ�Ϊ�������ݵ�������
			request.setAttribute("type1", form.getType1());
			//Ӱ��̶�
			request.setAttribute("type2", form.getType2());
			//�����̶�
			request.setAttribute("type3", form.getType3());
			//����key
			request.setAttribute("attkey", attkey);
			//������ʾ�Ĵ�
			request.setAttribute("attstr", attstr.toString());
			
			//��ȡ��Ŀ·��
			String requestURL = request.getRequestURL().toString();
			String path = requestURL.replace("/IGCRC3001.do", "");
			//����·��
			request.setAttribute("path", path);
			
			return mapping.findForward("SUCCESS");
		}else{
			return mapping.findForward("DISP");
		}
	}

}
