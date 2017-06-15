/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08011VO;
import com.deliverik.infogovernor.xls.smr.bl.IGSMR0801ExcelBL;
import com.deliverik.infogovernor.xls.smr.bl.IGSMR0802ExcelBL;
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0801ExcelDTO;
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0802ExcelDTO;

/**
 * ����:����� 
 * ��������������� 
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
public class IGSMR0801Action extends BaseAction {
	
	 /** ���������˵���ģ���ʶ */
    private static final String IG_SMR_MODE1 = "SMR0801G";
    
	 /** ����Ա���˵���ģ���ʶ */
    private static final String IG_SMR_MODE2 = "SMR0801U";
	
	static Log log = LogFactory.getLog(IGSMR0801Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGSMR0801Form form = (IGSMR0801Form)actionForm;
						
		//BLȡ��
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
						
		//DTO����
		IGSMR08DTO dto = new IGSMR08DTO();
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("����˳�ʼ����ʼ��");
			
			log.debug("����˳�ʼ��������");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("����˴���ʼ��");
			//��form�Ž�dto��
			dto.setIgsmr0801Form(form);
			//ʵ����vo
			IGSMR08011VO vo = new IGSMR08011VO();
			//�ж�form�����͵�ֵ�������1����������ѯ�������2 ����Ա��ѯ
			if("1".equals(form.getAssesstype())){
				dto = ctlBL.initSMR0801ByOrgAction(dto);				
				vo.setList(dto.getList());
				vo.setOrgsum(dto.getOrgsum());
			}
			if("2".equals(form.getAssesstype())){
				dto = ctlBL.initSMR0801ByUserAction(dto);
				vo.setMap(dto.getMap());
				vo.setUsersum(dto.getUsersum());
			}
			super.<IGSMR08011VO>setVO(req, vo);
			forward = "SEARCH";
			log.debug("����˴��������");
		}
       
        if("EXPORT".equals(mapping.getParameter())){
        	log.debug("����˰��������˵�����ʼ��");
            //��form��������ݷŽ�dto��
        	dto.setIgsmr0801Form(form);			
			//�ж�form�����͵�ֵ�������1����������ѯ�������2 ����Ա��ѯ
			if("1".equals(form.getAssesstype())){
				IGSMR0801ExcelDTO excelDTO = new IGSMR0801ExcelDTO(); 
				//������ʱ��Ž�dto��
				excelDTO.setAssessstartdate(form.getAssessstartdate());
				excelDTO.setAssessoverdate(form.getAssessoverdate());
				//����BL������������ѯ����dto
				dto = ctlBL.initSMR0801ByOrgAction(dto);
				  //����ѯ����Ž�dto��
				excelDTO.setList(dto.getList());
				excelDTO.setOrgsum(dto.getOrgsum());          
	            // ���������
	            excelDTO.setResponse(res);
	            // ����ģ���ʶ
	            excelDTO.setFileid(IG_SMR_MODE1); 
	            // ����������
	            IGSMR0801ExcelBL excelBL = (IGSMR0801ExcelBL) getBean("igsmr0801ExcelBL");
	            excelBL.initExcel(excelDTO);
			}
            if("2".equals(form.getAssesstype())){
            	//����BL������������ѯ����dto
    			dto = ctlBL.initSMR0801ByUserAction(dto);
    			IGSMR0802ExcelDTO excelDTO = new IGSMR0802ExcelDTO();  
    			//������ʱ��Ž�dto��
    			excelDTO.setAssessstartdate(form.getAssessstartdate());
    			excelDTO.setAssessoverdate(form.getAssessoverdate());
    			 //����ѯ����Ž�dto��
    			excelDTO.setMap(dto.getMap());
    			excelDTO.setUsersum(dto.getUsersum());          
                // ���������
                excelDTO.setResponse(res);
                // ����ģ���ʶ
                excelDTO.setFileid(IG_SMR_MODE2);          
                // ����������
                IGSMR0802ExcelBL excelBL = (IGSMR0802ExcelBL) getBean("igsmr0802ExcelBL");
                excelBL.initExcel(excelDTO);
            }                    
            log.debug("����˵���������");
            return null;        	
        }
		return mapping.findForward(forward);
	}

}
