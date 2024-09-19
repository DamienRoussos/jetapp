package com.example.jetapp.data.datasource

import com.example.jetapp.domain.model.CuisineType
import com.example.jetapp.domain.model.Restaurant

class MockData {
    fun loadMockData(): List<Restaurant> {
        return listOf(
            Restaurant(
                "Pret A Manger - Paternoster Square", "EC4M", "EC4M 7DY", listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Coffee")
                ), 5.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/114934.gif"
            ),
            Restaurant(
                "Starbucks - Paternoster Square", "EC4M", "EC4M 7DX", listOf(
                    CuisineType("Breakfast"),
                    CuisineType("Coffee"),
                    CuisineType("Lunch")
                ), 5.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/147838.gif"
            ),
            Restaurant(
                "Gourmet Burger Kitchen - St Pauls", "EC4M", "EC4M 8AL", listOf(
                    CuisineType("Burgers"),
                    CuisineType("American")
                ), 4.1, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/130434.gif"
            ),
            Restaurant(
                "Five Guys - St Paul's", "EC4M", "EC4M 8AY", listOf(
                    CuisineType("Burgers"),
                    CuisineType("Milkshakes")
                ), 4.5, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/187448.gif"
            ),
            Restaurant(
                "The Veg Box Cafe", "CT1", "CT1 2HG", listOf(
                    CuisineType("Breakfast"),
                    CuisineType("Lunch")
                ), 4.4, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/154351.gif"
            ),
            Restaurant(
                "Greggs - Canterbury, 22 St Georges St", "CT1", "CT1 2SS", listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Breakfast"),
                    CuisineType("Lunch")
                ), 3.4, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/124996.gif"
            ),
            Restaurant(
                "KFC Canterbury - Whitefriars Shopping Centre", "CT1", "CT1 2LE", listOf(
                    CuisineType("Chicken"),
                    CuisineType("American"),
                    CuisineType("Lunch")
                ), 3.6, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/92751.gif"
            ),
            Restaurant(
                "The Old Buttermarket - Nicholson's", "CT1", "CT1 2HW", listOf(
                    CuisineType("Pies "),
                    CuisineType("Pub Food")
                ), 3.7, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/156849.gif"
            ),
            Restaurant(
                "Pret A Manger - Canterbury", "CT1", "CT1 2JL", listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Coffee")
                ), 3.3, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/119427.gif"
            ),
            Restaurant(
                "Kick-Ass Burrito - Canterbury", "CT1", "CT1 2JS", listOf(
                    CuisineType("Mexican"),
                    CuisineType("Burritos"),
                    CuisineType("Lunch"),
                    CuisineType("Sandwiches")
                ), 3.3, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/236654.gif"
            ),
            Restaurant(
                "Stacks Burgers Canterbury", "CT1", "CT1 2JS", listOf(
                    CuisineType("Burgers"),
                    CuisineType("Desserts"),
                    CuisineType("Lunch")
                ), 4.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/245353.gif"
            ),
            Restaurant(
                "Starbucks - Canterbury", "CT1", "CT1 2JT", listOf(
                    CuisineType("Breakfast"),
                    CuisineType("Coffee"),
                    CuisineType("Lunch")
                ), 2.5, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/152988.gif"
            ),
            Restaurant(
                "Subway - Broad Quay", "BS1", "BS1 4DA", listOf(
                    CuisineType("Sandwiches"),
                    CuisineType("Lunch")
                ), 3.8, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/102746.gif"
            ),
            Restaurant(
                "Sainsbury's - Bristol Hippodrome Loc", "BS1", "BS1 4DA", listOf(
                    CuisineType("Groceries"),
                    CuisineType("Convenience")
                ), 3.7, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/194923.gif"
            ),
            Restaurant(
                "Turtle Bay - Bristol Broad Quay", "BS1", "BS1 4DA", listOf(
                    CuisineType("Caribbean"),
                    CuisineType("Chicken")
                ), 4.5, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/238239.gif"
            ),
            Restaurant(
                "Pieminister - Broad Quay", "BS1", "BS1 4DA", listOf(
                    CuisineType("Pies "),
                    CuisineType("British")
                ), 4.2, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/229203.gif"
            ),
            Restaurant(
                "Super Nonna - Bristol Baldwin Street", "BS1", "BS1 1SA", listOf(
                    CuisineType("Pasta"),
                    CuisineType("Italian")
                ), 4.7, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/226089.gif"
            ),
            Restaurant(
                "Miller & Carter - Bristol City Centre", "BS1", "BS1 5TA", listOf(
                    CuisineType("Steak"),
                    CuisineType("Burgers")
                ), 4.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/155664.gif"
            ),
            Restaurant(
                "Locked 'n Loaded - College Green", "BS1", "BS1 5SP", listOf(
                    CuisineType("Chicken"),
                    CuisineType("Burgers")
                ), 1.7, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/208577.gif"
            ),
            Restaurant(
                "Chik Box - College Green", "BS1", "BS1 5SP", listOf(
                    CuisineType("Chicken"),
                    CuisineType("Burgers")
                ), 2.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/182403.gif"
            ),
            Restaurant(
                "Pizza Amore - College Green", "BS1", "BS1 5SP", listOf(
                    CuisineType("Pizza"),
                    CuisineType("Italian")
                ), 1.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/243476.gif"
            ),
            Restaurant(
                "The Burger District - Walton Breck Road", "L4", "L4 0RD", listOf(
                    CuisineType("Burgers"),
                    CuisineType("Chicken")
                ), 1.5, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/225396.gif"
            ),
            Restaurant(
                "Grill & Eat Anfield", "L4", "L4 0RD", listOf(
                    CuisineType("Kebab"),
                    CuisineType("Pizza")
                ), 4.1, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/213648.gif"
            ),
            Restaurant(
                "Kims Anfield Supper Bar", "L4", "L4 0TJ", listOf(
                    CuisineType("Fish & Chips"),
                    CuisineType("Grill")
                ), 4.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/222115.gif"
            ),
            Restaurant(
                "Chop N Shayo", "L4", "L4 0RY", listOf(
                    CuisineType("Chicken"),
                    CuisineType("African")
                ), 4.4, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/233565.gif"
            ),
            Restaurant(
                "Pizza Rojin", "L4", "L4 0UQ", listOf(
                    CuisineType("Pizza"),
                    CuisineType("Alcohol")
                ), 4.3, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/133255.gif"
            ),
            Restaurant(
                "One Stop Liverpool Priory Rd", "L4", "L4 2RX", listOf(
                    CuisineType("Groceries"),
                    CuisineType("Alcohol")
                ), 4.7, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/211636.gif"
            ),
            Restaurant(
                "ABI Mini Mart", "L4", "L4 2RN", listOf(
                    CuisineType("Convenience")
                ), 3.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/251013.gif"
            ),
            Restaurant(
                "One Stop - Liverpool Breckfield N", "L4", "L5 4QT", listOf(
                    CuisineType("Groceries"),
                    CuisineType("Alcohol")
                ), 4.0, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/203193.gif"
            ),
            Restaurant(
                "NSNS News", "L4", "L5 4NJ", listOf(
                    CuisineType("Convenience")
                ), 4.2, "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/227891.gif"
            )
        )
    }
}


