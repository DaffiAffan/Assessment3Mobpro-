package org.d3if0146.assessment3mobpro.ui.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.d3if0146.assessment3mobpro.R

@Composable
fun DeleteDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfrimation: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            text = { Text(text = stringResource(R.string.hapus_data)) },
            confirmButton = {
                TextButton(onClick = { onConfrimation() }) {
                    Text(text = stringResource(R.string.hapus))
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismissRequest() }) {
                    Text(text = stringResource(id = R.string.batal))
                }
            },
            onDismissRequest = { onDismissRequest() }
        )
    }
}