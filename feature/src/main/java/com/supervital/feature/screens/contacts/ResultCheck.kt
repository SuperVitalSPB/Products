package com.supervital.feature.screens.contacts

sealed class ResultCheck () {
    class ResultOk() : ResultCheck()
    class NameExists() : ResultCheck()
    class NameMustEnter() : ResultCheck()
    class BadAge() : ResultCheck()
}