package com.deliverik.infogovernor.asset.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1104Form;
import com.deliverik.infogovernor.asset.vo.IGASM11041VO;

/**
 * ����ƽ��ͼ����Action����
 *
 */
public class IGASM1104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1104Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		/** ��ȡSystemConfigResources��Ϣ��Դ�ļ� */
		MessageResources resources = MessageResources.getMessageResources("SystemConfigResources");
		//��ȡTabҳ��ʾ��ʶ
		String tab = resources.getMessage("TAB_FLAG");
		String[] tab_flag = tab.split(",");
		for(String flag : tab_flag){
			String name = flag.split("_")[0];
			String isBool = flag.split("_")[1];
			if(name.equals("Env")){
				req.setAttribute("Env_Flag", isBool);
			}
		}
		//FORMȡ��
		IGASM1104Form form = (IGASM1104Form)actionForm;

		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����ƽ��ͼ���������ʾ����
			log.debug("========����ƽ��ͼ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1104Form(form);
			
			//���������߼�����
			dto = ctlBL.initIGASM1104Action(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11041VO vo = new IGASM11041VO(dto.getComputerRoomVWInfo(),
					dto.getComputerContainerVWInfoList());
			
			super.<IGASM11041VO>setVO(req, vo);
			
			log.debug("========����ƽ��ͼ���������ʾ��������========");
		}
		
		//FLEX�汾ƽ��ͼ�߼�
		if( "FLEX".equals(mapping.getParameter())){
			//����ƽ��ͼ���������ʾ����
			log.debug("========����ƽ��ͼ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1104Form(form);
			
			//���������߼�����
			dto = ctlBL.initIGASM1104Action(dto);
			
			//��ѯ���ϼܵĻ�����Ϣ������װ��XML�ļ�
			dto = ctlBL.getJiguiXml(dto);
			
			//��ѯδ�ϼܵĻ�����Ϣ������װ��XML�ļ�
			dto = ctlBL.getToolsXml(dto);
			
			//��ѯͼ����Ϣ������װ��XML�ļ�
			dto = ctlBL.getLegendXml(dto);
			
//			//��ѯδ�ϼܵĻ�����Ϣ������װ��XML�ļ�
//			dto = ctlBL.getGuodaoXml(dto);
			
			//��ѯ��Ч������Ϣ������װ��XML�ļ�
			dto = ctlBL.getWuXiaoXml(dto);
			
			//��ѯδ�ϼܵĻ�����Ϣ������װ��XML�ļ�
			dto = ctlBL.getRelateRoomXml(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM11041VO vo = new IGASM11041VO();
			vo.setComputerContainerVWInfoList(dto.getComputerContainerVWInfoList());
			vo.setComputerRoomVWInfo(dto.getComputerRoomVWInfo());
			vo.setJiguiXml(dto.getJiguiXml());
			vo.setToolsXml(dto.getToolsXml());
			//vo.setGuodaoXML(dto.getGuodaoXML());
			vo.setLegendXML(dto.getLegendXML());
			vo.setWuxiaoXML(dto.getWuxiaoXML());
			vo.setRelateRoomXML(dto.getRelateRoomXML());
			super.<IGASM11041VO>setVO(req, vo);
			
			log.debug("========����ƽ��ͼ���������ʾ��������========");
		}

		if( "MOVE".equals(mapping.getParameter())){
			//�����Ƴ�����
			log.debug("========�����Ƴ�����ʼ========");
			
			//DTO��������趨
			dto.setIgasm1104Form(form);
			
			//�����Ƴ��߼�����
			dto = ctlBL.moveoutComputerContainerAction(dto);
			
			log.debug("========�����Ƴ���������========");
		}

		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		if( "INITAPP".equals(mapping.getParameter())){
			//�����Ƴ�����
			log.debug("========��ʼ���ذ忪ʼ========");
			
			String roomID = req.getParameter("roomID");
			if(roomID!=null){
				
				String IMG_PATH = ResourceUtility.getString("DATA_CENTER_IMG_PATH")+"jifang"+roomID+".swf";
				
			 	BufferedOutputStream bos = null;   
			    BufferedInputStream bis = null;   
			    try {   
			        bis = new BufferedInputStream(new FileInputStream(IMG_PATH));             
			        bos = new BufferedOutputStream(res.getOutputStream());   
			           
			        byte[] buff = new byte[2048];   
			        int bytesRead;   
	
			        while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {   
			        bos.write(buff,0,bytesRead);   
			        }   
			    } catch(final IOException e) {   
			        e.printStackTrace();   
			    } catch(Exception e) {   
			        e.printStackTrace();   
			    }finally {   
			        if (bis != null)   
			        bis.close();   
			        if (bos != null)   
			        {   
			        bos.flush();   
			        bos.close();   
			        bos=null;   
			        }   
			    }   
			    res.flushBuffer();   
			}
			log.debug("========��ʼ���ذ�����========");
			return null;
		}
		return mapping.findForward("DISP");
	}
}
