import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Shape{
public int GetArea(){return 0;}
private int height;
private int width;
private int radius;
public void setRadius(int newValue){
    radius = newValue;
}
public void setHeight(int newValue){
    height = newValue;
}
public void setWidth(int newValue){
    width = newValue;
}
public int getHeight(){
    height = height;
    return height;
}
public int getWidth(){
    width = width;
    return width;
}

public double getRadius(){
    radius = radius;
    return radius;
}


}

 class Rectangle extends Shape{


public int GetArea(){
    {int area = getHeight() * getWidth();
    return area;
    }
}
public Rectangle(int i, int j){
setHeight(i);
setWidth(j);
}

}


 class Triangle extends Shape{

public int GetArea(){
    {double area = (getHeight() * getWidth())/2;
    return (int) Math.round(area);
    }
}
public Triangle(int i, int j){
setHeight(i);
setWidth(j);
}

}


 class Circle extends Shape{



public int GetArea(){
    {   double pi = 3.14;
        double area = pi*getRadius()*getRadius();
    return (int) Math.round(area);
    }
}
public Circle(int i){
setRadius(i);
}

}
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String rawInput;
        try {
            rawInput = in.nextLine();

            String[] parameters = rawInput.split(" ");

            int rectHeight = Integer.parseInt(parameters[0]);
            int rectWidth = Integer.parseInt(parameters[1]);

            int triHeight = Integer.parseInt(parameters[2]);
            int triWidth = Integer.parseInt(parameters[3]);

            int cirRadius = Integer.parseInt(parameters[4]);

            int totalArea = 0;

            List<Shape> shapes = new ArrayList<>();
            shapes.add(new Rectangle(rectHeight, rectWidth));
            shapes.add(new Triangle(triHeight, triWidth));
            shapes.add(new Circle(cirRadius));

            for(Shape shape : shapes)
            {
                totalArea += shape.GetArea();
            }

            System.out.println(String.valueOf(totalArea));

        } catch (Exception e) {
        }
    }
}
