/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3116Form;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.vo.IGASM31071VO;

/**
 * @Description: ����չʾ���ݲ�ѯ
 * @Author       zhangqiang
 * @History      @2014-7-26�½� 
 * 			
 * @Version V1.0
 */
public class IGASM3116Action extends BaseAction {

	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGASM3116Form form = (IGASM3116Form) actionForm;
		//BLȡ��
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		//ʵ����DTO
		IGASM31DTO dto = new IGASM31DTO();
		//��ȡ��ǰʱ��
		Calendar calendar = Calendar.getInstance();
		
		//��ʼ��ҳ��ʱ��(����) 
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			//�·������1λʱ��ȫ2λ
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		//�趨form
		dto.setIgasm3116form(form);
		if("DISP".equals(mapping.getParameter())){
			//����control��ѯ
			ctlBL.searchRiskIndexContext(dto);
			//��ȡ��һ��ֵ Ĭ����ʾ
			RiskIndexContextVWInfo ricvw = dto.getSearchRiskIndexContextVW().get(0);
			form.setEiid(ricvw.getEiid().toString());
			form.setRimid(ricvw.getRimid().toString());
			dto.setIgasm3116form(form);
			//����controlͳ��ͼ��ѯ
			ctlBL.searchRiskIndexByRiid(dto);
			
			//����ָ��������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM3116Action(dto);

			IGASM31071VO vo = new IGASM31071VO();
			req.getSession().setAttribute("IGASM3116Form", dto.getIgasm3116form());
			vo.setSearchRiskIndexContextVW(dto.getSearchRiskIndexContextVW());
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			super.<IGASM31071VO>setVO(req, vo);
		}else if("SEARCH".equals(mapping.getParameter())){
			//����controlͳ��ͼ��ѯ
			ctlBL.searchRiskIndexByRiid(dto);
			
			//����ָ��������Ϣ�Ǽǻ��������ʾ�߼�����
			dto = ctlBL.initIGASM3116Action(dto);
			
			//ʵ����vo
			IGASM31071VO vo = new IGASM31071VO();
			req.getSession().setAttribute("IGASM3116Form", dto.getIgasm3116form());
			vo.setSearchRiskIndexContextVW(dto.getSearchRiskIndexContextVW());
			//
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			super.<IGASM31071VO>setVO(req, vo);
		}
			
	
		return mapping.findForward("DISP");
	}

}
