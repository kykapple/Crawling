package restaurant.list.dto;

public class PageDTO {
    private int page;           // 현재 페이지 정보
    private int perPageCnt;     // 페이지 당 보여줄 개수

    public PageDTO() {
        this.page = 1;
        this.perPageCnt = 10;
    }

    public int getPageStart() {
        return (this.page - 1) * perPageCnt;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPageCnt() {
        return perPageCnt;
    }

    public void setPerPageCnt(int perPageCnt) {
        this.perPageCnt = perPageCnt;
    }
}
