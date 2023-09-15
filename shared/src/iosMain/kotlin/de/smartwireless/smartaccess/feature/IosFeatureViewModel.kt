package de.smartwireless.smartaccess.feature

class IosFeatureViewModel(
    id: Int,
    interactor: FeatureInteractor
): FeatureViewModel by RealFeatureViewModel(id = id, interactor = interactor)