
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.action;

import java.util.ArrayList;
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
import com.deliverik.infogovernor.prr.bl.IGPRR06BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;

/**
 * @Description: ���̴���Action
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2012-3-29	  �޸�	process00003�� ѡ��ִ�����Ƚ��и��´���
 * @Version V1.0
 */
public class IGPRR0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0105Action.class);

	/**
	 * ���̴���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//��ܱ����ã����÷������ʵ��ID
		req.setAttribute("instanceID", req.getParameter("instanceID"));
		//FORMȡ��
		IGPRR0102Form form = (IGPRR0102Form)actionForm;
		//BLȡ��
		IGPRR06BL ctlBL = (IGPRR06BL) getBean("igPRR06BL");
		String forward = "DISP";
		IGPRR01021VO vo = new IGPRR01021VO();
		//DTO����
		IGPRR01DTO dto = new IGPRR01DTO();
		Integer	prid = Integer.parseInt(req.getParameter("prid"));
		if(prid==null || prid==0){
			
			dto = ctlBL.searchAll(dto);
		}else{
			dto.setPrid(prid);
			dto = ctlBL.search(dto);
		}
		
		
		vo.setListMap(dto.getListMap());
		vo.setListPointVMs(dto.getListPointVMs());
		vo.setCheckItemVWs(dto.getCheckItemVWs());
		super.<IGPRR01021VO>setVO(req.getSession(), vo);
		//��ת������JSP
		if(!"DISP".equals(forward) && !"ASSIGN".equals(forward) && !"EXECUTOR".equals(forward)){ 
			return mapping.findForward("DISP");
		} else {
			if(!"DISP".equals(mapping.getParameter()) && "DISP".equals(forward)){
				//act��ʾ���ָ����˵�����,prstatus=��Ϊ���������һ���ύʱ��ֵ
				String url = "/IGPRR0102_Disp.do?act=0&prstatus=&prid=" + form.getPrid() + "&jump=" + form.getJump();
				req.getSession().removeAttribute("AD_columnInfoMap");
				req.getSession().removeAttribute("ADroleList");
				req.getSession().removeAttribute("ADlst_status");
				req.getSession().removeAttribute("AD_tableColumnValueMap");
				req.getSession().removeAttribute("IGPRR01021VO");
				return new ActionForward(url);
			}
			return mapping.findForward(forward);
		}
	}
	
	/**
	 * ����¼�û�ID����
	 */
	private List<LabelValueBean> sortLabel(List<LabelValueBean> lst_Label, String userid) {
		if(lst_Label == null) return null;
		List<LabelValueBean> lst_ValueBeans1 = new ArrayList<LabelValueBean>();
		List<LabelValueBean> lst_ValueBeans2 = new ArrayList<LabelValueBean>();
		for(LabelValueBean label : lst_Label) {
			//ƥ��userid,���Ҳ��ǹ���Ա
			if(userid.equals(label.getValue().split("_")[2]) && !"0".equals(label.getValue().split("_")[0])) {
				lst_ValueBeans1.add(label);
			} else {
				lst_ValueBeans2.add(label);
			}
		}
		lst_ValueBeans1.addAll(lst_ValueBeans2);
		return lst_ValueBeans1;
	}
}