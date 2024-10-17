import java.util.Scanner;

public static void main() {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("""
            Выбирете что нужно тестировать:
            Введите 3, чтобы протестировать Задание 3
            Введите 4, чтобы протестировать Задание 4
            """);
    int Variant = scanner.nextInt();
    if (Variant == 3){
        TriangleType();
    } else if (Variant == 4){
        
    }else System.out.println("Такого задания нет!!!");
}
private static void TriangleType() {

    String result = getTriangleType();
    System.out.println(result);
}
public static String getTriangleType() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите длину первой стороны: ");
    int a = scanner.nextInt();

    System.out.print("Введите длину второй стороны: ");
    int b = scanner.nextInt();

    System.out.print("Введите длину третьей стороны: ");
    int c = scanner.nextInt();

    if (isTriangle(a, b, c)) {
        String triangleType = determineTriangleType(a, b, c);
        return "Треугольник является: " + triangleType;
    } else {
        return "Введите корректные длины сторон. Треугольник с такими сторонами не существует.";
    }
}
public static boolean isTriangle(int a, int b, int c) {
    return (a + b > c) && (a + c > b) && (b + c > a);
}
public static String determineTriangleType(int a, int b, int c) {
    if (a == b && b == c) {
        return "равносторонним";
    } else if (a == b || b == c || a == c) {
        return "равнобедренным";
    } else if (isRightTriangle(a, b, c)) {
        return "прямоугольным";
    } else {
        return "разносторонним";
    }
}
public static boolean isRightTriangle(int a, int b, int c) {
    int[] sides = {a, b, c};
    java.util.Arrays.sort(sides);
    return (Math.abs(Math.pow(sides[0], 2) + Math.pow(sides[1], 2) - Math.pow(sides[2], 2)) < 1e-9);
}