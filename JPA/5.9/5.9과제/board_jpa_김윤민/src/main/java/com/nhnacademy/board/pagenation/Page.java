package com.nhnacademy.board.pagenation;

import java.util.List;

public interface Page<T> {
    // 현재 페이지 번호
    int getPageNumber();
    // 한페이지에 보여줄 게시물 게수
    int getPageSize();
    int getTotalPageCount();
    // 총 게시물 수
    int getTotalCount();
    // 게시물 목록
    List<T> getList();
}
