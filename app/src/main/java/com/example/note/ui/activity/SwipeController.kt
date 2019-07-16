package com.example.note.ui.activity

import android.graphics.Canvas
import android.graphics.RectF
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Gravity.LEFT
import android.view.Gravity.RIGHT
import android.widget.Button
import javax.security.auth.callback.Callback

enum class ButtonState{
    GONE,
    LEFT_VISIBLE,
    RIGHT_VISIBLE
}

class SwipeController : ItemTouchHelper.Callback{


    var swipeBack: Boolean = false
    var buttonShowedState : ButtonState = ButtonState.GONE
    var buttonInstance : RectF? = null
    var currentItemViewHolder : RecyclerView.ViewHolder? = null
    var buttonsActions : SwipeControllerActions
    val buttonWidth = 300

    constructor(buttonsActions: SwipeControllerActions){
        this.buttonsActions = buttonsActions
    }

    override fun getMovementFlags(p0: RecyclerView, p1: RecyclerView.ViewHolder): Int {
        return makeMovementFlags(0, LEFT or RIGHT)
    }

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
        if(swipeBack){
            swipeBack = buttonShowedState != ButtonState.GONE
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }
}