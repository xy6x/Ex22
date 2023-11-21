package com.example.article.ArticleModel;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {
    @NotNull(message = "please enter ID")
    private String id;
    @NotNull(message = "please enter title")
    @Size(max = 100)
    private String title;
    @NotNull(message = "please enter author")
    @Size(min = 4 ,max = 20)
    private String author;
    @NotNull(message = "please enter content")
    @Size(min = 20)
    private String content;
    @NotNull(message = "please enter category")
@Pattern(regexp = "(politics|sports|technology)",message = "The entry is incorrect")
    private String category;
    @NotNull(message = "please enter imageUrl")
    private String imageUrl;
@AssertFalse
private boolean isPublished;

private String publishDate;
}
