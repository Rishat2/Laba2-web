package app.model;

import app.entities.Point;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();

    private List<Point> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(Point point) {
        model.add(point);
    }

    /*public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }*/
    public List<Point> getList(){
        return model;
    }
}
