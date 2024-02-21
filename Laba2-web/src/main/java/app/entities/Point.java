package app.entities;

public class Point {
        Double x;
        Double y;
        int r;
        boolean t;
        public Point() {
        }
        public Point(Double x, Double y, int r, boolean t){
            this.x=x;
            this.y=y;
            this.r=r;
            this.t=t;
        }
        public void setX(Double x){
            this.x=x;
        }
        public Double getX(){
            return x;
        }
    public void setR(Double x){
        this.r=r;
    }
    public int getR(){
        return r;
    }
    public void setY(Double x){
        this.y=y;
    }
    public Double getY(){
        return y;
    }
    public void setT(boolean t){
            this.t=t;
    }
    public boolean getT(){
        return t;
    }
}
