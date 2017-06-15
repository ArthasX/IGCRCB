/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.action;


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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0103Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
/**
 * ����:��ض���Ǽ�Action
 * ����������1.��ض���Ǽ�
 * ������¼�����    2012/02/09
 */
public class IGMNT0103Action extends BaseAction{
	static Log log = LogFactory.getLog(IGMNT0103Action.class);

	/**
	 * ��ض���ǼǴ���
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//formȡ��
		IGMNT0103Form form=(IGMNT0103Form)actionForm;
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO����
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgmnt0103Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��ض���Ǽǳ�ʼ����ʼ===============");
			//��ȡ������ͼ���
			dto=ctlBL.searchMonitorTypeAction(dto);
			List<LabelValueBean> monitorTypeList = dto.getMonitorTypeList();
			req.getSession().setAttribute("monitorTypeList", monitorTypeList);
			String mtId = form.getMtId();
			if(StringUtils.isNotEmpty(mtId)){
				dto.setMtId(mtId);
				MonitorTypeInfo mt=ctlBL.searchMonitorTypeByPK(dto);
				String mtName = mt.getMtName();
				req.getSession().setAttribute("mtId", mtId);
				req.getSession().setAttribute("mtName", mtName);
			}
			saveToken(req);
			log.debug("==============��ض���Ǽǳ�ʼ������===============");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("==============��ض���Ǽǿ�ʼ===============");
			if (isTokenValid(req, true)){
				//��ض���Ǽ�
				dto = ctlBL.insertMonitorObject(dto);
				
				dto=ctlBL.searchCollect_Symmetrix_Info(dto);
				List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList = dto.getCollect_Symmetrix_InfoList();
				//���collect_Symmetrix_Info����û�иü�ض������ɱ���
				if(collect_Symmetrix_InfoList==null||collect_Symmetrix_InfoList.size()==0){
					dto.setMtId(form.getMtId());
					MonitorTypeInfo monitorType = ctlBL.searchMonitorTypeByPK(dto);
					String mtSyscoding = monitorType.getMtSyscoding();
					if(mtSyscoding.equals("002001")){//brocade������
						form.setSymm_type("Brocade");
					}
					if(mtSyscoding.equals("001003")){//CX
						form.setSymm_type("CX");
					}
					if(mtSyscoding.equals("001001")){//DMX
						form.setSymm_type("DMX");
					}
					if(mtSyscoding.equals("001002")){//IBM
						form.setSymm_type("IBM");
					}
					if(mtSyscoding.equals("002003")){//Mcdata
						form.setSymm_type("Mcdata");
					}
					if(mtSyscoding.equals("001004")){//Mcdata
						form.setSymm_type("HDS");
					}
					if(StringUtils.isNotEmpty(form.getSymm_type())){
						dto.setIgmnt0103Form(form);
						//�洢��Ϣ�Ǽ��߼�����
						dto = ctlBL.insertSymmInfoAction(dto);
						//�洢CodeDetail����Ϣ���
						dto=ctlBL.insertCodeDetailInfoAction(dto);
						//��ȡ�ô洢���͵ı���
						dto=ctlBL.searchCodeDetailListActioin(dto);
						List<CodeDetail> codeDetailList=dto.getCodeDetailList();
						if(codeDetailList!=null&&codeDetailList.size()>0){
							for(CodeDetail codeDetailInfo:codeDetailList){
								dto.setCodeDetailInfo(codeDetailInfo);
								//�����Զ�����ʱ
								if("1".equals(codeDetailInfo.getCdinfo())){
									dto=ctlBL.registSOC0203Action(dto);
								}
								if("1".equals(codeDetailInfo.getCdinfo())||"0".equals(codeDetailInfo.getCdinfo())){
								//������ͨ����ʱ
									dto=ctlBL.registReportFileDefinitionAction(dto);
								}
							}
						}
					}
				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("==============��ض���Ǽǽ���===============");
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
