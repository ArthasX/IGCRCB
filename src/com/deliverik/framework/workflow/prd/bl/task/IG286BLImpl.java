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
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG286DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;

/**
 * <p>����:���̼�����ҵ���߼�</p>
 * <p>����������1.������������</p>
 * <p>          2.��¼����</p>
 * <p>          3.ɾ������</p>
 * <p>          4.������������</p>
 * <p>������¼��</p>
 */

public class IG286BLImpl extends BaseBLImpl implements IG286BL{
	
	/** IG286 DAO */
	protected IG286DAO ig286DAO;
	
	/**
	 * �����¼�����DAO
	 * 
	 * @param ig286DAO IG286DAO
	 */
	public void setIg286DAO(
			IG286DAO ig286DAO) {
		this.ig286DAO = ig286DAO;
	}

	/**
	 * ���ܣ���ȡ���̱�������ʵ��
	 * @return IG286TB
	 */
	
	public IG286TB getIG286TBInstance(){
		return new IG286TB();
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond, int start, int count) {
		List<IG286Info> processLinkageDefList = ig286DAO.findByCond(cond, 0, 0);
		return processLinkageDefList;
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond) {
		List<IG286Info> processLinkageDefList = ig286DAO.findByCond(cond, 0, 0);
		return processLinkageDefList;
	}

	/**
	 * ���ܣ���¼����
	 * 
	 * @param IG286Info ��¼����
	 * @return IG286 ���̼�������Ϣ
	 * @throws BLException
	 */
	public IG286Info insertIG286Info(
			IG286Info processLinkageDef) throws BLException{
		//��������ļ��������ݿ����Ƿ����
		IG286SearchCondImpl cond = new IG286SearchCondImpl();
		cond.setInitiativepidid(processLinkageDef.getInitiativepidid());
		cond.setPassivitypidid(processLinkageDef.getPassivitypidid());
		List<IG286Info> processLinkageDefList = ig286DAO.findByCond(cond, 0, 0);
		if(processLinkageDefList.size()>0){
			if(processLinkageDefList.get(0).getInitiativepidid().equals(processLinkageDef.getInitiativepidid())&&processLinkageDefList.get(0).getPassivitypidid().equals(processLinkageDef.getPassivitypidid())){
				throw new BLException("IGCO10000.E024", "");
			}
		}
		return ig286DAO.save(processLinkageDef);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param IG286 ���̼�������Ϣ
	 */
	public void deleteIG286Info(
			IG286Info ig286Info) {
		ig286DAO.delete(ig286Info);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param plid ���̼���������
	 * @return IG286 ���̼�������Ϣ
	 */
	public IG286Info searchIG286InfoByPk(String plid) {
		return ig286DAO.findByPK(plid);
	}
	
	/**
	 * PLID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PLID����ֵ
	 */
	public String getPlidSequenceNextValue(String pdid) {
		return ig286DAO.getPlidSequenceNextValue(pdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG286SearchCondImpl cond = new IG286SearchCondImpl();
		cond.setPlid_like(pdid);
		List<IG286Info> lst_IG286Info = this.searchIG286Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG286>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG286Info != null) {
			for(IG286Info info : lst_IG286Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPlid()) ? "" : IGStringUtils.filterXMLStr(info.getPlid()));
				sbf_xml.append("</PLID>");
				sbf_xml.append("<PLDPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPldpdid()) ? "" : IGStringUtils.filterXMLStr(info.getPldpdid()));
				sbf_xml.append("</PLDPDID>");
				sbf_xml.append("<PLDACTIONID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPldactionid()) ? "" : IGStringUtils.filterXMLStr(info.getPldactionid()));
				sbf_xml.append("</PLDACTIONID>");
				sbf_xml.append("<INITIATIVEPIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getInitiativepidid()) ? "" : IGStringUtils.filterXMLStr(info.getInitiativepidid()));
				sbf_xml.append("</INITIATIVEPIDID>");
				sbf_xml.append("<PASSIVITYPIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPassivitypidid()) ? "" : IGStringUtils.filterXMLStr(info.getPassivitypidid()));
				sbf_xml.append("</PASSIVITYPIDID>");
				sbf_xml.append("<PLDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPldesc()) ? "" : IGStringUtils.filterXMLStr(info.getPldesc()));
				sbf_xml.append("</PLDESC>");
				sbf_xml.append("<PLBLNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPlblname()) ? "" : IGStringUtils.filterXMLStr(info.getPlblname()));
				sbf_xml.append("</PLBLNAME>");
				sbf_xml.append("<PLJSEVENT>");
				sbf_xml.append(StringUtils.isEmpty(info.getPljsevent()) ? "" : IGStringUtils.filterXMLStr(info.getPljsevent()));
				sbf_xml.append("</PLJSEVENT>");
				sbf_xml.append("<PLJTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPljtype()) ? "" : IGStringUtils.filterXMLStr(info.getPljtype()));
				sbf_xml.append("</PLJTYPE>");
				sbf_xml.append("<INITIATIVEPIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getInitiativepidname()) ? "" : IGStringUtils.filterXMLStr(info.getInitiativepidname()));
				sbf_xml.append("</INITIATIVEPIDNAME>");
				sbf_xml.append("<PASSIVITYPIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPassivitypidname()) ? "" : IGStringUtils.filterXMLStr(info.getPassivitypidname()));
				sbf_xml.append("</PASSIVITYPIDNAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG286>");
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
		List<IG286Info> lst_IG286 = new ArrayList<IG286Info>();
		IG286TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG286TBInstance();
			entity.setPlid(e.getChildText("PLID"));
			entity.setPldpdid(e.getChildText("PLDPDID"));
			entity.setPldactionid(e.getChildText("PLDACTIONID"));
			entity.setInitiativepidid(e.getChildText("INITIATIVEPIDID"));
			entity.setPassivitypidid(e.getChildText("PASSIVITYPIDID"));
			entity.setPldesc(e.getChildText("PLDESC"));
			entity.setPlblname(e.getChildText("PLBLNAME"));
			entity.setPljsevent(e.getChildText("PLJSEVENT"));
			entity.setPljtype(e.getChildText("PLJTYPE"));
			entity.setInitiativepidname(e.getChildText("INITIATIVEPIDNAME"));
			entity.setPassivitypidname(e.getChildText("PASSIVITYPIDNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG286.add(entity);
		}
		this.ig286DAO.saveOrUpdateAll(lst_IG286);
	}
	
}
