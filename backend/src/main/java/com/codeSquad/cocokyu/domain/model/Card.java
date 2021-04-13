package com.codeSquad.cocokyu.domain.model;

import com.codeSquad.cocokyu.domain.annotation.ToDoStatusPattern;
import com.codeSquad.cocokyu.domain.dto.CardDto;
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

    private LocalDateTime createDateTime;

    @ToDoStatusPattern
    private Status status;

    @Embedded.Nullable
    private Logs logs = new Logs();

    protected Card() {
    }

    public Card(CardDto cardDto) {
        this.title = cardDto.getTitle();
        this.contents = cardDto.getContents();
        this.status = cardDto.getStatus();
        this.createDateTime = LocalDateTime.now();
        logs.createLog(this);
    }

    public void modify(CardDto updateCardDto) {
        logs.updateLog(this, updateCardDto);
        this.title = updateCardDto.getTitle();
        this.contents = updateCardDto.getContents();
        this.status = updateCardDto.getStatus();
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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", createDateTime=" + createDateTime +
                ", status=" + status +
                ", logs=" + logs +
                '}';
    }

    public enum Status {
        TODO,
        DOING,
        DONE,
        DELETED
    }
}
