package common.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT_TABLE")
public class Comment {

    @Id @GeneratedValue
    private long id;

    private String value;

    private Date date;

    @JsonBackReference
    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;

    public Comment(){}

    public Comment(String value, Date date, Question question, User user) {
        this.value = value;
        this.date = date;
        this.question = question;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
