package cn.regentsoft.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Administrator on 2016/12/2 0002.
 *
 */
public class Movie extends BaseObservable {

    private String id;
    private String name;
    private String year;
    private int image;
    private int rating;

    public Movie() {
    }

    public Movie(String id, String title, String year, int image, int rating) {
        this.id = id;
        this.name = title;
        this.year = year;
        this.image = image;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged(cn.regentsoft.databindingdemo.BR.name);
        notifyChange();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", image=" + image +
                ", rating=" + rating +
                '}';
    }
}
