/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @����������������ҵ��ʵʱ�����ҳBL
 * @�������� 1.����ҵ��ʵʱ���         
 *			2.db2��Ϣ        
 *			3.���������HCAMP״̬         
 *			4.cpuռ����TOP5
 *			5.Omnibus�¼�����
 * @������¼��������    2010/12/01
 * @version 1.0
 */

public class IGDBM10BLImpl extends BaseBLImpl implements IGDBM10BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);

	/**
	 * ����: ����ҵ��ʵʱ���
	 * @param  IGDBM10DTO dto
	 * @return ����ҵ��ʵʱ����
	 * @throws BLException
	 */
	public IGDBM10DTO getChannelsBusinessRealtime(IGDBM10DTO dto) throws BLException{
		Random rand = new Random(new Date().getTime());
	    //������������xml
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
	 * ����: db2��Ϣ
	 * @param  IGDBM10DTO dto
	 * @return db2��Ϣ����
	 * @throws BLException
	 */
	public IGDBM10DTO getDB2Information(IGDBM10DTO dto) throws BLException{
		Random rand = new Random(new Date().getTime());
	    //������������xml
	    String content ="";
	    
	    
	    //����xml
	    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"CPUռ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"�ڴ�ռ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��ռ�ռ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��������\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
		"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"���ݿ�������\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
	    
	    dto.setDb2Information(content);
		return dto;
	}
	
	/**
	 * ����: ���������HCAMP״̬
	 * @param  IGDBM10DTO dto
	 * @return ���������HCAMP״ֵ̬
	 * @throws BLException
	 */
	public IGDBM10DTO getBackupAndHCAMPType(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //������������xml
	    String content ="";
	    
	    //����a1��a2�ж��Ǳ����������HCAMP״̬
	    String hostid = dto.getHostid();
	    
	    if("a1".equals(hostid)){
		    //����xml
		    content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "�ϴα���" + "</HOST>";
			content = content+"<COMPUTERA>" + "2010-12-0"+(rand.nextInt(4)+1) + "</COMPUTERA>";
			content = content+"<COMPUTERB>" + "2010-12-0"+(rand.nextInt(4)+1) + "</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"<DATA>";
			content = content+"<HOST>" + "״̬" + "</HOST>";
			content = content+"<COMPUTERA>" + "ok" + "</COMPUTERA>";
			content = content+"<COMPUTERB>" + "ok" + "</COMPUTERB>";
			content = content+"</DATA>";
			content = content+"</ROOT>";
	    }else{
		    //����xml
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
	 * ����:cpuռ����TOP5
	 * @param  IGDBM10DTO dto
	 * @return cpuռ����TOP5ֵ
	 * @throws BLException
	 */
	public IGDBM10DTO getCPUOccupancyrateTOP5(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //������������xml
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
		content = content+"<value>" + "����1" + "</value>";
		content = content+"<value>" + "����2" + "</value>";
		content = content+"<value>" + "����3" + "</value>";
		content = content+"<value>" + "����4" + "</value>";
		content = content+"<value>" + "����5" + "</value>";
		content = content+"</PROCESSTEXT>";
		content = content+"</ROOT>";
		dto.setCpuOccupancyrateTOP5(content);
		return dto;
	}
	
	/**
	 * ����: Omnibus�¼�����
	 * @param  IGDBM10DTO dto
	 * @return Omnibus�¼�����ֵ
	 * @throws BLException
	 */
	public IGDBM10DTO getOmnibusEventWarning(IGDBM10DTO dto) throws BLException{
		
		Random rand = new Random(new Date().getTime());
	    //������������xml
	    String content ="";
		
		content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "����" + "</TYPE>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "����" + "</TYPE>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "����" + "</TYPE>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "����" + "</TYPE>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"<DATA>";
		content = content+"<OPENTIME>" + "2010-11-11 09:20:34" + "</OPENTIME>";
		content = content+"<COUNT>" + (rand.nextInt(4)+1) + "</COUNT>";
		content = content+"<IP>" + "192.168.1.1" + "</IP>";
		content = content+"<TYPE>" + "����" + "</TYPE>";
		content = content+"<LEVEL>" + "����" + "</LEVEL>";
		content = content+"</DATA>";
		content = content+"</ROOT>";
		dto.setOmnibusEventWarning(content);
		return dto;
	}
	
}

