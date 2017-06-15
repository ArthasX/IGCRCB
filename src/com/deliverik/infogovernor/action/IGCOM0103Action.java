/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.vo.IGCOM01031VO;
import com.deliverik.plugin.sms.SMSThread;

/**
 * @Description: �쵼��¼����Action����
 * @Author  ZhaoJun
 * @History 2010-6-8     �½�
 * @Version V2.0
 */
public class IGCOM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String Forward = "SUCCESS";
		if("CHANGE".equals(mapping.getParameter())){
			//������ҳ
			Forward =  "IGCOM0403";
		} 

		// Session���
		clearSessionFormData(req);
		IGCOM0201Form form = (IGCOM0201Form) actionForm;
		setLinkID(req, form.getLinkID());
		// ���'��ҳ'��ת��

		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		IGCOM01DTO dto = new IGCOM01DTO();
		dto.setIgcom0201Form(form);
		dto.setUser(user);
		
		IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
		
		dto = ctrlBl.getUserRoles(dto);
		List<UserRoleInfo> userRoleInfoList = dto.getUserRoleInfoList();
		for (UserRoleInfo userRoleInfo : userRoleInfoList) {
			String roletype = userRoleInfo.getRoletype();
			//�жϵ�ǰ�û��Ƿ���֪ʶ������ɫ
			if("IGKG02".equals(roletype)){
				req.setAttribute("roleType", "IGKG02");
				break;
			}
		}

		dto = ctrlBl.getProcessInHand(dto); // �ҵĹ�����ع���
		dto = ctrlBl.getKnowledge(dto); // ֪ʶ
		dto = ctrlBl.getNotice(dto); // ֪ͨ
		dto = ctrlBl.getDaysPlans(dto); // �ճ��ƻ�
		dto = ctrlBl.getRiskCheckResultGoup(dto);	//��ҳ��鹤����ѯ
//		dto = ctrlBl.searchHQAlertListDetailVWAction(dto); // hq�澯
//		dto = ctrlBl.searchBussinessAvailvalVWAction(dto); // ҵ��ϵͳ������
//		dto = ctrlBl.searchOracleAlertAction(dto); // Oracle�澯

		IGCOM01031VO vo = new IGCOM01031VO();
		vo.setProcessInHandAsc(dto.getPihListAsc()); // �ҵĹ�������
		vo.setProcessInHandDesc(dto.getPihListDesc()); // �ҵĹ�������
		vo.setProcessInHandGroupDesc(dto.getPihGroupListDesc()); // ��ع�������
		vo.setProcessInHandGroupAsc(dto.getPihGroupListAsc()); // ��ع�������
		vo.setProcessInHandDiscontinueDesc(dto.getProcessInHandDiscontinueDesc());//��ֹ��������
		vo.setProcessInHandDiscontinueAsc(dto.getProcessInHandDiscontinueAsc());//��ֹ��������
		vo.setKnvoList(dto.getKnvoList()); // ����֪ʶ
		vo.setAppKnList(dto.getAppKnList());//������֪ʶ
		vo.setNoticeList(dto.getNoticeList()); // ֪ͨ
		vo.setDayplans(dto.getRiliString()); // �ճ��ƻ�
		vo.setLst_RiskCheckResult_Asc(dto.getLst_RiskCheckResult_Asc());//���˼�鹤������
		vo.setLst_RiskCheckResult_Desc(dto.getLst_RiskCheckResult_Desc());//���˼�鹤������
		vo.setLst_RiskCheckResultGroup_Asc(dto.getLst_RiskCheckResultGroup_Asc());//��ؼ�鹤������
		vo.setLst_RiskCheckResultGroup_Desc(dto.getLst_RiskCheckResultGroup_Desc());//��ؼ�鹤������
		vo.setRiskChecktime(IGStringUtils.getCurrentDateTime());//��ȡϵͳ��ǰʱ��
//		vo.setHqAlertListDetailVWList(dto.getHqAlertListDetailVWList()); // �澯
//		vo.setLst_BussinessAvailval(dto.getLst_BussinessAvailval()); // ҵ��ϵͳ������
		vo.setLst_CRM06Info(dto.getLst_CRM06Info()); // Oracle�澯
		
		vo.setYear(form.getYear());
		vo.setMonth(form.getMonth());
		req.getSession().setAttribute("AD_SMSSTATUS_REQUEST", SMSThread.isSmsOpen());
		
		super.<IGCOM01031VO> setVO(req, vo);
		return mapping.findForward(Forward);
	}

}