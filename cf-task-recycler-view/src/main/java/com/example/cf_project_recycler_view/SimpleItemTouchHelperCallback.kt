package com.example.cf_project_recycler_view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class SimpleItemTouchHelperCallback(private val mAdapter: ItemTouchHelperAdapter, context: Context) : ItemTouchHelper.Callback() {
    private val completeIcon = ContextCompat.getDrawable(context, R.drawable.baseline_check_black_18)
    private val deleteIcon = ContextCompat.getDrawable(context, R.drawable.baseline_delete_black_18)
    private val intrinsicWidth = deleteIcon?.intrinsicWidth
    private val completeIconWidth = completeIcon?.intrinsicWidth
    private val completeIconHeight = deleteIcon?.intrinsicHeight
    private val RIGHT_SWIPE = 32
    private val LEFT_SWIPE = 16
    private val intrinsicHeight = deleteIcon?.intrinsicHeight
    private val backgroundRightSwipe = ColorDrawable()
    private val backgroundLeftSwipe = ColorDrawable()
    private val backgroundLeftSwipeColor = Color.parseColor("#f44336")
    private val backgroundRightSwipeColor = Color.parseColor("#5e9cea")
    private val clearPaint = Paint().apply { xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR) }

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder,
                        target: ViewHolder): Boolean {
        mAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    //TODO отследить в какую сторону был сделан свайп
    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        when (direction) {
            RIGHT_SWIPE -> mAdapter.onRightSwipe(viewHolder, viewHolder.adapterPosition)
            LEFT_SWIPE -> mAdapter.onLeftSwipe(viewHolder, viewHolder.adapterPosition)
        }
    }

    override fun onChildDraw(c: Canvas,
                             recyclerView: RecyclerView,
                             viewHolder: ViewHolder,
                             dX: Float,
                             dY: Float,
                             actionState: Int,
                             isCurrentlyActive: Boolean) {
        val itemView = viewHolder.itemView
        val itemHeight = itemView.bottom - itemView.top
        val isCanceled = dX == 0f && !isCurrentlyActive


        if (isCanceled) {
            clearCanvas(c, itemView.right + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            return
        }

        // Draw the red delete background
        backgroundLeftSwipe.color = backgroundLeftSwipeColor
        backgroundLeftSwipe.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        if (dX < 0) {
            backgroundLeftSwipe.draw(c)
        }
        //draw complete background
        backgroundRightSwipe.color = backgroundRightSwipeColor
        backgroundRightSwipe.setBounds(itemView.left + dX.toInt(), itemView.top, itemView.left, itemView.bottom)
        if (dX > 0) {
            backgroundRightSwipe.draw(c)
        }
        // Calculate position of delete icon
        val iconTop = itemView.top + (itemHeight - intrinsicHeight!!) / 2
        val iconMargin = (itemHeight - intrinsicHeight) / 2
        val iconLeft = itemView.right - iconMargin - intrinsicWidth!!
        val iconRight = itemView.right - iconMargin
        val iconBottom = iconTop + intrinsicHeight

        // Calculate position of complete icon
        val completeIconTop = itemView.top + (itemHeight - completeIconHeight!!) / 2
        val completeIconMargin = (itemHeight - completeIconHeight) / 2
        var completeIconLeft: Int?
        var completeIconRight: Int?
        completeIconLeft = itemView.left + completeIconMargin
        completeIconRight = itemView.left + completeIconMargin + completeIconWidth!!
        val completeIconBottom = completeIconTop + completeIconHeight

        // Draw the delete icon
        if (dX < 0) {
            deleteIcon?.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            deleteIcon?.draw(c)
        }

        if (dX > 0) {
            // Draw the complete icon
            completeIcon?.setBounds(completeIconLeft, completeIconTop, completeIconRight, completeIconBottom)
            completeIcon?.draw(c)
        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private fun clearCanvas(c: Canvas?, left: Float, top: Float, right: Float, bottom: Float) {
        c?.drawRect(left, top, right, bottom, clearPaint)
    }
}