package ru.job4j.solid.lsp;

/*
Ожидается, что изменение ширины и высоты Rectangle приведёт к изменению площади согласно формуле width * height.
Однако Square нарушает это предположение, изменяя и ширину, и высоту.
 */
class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

class Example2 {
    public static void main(String[] args) {
        Rectangle rect = new Square();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Area: " + rect.calculateArea());
    }
}
