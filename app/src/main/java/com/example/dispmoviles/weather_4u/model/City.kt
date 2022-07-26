package com.example.dispmoviles.weather_4u.model


class City {
    val cities = mapOf("Montevideo" to Coordinates(-34.8335, 56.1674),
        "Punta del Este" to Coordinates(-34.9667,-54.95),
        "Colonia" to Coordinates(-34.1667, -57.5),
        "Canelones" to Coordinates(-34.5228, -56.2778),
        "Salto" to Coordinates(-31.3833, -57.9667),
        "Paysandú" to Coordinates(-32.3214, -58.0756),
        "Tacuarembo" to Coordinates(-31.7333, -55.9833),
        "Durazno" to Coordinates(-33.4131, -56.5006),
        "Florida" to Coordinates(-33.8333,-55.9167),
        "Cerro Largo" to Coordinates(-32.3333, -54.3333),
        "Río Negro" to Coordinates(-33.1325, -58.2956),
        "Soriano" to Coordinates(-33.5,-57.75),
        "Flores" to Coordinates(-33.5389,-56.8886),
        "Buenos Aires" to Coordinates(-34.6132, 58.3772),
        "New York" to Coordinates(40.7143, -74.006)
    )

    fun getCityCoordinates(name: String): Coordinates? {
        return cities[name] as Coordinates
    }
}