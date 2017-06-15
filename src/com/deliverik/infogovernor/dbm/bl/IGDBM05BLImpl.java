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
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;

/**
 * @�����������������ۺϷ�����ҳBL
 * @�������� 1. ȡ������������������ռ��ֵ
 *           2. ȡ������ƽ�����ʱ������ֵ
 *           3. ȡ��������������ֵ
 *           4. ȡ�����⼰ʱ�����ֵ
 * @������¼ �Կ�  2010/11/29
 * @version 1.0
 */

public class IGDBM05BLImpl extends BaseBLImpl implements IGDBM05BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * ����: ȡ������������������ռ��ֵ
	 * @param  IGDBM05DTO dto
	 * @return �������������ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getPieValue(IGDBM05DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //��ѯ���� ���� or ��Դ
		String yearValue = dto.getYearValue();  //��ѯ���
		String pn1Value = dto.getPn1Value();    //��ѯ�·�
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * ����: ȡ������ƽ�����ʱ������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ����ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForAvg(IGDBM05DTO dto) throws BLException{
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
		dto.setProblemLineForAvg(content);
		return dto;
	}
	
	/**
	 * ����: ȡ��������������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForCount(IGDBM05DTO dto) throws BLException{
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
		dto.setProblemLineForCount(content);
		return dto;
	}
	
	/**
	 * ����: ȡ��������������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForSolve(IGDBM05DTO dto) throws BLException{
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
		dto.setProblemLineForSolve(content);
		return dto;
	}
	/**
	 * ����: ȡ�������ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM05DTO dto
	 * @return �����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemAllMode(IGDBM05DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessProblemLineForAvg(dto);
		dto = this.getProcessProblemLineForCount(dto);
		dto = this.getProcessProblemLineForSolve(dto);
		return dto;
	}
}

