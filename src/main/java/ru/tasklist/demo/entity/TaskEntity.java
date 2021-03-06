package ru.tasklist.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Table(name = "task", schema = "tasklist")
public class TaskEntity {
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    private PriorityEntity priority;
    private CategoryEntity category;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "completed")
    public Integer getCompleted() {
        return completed;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    public PriorityEntity getPriority() {
        return priority;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public CategoryEntity getCategory() {
        return category;
    }



}
