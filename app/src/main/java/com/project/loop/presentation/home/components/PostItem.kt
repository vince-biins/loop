package com.project.loop.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.project.loop.base.composable.CacheableImage
import com.project.loop.base.composable.ImageShape
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.Padding
import com.project.loop.domain.model.Post
import com.project.loop.domain.model.PostDetails
import com.project.loop.domain.model.User

@Composable
fun PostItem(post: Post, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = LoopDp.EIGHT_DP,
                shape = RoundedCornerShape(LoopDp.EIGHT_DP),
                clip = true,
                spotColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
            .clip(RoundedCornerShape(LoopDp.EIGHT_DP))
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Padding.SIXTEEN_DP),
            horizontalAlignment = Alignment.Start
        ) {

            PostProfile(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Padding.SIXTEEN_DP),
                user = post.user
            )

            Spacer(modifier = Modifier.height(Padding.EIGHT_DP))

            PostDetails(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Padding.SIXTEEN_DP),
                postDetails = post.details
            )

            Spacer(modifier = Modifier.height(Padding.EIGHT_DP))

            PostImage(modifier = Modifier.fillMaxWidth(), image = post.details.image)

            Spacer(modifier = Modifier.height(Padding.EIGHT_DP))

            PostFooter(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Padding.SIXTEEN_DP),
                likes = post.reactions.count,
                comments = post.comments.count
            )
        }
    }
}

@Composable
fun PostFooter(
    modifier: Modifier = Modifier,
    likes: Int,
    comments: Int,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Padding.SIXTEEN_DP)
        ) {
            ReactionItem(icon = Icons.Outlined.FavoriteBorder, count = likes)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Padding.SIXTEEN_DP)
        ) {
            ReactionItem(icon = Icons.Outlined.ChatBubbleOutline, count = comments)
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = "Share",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ReactionItem(icon: ImageVector, count: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Padding.FOUR_DP)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


@Composable
fun PostDetails(modifier: Modifier = Modifier, postDetails: PostDetails) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = postDetails.description,
            style = MaterialTheme.typography.bodyMedium,
            softWrap = true,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = postDetails.hashtags,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun PostImage(modifier: Modifier = Modifier, image: Any) {
    CacheableImage(
        imageModel = image,
        contentDescription = null,
        shape = ImageShape.Square,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    )
}

@Composable
fun PostProfile(user: User, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CacheableImage(
            imageModel = user.avatar,
            contentDescription = user.username,
            shape = ImageShape.Circle,
            modifier = Modifier.size(LoopDp.FORTY_DP)
        )

        Column(
            modifier = Modifier.padding(start = Padding.EIGHT_DP)
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "@${user.username}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = " • ",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "2h ago", // Placeholder for now
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


