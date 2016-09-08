package com.mycarhz.myhz.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycarhz.myhz.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/1.
 */
public class PullToRefreshListView extends ListView implements AbsListView.OnScrollListener {
    private int headerHeight;
    private int downY;
    private View header;

    private static final int PULL_TO_REFRESH = 1; //下拉刷新状态
    private static final int RELEASE_TO_REFRESH = 2; //释放刷新状态
    private static final int REFRESHING = 3;      //正在刷新状态
    private TextView tvTitle;
    private TextView tvTime;
    private ImageView ivArrow;
    private RotateAnimation upAnim;
    private RotateAnimation downAnim;
    private RotateAnimation loadingAnim;
    private OnPullToRefreshListener onPullToRefreshListener;


    public void setOnPullToRefreshListener(OnPullToRefreshListener onPullToRefreshListener) {
        this.onPullToRefreshListener = onPullToRefreshListener;
    }


    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addHeader(); //给ListView添加头
        addFooter(); //添加脚
    }

    //TODO 上拉加载更多
    private void addFooter() {
        footer = View.inflate(getContext(), R.layout.footer, null);
        footer.measure(0, 0);
        footerHeight = footer.getMeasuredHeight();
        footer.setPadding(0, -footerHeight, 0, 0);
        addFooterView(footer); //给ListView 装一个脚
        setOnScrollListener(this);
    }

    //TODO 添加隐藏头
    private void addHeader() {
        header = View.inflate(getContext(), R.layout.header, null);
        header.measure(0, 0); //测量控件
        headerHeight = header.getMeasuredHeight();
        header.setPadding(0, -headerHeight, 0, 0);
        addHeaderView(header); //向ListView添加一个头


        tvTitle = (TextView) header.findViewById(R.id.tv_header);
        tvTime = (TextView) header.findViewById(R.id.tv_time);
        ivArrow = (ImageView) header.findViewById(R.id.iv_arrow);

        ivLeft = (ImageView) header.findViewById(R.id.iv_left);
        ivRight = (ImageView) header.findViewById(R.id.iv_right);

        //向上动画
        upAnim = new RotateAnimation(0, 180,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f);
        upAnim.setDuration(300);
        upAnim.setFillAfter(true); //设置动画结束以后停在最后的地方

        //向下动画
        downAnim = new RotateAnimation(180, 0,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f);
        downAnim.setDuration(300);
        downAnim.setFillAfter(true); //设置动画结束以后停在最后的地方

        loadingAnim = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f);
        loadingAnim.setRepeatCount(RotateAnimation.INFINITE);
        loadingAnim.setRepeatMode(RotateAnimation.RESTART);
        loadingAnim.setInterpolator(new LinearInterpolator());
        loadingAnim.setDuration(300);//设置动画结束以后停在最后的地方

    }



    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();
                int dy = moveY - downY;
                downY = moveY;
                //Log.i("test", "dy:" + dy);
                int paddingTop = header.getPaddingTop();
                if(state != REFRESHING && //当前状态不等于正在刷新才可以拉
                        getFirstVisiblePosition() == 0 && // 判断到顶
                        (dy > 0 ||  //判断当前正在向下滑
                                paddingTop > -headerHeight)){  //向上滑并且头在显示
                    header.setPadding(0, paddingTop + dy, 0, 0); //重新设置 padding

                    if(paddingTop >= 0){ //向下拉的距离超过了头的高度
                        //进入释入刷新状态
                        setState(RELEASE_TO_REFRESH);
                    }else{  //向下拉的距离没有超过了头的高度
                        //进入下拉刷新
                        setState(PULL_TO_REFRESH);
                    }
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.i("test","藏起来");
                resetHeader();
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);  //ListView自已处理滚动方法
    }


    private int state = PULL_TO_REFRESH; //记录ListView的当前状态
    private ImageView ivLeft;
    private ImageView ivRight;
    private View footer;

    //设置ListView状态
    private void setState(int state) {
        if( this.state != state){
            if(state == RELEASE_TO_REFRESH){ //释入刷新
                tvTitle.setText("释放刷新");
                ivArrow.startAnimation(upAnim);
            }else if( state == PULL_TO_REFRESH){ //下拉刷新
                tvTitle.setText("下拉刷新");
                ivArrow.startAnimation(downAnim);
            }else if( state == REFRESHING ){ //正在刷新状态
                tvTitle.setText("正在刷新");
                tvTime.setText("最后刷新时间:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                ivArrow.clearAnimation();
                ivArrow.setVisibility(View.GONE);
                ivLeft.setVisibility(View.VISIBLE);
                ivRight.setVisibility(View.VISIBLE);
                ivLeft.startAnimation(loadingAnim);
                ivRight.startAnimation(loadingAnim);
            }
            this.state = state;
        }

    }
    public void setRefreshFinish(){
        ivLeft.clearAnimation();
        ivRight.clearAnimation();
        ivLeft.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        setState(PULL_TO_REFRESH);
        ivArrow.setVisibility(View.VISIBLE);
        header.setPadding(0, -headerHeight, 0, 0);
    }


    public void setLoadMoreFinish(){
        isLoading = false;
        footer.setPadding(0, -footerHeight, 0, 0);
    }

    //重置头
    private void resetHeader() {
        if(state == PULL_TO_REFRESH){ //手抬起的时候是下拉刷新
            header.setPadding(0, -headerHeight, 0, 0);
        }else if( state == RELEASE_TO_REFRESH){ //手抬起的时候是释放刷新，进入正在刷新
            header.setPadding(0, 0, 0, 0);
            setState(REFRESHING);

            //获取最新数据，执行刷新。
            if( onPullToRefreshListener != null){
                onPullToRefreshListener.onRefersh();
            }
        }
    }



    public interface OnPullToRefreshListener{
        public void onRefersh();
        public void onLoadMore();
    }


    private boolean isLoading = false; //表示当前ListView是否正在加载中
    private int footerHeight;


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int count = view.getAdapter().getCount();
        if(getLastVisiblePosition() == count - 1
                && scrollState == OnScrollListener.SCROLL_STATE_IDLE
                && isLoading == false){
            Log.i("test", "到底");
            footer.setPadding(0, 0, 0, 0);
            isLoading = true;
            setSelection(count-1);
            //加载下一页数据
            if( onPullToRefreshListener != null){
                onPullToRefreshListener.onLoadMore();
            }

        }
    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    /**
     * Integer.MAX_VALUE >> 2,如果不设置，系统默认设置是显示两条
     */
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//                MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//    }

}















