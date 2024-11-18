package com.app.abc.presentation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.app.abc.R
import com.app.abc.domain.model.Occurrence
import com.app.abc.presentation.components.AppBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalysisBottomSheet(
    modifier: Modifier = Modifier,
    data: Occurrence,
    onDismiss: () -> Unit,
    bottomSheetState: SheetState
) {
    AppBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState
    ) {
        if(data.characterOccurrences.isNotEmpty()){
            Text(text = data.characterOccurrences.toString())
        }else{
            Text(text = stringResource((R.string.item_list_empty)))
        }
    }
}