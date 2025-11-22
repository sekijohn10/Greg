package greg.newborn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform