package training.journal.fragments.settings

import android.os.Bundle
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import kotlinx.android.synthetic.main.fragment_account_settings.*
import retrofit2.Response
import training.journal.R
import training.journal.api.Api
import training.journal.dto.FatherNameDto
import training.journal.dto.FirstNameDto
import training.journal.dto.LastNameDto
import training.journal.dto.UserDto
import training.journal.fragments.BaseFragment
import training.journal.repository.CurrentUserRepository
import training.journal.utils.auth.AuthorizationHelper
import training.journal.utils.logger.Logger
import training.journal.utils.toast.ToastUtils
import java.net.HttpURLConnection

class AccountSettingsFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = CurrentUserRepository.currentUser.value
        currentUser?.let { user ->
            last_name_header.text = user.lastName
            first_name_header.text = user.firstName
            father_name_header.text = user.fatherName
            user_image.setImageURI(user.pictureUrlStr)

            context?.let {
                last_name_ll.setOnClickListener { _ ->
                    MaterialDialog(it).show {
                        title(R.string.last_name)
                        negativeButton(R.string.close) { mt ->
                            mt.cancel()
                        }
                        input(
                                prefill = CurrentUserRepository.currentUser.value?.lastName,
                                maxLength = 30,
                                callback = { dialog, lastName ->
                                    val lastNameStr = lastName.toString()
                                    if (AuthorizationHelper.isCorrectName(lastNameStr)) {
                                        taskContainer.add(Api.changeUserData(
                                                user.id,
                                                LastNameDto(lastNameStr),
                                                CurrentUserRepository.getCurrentUserToken(it) ?: ""
                                        ).subscribe(
                                                { response ->
                                                    run {
                                                        val userDto = response.body()
                                                        userDto?.lastName = lastNameStr
                                                        onResponse(response, userDto)
                                                    }
                                                },
                                                { throwable -> onFail(throwable) }
                                        ))
                                    }
                                })
                    }
                    first_name_ll.setOnClickListener { _ ->
                        MaterialDialog(it).show {
                            title(R.string.first_name)
                            negativeButton(R.string.close) { mt ->
                                mt.cancel()
                            }
                            input(
                                    prefill = CurrentUserRepository.currentUser.value?.firstName,
                                    maxLength = 30,
                                    callback = { dialog, firstName ->
                                        val firstNameStr = firstName.toString()
                                        if (AuthorizationHelper.isCorrectName(firstNameStr)) {
                                            taskContainer.add(Api.changeUserData(
                                                    user.id,
                                                    FirstNameDto(firstNameStr),
                                                    CurrentUserRepository.getCurrentUserToken(it)
                                                            ?: ""
                                            ).subscribe(
                                                    { response ->
                                                        run {
                                                            val userDto = response.body()
                                                            userDto?.firstName = firstNameStr
                                                            onResponse(response, userDto)
                                                        }
                                                    },
                                                    { throwable -> onFail(throwable) }
                                            ))
                                        } else {
                                            ToastUtils.showLongToast(it, R.string.incorrect_first_name)
                                        }
                                    }
                            )
                        }
                    }
                    father_name_ll.setOnClickListener { _ ->
                        MaterialDialog(it).show {
                            title(R.string.father_name)
                            negativeButton(R.string.close) { mt ->
                                mt.cancel()
                            }
                            input(
                                    prefill = CurrentUserRepository.currentUser.value?.fatherName,
                                    maxLength = 30,
                                    callback = { dialog, fatherName ->
                                        val fatherNameStr = fatherName.toString()
                                        if (AuthorizationHelper.isCorrectName(fatherNameStr)) {
                                            taskContainer.add(Api.changeUserData(
                                                    user.id,
                                                    FatherNameDto(fatherNameStr),
                                                    CurrentUserRepository.getCurrentUserToken(it)
                                                            ?: ""
                                            ).subscribe(
                                                    { response ->
                                                        run {
                                                            val userDto = response.body()
                                                            userDto?.fatherName = fatherNameStr
                                                            onResponse(response, userDto)
                                                        }
                                                    },
                                                    { throwable -> onFail(throwable) }
                                            ))
                                        } else {
                                            ToastUtils.showLongToast(it, R.string.incorrect_father_name)
                                        }
                                    }
                            )
                        }
                    }
                    user_image_ll.setOnClickListener { _ ->
                    }
                }
            }
        }
    }

    private fun onResponse(response: Response<UserDto>, userDto: UserDto?) {
        when (response.code()) {
            HttpURLConnection.HTTP_OK -> {
                userDto?.let {
                    CurrentUserRepository.currentUser.value = it.toUserInfo()
                    last_name_header.text = it.lastName
                    first_name_header.text = it.firstName
                    father_name_header.text = it.fatherName
                    user_image.setImageURI(it.pictureUrlStr)
                }
                Logger.d(this, "successfully changed user data with code ${response.code()}")
            }
            else -> {
                context?.let {
                    ToastUtils.showLongToast(it, R.string.server_not_available)
                }
                Logger.d(this, "unsuccessfully changed user data with code ${response.code()}")
            }
        }
    }

    private fun onFail(throwable: Throwable) {
        context?.let {
            ToastUtils.showLongToast(it, R.string.failed_change_user_data)
        }
        Logger.e(this, "Login failed : ${throwable.message}")
    }

    override fun getFragmentLayoutId(): Int = R.layout.fragment_account_settings
}
