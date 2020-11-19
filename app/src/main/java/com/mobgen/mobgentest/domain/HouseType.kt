package com.mobgen.mobgentest.domain

import java.util.*

/**
 * Emun that expose images url for Houses by region
 */
enum class HouseType constructor(val region: String, val imageUrl: String) {
    North("The North","https://bit.ly/2Gcq0r4"),
    Vale("The Vale","https://bit.ly/34FAvws"),
    Riverlands("The Riverlands","https://bit.ly/3kJrIiP"),
    IronIslands("Iron Islands","https://bit.ly/3kJrIiP"),
    Westerlands("The Westerlands","https://bit.ly/2TAzjnO"),
    Reach("The Reach","https://bit.ly/2HSCW5N"),
    Dorne("Dorne","https://bit.ly/2HOcavT"),
    Stormlands("The Stormlands","https://bit.ly/34F2sEC");

    companion object {
        fun byRegion(region: String): HouseType? {
            return values().firstOrNull {
                it.region.toLowerCase(Locale.ROOT).equals(region.toLowerCase(Locale.ROOT), true)
            }
        }
    }

}
