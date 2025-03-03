package com.idekhail.an1_animation1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare Global variables for ImageView and Buttons (fields)
    private lateinit var imageView: ImageView
    private lateinit var blinkBTN: Button
    private lateinit var rotateBTN: Button
    private lateinit var fadeBTN: Button
    private lateinit var moveBTN: Button
    private lateinit var slideBTN: Button
    private lateinit var zoomBTN: Button
    private lateinit var stopBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ImageView and Buttons using their IDs
        imageView = findViewById(R.id.imageview)

        blinkBTN = findViewById(R.id.BTNblink)
        rotateBTN = findViewById(R.id.BTNrotate)
        fadeBTN = findViewById(R.id.BTNfade)
        moveBTN = findViewById(R.id.BTNmove)
        slideBTN = findViewById(R.id.BTNslide)
        zoomBTN = findViewById(R.id.BTNzoom)
        stopBTN = findViewById(R.id.BTNstop)

        // Set up click listeners for each button to start corresponding animations
        createAnimation(blinkBTN, R.anim.blink_animation)
        createAnimation(rotateBTN, R.anim.rotate_animation)
        createAnimation(fadeBTN, R.anim.fade_animation)
        createAnimation(moveBTN, R.anim.move_animation)
        createAnimation(slideBTN, R.anim.slide_animation)

        createAnimationZoom(R.anim.zoom_animation)

        // Set up click listener for stop button to clear any ongoing animation
        stopBTN.setOnClickListener {
            imageView.clearAnimation()
            zoomBTN.clearAnimation()
        }
    }

    // Function to set up an animation for a given view and animation resource ID
    private fun createAnimation(view: View, animationResId: Int) {
        view.setOnClickListener {
            // Load the animation from the specified resource ID
            val animation = AnimationUtils.loadAnimation(this, animationResId)
            // Start the animation on the ImageView
            imageView.startAnimation(animation)
        }
    }

    private fun createAnimationZoom(animationZoomId: Int) {
        zoomBTN.setOnClickListener {
            // Load the animation from the specified resource ID
            val animation = AnimationUtils.loadAnimation(this, animationZoomId)
            // Start the animation on the ImageView
            zoomBTN.startAnimation(animation)
        }
    }
}