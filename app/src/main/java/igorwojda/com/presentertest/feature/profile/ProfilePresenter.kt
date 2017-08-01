package igorwojda.com.presentertest.feature.profile

import org.greenrobot.eventbus.EventBus

class ProfilePresenter<VIEW : ProfileView>(private val eventBus: EventBus) {
    private var view: VIEW? = null

    fun onTakeView(view: VIEW) {
        this.view = view

        eventBus.register(this)
    }

    fun onDropView() {
        eventBus.unregister(this)
    }

    fun onLoadUserData() {
        view?.showLoading()
    }
}
