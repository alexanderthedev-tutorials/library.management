package com.tutorials.library.management.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {
    private Long id;
    private String title;
    private String author;
}
