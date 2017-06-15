/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @�����������л�����ʩ��ҳBL
 * @���������� 1.�Ĵ�����ʹ����
 *           2.�Ĵ�������������������
 *           3.�Ĵ��������ݿ����м��ʹ����
 *           4.���Ĵ洢��������������
 *           5.����¼������������
 * @������¼ ������  2010/11/29
 * @version 1.0
 */

public class IGDBM04BLImpl extends BaseBLImpl implements IGDBM04BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	
	
	/**
	 * ����:���պ���ϵͳ����CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ���պ���ϵͳ����cpu�ڴ�ʹ����
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
	 * ����:����ǰ��ϵͳ����CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ����ǰ��ϵͳ����cpu�ڴ�ʹ����
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
	 * ����:�����м�ҵ������CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return �����м�ҵ������cpu�ڴ�ʹ����
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
	 * ����:������������CPU/�ڴ�������xml
	 * @param IGDBM04DTO dto
	 * @return ������������cpu�ڴ�ʹ����
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
	 * ����:������IT�������
	 * @param IGDBM04DTO dto
	 * @return ����������������
	 * @throws BLException
	 */
	public IGDBM04DTO setEquipment(IGDBM04DTO dto)  throws BLException{
		List<Integer> core = new ArrayList<Integer>();
		List<Integer> center = new ArrayList<Integer>();
		List<Integer> before = new ArrayList<Integer>();
		List<Integer> netbank = new ArrayList<Integer>();
		
		    Random rand = new Random(new Date().getTime());
		    
		    //����ȡ���ݵĲ���
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
		    
		    //������������xml
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
	 * ����:��ú���ҵ���������ݿ���м��������������
	 * @param IGDBM04DTO dto
	 * @return ���ݿ���м��������������
	 * @throws BLException
	 */
	public IGDBM04DTO getSystemPiller(IGDBM04DTO dto)  throws BLException{
		
		    Random rand = new Random(new Date().getTime());
		    //������������xml
		    String content ="";
		    
		    if("db".equals(dto.getSystemPillarType())){
			    //�������ݿ�xml
			    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��������\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"CPUռ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"�ڴ�ռ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��ռ�ʹ����\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"���ݿ�������\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
		    }else if("cer".equals(dto.getSystemPillarType())){
			    //�����м��xml
			    content ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��Ự\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"�����ڴ�\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"����������\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"��Ӧʱ��\">"+(rand.nextInt(40)+35)+"</PILLAR>" +
				"<PILLAR YELLOWVALUE=\"60\" REDVALUE=\"70\" TEXT=\"JVMT�Ѵ�С\">"+(rand.nextInt(40)+35)+"</PILLAR></ROOT>";
		    }
		    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:������ʩ��ҳ����¼������Ǳ�
	 * @param IGDBM04DTO dto
	 * @return �¼���������
	 * @throws BLException
	 */
	public IGDBM04DTO getSomeThingsQuestions(IGDBM04DTO dto)throws BLException{
		Random rand = new Random(new Date().getTime());
		dto.setSomethings(rand.nextInt(50));
		dto.setSomequestion(rand.nextInt(50));
		return dto;
	}
	
	/**
	 * ����:���Ĵ洢��������������
	 * @param IGDBM04DTO dto
	 * @return ���Ĵ洢����������
	 * @throws BLException
	 */
	public IGDBM04DTO getDoubleColorLine(IGDBM04DTO dto)  throws BLException{
		
		    Random rand = new Random(new Date().getTime());
		   
		    //������������xml
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

