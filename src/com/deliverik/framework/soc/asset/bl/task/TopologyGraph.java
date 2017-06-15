/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

/**
 * ����: ����ͼ
 * ��������: ��Žڵ�������Ϊ�����ɵĽڵ�ID
 * ������¼: 2011/04/20
 * �޸ļ�¼: 
 */
class TopologyGraph {
	private int nodecount = 1;

	public int getNodecount() {
		return nodecount;
	}

	public int getRootid() {
		return 1;
	}

	public void setNodecount(int nodecount) {
		this.nodecount = nodecount;
	}

	public void increase() {
		this.nodecount++;
	}

	public static String filterStr(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		StringBuffer buf = new StringBuffer();
		char ch = ' ';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else if (ch == '"') {
				buf.append("&quot;");
			} else if (ch == '\'') {
				buf.append("&apos;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

}
