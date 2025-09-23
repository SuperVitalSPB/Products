package com.supervital.data.mappers

import com.supervital.data.database.entries.UserEntry
import com.supervital.domain.models.UserInfo

private const val BAD_ID = -1

fun UserEntry.map() = UserInfo(
    id = this.id ?: BAD_ID,
    name = this.name,
    age = this.age
)

fun UserInfo.map() = UserEntry(
    id = this.id.takeUnless { it == BAD_ID },
    name = this.name,
    age = this.age
)