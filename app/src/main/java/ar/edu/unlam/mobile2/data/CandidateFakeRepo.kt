package ar.edu.unlam.mobile2.data

import ar.edu.unlam.mobile2.R

object CandidateFakeRepo : CandidateRepo {
    override fun getCandidates(): List<CandidateCollection> = candidatesCollectionList
}

private val candidatesCollectionList = listOf(
    CandidateCollection(
        name = "Los candidatos son:",
        candidates = listOf(
            Candidate(
                id = 1L,
                shortName = "Cand. 1",
                fullName = "Candidato 1",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 1"
            ),
            Candidate(
                id = 2L,
                shortName = "Cand. 2",
                fullName = "Candidato 2",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 2.a"
            ),
            Candidate(
                id = 3L,
                shortName = "Cand. 3",
                fullName = "Candidato 3",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 3"
            ),
            Candidate(
                id = 4L,
                shortName = "Cand. 4",
                fullName = "Candidato 4",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 3"
            ),
            Candidate(
                id = 5L,
                shortName = "Cand. 5",
                fullName = "Candidato 5",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 3"
            ),
            Candidate(
                id = 6L,
                shortName = "Cand. 6",
                fullName = "Candidato 6",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 2.a"
            ),
            Candidate(
                id = 7L,
                shortName = "Cand. 7",
                fullName = "Candidato 7",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 3"
            ),
            Candidate(
                id = 8L,
                shortName = "Cand. 8",
                fullName = "Candidato 8",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 2.a"
            ),
            Candidate(
                id = 9L,
                shortName = "Cand. 9",
                fullName = "Candidato 9",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 2.b"
            ),
            Candidate(
                id = 10L,
                shortName = "Cand. 10",
                fullName = "Candidato 10",
                imageUrl = R.drawable.candidate_placeholder,
                party = "Partido 3"
            )
        )
    )
)