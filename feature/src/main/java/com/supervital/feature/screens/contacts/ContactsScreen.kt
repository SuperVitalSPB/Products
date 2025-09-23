package com.supervital.feature.screens.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.supervital.domain.models.UserInfo

@Composable
fun ContactsScreen(vm: UserViewModel = hiltViewModel()) {
    val userList = vm.getUsers()
        .collectAsState(initial = emptyList())
    val isUserNameExists by vm.foundUsers.observeAsState(false)
    var name by remember { vm.userName }
    var resultCheck by remember { vm.resultCheck }

    val focusRequester = remember { FocusRequester() }

    Column {
        OutlinedTextField(
            value = name,
            label = { Text("Name") },
            modifier = Modifier
                .padding(8.dp)
                .focusRequester(focusRequester),
            onValueChange = { vm.changeName(it) },
            isError = isUserNameExists,
            supportingText = {
                if (isUserNameExists) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = vm.getStringUserNameExists,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        OutlinedTextField(
            value = vm.userAge.value,
            label = { Text("Age") },
            modifier = Modifier
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            onValueChange = { vm.changeAge(it) }
        )

        Button(
            onClick = {
                vm.apply {
                    addUser(userName.value, userAge.value)
                    userName.value = ""
                    userAge.value = ""
                    checkData()
                    focusRequester.requestFocus()
                }
            },
            enabled = resultCheck is ResultCheck.ResultOk,
            modifier = Modifier
                .padding(8.dp),
        ) {
            Text(
                text = "Add",
                fontSize = 24.sp
            )
        }

        UserList(
            users = userList.value,
            delete = { vm.deleteUser(it) }
        )
    }
}

@Composable
fun UserList(users: List<UserInfo>,
             delete: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .width(900.dp)
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .matchParentSize()
                .padding(top = 15.dp)
        ) {
            item {UserTitleRow() }
            items(users) { user ->
                UserRow(user) { delete(user.id) }
            }
        }
    }
}

@Composable
fun UserRow(user: UserInfo, onDelete: (Int) -> Unit) {
    // val onItemClick = { id: Int -> selectedId = id }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(
                if (user.id % 2 == 0)
                    Color.Green
                else
                    Color.Transparent
            )
            .clickable {
                // onItemClick.invoke(user.id)
            }
    ) {
        Text(
            text = user.id.toString(),
            modifier = Modifier.weight(0.1f),
            fontSize = 24.sp
        )
        Text(
            text = user.name,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = user.age.toString(),
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = "Delete",
            color = Color(0xFF6650A4),
            fontSize = 24.sp,
            modifier = Modifier
                .weight(0.2f)
                .clickable { onDelete(user.id) }
        )
    }
}

@Composable
fun UserTitleRow() {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "ID",
            color = Color.White,
            modifier = Modifier.weight(0.1f),
            fontSize = 24.sp
        )
        Text(
            text = "Name",
            color = Color.White,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Text(
            text = "Age",
            color = Color.White,
            modifier = Modifier.weight(0.2f),
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.weight(0.2f))
    }
}
