package igorwojda.com.presentertest.feature

import com.nhaarman.mockito_kotlin.then
import igorwojda.com.presentertest.feature.profile.ProfilePresenter
import igorwojda.com.presentertest.feature.profile.ProfileView
import org.greenrobot.eventbus.EventBus
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class ProfilePresenterTest {
    private lateinit var presenter: ProfilePresenter<ProfileView>

    @JvmField @Rule var mockitoRule = MockitoJUnit.rule()
    @Mock private lateinit var mockEventBus: EventBus
    @Mock private lateinit var mockView: ProfileView

    @Before
    fun setUp() {
        presenter = ProfilePresenter(mockEventBus)
    }

    @Test
    fun when_take_view_then_register_event_bus() {
        // when
        presenter.onTakeView(mockView)

        // then
        then(mockEventBus).should().register(presenter)
    }

    @Test
    fun when_drop_view_then_unregister_event_bus() {
        // when
        presenter.onDropView()

        // then
        then(mockEventBus).should().unregister(presenter)
    }

    @Test
    fun when_load_users_then_show_loading() {
        //given
        presenter.onTakeView(mockView)

        //when
        presenter.onLoadUserData()

        //then
        then(mockView).should().showLoading()
    }
}
