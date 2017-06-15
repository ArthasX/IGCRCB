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
 * 机房平面图画面Action处理
 *
 */
public class IGASM1104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1104Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		/** 读取SystemConfigResources消息资源文件 */
		MessageResources resources = MessageResources.getMessageResources("SystemConfigResources");
		//获取Tab页显示标识
		String tab = resources.getMessage("TAB_FLAG");
		String[] tab_flag = tab.split(",");
		for(String flag : tab_flag){
			String name = flag.split("_")[0];
			String isBool = flag.split("_")[1];
			if(name.equals("Env")){
				req.setAttribute("Env_Flag", isBool);
			}
		}
		//FORM取得
		IGASM1104Form form = (IGASM1104Form)actionForm;

		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//机房平面图画面初期显示处理
			log.debug("========机房平面图画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm1104Form(form);
			
			//机房检索逻辑调用
			dto = ctlBL.initIGASM1104Action(dto);
			
			//将机房信息检索结果设定到VO中
			IGASM11041VO vo = new IGASM11041VO(dto.getComputerRoomVWInfo(),
					dto.getComputerContainerVWInfoList());
			
			super.<IGASM11041VO>setVO(req, vo);
			
			log.debug("========机房平面图画面初期显示处理终了========");
		}
		
		//FLEX版本平面图逻辑
		if( "FLEX".equals(mapping.getParameter())){
			//机房平面图画面初期显示处理
			log.debug("========机房平面图画面初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm1104Form(form);
			
			//机房检索逻辑调用
			dto = ctlBL.initIGASM1104Action(dto);
			
			//查询已上架的机柜信息，并组装成XML文件
			dto = ctlBL.getJiguiXml(dto);
			
			//查询未上架的机柜信息，并组装成XML文件
			dto = ctlBL.getToolsXml(dto);
			
			//查询图例信息，并组装成XML文件
			dto = ctlBL.getLegendXml(dto);
			
//			//查询未上架的机柜信息，并组装成XML文件
//			dto = ctlBL.getGuodaoXml(dto);
			
			//查询无效地区信息，并组装成XML文件
			dto = ctlBL.getWuXiaoXml(dto);
			
			//查询未上架的机柜信息，并组装成XML文件
			dto = ctlBL.getRelateRoomXml(dto);
			
			//将机房信息检索结果设定到VO中
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
			
			log.debug("========机房平面图画面初期显示处理终了========");
		}

		if( "MOVE".equals(mapping.getParameter())){
			//机柜移除处理
			log.debug("========机柜移除处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm1104Form(form);
			
			//机柜移除逻辑调用
			dto = ctlBL.moveoutComputerContainerAction(dto);
			
			log.debug("========机柜移除处理终了========");
		}

		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		if( "INITAPP".equals(mapping.getParameter())){
			//机柜移除处理
			log.debug("========初始化地板开始========");
			
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
			log.debug("========初始化地板终了========");
			return null;
		}
		return mapping.findForward("DISP");
	}
}
