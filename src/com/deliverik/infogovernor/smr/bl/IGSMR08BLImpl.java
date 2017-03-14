/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.smr.bl.task.FillInQualityAssessVWBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * ����:��������� 
 * �������������������
 * �����ˣ�����͢
 * ������¼�� 2013-09-02
 * �޸ļ�¼��
 */
public class IGSMR08BLImpl extends BaseBLImpl implements IGSMR08BL {
	
	static Log log = LogFactory.getLog(IGSMR08BLImpl.class);
	
	/** �����ʵ����BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** ���������BL */
	protected FillInQualityAssessVWBL fillInQualityAssessVWBL;
	
	/** ���̹��ܲ�ѯAPI */
	protected FlowSearchBL flowSearchBL;
	
	public void setFillInQualityAssessVWBL(
			FillInQualityAssessVWBL fillInQualityAssessVWBL) {
		this.fillInQualityAssessVWBL = fillInQualityAssessVWBL;
	}
	
	/**
	 * ���̹��ܲ�ѯAPI�趨
	 *
	 * @param flowSearchBL ���̹��ܲ�ѯAPI
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * �����ʵ����BL�趨
	 *
	 * @param regulatoryReportInstanceBL �����ʵ����BL
	 */
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}


	/**
	 * 
	 *�����������ſ���
	 *ʱ�䣺2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	public IGSMR08DTO initSMR0801ByOrgAction(IGSMR08DTO dto) throws BLException {
		//formȡ��
		IGSMR0801Form form = dto.getIgsmr0801Form();
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();	
		cond.setAssessstartdate(form.getAssessstartdate());
		cond.setAssessoverdate(form.getAssessoverdate());
		List<FillInQualityAssessInfo> list_fiqa = fillInQualityAssessVWBL.searchFillInQualityByUser(cond);
		//�½�ҳ������
		List<IGSMR08001VO> list = new ArrayList<IGSMR08001VO>();
		//����
		for(FillInQualityAssessInfo info:list_fiqa){
			//ѭ����������鿴�Ƿ��и��˵ļ�¼�����û���������µļ�¼����������޸ļ�¼
			if(list.size()!=0){
				//�Ƿ���ڸ��˵ı�ʶ
				String mark="1";
				//�����������ֵ
				for(IGSMR08001VO vo:list){
					//�ж��Ƿ��иò��ŵļ�¼�����û��������һ������������޸ļ�¼
					if(vo.getOrgid().equals(info.getPporgid())){
						//�жϸ����Ƿ���д�걨
						if(StringUtils.isNotEmpty(info.getPpuserid1())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getYearnum())){
								vo.setYearnum(String.valueOf(Integer.parseInt(vo.getYearnum())+1));
							}else{
								vo.setYearnum("1");
							}
						}
						//�жϸ����Ƿ���д����
						if(StringUtils.isNotEmpty(info.getPpuserid2())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getQuarternum())){
								vo.setQuarternum(String.valueOf(Integer.parseInt(vo.getQuarternum())+1));
							}else{
								vo.setQuarternum("1");
							}
						}
						//�жϸ����Ƿ���д�����ڱ���
						if(StringUtils.isNotEmpty(info.getPpuserid3())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getNotimenum())){
								vo.setNotimenum(String.valueOf(Integer.parseInt(vo.getNotimenum())+1));
							}else{
								vo.setNotimenum("1");
							}
						}
						//�ж��걨��д���Ƿ�ʱ
						if("1".equals(info.getTimely1())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getYeartime())){								
								vo.setYeartime(String.valueOf(Integer.parseInt(vo.getYeartime())+1));
							}else{
								vo.setYeartime("1");
							}
						}
						//�жϼ�����д���Ƿ�ʱ
						if("1".equals(info.getTimely2())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getQuartertime())){
								vo.setQuartertime(String.valueOf(Integer.parseInt(vo.getQuartertime())+1));
							}else{
								vo.setQuartertime("1");
							}
						}
						//�жϲ����ڱ�����д���Ƿ�ʱ
						if("1".equals(info.getTimely3())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getNotime())){
								vo.setNotime(String.valueOf(Integer.parseInt(vo.getNotime())+1));
							}else{
								vo.setNotime("1");
							}
						}
						//�ж��걨��Ƿ�׼ȷ
						if("0".equals(info.getTruely1())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getYeartrue())){
								vo.setYeartrue(String.valueOf(Integer.parseInt(vo.getYeartrue())+1));
							}else{
								vo.setYeartrue("1");
							}
						}
						//�жϼ�����Ƿ�׼ȷ
						if("0".equals(info.getTruely2())){
							//����ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getQuartertrue())){
								vo.setQuartertrue(String.valueOf(Integer.parseInt(vo.getQuartertrue())+1));
							}else{
								vo.setQuartertrue("1");
							}
						}
						//�жϲ����ڱ�����Ƿ�׼ȷ
						if("0".equals(info.getTimely3())){
							//����ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getNotimetrue())){
								vo.setNotimetrue(String.valueOf(Integer.parseInt(vo.getNotimetrue())+1));
							}else{
								vo.setNotimetrue("1");
							}
						}
						mark="0";
					}
				}
				if("1".equals(mark)){
					IGSMR08001VO smrvo = new IGSMR08001VO();
					//�����˲��Ż�����
					smrvo.setOrgid(info.getPporgid());
					//��������
					smrvo.setOrgname(info.getPporgname());
					//�û�id
					smrvo.setUserid(info.getPpuserid());
					//�û���
					smrvo.setUsername(info.getUsername());
					//n�걨��д����
					//�жϸ����Ƿ���д�걨
					if(StringUtils.isNotEmpty(info.getPpuserid1())){
						smrvo.setYearnum("1");
					}
					//�жϸ����Ƿ���д����
					if(StringUtils.isNotEmpty(info.getPpuserid2())){
						smrvo.setQuarternum("1");
					}
					//�жϸ����Ƿ���д�����ڱ���
					if(StringUtils.isNotEmpty(info.getPpuserid3())){
						smrvo.setNotimenum("1");							
					}
					//�ж��걨��д���Ƿ�ʱ
					if("1".equals(info.getTimely1())){
						smrvo.setYeartime("1");
						
					}
					//�жϼ�����д���Ƿ�ʱ
					if("1".equals(info.getTimely2())){
						smrvo.setQuartertime("1");
					}
					//�жϲ����ڱ�����д���Ƿ�ʱ
					if("1".equals(info.getTimely3())){
						smrvo.setNotime("1");
					}
					//�ж��걨��Ƿ�׼ȷ
					if("0".equals(info.getTruely1())){					
						smrvo.setYeartrue("1");
					}
					//�жϼ�����Ƿ�׼ȷ
					if("0".equals(info.getTruely2())){
						smrvo.setQuartertrue("1");
					}
					//�жϲ����ڱ�����Ƿ�׼ȷ
					if("0".equals(info.getTimely3())){
						smrvo.setNotimetrue("1");
					}
					list.add(smrvo);											
				}
			}else{
				IGSMR08001VO smrvo = new IGSMR08001VO();
				//�����˲��Ż�����
				smrvo.setOrgid(info.getPporgid());
				//��������
				smrvo.setOrgname(info.getPporgname());
				//�û�id
				smrvo.setUserid(info.getPpuserid());
				//�û���
				smrvo.setUsername(info.getUsername());
				//n�걨��д����
				//�жϸ����Ƿ���д�걨
				if(StringUtils.isNotEmpty(info.getPpuserid1())){
					smrvo.setYearnum("1");
				}
				//�жϸ����Ƿ���д����
				if(StringUtils.isNotEmpty(info.getPpuserid2())){
					smrvo.setQuarternum("1");
				}
				//�жϸ����Ƿ���д�����ڱ���
				if(StringUtils.isNotEmpty(info.getPpuserid3())){
					smrvo.setNotimenum("1");							
				}
				//�ж��걨��д���Ƿ�ʱ
				if("1".equals(info.getTimely1())){
					smrvo.setYeartime("1");
					
				}
				//�жϼ�����д���Ƿ�ʱ
				if("1".equals(info.getTimely2())){
					smrvo.setQuartertime("1");
				}
				//�жϲ����ڱ�����д���Ƿ�ʱ
				if("1".equals(info.getTimely3())){
					smrvo.setNotime("1");
				}
				//�ж��걨��Ƿ�׼ȷ
				if("0".equals(info.getTruely1())){					
					smrvo.setYeartrue("1");
				}
				//�жϼ�����Ƿ�׼ȷ
				if("0".equals(info.getTruely2())){
					smrvo.setQuartertrue("1");
				}
				//�жϲ����ڱ�����Ƿ�׼ȷ
				if("0".equals(info.getTimely3())){
					smrvo.setNotimetrue("1");
				}
				list.add(smrvo);						
			
			}
			
			
		}
		//�������ٷֱ�֮��ļ���
		List<IGSMR08001VO> list_vo = new ArrayList<IGSMR08001VO>();
		//����ҳ�����������map����
		for(IGSMR08001VO vo:list){
			    //������˵��걨��ʱ�ʺ�׼ȷ��
			    //���ø����걨�������			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//������˵ļ�����ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//������˵Ĳ����ڱ���ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				
				list_vo.add(vo);
				
		}
		//����ϼƵ�ʵ��
	    IGSMR08001VO sumorg = new IGSMR08001VO();
		//���������
		for(FillInQualityAssessInfo fiq:list_fiqa){
			//�����걨�������
			if(StringUtils.isNotEmpty(fiq.getPpuserid1())){
				if(StringUtils.isNotEmpty(sumorg.getYearnum())){
					sumorg.setYearnum(String.valueOf(Integer.parseInt(sumorg.getYearnum())+1));
				}else{
					sumorg.setYearnum("1");
				}
				
			}
			//�����걨��ʱ����
			if("1".equals(fiq.getTimely1())){
				if(StringUtils.isNotEmpty(sumorg.getYeartime())){
					sumorg.setYeartime(String.valueOf(Integer.parseInt(sumorg.getYeartime())+1));
				}else{
					sumorg.setYeartime("1");
				}
			}
			//�����걨׼ȷ����
			if("0".equals(fiq.getTruely1())){
				if(StringUtils.isNotEmpty(sumorg.getYeartrue())){
					sumorg.setYeartrue(String.valueOf(Integer.parseInt(sumorg.getYeartrue())+1));											
				}else{
					sumorg.setYeartrue("1");
				}
			}
			//���㼾�������
			if(StringUtils.isNotEmpty(fiq.getPpuserid2())){
				if(StringUtils.isNotEmpty(sumorg.getQuarternum())){
					sumorg.setQuarternum(String.valueOf(Integer.parseInt(sumorg.getQuarternum())+1));	
				}else{
					sumorg.setQuarternum("1");
				}
			}
			//���㼾����ʱ����
			if("1".equals(fiq.getTimely2())){
				if(StringUtils.isNotEmpty(sumorg.getQuartertime())){
					sumorg.setQuartertime(String.valueOf(Integer.parseInt(sumorg.getQuartertime())+1));	
				}else{
					sumorg.setQuartertime("1");
				}
				
			}
			//���㼾��׼ȷ����
			if("0".equals(fiq.getTruely2())){
				if(StringUtils.isNotEmpty(sumorg.getQuartertrue())){
					sumorg.setQuartertrue(String.valueOf(Integer.parseInt(sumorg.getQuartertrue())+1));	
				}else{
					sumorg.setQuartertrue("1");
				}
			}
			//���㲻���������
			if(StringUtils.isNotEmpty(fiq.getPpuserid3())){
				if(StringUtils.isNotEmpty(sumorg.getNotimenum())){
					sumorg.setNotimenum(String.valueOf(Integer.parseInt(sumorg.getNotimenum())+1));	
				}else{
					sumorg.setNotimenum("1");
				}
			}
			//���㲻���ڼ�ʱ����
			if("1".equals(fiq.getTimely3())){
				if(StringUtils.isNotEmpty(sumorg.getNotime())){
					sumorg.setNotime(String.valueOf(Integer.parseInt(sumorg.getNotime())+1));	
				}else{
					sumorg.setNotime("1");
				}
			}
			//���㲻����׼ȷ����
			if("0".equals(fiq.getTruely3())){
				if(StringUtils.isNotEmpty(sumorg.getNotimetrue())){
					sumorg.setNotimetrue(String.valueOf(Integer.parseInt(sumorg.getNotimetrue())+1));	
				}else{
					sumorg.setNotimetrue("1");
				}
			}
		}
	    //������˵��걨��ʱ�ʺ�׼ȷ��
	    //���ø����걨�������			   
		if(StringUtils.isNotEmpty(sumorg.getYearnum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getYeartime())){
				a=Double.parseDouble(sumorg.getYeartime());
			}
			if(StringUtils.isNotEmpty(sumorg.getYeartrue())){
				 c=Double.parseDouble(sumorg.getYeartrue());
			}
			Double b=Double.parseDouble(sumorg.getYearnum());
			sumorg.setYeartime(numformate(a,b));					
			sumorg.setYeartrue(numformate(c,b));
		}
		//������˵ļ�����ʱ�ʺ�׼ȷ��
		if(StringUtils.isNotEmpty(sumorg.getQuarternum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getQuartertime())){
				a=Double.parseDouble(sumorg.getQuartertime());
			}
			if(StringUtils.isNotEmpty(sumorg.getQuartertrue())){
				 c=Double.parseDouble(sumorg.getQuartertrue());
			}
			Double b=Double.parseDouble(sumorg.getQuarternum());
			sumorg.setQuartertime(numformate(a,b));					
			sumorg.setQuartertrue(numformate(c,b));
		}
		//������˵Ĳ����ڱ���ʱ�ʺ�׼ȷ��
		if(StringUtils.isNotEmpty(sumorg.getNotimenum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getNotime())){
				a=Double.parseDouble(sumorg.getNotime());
			}
			if(StringUtils.isNotEmpty(sumorg.getNotimetrue())){
				 c=Double.parseDouble(sumorg.getNotimetrue());
			}
			Double b=Double.parseDouble(sumorg.getNotimenum());
			sumorg.setNotime(numformate(a,b));					
			sumorg.setNotimetrue(numformate(c,b));
		}
		dto.setOrgsum(sumorg);
		dto.setList(list_vo);
		return dto;
	}
	
	/**
	 * 
	 *����������Ա����
	 *ʱ�䣺2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	public IGSMR08DTO initSMR0801ByUserAction(IGSMR08DTO dto)
			throws BLException {
		//formȡ��
		IGSMR0801Form form = dto.getIgsmr0801Form();
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();
		cond.setAssessstartdate(form.getAssessstartdate());
		cond.setAssessoverdate(form.getAssessoverdate());
		List<FillInQualityAssessInfo> list_fiqa = fillInQualityAssessVWBL.searchFillInQualityByUser(cond);
		//�½�ҳ������
		List<IGSMR08001VO> list = new ArrayList<IGSMR08001VO>();
		//����
		for(FillInQualityAssessInfo info:list_fiqa){
			//ѭ����������鿴�Ƿ��и��˵ļ�¼�����û���������µļ�¼����������޸ļ�¼
			if(list.size()!=0){
				//�Ƿ���ڸ��˵ı�ʶ
				String mark="1";
				//�����������ֵ
				for(IGSMR08001VO vo:list){
					//�ж��Ƿ��и��˵ļ�¼�����û��������һ������������޸ļ�¼
					if(vo.getUserid().equals(info.getPpuserid())){
						//�жϸ����Ƿ���д�걨
						if(StringUtils.isNotEmpty(info.getPpuserid1())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getYearnum())){
								vo.setYearnum(String.valueOf(Integer.parseInt(vo.getYearnum())+1));
							}else{
								vo.setYearnum("1");
							}
						}
						//�жϸ����Ƿ���д����
						if(StringUtils.isNotEmpty(info.getPpuserid2())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getQuarternum())){
								vo.setQuarternum(String.valueOf(Integer.parseInt(vo.getQuarternum())+1));
							}else{
								vo.setQuarternum("1");
							}
						}
						//�жϸ����Ƿ���д�����ڱ���
						if(StringUtils.isNotEmpty(info.getPpuserid3())){
							//�ж��Ƿ���ֵ��
							if(StringUtils.isNotEmpty(vo.getNotimenum())){
								vo.setNotimenum(String.valueOf(Integer.parseInt(vo.getNotimenum())+1));
							}else{
								vo.setNotimenum("1");
							}
						}
						//�ж��걨��д���Ƿ�ʱ
						if("1".equals(info.getTimely1())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getYeartime())){								
								vo.setYeartime(String.valueOf(Integer.parseInt(vo.getYeartime())+1));
							}else{
								vo.setYeartime("1");
							}
						}
						//�жϼ�����д���Ƿ�ʱ
						if("1".equals(info.getTimely2())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getQuartertime())){
								vo.setQuartertime(String.valueOf(Integer.parseInt(vo.getQuartertime())+1));
							}else{
								vo.setQuartertime("1");
							}
						}
						//�жϲ����ڱ�����д���Ƿ�ʱ
						if("1".equals(info.getTimely3())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getNotime())){
								vo.setNotime(String.valueOf(Integer.parseInt(vo.getNotime())+1));
							}else{
								vo.setNotime("1");
							}
						}
						//�ж��걨��Ƿ�׼ȷ
						if("0".equals(info.getTruely1())){
							//������ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getYeartrue())){
								vo.setYeartrue(String.valueOf(Integer.parseInt(vo.getYeartrue())+1));
							}else{
								vo.setYeartrue("1");
							}
						}
						//�жϼ�����Ƿ�׼ȷ
						if("0".equals(info.getTruely2())){
							//����ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getQuartertrue())){
								vo.setQuartertrue(String.valueOf(Integer.parseInt(vo.getQuartertrue())+1));
							}else{
								vo.setQuartertrue("1");
							}
						}
						//�жϲ����ڱ�����Ƿ�׼ȷ
						if("0".equals(info.getTimely3())){
							//����ֶβ�Ϊ��
							if(StringUtils.isNotEmpty(vo.getNotimetrue())){
								vo.setNotimetrue(String.valueOf(Integer.parseInt(vo.getNotimetrue())+1));
							}else{
								vo.setNotimetrue("1");
							}
						}
						mark="0";
					}

				}
				if("1".equals(mark)){
					IGSMR08001VO smrvo = new IGSMR08001VO();
					//�����˲��Ż�����
					smrvo.setOrgid(info.getPporgid());
					//��������
					smrvo.setOrgname(info.getPporgname());
					//�û�id
					smrvo.setUserid(info.getPpuserid());
					//�û���
					smrvo.setUsername(info.getUsername());
					//n�걨��д����
					//�жϸ����Ƿ���д�걨
					if(StringUtils.isNotEmpty(info.getPpuserid1())){
						smrvo.setYearnum("1");
					}
					//�жϸ����Ƿ���д����
					if(StringUtils.isNotEmpty(info.getPpuserid2())){
						smrvo.setQuarternum("1");
					}
					//�жϸ����Ƿ���д�����ڱ���
					if(StringUtils.isNotEmpty(info.getPpuserid3())){
						smrvo.setNotimenum("1");							
					}
					//�ж��걨��д���Ƿ�ʱ
					if("1".equals(info.getTimely1())){
						smrvo.setYeartime("1");
						
					}
					//�жϼ�����д���Ƿ�ʱ
					if("1".equals(info.getTimely2())){
						smrvo.setQuartertime("1");
					}
					//�жϲ����ڱ�����д���Ƿ�ʱ
					if("1".equals(info.getTimely3())){
						smrvo.setNotime("1");
					}
					//�ж��걨��Ƿ�׼ȷ
					if("0".equals(info.getTruely1())){					
						smrvo.setYeartrue("1");
					}
					//�жϼ�����Ƿ�׼ȷ
					if("0".equals(info.getTruely2())){
						smrvo.setQuartertrue("1");
					}
					//�жϲ����ڱ�����Ƿ�׼ȷ
					if("0".equals(info.getTimely3())){
						smrvo.setNotimetrue("1");
					}
					list.add(smrvo);											
				}
			}else{
				IGSMR08001VO smrvo = new IGSMR08001VO();
				//�����˲��Ż�����
				smrvo.setOrgid(info.getPporgid());
				//��������
				smrvo.setOrgname(info.getPporgname());
				//�û�id
				smrvo.setUserid(info.getPpuserid());
				//�û���
				smrvo.setUsername(info.getUsername());
				//n�걨��д����
				//�жϸ����Ƿ���д�걨
				if(StringUtils.isNotEmpty(info.getPpuserid1())){
					smrvo.setYearnum("1");
				}
				//�жϸ����Ƿ���д����
				if(StringUtils.isNotEmpty(info.getPpuserid2())){
					smrvo.setQuarternum("1");
				}
				//�жϸ����Ƿ���д�����ڱ���
				if(StringUtils.isNotEmpty(info.getPpuserid3())){
					smrvo.setNotimenum("1");							
				}
				//�ж��걨��д���Ƿ�ʱ
				if("1".equals(info.getTimely1())){
					smrvo.setYeartime("1");
					
				}
				//�жϼ�����д���Ƿ�ʱ
				if("1".equals(info.getTimely2())){
					smrvo.setQuartertime("1");
				}
				//�жϲ����ڱ�����д���Ƿ�ʱ
				if("1".equals(info.getTimely3())){
					smrvo.setNotime("1");
				}
				//�ж��걨��Ƿ�׼ȷ
				if("0".equals(info.getTruely1())){					
					smrvo.setYeartrue("1");
				}
				//�жϼ�����Ƿ�׼ȷ
				if("0".equals(info.getTruely2())){
					smrvo.setQuartertrue("1");
				}
				//�жϲ����ڱ�����Ƿ�׼ȷ
				if("0".equals(info.getTimely3())){
					smrvo.setNotimetrue("1");
				}
				list.add(smrvo);						
			
			}
			
		}
		//����꼯��֮�󽫼�����ֵ�޸ģ��������Ϊ�Բ�����Ϊ����ListΪֵ��map����
		//����map����
		Map<String,List<IGSMR08001VO>> map = new LinkedHashMap<String, List<IGSMR08001VO>>();
		//����ҳ�����������map����
		for(IGSMR08001VO vo:list){
			//�ж��Ƿ��иò��ż��ϵĴ���
			if(map.get(vo.getOrgname())==null){
				 //���ø����걨�������			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//������˵ļ�����ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//������˵Ĳ����ڱ���ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				//ʵ������list
				List<IGSMR08001VO> list_vo = new ArrayList<IGSMR08001VO>();
				list_vo.add(vo);
				map.put(vo.getOrgname(),list_vo );
			}else{
				 //���ø����걨�������			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//������˵ļ�����ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//������˵Ĳ����ڱ���ʱ�ʺ�׼ȷ��
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				map.get(vo.getOrgname()).add(vo);
			}				
				
		}
		//����ϼƵ�ʵ��
	    IGSMR08001VO sumuser = new IGSMR08001VO();
		//���������
		for(FillInQualityAssessInfo fiq:list_fiqa){
			//�����걨�������
			if(StringUtils.isNotEmpty(fiq.getPpuserid1())){
				if(StringUtils.isNotEmpty(sumuser.getYearnum())){
					sumuser.setYearnum(String.valueOf(Integer.parseInt(sumuser.getYearnum())+1));
				}else{
					sumuser.setYearnum("1");
				}
				
			}
			//�����걨��ʱ����
			if("1".equals(fiq.getTimely1())){
				if(StringUtils.isNotEmpty(sumuser.getYeartime())){
					sumuser.setYeartime(String.valueOf(Integer.parseInt(sumuser.getYeartime())+1));
				}else{
					sumuser.setYeartime("1");
				}
			}
			//�����걨׼ȷ����
			if("0".equals(fiq.getTruely1())){
				if(StringUtils.isNotEmpty(sumuser.getYeartrue())){
					sumuser.setYeartrue(String.valueOf(Integer.parseInt(sumuser.getYeartrue())+1));											
				}else{
					sumuser.setYeartrue("1");
				}
			}
			//���㼾�������
			if(StringUtils.isNotEmpty(fiq.getPpuserid2())){
				if(StringUtils.isNotEmpty(sumuser.getQuarternum())){
					sumuser.setQuarternum(String.valueOf(Integer.parseInt(sumuser.getQuarternum())+1));	
				}else{
					sumuser.setQuarternum("1");
				}
			}
			//���㼾����ʱ����
			if("1".equals(fiq.getTimely2())){
				if(StringUtils.isNotEmpty(sumuser.getQuartertime())){
					sumuser.setQuartertime(String.valueOf(Integer.parseInt(sumuser.getQuartertime())+1));	
				}else{
					sumuser.setQuartertime("1");
				}
				
			}
			//���㼾��׼ȷ����
			if("0".equals(fiq.getTruely2())){
				if(StringUtils.isNotEmpty(sumuser.getQuartertrue())){
					sumuser.setQuartertrue(String.valueOf(Integer.parseInt(sumuser.getQuartertrue())+1));	
				}else{
					sumuser.setQuartertrue("1");
				}
			}
			//���㲻���������
			if(StringUtils.isNotEmpty(fiq.getPpuserid3())){
				if(StringUtils.isNotEmpty(sumuser.getNotimenum())){
					sumuser.setNotimenum(String.valueOf(Integer.parseInt(sumuser.getNotimenum())+1));	
				}else{
					sumuser.setNotimenum("1");
				}
			}
			//���㲻���ڼ�ʱ����
			if("1".equals(fiq.getTimely3())){
				if(StringUtils.isNotEmpty(sumuser.getNotime())){
					sumuser.setNotime(String.valueOf(Integer.parseInt(sumuser.getNotime())+1));	
				}else{
					sumuser.setNotime("1");
				}
			}
			//���㲻����׼ȷ����
			if("0".equals(fiq.getTruely3())){
				if(StringUtils.isNotEmpty(sumuser.getNotimetrue())){
					sumuser.setNotimetrue(String.valueOf(Integer.parseInt(sumuser.getNotimetrue())+1));	
				}else{
					sumuser.setNotimetrue("1");
				}
			}
		}
	    //������˵��걨��ʱ�ʺ�׼ȷ��
	    //���ø����걨�������			   
		if(StringUtils.isNotEmpty(sumuser.getYearnum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getYeartime())){
				a=Double.parseDouble(sumuser.getYeartime());
			}
			if(StringUtils.isNotEmpty(sumuser.getYeartrue())){
				 c=Double.parseDouble(sumuser.getYeartrue());
			}
			Double b=Double.parseDouble(sumuser.getYearnum());
			sumuser.setYeartime(numformate(a,b));					
			sumuser.setYeartrue(numformate(c,b));
		}
		//������˵ļ�����ʱ�ʺ�׼ȷ��
		if(StringUtils.isNotEmpty(sumuser.getQuarternum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getQuartertime())){
				a=Double.parseDouble(sumuser.getQuartertime());
			}
			if(StringUtils.isNotEmpty(sumuser.getQuartertrue())){
				 c=Double.parseDouble(sumuser.getQuartertrue());
			}
			Double b=Double.parseDouble(sumuser.getQuarternum());
			sumuser.setQuartertime(numformate(a,b));					
			sumuser.setQuartertrue(numformate(c,b));
		}
		//������˵Ĳ����ڱ���ʱ�ʺ�׼ȷ��
		if(StringUtils.isNotEmpty(sumuser.getNotimenum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getNotime())){
				a=Double.parseDouble(sumuser.getNotime());
			}
			if(StringUtils.isNotEmpty(sumuser.getNotimetrue())){
				 c=Double.parseDouble(sumuser.getNotimetrue());
			}
			Double b=Double.parseDouble(sumuser.getNotimenum());
			sumuser.setNotime(numformate(a,b));					
			sumuser.setNotimetrue(numformate(c,b));
		}
		dto.setUsersum(sumuser);
		dto.setMap(map);
		return dto;
	}
	
	private String numformate(double a,double b){
		if(b==0){
			 return (a*100)+"%";
		}
		BigDecimal b1 = new BigDecimal(Double.toString(a));
	    BigDecimal b2 = new BigDecimal(Double.toString(b));
	    double fen=b1.divide(b2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
	    DecimalFormat df1 = new DecimalFormat("##%");    //##%   �ٷֱȸ�ʽ
	    String baifenbi= df1.format(fen);  
	    return baifenbi;
		
	}
	
	
	
	
	
	/**
	 * ��ر�����ϸҳ ��Ϣ��ѯ
	 * @param dto
	 * @return
	 */
	public IGSMR08DTO searchListForDetailAction(IGSMR08DTO dto) throws BLException{
		log.debug("================��ر�����ϸҳ ��Ϣ��ѯ������ʼ================");
		
		//��ѯformȡ��
		IGSMR0803Form form = dto.getIgsmr0803Form();
		
		//��װ��ѯ���������趨
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();
		
		//��װ��ѯ����(��ԱID)
		cond.setUserid(form.getUserid());
		
		//��װ��ѯ����(����ID)
		cond.setOrgid(form.getOrgid());
		
		//����taskBL��ѯ
		List<ReportDetailVWInfo> detailList = fillInQualityAssessVWBL.searchListForDetailByUser(cond);
		
		//����һ��map keyΪuserid valueΪdetailList �ϲ���Ԫ����
		Map<String,List<ReportDetailVWInfo>> map = new LinkedHashMap<String,List<ReportDetailVWInfo>>();
		
		//������ϸ��Ϣ����
		for(ReportDetailVWInfo info : detailList){
			
			//�ж�map������key�Ƿ���� ���ظ� Ҫ�ϲ�
			if(map.get(info.getUserid()) == null){
				
				//����������װ�ظ�������List
				List<ReportDetailVWInfo> list_dou = new ArrayList<ReportDetailVWInfo>();
				
				//��װvalueֵ
				list_dou.add(info);
				
				//��װ��map�й�ҳ����ʾ
				map.put(info.getUserid(),list_dou );
				
			}else{
				
				//��map�д����ظ�key ����value�е�List��װһ����Ϣ
				map.get(info.getUserid()).add(info);
			}
		}
			
		//�ٰѲ�ѯ�����װ��dto��ȥ
		dto.setDetailMap(map);
		
		log.debug("================��ر�����ϸҳ ��Ϣ��ѯ��������================");
		return dto;
	}	

	/**
	 * ��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0804Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ������ʼ================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//��ѯ����1��Ϣ
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
//		rrcond.setOrderby("DESC");
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//��¼����չʾ���ݵ�map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();

		//��¼����1����
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//��ȡ��ѯ�������
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//ѭ�����ȱ�����ȡ�������е�ָ�����ʽ��
		for (int i = report_start; i < report_count; i++) {
			
			//��¼ǰһ���ȵ�����
			Map<String, String> map_next = new LinkedHashMap<String, String>();
				
			//��ѯ��ǰ���ȱ�����ϼ��ȱ�����Ϣ
			//��ȡ��ǰ���ȱ�����ϱ����
			String year_next = lst_lookatFillIn.get(i).getYear();
			//��ȡ��ǰ���ȱ�����ϱ�����
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//��ǰ���ȼ�һ���ȵ���0ʱ��������ָ��Ϊ�ģ���ݼ�һ��������ݲ��䣬���ȼ�һ��
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//����ǰ���ȱ�����ϼ��ȱ�������Ϣʱ����¼�ϼ��ȱ������Ϣ
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//���ʽ��ֵ
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK, lst_next.get(0).getPrid(), null);
				//ѭ����ѯ���ı��ʽ��
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//��ȡ���ȱ���
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//���ʽ��ֵ
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK, info.getPrid(), null);
		
			
			//ѭ����ѯ���ı��ʽ��
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//��װ����
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_4.equals(objectTable[1]) || string.equals(objectTable[1])){
								objectTable[2] = "0";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_1.equals(string)){
								objectTable[2] = "2";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_3.equals(string)){
								objectTable[2] = "1";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_2.equals(string) 
									&& IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_1.equals(objectTable[1])){
								objectTable[2] = "1";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_2.equals(string) 
									&& IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_3.equals(objectTable[1])){
								objectTable[2] = "2";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//��װmap
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("��").append(info.getQuarter()).append("����");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//��ʾ������4��ʱ���˳�ѭ��
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}

		//�������ż����Ĳ�ȫ
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//��װ����
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//��װmap
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ��������================");
		
		return dto;
	}
	
	/**
	 * ��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0805Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ������ʼ================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//��ѯ����1��Ϣ
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//��¼����չʾ���ݵ�map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();
		
		//��¼����1����
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//��ȡ��ѯ�������
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//ѭ�����ȱ�����ȡ�������е�ָ�����ʽ��
		for (int i = report_start; i < report_count; i++) {
			
			//��¼ǰһ���ȵ�����
			Map<String, String> map_next = new LinkedHashMap<String, String>();

			//��ѯ��ǰ���ȱ�����ϼ��ȱ�����Ϣ
			//��ȡ��ǰ���ȱ�����ϱ����
			String year_next = lst_lookatFillIn.get(i).getYear();
			//��ȡ��ǰ���ȱ�����ϱ�����
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//��ǰ���ȼ�һ���ȵ���0ʱ��������ָ��Ϊ�ģ���ݼ�һ��������ݲ��䣬���ȼ�һ��
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//����ǰ���ȱ�����ϼ��ȱ�������Ϣʱ����¼�ϼ��ȱ������Ϣ
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//���ʽ��ֵ
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_ONLINE, lst_next.get(0).getPrid(), null);
				//ѭ����ѯ���ı��ʽ��
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//��ȡ���ȱ���
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//���ʽ��ֵ
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_ONLINE, info.getPrid(), null);
		
			
			//ѭ����ѯ���ı��ʽ��
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//��װ����
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							//��ָ������ת��Ϊ��ֵ���ͽ��бȽ�
							Double valueOf1 = Double.valueOf(string);//�ϸ����ȵ�ָ����
							Double valueOf2 = Double.valueOf(objectTable[1]);//��ǰ���ȵ�ָ����
							if(valueOf1.compareTo(valueOf2) == 0){
								objectTable[2] = "0";
							}else if(valueOf1.compareTo(valueOf2)  < 0){
								objectTable[2] = "2";
							}else if(valueOf1.compareTo(valueOf2)  >  0){
								objectTable[2] = "1";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//��װmap
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("��").append(info.getQuarter()).append("����");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//��ʾ������4��ʱ���˳�ѭ��
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}
		
		//�������ż����Ĳ�ȫ
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//��װ����
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//��װmap
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ��������================");
		
		return dto;
	}
	
	/**
	 * ���п�ϵͳ�������ͳ�Ƴ�ʼ����ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0806Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================���п�ϵͳ�������ͳ�Ƴ�ʼ����ѯ������ʼ================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//��ѯ����1��Ϣ
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//��¼����չʾ���ݵ�map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();
		
		//��¼����1����
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//��ȡ��ѯ�������
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//ѭ�����ȱ�����ȡ�������е�ָ�����ʽ��
		for (int i = report_start; i < report_count; i++) {
			
			//��¼ǰһ���ȵ�����
			Map<String, String> map_next = new LinkedHashMap<String, String>();
				
			//��ѯ��ǰ���ȱ�����ϼ��ȱ�����Ϣ
			//��ȡ��ǰ���ȱ�����ϱ����
			String year_next = lst_lookatFillIn.get(i).getYear();
			//��ȡ��ǰ���ȱ�����ϱ�����
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//��ǰ���ȼ�һ���ȵ���0ʱ��������ָ��Ϊ�ģ���ݼ�һ��������ݲ��䣬���ȼ�һ��
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//����ǰ���ȱ�����ϼ��ȱ�������Ϣʱ����¼�ϼ��ȱ������Ϣ
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//���ʽ��ֵ
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_BANKCARD, lst_next.get(0).getPrid(), null);
				//ѭ����ѯ���ı��ʽ��
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//��ȡ���ȱ���
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//���ʽ��ֵ
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_BANKCARD, info.getPrid(), null);
		
			
			//ѭ����ѯ���ı��ʽ��
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//��װ����
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							//��ָ������ת��Ϊ��ֵ���ͽ��бȽ�
							Double valueOf1 = Double.valueOf(string);//�ϸ����ȵ�ָ����
							Double valueOf2 = Double.valueOf(objectTable[1]);//��ǰ���ȵ�ָ����
							if(valueOf1.compareTo(valueOf2) == 0){
								objectTable[2] = "0";
							}else if(valueOf1.compareTo(valueOf2)  < 0){
								objectTable[2] = "2";
							}else if(valueOf1.compareTo(valueOf2)  >  0){
								objectTable[2] = "1";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//��װmap
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("��").append(info.getQuarter()).append("����");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//��ʾ������4��ʱ���˳�ѭ��
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}
		
		//�������ż����Ĳ�ȫ
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//��װ����
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//��װmap
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================��������ϵͳ�������ͳ�Ƴ�ʼ����ѯ��������================");
		
		return dto;
	}
}
