/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Attribute;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG380DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>
 * ���̶���ҵ���߼�ʵ��
 * </p>
 */

public class IG380BLImpl extends BaseBLImpl implements IG380BL {
	
	/**���̶������*/
	protected IG380DAO ig380DAO;
	
	/**
	 * �������̶������
	 * @param ig380DAO ig380DAO
	 */
	public void setIg380DAO(IG380DAO ig380DAO) {
		this.ig380DAO = ig380DAO;
	}

	/**
	 * ��ȡ���̶���ʵ��
	 * 
	 * @return ProcessDefinitionTB
	 * @throws BLException
	 */
	
	public IG380TB getIG380TBInstance(){
		return new IG380TB();
	}
	
	
	/**
	 * ��������ģ��ID��ȡ���̶��弯��
	 * @param processTemplateId ����ģ��ID
	 * @return  List<ProcessDefinition>
	 */
	
	public List<IG380Info> searchIG380InfoByPtid(Integer processTemplateId){
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPtid(processTemplateId);
		cond.setPdstatus("a");
		return ig380DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * �������̶���ID��ȡ���̶���
	 * @param pdid ���̶���ID
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	public IG380Info searchIG380InfoByKey(String pdid) throws BLException {
		checkExistIG380Info(pdid);
		return ig380DAO.findByPK(pdid);
	}
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchLastCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchLastCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ�����̶�����ʷ��Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchHistoryCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchHistoryCount(cond);
	}
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond){
		
		return ig380DAO.findByCond(cond,0,0);
	}
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchLastIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findLastByCond(cond,start,count);
	}
	
	/**
	 * ���ݼ�������ȡ����ط�����Զ����������͵���Ϣ
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond) {
	    
	    return ig380DAO.relevantProcessfindByCond(cond);
	}
	
	/**
     * ���ݼ�������ȡ��ȱʡȨ�޵���ط�����Զ����������͵���Ϣ
     * 
     * @param cond ���̶����������
     * @return ���̶�����Ϣ�б�
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond) {
        
        return ig380DAO.relevantProcessfindByCondDefault(cond);
    }
	
	/**
	 * ���ݼ�������ȡ�����̶�����ʷ��Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchHistoryIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findHistoryByCond(cond,start,count);
	}
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findByCond(cond,start,count);
	}
	
	/**
	 * ���̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return ���̶���
	 */
	public IG380Info registIG380Info(IG380Info ig380Info) throws BLException{
		if(ig380Info == null) {
			throw new BLException("IGCO10000.E004","���̶������");
		}
		checkNotExistIG380Info(ig380Info.getPtid(), ig380Info.getPdname());
		return ig380DAO.save(ig380Info);
	}

	/**
	 * ɾ�����̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380Info(IG380Info ig380Info) throws BLException{
		IG380Info pd = checkExistIG380Info(ig380Info.getPdid());
		ig380DAO.delete(pd);
	}
	
	/**
	 * ɾ�����̶�����Ϣ
	 * 
	 * @param pdid ���̶�������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380InfoByKey(String pdid) throws BLException{
		IG380Info processDefinition = checkExistIG380Info(pdid);
		ig380DAO.delete(processDefinition);
	}

	/**
	 * �������̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return ���̶���
	 * @throws BLException
	 */
	public IG380Info updateIG380Info(IG380Info ig380Info) throws BLException{
		
		checkExistIG380Info(ig380Info.getPdid());
		return ig380DAO.save(ig380Info);
	}

	/**
	 * ���̶�����ڼ��
	 * 
	 * @param pdid ���̶���ID
	 * @return ���̶���
	 * @throws BLException 
	 */
	protected IG380Info checkExistIG380Info(String pdid) throws BLException{
		IG380Info info = ig380DAO.findByPK(pdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̻���");
		}
		return info;
	}
	
	
	/**
	 * ���̶��岻���ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @param pdname ���̶�������
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG380Info(Integer ptid, String pdname) throws BLException{
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdname(pdname);
		cond.setPtid(ptid);
		List<IG380Info> infoList = ig380DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGCO10000.E021","���̻���");
		}
	}
	
	/**
	 * �����û�ID��ȡ���û���������̶�����Ϣ����б�
	 * @param userid �û�ID
	 * @param pdstatus �Զ�������״̬
	 * @return ���̶�����Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionByUserId(String userid, String pdstatus){
		return ig380DAO.findSelfDefinitionByUserId(userid, pdstatus);
	}
	
	/**
	 * �����û�ID��ȡ���û���������̶�����Ϣ����б�(��ά�ƻ���)
	 * @return ���̶�����Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionAll(){
		return ig380DAO.findSelfDefinitionAll();
	}
	
	/**
	 * �����û�ID��ȡ���û����̶�����Ϣ����б�
	 * @param userid �û�ID
	 * @return ������Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(String userid, Integer ptid
			, String pdstatus){
		UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
		cond.setUserid(userid);
		return ig380DAO.findSelfDefinitionByUserIdCom(cond, ptid, pdstatus);
	}
	
	/**
	 * ���̶�������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getPdidNextValue(String firstsite,String pdsequence) {
		return ig380DAO.getPdidSequenceNextValue(firstsite,pdsequence);
	}
	
	/**
	 * ���̶������洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public String upgradeProcessDefVersion(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶������");
		}
		return ig380DAO.upgradeProcessDefVersion(pdid);
	}
	
	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 * @param pdsequence ���ж���
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶������");
		}
		return ig380DAO.copyProcessDefVersion(pdid,pdsequence);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG380Info ig380 = this.searchIG380InfoByKey(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG380>");
		sbf_xml.append("<DATALIST>");
		sbf_xml.append("<DATA>");
		if(ig380 != null) {
			sbf_xml.append("<PDID>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdid()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdid()));
			sbf_xml.append("</PDID>");
			sbf_xml.append("<PTID>");
			sbf_xml.append(ig380.getPtid() == null ? "" : ig380.getPtid());
			sbf_xml.append("</PTID>");
			sbf_xml.append("<PDNAME>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdname()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdname()));
			sbf_xml.append("</PDNAME>");
			sbf_xml.append("<PDDESC>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPddesc()) ? "" : IGStringUtils.filterXMLStr(ig380.getPddesc()));
			sbf_xml.append("</PDDESC>");
			sbf_xml.append("<PDCRTDATE>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdcrtdate()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdcrtdate()));
			sbf_xml.append("</PDCRTDATE>");
			//Ĭ��ͣ��״̬
			sbf_xml.append("<PDSTATUS>");
			sbf_xml.append(IGPRDCONSTANTS.PD_STATUS_DISABLE);
			sbf_xml.append("</PDSTATUS>");
			sbf_xml.append("<PDXML>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdxml()) ? "" : ig380.getPdxml());
			sbf_xml.append("</PDXML>");
			sbf_xml.append("<PERMISSION>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPermission()) ? "" : IGStringUtils.filterXMLStr(ig380.getPermission()));
			sbf_xml.append("</PERMISSION>");
			sbf_xml.append("<FINGERPRINT>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(ig380.getFingerPrint()));
			sbf_xml.append("</FINGERPRINT>");
			sbf_xml.append("<SERIALGENERATOR>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getSerialgenerator()) ? "" : IGStringUtils.filterXMLStr(ig380.getSerialgenerator()));
			sbf_xml.append("</SERIALGENERATOR>");
			sbf_xml.append("<PDACTNAME>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdactname()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdactname()));
            sbf_xml.append("</PDACTNAME>");
            sbf_xml.append("<REPORTDESC>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getReportdesc()) ? "" : IGStringUtils.filterXMLStr(ig380.getReportdesc()));
            sbf_xml.append("</REPORTDESC>");
            sbf_xml.append("<MESSAGEGENERATOR>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getMessagegenerator()) ? "" : IGStringUtils.filterXMLStr(ig380.getMessagegenerator()));
            sbf_xml.append("</MESSAGEGENERATOR>");
            sbf_xml.append("<PDSERIALNUMBER>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdserialnumber()) ? "" : ig380.getPdserialnumber());
            sbf_xml.append("</PDSERIALNUMBER>");
            sbf_xml.append("<PDSERVICECATALOG>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdservicecatalog()) ? "" : ig380.getPdservicecatalog());
            sbf_xml.append("</PDSERVICECATALOG>");
            sbf_xml.append("<PDSERVICECATALOGNAME>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdservicecatalogname()) ? "" : ig380.getPdservicecatalogname());
            sbf_xml.append("</PDSERVICECATALOGNAME>");
		}
		sbf_xml.append("</DATA>");
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG380>");
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
		List<IG380Info> lst_IG380 = new ArrayList<IG380Info>();
		IG380TB entity = null;
		for(Element e : dataList) {
			StringBuffer pdxml = new StringBuffer();
			entity = this.getIG380TBInstance();
			display(e.getChild("PDXML").getChild("WebFlow"), pdxml);
			entity.setPdid(e.getChildText("PDID"));
			entity.setPtid(new Integer(e.getChildText("PTID")));
			entity.setPdname(e.getChildText("PDNAME"));
			entity.setPddesc(e.getChildText("PDDESC"));
			entity.setPdcrtdate(e.getChildText("PDCRTDATE"));
			entity.setPdstatus(e.getChildText("PDSTATUS"));
			if(pdxml.length() > 1) {
				entity.setPdxml(pdxml.toString());
			}
			entity.setPermission(e.getChildText("PERMISSION"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setSerialgenerator(e.getChildText("SERIALGENERATOR"));
			entity.setPdactname(e.getChildText("PDACTNAME"));
			entity.setReportdesc(e.getChildText("REPORTDESC").replaceAll("&lt;", "<").replaceAll("&gt;", ">"));
			entity.setMessagegenerator(e.getChildText("MESSAGEGENERATOR"));
			entity.setPdserialnumber(e.getChildText("PDSERIALNUMBER"));
			entity.setPdservicecatalog(e.getChildText("PDSERVICECATALOG"));
			entity.setPdservicecatalogname(e.getChildText("PDSERVICECATALOGNAME"));
			lst_IG380.add(entity);
		}
		this.ig380DAO.saveOrUpdateAll(lst_IG380);
	}
	
	/*********** ������ʽ��ʾ������� ************/
	@SuppressWarnings("rawtypes")
	public void display(Element e, StringBuffer sbf) {
		if(e != null) {
			sbf.append("<").append(e.getName());
			List content = e.getContent();// ��������ӽ�����б���
			Iterator childIterator = content.iterator();// ���ɵ����б�
			// ����Ԫ������
			List attributes = e.getAttributes();// �����б�
			if (!attributes.isEmpty()) {// ��������ԣ���������
				Iterator attributeIterator = attributes.iterator(); // �������Եĵ����б�
				while (attributeIterator.hasNext()) { // ����������������
					Attribute attribute = (Attribute) attributeIterator.next(); // ȡ��һ������һ��������
					sbf.append(" ").append(attribute.getName()).append("=").append("'").append(attribute.getValue()).append("'");
				}
			}
			sbf.append(">");
			// ���������ı�
			String text = e.getTextNormalize();
			if (StringUtils.isNotEmpty(text)) {
				sbf.append(text);
			}
			// ��������ӽ�㣨������
			Object child = null;
			while (childIterator.hasNext()) {
				child = childIterator.next();
				if (child instanceof Element) { // ����õ���next��Element���͵�
					display((Element)child, sbf);
				}
			}
			sbf.append("</").append(e.getName()).append(">");
		}
	}
}
