package com.movieq.domain

class Movie(val id: Int, val title: String, val description: String, val rating: Double, val people: List[People],
            val genre: List[Genre], val productionCountry: ProductionCountry) extends DomainObject {


}

