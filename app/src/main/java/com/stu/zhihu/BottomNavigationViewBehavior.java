package com.stu.zhihu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BottomNavigationViewBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {
    public BottomNavigationViewBehavior() {
    }

    public BottomNavigationViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * onInterceptTouchEvent()：是否拦截触摸事件
     *
     * onTouchEvent()：处理触摸事件
     *
     * layoutDependsOn()：确定使用Behavior的View要依赖的View的类型
     *
     * onDependentViewChanged()：当被依赖的View状态改变时回调
     *
     * onDependentViewRemoved()：当被依赖的View移除时回调
     *
     * onMeasureChild()：测量使用Behavior的View尺寸
     *
     * onLayoutChild()：确定使用Behavior的View位置
     *
     * onStartNestedScroll()：嵌套滑动开始（ACTION_DOWN），确定Behavior是否要监听此次事件
     *
     * onStopNestedScroll()：嵌套滑动结束（ACTION_UP或ACTION_CANCEL）
     *
     * onNestedScroll()：嵌套滑动进行中，要监听的子 View的滑动事件已经被消费
     *
     * onNestedPreScroll()：嵌套滑动进行中，要监听的子 View将要滑动，滑动事件即将被消费（但最终被谁消费，可以通过代码控制）
     *
     * onNestedFling()：要监听的子 View在快速滑动中
     *
     * onNestedPreFling()：要监听的子View即将快速滑动
     * */




    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, int layoutDirection) {
     //   ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin = parent.getMeasuredHeight() - child.getMeasuredHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    /**
     * 使用该Behavior的View要监听哪个类型的View的状态变化。
     * 其中参数parant代表CoordinatorLayout，child代表使用该Behavior的View，dependency代表要监听的View。
     * 这里要监听RecyclerView。
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, @NonNull View dependency) {
        return dependency instanceof RecyclerView;
        //因为Behavior只对CoordinatorLayout的直接子View生效，因此将依赖关系转移到RecyclerView
       // return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, @NonNull View dependency) {
        Log.i("xxxx",(dependency instanceof  RecyclerView)+"");
        Log.i("xxxx",(dependency.getY())+"");
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        RecyclerView recyclerView = (RecyclerView) directTargetChild;

        Log.i("xxxx",(recyclerView instanceof  RecyclerView)+"");
        Log.i("xxxx",(recyclerView.getScrollX())+"");
        Log.i("xxxx",axes+"   axes");
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
}
