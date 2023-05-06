package com.nhnacademy.todo.repository.impl;

import com.nhnacademy.todo.domain.Event;
import com.nhnacademy.todo.repository.EventRepository;
import com.nhnacademy.todo.share.UserIdStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//이 파일은 jdbc를 이용해 데이터를 처리해줄 때 사용하는 것 같음. my batis이용할 땐 사용 x
//primary 어노테이션?
@Slf4j
@Primary
@Repository
@RequiredArgsConstructor
public class DbEventRepository implements EventRepository {
    private final DataSource dataSource;
    Connection connection = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    Event result = null;


    @Override
    public Event save(Event event) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.setAutoCommit(false);
            String sql = "insert into event(subject, user_id, event_at) values(?,?,?)";
            //sql 작성 또다른 방법
            //String sql2 = "insert into event set subject=?, user_id=?, event_at=? created_at=now()";

            //sql injection
            int index = 0;
            psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(++index, event.getSubject());
            psmt.setString(++index, UserIdStore.getUserId());
            psmt.setObject(++index, event.getEventAt());
            psmt.executeUpdate();

            //select_last_id()
            rs = psmt.getGeneratedKeys();
            connection.commit();
            if (rs.next()) {
                long eventId = rs.getLong(1);
                result = getEvent(eventId);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
        //.git
    }

    @Override
    public void update(Event event) {
        try {
            connection = dataSource.getConnection();
        } catch(SQLException e ) {
            throw new RuntimeException(e);
        }

        try{
            connection.setAutoCommit(false);

            String sql = "insert into event(subject, user_id, event_at) values(?,?,?)";


        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(String userId, long eventId) {
        try{
            connection = dataSource.getConnection();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "delete from event where id= ? and user_id= ?";
        try{
            psmt = connection.prepareStatement(sql);
            psmt.setString(1, userId);
            psmt.setLong(2, eventId);
            rs = psmt.executeQuery();

            if (rs.next()) {
                LocalDate localDate = rs.getDate("event_at").toLocalDate();
                Event event = new Event(rs.getString("user_id"), rs.getString("subject"), localDate);
                event.setId(rs.getLong("id"));
                result = event;
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Event getEvent(String userId, long eventId) {
        return null;
    }



    @Override
    public Event getEvent(long eventId) {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Event result = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "select id, subject, user_id, event_at, created_at from event where id =?";
        try {
            psmt = connection.prepareStatement(sql);
            psmt.setLong(1, eventId);
            rs = psmt.executeQuery();
            if (rs.next()) {
                LocalDate localDate = rs.getDate("event_at").toLocalDate();
                Event event = new Event(rs.getString("user_id"), rs.getString("subject"), localDate);
                event.setId(rs.getLong("id"));
//                result = getEvent(event);
                result = event;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(psmt)) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Objects.nonNull(rs)) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return result;
        }
    }

    @Override
    public List<Event> findAllByDay(String userId, int year, int month, int day) {
        return null;
    }

    @Override
    public List<Event> findAllByMonth(String userId, int year, int month) {
        return null;
    }

    @Override
    public long countByUserIdAndEventAt(String userId, LocalDate targetDate) {
        return 0;
    }

    @Override
    public void deletebyDaily(String userId, LocalDate targetDate) {

    }

    @Override
    public void init() {

    }
}
