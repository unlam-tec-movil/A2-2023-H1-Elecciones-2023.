package ar.edu.unlam.mobile2.ui.candidates

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ar.edu.unlam.mobile2.data.CandidateCollection
import ar.edu.unlam.mobile2.data.CandidateFakeRepo
import ar.edu.unlam.mobile2.data.PartyCollection
import ar.edu.unlam.mobile2.data.PartyFakeRepo
import ar.edu.unlam.mobile2.ui.components.CandidatesCollection
import ar.edu.unlam.mobile2.ui.components.PartiesCollection

@Composable
fun CandidatesRoute() {
    CandidatesScreen()
}

@Composable
fun CandidatesScreen() {
    //TODO
    val candidateCollections = remember { CandidateFakeRepo.getCandidates() }
    val partyCollections = remember { PartyFakeRepo.getParties() }

    CandidatesScreen(
        candidateCollections,
        partyCollections,
        onCandidateClick = { /* TODO */ },
    )
}

@Composable
private fun CandidatesScreen(
    candidateCollections: List<CandidateCollection>,
    partyCollections: List<PartyCollection>,
    onCandidateClick: (Long) -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box {
            CandidateAndPartyCollectionList(
                candidateCollections,
                partyCollections,
                onCandidateClick
            )
        }
    }
}

@Composable
private fun CandidateAndPartyCollectionList(
    candidateCollections: List<CandidateCollection>,
    partyCollections: List<PartyCollection>,
    onCandidateClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn {
            itemsIndexed(candidateCollections) { index, candidateCollection ->
                //TODO eliminar index
                CandidatesCollection(
                    candidateCollection = candidateCollection,
                    onCandidateClick = onCandidateClick
                )
            }
            itemsIndexed(partyCollections) { index, partyCollection ->
                //TODO eliminar index
                PartiesCollection(
                    partyCollection = partyCollection
                )
            }
        }
    }
}

