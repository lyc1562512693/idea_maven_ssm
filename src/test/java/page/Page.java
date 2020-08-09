package page;

import java.util.List;

public class Page<T> {

	protected int pageNo = 1;
	protected int pageSize = 15;
	protected int offset;
	protected int limit;
	protected int currentPage;
	protected int totalPages;
	protected int totalCount;
	protected List<T> result;

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getOffset() {
		return (pageNo - 1) * pageSize;
	}

	public int getLimit() {
		return limit;
	}

	public Page() {
		limit = pageSize;
		offset = getOffset();
	}

	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		limit = pageSize;
		offset = getOffset();
	}

	public int getTotalPages() {
		if (totalCount % pageSize == 0) {
			totalPages = totalCount / pageSize;
		} else {
			totalPages = totalCount / pageSize + 1;
		}
		return totalPages % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPages = getTotalPages();
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setResult(List<T> result){
		this.result=result;
	}
	public List<T> getResult(){
		return result;
	}

}
