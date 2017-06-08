/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.plugin.change.socket;
  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;

/***
 * 推送变更线程
 * @time 2015/08/20
 * @author zhangq
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IgChangeThread implements Runnable {
	
	static Log log = LogFactory.getLog(IgChangeThread.class);

	
	protected static ActionServlet servlet;
	
	/**流程ID*/
	protected Integer prid;
	
	public IgChangeThread(Integer prid){
		this.prid = prid;
	}
	
	
	/**
	 * 推送变更线程 执行操作
	 */
	public void run(){  
		log.info("=========================变更信息推送开始========================");
		IGCHANGE01BLImpl ctrBL = (IGCHANGE01BLImpl) WebApplicationSupport.getBean("iGCHANGE01BLImpl");
    	try {
    	    //实例化DTO
    	    IGCHANGE01DTO dto = new IGCHANGE01DTO();
    	    dto.setPrid(prid);
    		
    		//调用变更日志处理BL查询与相应的prid相关的流程日志数据
    	    IGCHANGE01DTO initDto = ctrBL.searchInitiacteChangeAction(dto);
    	    
			//实例化推送变更工具类
			IGPMSSERVICE01Utils utils = new IGPMSSERVICE01Utils();
			/**开始推送变更信息*/ 
			String ticketId=initDto.getTicketId();
			log.info("ticketId: "+ticketId);
			log.info(utils.ChangeTicketPhase(initDto.getTicketId(),"true"));
			
		} catch (BLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	log.info("=========================变更信息推送结束========================");
	}  
   
	

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	
	public Integer getPrid() {
		return prid;
	}



	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}



	/**
	 * servlet获取
	 * @return the servlet
	 */
	public static ActionServlet getServlet() {
		return servlet;
	}

	/**
	 * servlet设定
	 * @param servlet servlet 
	 */
	public static void setServlet(ActionServlet servlet) {
		IgChangeThread.servlet = servlet;
	}  
} 