/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.crc.bl.IGCRC22BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**	
 * ����:���������ȡͳ�Ƹ�ֵAction����
 * ���������� 
 * ������¼��ʷ����    2014-8-15 ����1:54:45	
 * �޸ļ�¼��
 *          
 */	
public class IGCRC2202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC2202Action.class);
	/**	
	 * ���ܣ��¼�����
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * �޸ļ�¼��
	 *          	
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================���������ȡͳ�Ƹ�ֵAction��ʼ=============");
		// Form���
		IGWKM0101Form form = (IGWKM0101Form) actionForm;
		//��ȡrequest�����ֵ
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		//��ȡ����syscoding
		String syscoding = request.getParameter("syscoding");
		//��ȡ�������ı�ʾ
		String flag = request.getParameter("flag");
		StringBuffer date = new StringBuffer();
		StringBuffer datemin = new StringBuffer();
		
		String str = "";
		
		//����ʱ���ѯ����
		if(year != null && !(month.equals("")) && month != null && !(month.equals(""))){
			date.append(year);
			date.append("/");
			date.append(month);
			date.append("/01");
			if( month.equals("12")){
				Integer demoyear = Integer.parseInt(year);
				demoyear = demoyear + 1;
				datemin.append(demoyear.toString());
				datemin.append("/01/01");
			}else{
				Integer demoMonth = Integer.parseInt(month);
				demoMonth = demoMonth + 1;
				month = demoMonth>9 ? demoMonth.toString():"0"+demoMonth.toString();
				datemin.append(year);
				datemin.append("/");
				datemin.append(month);
				datemin.append("/01");
			}
		}
		
		if ("DISP".equals(mapping.getParameter())) {
			//���ñ��������Ϣ
			String[] varnames = {"�������", "���ش���", "�Ƿ�Ӱ��ҵ��", "ҵ��Ӱ�췶Χ"};
			String[] varvalues = new String[4];
			//���ñ��Ķ�Ӧ��ֵ
			if(syscoding != null){
				varvalues[0] = syscoding;
			}
			if(flag.equals("1")){
				varvalues[1] = "0";				
			}
			form.setCustom("0");
			form.setPropentime(date.toString());
			form.setPrclosetime(datemin.toString());
			form.setPrstatus("C");
			form.setPrpdid("01084%");
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}else if("SEARCH".equals(mapping.getParameter())){
			//���ñ��������Ϣ
			String[] varnames = {"�������", "������", "�Ƿ�Ӱ��ҵ��", "ҵ��Ӱ�췶Χ"};
			String[] varvalues = new String[4];
			//���ñ��Ķ�Ӧֵ
			if(syscoding != null){
				varvalues[0] = syscoding;
			}
			//�жϱ������ǳɹ�����ʧ��
			if(flag.equals("1")){
				varvalues[1] = "�ɹ�";
			}else if(flag.equals("0")){
				varvalues[1] = "ʧ��";
			}
			form.setCustom("0");
			form.setPrstatus("C");
			form.setPropentime(date.toString());
			form.setPrclosetime(datemin.toString());
			form.setPrpdid("01084%");
			form.setVarnames(varnames);
			form.setVarvalues(varvalues);
		}
		log.debug("================���������ȡͳ�Ƹ�ֵAction����=============");
		return mapping.findForward("SEARCH");
		
	}
}
