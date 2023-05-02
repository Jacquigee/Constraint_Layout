package com.example.constraintlayout.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayout.R


@Preview(showBackground = true)
@Composable
fun MovieBookingScreen() {
    Surface(color = Color.White) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (
                menuButton, coverImage, titleText, genreText, ratingText, castText, castContainer,
                castImage1, castImage2, castImage3, castImage4, descText, bottomSurface, bookButton,
                cinemaNameContainer,
            ) = createRefs()

            Icon(painter = painterResource(
                id = R.drawable.ic_menu
            ),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .constrainAs(menuButton) {
                        start.linkTo(parent.start, 16.dp)
                        top.linkTo(parent.top, 16.dp)
                    })

            val rightGuideline = createGuidelineFromStart(0.4f)

            Image(
                painter = painterResource(id = R.drawable.cover_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .constrainAs(coverImage) {
                        start.linkTo(parent.start, 24.dp)
                        top.linkTo(menuButton.bottom, 16.dp)
                        end.linkTo(rightGuideline, 16.dp)
                        width = Dimension.fillToConstraints
                    }
                    .aspectRatio(2f / 3f),
            )

            Text(
                text = "Deadpool",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(menuButton.bottom, 8.dp)
                        start.linkTo(coverImage.end, 16.dp)
                    }
            )

            Text(
                text = "Action | 1h 48m",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier
                    .constrainAs(genreText) {
                        top.linkTo(titleText.bottom)
                        start.linkTo(coverImage.end, 16.dp)
                    }
            )

            Text(
                text = "IMDb 8.0/10",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .constrainAs(ratingText) {
                        top.linkTo(genreText.bottom, 16.dp)
                        start.linkTo(coverImage.end, 16.dp)
                    }
            )

            Text(
                text = "CAST",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(castText) {
                    bottom.linkTo(castContainer.top)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            ConstraintLayout(modifier = Modifier.constrainAs(castContainer) {
                bottom.linkTo(coverImage.bottom)
                start.linkTo(coverImage.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            }) {
                Image(painter = painterResource(id = R.drawable.cast1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage1) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(coverImage.end, 16.dp)
                        }
                        .aspectRatio(1f))

            }

        }
    }


}