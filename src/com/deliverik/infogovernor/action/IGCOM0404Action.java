/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.action;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.form.IGCOM0404Form;
import com.deliverik.infogovernor.prm.bl.IGPRMCONSTANTS;

/**
 * @Description: ���񹤵���ݷ�������Action����
 * @Author masai
 * @History 
 * @Version 1.0
 */
public class IGCOM0404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0404Action.class);

	/**
	 * �¼�����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		log.debug("========���̿�ݷ�����ʼ ========");
		
		//Session���
		clearSessionFormData(req);
		
		IGCOM0404Form form = (IGCOM0404Form) actionForm;
		
		if(StringUtils.isEmpty(form.getPrtype())) {
			
			throw new BLException("IGCO10000.E004","�ɷ�����������");
			
		} else {
			
			//�Զ����¼�����url
			if(form.getPtid().equals("9") || form.getPtid().equals("10") || form.getPtid().equals("11") || form.getPtid().equals("12") || form.getPtid().equals("13")){
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_SF_W");
				String url = (String) type.get(IGPRMCONSTANTS.class);
				form.setUrl(url + "?psdcode=Z&isServiceStart=S&parprid="+form.getParprid()+"&pdid=" + form.getPrpdid() + "&ptid=" + form.getPtid());
			}else{
				//��ȡ��ݷ���ҳ��URL if ���񹤵���ݷ�������
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_SF_" + form.getPrtype());
				String url = (String) type.get(IGPRMCONSTANTS.class);
				form.setUrl(url + "?isServiceStart=S&parprid=" + form.getParprid() + "&prpdid=" + form.getPrpdid() + "&flag=" + form.getFlag());
			}
		
		}
		
		log.debug("========���̿�ݷ���������========");
		
		return mapping.findForward("DISP");
		
	}
}
