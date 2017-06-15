/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;


import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * @�������������¼��ۺϷ�����ҳBL
 * @�������� 1. ȡ���¼�������������ռ��ֵ
 *           2. ȡ���¼�ƽ�����ʱ������ֵ
 *           3. ȡ���¼���������ֵ
 *           4. ȡ���¼���ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public class IGDBM06BLImpl extends BaseBLImpl implements IGDBM06BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * ����: ȡ���¼�������������ռ��ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼�����������ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getPieValue(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn1Value = dto.getPn1Value();    //��ѯ�·�
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * ����: ȡ���¼�ƽ�����ʱ������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼�ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForAvg(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn2Value = dto.getPn2Value();  //�¼�����
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForAvg(content);
		return dto;
	}
	
	/**
	 * ����: ȡ���¼���������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForCount(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn3Value = dto.getPn2Value();  //�¼�����
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForCount(content);
		return dto;
	}
	
	/**
	 * ����: ȡ���¼���������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForSolve(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn4Value = dto.getPn2Value();  //�¼�����
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForSolve(content);
		return dto;
	}
	/**
	 * ����: ȡ���¼��ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼��ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentAllMode(IGDBM06DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessIncidentLineForAvg(dto);
		dto = this.getProcessIncidentLineForCount(dto);
		dto = this.getProcessIncidentLineForSolve(dto);
		return dto;
	}
}

