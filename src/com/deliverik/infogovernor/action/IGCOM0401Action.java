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
import com.deliverik.infogovernor.form.IGCOM0401Form;
import com.deliverik.infogovernor.prm.bl.IGPRMCONSTANTS;

/**
 * @Description: ���̿�ݷ���Action����
 * @Author
 * @History 
 * @Version
 */
public class IGCOM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0401Action.class);

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
		//Session���
		clearSessionFormData(req);
		log.debug("========���̿�ݷ�����ʼ ========");

		IGCOM0401Form form = (IGCOM0401Form) actionForm;
		if(StringUtils.isEmpty(form.getPrtype())) {
			throw new BLException("IGCO10000.E004","�ɷ�����������");
		} else {
			
			//�Զ��幤�������⣬�������url
			if(form.getPtid().equals("8") || form.getPtid().equals("10") ||form.getPtid().equals("11")){
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_SF_W");
				StringBuilder url = new StringBuilder((String) type.get(IGPRMCONSTANTS.class));
				url.append("?psdcode=Z&isServiceStart=C&parprid=").append(
				        form.getParprid()).append("&pdid=").append(
                        form.getPrpdid()).append("&ptid=").append(
                        form.getPtid()).append("&parameters=").append(
                        form.getParameters());
				if(form!=null && form.getPjdtype()!=null && !(form.getPjdtype().equals(""))){
					url.append("&pjdtype=").append(form.getPjdtype());
				}
				form.setUrl(url.toString());
			}else if(form.getPtid().equals("7")){
				Field type=null;
				StringBuilder url=null;
				if("IGSDL0110_SOC".equals(form.getPath())){
					type = IGPRMCONSTANTS.class.getDeclaredField("SOC_PROCESS_INIT_0110");
					url = new StringBuilder((String) type.get(IGPRMCONSTANTS.class));
					form.setUrl(url.append("?date=").append(form.getDate()).toString());
				}else if("IGMTP0103_Disp_SOC".equals(form.getPath())){
					type = IGPRMCONSTANTS.class.getDeclaredField("SOC_PROCESS_INIT_0103");
					url = new StringBuilder((String) type.get(IGPRMCONSTANTS.class));
					form.setUrl(url.append("?date=").append(form.getDate()).toString());
				}else{
					type = IGPRMCONSTANTS.class.getDeclaredField("SOC_PROCESS_INIT_PAGE");
					url = new StringBuilder((String) type.get(IGPRMCONSTANTS.class));
					form.setUrl(url.append("?prpdid=").append(form.getPrpdid()).append("&flag=").append(form.getFlag()).toString());
				}
			}else{
				//��ȡ��ݷ���ҳ��URL
				Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_INIT_PAGE_" + form.getPrtype());
				StringBuilder url = new StringBuilder((String) type.get(IGPRMCONSTANTS.class));
				form.setUrl(url.append("?isServiceStart=C&parprid=").append(
                        form.getParprid()).append("&prpdid=").append(
                        form.getPrpdid()).append("&flag=").append(
                        form.getFlag()).append("&parameters=").append(
                        form.getParameters()).toString());
			}
		}
		
		log.debug("========���̿�ݷ���������========");
		return mapping.findForward("DISP");
	}
}
