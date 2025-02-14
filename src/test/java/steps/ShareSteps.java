package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.text.DecimalFormat;

    public ShapeSteps {
    private Shape shape;
    private double actualArea;
    private double actualPerimeter;
    private static final DecimalFormat df = new DecimalFormat("#.##");

    @Дано("у меня есть круг с радиусом {double}")
    public void у_меня_есть_круг_с_радиусом(double radius) {
        shape = new Circle(radius);
    }

    @Дано("у меня есть квадрат со стороной {double}")
    public void у_меня_есть_квадрат_со_стороной(double side) {
        shape = new Square(side);
    }

    @Дано("у меня есть прямоугольник с шириной {double} и высотой {double}")
    public void у_меня_есть_прямоугольник_с_шириной_и_высотой(double width, double height) {
        shape = new Rectangle(width, height);
    }

    @Тогда("его площадь должна быть {double}")
    @Step("Проверяем площадь фигуры")
    public void его_площадь_должна_быть(double expectedArea) {
        actualArea = shape.area();
        Assertions.assertEquals(expectedArea, Double.parseDouble(df.format(actualArea)), "Площадь не совпадает");
    }

    @И("его периметр должен быть {double}")
    @Step("Проверяем периметр фигуры")
    public void его_периметр_должен_быть(double expectedPerimeter) {
        actualPerimeter = shape.perimeter();
        Assertions.assertEquals(expectedPerimeter, Double.parseDouble(df.format(actualPerimeter)), "Периметр не совпадает");
    }
}
