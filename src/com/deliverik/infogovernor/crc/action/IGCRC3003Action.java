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
import com.deliverik.infogovernor.crc.form.IGCRC3003Form;

/**
 * Զ�̷��������� �ϴ������ͱ�ֵ��ת�����̴�����ҳ��
 */
public class IGCRC3003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC3003Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		IGCRC3003Form form = (IGCRC3003Form) actionForm;
//		form.setPlatformuserid("000124");
//		form.setTitle("����������");
//		form.setDesc("����");
//		/** �ƻ�ִ�п�ʼʱ�� */
//		form.setBegintime("2016/03/30 15:46");
//		/** ������� */
//		form.setTree("110003_tree_��Ŀ��");
//		/** ������ */
//		form.setType1("������");
//		/** ������� */
//		form.setType2("��������");
//		/** ����ƽ̨ */
//		form.setType3("����");
//		/** ���ԭ����� */
//		form.setType4("����");
//		/** ���ԭ�� */
//		form.setText1("���Ա��ԭ��");
//		/** ������� */
//		form.setText2("���Ա������");
//		/** �Ƿ�Ӱ��ҵ�� */
//		form.setType5("��");;
//		/** ִ�мƻ� */
//		form.setText3("����ִ�мƻ�");
//		/** ���˼ƻ� */
//		form.setText4("���Ի��˼ƻ�");
//		/** ��֤�ƻ� */
//		form.setText5("������֤�ƻ�");
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
			//�ƻ�ִ�п�ʼʱ�� 
			request.setAttribute("begintime", form.getBegintime());
			// �������
			request.setAttribute("tree", form.getTree());
			//������ 
			request.setAttribute("type1", form.getType1());
			//������� 
			request.setAttribute("type2", form.getType2());
			//����ƽ̨ 
			request.setAttribute("type3", form.getType3());
			//���ԭ����� 
			request.setAttribute("type4", form.getType4());
			//���ԭ�� 
			request.setAttribute("text1", form.getText1());
			//������� 
			request.setAttribute("text2", form.getText2());
			//�Ƿ�Ӱ��ҵ�� 
			request.setAttribute("type5", form.getType5());
			//ִ�мƻ� 
			request.setAttribute("text3", form.getText3());
			//���˼ƻ� 
			request.setAttribute("text4", form.getText4());
			//��֤�ƻ� 
			request.setAttribute("text5", form.getText5());
			
			//����key
			request.setAttribute("attkey", attkey);
			//������ʾ�Ĵ�
			request.setAttribute("attstr", attstr.toString());
			
			//��ȡ��Ŀ·��
			String requestURL = request.getRequestURL().toString();
			String path = requestURL.replace("/IGCRC3003.do", "");
			//����·��
			request.setAttribute("path", path);
			
			return mapping.findForward("SUCCESS");
		}else{
			return mapping.findForward("DISP");
		}
	}

}
