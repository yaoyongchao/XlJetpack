package com.yyc.login.model

data class LoginResponse(
    val token: String,
    val uid: String,
    val user_sign: String,
    val username: String,
    val headimg: String
) {
    override fun toString(): String {
        return "LoginResponse(token='$token', uid='$uid', user_sign='$user_sign', username='$username', headimg='$headimg')"
    }
}