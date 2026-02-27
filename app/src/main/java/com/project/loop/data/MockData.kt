package com.project.loop.data

import com.project.loop.R
import com.project.loop.domain.model.Comment
import com.project.loop.domain.model.Comments
import com.project.loop.domain.model.Post
import com.project.loop.domain.model.PostDetails
import com.project.loop.domain.model.Reactions
import com.project.loop.domain.model.User


object MockData {
    private val avatars = listOf(
        R.drawable.avatar_1,
        R.drawable.avatar_2,
        R.drawable.avatar_3,
        R.drawable.avatar_4
    )

    private val samples = listOf(
        R.drawable.sample_1,
        R.drawable.sample_2,
        R.drawable.sample_3,
        R.drawable.sample_4,
        R.drawable.sample_5,
        R.drawable.sample_6,
        R.drawable.sample_7,
        R.drawable.sample_8
    )

    val users = listOf(
        User(
            id = 1,
            name = "John Doe",
            username = "johndoe",
            avatar = avatars[0],
            cover = "",
            bio = "Android Developer",
            website = "https://johndoe.com"
        ),
        User(
            id = 2,
            name = "Jane Smith",
            username = "janesmith",
            avatar = avatars[1],
            cover = "",
            bio = "UI/UX Designer",
            website = "https://janesmith.design"
        ),
        User(
            id = 3,
            name = "Alice Johnson",
            username = "alicej",
            avatar = avatars[2],
            cover = "",
            bio = "Content Creator",
            website = "https://alicej.me"
        ),
        User(
            id = 4,
            name = "Bob Brown",
            username = "bobb",
            avatar = avatars[3],
            cover = "",
            bio = "Photographer",
            website = "https://bobb.photo"
        )
    )

    val posts = listOf(
        Post(
            id = 1,
            user = users[0],
            details = PostDetails(
                id = 1,
                description = "Beautiful sunset today!",
                hashtags = "#sunset #nature",
                image = samples[0]
            ),
            comments = Comments(
                count = 2,
                comments = listOf(
                    Comment(1, users[1], "Wow, amazing shot!"),
                    Comment(2, users[2], "I love the colors.")
                )
            ),
            reactions = Reactions(
                count = 10,
                user = listOf(users[1], users[2], users[3])
            )
        ),
        Post(
            id = 2,
            user = users[1],
            details = PostDetails(
                id = 2,
                description = "Working on a new project.",
                hashtags = "#coding #android",
                image = samples[1]
            ),
            comments = Comments(
                count = 5,
                comments = listOf(
                    Comment(3, users[0], "Good luck with that!"),
                    Comment(4, users[3], "Can't wait to see it.")
                )
            ),
            reactions = Reactions(
                count = 25,
                user = listOf(users[0], users[2])
            )
        ),
        Post(
            id = 3,
            user = users[2],
            details = PostDetails(
                id = 3,
                description = "Exploring the city.",
                hashtags = "#travel #city",
                image = samples[2]
            ),
            comments = Comments(
                count = 1,
                comments = listOf(
                    Comment(5, users[1], "Which city is this?")
                )
            ),
            reactions = Reactions(
                count = 15,
                user = listOf(users[0], users[1], users[3])
            )
        ),
        Post(
            id = 4,
            user = users[3],
            details = PostDetails(
                id = 4,
                description = "Delicious food!",
                hashtags = "#food #yummy",
                image = samples[3]
            ),
            comments = Comments(
                count = 8,
                comments = listOf(
                    Comment(6, users[2], "Looks delicious!")
                )
            ),
            reactions = Reactions(
                count = 40,
                user = listOf(users[0], users[1], users[2])
            )
        ),
        Post(
            id = 5,
            user = users[0],
            details = PostDetails(
                id = 5,
                description = "Morning hike.",
                hashtags = "#hike #fitness",
                image = samples[4]
            ),
            comments = Comments(
                count = 3,
                comments = listOf(
                    Comment(7, users[3], "Great way to start the day!")
                )
            ),
            reactions = Reactions(
                count = 20,
                user = listOf(users[1], users[2])
            )
        ),
        Post(
            id = 6,
            user = users[1],
            details = PostDetails(
                id = 6,
                description = "New office setup.",
                hashtags = "#office #setup",
                image = samples[5]
            ),
            comments = Comments(
                count = 12,
                comments = listOf(
                    Comment(8, users[0], "Very clean setup.")
                )
            ),
            reactions = Reactions(
                count = 100,
                user = listOf(users[0], users[2], users[3])
            )
        ),
        Post(
            id = 7,
            user = users[2],
            details = PostDetails(
                id = 7,
                description = "Reading a great book.",
                hashtags = "#books #reading",
                image = samples[6]
            ),
            comments = Comments(
                count = 0,
                comments = emptyList()
            ),
            reactions = Reactions(
                count = 5,
                user = listOf(users[3])
            )
        ),
        Post(
            id = 8,
            user = users[3],
            details = PostDetails(
                id = 8,
                description = "Peaceful lake view.",
                hashtags = "#lake #peace",
                image = samples[7]
            ),
            comments = Comments(
                count = 4,
                comments = listOf(
                    Comment(9, users[1], "So tranquil.")
                )
            ),
            reactions = Reactions(
                count = 30,
                user = listOf(users[0], users[1], users[2])
            )
        )
    )
}
