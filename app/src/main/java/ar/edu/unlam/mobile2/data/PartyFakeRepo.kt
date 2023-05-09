package ar.edu.unlam.mobile2.data

import ar.edu.unlam.mobile2.R

object PartyFakeRepo : PartyRepo {
    override fun getParties(): List<PartyCollection> = partyCollectionList
}

private val partyCollectionList = listOf(
    PartyCollection(
        name = "Los partidos son:",
        parties = listOf(
            Party(
                id = 1L,
                name = "Partido 1",
                imageUrl = R.drawable.candidate_placeholder,
            ),
            Party(
                id = 2L,
                name = "Partido 2",
                imageUrl = R.drawable.candidate_placeholder,
            ),
            Party(
                id = 3L,
                name = "Partido 3",
                imageUrl = R.drawable.candidate_placeholder,
            )
        )
    )
)