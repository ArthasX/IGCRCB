/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.rpt.bl.task.SOC0424BL;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.bl.task.Object_ListBL;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.CustomConfigurationBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileVersionBL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;
import com.deliverik.infogovernor.sym.form.IGSYM1407Form;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;
import com.deliverik.infogovernor.sym.model.entity.ReportFileVersionTB;

/**
 * ������Ϣҵ���߼�ʵ��
 *
 */
public class IGSYM14BLImpl extends BaseBLImpl implements IGSYM14BL {

	/**
	 * object_ListBL�趨
	 *
	 * @param object_ListBL object_ListBL
	 */
	public void setObject_ListBL(Object_ListBL object_ListBL) {
		this.object_ListBL = object_ListBL;
	}

	/**
	 * soc0424BL�趨
	 *
	 * @param soc0424BL soc0424BL
	 */
	public void setSoc0424BL(SOC0424BL soc0424BL) {
		this.soc0424BL = soc0424BL;
	}

	static Log log = LogFactory.getLog(IGSYM14BLImpl.class);
	
	/** ������ϢBL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** ����汾��ϢBL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	protected Object_ListBL object_ListBL;
	
	protected SOC0424BL soc0424BL;
	
	protected IG380BL ig380BL;
	
	protected IG333BL ig333BL;
	
	protected IG007BL ig007BL;
	
	protected CodeDetailDefBL  codeDetailDefBL;
	
	protected CustomConfigurationBL customConfigurationBL;
    
	public void setCustomConfigurationBL(CustomConfigurationBL customConfigurationBL) {
		this.customConfigurationBL = customConfigurationBL;
	}

	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * ������ϢBL�趨
	 * 
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	
	/**
	 * ����汾��ϢBL�趨
	 * 
	 * @param reportFileVersionBL
	 */
	public void setReportFileVersionBL(
			ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//������Ϣ��ѯ����ȡ�� 
		int totalCount = this.reportFileDefinitionBL.getSearchCount(dto.getReportFileDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========������Ϣ��ѯ���ݲ�����========");
			//������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������Ϣ��ѯ���ݼ�������========");
			//������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ������Ϣȡ��
		List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO insertReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException {
		
		log.debug("========������Ϣ�ǼǴ���ʼ========");
		
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		if(dto.getUser() == null) {
			throw new BLException("IGCO10000.E004","��½�û�����");
		}
		
		//�Ǽ���ID
		form.setRfduserid(dto.getUser().getUserid());
		
		//�Ǽ�������
		form.setRfdusername(dto.getUser().getUsername());
		
		//�Ǽ�ʱ��
		form.setRfdinstime(IGStringUtils.getCurrentDateTime());
		
		//��һ��
		form.setRfdversion(1);
		
		//��һ��
		form.setRfdnewversion(1);
		
		//���Ƕ��Ʊ���ʱ���趨����ģ��
		if("0".equals(form.getIsFlag())) {
		    form.setRfdfilename(form.getRfdfilemodel());
		}
		
		//������Ϣ�ǼǴ���
		ReportFileDefinition pfd = this.reportFileDefinitionBL.registReportFileDefinition(form);
		
		//�����汾��Ϣ
		ReportFileVersionTB rfvTB = new ReportFileVersionTB();
		
		rfvTB.setRfdid(pfd.getRfdid());
		
		rfvTB.setRfvversion(1);
		
		rfvTB.setRfvinstime(form.getRfdinstime());
		
		this.reportFileVersionBL.registReportFileVersion(rfvTB);
		
		//���Ʊ���
		if("0".equals(form.getIsFlag())){
			CustomConfigurationTB ccTB = new CustomConfigurationTB();
			ccTB.setRfdid(pfd.getRfdid());
			//��������
			if(form.getPrtypes() != null && form.getPrtypes().length > 0 ) {
				ccTB.setPdid(getCustomConfigField(form.getPrtypes()));
			} else {
				ccTB.setPdid(form.getPrtype());
			}
			
			//����״̬
			if(form.getPrstatus() != null && form.getPrstatus().length > 0) {
				ccTB.setPrstatusInfo(getCustomConfigField(form.getPrstatus()));
			}
			
			//���̱�
			if(StringUtils.isNotEmpty(form.getPidid())){
				String[] pidids=form.getPidid().split("_");
				if (pidids != null && pidids.length > 0) {
					ccTB.setPidid(form.getPidid());
					//���Ϊ���α�ʱ
					if("T".equals(pidids[1])){
						IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
						StringBuffer pidvalue=new StringBuffer();
						if(ig007Info!=null){
							String ccid=ig007Info.getCcid().split("_")[0];
							if(StringUtils.isNotEmpty(form.getRank())){
								//�������α�ͳ�ƽڵ㼶����ccid���ϼ���
								Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
								CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
								cddCond.setCcid(cddccid.toString());
								cddCond.setCdstatus("1");
								//�������νڵ�ccid��ѯ�ڵ�����ֵ
								List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDef(cddCond);
								if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
									int i=0;
									for(CodeDetailDef info:codeDetailDefList){
										pidvalue.append(info.getSyscoding());
										if(i!=codeDetailDefList.size()){
											//��#ƴд����ֵ���磺��׼���#������
											pidvalue.append("#");
										}
										i++;
									}
								}
							}
						}
						ccTB.setPidvalue(pidvalue.toString());
					}else{
						IG007Info ig007Info = this.ig007BL.searchIG007InfoByKey(pidids[0]);
						if (ig007Info != null) {
							ccTB.setPidvalue(ig007Info.getPidoption());
						}
					}
				}
			}
			ccTB.setUserid(dto.getUser().getUserid());
			ccTB.setCreateTime(IGStringUtils.getCurrentDateTime());
			this.customConfigurationBL.registCustomConfiguration(ccTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���������Ϣ") );
		
		log.debug("========������Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ��װ���浽CUSTOMCONFIGURATION����ֶ�
	 *
	 * 2012-11-16����2:57:43
	 * @param pdids
	 * @return ��#�ŷָ����ַ���
	 */
	private String getCustomConfigField(String[] pdids) {
		StringBuffer sb = new StringBuffer();
		for (String pdid : pdids) {
		    if(sb.length() == 0) {
		        sb.append(pdid);
		    } else {
		        sb.append("#").append(pdid);
		    }
		}
		return sb.toString();
	}

	/**
	 * ȡ�ñ�����ʾ����
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO getReportTitle(IGSYM14DTO dto) throws BLException {
		
		log.debug("========���������Ϣ��ѯ����ʼ========");

		IGSYM1402Form form = new IGSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//��ʾ����
		
		form.setRfdtype(rfd.getRfdtype());//����
		
		form.setRfdid(rfd.getRfdid());//����
		
		form.setRfdfilename(rfd.getRfdfilename());//�ļ���
		
		form.setRfddesc(rfd.getRfddesc());//˵��
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//������ʾ����
		
		dto.setIgSYM1402Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
		
		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�����ʼ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO initReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========���������Ϣ��ѯ����ʼ========");
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//��ʾ����
		
		form.setRfdtype(rfd.getRfdtype());//����
		
		form.setRfdid(rfd.getRfdid());//����
		
		if("0".equals(rfd.getIsFlag())){
			form.setRfdfilemodel(rfd.getRfdfilename());//�ļ���
		}else{
			form.setRfdfilename(rfd.getRfdfilename());//�ļ���
		}
		
		form.setRfddesc(rfd.getRfddesc());//˵��
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//������ʾ����
		
		form.setRfdpictype(rfd.getRfdpictype());
		
		form.setIsFlag(rfd.getIsFlag());
		
		if("0".equals(rfd.getIsFlag())){
			CustomConfigurationInfo ccInfo=this.customConfigurationBL.searchCustomConfigurationByPK(rfd.getRfdid());
			 if(ccInfo!=null){
				 form.setPrtype(ccInfo.getPdid());
				 form.setPidid(ccInfo.getPidid());
				 form.setPrstatuss(ccInfo.getPrstatusInfo());
				 form.setPidvalue(ccInfo.getPidvalue());
				 if(null !=ccInfo.getPidvalue())
				 {
					 if(ccInfo.getPidvalue().split("#")[0].length()==6){
							form.setRank("0");
					 }
					 else{
							form.setRank("1");
					 }
				 }
				 
			 }
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
		
		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ���
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO editReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException{
		
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		//��鱨����ʾ����
		if(!rfdTB.getRfdtitle().equals(form.getRfdtitle())){
			this.reportFileDefinitionBL.checkRfdtitle(form.getRfdtitle());
		}
		
		rfdTB.setRfdtitle(form.getRfdtitle());//��ʾ����
		
		rfdTB.setRfdtype(form.getRfdtype());//����
		
		rfdTB.setRfddesc(form.getRfddesc());//˵��
		
		if(StringUtils.isNotEmpty(form.getRfdfilemodel())){
			rfdTB.setRfdfilename(form.getRfdfilemodel());
		}
		
	    // ���Ƕ��Ʊ���ʱ���趨����ģ��
        if("0".equals(form.getIsFlag())){
            rfdTB.setRfdfilename(form.getRfdfilemodel());
        } else {
        	rfdTB.setRfdfilename(form.getRfdfilename());
        }
        
		rfdTB.setRfdpictype(form.getRfdpictype());//��������
		
		rfdTB.setIsFlag(form.getIsFlag());
		
		ReportFileDefinition pfd=this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		//���Ʊ���
		if("0".equals(form.getIsFlag())){
			CustomConfigurationInfo ccInfo=this.customConfigurationBL.searchCustomConfigurationByPK(pfd.getRfdid());
			if(ccInfo!=null){
				CustomConfigurationTB ccTB=(CustomConfigurationTB)SerializationUtils.clone(ccInfo);
				//��������
				if(form.getPrtypes()!=null) {
					ccTB.setPdid(getCustomConfigField(form.getPrtypes()));
				} else {
					ccTB.setPdid(form.getPrtype());
				}
				if(form.getPrstatus()!=null&&form.getPrstatus().length>0){
					ccTB.setPrstatusInfo(getCustomConfigField(form.getPrstatus()));
				}
				if(StringUtils.isNotEmpty(form.getPidid())){
					String[] pidids=form.getPidid().split("_");
					if(pidids!=null&&pidids.length>0){
						ccTB.setPidid(form.getPidid());
						//���Ϊ���α�ʱ
						if("T".equals(pidids[1])){
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							StringBuffer pidvalue=new StringBuffer();
							if(ig007Info!=null){
								String ccid=ig007Info.getCcid().split("_")[0];
								if(StringUtils.isNotEmpty(form.getRank())){
									//�������α�ͳ�ƽڵ㼶����ccid���ϼ���
									Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
									CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
									cddCond.setCcid(cddccid.toString());
									//�������νڵ�ccid��ѯ�ڵ�����ֵ
									List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDefTree(cddCond, 0);
									if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
										int i=0;
										for(CodeDetailDef info:codeDetailDefList){
											pidvalue.append(info.getSyscoding());
											if(i!=codeDetailDefList.size()){
												//��#ƴд����ֵ���磺��׼���#������
												pidvalue.append("#");
											}
											i++;
										}
									}
								}
							}
							ccTB.setPidvalue(pidvalue.toString());
						}else{
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							if(ig007Info!=null){
								ccTB.setPidvalue(ig007Info.getPidoption());
							}
						}
					}
				}
				ccTB.setUserid(dto.getUser().getUserid());
				ccTB.setUpdateTime(IGStringUtils.getCurrentDateTime());
				this.customConfigurationBL.registCustomConfiguration(ccTB);
			}else{
				CustomConfigurationTB ccTB=new CustomConfigurationTB();
				ccTB.setRfdid(pfd.getRfdid());
				ccTB.setPdid(form.getPrtype());
				if(form.getPrstatus()!=null&&form.getPrstatus().length>0){
					StringBuffer prstatus=new StringBuffer();
					for(int i=0;i<form.getPrstatus().length;i++){
						prstatus.append(form.getPrstatus()[i]);
						if(i!=form.getPrstatus().length){
							prstatus.append("#");
						}
					}
					ccTB.setPrstatusInfo(prstatus.toString());
				}
				if(StringUtils.isNotEmpty(form.getPidid())){
					String[] pidids=form.getPidid().split("_");
					if(pidids!=null&&pidids.length>0){
						ccTB.setPidid(form.getPidid());
						//���Ϊ���α�ʱ
						if("T".equals(pidids[1])){
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							StringBuffer pidvalue=new StringBuffer();
							if(ig007Info!=null){
								String ccid=ig007Info.getCcid().split("_")[0];
								if(StringUtils.isNotEmpty(form.getRank())){
									//�������α�ͳ�ƽڵ㼶����ccid���ϼ���
									Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
									CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
									cddCond.setCcid(cddccid.toString());
									//�������νڵ�ccid��ѯ�ڵ�����ֵ
									List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDef(cddCond);
									if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
										int i=0;
										for(CodeDetailDef info:codeDetailDefList){
											pidvalue.append(info.getSyscoding());
											if(i!=codeDetailDefList.size()){
												//��#ƴд����ֵ���磺��׼���#������
												pidvalue.append("#");
											}
											i++;
										}
									}
								}
							}
							ccTB.setPidvalue(pidvalue.toString());
						}else{
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							if(ig007Info!=null){
								ccTB.setPidvalue(ig007Info.getPidoption());
							}
						}
					}
				}
				ccTB.setUserid(dto.getUser().getUserid());
				ccTB.setCreateTime(IGStringUtils.getCurrentDateTime());
				this.customConfigurationBL.registCustomConfiguration(ccTB);
			}
			
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "���������Ϣ") );
		return dto;
	}
	
	/**
	 * ����汾��������
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		log.debug("========����汾��������ʼ========");
		
		//�汾��Ϣȡ��
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		//�汾��1
		int version = rfd.getRfdnewversion() + 1;
		
		//����ʱ��
		String datatime = IGStringUtils.getCurrentDateTime();
		
		rfdTB.setRfdnewversion(version);
		
		//���±�����Ϣ
		this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		//�����汾��Ϣ
		ReportFileVersionTB rfvTB = new ReportFileVersionTB();
		
		rfvTB.setRfdid(dto.getRfdid());
		
		rfvTB.setRfvversion(version);
		
		rfvTB.setRfvinstime(datatime);
		
		this.reportFileVersionBL.registReportFileVersion(rfvTB);
		
		dto.addMessage(new ActionMessage("IGSYM1401.I001"));
		
		log.debug("========����汾������������========");
		return dto;
	}
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO deleteReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
		if(dto.getDeleteRfdid() != null) {
			//ѭ��ɾ��
			for( int i=0;i<dto.getDeleteRfdid().length;i++ ){
				this.reportFileDefinitionBL.deleteReportFileDefinition(Integer.parseInt(dto.getDeleteRfdid()[i]));
				this.customConfigurationBL.deleteCustomConfigurationByPK(Integer.parseInt(dto.getDeleteRfdid()[i]));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "���������Ϣ"));
		log.debug("========������Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * ����汾��Ϣ��ѯ����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========����汾��Ϣ��ѯ����ʼ========");
		
		//������Ϣȡ��
		dto.setReportFileDefinition(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getReportFileVersionSearchCond().getRfdid()));
		
		//����汾��Ϣȡ��
		List<ReportFileVersion> reportFileVersionList = this.reportFileVersionBL.searchReportFileVersion(dto.getReportFileVersionSearchCond(), 0, 0);
		
		dto.setReportFileVersionList(reportFileVersionList);
		
		log.debug("========����汾��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ָ����ǰ�汾����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO assignCurrentReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========ָ����ǰ�汾����ʼ========");
		
		//����汾��Ϣȡ��
		ReportFileVersion rfv = this.reportFileVersionBL.searchReportFileVersionByKey(dto.getRfvid());
		
		//�汾��Ϣȡ��
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(rfv.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		rfdTB.setRfdversion(rfv.getRfvversion());//��ǰ�汾
		
		rfdTB.setRfdinstime(rfv.getRfvinstime());//����ʱ��
		
		//���±�����Ϣ
		this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		dto.addMessage(new ActionMessage("IGSYM1405.I001"));
		
		log.debug("========ָ����ǰ�汾��������========");
		return dto;
	}
	
	/**
	 * ȡ�ö�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO getObjectName(IGSYM14DTO dto) throws BLException {
		List<LabelValueBean> objectNameList=new ArrayList<LabelValueBean>();
		IGSYM1407Form form=dto.getIgsym1407Form();
		if(form!=null){
			//ģ������
			String rtname=form.getReportname();
			if(rtname!=null&&!"".equals(rtname)){
				SOC0424SearchCondImpl rtCond=new SOC0424SearchCondImpl();
				rtCond.setReportName_eq(rtname);
				List<SOC0424Info> rtList=soc0424BL.searchSOC0424(rtCond);
				if(rtList!=null&&rtList.size()>0){
					Object_ListSearchCondImpl cond=new Object_ListSearchCondImpl();
					cond.setObject_Type(rtList.get(0).getRtType());
					cond.setDataId(form.getDataid());
					List<Object_ListInfo> object_List = object_ListBL.searchObject_List(cond);
					for (Object_ListInfo object_ListInfo : object_List) {
						LabelValueBean lvb=new LabelValueBean(object_ListInfo.getObject_Name(),object_ListInfo.getObject_Name());
						objectNameList.add(lvb);
					}
					dto.setObjectNameList(objectNameList);
				}
			}
		}
		return dto;
	}

	/**
	 * ��ȡ�������ͺͱ���ģ�����ݼ�
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO searchPrtypeAndRfdFilenameList(IGSYM14DTO dto) throws BLException {
		log.debug("========��ȡ�������ͺͱ���ģ�����ݼ���ʼ========");
		IG380SearchCondImpl cond=new IG380SearchCondImpl();
		//��������ȡ��
		cond.setPtid(8);
		cond.setPdstatus("a");
		List<IG380Info> ig380List=this.ig380BL.searchIG380Info(cond);
		List<LabelValueBean> prtypeList = new ArrayList<LabelValueBean>();
		prtypeList.add(new LabelValueBean("",""));
		for(IG380Info info:ig380List){
			prtypeList.add(new LabelValueBean(info.getPdname(), info.getPdid()));
		}
		dto.setPrtypeList(prtypeList);
		
		log.debug("========��ȡ�������ͺͱ���ģ�����ݼ�����========");
		return dto;
	}

}
