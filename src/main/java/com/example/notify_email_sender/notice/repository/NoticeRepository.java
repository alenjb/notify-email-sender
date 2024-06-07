package com.example.notify_email_sender.notice.repository;

import com.example.notify_email_sender.common.domain.NoticeCategory;
import com.example.notify_email_sender.common.domain.NoticeType;
import com.example.notify_email_sender.notice.domain.Notice;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository<T extends Notice, ID extends Long> extends JpaRepository<Notice, Long> {
    public Optional<Notice> findByNoticeId(Long noticeId);

    /**
     * 타입과 일치하는 모든 공지사항들을 페이지 번호에 맞게 조회한다.
     * @param noticeType 공지사항 종류
     * @param pageable 조회할 페이지 정보
     * @return 페이지 정보 및 공지사항들
     */
    @Query("SELECT n FROM Notice n WHERE n.noticeType = :noticeType ORDER BY n.noticeId DESC")
    Page<Notice> findAllByNoticeType(@Param("noticeType") NoticeType noticeType, Pageable pageable);

    /**
     * 타입과 일치하는 모든 공지사항들을 페이지 번호에 맞게 조회한다.
     * @param noticeType 공지사항 종류
     * @param pageable 조회할 페이지 정보
     * @return 페이지 정보 및 공지사항들
     */
    @Query("SELECT n FROM Notice n WHERE n.noticeType = :noticeType and n.noticeCategory = :noticeCategory ORDER BY n.noticeId DESC")
    Page<Notice> findAllByNoticeTypeAndCategory(NoticeType noticeType, Pageable pageable, NoticeCategory noticeCategory);
}
