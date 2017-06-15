/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG273DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * <p>����:����״̬ԾǨ����ҵ���߼�ʵ��</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.ȫ����������</p>
 * <p>          5.��������</p>
 * <p>          6.ɾ������(����)</p>
 * <p>          7.ɾ������</p>
 * <p>          8.�������</p>
 * <p>          9.����״̬ԾǨ������Ϣ���ڼ��</p>
 * <p>          10.��ȡ��������Ϣʵ��</p>
 * <p>������¼��</p>
 */
public class IG273BLImpl extends BaseBLImpl implements IG273BL {
	
	/** ����״̬ԾǨ����DAO���� */
	protected IG273DAO ig273DAO;

	/**
	 * ���ܣ���������״̬ԾǨ����DAO
	 * 
	 * @param ig273DAO ����״̬ԾǨ����DAO
	 */
	public void setIg273DAO(
			IG273DAO ig273DAO) {
		this.ig273DAO = ig273DAO;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG273InfoSearchCount(IG273SearchCond cond) {
		return ig273DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param ptdid ����״̬ԾǨ����ID
	 * @return ����״̬ԾǨ������Ϣ
	 * @throws BLException 
	 */
	
	public IG273Info searchIG273InfoByKey(String ptdid) throws BLException {
		return checkExistIG273Info(ptdid);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273Info(
			IG273SearchCond cond, int start, int count) {
		return ig273DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273Info(IG273SearchCond cond) {
		return ig273DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273InfoAll() {
		return ig273DAO.findAll();
	}
	
	

	/**
	 * ���ܣ���������
	 * 
	 * @param IG273Info ��������
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	
	public IG273Info registIG273Info(
			IG273Info ig273Info) throws BLException {
		return ig273DAO.save(ig273Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param ptdid ɾ������״̬ԾǨ��������
	 * @throws BLException 
	 */
	
	public void deleteIG273InfoByKey(String ptdid) throws BLException {
		IG273Info processTransitionDef = checkExistIG273Info(ptdid);
		ig273DAO.delete(processTransitionDef);
	}
	
	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param ig273Info ɾ������״̬ԾǨ������Ϣ
	 * @throws BLException 
	 */
	
	public void deleteIG273Info(IG273Info ig273Info) throws BLException {
		ig273DAO.delete(ig273Info);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param ig273Info �������
	 * @return ����״̬ԾǨ����
	 * @throws BLException 
	 */
	
	public IG273Info updateIG273Info(
			IG273Info ig273Info) throws BLException {
		return ig273DAO.save(ig273Info);
	}
	
	/**
	 * ���ܣ�����״̬ԾǨ������Ϣ���ڼ��
	 * 
	 * @param ptdid ����״̬ԾǨ����ID
	 * @return ����״̬ԾǨ����
	 * @throws BLException 
	 */
	
	protected IG273Info checkExistIG273Info(String ptdid) throws BLException{
		IG273Info info = ig273DAO.findByPK(ptdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����״̬ԾǨ�������");
		}
		return info;
	}
	
	/**
	 * ���ܣ���ȡ��������Ϣʵ��
	 * 
	 * @return ������
	 */
	
	public IG273TB getIG273TBInstance() {
		return new IG273TB();
	}
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String psdid) {
		return ig273DAO.getPtdidSequenceNextValue(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG273SearchCondImpl cond = new IG273SearchCondImpl();
		cond.setPtdid_like(pdid);
		List<IG273Info> lst_IG273Info = this.searchIG273Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG273>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG273Info != null) {
			for(IG273Info info : lst_IG273Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdid()) ? "" : IGStringUtils.filterXMLStr(info.getPtdid()));
				sbf_xml.append("</PTDID>");
				sbf_xml.append("<FPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getFpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getFpsdid()));
				sbf_xml.append("</FPSDID>");
				sbf_xml.append("<TPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getTpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getTpsdid()));
				sbf_xml.append("</TPSDID>");
				sbf_xml.append("<PTDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdname()) ? "" : IGStringUtils.filterXMLStr(info.getPtdname()));
				sbf_xml.append("</PTDNAME>");
				sbf_xml.append("<PTDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPtddesc()));
				sbf_xml.append("</PTDDESC>");
				sbf_xml.append("<PTDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdtype()) ? "" : IGStringUtils.filterXMLStr(info.getPtdtype()));
				sbf_xml.append("</PTDTYPE>");
				sbf_xml.append("<PTDCOND>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdcond()) ? "" : IGStringUtils.filterXMLStr(info.getPtdcond()));
				sbf_xml.append("</PTDCOND>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG273>");
		return sbf_xml;
	}
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG273Info> lst_IG273 = new ArrayList<IG273Info>();
		IG273TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG273TBInstance();
			entity.setPtdid(e.getChildText("PTDID"));
			entity.setFpsdid(e.getChildText("FPSDID"));
			entity.setTpsdid(e.getChildText("TPSDID"));
			entity.setPtdname(e.getChildText("PTDNAME"));
			entity.setPtddesc(e.getChildText("PTDDESC"));
			entity.setPtdtype(e.getChildText("PTDTYPE"));
			entity.setPtdcond(e.getChildText("PTDCOND"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG273.add(entity);
		}
		this.ig273DAO.saveOrUpdateAll(lst_IG273);
	}

}
