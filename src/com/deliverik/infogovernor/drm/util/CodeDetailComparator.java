/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.util;

import java.util.Comparator;

import com.deliverik.framework.model.CodeDetail;

/**
 * CodeDetail���ѯ����Ƚ���
 * ����cid�ֶε�ֵ˳��������ҪΪ�˱�֤��ѯ˳������
 */
public class CodeDetailComparator implements Comparator<Object> {
	public int compare(Object one, Object two) {
		CodeDetail oneInfo = (CodeDetail) one;
		CodeDetail twoInfo = (CodeDetail) two;
		if(!oneInfo.getCid().equals(twoInfo.getCid()))
			return Integer.parseInt(oneInfo.getCid())>Integer.parseInt(twoInfo.getCid())? 1:-1;
		else
			return Integer.parseInt(oneInfo.getCid())>Integer.parseInt(twoInfo.getCid())? 1:-1;
	}
}