package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.asset.bl.task.IG343BL;
import com.deliverik.infogovernor.asset.bl.task.IG344BL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCondImpl;

/**
 * �����¼ͳ��ҵ���߼�ʵ��
 *
 */
public class IGASM25BLImpl extends BaseBLImpl implements IGASM25BL {

	static Log log = LogFactory.getLog(IGASM25BLImpl.class);

	/** �����¼ͳ��BL */
	private IG343BL ig343BL;
	
	/** �����¼��ϸBL */
	private IG344BL ig344BL;
	
	/** �ʲ���ϢBL */
//	private IG013BL ig013BL;
	protected SOC0118BL soc0118BL;
	

    /**
     * �ʲ���ϢBL�趨
     *
     * @param soc0118BL soc0118BL
     */
    public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	/**
     * �����¼ͳ��BL�趨
     *
     * @param ig343bl ig343BL
     */
    public void setIg343BL(IG343BL ig343bl) {
        ig343BL = ig343bl;
    }


    /**
     * �����¼��ϸBL�趨
     *
     * @param ig344bl ig344BL
     */
    public void setIg344BL(IG344BL ig344bl) {
        ig344BL = ig344bl;
    }


    /**
	 * �����¼ͳ����Ϣ��ѯ����
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM25DTO searchEntityItemRelationVW(IGASM25DTO dto)
			throws BLException {
		log.debug("========�����¼ͳ����Ϣ��ѯ����ʼ========");
		//����������ѯ����
		IG343SearchCondImpl cond = new IG343SearchCondImpl();
		//���ò�ѯ����
		cond.setEiname_like(dto.getEiname_like());//����������
		cond.setBeginTime_q(dto.getBeginTime_q());//�����¼��ʼʱ��
		cond.setEndTime_q(dto.getEndTime_q());//�����¼��ֹʱ��
		List<IG343Info> entityItemRelationVWInfoList = ig343BL.searchIG343(cond, 0, 0);
		int sbSumCount = 0;//�豸�ʲ�����
		int yySumCount = 0;//Ӧ���ʲ�����
		int pxSumCount = 0;//��ѵ��¼����
		int hjSumCount = 0;//�ϼƴ�������
		//ѭ��ͳ�ƹ���
		for(IG343Info info :entityItemRelationVWInfoList){
			sbSumCount += info.getCivalue();
			yySumCount += info.getCivalue2();
			pxSumCount += info.getEiname3();
			hjSumCount += info.getSumcount();
		}
		//��ֵ���浽dto��
		dto.setSbSumCount(sbSumCount);
		dto.setYySumCount(yySumCount);
		dto.setPxSumCount(pxSumCount);
		dto.setHjSumCount(hjSumCount);
		dto.setEntityItemRelationVWInfoList(entityItemRelationVWInfoList);
		log.debug("========�����¼ͳ����Ϣ��ѯ�������========");
		return dto;
	}
	
	/**		
	 * �����¼��ϸ��Ϣ��ѯ����		
	 *		
	 * @param dto IGASM20DTO		
	 * @return IGASM20DTO		
	 */		
	public IGASM25DTO searchEntityItemRelationDetailVW(IGASM25DTO dto)		
			throws BLException {
		log.debug("========�����¼ͳ����Ϣ��ѯ����ʼ========");	
		//��ѯ����������
		SOC0118Info item = soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgasm2502Form().getEiid_q()));
		//����������ѯ����	
		IG344SearchCondImpl cond = new IG344SearchCondImpl();	
		//���ò�ѯ����	
		cond.setBeginTime_q(dto.getIgasm2502Form().getBeginTime());//�����¼��ʼʱ��	
		cond.setEndTime_q(dto.getIgasm2502Form().getEndTime());//�����¼��ֹʱ��	
		cond.setEiid_q(dto.getIgasm2502Form().getEiid_q());//������id	
		List<IG344Info> entityItemRelationDetailVWInfoList = ig344BL.searchIG344(cond, 0, 0);	
		int fwcsSumCount = 0;//��������ۼ�	
		double fwpjfSumStore = 0;//����ƽ�����ۼ�	
		
		for(IG344Info info :entityItemRelationDetailVWInfoList){	
			fwcsSumCount += 1;
			fwpjfSumStore += info.getCivalue3();
		}	
		//��ֵ���浽dto��	
		dto.setFwcsSumCount(fwcsSumCount);	
		dto.setFwpjfSumStore(fwpjfSumStore);	
		dto.setEiname_like(item.getEiname());	
		dto.setEntityItemRelationDetailVWInfo(entityItemRelationDetailVWInfoList);	
		log.debug("========�����¼ͳ����Ϣ��ѯ�������========");	
		return dto;	
	}


}
