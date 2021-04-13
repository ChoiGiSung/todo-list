package com.codeSquad.cocokyu.domain.dto;

import com.codeSquad.cocokyu.domain.model.Card.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CardDto {

    @NotBlank
    @NotNull
    private final String title;

    @NotBlank
    @NotNull
    private final String contents;

    @NotNull
    private final Status status;

    public CardDto(String title, String contents, Status status) {
        this.title = title;
        this.contents = contents;
        this.status = status;
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
}
