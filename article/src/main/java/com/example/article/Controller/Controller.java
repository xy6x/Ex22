package com.example.article.Controller;

import com.example.article.ArticleModel.Model;
import com.example.article.Serice.ArticleSerice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Cont")
@RequiredArgsConstructor
public class Controller {
    private final ArticleSerice articleSerice;

    @GetMapping("/get")
    public ResponseEntity getArticle() {
        ArrayList<Model> m1 = articleSerice.getAr();
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }

    @PostMapping("/add")
    public ResponseEntity addArticle(@RequestBody @Valid Model model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        articleSerice.addModel(model);
        return ResponseEntity.status(HttpStatus.OK).body("Article added");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity updateArticle(@PathVariable String id, @RequestBody @Valid Model model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        boolean isUpdate = articleSerice.UpdateModel(id, model);
        if (isUpdate) {
            return ResponseEntity.status(HttpStatus.OK).body("blog update");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable String id) {
        boolean isDelete = articleSerice.deleteArticle(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("blog deleted");

        }
        return ResponseEntity.status(400).body("wrong id");

    }
    public ResponseEntity PublishArticle(){
      return null;
    }

    public ResponseEntity Published(){

        return null;
    }
public ResponseEntity newsArticles(@PathVariable String n){
return null;

}

}
