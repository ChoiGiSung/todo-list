package com.codeSquad.cocokyu.domain.card;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Card {
    @Id
    private Long id;

    private String title;
    private String contents;
    private LocalDateTime createDateTime;
    private Status status;

    public Card(String title, String contents, Status status) {
        this.title = title;
        this.contents = contents;
        this.status = status;
        this.createDateTime = LocalDateTime.now();
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

}