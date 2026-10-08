abstract class Figure(val id: Int) {
    abstract fun area(): Float
}

interface Movable {
    fun move(dx: Int, dy: Int)
}

interface Transforming {
    fun resize(zoom: Int)

    fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    )
}

enum class RotateDirection {
    Clockwise,
    CounterClockwise
}

// x и y — нижний левый угол.
class Rect(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int
) : Figure(0), Movable, Transforming {

    var color: Int = -1
    lateinit var name: String

    constructor(rect: Rect) : this(
        rect.x,
        rect.y,
        rect.width,
        rect.height
    )

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) {
            "Множитель масштаба должен быть положительным"
        }

        width *= zoom
        height *= zoom
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        val relativeX = x - centerX
        val relativeY = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX + relativeY
                y = centerY - relativeX - width
            }

            RotateDirection.CounterClockwise -> {
                x = centerX - relativeY - height
                y = centerY + relativeX
            }
        }

        val oldWidth = width
        width = height
        height = oldWidth
    }
}

// x и y — центр круга.
class Circle(
    var x: Int,
    var y: Int,
    var radius: Int
) : Figure(0), Movable, Transforming {

    override fun area(): Float {
        return (kotlin.math.PI * radius * radius).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) {
            "Множитель масштаба должен быть положительным"
        }

        radius *= zoom
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        val relativeX = x - centerX
        val relativeY = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX + relativeY
                y = centerY - relativeX
            }

            RotateDirection.CounterClockwise -> {
                x = centerX - relativeY
                y = centerY + relativeX
            }
        }
    }
}

// x и y — нижний левый угол.
class Square(
    var x: Int,
    var y: Int,
    var side: Int
) : Figure(0), Movable, Transforming {

    override fun area(): Float {
        return (side * side).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun resize(zoom: Int) {
        require(zoom > 0) {
            "Множитель масштаба должен быть положительным"
        }

        side *= zoom
    }

    override fun rotate(
        direction: RotateDirection,
        centerX: Int,
        centerY: Int
    ) {
        val relativeX = x - centerX
        val relativeY = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX + relativeY
                y = centerY - relativeX - side
            }

            RotateDirection.CounterClockwise -> {
                x = centerX - relativeY - side
                y = centerY + relativeX
            }
        }
    }
}