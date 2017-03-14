/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM0901ExcelDTO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
/**
 * 
 * ����: ��������Ϣ�����߼�ʵ��
 * ��������: ��������Ϣ�����߼�ʵ��
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼:
 */
public class IGASM0901ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM0901ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		IGASM0901ExcelDTO exceldto = (IGASM0901ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);

		// ������������ȡ��
		List<EntityItemFacilitatorVWInfo> list = exceldto.getEntityItemFacilitatorList();
		// д�������Ԫ��
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				//��������Ϣ����ȡ��
				EntityItemFacilitatorVWInfo info=list.get(i);
				
				//��˾����
				addCell(0, i, info.getEiname());
				//��ַ
				addCell(1, i, info.getAddress());
				//��ϵ��
				addCell(2, i, info.getLinkman());
				//�绰
				addCell(3, i, info.getTel());
				//������
				addCell(4, i, info.getAccountbk());
				//�����ʺ�
				addCell(5, i, info.getAccountno());
				//��������
				addCell(6, i, info.getAccountname());
			}
		}
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return dto;
	}

}
