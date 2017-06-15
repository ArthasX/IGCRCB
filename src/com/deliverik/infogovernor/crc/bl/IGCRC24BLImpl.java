/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2401BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * ����:�¼�ƽ�����ʱ��ͳ��BL 
 */
public class IGCRC24BLImpl extends BaseBLImpl implements IGCRC24BL {
	
	/**�¼�ƽ�����ʱ��BL*/
	protected IGCRC2401BL igcrc2401bl;

	public IGCRC2401BL getIgcrc2401bl() {
		return igcrc2401bl;
	}

	public void setIgcrc2401bl(IGCRC2401BL igcrc2401bl) {
		this.igcrc2401bl = igcrc2401bl;
	}

	public IGCRC2401DTO getFindStatistics(IGCRC2401DTO dto) {
		// TODO Auto-generated method stub
		
		IGCRC2401Form form = dto.getIgcrc2401Form();
		
		IGCRC2401CondImpl cond = new IGCRC2401CondImpl();
		//��Ӳ�ѯ����  ��
		cond.setYear(form.getYear());
		//��Ӳ�ѯ���� ��
		cond.setMonth(form.getMonth());
		//��Ӳ�ѯ���� ����
		cond.setDept(form.getDept());
		
		cond.setSign(form.getSign());
		//ֵ�ŵ�DTO
		dto.setCond(cond);
		//��ѯ�������
		List<IGCRC2401VW> igcrc2401vwList = igcrc2401bl.igcrc2401vwList(cond);

		//ҳ����ʾ������
		List<IGCRC2402VO> igcrc2402voList = new ArrayList<IGCRC2402VO>();
		if(null != igcrc2401vwList && igcrc2401vwList.size() != 0){
			
			//��һ�����ݵ�userId �� ����
			String initialUserId = igcrc2401vwList.get(0).getUserId();
			String initialName = igcrc2401vwList.get(0).getUserName();
			//ʱ��Ͷ���
			IGCRC2402VO timeSum = new IGCRC2402VO();
			Integer pridNUM = 0;
			//ѭ��
			for (int i = 0 ; i < igcrc2401vwList.size(); i ++) {
				IGCRC2401VW igcrc2401vw = igcrc2401vwList.get(i);
				//�ж�userId�Ƿ���ͬ ��ͬ�����
				if(initialUserId.equals(igcrc2401vw.getUserId())){
					pridNUM++;
					//����ʱ���
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTime(igcrc2401vw) , pridNUM ,igcrc2401vw.getPrid());
				}else if(!initialUserId.equals(igcrc2401vw.getUserId())){//��ͬ���³�ʼ��userid
					//userid��һ�β�ͬʱ(���ڼ�����һ����Աʱ) ��timeSum��ӵ�List��
					pridNUM = 1;
					igcrc2402voList.add(new IGCRC2402VO(timeSum, initialUserId, initialName));
					initialUserId = igcrc2401vw.getUserId();
					initialName = igcrc2401vw.getUserName();
					//��ʼ��ʱ��Ͷ���
					timeSum = new IGCRC2402VO();
					//�����һ��userid��ͬ��ʱ���
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTime(igcrc2401vw),pridNUM,igcrc2401vw.getPrid());
					
				}
				if(i == (igcrc2401vwList.size() - 1)){
					//����ʱ(�������һ����Ա) ��timeSum��ӵ�List��
					igcrc2402voList.add(new IGCRC2402VO(timeSum, igcrc2401vw.getUserId(),igcrc2401vw.getUserName()));
				}
			}
		}
		dto.setIgcrc2402voList(igcrc2402voList);
		return dto;
	}
	
	/**	
	 * ���ܣ�����ʱ��� ���浽������
	 * @param ʱ��Ͷ���
	 * @param �ȼ�
	 * @param ʱ���
	 * @return ʱ��Ͷ���
	 * �޸ļ�¼��null 	
	 */	
	private IGCRC2402VO getTimeSum(IGCRC2402VO timeSum, String gradeStr, Long time , Integer pridNUM , Integer prid ){
		int grade = 0;
		timeSum.setPridNUM(pridNUM);
		
		if(StringUtils.isNotBlank(timeSum.getPrid_In())){
			timeSum.setPrid_In(timeSum.getPrid_In() + "," + prid);
		}else if(prid != null){
			timeSum.setPrid_In(prid.toString());
		}
		if("��".equals(gradeStr)){
			grade = 1;
		}else if("��".equals(gradeStr)){
			grade = 2;
		}else if("��".equals(gradeStr)){
			grade = 3;
		}else if("��".equals(gradeStr)){
			grade = 4;
		}else if("��".equals(gradeStr)){
			grade = 5;
		}
		//�ж�ÿ��������õ�ʱ��ƽ����
		switch (grade) {
		case 1:
			timeSum.setGrade1(timeSum.getGrade1() + time);
			timeSum.setGrade1Count(timeSum.getGrade1Count() + 1);
			break;
		case 2:
			timeSum.setGrade2(timeSum.getGrade2() + time);
			timeSum.setGrade2Count(timeSum.getGrade2Count() + 1);
			break;
		case 3:
			timeSum.setGrade3(timeSum.getGrade3() + time);
			timeSum.setGrade3Count(timeSum.getGrade3Count() + 1);
			break;
		case 4:
			timeSum.setGrade4(timeSum.getGrade4() + time);
			timeSum.setGrade4Count(timeSum.getGrade4Count() + 1);
			break;
		case 5:
			timeSum.setGrade5(timeSum.getGrade5() + time);
			timeSum.setGrade5Count(timeSum.getGrade5Count() + 1);
			break;
		case 6:
			timeSum.setGrade6(timeSum.getGrade6() + time);
			timeSum.setGrade6Count(timeSum.getGrade6Count() + 1);
			break;
		case 7:
			timeSum.setGrade7(timeSum.getGrade7() + time);
			timeSum.setGrade7Count(timeSum.getGrade7Count() + 1);
			break;
		case 8:
			timeSum.setGrade8(timeSum.getGrade8() + time);
			timeSum.setGrade8Count(timeSum.getGrade8Count() + 1);
			break;

		default:
			break;
		}
		return timeSum;
	}
	
	/**	
	 * ���ܣ�����ʱ��� ��λ:����
	 * @param igcrc2401vw
	 * @return ʱ���
	 * �޸ļ�¼��null 	
	 */	
	private Long getTime(IGCRC2401VW igcrc2401vw){
		//��ʼʱ��
		Date startTime = null;
		//�����¼�
		Date endTime=null;
		//��ʽ��
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//�����ʼ�ͽ���ʱ��
		try {
			endTime = df.parse(igcrc2401vw.getEndTime() + ":00");
			startTime = df.parse(igcrc2401vw.getStartTime() + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//����ʱ��� ��λ:����
		return (endTime.getTime() - startTime.getTime()) / 60000;
	}
	

	
	/***
	 *  ����ƽ��ֵ
	 *  zhangqiang
	 *  zhangq@deliverik.com
	 *  2014-12-24
	 * @param dto
	 * @return
	 */
	public IGCRC2401DTO getFindStatisticsConfirm(IGCRC2401DTO dto) {
		// TODO Auto-generated method stub
		
		IGCRC2401Form form = dto.getIgcrc2401Form();
		
		IGCRC2401CondImpl cond = new IGCRC2401CondImpl();
		//��Ӳ�ѯ����  ��
		cond.setYear(form.getYear());
		//��Ӳ�ѯ���� ��
		cond.setMonth(form.getMonth());
		//��Ӳ�ѯ���� ����
		cond.setDept(form.getDept());
		
		cond.setSign(form.getSign());
		//ֵ�ŵ�DTO
		dto.setCond(cond);
		//��ѯ�������
		List<IGCRC2401VW> igcrc2401vwList = igcrc2401bl.igcrc2401vwListConfirm(cond);

		//ҳ����ʾ������
		List<IGCRC2402VO> igcrc2402voList = new ArrayList<IGCRC2402VO>();
		if(null != igcrc2401vwList && igcrc2401vwList.size() != 0){
			
			//��һ�����ݵ�userId �� ����
			String initialUserId = igcrc2401vwList.get(0).getUserId();
			String initialName = igcrc2401vwList.get(0).getUserName();
			Integer pridNUM = 0;
			//ʱ��Ͷ���
			IGCRC2402VO timeSum = new IGCRC2402VO();
			//ѭ��
			for (int i = 0 ; i < igcrc2401vwList.size(); i ++) {
				IGCRC2401VW igcrc2401vw = igcrc2401vwList.get(i);
				//�ж�userId�Ƿ���ͬ ��ͬ�����
				if(initialUserId.equals(igcrc2401vw.getUserId())){
					pridNUM ++ ;
					//����ʱ���
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTimeConfirm(igcrc2401vw),pridNUM , igcrc2401vw.getPrid());
				}else if(!initialUserId.equals(igcrc2401vw.getUserId())){//��ͬ���³�ʼ��userid
					pridNUM = 1;
					//userid��һ�β�ͬʱ(���ڼ�����һ����Աʱ) ��timeSum��ӵ�List��
					igcrc2402voList.add(new IGCRC2402VO(timeSum, initialUserId, initialName));
					initialUserId = igcrc2401vw.getUserId();
					initialName = igcrc2401vw.getUserName();
					//��ʼ��ʱ��Ͷ���
					timeSum = new IGCRC2402VO();
					//�����һ��userid��ͬ��ʱ���
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTimeConfirm(igcrc2401vw),pridNUM ,igcrc2401vw.getPrid());
					
				}
				if(i == (igcrc2401vwList.size() - 1)){
					//����ʱ(�������һ����Ա) ��timeSum��ӵ�List��
					igcrc2402voList.add(new IGCRC2402VO(timeSum, igcrc2401vw.getUserId(),igcrc2401vw.getUserName()));
				}
			}
		}
		dto.setIgcrc2402voList(igcrc2402voList);
		return dto;
	}
	
	
	
	
	/**	
	 * ���ܣ�����ʱ��� ��λ:����
	 * @param igcrc2401vw
	 * @return ʱ���
	 * @time  2014-12-24 
	 * @auth  zhangq@deliverik.com
	 * �޸ļ�¼��null 	
	 */	
	private Long getTimeConfirm(IGCRC2401VW igcrc2401vw){
		//��ʼʱ��
		Date startTime = null;
		//�����¼�
		Date endTime=null;
		//��ʽ��
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//�����ʼ�ͽ���ʱ��
		try {
			endTime = df.parse(igcrc2401vw.getConfirmtime() + ":00");
			startTime = df.parse(igcrc2401vw.getStartTime() + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//����ʱ��� ��λ:����
		return (endTime.getTime() - startTime.getTime()) / 60000;
	}

	

}
