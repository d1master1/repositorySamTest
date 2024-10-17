import java.util.Scanner;

public static void main() {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("""
            Выбирете что нужно тестировать:
            Введите 3, чтобы протестировать Задание 3
            Введите 4, чтобы протестировать Задание 4
            """);
    int Variant = scanner.nextInt();
    if (Variant == 3)TriangleType();
    else if (Variant == 4)QuadraticEquationSolver();
    else System.out.println("Такого задания нет!!!");
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
    public static void QuadraticEquationSolver() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

        solveQuadraticEquation(a, b, c);
    }
    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Коэффициент a не должен быть равен 0.");
            return;
        }
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Уравнение имеет два корня: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Уравнение имеет один корень: x = " + x);
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
}