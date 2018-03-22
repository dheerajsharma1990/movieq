package com.movieq.domain

class Movie(id: Int, title: String, description: String, rating: Double, people: List[People],
            genre: List[Genre], productionCountry: ProductionCountry) extends DomainObject {

}

