import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.RenderTarget
import org.openrndr.extensions.Screenshots
import org.openrndr.math.Vector2
import org.openrndr.workshop.toolkit.filters.StepWaves
import org.openrndr.workshop.toolkit.filters.VerticalStepWaves


fun main(args: Array<String>) {
    application {
        configure {
            width = 480
            height = 640
        }
        program {
            extend(Screenshots().apply {
                scale = 4.0
            })
            extend {

                val scale = (RenderTarget.active.width.toDouble() / width)

                val stepWaves = VerticalStepWaves()
                val stepWaves2 = StepWaves()
                poster(drawer) {
                    drawer.background(ColorRGBa.BLACK)

                    stepWaves.phase = seconds
                    stepWaves2.phase = seconds

                    layer(post = listOf(stepWaves2, stepWaves)) {
                        drawer.fill = ColorRGBa.WHITE
                        drawer.stroke = null
                        drawer.circle(Vector2(width / 2.0, height / 2.0), 200.0)
                    }
                }

            }

        }
    }
}
