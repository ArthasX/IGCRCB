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
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * @������������ϵͳ�����ʷ�����ҳBL
 * @�������� 1.��ǰʵ�ʿ�����         
 *			2.ʵ�ʿ�����ȫ���ۼ�        
 *			3.�������������         
 *			4.������ʱ���������
 * @������¼��������    2010/12/01
 * @version 1.0
 */

public class IGDBM09BLImpl extends BaseBLImpl implements IGDBM09BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);

	/**
	 * ����: ȡ�õ�ǰʵ�ʿ�����
	 * @param  IGDBM09DTO dto
	 * @return ��ǰʵ�ʿ�����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getCurrentActualAvailability(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//ȡ����ѡ��ϵͳID
		Random rand = new Random();
		//����ϵͳIDȡ�õ�ǰʵ�ʿ�����
		dto.setCurrentActualAvailability((rand.nextInt(20)+80)+"");
		return dto;
	}
	
	/**
	 * ����: ȡ��ʵ�ʿ�����ȫ���ۼ�
	 * @param  IGDBM09DTO dto
	 * @return ʵ�ʿ�����ȫ���ۼ�ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getYearActualAvailability(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//ȡ����ѡ��ϵͳID
		Random rand = new Random();
		//����ϵͳIDȡ��ʵ�ʿ�����ȫ���ۼ�
		dto.setYearActualAvailability((rand.nextInt(20)+80)+"");
		return dto;
	}
	
	/**
	 * ����: ȡ�ÿ������������
	 * @param  IGDBM09DTO dto
	 * @return �������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getAvailabilityYearTrends(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//ȡ����ѡ��ϵͳID
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
		content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "80" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "88" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "98" + "</value>";
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"</ROOT>";
	    dto.setAvailabilityYearTrends(content);
		return dto;
	}
	
	/**
	 * ����: ȡ�ù�����ʱ���������
	 * @param  IGDBM09DTO dto
	 * @return ������ʱ���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getWorkTimelySolutionlyTrends(IGDBM09DTO dto) throws BLException{
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
		content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
		content = content+"<ALARMVALUE>" + "90" + "</ALARMVALUE>";
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "80" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "88" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"</ROOT>";
	    dto.setWorkTimelySolutionlyTrends(content);
		return dto;
	}
	
}

