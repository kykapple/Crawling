package restaurant.list.dto;

public class PageMaker {
    private PageDTO pageDTO;
    private int totalCnt;       // 총 개수
    private int startPage;      // 시작 페이지
    private int endPage;        // 끝 페이지
    private boolean prev;       // 이전 페이지가 있는지
    private boolean next;       // 다음 페이지가 있는지
    private int displayPageCnt = 10; // 보여줄 페이지 수

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
        setPagingData();
    }

    public void setPagingData() {
        endPage = (int) (Math.ceil(pageDTO.getPage() / (double)displayPageCnt) * displayPageCnt);

        int range = (int) (Math.ceil(totalCnt / (double)pageDTO.getPerPageCnt()));
        if(endPage > range) {
            endPage = range;
            startPage = (pageDTO.getPage() / displayPageCnt) * displayPageCnt + 1;
        } else {
            startPage = endPage - displayPageCnt + 1;
        }


    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayPageCnt() {
        return displayPageCnt;
    }

    public void setDisplayPageCnt(int displayPageCnt) {
        this.displayPageCnt = displayPageCnt;
    }
}
