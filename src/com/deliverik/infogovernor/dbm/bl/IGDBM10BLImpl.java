/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;


import java.util.Date;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM10DTO;

/**
 * @概述锦州银行渠道业务实时情况首页BL
 * @功能描述 1.渠道业务实时情况         
 *			2.db2信息        
 *			3.备份情况及HCAMP状态         
 *			4.cpu占用率TOP5
 *			5.Omnibus事件警告
 * @创建记录：李旭峙    2010/12/01
 * @version 1.0
 */

public class IGDBM10BLImpl extends BaseBLImpl implements IGDBM10BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);

	/**
	 * 功能: 渠道业务实时情况
	 * @param  IGDBM10DTO dto
	 * @return 渠道业务实时数据
	 * @throws BLException
	 */
	public IGDBM10DTO getChannelsBusinessRealtime(IGDBM10DTO dto) throws BLException{
		Random rand = new Random(new Date().getTime());
	    //根据数据生成xml
	    String content ="";
	    
		content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		content = content+"<COMPUTERA>";
		content = content+"<value>" + (rand.nextInt(40)+35)+"%" + "</value>";
		content = content+"<value>" + (rand.nextInt(40)+35)+"%" + "</value>";
		content = content+"<value>" + (rand.nextInt(40)+35)+"%" + "</value>";
		content = content+"<value>" + (rand.nextInt(40)+35)+"%" + "</value>";
		content = content+"<value>" + (rand.nextInt(40)+35)+"%" + "</value>";
		content = content+"</COMPUTERA>";
		content = content+"<COMPUTERB>";
		content = content+"<value>" + "100%" + "</value>";
		content = content+"<value>" + "95%" + "</value>";
		content = content+"<value>" + "90%" + "</value>";
		content = content+"<value>" + "85%" + "</value>";
		content = content+"<value>" + "80%" + "</value>";
		content = content+"</COMPUTERB>";
		content = content+"<SWITCHBOARDA>";
		content = content+"<value>" + "100%" + "</value>";
		content = content+"<value>" + "95%" + "</value>";
		content = content+"<value>" + "90%" + "</value>";
		content = content+"<value>" + "85%" + "</value>";
		content = content+"<value>" + "80%" + "</value>";
		content = content+"</SWITCHBOARDA>";
		content = content+"<SWITCHBOARDB>";
		content = content+"<value>" + "100%" + "</value>";
		content = content+"<value>" + "95%" + "</value>";
		content = content+"<value>" + "90%" + "</value>";
		content = content+"<value>" + "85%" + "</value>";
		content = content+"<value>" + "80%" + "</value>";
		content = content+"</SWITCHBOARDB>";
		content = content+"<STORAGE>";
		content = content+"<value>" + "60" + "</value>";
		content = content+"<value>" + "80" + "</value>";
		content = content+"<value>" + "90%" + "</value>";
		content = content+"<value>" + "85%" + "</value>";
		content = content+"<value>" + "5" + "</value>";
		content = content+"<value>" + "6" + "</value>";
		content = content+"</STORAGE>";
		content = content+"</ROOT>";
		dto.setChannelsBusinessRealtime(content);
		return dto;
	}
	
	/**
	 * 功能: db2信息
	 * @param  IGDBM10DTO dto
	 * @return db2信息数据
	 * @throws BLException
	 */
	public IGDBM10DTO getDB2Information(IGDBM10DTO dto) throws BLException{
		Random rand = new Random(new Date().getTime());
	    //根据数据生成xml
	    String content ="";
	    
	    
	    //生成xml
	    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"CPU占用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"内存占用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"表空间占用率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"读命中率\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"数据库锁数量\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
	    
	    dto.setDb2Information(content);
		return dto;
	}
	
	/**
	 * 功能: 备份情况及HCAMP状态
	 * @param  IGDBM10DTO dto
	 * @return 备份情况及HCAMP状态值
	 * @throws BLException
	 */
	public IGDBM10DTO getBackupAndHCAMPType(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //根据数据生成xml
	    String content ="";
	    
	    //根据a1或a2判断是备份情况还是HCAMP状态
	    String hostid = dto.getHostid();
	    
	    if("a1".equals(hostid)){
		    //生成xml
		    content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "上次备份" + "</HOST>";
			content = content+"<COMPUTERA>" + "2010-12-0"+(rand.nextInt(4)+1) + "</COMPUTERA>";
			content = content+"<COMPUTERB>" + "2010-12-0"+(rand.nextInt(4)+1) + "</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "状态" + "</HOST>";
			content = content+"<COMPUTERA>" + "ok" + "</COMPUTERA>";
			content = content+"<COMPUTERB>" + "ok" + "</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"</ROOT>";
	    }else{
		    //生成xml
		    content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "ClsMgr" + "</HOST>";
			content = content+"<COMPUTERA>" + "up"+"</COMPUTERA>";
			content = content+"<COMPUTERB>" + "up"+"</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "HeartBeat" + "</HOST>";
			content = content+"<COMPUTERA>" + "ok" + "</COMPUTERA>";
			content = content+"<COMPUTERB>" + "ok" + "</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"</ROOT>";
	    }

		dto.setBackupAndHCAMPType(content);
		
		return dto;
	}
	
	/**
	 * 功能:cpu占用率TOP5
	 * @param  IGDBM10DTO dto
	 * @return cpu占用率TOP5值
	 * @throws BLException
	 */
	public IGDBM10DTO getCPUOccupancyrateTOP5(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //根据数据生成xml
	    String content ="";
		
		content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		content = content+"<MAXVALUE>100</MAXVALUE>";
		content = content+"<MINVALUE>0</MINVALUE>";
		content = content+"<REDVALUE>30</REDVALUE>";
		content = content+"<DATA>";
		content = content+"<value>" + rand.nextInt(70) + "</value>";
		content = content+"<value>" + rand.nextInt(70) + "</value>";
		content = content+"<value>" + rand.nextInt(70) + "</value>";
		content = content+"<value>" + rand.nextInt(70) + "</value>";
		content = content+"<value>" + rand.nextInt(70) + "</value>";
		content = content+"</DATA>";
		content = content+"<PROCESSTEXT>";
		content = content+"<value>" + "进程1" + "</value>";
		content = content+"<value>" + "进程2" + "</value>";
		content = content+"<value>" + "进程3" + "</value>";
		content = content+"<value>" + "进程4" + "</value>";
		content = content+"<value>" + "进程5" + "</value>";
		content = content+"</PROCESSTEXT>";
		content = content+"</ROOT>";
		dto.setCpuOccupancyrateTOP5(content);
		return dto;
	}
	
	/**
	 * 功能: Omnibus事件警告
	 * @param  IGDBM10DTO dto
	 * @return Omnibus事件警告值
	 * @throws BLException
	 */
	public IGDBM10DTO getOmnibusEventWarning(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //根据数据生成xml
	    String content ="";
		
		content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "主机" + "</TYPE>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "主机" + "</TYPE>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "主机" + "</TYPE>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "主机" + "</TYPE>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "主机" + "</TYPE>";
		content = content+"<LEVEL>" + "正常" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"</ROOT>";
		dto.setOmnibusEventWarning(content);
		return dto;
	}
	
}

