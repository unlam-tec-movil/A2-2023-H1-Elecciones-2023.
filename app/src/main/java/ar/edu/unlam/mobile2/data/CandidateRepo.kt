package ar.edu.unlam.mobile2.data

interface CandidateRepo {
    fun getCandidates(): List<CandidateCollection>
}