/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.cic.form.IGCIC0201Form;
import com.deliverik.infogovernor.cic.form.IGCIC0203Form;
import com.deliverik.infogovernor.cic.form.IGCIC0204Form;
import com.deliverik.infogovernor.cic.form.IGCIC0205Form;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.vo.IGCIC02022VO;
import com.deliverik.infogovernor.cic.vo.IGCIC02032VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ա��������ҵ����DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02DTO extends BaseDTO implements Serializable{

	/** �Ա�ִ�������ѯ����FORM */
	private IGCIC0201Form igcic0201Form;

	/** �����ѯ������¼�� */
    protected int maxSearchCount;

    /** ��ҳBean */
    protected PagingDTO pagingDto;
    
    /** �Աȼ�¼���� */
    protected List<CompareprocessInfo> compareprocessList;
    
    /** �ȶԽ��Map */
    protected Map<String, List<IGCIC02022VO>> resultVoMap;
    
    /** �ȶ���������� */
    protected Integer cpid;
    
    /** ƥ������ϸҳ����Form */
    protected IGCIC0203Form igcic0203Form;
    protected IGCIC0205Form igcic0205Form;
    
    /** ҳ����ʾ��Map key��ҳ����ʾ���� value����ʾ����Map key��ģ������ value�������б� */
    protected Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap;
    
    /** �ȶԽ������ */
    protected CompareresultInfo compareresultInfo;
    
    /** �ԱȽ����ϸ����FORM */
    protected IGCIC0204Form igcic0204Form;
    
    /**�����������*/
    private Map<String,TreeNode> treeMap;
    
    private SOC0124Info soc0124Info;
    
    private Map<String,String> sourceMap;
    private Map<String,String> targetMap;
    
    /** 
     * �Ա�ִ�������ѯ����FORM ȡ��
     * @return igcic0201Form �Ա�ִ�������ѯ����FORM 
     */
    public IGCIC0201Form getIgcic0201Form() {
        return igcic0201Form;
    }

    /** 
     * �Ա�ִ�������ѯ����FORM �趨
     * @param igcic0201Form �Ա�ִ�������ѯ����FORM 
     */
    public void setIgcic0201Form(IGCIC0201Form igcic0201Form) {
        this.igcic0201Form = igcic0201Form;
    }

    /** 
     * �����ѯ������¼�� ȡ��
     * @return maxSearchCount �����ѯ������¼�� 
     */
    public int getMaxSearchCount() {
        return maxSearchCount;
    }

    /** 
     * �����ѯ������¼�� �趨
     * @param maxSearchCount �����ѯ������¼�� 
     */
    public void setMaxSearchCount(int maxSearchCount) {
        this.maxSearchCount = maxSearchCount;
    }

    /** 
     * ��ҳBean ȡ��
     * @return pagingDto ��ҳBean 
     */
    public PagingDTO getPagingDto() {
        return pagingDto;
    }

    /** 
     * ��ҳBean �趨
     * @param pagingDto ��ҳBean 
     */
    public void setPagingDto(PagingDTO pagingDto) {
        this.pagingDto = pagingDto;
    }

    /** 
     * �Աȼ�¼���� ȡ��
     * @return compareprocessList �Աȼ�¼���� 
     */
    public List<CompareprocessInfo> getCompareprocessList() {
        return compareprocessList;
    }

    /** 
     * �Աȼ�¼���� �趨
     * @param compareprocessList �Աȼ�¼���� 
     */
    public void setCompareprocessList(List<CompareprocessInfo> compareprocessList) {
        this.compareprocessList = compareprocessList;
    }

    /** 
     * �ȶԽ��Map ȡ��
     * @return resultVoMap �ȶԽ��Map 
     */
    public Map<String, List<IGCIC02022VO>> getResultVoMap() {
        return resultVoMap;
    }

    /** 
     * �ȶԽ��Map �趨
     * @param resultVoMap �ȶԽ��Map 
     */
    public void setResultVoMap(Map<String, List<IGCIC02022VO>> resultVoMap) {
        this.resultVoMap = resultVoMap;
    }

    /** 
     * �ȶ���������� ȡ��
     * @return cpid �ȶ���������� 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * �ȶ���������� �趨
     * @param cpid �ȶ���������� 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    /** 
     * ƥ������ϸҳ����Form ȡ��
     * @return igcic0203Form ƥ������ϸҳ����Form 
     */
    public IGCIC0203Form getIgcic0203Form() {
        return igcic0203Form;
    }

    /** 
     * ƥ������ϸҳ����Form �趨
     * @param igcic0203Form ƥ������ϸҳ����Form 
     */
    public void setIgcic0203Form(IGCIC0203Form igcic0203Form) {
        this.igcic0203Form = igcic0203Form;
    }

    /** 
     * ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� ȡ��
     * @return cic0203ShowMap ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� 
     */
    public Map<String, Map<String, IGCIC02032VO>> getCic0203ShowMap() {
        return cic0203ShowMap;
    }

    /** 
     * ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� �趨
     * @param cic0203ShowMap ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� 
     */
    public void setCic0203ShowMap(Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap) {
        this.cic0203ShowMap = cic0203ShowMap;
    }

    /** 
     * �ȶԽ������ ȡ��
     * @return compareresultInfo �ȶԽ������ 
     */
    public CompareresultInfo getCompareresultInfo() {
        return compareresultInfo;
    }

    /** 
     * �ȶԽ������ �趨
     * @param compareresultInfo �ȶԽ������ 
     */
    public void setCompareresultInfo(CompareresultInfo compareresultInfo) {
        this.compareresultInfo = compareresultInfo;
    }

    /** 
     * �ԱȽ����ϸ����FORM ȡ��
     * @return igcic0204Form �ԱȽ����ϸ����FORM 
     */
    public IGCIC0204Form getIgcic0204Form() {
        return igcic0204Form;
    }

    /** 
     * �ԱȽ����ϸ����FORM �趨
     * @param igcic0204Form �ԱȽ����ϸ����FORM 
     */
    public void setIgcic0204Form(IGCIC0204Form igcic0204Form) {
        this.igcic0204Form = igcic0204Form;
    }

	public IGCIC0205Form getIgcic0205Form() {
		return igcic0205Form;
	}

	public void setIgcic0205Form(IGCIC0205Form igcic0205Form) {
		this.igcic0205Form = igcic0205Form;
	}

	public Map<String, TreeNode> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(Map<String, TreeNode> treeMap) {
		this.treeMap = treeMap;
	}

	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	public Map<String, String> getSourceMap() {
		return sourceMap;
	}

	public void setSourceMap(Map<String, String> sourceMap) {
		this.sourceMap = sourceMap;
	}

	public Map<String, String> getTargetMap() {
		return targetMap;
	}

	public void setTargetMap(Map<String, String> targetMap) {
		this.targetMap = targetMap;
	}
	
	
    
	
}


