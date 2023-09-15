package de.smartwireless.smartaccess.feature

import de.smartwireless.smartaccess.presentation.viewmodel.AndroidViewModel

class AndroidFeatureViewModel(
    id: Int,
    interactor: FeatureInteractor
): AndroidViewModel(), FeatureViewModel by RealFeatureViewModel(id = id, interactor = interactor)

