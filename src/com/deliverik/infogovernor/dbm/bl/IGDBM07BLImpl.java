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
import com.deliverik.infogovernor.dbm.dto.IGDBM07DTO;

/**
 * @�����������б���ۺϷ�����ҳBL
 * @�������� 1. ȡ���±������������ռ��ֵ
 *           2. ȡ�ñ��ƽ�����ʱ������ֵ
 *           3. ȡ�ñ����������ֵ
 *           4. ȡ�ñ����ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public class IGDBM07BLImpl extends BaseBLImpl implements IGDBM07BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * ����: ȡ���±������������ռ��ֵ
	 * @param  IGDBM07DTO dto
	 * @return �������������ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getPieValue(IGDBM07DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn1Value = dto.getPn1Value();    //��ѯ�·�
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * ����: ȡ�ñ��ƽ�����ʱ������ֵ
	 * @param  IGDBM07DTO dto
	 * @return ���ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForAvg(IGDBM07DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn2Value = dto.getPn2Value();  //�������
		
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
		dto.setChangeLineForAvg(content);
		return dto;
	}
	
	/**
	 * ����: ȡ�ñ����������ֵ
	 * @param  IGDBM07DTO dto
	 * @return �����������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForCount(IGDBM07DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn3Value = dto.getPn2Value();  //�������
		
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
		dto.setChangeLineForCount(content);
		return dto;
	}
	
	/**
	 * ����: ȡ�ñ����������ֵ
	 * @param  IGDBM07DTO dto
	 * @return �����������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForSolve(IGDBM07DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn4Value = dto.getPn2Value();  //�������
		
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
		dto.setChangeLineForSolve(content);
		return dto;
	}
	/**
	 * ����: ȡ�ñ���ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM07DTO dto
	 * @return ����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeAllMode(IGDBM07DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessChangeLineForAvg(dto);
		dto = this.getProcessChangeLineForCount(dto);
		dto = this.getProcessChangeLineForSolve(dto);
		return dto;
	}
}

