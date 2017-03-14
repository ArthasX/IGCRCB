/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM2814ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;

/**
 * @����������1.������ѯ����������� 2.������Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/23
 * 
 * @Version V1.0
 */
public class IGASM2814ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM2814ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGASM2814ExcelBLImpl.class);
	/** ����syscondingĬ��ֵ */
	protected static final String SYSCODE = "999018";

	/** ������ʲ���ѯ */
	protected CheckItemVWBL checkItemVWBL;

	/**
	 * ������ʲ���ѯ�趨
	 * 
	 * @param checkItemVWBL
	 *            ������ʲ���ѯ
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================������ѯ�����������ʼ=================");
		// ʵ����DTO
		IGASM2814ExcelDTO exceldto = (IGASM2814ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<CheckItemVWInfo> itemList = exceldto.getItemList();
		// д�������Ԫ��
		if (itemList != null && itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				// ��ȡ���̶���
				CheckItemVWInfo info = itemList.get(i);
				// ����������
				addCell(0, i, info.getRiskly());
				// ����������
				addCell(1, i, info.getRiskarea());
				// ��������
				addCell(2, i, info.getRiskitem());
				// �����
				addCell(3, i, info.getEilabel());
				// �����յ�����
				addCell(4, i, info.getEiname());
				// �����յ�˵��
				addCell(5, i, info.getEidesc());
				// ��������
				addCell(6, i, info.getMguserid());
				// ���Ǽ���
				addCell(7, i, info.getEiinsdate());
				// ��佨����Ƶ��
				addCell(8, i, info.getCheckfrequency());
			}
		}
		log.debug("=================������ѯ��������������=================");
		return dto;
	}

	/**
	 * ������Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto)
			throws BLException {

		IGASM2814Form form = dto.getIgasm2814form();
		/** ������ѯ�����趨 */
		CheckItemVWSearchCondImpl cond = new CheckItemVWSearchCondImpl();
		cond.setEiname(form.getEiname());
		cond.setManagername(form.getMguserid());
		cond.setBh(form.getEilabel());
		cond.setCheckfrequency(form.getCheckfrequency());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		/** �趨���շ��� syscoding�� */
		if (null == form.getSyscoding() || "".equals(form.getSyscoding())) {
			cond.setSyscoding(SYSCODE);
		} else {
			cond.setSyscoding(form.getSyscoding());
		}
		/** ������ʲ���ѯ */
		List<CheckItemVWInfo> itemList = this.checkItemVWBL.searchCheckItemVW(
				cond, 0, 0);
		/** ��ѯ�����set��dto */
		dto.setItemList(itemList);
		return dto;
	}
}
