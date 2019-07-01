package common.server.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "QUESTION_TABLE")
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String content;

    private Date date;

    private String category;

    @OneToMany(cascade = ALL)
    private List<Option> options;


    @JsonManagedReference
    @OneToMany(mappedBy = "question")
    private List<Comment> comments;

    @ManyToOne
    private User user;

    public Question() {
    }

    public Question(String title, String content, Date date, String category, List<Option> options, List<Comment> comments, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
        this.options = options;
        this.comments = comments;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
