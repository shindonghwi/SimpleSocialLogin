package wolf.shin.simplesociallogin.social_component.google

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow
import wolf.shin.simple_social_login.SimpleSocialLoginSDK
import wolf.shin.simple_social_login.model.LoginState
import wolf.shin.simple_social_login.model.LogoutState
import wolf.shin.simple_social_login.model.UnlinkState
import wolf.shin.simplesociallogin.ui.theme.Gray300
import wolf.shin.simplesociallogin.ui.theme.Gray800
import wolf.shin.simplesociallogin.ui.theme.KakaoColor
import wolf.shin.simplesociallogin.ui.theme.OutLine60

@Composable
fun GoogleView(simpleSocialLoginSDK: SimpleSocialLoginSDK.Builder) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "구글", style = MaterialTheme.typography.h6, color = Gray800)

            Text(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Gray300)
                    .clickable {
                        simpleSocialLoginSDK.doGoogleLogin()
                    }
                    .padding(all = 4.dp),
                text = "로그인",
                style = MaterialTheme.typography.subtitle1,
                color = Gray800
            )

            Text(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Gray300)
                    .padding(all = 4.dp)
                    .clickable {
                        simpleSocialLoginSDK.doGoogleLogout()
                    },
                text = "로그아웃",
                style = MaterialTheme.typography.subtitle1,
                color = Gray800
            )

            Text(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Gray300)
                    .padding(all = 4.dp)
                    .clickable {
                        simpleSocialLoginSDK.doGoogleUnlink()
                    },
                text = "연결해제",
                style = MaterialTheme.typography.subtitle1,
                color = Gray800
            )

        }


        GoogleLoginStateView(simpleSocialLoginSDK.googleState.loginFlow)
        GoogleLogoutStateView(simpleSocialLoginSDK.googleState.logoutFlow)
        GoogleUnlinkStateView(simpleSocialLoginSDK.googleState.unlinkFlow)

        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp), color = OutLine60)
    }
}

/** 구글 로그인 텍스트 상태 */
@Composable
private fun GoogleLoginStateView(loginStateFlow: StateFlow<LoginState<String>>) {
    with(loginStateFlow.collectAsState().value) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            text = "로그인상태: ${
                when (this) {
                    is LoginState.Loading -> {
                        "Loading"
                    }
                    is LoginState.Success -> {
                        "Success: ${this.token}"
                    }
                    is LoginState.Error -> {
                        "Error: ${this.message}"
                    }
                    else -> {
                        "Init"
                    }
                }
            }",
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

/** 구글 로그아웃 텍스트 상태 */
@Composable
private fun GoogleLogoutStateView(logoutStateFlow: StateFlow<LogoutState>) {
    with(logoutStateFlow.collectAsState().value) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "로그아웃상태: ${
                when (this) {
                    is LogoutState.Loading -> {
                        "Loading"
                    }
                    is LogoutState.Success -> {
                        "Success"
                    }
                    is LogoutState.Error -> {
                        "Error: ${this.message}"
                    }
                    else -> {
                        "Init"
                    }
                }
            }",
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
    }
}

/** 구글 연결끊기 텍스트 상태 */
@Composable
private fun GoogleUnlinkStateView(unlinkStateFlow: StateFlow<UnlinkState>) {
    with(unlinkStateFlow.collectAsState().value) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "연결끊기상태: ${
                when (this) {
                    is UnlinkState.Loading -> {
                        "Loading"
                    }
                    is UnlinkState.Success -> {
                        "Success"
                    }
                    is UnlinkState.Error -> {
                        "Error: ${this.message}"
                    }
                    else -> {
                        "Init"
                    }
                }
            }",
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
    }
}
