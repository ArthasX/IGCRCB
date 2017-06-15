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
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;

/**
 * @�����������й����ۺϷ�����ҳBL
 * @�������� 1. ȡ���¹�������������ռ��ֵ
 *           2. ȡ�ù���ƽ�����ʱ������ֵ
 *           3. ȡ�ù�����������ֵ
 *           4. ȡ�ù�����ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public class IGDBM08BLImpl extends BaseBLImpl implements IGDBM08BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * ����: ȡ���¹�������������ռ��ֵ
	 * @param  IGDBM08DTO dto
	 * @return ��������������ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getPieValue(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn1Value = dto.getPn1Value();    //��ѯ�·�
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * ����: ȡ�ù���ƽ�����ʱ������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ����ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForAvg(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn2Value = dto.getPn2Value();  //��������
		
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
		dto.setWorkLineForAvg(content);
		return dto;
	}
	
	/**
	 * ����: ȡ�ù�����������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForCount(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn3Value = dto.getPn2Value();  //��������
		
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
		dto.setWorkLineForCount(content);
		return dto;
	}
	
	/**
	 * ����: ȡ�ù�����������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForSolve(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn4Value = dto.getPn2Value();  //��������
		
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
		dto.setWorkLineForSolve(content);
		return dto;
	}
	/**
	 * ����: ȡ�ù����ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM08DTO dto
	 * @return �����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkAllMode(IGDBM08DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessWorkLineForAvg(dto);
		dto = this.getProcessWorkLineForCount(dto);
		dto = this.getProcessWorkLineForSolve(dto);
		return dto;
	}
}

