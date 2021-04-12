package com.codeSquad.cocokyu.domain.model;

import com.codeSquad.cocokyu.domain.annotation.ToDoStatusPattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Card {
    @Id
    private Long id;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String contents;

    @ToDoStatusPattern
    private Status status;

    @JsonIgnore
    @Embedded.Nullable
    private Logs logs = new Logs();

    private double priority;

    private LocalDateTime createDateTime;

    protected Card() {
    }

    public Card(String title, String contents, Status status, double priority) {
        this.title = title;
        this.contents = contents;
        this.status = status;
        this.priority = priority;
        this.createDateTime = LocalDateTime.now();
        logs.createLog(this);
    }

    public void modify(Card updateCard) {
        logs.updateLog(this, updateCard);
        this.title = updateCard.title;
        this.contents = updateCard.contents;
        this.status = updateCard.status;
        this.priority = updateCard.priority;
    }

    public void delete() {
        logs.deleteLog(this);
        this.status = Status.DELETED;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public double getPriority() {
        return priority;
    }

    public Logs getLogs() {
        return logs;
    }

    public enum Status {
        TODO,
        DOING,
        DONE,
        DELETED
    }
}