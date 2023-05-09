package ar.edu.unlam.mobile2.data

data class Party(
    val id: Long,
    val name: String,
    val imageUrl: Int,
)

data class PartyCollection(
    val name: String,
    val parties: List<Party>
)
//TODO eliminar collection