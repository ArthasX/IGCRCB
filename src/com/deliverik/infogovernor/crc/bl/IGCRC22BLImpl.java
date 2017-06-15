/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2201BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201CondImpl;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * ����:�������ͳ���߼��ӿ�ʵ��
 * ������¼��yukexin    2014-8-15 ����5:11:24	
 * �޸ļ�¼��null
 */	
public class IGCRC22BLImpl extends BaseBLImpl implements IGCRC22BL {

	static Log log = LogFactory.getLog(IGCRC22BLImpl.class);

	/** �������ͳ��BL�ӿ� */
	protected IGCRC2201BL igcrc2201BL;

	public IGCRC2201BL getIgcrc2201BL() {
		return igcrc2201BL;
	}

	public void setIgcrc2201BL(IGCRC2201BL igcrc2201bl) {
		igcrc2201BL = igcrc2201bl;
	}



	/**
	 * �������ͳ�Ʋ�ѯ����
	 * 
	 * @param igcrc22dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC2201DTO searchEntityItemAction(IGCRC2201DTO dto) throws BLException {

		log.debug("==============================�������ͳ�Ʋ�ѯ��ʼ==============================");
		IGCRC2201Form form = dto.getIgcrc2201Form();
		IGCRC2201CondImpl cond = new IGCRC2201CondImpl();
		//��ѯ��������cond
		cond = copyProperties(form, cond);
		//��ѯ����
		List<IGCRC2201VWInfo> list = igcrc2201BL.searchIncidentTypeData(cond);
		IGCRC2202VO igcrc2202vo = null;
		@SuppressWarnings("serial")
		//�������ͳ�ʼ��
		Map<String, String> typeMap = new HashMap<String, String>(){
			{
				put("110001","ϵͳ������");
				put("110002","Ӧ�ó�����");
				put("110003","��Ŀ��");
				put("110004","������");
			}
		};
		//���ָ�ʽ������
		NumberFormat nf = NumberFormat.getPercentInstance();
		//С����1λ
		nf.setMaximumFractionDigits(1);
		//ͨ����
		double pass = 0;
		//�ɹ���
		double success = 0;
		//���ص�List
		List<IGCRC2202VO> igcrc2202voList = new ArrayList<IGCRC2202VO>();
		//����ѯ�����ݼ���֮����벢����
		for (IGCRC2201VWInfo igcrc2201vwInfo : list) {
			//�����������С��4��ִ��
			if(list.size() < 4){
				//ѭ���趨�õ�map
				for(Map.Entry<String, String> entry : typeMap.entrySet()){
					//�����������������趨�õ�map typeId��ͬ ����ֵ �ÿ�,��Ϊ��־
					if(igcrc2201vwInfo.getTypeId().equals(entry.getKey())){
						entry.setValue("");
					}
				}
			}
			//���ݸ���
			igcrc2202vo = new IGCRC2202VO();
			igcrc2202vo.setTypeId(igcrc2201vwInfo.getTypeId());
			igcrc2202vo.setTypeName(igcrc2201vwInfo.getTypeName());
			igcrc2202vo.setPassnum(igcrc2201vwInfo.getPassnum());
			igcrc2202vo.setSuccessnum(igcrc2201vwInfo.getSuccessnum());
			igcrc2202vo.setTotalnum(igcrc2201vwInfo.getTotalnum());
			//����ͨ����
			pass = new Double(igcrc2201vwInfo.getPassnum())/igcrc2201vwInfo.getTotalnum();
			//����0 ���ʽ��
			igcrc2202vo.setPassrate(pass == 0 ? "0" : nf.format(pass));
			//����ɹ���
			success = new Double(igcrc2201vwInfo.getSuccessnum())/igcrc2201vwInfo.getTotalnum();
			//����0 ���ʽ��
			igcrc2202vo.setSuccessrate(success == 0 ? "0" : nf.format(success));
			igcrc2202voList.add(igcrc2202vo);
		}
		//�����������С��4��ִ��
		if(list.size() < 4){
			//��ӿ�������
			for(Map.Entry<String, String> entry : typeMap.entrySet()){
				//���ֵ��Ϊ����Ӵ���
				if(!"".equals(entry.getValue())){
					igcrc2202voList.add(new IGCRC2202VO(entry.getKey(), entry.getValue(), 0, 0, "0", 0, "0"));
				}
			}
		}
		//���ݰ�typeId����
		Collections.sort(igcrc2202voList, new Comparator<IGCRC2202VO>() {
			public int compare(IGCRC2202VO o1, IGCRC2202VO o2) {
				return new Integer(Integer.parseInt(o1.getTypeId()))
						.compareTo(Integer.parseInt(o2.getTypeId()));
			}
		});
		dto.setIgcrc2202voList(igcrc2202voList);
		log.debug("==============================�������ͳ�Ʋ�ѯ����==============================");
		return dto;
	}

	/**	
	 * ���ܣ���form�еĲ�ѯ��������cond
	 * @param form ҳ���ѯ����
	 * @param cond ��������
	 * @return
	 * �޸ļ�¼��
	 */	
	private IGCRC2201CondImpl copyProperties(IGCRC2201Form form, IGCRC2201CondImpl cond){
		//��
		cond.setYear(form.getYear());
		//��
		cond.setMonth(form.getMonth());
		return cond;
	}
}
