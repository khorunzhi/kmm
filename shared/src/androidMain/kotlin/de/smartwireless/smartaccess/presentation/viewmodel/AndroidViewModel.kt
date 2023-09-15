package de.smartwireless.smartaccess.presentation.viewmodel

import androidx.lifecycle.ViewModel

abstract class AndroidViewModel: ViewModel(), DisposableViewModel {
    init {
        this.addCloseable { onDispose() }
    }
}