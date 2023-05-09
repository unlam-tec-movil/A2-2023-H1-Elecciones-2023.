package ar.edu.unlam.mobile2.data

data class Candidate(
    val id: Long,
    val shortName: String,
    val fullName: String,
    val imageUrl: Int,
    val party: String
)

data class CandidateCollection(
    val name: String,
    val candidates: List<Candidate>
)
//TODO eliminar collection