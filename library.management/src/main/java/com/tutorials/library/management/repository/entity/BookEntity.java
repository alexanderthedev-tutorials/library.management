package com.tutorials.library.management.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@Data
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity implements Serializable {
    @Id
    private Long id;
    private String title;
    private String author;
}
