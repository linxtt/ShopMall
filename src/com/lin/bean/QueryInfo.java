package com.lin.bean;

public class QueryInfo {
	
	private int currentpage = 1;// ��¼�û��뿴��ҳ�棬���Դӿͻ����ύ���ݹ�����Ĭ���ǵ�һҳ
	private int pagesize = 10;// �û�һҳ������ʾ�����������Դӿͻ����ύ���ݹ�����Ĭ���ǵ�����
	private int startindex;// �ӵڼ�����ʼ��ѯ,���Լ����������


	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStartindex() {
		// �������ѯ�Ŀ�ʼλ��
		// ��ѯ��ʼλ��==(��ǰҳ��-1)*��ʾ��������
		this.startindex = (this.currentpage - 1) * this.pagesize;
		return startindex;
	}

	public void setStartindex(int startindex) {

		this.startindex = startindex;
	}

	
}
