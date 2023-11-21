package com.example.article.Serice;

import com.example.article.ArticleModel.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleSerice {
    public ArrayList<Model> mod =new ArrayList<>();

    public ArrayList<Model> getAr(){

        return mod;
    }
    public void addModel(Model model){

        mod.add(model);
    }
    public boolean UpdateModel(String id,Model model){
        for (int i = 0; i <=mod.size() ; i++) {
            if (mod.get(i).getId().equals(id)) {
                mod.set(i,model);
                return true;
            }
        }
        return false;
    }
    public boolean deleteArticle(String id){
        for (int i = 0; i <=mod.size() ; i++) {
            if (mod.get(i).getId().equals(id)) {
              mod.remove(i);
              return true;
            }
        }
        return false;
    }
    public ArrayList<Model> Publish(String id){

        for (int i = 0; i <mod.size() ; i++) {
            if (mod.get(i).getId().equals(id)&& !mod.get(i).isPublished()) {


                return false;
            }
        }
        return true;
    }

    public ArrayList<Model> search( String Category ) {
      ArrayList<Model> d =new ArrayList<>();
        for (Model t : mod
        ) {
            if (t.getCategory().equals(Category)) {
              d.add(t);
                return d;
            }
        }
return mod;    }
}
