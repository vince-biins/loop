package com.project.loop.domain.model

import com.project.loop.R

data class Post(
    val id: Int,
    val user: User,
    val details: PostDetails,
    val comments: Comments,
    val reactions: Reactions,
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val avatar: Any,
    val cover: String,
    val bio: String,
    val website: String,
)

data class PostDetails(
    val id: Int,
    val description: String,
    val hashtags: String,
    val image: Any,
)

data class Comments(
    val count: Int,
    val comments: List<Comment>,
)

data class Comment(
    val id: Int,
    val user: User,
    val comment: String,
)

data class Reactions(
    val count: Int,
    val user: List<User>,
)
