package com.supervital.feature.screens.contacts

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supervital.domain.models.UserInfo
import com.supervital.domain.usecase.UserCreateUseCase
import com.supervital.domain.usecase.UserDeleteUseCase
import com.supervital.domain.usecase.UserGetCountUseCase
import com.supervital.domain.usecase.UsersGetListUseCase
import com.supervital.feature.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    application: Application,
    private val userCreateUseCase: UserCreateUseCase,
    private val userDeleteUseCase: UserDeleteUseCase,
    private val userGetCountUseCase: UserGetCountUseCase,
    private val usersGetListUseCase: UsersGetListUseCase
) : ViewModel() {
    var userName = mutableStateOf("")
    var resultCheck = mutableStateOf(Any())
    var userAge = mutableStateOf("")
    private val _foundUsers = MutableLiveData<Boolean>()
    val foundUsers: LiveData<Boolean> = _foundUsers

    val getStringUserNameExists = application.getString(R.string.user_name_exists)

    fun getUsers() = usersGetListUseCase()

    fun changeName(value: String) {
        userName.value = value
        checkData()
        checkNameExists()
    }

    fun checkNameExists() {
        if (userName.value.isEmpty()) {
            _foundUsers.postValue(false)
            return
        }
        viewModelScope.launch (Dispatchers.IO ) {
            val isError = userGetCountUseCase(userName.value) != 0
            _foundUsers.postValue(isError)
            if (isError && resultCheck.value is ResultCheck.ResultOk) {
                resultCheck.value = ResultCheck.NameExists()
            }
        }
    }

    fun changeAge(value: String) {
        if(value.isNotEmpty() && !value.isNumeric()) {
            return
        }
        userAge.value = value
        checkData()
    }

    fun checkData() {
        resultCheck.value = when {
            userName.value.isEmpty() -> ResultCheck.NameMustEnter()
            userAge.value.length == 0 || !userAge.value.isNumeric() -> ResultCheck.BadAge()
            else -> ResultCheck.ResultOk()
        }
    }

    fun addUser(name: String, age: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userCreateUseCase(UserInfo( -1, name, age.toInt()))
        }
    }

    fun deleteUser(user_id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            userDeleteUseCase(user_id)
        }
    }

}

fun String.isNumeric(): Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return this.matches(regex)
}