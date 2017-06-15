/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;

/**
 * @概述锦州银行基础设施首页BL
 * @功能描述： 1.四大主机使用率
 *           2.四大主机当日利用率趋势
 *           3.四大主机数据库与中间件使用率
 *           4.核心存储当月利用率趋势
 *           5.相关事件与相关问题数
 * @创建记录 李旭峙  2010/11/29
 * @version 1.0
 */

public class IGDBM04BLImpl extends BaseBLImpl implements IGDBM04BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	
	
	/**
	 * 功能:当日核心系统主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日核心系统主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setKernelUseAvg(IGDBM04DTO dto)  throws BLException{

		Random rand = new Random(new Date().getTime());
		    
		    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
		    
		    content = content+"<LEFTMAXVALUE>" + "100" + "</LEFTMAXVALUE>";
		    content = content+"<LEFTLINE>" ;
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"</LEFTLINE>" ;
		    content = content+"<RIGHTLINE>" ;
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"<value>" + rand.nextInt(100) + "</value>";
		    content = content+"</RIGHTLINE>" ;
		    content = content+"<HOUR>" ;
		    content = content+"<value>" + 1 + "</value>";
		    content = content+"<value>" + 2 + "</value>";
		    content = content+"<value>" + 3 + "</value>";
		    content = content+"<value>" + 4 + "</value>";
		    content = content+"<value>" + 5 + "</value>";
		    content = content+"<value>" + 6 + "</value>";
		    content = content+"<value>" + 7 + "</value>";
		    content = content+"<value>" + 8 + "</value>";
		    content = content+"<value>" + 9 + "</value>";
		    content = content+"<value>" + 10 + "</value>";
		    content = content+"<value>" + 11 + "</value>";
		    content = content+"<value>" + 12 + "</value>";
		    content = content+"</HOUR>" ;
		    content = content+"</ROOT>";
		    dto.setResultXML(content);
		
		return dto;
	}
	
	/**
	 * 功能:当日前置系统主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日前置系统主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setPrefixUseAvg(IGDBM04DTO dto)  throws BLException{

		Random rand = new Random(new Date().getTime());
	    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
	    
	    content = content+"<LEFTMAXVALUE>" + "100" + "</LEFTMAXVALUE>";
	    content = content+"<LEFTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</LEFTLINE>" ;
	    content = content+"<RIGHTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</RIGHTLINE>" ;
	    content = content+"<HOUR>" ;
	    content = content+"<value>" + 1 + "</value>";
	    content = content+"<value>" + 2 + "</value>";
	    content = content+"<value>" + 3 + "</value>";
	    content = content+"<value>" + 4 + "</value>";
	    content = content+"<value>" + 5 + "</value>";
	    content = content+"<value>" + 6 + "</value>";
	    content = content+"<value>" + 7 + "</value>";
	    content = content+"<value>" + 8 + "</value>";
	    content = content+"<value>" + 9 + "</value>";
	    content = content+"<value>" + 10 + "</value>";
	    content = content+"<value>" + 11 + "</value>";
	    content = content+"<value>" + 12 + "</value>";
	    content = content+"</HOUR>" ;
	    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * 功能:当日中间业务主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日中间业务主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setMiddleOperationUseAvg(IGDBM04DTO dto)  throws BLException{

		Random rand = new Random(new Date().getTime());
	    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
	    
	    content = content+"<LEFTMAXVALUE>" + "100" + "</LEFTMAXVALUE>";
	    content = content+"<LEFTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</LEFTLINE>" ;
	    content = content+"<RIGHTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</RIGHTLINE>" ;
	    content = content+"<HOUR>" ;
	    content = content+"<value>" + 1 + "</value>";
	    content = content+"<value>" + 2 + "</value>";
	    content = content+"<value>" + 3 + "</value>";
	    content = content+"<value>" + 4 + "</value>";
	    content = content+"<value>" + 5 + "</value>";
	    content = content+"<value>" + 6 + "</value>";
	    content = content+"<value>" + 7 + "</value>";
	    content = content+"<value>" + 8 + "</value>";
	    content = content+"<value>" + 9 + "</value>";
	    content = content+"<value>" + 10 + "</value>";
	    content = content+"<value>" + 11 + "</value>";
	    content = content+"<value>" + 12 + "</value>";
	    content = content+"</HOUR>" ;
	    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * 功能:当日网银主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日网银主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setNetbankUseAvg(IGDBM04DTO dto)  throws BLException{

		Random rand = new Random(new Date().getTime());
	    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
	    
	    content = content+"<LEFTMAXVALUE>" + "100" + "</LEFTMAXVALUE>";
	    content = content+"<LEFTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</LEFTLINE>" ;
	    content = content+"<RIGHTLINE>" ;
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"<value>" + rand.nextInt(100) + "</value>";
	    content = content+"</RIGHTLINE>" ;
	    content = content+"<HOUR>" ;
	    content = content+"<value>" + 1 + "</value>";
	    content = content+"<value>" + 2 + "</value>";
	    content = content+"<value>" + 3 + "</value>";
	    content = content+"<value>" + 4 + "</value>";
	    content = content+"<value>" + 5 + "</value>";
	    content = content+"<value>" + 6 + "</value>";
	    content = content+"<value>" + 7 + "</value>";
	    content = content+"<value>" + 8 + "</value>";
	    content = content+"<value>" + 9 + "</value>";
	    content = content+"<value>" + 10 + "</value>";
	    content = content+"<value>" + 11 + "</value>";
	    content = content+"<value>" + 12 + "</value>";
	    content = content+"</HOUR>" ;
	    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * 功能:各主机IT运行情况
	 * @param IGDBM04DTO dto
	 * @return 各主机利用率数据
	 * @throws BLException
	 */
	public IGDBM04DTO setEquipment(IGDBM04DTO dto)  throws BLException{
		List<Integer> core = new ArrayList<Integer>();
		List<Integer> center = new ArrayList<Integer>();
		List<Integer> before = new ArrayList<Integer>();
		List<Integer> netbank = new ArrayList<Integer>();
		
		    Random rand = new Random(new Date().getTime());
		    
		    //真正取数据的部分
		    for(int i=1;i<=6;i++){
		    	int type = rand.nextInt(50)+20;
		    	core.add(type);
		    }
		    for(int i=1;i<=6;i++){
		    	int type = rand.nextInt(50)+20;
		    	center.add(type);
		    }
		    for(int i=1;i<=6;i++){
		    	int type = rand.nextInt(50)+20;
		    	before.add(type);
		    }
		    for(int i=1;i<=6;i++){
		    	int type = rand.nextInt(50)+20;
		    	netbank.add(type);
		    }
		    
		    //根据数据生成xml
		    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";
		    
		   
		    content = content+"<core>";
		    for(int i=0;i<core.size();i++){
		    	if(core.get(i)>=60){
		    		content = content+"<value color=\"#ff0000\">"+core.get(i)+"%</value>";
		    	}else{
		    		content = content+"<value color=\"#000000\">"+core.get(i)+"%</value>";
		    	}
		    	
		    }
		    content = content+"</core>";
		    content = content+"<center>";
		    for(int i=0;i<center.size();i++){
		    	if(center.get(i)>=60){
		    		content = content+"<value color=\"#ff0000\">"+center.get(i)+"%</value>";
		    	}else{
		    		content = content+"<value color=\"#000000\">"+center.get(i)+"%</value>";
		    	}
		    	
		    }
		    content = content+"</center>";
		    content = content+"<before>";
		    for(int i=0;i<before.size();i++){
		    	if(before.get(i)>=60){
		    		content = content+"<value color=\"#ff0000\">"+before.get(i)+"%</value>";
		    	}else{
		    		content = content+"<value color=\"#000000\">"+before.get(i)+"%</value>";
		    	}
		    	
		    }
		    content = content+"</before>";
		    content = content+"<netbank>";
		    for(int i=0;i<netbank.size();i++){
		    	if(netbank.get(i)>=60){
		    		content = content+"<value color=\"#ff0000\">"+netbank.get(i)+"%</value>";
		    	}else{
		    		content = content+"<value color=\"#000000\">"+netbank.get(i)+"%</value>";
		    	}
		    	
		    }
		    content = content+"</netbank>";
		    content = content+"</ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * 功能:获得核心业务主机数据库或中间件各部分利用率
	 * @param IGDBM04DTO dto
	 * @return 数据库或中间件各部分利用率
	 * @throws BLException
	 */
	public IGDBM04DTO getSystemPiller(IGDBM04DTO dto)  throws BLException{
		
		    Random rand = new Random(new Date().getTime());
		    //根据数据生成xml
		    String content ="";
		    
		    if("db".equals(dto.getSystemPillarType())){
			    //生成数据库xml
			    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"读命中率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"CPU占用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"内存占用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"表空间使用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"数据库锁数量\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
		    }else if("cer".equals(dto.getSystemPillarType())){
			    //生成中间件xml
			    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"活动会话\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"可用内存\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"请求吞吐量\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"相应时间\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"JVMT堆大小\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
		    }
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * 功能:基础设施首页相关事件问题仪表
	 * @param IGDBM04DTO dto
	 * @return 事件问题数量
	 * @throws BLException
	 */
	public IGDBM04DTO getSomeThingsQuestions(IGDBM04DTO dto)throws BLException{
		Random rand = new Random(new Date().getTime());
		dto.setSomethings(rand.nextInt(50));
		dto.setSomequestion(rand.nextInt(50));
		return dto;
	}
	
	/**
	 * 功能:核心存储当月利用率趋势
	 * @param IGDBM04DTO dto
	 * @return 核心存储当月利用率
	 * @throws BLException
	 */
	public IGDBM04DTO getDoubleColorLine(IGDBM04DTO dto)  throws BLException{
		
		    Random rand = new Random(new Date().getTime());
		   
		    //根据数据生成xml
		    String content ="<?xml version=1.0 encoding=UTF-8?><ROOT>" ;
		    content+="<REDLINE>50</REDLINE><LINE>";
		    for(int i=0;i<31;i++){
		    	content+="<value>"+rand.nextInt(100)+"</value>";
		    }
			content+="</LINE></ROOT>";
		    dto.setResultXML(content);
		return dto;
	}
}

