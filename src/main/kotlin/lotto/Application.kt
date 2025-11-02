package lotto

fun main() {
    val appConfig = AppConfig()
    val controller = appConfig.controller()
    controller.run()
}
