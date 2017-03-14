/* ��������������������޹�˾��Ȩ���У���������Ȩ����*/

package com.deliverik.plugin.PluginMgr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.plugin.PluginMgr.bl.IGPluginMgrBLImpl;
import com.deliverik.plugin.PluginMgr.dto.IGPluginDTO;
import com.deliverik.plugin.PluginMgr.vo.IGPluginMgrVO;

/**
 * ����: �澯��Ϣ����ҳ��Action����
 * ��������: �澯��Ϣ����ҳ��Action����
 * ������¼: 2012/10/12
 * �޸ļ�¼: 
 */
public class IGPluginMgrAction extends BaseAction{
	static Log log=LogFactory.getLog(IGPluginMgrAction.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IGPluginMgrBLImpl igpmbl =new IGPluginMgrBLImpl();
		IGPluginDTO dto=new IGPluginDTO();
		//��ѯ��ʾ
		if("DISP".equals(mapping.getParameter())){
		log.debug("========Plugin�����������ʾ����ʼ========");
			igpmbl.getPluginList(dto);
			dto.getPluginList();
			IGPluginMgrVO vo=new IGPluginMgrVO();
			vo.setPluginList(dto.getPluginList());
			super.<IGPluginMgrVO>setVO(req, vo);
			log.debug("========Plugin�����������ʾ��������========");
		}
		//�޸�״̬
		if("MODIFY".equals(mapping.getParameter())){
			log.debug("========Plugin����״̬�޸Ĵ���ʼ========");
			dto.setPath(req.getParameter("pluginPath"));
			dto.setStatus(req.getParameter("pluginStatus"));
			dto=igpmbl.modifyPlugin(dto);
			log.debug("========Plugin����״̬�޸Ĵ�������========");
		}
		//��������
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========Plugin������´���ʼ========");
			dto.setPath(req.getParameter("pluginPath"));
			dto.setStatus(req.getParameter("pluginStatus"));
			dto=igpmbl.updatePluginDataXml(dto);
			log.debug("========Plugin������´�������========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}