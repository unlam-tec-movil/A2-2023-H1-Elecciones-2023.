package ar.edu.unlam.mobile2.data

interface PartyRepo {
    fun getParties(): List<PartyCollection>
}