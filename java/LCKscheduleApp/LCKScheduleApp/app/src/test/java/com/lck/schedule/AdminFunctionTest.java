package com.lck.schedule;

import com.lck.schedule.dao.MatchDAO;
import com.lck.schedule.dao.CommentDAO;
import com.lck.schedule.dto.Match;
import com.lck.schedule.dto.Comment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminFunctionTest {

    MatchDAO matchDAO = new MatchDAO();
    CommentDAO commentDAO = new CommentDAO();

    // Testcase 1: 경기 수정
    @Test
    public void testModifySchedule() {
        Match match = new Match("LCK2025S1G03", LocalDate.now(), LocalTime.of(18, 0),
                "T1", "GEN", "서울", 0, 0);
        matchDAO.insert(match);

        match.setTeamA("KT");
        match.setTeamB("HLE");
        match.setLocation("부산");
        match.setScoreA(2);
        match.setScoreB(1);
        matchDAO.updateMatch(match);

        Match updated = matchDAO.findById("LCK2025S1G03");
        assertEquals("KT", updated.getTeamA());
        assertEquals("HLE", updated.getTeamB());
        assertEquals("부산", updated.getLocation());
        assertEquals(2, updated.getScoreA());
        assertEquals(1, updated.getScoreB());
    }

    // Testcase 2: 댓글 수정
    @Test
    public void testEditComment() {
        Comment comment = new Comment();
        comment.setUserId("jinser02");
        comment.setMatchId("LCK2025S1G03");
        comment.setContent("수정 전 댓글");
        comment.setTimestamp(LocalDateTime.now());
        commentDAO.save(comment);

        List<Comment> list = commentDAO.findByMatchId("LCK2025S1G03");
        assertFalse(list.isEmpty());
        Comment saved = list.get(list.size() - 1);

        commentDAO.update(saved.getCommentId(), "수정된 댓글입니다");

        List<Comment> updatedList = commentDAO.findByMatchId("LCK2025S1G03");
        boolean modified = updatedList.stream()
                .anyMatch(c -> c.getCommentId() == saved.getCommentId()
                        && "수정된 댓글입니다".equals(c.getContent()));
        assertTrue(modified);
    }

    // Testcase 3: 댓글 삭제
    @Test
    public void testDeleteComment() {
        Comment comment = new Comment();
        comment.setUserId("jinser02");
        comment.setMatchId("LCK2025S1G03");
        comment.setContent("삭제할 댓글");
        comment.setTimestamp(LocalDateTime.now());
        commentDAO.save(comment);

        List<Comment> list = commentDAO.findByMatchId("LCK2025S1G03");
        assertFalse(list.isEmpty());
        Comment saved = list.get(list.size() - 1);

        commentDAO.delete(saved.getCommentId());

        List<Comment> afterDelete = commentDAO.findByMatchId("LCK2025S1G03");
        boolean stillExists = afterDelete.stream()
                .anyMatch(c -> c.getCommentId() == saved.getCommentId());
        assertFalse(stillExists);
    }
}
