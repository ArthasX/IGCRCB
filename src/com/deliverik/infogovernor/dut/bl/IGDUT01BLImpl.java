/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditDefBL;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditTimeBL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0101Form;
import com.deliverik.infogovernor.dut.form.IGDUT0102Form;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCondImpl;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditDefTB;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditTimeTB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ֵ�����_ֵ�����趨_BL
 * </p>
 * @version 
 */
public class IGDUT01BLImpl extends BaseBLImpl implements IGDUT01BL {
	
	static Log log = LogFactory.getLog(IGDUT01BLImpl.class);

	/** ֵ������BL */
	protected DutyAuditDefBL dutyAuditDefBL;
	
	/** ֵ����ʱ��BL */
	protected DutyAuditTimeBL dutyAuditTimeBL;

	/**
	 *  ֵ������BL
	 * @param dutyAuditDefBL ֵ������BL
	 */
	public void setDutyAuditDefBL(DutyAuditDefBL dutyAuditDefBL) {
		this.dutyAuditDefBL = dutyAuditDefBL;
	}

	/**
	 *  ֵ����ʱ��BL
	 * @param dutyAuditTimeBL ֵ����ʱ��BL
	 */
	public void setDutyAuditTimeBL(DutyAuditTimeBL dutyAuditTimeBL) {
		this.dutyAuditTimeBL = dutyAuditTimeBL;
	}
	
	/**
	 * ֵ������ǼǴ���
	 *
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 */
	public IGDUT01DTO insertDutyAuditDefAction(IGDUT01DTO dto) throws BLException {
		log.debug("========ֵ������ǼǴ���ʼ========");
		IGDUT0101Form form = dto.getIgDUT0101Form();
		User user = dto.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd;HH:mm");
		//����ֵ������ 
		DutyAuditDefTB dtb = new DutyAuditDefTB();
		dtb.setDadcategory(form.getDadcategory());
		dtb.setDadtype(form.getDadtype());
		dtb.setDadname(form.getDadname());
		dtb.setDadlimtime(form.getDadlimtime());
		dtb.setDadcontent(form.getDadcontent());
		dtb.setDadinfo(form.getDadinfo());
		dtb.setDadstatus(IGDUTCONSTANTS.DUTY_STATUS_ENABLE);//����
		
		dtb.setDaduserid(user.getUserid());
		dtb.setDadusername(user.getUsername());
		dtb.setDadupdtime(IGStringUtils.getCurrentDateTime());
		dtb.setDadorderby(form.getDadorderby());
		//20120406 byf start
		dtb.setPeriodType(form.getPeriodType());//��������
		
		//����ʱ��
		if("day".equalsIgnoreCase(form.getPeriodType())){
			
		}else if("week".equalsIgnoreCase(form.getPeriodType())){
			dtb.setPeriodValue(form.getWeek_value());
		}else if("month".equalsIgnoreCase(form.getPeriodType())){
			dtb.setPeriodValue(form.getMonth_value());
		}else if("quarter".equalsIgnoreCase(form.getPeriodType())){
			if("one".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="one,01/"+form.getQuarter_dayValue()+","+"04/"+form.getQuarter_dayValue()+","
				+"07/"+form.getQuarter_dayValue()+","+"10/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
			if("two".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="two,02/"+form.getQuarter_dayValue()+","+"05/"+form.getQuarter_dayValue()+","
				+"08/"+form.getQuarter_dayValue()+","+"12/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
			if("three".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="three,03/"+form.getQuarter_dayValue()+","+"06/"+form.getQuarter_dayValue()+","
				+"09/"+form.getQuarter_dayValue()+","+"12/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
		}
		//20120406 byf end
		DutyAuditDef dutyAuditDef = this.dutyAuditDefBL.registDutyAuditDef(dtb);
		dto.setDutyAuditDef(dutyAuditDef);	
		
		//����ֵ����ʱ��
		String[] dattimes = form.getDattimes();//���ʱ��
		String dadlimtime = form.getDadlimtime();//�ʱ������
		if(dattimes!=null){
			for(int i=0,j=dattimes.length;i<j;i++){
				String hour = dattimes[i].split(":")[0];
				String min = dattimes[i].split(":")[1];
				DutyAuditTimeTB dat = new DutyAuditTimeTB();
				dat.setDadid(dutyAuditDef.getDadid());
				dat.setDattime(dattimes[i]);
				
				//��������ʱ��
				Calendar c = Calendar.getInstance();
				c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), Integer.valueOf(hour), 
						Integer.valueOf(min));
				c.add(Calendar.MINUTE, Integer.valueOf(dadlimtime));
				dat.setDatlimtime(sdf.format(c.getTime()).split(";")[1]);
				dutyAuditTimeBL.registDutyAuditTime(dat);
			}
		}

		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ֵ��������Ϣ") );
		
		log.debug("========ֵ������ǼǴ�������========");
		return dto;
	}
	

	/**
	 * ֵ������Ϣ���´���
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGDUT01DTO updateDutyAuditDefAction(IGDUT01DTO dto) throws BLException {
		log.debug("========ֵ������Ϣ���´���ʼ========");
		
		IGDUT0101Form form = dto.getIgDUT0101Form();
		User user = dto.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd;HH:mm");
		//����ֵ������
		DutyAuditDefTB dtb = new DutyAuditDefTB();
		dtb.setDadid(form.getDadid());
		dtb.setDadcategory(form.getDadcategory());
		dtb.setDadtype(form.getDadtype());
		dtb.setDadname(form.getDadname());
		dtb.setDadlimtime(form.getDadlimtime());
		dtb.setDadcontent(form.getDadcontent());
		dtb.setDadinfo(form.getDadinfo());
		dtb.setDadstatus(form.getDadstatus());
		
		dtb.setDaduserid(user.getUserid());
		dtb.setDadusername(user.getUsername());
		dtb.setDadupdtime(IGStringUtils.getCurrentDateTime());
		dtb.setDadorderby(form.getDadorderby());
		//20120406 byf start
		dtb.setPeriodType(form.getPeriodType());//��������
		
		//����ʱ��
		if("day".equalsIgnoreCase(form.getPeriodType())){
			
		}else if("week".equalsIgnoreCase(form.getPeriodType())){
			dtb.setPeriodValue(form.getWeek_value());
		}else if("month".equalsIgnoreCase(form.getPeriodType())){
			dtb.setPeriodValue(form.getMonth_value());
		}else if("quarter".equalsIgnoreCase(form.getPeriodType())){
			if("one".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="one,01/"+form.getQuarter_dayValue()+","+"04/"+form.getQuarter_dayValue()+","
				+"07/"+form.getQuarter_dayValue()+","+"10/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
			if("two".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="two,02/"+form.getQuarter_dayValue()+","+"05/"+form.getQuarter_dayValue()+","
				+"08/"+form.getQuarter_dayValue()+","+"12/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
			if("three".equalsIgnoreCase(form.getQuarter_monthValue())){
				String periodValue="three,03/"+form.getQuarter_dayValue()+","+"06/"+form.getQuarter_dayValue()+","
				+"09/"+form.getQuarter_dayValue()+","+"12/"+form.getQuarter_dayValue();
				dtb.setPeriodValue(periodValue);
			}
		}
		//20120406 byf end
		DutyAuditDef dutyAuditDef = this.dutyAuditDefBL.updateDutyAuditDef(dtb);
		dto.setDutyAuditDef(dutyAuditDef);	
		
		//����ֵ����ʱ��
		String[] dattimes = form.getDattimes();//���ʱ��
		String dadlimtime = form.getDadlimtime();//�ʱ������
		if(dattimes!=null){
			//ɾ�����оɵ�DutyAuditTimeTB���еļ�¼��dadid==dutyAuditDef.getDadid()��
			DutyAuditTimeSearchCondImpl cond = new DutyAuditTimeSearchCondImpl();
			cond.setDadid(dutyAuditDef.getDadid());
			List<DutyAuditTime> datList  = dutyAuditTimeBL.searchDutyAuditTime(cond, 0, 0);
			for(DutyAuditTime dat:datList){
				dutyAuditTimeBL.deleteDutyAuditTime(dat.getDatid());
			}
			
			//�����µĹ�����¼
			for(int i=0,j=dattimes.length;i<j;i++){
				String hour = dattimes[i].split(":")[0];
				String min = dattimes[i].split(":")[1];
				DutyAuditTimeTB dat = new DutyAuditTimeTB();
				dat.setDadid(dutyAuditDef.getDadid());
				dat.setDattime(dattimes[i]);
				
				//��������ʱ��
				Calendar c = Calendar.getInstance();
				c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), Integer.valueOf(hour), 
						Integer.valueOf(min));
				c.add(Calendar.MINUTE, Integer.valueOf(dadlimtime));
				dat.setDatlimtime(sdf.format(c.getTime()).split(";")[1]);
				dutyAuditTimeBL.registDutyAuditTime(dat);
			}
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ֵ��������Ϣ") );
		
		log.debug("========ֵ������Ϣ���´�������========");
		return dto;
	}


	/**
	 * ֵ��������������ʾ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGDUT01DTO initDutyAuditDef(IGDUT01DTO dto) throws BLException {

		log.debug("========ֵ�����������������ʾ����ʼ========");	
		IGDUT0101Form form = dto.getIgDUT0101Form();
		DutyAuditDef dad = dutyAuditDefBL.searchDutyAuditDefByKey(form.getDadid());
		if ( dad == null ){
			throw new BLException("IGCO10000.E004","ֵ�������趨");
		}
		
		//������ʾ�趨
		
		form.setDadid(dad.getDadid());
		form.setDadcategory(dad.getDadcategory());
		form.setDadtype(dad.getDadtype());
		form.setDadname(dad.getDadname());
		form.setDadlimtime(dad.getDadlimtime());
		form.setDadcontent(dad.getDadcontent());
		form.setDadinfo(dad.getDadinfo());
		form.setDadstatus(dad.getDadstatus());
		form.setDadorderby(dad.getDadorderby());
		form.setMode("1");
		form.setPeriodType(dad.getPeriodType());
		if("day".equalsIgnoreCase(dad.getPeriodType())){
			
		}else if("week".equalsIgnoreCase(dad.getPeriodType())){
			form.setWeek_value(dad.getPeriodValue());
		}else if("month".equalsIgnoreCase(dad.getPeriodType())){
			form.setMonth_value(dad.getPeriodValue());
		}else if("quarter".equalsIgnoreCase(dad.getPeriodType())){
			if("one".equalsIgnoreCase(dad.getPeriodValue().split(",")[0])){
				form.setQuarter_monthValue("one");
			}else if("two".equalsIgnoreCase(dad.getPeriodValue().split(",")[0])){
				form.setQuarter_monthValue("two");
			}else if("three".equalsIgnoreCase(dad.getPeriodValue().split(",")[0])){
				form.setQuarter_monthValue("three");
			}
			form.setQuarter_dayValue(dad.getPeriodValue().split(",")[1].split("/")[1]);
		}
		

		dto.setIgDUT0101Form(form);
		
		log.debug("========ֵ�����������������ʾ��������========");
		return dto;
	}



	
	/**
	 * ֵ������Ϣ��ѯ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGDUT01DTO searchDutyAuditDefAction(IGDUT01DTO dto) throws BLException {

		log.debug("========ֵ������Ϣ��ѯ����ʼ========");
		
		//ֵ������Ϣ��ѯ����ȡ�� 
		int totalCount = this.dutyAuditDefBL.getSearchCount(dto.getDutyAuditDefSearchCond());
		
		if (totalCount == 0) {
			log.debug("========ֵ������Ϣ��ѯ���ݲ�����========");
			//ֵ������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ֵ������Ϣ��ѯ���ݼ�������========");
			//ֵ������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<DutyAuditDef> dutyAuditList = this.dutyAuditDefBL.searchDutyAuditDef(dto.getDutyAuditDefSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setDutyAuditList(dutyAuditList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========ֵ������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ֵ��״̬�ر�/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGDUT01DTO changeDutyAuditDefAction(IGDUT01DTO dto) throws BLException {
		log.debug("========ֵ��״̬�ر�/���ô���ʼ========");
		IGDUT0102Form form = dto.getIgDUT0102Form();
		
		DutyAuditDef rai = this.dutyAuditDefBL.searchDutyAuditDefByKey(form.getDadid());
		
		//���ƶ���
		DutyAuditDefTB pdTB = (DutyAuditDefTB)SerializationUtils.clone(rai);
		
		if(IGDUTCONSTANTS.DUTY_STATUS_ENABLE.equals(form.getDadstatus())) {
			pdTB.setDadstatus(IGDUTCONSTANTS.DUTY_STATUS_DISABLE);//�ر�
			log.debug("========�ر�========");
			dto.addMessage(new ActionMessage( "IGCO10000.I008", "") );
		} else if(IGDUTCONSTANTS.DUTY_STATUS_DISABLE.equals(form.getDadstatus())) {
			pdTB.setDadstatus(IGDUTCONSTANTS.DUTY_STATUS_ENABLE);//����
			log.debug("========����========");
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "") );
		}
		this.dutyAuditDefBL.updateDutyAuditDef(pdTB);
		log.debug("========ֵ������Ϣ�ر�/���ô�������========");
		return dto;
	}
	


}
