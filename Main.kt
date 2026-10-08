fun main() {
    val rect = Rect(2, 2, 4, 2)

    println("Прямоугольник")
    println("Начало: x=${rect.x}, y=${rect.y}, ширина=${rect.width}, высота=${rect.height}, площадь=${rect.area()}")
    check(rect.area() == 8f)

    rect.move(1, -1)
    println("Перемещение: x=${rect.x}, y=${rect.y}")
    check(rect.x == 3 && rect.y == 1 && rect.width == 4 && rect.height == 2)

    rect.resize(3)
    println("Масштабирование: ширина=${rect.width}, высота=${rect.height}, площадь=${rect.area()}")
    check(rect.x == 3 && rect.y == 1 && rect.width == 12 && rect.height == 6 && rect.area() == 72f)

    rect.rotate(RotateDirection.Clockwise, 3, -3)
    println("По часовой: x=${rect.x}, y=${rect.y}, ширина=${rect.width}, высота=${rect.height}")
    check(rect.x == 7 && rect.y == -15 && rect.width == 6 && rect.height == 12 && rect.area() == 72f)

    rect.rotate(RotateDirection.CounterClockwise, 3, -3)
    println("Обратно: x=${rect.x}, y=${rect.y}, ширина=${rect.width}, высота=${rect.height}")
    check(rect.x == 3 && rect.y == 1 && rect.width == 12 && rect.height == 6)

    println()

    val circle = Circle(4, 3, 2)

    println("Круг")
    println("Начало: x=${circle.x}, y=${circle.y}, радиус=${circle.radius}, площадь=${circle.area()}")
    check(kotlin.math.abs(circle.area() - 12.566371f) < 0.0001f)

    circle.move(1, -1)
    println("Перемещение: x=${circle.x}, y=${circle.y}")
    check(circle.x == 5 && circle.y == 2 && circle.radius == 2)

    circle.resize(3)
    println("Масштабирование: радиус=${circle.radius}, площадь=${circle.area()}")
    check(circle.x == 5 && circle.y == 2 && circle.radius == 6)
    check(kotlin.math.abs(circle.area() - 113.097336f) < 0.0001f)

    circle.rotate(RotateDirection.Clockwise, 3, -3)
    println("По часовой: x=${circle.x}, y=${circle.y}, радиус=${circle.radius}")
    check(circle.x == 8 && circle.y == -5 && circle.radius == 6)

    circle.rotate(RotateDirection.CounterClockwise, 3, -3)
    println("Обратно: x=${circle.x}, y=${circle.y}, радиус=${circle.radius}")
    check(circle.x == 5 && circle.y == 2 && circle.radius == 6)

    println()

    val square = Square(2, 2, 3)

    println("Квадрат")
    println("Начало: x=${square.x}, y=${square.y}, сторона=${square.side}, площадь=${square.area()}")
    check(square.area() == 9f)

    square.move(1, -1)
    println("Перемещение: x=${square.x}, y=${square.y}")
    check(square.x == 3 && square.y == 1 && square.side == 3)

    square.resize(2)
    println("Масштабирование: сторона=${square.side}, площадь=${square.area()}")
    check(square.x == 3 && square.y == 1 && square.side == 6 && square.area() == 36f)

    square.rotate(RotateDirection.Clockwise, 3, -3)
    println("По часовой: x=${square.x}, y=${square.y}, сторона=${square.side}")
    check(square.x == 7 && square.y == -9 && square.side == 6 && square.area() == 36f)

    square.rotate(RotateDirection.CounterClockwise, 3, -3)
    println("Обратно: x=${square.x}, y=${square.y}, сторона=${square.side}")
    check(square.x == 3 && square.y == 1 && square.side == 6)

    // Проверка координат с рисунка задания.
    val example = Rect(2, 2, 4, 2)

    example.rotate(RotateDirection.Clockwise, 3, -3)
    check(example.x == 8 && example.y == -6 && example.width == 2 && example.height == 4)

    example.rotate(RotateDirection.CounterClockwise, 3, -3)
    check(example.x == 2 && example.y == 2 && example.width == 4 && example.height == 2)

    example.rotate(RotateDirection.CounterClockwise, 3, -3)
    check(example.x == -4 && example.y == -4 && example.width == 2 && example.height == 4)

    // Поворот круга вокруг собственного центра.
    circle.rotate(RotateDirection.Clockwise, circle.x, circle.y)
    check(circle.x == 5 && circle.y == 2 && circle.radius == 6)

    // Использование общего типа Figure.
    val figures: List<Figure> = listOf(rect, circle, square)
    check(figures.size == 3 && figures.all { it.area() > 0f })

    println()
    println("Все проверки пройдены")
}