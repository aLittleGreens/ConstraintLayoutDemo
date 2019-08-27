package com.example.constraintlayoutdemo

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.guidelines_layout.*
import kotlinx.android.synthetic.main.placeholder_layout.*


/**
 * 可以发现其中的
 * layout_constraintVertical_bias、layout_constraintHorizontal_bias、
 * layout_constraintDimensionRatio、
 * layout_constraintHorizontal_weight、 layout_constraintVertical_weight 属性，
 * 以及Guidelines 等都可以做屏幕适配
 */
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        button6.setOnClickListener {
//            Toast.makeText(MainActivity@ this, "asdas", Toast.LENGTH_SHORT).show()
//        }

/*        avatar.setOnClickListener {
            placeholder.setContentId(R.id.avatar)
            placeholder.setEmptyVisibility(View.GONE)
        }*/
        val set = ConstraintSet()
        button14.setOnClickListener {

            set.clone(this, R.layout.activity_main)//复制一份父布局的约束

//            设置组件之间的约束
            set.connect(R.id.button15, ConstraintSet.LEFT, R.id.button14, ConstraintSet.LEFT)
            set.connect(R.id.button15, ConstraintSet.RIGHT, R.id.button14, ConstraintSet.RIGHT)
            set.connect(R.id.button15, ConstraintSet.TOP, R.id.button14, ConstraintSet.BOTTOM)

//            set.centerHorizontally(R.id.button15, ConstraintSet.PARENT_ID) //设置btn水平剧中于父布局parent
//            设置btn的高度,宽度
            set.constrainHeight(R.id.button15, 100)
            set.constrainWidth(R.id.button15, 400)

            TransitionManager.beginDelayedTransition(constraintLayout)//设置一个动画
            set.applyTo(constraintLayout)//.最后一步 ,apply一下使设置生效
        }

    }
}
